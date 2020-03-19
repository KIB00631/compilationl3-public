import sa.*;

public class Sa2ts extends SaDepthFirstVisitor<Void> {


    public Sa2ts(SaNode SaNode) {


        SaNode.accept(this);
    }

    @Override
    public Void visit(SaDecTab node) {
        return null;
    }

    @Override
    public Void visit(SaDecFonc node) {
        return null;
    }

    @Override
    public Void visit(SaDecVar node) {
        return null;
    }

    @Override
    public Void visit(SaVarSimple node) {
        return null;
    }

    @Override
    public Void visit(SaAppel node) {
        return null;
    }

    @Override
    public Void visit(SaVarIndicee node) {
        return null;
    }
}
