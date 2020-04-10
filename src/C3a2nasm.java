import c3a.*;
import nasm.*;
import ts.*;


public class C3a2nasm implements C3aVisitor<NasmOperand> {
    private C3a c3a;
    private Nasm nasm;
    private Ts tableGlobale;
    private TsItemFct tableCourante;

    public C3a2nasm(C3a c3a, Ts table){
        this.c3a = c3a;
        this.tableGlobale = table;
        this.nasm = new Nasm(tableGlobale);
        this.tableCourante = null;

        nasm.setTempCounter(c3a.getTempCounter());

        NasmRegister ebx = nasm.newRegister();
        NasmRegister eax = nasm.newRegister();
        ebx.colorRegister(Nasm.REG_EBX);
        eax.colorRegister(Nasm.REG_EAX);


        nasm.ajouteInst(new NasmCall(null, new NasmLabel("main"), ""));
        nasm.ajouteInst(new NasmMov(null, ebx, new NasmConstant(0), " valeur de retour du programme"));
        nasm.ajouteInst(new NasmMov(null, eax, new NasmConstant(1), ""));
        nasm.ajouteInst(new NasmInt(null, ""));

        c3a.listeInst.forEach(inst -> inst.accept(this));
    }

    public Nasm getNasm(){
        return this.nasm;
    }
    private NasmOperand getLabel(C3aInst  inst){
        return (inst.label != null) ? inst.label.accept(this) : null;
    }
    @Override
    public NasmOperand visit(C3aInstAdd inst) {
        NasmOperand label = this.getLabel(inst);
        NasmOperand oper1 = inst.op1.accept(this);
        NasmOperand oper2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);

        nasm.ajouteInst(new NasmMov(label, dest, oper1, ""));
        nasm.ajouteInst(new NasmAdd(null, dest, oper2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstCall inst) {
        NasmOperand res = inst.result.accept(this);
        NasmRegister esp = new NasmRegister(Nasm.REG_ESP);
        esp.colorRegister(Nasm.REG_ESP);

        nasm.ajouteInst(new NasmSub(this.getLabel(inst),esp,new NasmConstant(4),"allocation mémoire pour la valeur de retour"));
        nasm.ajouteInst(new NasmCall(null,new NasmLabel(inst.op1.val.identif),""));
        nasm.ajouteInst(new NasmPop(null, res,"récupération de la valeur de retour"));
        int nbArgs = inst.op1.val.getNbArgs();
        if (nbArgs > 0)
            nasm.ajouteInst(new NasmAdd(null,esp,new NasmConstant(nbArgs*4),"désallocation des arguments"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {
        tableCourante = inst.val;
        NasmOperand label = new NasmLabel(inst.val.identif);
        int nbVar = tableCourante.getTable().nbVar();
        NasmRegister ebp = new NasmRegister(Nasm.REG_EBP);
        NasmRegister esp = new NasmRegister(Nasm.REG_ESP);
        ebp.colorRegister(Nasm.REG_EBP);
        esp.colorRegister(Nasm.REG_ESP);

        nasm.ajouteInst(new NasmPush(label,ebp,"sauvegarde la valeur de ebp"));
        nasm.ajouteInst(new NasmMov(null,ebp,esp,"nouvelle valeur de ebp"));
        nasm.ajouteInst(new NasmSub(null,esp,new NasmConstant(nbVar*4),"allocation des variables locales"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfLess inst) {
        NasmOperand res = inst.result.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);

        nasm.ajouteInst(new NasmCmp(this.getLabel(inst),op1,op2,"JumpIfLess 1"));
        nasm.ajouteInst(new NasmJl(null,res,"JumpIfLess 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstMult inst) {
        NasmOperand label = this.getLabel(inst);
        NasmOperand oper1 = inst.op1.accept(this);
        NasmOperand oper2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);

        nasm.ajouteInst(new NasmMov(label, dest, oper1, ""));
        nasm.ajouteInst(new NasmMul(null, dest, oper2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {
        NasmOperand res = inst.result.accept(this);
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);

        nasm.ajouteInst(new NasmMov(this.getLabel(inst),eax,new NasmLabel("sinput"),""));
        nasm.ajouteInst(new NasmCall(null,new NasmLabel("readline"),""));
        nasm.ajouteInst(new NasmCall(null,new NasmLabel("atoi"),""));
        nasm.ajouteInst(new NasmMov(null,res,eax,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstSub inst) {
        NasmOperand label = this.getLabel(inst);
        NasmOperand oper1 = inst.op1.accept(this);
        NasmOperand oper2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);

        nasm.ajouteInst(new NasmMov(label, dest, oper1, ""));
        nasm.ajouteInst(new NasmSub(null, dest, oper2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand dest = inst.result.accept(this);

        nasm.ajouteInst(new NasmMov(this.getLabel(inst),dest,op1,"Affect"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstDiv inst) {
        NasmOperand label = this.getLabel(inst);
        NasmOperand oper1 = inst.op1.accept(this);
        NasmOperand oper2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);
        NasmRegister temp = nasm.newRegister();

        nasm.ajouteInst(new NasmMov(label, eax, oper1, ""));
        nasm.ajouteInst(new NasmMov(label, temp, oper2, ""));
        nasm.ajouteInst(new NasmDiv(null, temp, ""));
        nasm.ajouteInst(new NasmMov(label, dest, eax, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        NasmOperand label = this.getLabel(inst);
        NasmRegister ebp = new NasmRegister(Nasm.REG_EBP);
        NasmRegister esp = new NasmRegister(Nasm.REG_ESP);
        ebp.colorRegister(Nasm.REG_EBP);
        esp.colorRegister(Nasm.REG_ESP);
        int nbVar = tableCourante.getTable().nbVar();

        nasm.ajouteInst(new NasmAdd(label,esp,new NasmConstant(nbVar*4),"désallocation des variables locales"));
        nasm.ajouteInst(new NasmPop(null,ebp,"restaure la valeur de ebp"));
        nasm.ajouteInst(new NasmRet(null,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        NasmOperand dest = inst.result.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);

        nasm.ajouteInst(new NasmCmp(this.getLabel(inst),op1,op2,"JumpIfEqual 1"));
        nasm.ajouteInst(new NasmJe(null,dest,"JumpIfEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        NasmOperand dest = inst.result.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);

        nasm.ajouteInst(new NasmCmp(this.getLabel(inst),op1,op2,"jumpIfNotEqual 1"));
        nasm.ajouteInst(new NasmJne(null,dest,"jumpIfNotEqual 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {
        nasm.ajouteInst(new NasmJmp(this.getLabel(inst),inst.result.accept(this),"Jump"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstParam inst) {
        NasmOperand op1 = inst.op1.accept(this);
        nasm.ajouteInst(new NasmPush(this.getLabel(inst),op1,"Param"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstReturn inst) {
        NasmOperand op1 = inst.op1.accept(this);
        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(Nasm.REG_EBP);

        NasmAddress address = new NasmAddress(ebp,'+',new NasmConstant(2));
        nasm.ajouteInst(new NasmMov(this.getLabel(inst),address,op1,"ecriture de la valeur de retour"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);
        NasmOperand op1 = inst.op1.accept(this);

        nasm.ajouteInst(new NasmMov(this.getLabel(inst),eax,op1,"Write 1"));
        nasm.ajouteInst(new NasmCall(null,new NasmLabel("iprintLF"),"Write 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aConstant oper) {
        return new NasmConstant(oper.val);
    }

    @Override
    public NasmOperand visit(C3aLabel oper) {
        return new NasmLabel(oper.toString());
    }

    @Override
    public NasmOperand visit(C3aTemp oper) {
        return new NasmRegister(oper.num);
    }

    @Override
    public NasmOperand visit(C3aVar oper) {
        NasmAddress address;

        if(oper.index != null){
            NasmOperand op = oper.index.accept(this);
            address = new NasmAddress(new NasmLabel(oper.item.getIdentif()), '+', op);
            return address;
        }


        NasmRegister ebp = new NasmRegister(Nasm.REG_EBP);
        ebp.colorRegister(Nasm.REG_EBP);
        NasmConstant offset;
        if(oper.item.isParam){
            offset = new NasmConstant((tableCourante.getNbArgs() * 2) - oper.item.getAdresse());
            address = new NasmAddress(ebp, '+', offset);
        }
        else {
            if (tableCourante.getTable().getVar(oper.item.getIdentif()) != null){
                offset = new NasmConstant(oper.item.adresse + 1);
                address = new NasmAddress(ebp, '-', offset);
            }
            else
                address =  new NasmAddress(new NasmLabel(oper.item.getIdentif()), '+', null);
        }

        return address;
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {
        return new NasmLabel(oper.val.identif);
    }
}
