import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;


    public SaNode getRoot(){
        return this.returnValue;
    }

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
    public void caseABaseBase(ABaseBase node) {
        SaLDec decVar;
        node.getListedecvar().apply(this);
        decVar = (SaLDec) this.returnValue;
        this.returnValue = decVar;
    }

    @Override
    public void caseAVideBase(AVideBase node) {
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
        SaAppel appel;
        node.getInstrappel().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = appel;
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


    @Override
    public void caseAVideS2(AVideS2 node) {
        this.returnValue = null;
    }

    @Override
    public void caseAInstrappel(AInstrappel node) {
        SaAppel fct;
        node.getFct().apply(this);
        fct = (SaAppel) this.returnValue;

        this.returnValue = fct;
    }

    @Override
    public void caseAInstrretour(AInstrretour node) {
        SaExp exp;

        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;

        this.returnValue = new SaInstRetour(exp);
    }

    @Override
    public void caseAInstrecriture(AInstrecriture node) {
        SaExp exp;

        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;

        this.returnValue = new SaInstEcriture(exp);

    }

    @Override
    public void caseAInstrvide(AInstrvide node) {
        this.returnValue = null;
    }

    @Override
    public void caseAListedecvar(AListedecvar node) {
        SaLDec lVar;
        SaDec var;

        node.getListedecvar2().apply(this);
        lVar = (SaLDec) this.returnValue;
        node.getDecvar().apply(this);
        var = (SaDec) this.returnValue;

        this.returnValue = new SaLDec(var,lVar);
    }


    @Override
    public void caseAListedecvar2Listedecvar2(AListedecvar2Listedecvar2 node) {
        SaLDec lVar;
        SaDec var;

        node.getListedecvar2().apply(this);
        lVar = (SaLDec) this.returnValue;
        node.getDecvar().apply(this);
        var = (SaDec) this.returnValue;

        this.returnValue = new SaLDec(var,lVar);
    }

    @Override
    public void caseAVideListedecvar2(AVideListedecvar2 node) {
        this.returnValue = null;
    }

    @Override
    public void caseAVarDecvar(AVarDecvar node){
        String name;

        name = node.getIdentif().getText();

        this.returnValue = new SaDecVar(name) ;
    }

    @Override
    public void caseATabDecvar(ATabDecvar node){
        String name;
        int taille;

        name = node.getIdentif().getText();
        taille = Integer.parseInt(node.getNombre().getText());

        this.returnValue = new SaDecTab(name,taille);
    }


    @Override
    public void caseAAvecDecfonction(AAvecDecfonction node)
    {
        String name;
        SaLDec param;
        SaLDec lDecVar;
        SaInstBloc bloc;

        name = node.getIdentif().getText();

        node.getListedecvar().apply(this);
        param = (SaLDec) this.returnValue;

        node.getBase().apply(this);
        lDecVar = (SaLDec) this.returnValue;

        node.getInstrbloc().apply(this);
        bloc = (SaInstBloc) this.returnValue;

        this.returnValue = new SaDecFonc(name,param,lDecVar,bloc);

    }

    @Override
    public void caseASansDecfonction(ASansDecfonction node)
    {
        String name;
        SaLDec lDecVar;
        SaInstBloc bloc;

        name = node.getIdentif().getText();

        node.getBase().apply(this);
        lDecVar = (SaLDec) this.returnValue;

        node.getInstrbloc().apply(this);
        bloc = (SaInstBloc) this.returnValue;

        this.returnValue = new SaDecFonc(name,null,lDecVar,bloc);

    }


    @Override
    public void caseAInstrbloc(AInstrbloc node) {
        SaLInst lInstr;

        node.getB2().apply(this);
        lInstr = (SaLInst) this.returnValue;

        this.returnValue = new SaInstBloc(lInstr);
    }


    @Override
    public void caseAOuExp(AOuExp node) {
        SaExp exp1;
        SaExp exp2;

        node.getExp().apply(this);
        exp1 = (SaExp) this.returnValue;

        node.getExp2().apply(this);
        exp2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpOr(exp1,exp2);
    }


    @Override
    public void caseAExp2Exp(AExp2Exp node) {
        SaExp exp1;

        node.getExp2().apply(this);
        exp1 = (SaExp) this.returnValue;

        this.returnValue = exp1;
    }


    @Override
    public void caseAEtExp2(AEtExp2 node) {
        SaExp exp1;
        SaExp exp2;

        node.getExp2().apply(this);
        exp1 = (SaExp) this.returnValue;

        node.getExp3().apply(this);
        exp2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpAnd(exp1,exp2);
    }


    @Override
    public void caseAExp3Exp2(AExp3Exp2 node) {
        SaExp exp1;

        node.getExp3().apply(this);
        exp1 = (SaExp) this.returnValue;

        this.returnValue = exp1;
    }


    @Override
    public void caseAEgalExp3(AEgalExp3 node) {
        SaExp exp1;
        SaExp exp2;

        node.getExp3().apply(this);
        exp1 = (SaExp) this.returnValue;

        node.getExp4().apply(this);
        exp2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpEqual(exp1,exp2);
    }


    @Override
    public void caseAInferieurExp3(AInferieurExp3 node) {
        SaExp exp1;
        SaExp exp2;

        node.getExp3().apply(this);
        exp1 = (SaExp) this.returnValue;

        node.getExp4().apply(this);
        exp2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpInf(exp1,exp2);
    }


    @Override
    public void caseAExp4Exp3(AExp4Exp3 node) {
        SaExp exp1;

        node.getExp4().apply(this);
        exp1 = (SaExp) this.returnValue;

        this.returnValue = exp1;
    }


    @Override
    public void caseAPlusExp4(APlusExp4 node) {
        SaExp exp1;
        SaExp exp2;

        node.getExp4().apply(this);
        exp1 = (SaExp) this.returnValue;

        node.getExp5().apply(this);
        exp2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpAdd(exp1,exp2);
    }


    @Override
    public void caseAMoinsExp4(AMoinsExp4 node) {
        SaExp exp1;
        SaExp exp2;

        node.getExp4().apply(this);
        exp1 = (SaExp) this.returnValue;

        node.getExp5().apply(this);
        exp2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpSub(exp1,exp2);
    }


    @Override
    public void caseAExp5Exp4(AExp5Exp4 node) {
        SaExp exp1;

        node.getExp5().apply(this);
        exp1 = (SaExp) this.returnValue;

        this.returnValue = exp1;
    }


    @Override
    public void caseAFoisExp5(AFoisExp5 node) {
        SaExp exp1;
        SaExp exp2;

        node.getExp5().apply(this);
        exp1 = (SaExp) this.returnValue;

        node.getExp6().apply(this);
        exp2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpMult(exp1,exp2);
    }


    @Override
    public void caseADiviseExp5(ADiviseExp5 node) {
        SaExp exp1;
        SaExp exp2;

        node.getExp5().apply(this);
        exp1 = (SaExp) this.returnValue;

        node.getExp6().apply(this);
        exp2 = (SaExp) this.returnValue;

        this.returnValue = new SaExpDiv(exp1,exp2);
    }


    @Override
    public void caseAExp6Exp5(AExp6Exp5 node) {
        SaExp exp1;

        node.getExp6().apply(this);
        exp1 = (SaExp) this.returnValue;

        this.returnValue = exp1;
    }


    @Override
    public void caseANonExp6(ANonExp6 node) {
        SaExp exp1;

        node.getExp6().apply(this);
        exp1 = (SaExp) this.returnValue;

        this.returnValue = new SaExpNot(exp1);
    }


    @Override
    public void caseAExp7Exp6(AExp7Exp6 node) {
        SaExp exp1;

        node.getExp7().apply(this);
        exp1 = (SaExp) this.returnValue;


        this.returnValue = exp1;
    }


    @Override
    public void caseAParentheseExp7(AParentheseExp7 node) {
        SaExp exp;

        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;

        this.returnValue = exp;
    }


    @Override
    public void caseAFctExp7(AFctExp7 node) {
        SaAppel fct;

        node.getFct().apply(this);
        fct = (SaAppel) this.returnValue;

        this.returnValue = new SaExpAppel(fct);
    }


    @Override
    public void caseANombreExp7(ANombreExp7 node) {
        int nbr;

        nbr = Integer.parseInt(node.getNombre().getText());

        this.returnValue = new SaExpInt(nbr);
    }


    @Override
    public void caseAVarExp7(AVarExp7 node) {
        SaVar var;

        node.getVar().apply(this);
        var = (SaVar) this.returnValue;

        this.returnValue = new SaExpVar(var);
    }


    @Override
    public void caseALireExp7(ALireExp7 node) {
        this.returnValue = new SaExpLire();
    }


    @Override
    public void caseAFct(AFct node) {
        String identif;
        SaLExp param;

       identif = node.getIdentif().getText();
        node.getListeexp().apply(this);
        param = (SaLExp) this.returnValue;

        this.returnValue = new SaAppel(identif, param);
    }


    @Override
    public void caseAListeexpListeexp(AListeexpListeexp node) {
        SaExp exp;
        SaLExp lExp;

        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getExpbis().apply(this);
        lExp = (SaLExp) this.returnValue;

        this.returnValue = new SaLExp(exp, lExp);
    }


    @Override
    public void caseAVideListeexp(AVideListeexp node) {
        this.returnValue = null;
    }


    @Override
    public void caseAExpbisExpbis(AExpbisExpbis node) {
        SaExp exp;
        SaLExp lExp;

        node.getExp().apply(this);
        exp = (SaExp) this.returnValue;
        node.getExpbis().apply(this);
        lExp = (SaLExp) this.returnValue;

        this.returnValue = new SaLExp(exp, lExp);
    }


    @Override
    public void caseAVideExpbis(AVideExpbis node) {
        this.returnValue = null;
    }


    @Override
    public void caseAVarVar(AVarVar node) {
        String nom;

        nom = node.getIdentif().getText();

        returnValue = new SaVarSimple(nom);
    }


    @Override
    public void caseATabVar(ATabVar node) {
        String nom;
        SaExp taille;

        nom = node.getIdentif().getText();
        node.getExp().apply(this);
        taille = (SaExp) this.returnValue;

        returnValue = new SaVarIndicee(nom, taille);
    }
}