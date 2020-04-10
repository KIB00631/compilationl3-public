package fg;

import nasm.*;
import util.graph.Node;
import util.graph.NodeList;
import util.intset.IntSet;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FgSolution {
    public Nasm nasm;
    public Map<NasmInst, IntSet> use;
    public Map<NasmInst, IntSet> def;
    public Map<NasmInst, IntSet> in;
    public Map<NasmInst, IntSet> out;
    int iteration = 0;
    Fg fg;

    public FgSolution(Nasm nasm, Fg fg) {
        this.nasm = nasm;
        this.fg = fg;
        this.use = new HashMap<>();
        this.def = new HashMap<>();
        this.in = new HashMap<>();
        this.out = new HashMap<>();
        nasm.listeInst.forEach(this::put);
        parcourt();
    }

    private void put(NasmInst inst) {
        this.use.put(inst,new IntSet(nasm.getTempCounter()));
        this.def.put(inst,new IntSet(nasm.getTempCounter()));
        this.in.put(inst,new IntSet(nasm.getTempCounter()));
        this.out.put(inst,new IntSet(nasm.getTempCounter()));
        addDestination(inst.destination, inst);
        addSource(inst.source, inst);
    }

    private void addDestination(NasmOperand operand, NasmInst inst) {
        if(operand instanceof NasmRegister) {
            NasmRegister register = (NasmRegister) operand;
            if (register.isGeneralRegister()) {
                int val = register.val;
                if (inst.destDef)
                    this.def.get(inst).add(val);
                if (inst.destUse)
                    this.use.get(inst).add(val);
            }
        }
    }
    private void addSource(NasmOperand operand, NasmInst inst) {
        if(operand instanceof NasmRegister) {
            NasmRegister register = (NasmRegister) operand;
            if (register.isGeneralRegister()) {
                int val = register.val;
                if (inst.srcDef)
                    this.def.get(inst).add(val);
                if (inst.srcUse)
                    this.use.get(inst).add(val);
            }
        }
    }

    private void parcourt() {
        boolean asChanged = true;
        var nodes = fg.graph.nodeArray();
        while (asChanged) {
            asChanged = false;
            for (Node node : nodes) {
                NasmInst inst = fg.node2Inst.get(node);
                IntSet def = this.def.get(inst);
                IntSet inTemp = this.in.get(inst);
                IntSet outTemp = this.out.get(inst);
                IntSet use = this.use.get(inst);

                IntSet diff =  outTemp.copy().minus(def);
                this.in.replace(inst,diff.union(use));

                IntSet out = new IntSet(outTemp.getSize());
                this.out.put(inst,out);
                for (NodeList succ = node.succ(); succ != null; succ = succ.tail)
                    this.out.get(inst).union(this.in.get(fg.node2Inst.get(succ.head)));

                if ((!this.in.get(inst).equal(inTemp) || !this.out.get(inst).equal(outTemp))) {
                    asChanged = true;
                }
            }
            this.iteration++;
        }
    }


    public void affiche(String baseFileName) {
        String fileName;
        PrintStream out = System.out;

        if (baseFileName != null) {
            try {
                baseFileName = baseFileName;
                fileName = baseFileName + ".fgs";
                out = new PrintStream(fileName, StandardCharsets.UTF_8);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        out.println("iter num = " + iteration);
        for (NasmInst nasmInst : this.nasm.listeInst) {
            out.println("use = " + this.use.get(nasmInst) + " def = " + this.def.get(nasmInst) + "\tin = " + this.in.get(nasmInst) + "\t \tout = " + this.out.get(nasmInst) + "\t \t" + nasmInst);
        }
    }
}