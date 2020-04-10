import sa.*;
import ts.*;


public class Sa2ts extends SaDepthFirstVisitor<Void> {
    enum Scope {LOCAL, PARAM, GLOBAL}

    private Ts tableGlobale;
    private Ts tableCourante = null;
    private Scope scope;

    public Sa2ts(SaNode saRoot) {
        this.tableGlobale = new Ts();
        scope = Scope.GLOBAL;
        visit((SaProg) saRoot);
        this.mainExist();

    }


    public Ts getTableGlobale() {
        return tableGlobale;
    }

    private void mainExist(){
        if (tableGlobale.getFct("main") == null)
            throw new RuntimeException("Function main not found");
        if (tableGlobale.getFct("main").getNbArgs() != 0)
            throw new RuntimeException("Function main with argument");
    }
    @Override
    public Void visit(SaDecFonc node) {
        if (tableGlobale.getFct(node.getNom()) != null)
            throw new RuntimeException("Function " + node.getNom() + " ALREADY exists!");
        tableCourante = new Ts();
        scope = Scope.PARAM;
        if (node.getParametres() != null) node.getParametres().accept(this);
        scope = Scope.LOCAL;
        if (node.getVariable() != null) node.getVariable().accept(this);
        node.getCorps().accept(this);
        scope = Scope.GLOBAL;
        node.tsItem = tableGlobale.addFct(node.getNom(), tableCourante.nbArg(), tableCourante, node);
        return null;
    }

    @Override
    public Void visit(SaVarIndicee node) {
        TsItemVar indice;
        if (scope.equals(Scope.LOCAL)) {
            indice = tableCourante.getVar(node.getNom());
            if (indice == null) {
                indice = tableGlobale.getVar(node.getNom());
                if (indice == null)
                    throw new RuntimeException("Var " + node.getNom() + " NOT defined!");
            }
        } else {
            indice = tableGlobale.getVar(node.getNom());
            if (indice == null)
                throw new RuntimeException("Global var " + node.getNom() + " NOT defined!");
        }
        node.tsItem = indice;
        return null;
    }

    @Override
    public Void visit(SaDecTab node) {

        if (scope.equals(Scope.LOCAL)) {
            throw new RuntimeException("Local array");
        } else if (scope.equals(Scope.PARAM)) {
            throw new RuntimeException("Param array");
        } else if (scope.equals(Scope.GLOBAL)) {
            if (tableGlobale.getVar(node.getNom()) != null)
                throw new RuntimeException("Global Array " + node.getNom() + " ALREADY exists!");
            node.tsItem = tableGlobale.addVar(node.getNom(), node.getTaille());
        }
        return null;
    }

    @Override
    public Void visit(SaVarSimple node) {
        TsItemVar var;
        if (scope.equals(Scope.LOCAL)) {
            var = tableCourante.getVar(node.getNom());
            if (var == null) {
                var = tableGlobale.getVar(node.getNom());
                if (var == null)
                    throw new RuntimeException("Var " + node.getNom() + " NOT defined!");
            }
        } else {
            var = tableGlobale.getVar(node.getNom());
            if (var == null)
                throw new RuntimeException("Global var " + node.getNom() + " NOT defined!");
        }
        node.tsItem = var;
        if (node.tsItem.getTaille() > 1)
            throw new RuntimeException("Wrong call to indexed variable.");

        return null;
    }

    @Override
    public Void visit(SaDecVar node) {
        if (scope.equals(Scope.LOCAL)) {
            if (tableCourante.getVar(node.getNom()) != null)
                throw new RuntimeException("Var " + node.getNom() + " ALREADY exists!");
            node.tsItem = tableCourante.addVar(node.getNom(), 1);
        } else if (scope.equals(Scope.PARAM)) {
            if (tableCourante.getVar(node.getNom()) != null)
                throw new RuntimeException("Param " + node.getNom() + " ALREADY exists!");
            node.tsItem = tableCourante.addParam(node.getNom());
        } else if (scope.equals(Scope.GLOBAL)) {
            if (tableGlobale.getVar(node.getNom()) != null)
                throw new RuntimeException("Global var " + node.getNom() + " ALREADY exists!");
            node.tsItem = tableGlobale.addVar(node.getNom(), 1);
        }
        return null;
    }

    @Override
    public Void visit(SaAppel node) {
        TsItemFct fct = tableGlobale.getFct(node.getNom());
        if (fct == null)
            throw new RuntimeException("Function " + node.getNom() + " NOT defined!");
        node.tsItem = fct;
        if (node.getArguments() != null)
            node.getArguments().accept(this);
        if (node.getArguments() != null && node.tsItem.getNbArgs() != node.getArguments().length())
            throw new RuntimeException("Function " + node.getNom() + " Invalid number of arguments");
        return null;
    }

}
