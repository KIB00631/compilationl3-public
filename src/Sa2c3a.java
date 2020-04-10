import c3a.*;
import ts.*;
import sa.*;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {

    private C3a c3a;

    public Sa2c3a(SaNode root) {
        this.c3a = new C3a();
        root.accept(this);
    }

    public C3a getC3a() {
        return c3a;
    }

    @Override
    public C3aOperand visit(SaProg node) {
        node.getFonctions().accept(this);
        return null;
    }

    @Override
    public C3aOperand visit(SaExpInt node) {
        return new C3aConstant(node.getVal());
    }

    @Override
    public C3aOperand visit(SaExpVar node) {
        return node.getVar().accept(this);
    }

    @Override
    public C3aOperand visit(SaInstEcriture node) {
        c3a.ajouteInst(new C3aInstWrite(node.getArg().accept(this), ""));
        return null;
    }

    @Override
    public C3aOperand visit(SaInstTantQue node) {
        C3aLabel condition = c3a.newAutoLabel();
        C3aLabel fin = c3a.newAutoLabel();

        c3a.addLabelToNextInst(condition);
        c3a.ajouteInst(new C3aInstJumpIfEqual(node.getTest().accept(this), c3a.False, fin, ""));

        node.getFaire().accept(this);
        c3a.ajouteInst(new C3aInstJump(condition, ""));
        c3a.addLabelToNextInst(fin);
        return null;
    }


    @Override
    public C3aOperand visit(SaDecFonc node) {
        c3a.ajouteInst(new C3aInstFBegin(node.tsItem, "entree fonction"));
        if (node.getCorps() != null)
            node.getCorps().accept(this);
        c3a.ajouteInst(new C3aInstFEnd(""));
        return null;
    }

    @Override
    public C3aOperand visit(SaInstAffect node) {
        c3a.ajouteInst(new C3aInstAffect(node.getRhs().accept(this),node.getLhs().accept(this),""));
        return null;
    }

    @Override
    public C3aOperand visit(SaVarSimple node) {
        return new C3aVar(node.tsItem, null);
    }

    @Override
    public C3aOperand visit(SaAppel node) {
        if (node.getArguments() != null) {
            node.getArguments().accept(this);
        }
        C3aOperand temp = c3a.newTemp();
        C3aInstCall call = new C3aInstCall(new C3aFunction(node.tsItem), temp, "");
        c3a.ajouteInst(call);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpAppel node) {
        return node.getVal().accept(this);
    }

    @Override
    public C3aOperand visit(SaExpAdd node) {
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aTemp temp = c3a.newTemp();
        c3a.ajouteInst(new C3aInstAdd(op1, op2, temp, ""));
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpSub node) {
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aTemp temp = c3a.newTemp();
        c3a.ajouteInst(new C3aInstSub(op1, op2, temp, ""));
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpMult node) {
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aTemp temp = c3a.newTemp();
        c3a.ajouteInst(new C3aInstMult(op1, op2, temp, ""));
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpDiv node) {
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aTemp temp = c3a.newTemp();
        c3a.ajouteInst(new C3aInstDiv(op1, op2, temp, ""));
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpInf node) {
        C3aTemp temp = c3a.newTemp();
        C3aLabel l0 = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, temp, ""));
        c3a.ajouteInst(new C3aInstJumpIfLess(op1, op2, l0, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, temp, ""));
        c3a.addLabelToNextInst(l0);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpEqual node) {
        C3aTemp temp = c3a.newTemp();
        C3aLabel l0 = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, temp, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, op2, l0, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, temp, ""));
        c3a.addLabelToNextInst(l0);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpAnd node) {
        C3aTemp temp = c3a.newTemp();
        C3aLabel l0 = c3a.newAutoLabel();
        C3aLabel l1 = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, c3a.False, l1, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op2, c3a.False, l1, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.True, temp, ""));
        c3a.ajouteInst(new C3aInstJump(l0, ""));
        c3a.addLabelToNextInst(l1);
        c3a.ajouteInst(new C3aInstAffect(c3a.False, temp, ""));
        c3a.addLabelToNextInst(l0);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpOr node) {
        C3aTemp temp = c3a.newTemp();
        C3aLabel l0 = c3a.newAutoLabel();
        C3aLabel l1 = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op1, c3a.False, l1, ""));
        c3a.ajouteInst(new C3aInstJumpIfNotEqual(op2, c3a.False, l1, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, temp, ""));
        c3a.ajouteInst(new C3aInstJump(l0, ""));
        c3a.addLabelToNextInst(l1);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, temp, ""));
        c3a.addLabelToNextInst(l0);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpNot node) {
        C3aTemp temp = c3a.newTemp();
        C3aLabel l0 = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        c3a.ajouteInst(new C3aInstAffect(c3a.True, temp, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, c3a.False, l0, ""));
        c3a.ajouteInst(new C3aInstAffect(c3a.False, temp, ""));
        c3a.addLabelToNextInst(l0);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpLire node) {
        c3a.ajouteInst(new C3aInstRead(node.accept(this), ""));
        return null;
    }

    @Override
    public C3aOperand visit(SaInstSi node) {
        C3aLabel l0 = c3a.newAutoLabel();
        C3aLabel l1 = c3a.newAutoLabel();
        C3aOperand test = node.getTest().accept(this);
        if (node.getSinon() != null) {
            c3a.ajouteInst(new C3aInstJumpIfEqual(test, c3a.False, l0, ""));
        } else {
            c3a.ajouteInst(new C3aInstJumpIfEqual(test, c3a.False, l1, ""));
        }
        node.getAlors().accept(this);
        if (node.getSinon() != null) {
            c3a.ajouteInst(new C3aInstJump(l1, ""));
            c3a.addLabelToNextInst(l0);
            node.getSinon().accept(this);
        }
        c3a.addLabelToNextInst(l1);
        return null;
    }

    @Override
    public C3aOperand visit(SaInstRetour node) {
        c3a.ajouteInst(new C3aInstReturn(node.getVal().accept(this), ""));
        return null;
    }

    @Override
    public C3aOperand visit(SaLExp node) {
        c3a.ajouteInst(new C3aInstParam(node.getTete().accept(this), ""));
        if (node.getQueue() != null)
            node.getQueue().accept(this);
        return null;
    }

    @Override
    public C3aOperand visit(SaVarIndicee node) {
        TsItemVar tsItemVar = node.tsItem;
        if (node.tsItem == null) throw new RuntimeException("Error VarIndice Ca3");
        return new C3aVar(tsItemVar, node.getIndice().accept(this));
    }
}