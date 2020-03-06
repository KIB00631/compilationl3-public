import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;


    @Override
    public void caseStart(Start node) {
        super.caseStart(node);
    }


    @Override
    public void caseAProgramme(AProgramme node) {
        SaLDec base;
        SaLDec listFonction;

        node.getBase().apply(this);
        base = (SaLDec) this.returnValue;

        node.getListdecfonction().apply(this);
        listFonction = (SaLDec) this.returnValue;

        this.returnValue = new SaProg(base,listFonction);
    }

    @Override
    public void caseADecvarBase(ADecvarBase node) {
        SaLDec decVar;
        node.getDecvar().apply(this);
        decVar = (SaLDec) this.returnValue;
        this.returnValue = decVar;
    }

    @Override
    public void caseAVoidBase(AVoidBase node) {
        this.returnValue = null;
    }

    @Override
    public void caseADecfonctionboucleListdecfonction(ADecfonctionboucleListdecfonction node) {
        SaDec function;
        SaLDec listefunction;

        node.getDecfonction().apply(this);
        function = (SaDec) this.returnValue;

        node.getListdecfonction().apply(this);
        listefunction = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(function, listefunction);
    }

    @Override
    public void caseADecfonctionListdecfonction(ADecfonctionListdecfonction node) {
        node.getDecfonction().apply(this);
        this.returnValue = new SaLDec((SaDec) this.returnValue,null);
    }

    @Override
    public void caseADecvarInstr(ADecvarInstr node) {
        SaLDec decvar;
        node.getDecvar().apply(this);
        decvar = (SaLDec) this.returnValue;
        this.returnValue = decvar;
    }

    @Override
    public void caseAInstrtantqueInstr(AInstrtantqueInstr node) {
        SaInstTantQue tantQue;
        node.getInstrtantque().apply(this);
        tantQue = (SaInstTantQue) this.returnValue;
        this.returnValue = tantQue;
    }

    @Override
    public void caseAInstraffectInstr(AInstraffectInstr node) {
        SaInstAffect instAffect;
        node.getInstraffect().apply(this);
        instAffect = (SaInstAffect) this.returnValue;
        this.returnValue = instAffect;
    }

    @Override
    public void caseAInstrblocInstr(AInstrblocInstr node) {
        SaInstBloc bloc;
        node.getInstrbloc().apply(this);
        bloc = (SaInstBloc) this.returnValue;
        this.returnValue = bloc;
    }

    @Override
    public void caseAInstrsiInstr(AInstrsiInstr node) {
        SaInstSi instrSi;
        node.getInstrsi().apply(this);
        instrSi = (SaInstSi) this.returnValue;
        this.returnValue = instrSi;
    }

    @Override
    public void caseAInstrappelInstr(AInstrappelInstr node) {
        SaAppel instrSi;
        node.getInstrappel().apply(this);
        instrSi = (SaAppel) this.returnValue;
        this.returnValue = instrSi;
    }

    @Override
    public void caseAInstrretourInstr(AInstrretourInstr node) {
        SaInstRetour instrRet;
        node.getInstrretour().apply(this);
        instrRet = (SaInstRetour) this.returnValue;
        this.returnValue = instrRet;
    }

    @Override
    public void caseAInstrecritureInstr(AInstrecritureInstr node) {
        SaInstEcriture instrEcr;
        node.getInstrecriture().apply(this);
        instrEcr = (SaInstEcriture) this.returnValue;
        this.returnValue = instrEcr;
    }

    @Override
    public void caseAInstrvideInstr(AInstrvideInstr node) {
        this.returnValue = null;
    }

    @Override
    public void caseAInstrtantque(AInstrtantque node) {
        SaExp exp;
        SaInst instr;

        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;

        node.getInstrbloc().apply(this);
        instr = (SaInst) this.returnValue;

        this.returnValue = new SaInstTantQue(exp, instr);
    }

    @Override
    public void caseAInstraffect(AInstraffect node) {
        SaVar var;
        SaExp exp;

        node.getVar().apply(this);
        var = (SaVar) this.returnValue;

        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;

        this.returnValue = new SaInstAffect(var, exp);

    }

    @Override
    public void caseAListinstrB2(AListinstrB2 node) {
        SaInst instr;
        SaLInst b2;

        node.getInstr().apply(this);
        instr = (SaInst) this.returnValue;

        node.getB2().apply(this);
        b2 = (SaLInst) this.returnValue;

        this.returnValue = new SaLInst(instr,b2);
    }

    @Override
    public void caseAInstrfinB2(AInstrfinB2 node) {
        SaInst instr;

        node.getInstr().apply(this);
        instr = (SaInst) this.returnValue;

        this.returnValue = new SaLInst(instr,null);
    }

    @Override
    public void caseAInstrsi(AInstrsi node) {
        SaExp exp;
        SaInst bloc;
        SaInst s2;

        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;

        node.getInstrbloc().apply(this);
        bloc = (SaInst) this.returnValue;

        node.getS2().apply(this);
        s2 = (SaInst) this.returnValue;

        this.returnValue = new SaInstSi(exp, bloc, s2);
    }

    @Override
    public void caseASinonsiS2(ASinonsiS2 node) {
        SaInstSi bloc;
        node.getInstrsi().apply(this);
        bloc = (SaInstSi) this.returnValue;

        this.returnValue = bloc;
    }

    @Override
    public void caseASinonS2(ASinonS2 node) {
        SaInstBloc bloc;
        node.getInstrbloc().apply(this);
        bloc = (SaInstBloc) this.returnValue;

        this.returnValue = bloc;
    }


    //ici la mort continue

    @Override
    public void caseAVideS2(AVideS2 node) {
        inAVideS2(node);
        outAVideS2(node);
    }

    @Override
    public void caseAInstrappel(AInstrappel node) {
        inAInstrappel(node);
        if (node.getIdentif() != null) {
            node.getIdentif().apply(this);
        }
        if (node.getParentheseOuvrante() != null) {
            node.getParentheseOuvrante().apply(this);
        }
        if (node.getListeexp() != null) {
            node.getListeexp().apply(this);
        }
        if (node.getParentheseFermante() != null) {
            node.getParentheseFermante().apply(this);
        }
        if (node.getPointVirgule() != null) {
            node.getPointVirgule().apply(this);
        }
        outAInstrappel(node);
    }

    @Override
    public void caseAInstrretour(AInstrretour node) {
        inAInstrretour(node);
        if (node.getRetour() != null) {
            node.getRetour().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getPointVirgule() != null) {
            node.getPointVirgule().apply(this);
        }
        outAInstrretour(node);
    }

    @Override
    public void caseAInstrecriture(AInstrecriture node) {
        inAInstrecriture(node);
        if (node.getEcrire() != null) {
            node.getEcrire().apply(this);
        }
        if (node.getParentheseOuvrante() != null) {
            node.getParentheseOuvrante().apply(this);
        }
        if (node.getListeexp() != null) {
            node.getListeexp().apply(this);
        }
        if (node.getParentheseFermante() != null) {
            node.getParentheseFermante().apply(this);
        }
        if (node.getPointVirgule() != null) {
            node.getPointVirgule().apply(this);
        }
        outAInstrecriture(node);
    }

    @Override
    public void caseAInstrvide(AInstrvide node) {
        inAInstrvide(node);
        if (node.getPointVirgule() != null) {
            node.getPointVirgule().apply(this);
        }
        outAInstrvide(node);
    }


    @Override
    public void caseADecparamParam(ADecparamParam node)
    {
        inADecparamParam(node);
        if(node.getEntier() != null)
        {
            node.getEntier().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getParam2() != null)
        {
            node.getParam2().apply(this);
        }
        outADecparamParam(node);
    }


    @Override
    public void caseAVideParam(AVideParam node)
    {
        inAVideParam(node);
        outAVideParam(node);
    }

    @Override
    public void caseAParam2Param2(AParam2Param2 node)
    {
        inAParam2Param2(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getParam() != null)
        {
            node.getParam().apply(this);
        }
        outAParam2Param2(node);
    }


    @Override
    public void caseAVideParam2(AVideParam2 node)
    {
        inAVideParam2(node);
        outAVideParam2(node);
    }


    @Override
    public void caseADecvar(ADecvar node) {
        inADecvar(node);
        if (node.getEntier() != null) {
            node.getEntier().apply(this);
        }
        if (node.getVar() != null) {
            node.getVar().apply(this);
        }
        if (node.getDecvar2() != null) {
            node.getDecvar2().apply(this);
        }
        outADecvar(node);
    }


    @Override
    public void caseADecvar2Decvar2(ADecvar2Decvar2 node) {
        inADecvar2Decvar2(node);
        if (node.getPointVirgule() != null) {
            node.getPointVirgule().apply(this);
        }
        outADecvar2Decvar2(node);
    }


    @Override
    public void caseAListdecvarDecvar2(AListdecvarDecvar2 node) {
        inAListdecvarDecvar2(node);
        if (node.getVirgule() != null) {
            node.getVirgule().apply(this);
        }
        if (node.getDecvar() != null) {
            node.getDecvar().apply(this);
        }
        outAListdecvarDecvar2(node);
    }


    @Override
    public void caseADecfonction(ADecfonction node)
    {
        inADecfonction(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getParam() != null)
        {
            node.getParam().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        if(node.getDecfonction2() != null)
        {
            node.getDecfonction2().apply(this);
        }
        outADecfonction(node);
    }


        @Override
    public void caseAIntrblocDecfonction2(AIntrblocDecfonction2 node) {
        inAIntrblocDecfonction2(node);
        if (node.getInstrbloc() != null) {
            node.getInstrbloc().apply(this);
        }
        outAIntrblocDecfonction2(node);
    }


    @Override
    public void caseAListdecvarDecfonction2(AListdecvarDecfonction2 node) {
        inAListdecvarDecfonction2(node);
        if (node.getDecvar() != null) {
            node.getDecvar().apply(this);
        }
        if (node.getDecfonction2() != null) {
            node.getDecfonction2().apply(this);
        }
        outAListdecvarDecfonction2(node);
    }


    @Override
    public void caseAInstrbloc(AInstrbloc node) {
        inAInstrbloc(node);
        if (node.getAccoladeOuvrante() != null) {
            node.getAccoladeOuvrante().apply(this);
        }
        if (node.getB2() != null) {
            node.getB2().apply(this);
        }
        if (node.getAccoladeFermante() != null) {
            node.getAccoladeFermante().apply(this);
        }
        outAInstrbloc(node);
    }


    @Override
    public void caseAOuExp(AOuExp node) {
        inAOuExp(node);
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getOu() != null) {
            node.getOu().apply(this);
        }
        if (node.getExp2() != null) {
            node.getExp2().apply(this);
        }
        outAOuExp(node);
    }


    @Override
    public void caseAExp2Exp(AExp2Exp node) {
        inAExp2Exp(node);
        if (node.getExp2() != null) {
            node.getExp2().apply(this);
        }
        outAExp2Exp(node);
    }


    @Override
    public void caseAEtExp2(AEtExp2 node) {
        inAEtExp2(node);
        if (node.getExp2() != null) {
            node.getExp2().apply(this);
        }
        if (node.getEt() != null) {
            node.getEt().apply(this);
        }
        if (node.getExp3() != null) {
            node.getExp3().apply(this);
        }
        outAEtExp2(node);
    }


    @Override
    public void caseAExp3Exp2(AExp3Exp2 node) {
        inAExp3Exp2(node);
        if (node.getExp3() != null) {
            node.getExp3().apply(this);
        }
        outAExp3Exp2(node);
    }


    @Override
    public void caseAEgalExp3(AEgalExp3 node) {
        inAEgalExp3(node);
        if (node.getExp3() != null) {
            node.getExp3().apply(this);
        }
        if (node.getEgal() != null) {
            node.getEgal().apply(this);
        }
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
        }
        outAEgalExp3(node);
    }


    @Override
    public void caseAInferieurExp3(AInferieurExp3 node) {
        inAInferieurExp3(node);
        if (node.getExp3() != null) {
            node.getExp3().apply(this);
        }
        if (node.getInferieur() != null) {
            node.getInferieur().apply(this);
        }
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
        }
        outAInferieurExp3(node);
    }


    @Override
    public void caseAExp4Exp3(AExp4Exp3 node) {
        inAExp4Exp3(node);
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
        }
        outAExp4Exp3(node);
    }


    @Override
    public void caseAPlusExp4(APlusExp4 node) {
        inAPlusExp4(node);
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
        }
        if (node.getPlus() != null) {
            node.getPlus().apply(this);
        }
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
        }
        outAPlusExp4(node);
    }


    @Override
    public void caseAMoinsExp4(AMoinsExp4 node) {
        inAMoinsExp4(node);
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
        }
        if (node.getMoins() != null) {
            node.getMoins().apply(this);
        }
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
        }
        outAMoinsExp4(node);
    }


    @Override
    public void caseAExp5Exp4(AExp5Exp4 node) {
        inAExp5Exp4(node);
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
        }
        outAExp5Exp4(node);
    }


    @Override
    public void caseAFoisExp5(AFoisExp5 node) {
        inAFoisExp5(node);
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
        }
        if (node.getFois() != null) {
            node.getFois().apply(this);
        }
        if (node.getExp6() != null) {
            node.getExp6().apply(this);
        }
        outAFoisExp5(node);
    }


    @Override
    public void caseADiviseExp5(ADiviseExp5 node) {
        inADiviseExp5(node);
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
        }
        if (node.getDivise() != null) {
            node.getDivise().apply(this);
        }
        if (node.getExp6() != null) {
            node.getExp6().apply(this);
        }
        outADiviseExp5(node);
    }


    @Override
    public void caseAExp6Exp5(AExp6Exp5 node) {
        inAExp6Exp5(node);
        if (node.getExp6() != null) {
            node.getExp6().apply(this);
        }
        outAExp6Exp5(node);
    }


    @Override
    public void caseANonExp6(ANonExp6 node) {
        inANonExp6(node);
        if (node.getNon() != null) {
            node.getNon().apply(this);
        }
        if (node.getExp6() != null) {
            node.getExp6().apply(this);
        }
        outANonExp6(node);
    }


    @Override
    public void caseAExp7Exp6(AExp7Exp6 node) {
        inAExp7Exp6(node);
        if (node.getExp7() != null) {
            node.getExp7().apply(this);
        }
        outAExp7Exp6(node);
    }


    @Override
    public void caseAParentheseExp7(AParentheseExp7 node) {
        inAParentheseExp7(node);
        if (node.getParentheseOuvrante() != null) {
            node.getParentheseOuvrante().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getParentheseFermante() != null) {
            node.getParentheseFermante().apply(this);
        }
        outAParentheseExp7(node);
    }


    @Override
    public void caseAFctExp7(AFctExp7 node) {
        inAFctExp7(node);
        if (node.getFct() != null) {
            node.getFct().apply(this);
        }
        outAFctExp7(node);
    }


    @Override
    public void caseANombreExp7(ANombreExp7 node) {
        inANombreExp7(node);
        if (node.getNombre() != null) {
            node.getNombre().apply(this);
        }
        outANombreExp7(node);
    }


    @Override
    public void caseAVarExp7(AVarExp7 node) {
        inAVarExp7(node);
        if (node.getVar() != null) {
            node.getVar().apply(this);
        }
        outAVarExp7(node);
    }


    @Override
    public void caseALireExp7(ALireExp7 node) {
        inALireExp7(node);
        if (node.getLire() != null) {
            node.getLire().apply(this);
        }
        if (node.getParentheseOuvrante() != null) {
            node.getParentheseOuvrante().apply(this);
        }
        if (node.getParentheseFermante() != null) {
            node.getParentheseFermante().apply(this);
        }
        outALireExp7(node);
    }


    @Override
    public void caseAFct(AFct node) {
        inAFct(node);
        if (node.getIdentif() != null) {
            node.getIdentif().apply(this);
        }
        if (node.getParentheseOuvrante() != null) {
            node.getParentheseOuvrante().apply(this);
        }
        if (node.getListeexp() != null) {
            node.getListeexp().apply(this);
        }
        if (node.getParentheseFermante() != null) {
            node.getParentheseFermante().apply(this);
        }
        outAFct(node);
    }


    @Override
    public void caseAListeexpListeexp(AListeexpListeexp node) {
        inAListeexpListeexp(node);
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getExpbis() != null) {
            node.getExpbis().apply(this);
        }
        outAListeexpListeexp(node);
    }


    @Override
    public void caseAVideListeexp(AVideListeexp node) {
        inAVideListeexp(node);
        outAVideListeexp(node);
    }


    @Override
    public void caseAExpbisExpbis(AExpbisExpbis node) {
        inAExpbisExpbis(node);
        if (node.getVirgule() != null) {
            node.getVirgule().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getExpbis() != null) {
            node.getExpbis().apply(this);
        }
        outAExpbisExpbis(node);
    }


    @Override
    public void caseAVideExpbis(AVideExpbis node) {
        inAVideExpbis(node);
        outAVideExpbis(node);
    }


    @Override
    public void caseAVarVar(AVarVar node) {
        inAVarVar(node);
        if (node.getIdentif() != null) {
            node.getIdentif().apply(this);
        }
        outAVarVar(node);
    }


    @Override
    public void caseATabVar(ATabVar node) {
        inATabVar(node);
        if (node.getIdentif() != null) {
            node.getIdentif().apply(this);
        }
        if (node.getCrochetOuvrant() != null) {
            node.getCrochetOuvrant().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getCrochetFermant() != null) {
            node.getCrochetFermant().apply(this);
        }
        outATabVar(node);
    }
}