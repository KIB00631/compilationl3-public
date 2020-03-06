/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import sc.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgramme(AProgramme node);
    void caseADecvarBase(ADecvarBase node);
    void caseAVoidBase(AVoidBase node);
    void caseADecfonctionboucleListdecfonction(ADecfonctionboucleListdecfonction node);
    void caseADecfonctionListdecfonction(ADecfonctionListdecfonction node);
    void caseADecvarInstr(ADecvarInstr node);
    void caseAInstrtantqueInstr(AInstrtantqueInstr node);
    void caseAInstraffectInstr(AInstraffectInstr node);
    void caseAInstrblocInstr(AInstrblocInstr node);
    void caseAInstrsiInstr(AInstrsiInstr node);
    void caseAInstrappelInstr(AInstrappelInstr node);
    void caseAInstrretourInstr(AInstrretourInstr node);
    void caseAInstrecritureInstr(AInstrecritureInstr node);
    void caseAInstrvideInstr(AInstrvideInstr node);
    void caseAInstrtantque(AInstrtantque node);
    void caseAInstraffect(AInstraffect node);
    void caseAListinstrB2(AListinstrB2 node);
    void caseAInstrfinB2(AInstrfinB2 node);
    void caseAInstrsi(AInstrsi node);
    void caseASinonsiS2(ASinonsiS2 node);
    void caseASinonS2(ASinonS2 node);
    void caseAVideS2(AVideS2 node);
    void caseAInstrappel(AInstrappel node);
    void caseAInstrretour(AInstrretour node);
    void caseAInstrecriture(AInstrecriture node);
    void caseAInstrvide(AInstrvide node);
    void caseADecparamParam(ADecparamParam node);
    void caseAVideParam(AVideParam node);
    void caseAParam2Param2(AParam2Param2 node);
    void caseAVideParam2(AVideParam2 node);
    void caseADecvar(ADecvar node);
    void caseADecvar2Decvar2(ADecvar2Decvar2 node);
    void caseAListdecvarDecvar2(AListdecvarDecvar2 node);
    void caseADecfonction(ADecfonction node);
    void caseAIntrblocDecfonction2(AIntrblocDecfonction2 node);
    void caseAListdecvarDecfonction2(AListdecvarDecfonction2 node);
    void caseAInstrbloc(AInstrbloc node);
    void caseAOuExp(AOuExp node);
    void caseAExp2Exp(AExp2Exp node);
    void caseAEtExp2(AEtExp2 node);
    void caseAExp3Exp2(AExp3Exp2 node);
    void caseAEgalExp3(AEgalExp3 node);
    void caseAInferieurExp3(AInferieurExp3 node);
    void caseAExp4Exp3(AExp4Exp3 node);
    void caseAPlusExp4(APlusExp4 node);
    void caseAMoinsExp4(AMoinsExp4 node);
    void caseAExp5Exp4(AExp5Exp4 node);
    void caseAFoisExp5(AFoisExp5 node);
    void caseADiviseExp5(ADiviseExp5 node);
    void caseAExp6Exp5(AExp6Exp5 node);
    void caseANonExp6(ANonExp6 node);
    void caseAExp7Exp6(AExp7Exp6 node);
    void caseAParentheseExp7(AParentheseExp7 node);
    void caseAFctExp7(AFctExp7 node);
    void caseANombreExp7(ANombreExp7 node);
    void caseAVarExp7(AVarExp7 node);
    void caseALireExp7(ALireExp7 node);
    void caseAFct(AFct node);
    void caseAListeexpListeexp(AListeexpListeexp node);
    void caseAVideListeexp(AVideListeexp node);
    void caseAExpbisExpbis(AExpbisExpbis node);
    void caseAVideExpbis(AVideExpbis node);
    void caseAVarVar(AVarVar node);
    void caseATabVar(ATabVar node);

    void caseTEspaces(TEspaces node);
    void caseTCommentaire(TCommentaire node);
    void caseTSi(TSi node);
    void caseTAlors(TAlors node);
    void caseTSinon(TSinon node);
    void caseTFaire(TFaire node);
    void caseTEntier(TEntier node);
    void caseTRetour(TRetour node);
    void caseTLire(TLire node);
    void caseTEcrire(TEcrire node);
    void caseTPointVirgule(TPointVirgule node);
    void caseTPlus(TPlus node);
    void caseTMoins(TMoins node);
    void caseTFois(TFois node);
    void caseTDivise(TDivise node);
    void caseTParentheseOuvrante(TParentheseOuvrante node);
    void caseTParentheseFermante(TParentheseFermante node);
    void caseTCrochetOuvrant(TCrochetOuvrant node);
    void caseTCrochetFermant(TCrochetFermant node);
    void caseTAccoladeOuvrante(TAccoladeOuvrante node);
    void caseTAccoladeFermante(TAccoladeFermante node);
    void caseTEgal(TEgal node);
    void caseTTantque(TTantque node);
    void caseTInferieur(TInferieur node);
    void caseTEt(TEt node);
    void caseTOu(TOu node);
    void caseTNon(TNon node);
    void caseTVirgule(TVirgule node);
    void caseTNombre(TNombre node);
    void caseTIdentif(TIdentif node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
