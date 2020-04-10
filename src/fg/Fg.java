package fg;

import nasm.*;
import util.graph.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

public class Fg implements NasmVisitor<Void> {
    public Nasm nasm;
    public Graph graph;
    Map<NasmInst, Node> inst2Node;
    Map<Node, NasmInst> node2Inst;
    Map<String, NasmInst> label2Inst;

    public Fg(Nasm nasm) {
        this.nasm = nasm;
        this.inst2Node = new HashMap<>();
        this.node2Inst = new HashMap<>();
        this.label2Inst = new HashMap<>();
        this.graph = new Graph();
        nasm.listeInst.forEach(this::doNode);
        nasm.listeInst.forEach(inst -> inst.accept(this));

    }

    public void affiche(String baseFileName) {
        String fileName;
        PrintStream out = System.out;

        if (baseFileName != null) {
            try {
                baseFileName = baseFileName;
                fileName = baseFileName + ".fg";
                out = new PrintStream(fileName, StandardCharsets.UTF_8);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        for (NasmInst nasmInst : nasm.listeInst) {
            Node n = this.inst2Node.get(nasmInst);
            out.print(n + " : ( ");
            for (NodeList q = n.succ(); q != null; q = q.tail) {
                out.print(q.head.toString());
                out.print(" ");
            }
            out.println(")\t" + nasmInst);
        }
    }

    private void doNode(NasmInst inst){
        if (inst.label != null) {
            label2Inst.put(inst.label.toString(), inst);
        }
        Node node = graph.newNode();
        inst2Node.put(inst, node);
        node2Inst.put(node, inst);
    }

    private int getIndex (NasmInst inst){
        return this.nasm.listeInst.indexOf(inst);
    }
    private void addEdge(NasmInst inst){
        this.graph.addEdge(this.inst2Node.get(inst),this.inst2Node.get(nasm.listeInst.get(getIndex(inst) + 1)));
    }

    private void addLabelEdge(NasmInst inst, NasmOperand  label) {
        if (!label2Inst.containsKey(((NasmLabel)label).val)) return;
        graph.addEdge(inst2Node.get(inst), inst2Node.get(label2Inst.get(((NasmLabel)label).val)));
    }

    public Void visit(NasmAdd inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmCall inst) {
        addLabelEdge(inst,inst.address);
        return null;
    }

    public Void visit(NasmDiv inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmJe inst) {
        addLabelEdge(inst,inst.address);
        addEdge(inst);
        return null;
    }

    public Void visit(NasmJle inst) {
        addLabelEdge(inst,inst.address);
        addEdge(inst);
        return null;
    }

    public Void visit(NasmJne inst) {
        addLabelEdge(inst,inst.address);
        addEdge(inst);
        return null;
    }

    public Void visit(NasmMul inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmOr inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmCmp inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmInst inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmJge inst) {
        addLabelEdge(inst,inst.address);
        addEdge(inst);
        return null;
    }

    public Void visit(NasmJl inst) {
        addLabelEdge(inst,inst.address);
        addEdge(inst);
        return null;
    }

    public Void visit(NasmNot inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmPop inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmRet inst) {
        if (getIndex(inst)+1 < graph.nodeCount()) {
            addEdge(inst);
        }
        return null;
    }

    public Void visit(NasmXor inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmAnd inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmJg inst) {
        addLabelEdge(inst,inst.address);
        addEdge(inst);
        return null;
    }

    public Void visit(NasmJmp inst) {
        addLabelEdge(inst,inst.address);
        return null;
    }

    public Void visit(NasmMov inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmPush inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmSub inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmEmpty inst) {
        addEdge(inst);
        return null;
    }

    public Void visit(NasmAddress operand) {
        return null;
    }

    public Void visit(NasmConstant operand) {
        return null;
    }

    public Void visit(NasmLabel operand) {
        return null;
    }

    public Void visit(NasmRegister operand) {
        return null;
    }


}
