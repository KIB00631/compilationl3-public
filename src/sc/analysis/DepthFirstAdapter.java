/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import java.util.*;
import sc.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPProgramme().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAProgramme(AProgramme node)
    {
        defaultIn(node);
    }

    public void outAProgramme(AProgramme node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAProgramme(AProgramme node)
    {
        inAProgramme(node);
        if(node.getBase() != null)
        {
            node.getBase().apply(this);
        }
        if(node.getListdecfonction() != null)
        {
            node.getListdecfonction().apply(this);
        }
        outAProgramme(node);
    }

    public void inADecvarBase(ADecvarBase node)
    {
        defaultIn(node);
    }

    public void outADecvarBase(ADecvarBase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvarBase(ADecvarBase node)
    {
        inADecvarBase(node);
        if(node.getDecvar() != null)
        {
            node.getDecvar().apply(this);
        }
        outADecvarBase(node);
    }

    public void inAVoidBase(AVoidBase node)
    {
        defaultIn(node);
    }

    public void outAVoidBase(AVoidBase node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVoidBase(AVoidBase node)
    {
        inAVoidBase(node);
        outAVoidBase(node);
    }

    public void inADecfonctionboucleListdecfonction(ADecfonctionboucleListdecfonction node)
    {
        defaultIn(node);
    }

    public void outADecfonctionboucleListdecfonction(ADecfonctionboucleListdecfonction node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecfonctionboucleListdecfonction(ADecfonctionboucleListdecfonction node)
    {
        inADecfonctionboucleListdecfonction(node);
        if(node.getDecfonction() != null)
        {
            node.getDecfonction().apply(this);
        }
        if(node.getListdecfonction() != null)
        {
            node.getListdecfonction().apply(this);
        }
        outADecfonctionboucleListdecfonction(node);
    }

    public void inADecfonctionListdecfonction(ADecfonctionListdecfonction node)
    {
        defaultIn(node);
    }

    public void outADecfonctionListdecfonction(ADecfonctionListdecfonction node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecfonctionListdecfonction(ADecfonctionListdecfonction node)
    {
        inADecfonctionListdecfonction(node);
        if(node.getDecfonction() != null)
        {
            node.getDecfonction().apply(this);
        }
        outADecfonctionListdecfonction(node);
    }

    public void inADecvarInstr(ADecvarInstr node)
    {
        defaultIn(node);
    }

    public void outADecvarInstr(ADecvarInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvarInstr(ADecvarInstr node)
    {
        inADecvarInstr(node);
        if(node.getDecvar() != null)
        {
            node.getDecvar().apply(this);
        }
        outADecvarInstr(node);
    }

    public void inAInstrtantqueInstr(AInstrtantqueInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrtantqueInstr(AInstrtantqueInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrtantqueInstr(AInstrtantqueInstr node)
    {
        inAInstrtantqueInstr(node);
        if(node.getInstrtantque() != null)
        {
            node.getInstrtantque().apply(this);
        }
        outAInstrtantqueInstr(node);
    }

    public void inAInstraffectInstr(AInstraffectInstr node)
    {
        defaultIn(node);
    }

    public void outAInstraffectInstr(AInstraffectInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstraffectInstr(AInstraffectInstr node)
    {
        inAInstraffectInstr(node);
        if(node.getInstraffect() != null)
        {
            node.getInstraffect().apply(this);
        }
        outAInstraffectInstr(node);
    }

    public void inAInstrblocInstr(AInstrblocInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrblocInstr(AInstrblocInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrblocInstr(AInstrblocInstr node)
    {
        inAInstrblocInstr(node);
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outAInstrblocInstr(node);
    }

    public void inAInstrsiInstr(AInstrsiInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrsiInstr(AInstrsiInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrsiInstr(AInstrsiInstr node)
    {
        inAInstrsiInstr(node);
        if(node.getInstrsi() != null)
        {
            node.getInstrsi().apply(this);
        }
        outAInstrsiInstr(node);
    }

    public void inAInstrappelInstr(AInstrappelInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrappelInstr(AInstrappelInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrappelInstr(AInstrappelInstr node)
    {
        inAInstrappelInstr(node);
        if(node.getInstrappel() != null)
        {
            node.getInstrappel().apply(this);
        }
        outAInstrappelInstr(node);
    }

    public void inAInstrretourInstr(AInstrretourInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrretourInstr(AInstrretourInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrretourInstr(AInstrretourInstr node)
    {
        inAInstrretourInstr(node);
        if(node.getInstrretour() != null)
        {
            node.getInstrretour().apply(this);
        }
        outAInstrretourInstr(node);
    }

    public void inAInstrecritureInstr(AInstrecritureInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrecritureInstr(AInstrecritureInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrecritureInstr(AInstrecritureInstr node)
    {
        inAInstrecritureInstr(node);
        if(node.getInstrecriture() != null)
        {
            node.getInstrecriture().apply(this);
        }
        outAInstrecritureInstr(node);
    }

    public void inAInstrvideInstr(AInstrvideInstr node)
    {
        defaultIn(node);
    }

    public void outAInstrvideInstr(AInstrvideInstr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrvideInstr(AInstrvideInstr node)
    {
        inAInstrvideInstr(node);
        if(node.getInstrvide() != null)
        {
            node.getInstrvide().apply(this);
        }
        outAInstrvideInstr(node);
    }

    public void inAInstrtantque(AInstrtantque node)
    {
        defaultIn(node);
    }

    public void outAInstrtantque(AInstrtantque node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrtantque(AInstrtantque node)
    {
        inAInstrtantque(node);
        if(node.getTantque() != null)
        {
            node.getTantque().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getFaire() != null)
        {
            node.getFaire().apply(this);
        }
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outAInstrtantque(node);
    }

    public void inAInstraffect(AInstraffect node)
    {
        defaultIn(node);
    }

    public void outAInstraffect(AInstraffect node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstraffect(AInstraffect node)
    {
        inAInstraffect(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getEgal() != null)
        {
            node.getEgal().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstraffect(node);
    }

    public void inAListinstrB2(AListinstrB2 node)
    {
        defaultIn(node);
    }

    public void outAListinstrB2(AListinstrB2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListinstrB2(AListinstrB2 node)
    {
        inAListinstrB2(node);
        if(node.getInstr() != null)
        {
            node.getInstr().apply(this);
        }
        if(node.getB2() != null)
        {
            node.getB2().apply(this);
        }
        outAListinstrB2(node);
    }

    public void inAInstrfinB2(AInstrfinB2 node)
    {
        defaultIn(node);
    }

    public void outAInstrfinB2(AInstrfinB2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrfinB2(AInstrfinB2 node)
    {
        inAInstrfinB2(node);
        if(node.getInstr() != null)
        {
            node.getInstr().apply(this);
        }
        outAInstrfinB2(node);
    }

    public void inAInstrsi(AInstrsi node)
    {
        defaultIn(node);
    }

    public void outAInstrsi(AInstrsi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrsi(AInstrsi node)
    {
        inAInstrsi(node);
        if(node.getSi() != null)
        {
            node.getSi().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getAlors() != null)
        {
            node.getAlors().apply(this);
        }
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        if(node.getS2() != null)
        {
            node.getS2().apply(this);
        }
        outAInstrsi(node);
    }

    public void inASinonsiS2(ASinonsiS2 node)
    {
        defaultIn(node);
    }

    public void outASinonsiS2(ASinonsiS2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASinonsiS2(ASinonsiS2 node)
    {
        inASinonsiS2(node);
        if(node.getSinon() != null)
        {
            node.getSinon().apply(this);
        }
        if(node.getInstrsi() != null)
        {
            node.getInstrsi().apply(this);
        }
        outASinonsiS2(node);
    }

    public void inASinonS2(ASinonS2 node)
    {
        defaultIn(node);
    }

    public void outASinonS2(ASinonS2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASinonS2(ASinonS2 node)
    {
        inASinonS2(node);
        if(node.getSinon() != null)
        {
            node.getSinon().apply(this);
        }
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outASinonS2(node);
    }

    public void inAVideS2(AVideS2 node)
    {
        defaultIn(node);
    }

    public void outAVideS2(AVideS2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideS2(AVideS2 node)
    {
        inAVideS2(node);
        outAVideS2(node);
    }

    public void inAInstrappel(AInstrappel node)
    {
        defaultIn(node);
    }

    public void outAInstrappel(AInstrappel node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrappel(AInstrappel node)
    {
        inAInstrappel(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getListeexp() != null)
        {
            node.getListeexp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstrappel(node);
    }

    public void inAInstrretour(AInstrretour node)
    {
        defaultIn(node);
    }

    public void outAInstrretour(AInstrretour node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrretour(AInstrretour node)
    {
        inAInstrretour(node);
        if(node.getRetour() != null)
        {
            node.getRetour().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstrretour(node);
    }

    public void inAInstrecriture(AInstrecriture node)
    {
        defaultIn(node);
    }

    public void outAInstrecriture(AInstrecriture node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrecriture(AInstrecriture node)
    {
        inAInstrecriture(node);
        if(node.getEcrire() != null)
        {
            node.getEcrire().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getListeexp() != null)
        {
            node.getListeexp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstrecriture(node);
    }

    public void inAInstrvide(AInstrvide node)
    {
        defaultIn(node);
    }

    public void outAInstrvide(AInstrvide node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrvide(AInstrvide node)
    {
        inAInstrvide(node);
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstrvide(node);
    }

    public void inADecparamParam(ADecparamParam node)
    {
        defaultIn(node);
    }

    public void outADecparamParam(ADecparamParam node)
    {
        defaultOut(node);
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

    public void inAVideParam(AVideParam node)
    {
        defaultIn(node);
    }

    public void outAVideParam(AVideParam node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideParam(AVideParam node)
    {
        inAVideParam(node);
        outAVideParam(node);
    }

    public void inAParam2Param2(AParam2Param2 node)
    {
        defaultIn(node);
    }

    public void outAParam2Param2(AParam2Param2 node)
    {
        defaultOut(node);
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

    public void inAVideParam2(AVideParam2 node)
    {
        defaultIn(node);
    }

    public void outAVideParam2(AVideParam2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideParam2(AVideParam2 node)
    {
        inAVideParam2(node);
        outAVideParam2(node);
    }

    public void inADecvar(ADecvar node)
    {
        defaultIn(node);
    }

    public void outADecvar(ADecvar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvar(ADecvar node)
    {
        inADecvar(node);
        if(node.getEntier() != null)
        {
            node.getEntier().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getDecvar2() != null)
        {
            node.getDecvar2().apply(this);
        }
        outADecvar(node);
    }

    public void inADecvar2Decvar2(ADecvar2Decvar2 node)
    {
        defaultIn(node);
    }

    public void outADecvar2Decvar2(ADecvar2Decvar2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADecvar2Decvar2(ADecvar2Decvar2 node)
    {
        inADecvar2Decvar2(node);
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outADecvar2Decvar2(node);
    }

    public void inAListdecvarDecvar2(AListdecvarDecvar2 node)
    {
        defaultIn(node);
    }

    public void outAListdecvarDecvar2(AListdecvarDecvar2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListdecvarDecvar2(AListdecvarDecvar2 node)
    {
        inAListdecvarDecvar2(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getDecvar() != null)
        {
            node.getDecvar().apply(this);
        }
        outAListdecvarDecvar2(node);
    }

    public void inADecfonction(ADecfonction node)
    {
        defaultIn(node);
    }

    public void outADecfonction(ADecfonction node)
    {
        defaultOut(node);
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

    public void inAIntrblocDecfonction2(AIntrblocDecfonction2 node)
    {
        defaultIn(node);
    }

    public void outAIntrblocDecfonction2(AIntrblocDecfonction2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntrblocDecfonction2(AIntrblocDecfonction2 node)
    {
        inAIntrblocDecfonction2(node);
        if(node.getInstrbloc() != null)
        {
            node.getInstrbloc().apply(this);
        }
        outAIntrblocDecfonction2(node);
    }

    public void inAListdecvarDecfonction2(AListdecvarDecfonction2 node)
    {
        defaultIn(node);
    }

    public void outAListdecvarDecfonction2(AListdecvarDecfonction2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListdecvarDecfonction2(AListdecvarDecfonction2 node)
    {
        inAListdecvarDecfonction2(node);
        if(node.getDecvar() != null)
        {
            node.getDecvar().apply(this);
        }
        if(node.getDecfonction2() != null)
        {
            node.getDecfonction2().apply(this);
        }
        outAListdecvarDecfonction2(node);
    }

    public void inAInstrbloc(AInstrbloc node)
    {
        defaultIn(node);
    }

    public void outAInstrbloc(AInstrbloc node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstrbloc(AInstrbloc node)
    {
        inAInstrbloc(node);
        if(node.getAccoladeOuvrante() != null)
        {
            node.getAccoladeOuvrante().apply(this);
        }
        if(node.getB2() != null)
        {
            node.getB2().apply(this);
        }
        if(node.getAccoladeFermante() != null)
        {
            node.getAccoladeFermante().apply(this);
        }
        outAInstrbloc(node);
    }

    public void inAOuExp(AOuExp node)
    {
        defaultIn(node);
    }

    public void outAOuExp(AOuExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOuExp(AOuExp node)
    {
        inAOuExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getOu() != null)
        {
            node.getOu().apply(this);
        }
        if(node.getExp2() != null)
        {
            node.getExp2().apply(this);
        }
        outAOuExp(node);
    }

    public void inAExp2Exp(AExp2Exp node)
    {
        defaultIn(node);
    }

    public void outAExp2Exp(AExp2Exp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp2Exp(AExp2Exp node)
    {
        inAExp2Exp(node);
        if(node.getExp2() != null)
        {
            node.getExp2().apply(this);
        }
        outAExp2Exp(node);
    }

    public void inAEtExp2(AEtExp2 node)
    {
        defaultIn(node);
    }

    public void outAEtExp2(AEtExp2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEtExp2(AEtExp2 node)
    {
        inAEtExp2(node);
        if(node.getExp2() != null)
        {
            node.getExp2().apply(this);
        }
        if(node.getEt() != null)
        {
            node.getEt().apply(this);
        }
        if(node.getExp3() != null)
        {
            node.getExp3().apply(this);
        }
        outAEtExp2(node);
    }

    public void inAExp3Exp2(AExp3Exp2 node)
    {
        defaultIn(node);
    }

    public void outAExp3Exp2(AExp3Exp2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp3Exp2(AExp3Exp2 node)
    {
        inAExp3Exp2(node);
        if(node.getExp3() != null)
        {
            node.getExp3().apply(this);
        }
        outAExp3Exp2(node);
    }

    public void inAEgalExp3(AEgalExp3 node)
    {
        defaultIn(node);
    }

    public void outAEgalExp3(AEgalExp3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEgalExp3(AEgalExp3 node)
    {
        inAEgalExp3(node);
        if(node.getExp3() != null)
        {
            node.getExp3().apply(this);
        }
        if(node.getEgal() != null)
        {
            node.getEgal().apply(this);
        }
        if(node.getExp4() != null)
        {
            node.getExp4().apply(this);
        }
        outAEgalExp3(node);
    }

    public void inAInferieurExp3(AInferieurExp3 node)
    {
        defaultIn(node);
    }

    public void outAInferieurExp3(AInferieurExp3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInferieurExp3(AInferieurExp3 node)
    {
        inAInferieurExp3(node);
        if(node.getExp3() != null)
        {
            node.getExp3().apply(this);
        }
        if(node.getInferieur() != null)
        {
            node.getInferieur().apply(this);
        }
        if(node.getExp4() != null)
        {
            node.getExp4().apply(this);
        }
        outAInferieurExp3(node);
    }

    public void inAExp4Exp3(AExp4Exp3 node)
    {
        defaultIn(node);
    }

    public void outAExp4Exp3(AExp4Exp3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp4Exp3(AExp4Exp3 node)
    {
        inAExp4Exp3(node);
        if(node.getExp4() != null)
        {
            node.getExp4().apply(this);
        }
        outAExp4Exp3(node);
    }

    public void inAPlusExp4(APlusExp4 node)
    {
        defaultIn(node);
    }

    public void outAPlusExp4(APlusExp4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusExp4(APlusExp4 node)
    {
        inAPlusExp4(node);
        if(node.getExp4() != null)
        {
            node.getExp4().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getExp5() != null)
        {
            node.getExp5().apply(this);
        }
        outAPlusExp4(node);
    }

    public void inAMoinsExp4(AMoinsExp4 node)
    {
        defaultIn(node);
    }

    public void outAMoinsExp4(AMoinsExp4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMoinsExp4(AMoinsExp4 node)
    {
        inAMoinsExp4(node);
        if(node.getExp4() != null)
        {
            node.getExp4().apply(this);
        }
        if(node.getMoins() != null)
        {
            node.getMoins().apply(this);
        }
        if(node.getExp5() != null)
        {
            node.getExp5().apply(this);
        }
        outAMoinsExp4(node);
    }

    public void inAExp5Exp4(AExp5Exp4 node)
    {
        defaultIn(node);
    }

    public void outAExp5Exp4(AExp5Exp4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp5Exp4(AExp5Exp4 node)
    {
        inAExp5Exp4(node);
        if(node.getExp5() != null)
        {
            node.getExp5().apply(this);
        }
        outAExp5Exp4(node);
    }

    public void inAFoisExp5(AFoisExp5 node)
    {
        defaultIn(node);
    }

    public void outAFoisExp5(AFoisExp5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFoisExp5(AFoisExp5 node)
    {
        inAFoisExp5(node);
        if(node.getExp5() != null)
        {
            node.getExp5().apply(this);
        }
        if(node.getFois() != null)
        {
            node.getFois().apply(this);
        }
        if(node.getExp6() != null)
        {
            node.getExp6().apply(this);
        }
        outAFoisExp5(node);
    }

    public void inADiviseExp5(ADiviseExp5 node)
    {
        defaultIn(node);
    }

    public void outADiviseExp5(ADiviseExp5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADiviseExp5(ADiviseExp5 node)
    {
        inADiviseExp5(node);
        if(node.getExp5() != null)
        {
            node.getExp5().apply(this);
        }
        if(node.getDivise() != null)
        {
            node.getDivise().apply(this);
        }
        if(node.getExp6() != null)
        {
            node.getExp6().apply(this);
        }
        outADiviseExp5(node);
    }

    public void inAExp6Exp5(AExp6Exp5 node)
    {
        defaultIn(node);
    }

    public void outAExp6Exp5(AExp6Exp5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp6Exp5(AExp6Exp5 node)
    {
        inAExp6Exp5(node);
        if(node.getExp6() != null)
        {
            node.getExp6().apply(this);
        }
        outAExp6Exp5(node);
    }

    public void inANonExp6(ANonExp6 node)
    {
        defaultIn(node);
    }

    public void outANonExp6(ANonExp6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANonExp6(ANonExp6 node)
    {
        inANonExp6(node);
        if(node.getNon() != null)
        {
            node.getNon().apply(this);
        }
        if(node.getExp6() != null)
        {
            node.getExp6().apply(this);
        }
        outANonExp6(node);
    }

    public void inAExp7Exp6(AExp7Exp6 node)
    {
        defaultIn(node);
    }

    public void outAExp7Exp6(AExp7Exp6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExp7Exp6(AExp7Exp6 node)
    {
        inAExp7Exp6(node);
        if(node.getExp7() != null)
        {
            node.getExp7().apply(this);
        }
        outAExp7Exp6(node);
    }

    public void inAParentheseExp7(AParentheseExp7 node)
    {
        defaultIn(node);
    }

    public void outAParentheseExp7(AParentheseExp7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParentheseExp7(AParentheseExp7 node)
    {
        inAParentheseExp7(node);
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outAParentheseExp7(node);
    }

    public void inAFctExp7(AFctExp7 node)
    {
        defaultIn(node);
    }

    public void outAFctExp7(AFctExp7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFctExp7(AFctExp7 node)
    {
        inAFctExp7(node);
        if(node.getFct() != null)
        {
            node.getFct().apply(this);
        }
        outAFctExp7(node);
    }

    public void inANombreExp7(ANombreExp7 node)
    {
        defaultIn(node);
    }

    public void outANombreExp7(ANombreExp7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANombreExp7(ANombreExp7 node)
    {
        inANombreExp7(node);
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        outANombreExp7(node);
    }

    public void inAVarExp7(AVarExp7 node)
    {
        defaultIn(node);
    }

    public void outAVarExp7(AVarExp7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarExp7(AVarExp7 node)
    {
        inAVarExp7(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVarExp7(node);
    }

    public void inALireExp7(ALireExp7 node)
    {
        defaultIn(node);
    }

    public void outALireExp7(ALireExp7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALireExp7(ALireExp7 node)
    {
        inALireExp7(node);
        if(node.getLire() != null)
        {
            node.getLire().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outALireExp7(node);
    }

    public void inAFct(AFct node)
    {
        defaultIn(node);
    }

    public void outAFct(AFct node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFct(AFct node)
    {
        inAFct(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getListeexp() != null)
        {
            node.getListeexp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outAFct(node);
    }

    public void inAListeexpListeexp(AListeexpListeexp node)
    {
        defaultIn(node);
    }

    public void outAListeexpListeexp(AListeexpListeexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListeexpListeexp(AListeexpListeexp node)
    {
        inAListeexpListeexp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getExpbis() != null)
        {
            node.getExpbis().apply(this);
        }
        outAListeexpListeexp(node);
    }

    public void inAVideListeexp(AVideListeexp node)
    {
        defaultIn(node);
    }

    public void outAVideListeexp(AVideListeexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideListeexp(AVideListeexp node)
    {
        inAVideListeexp(node);
        outAVideListeexp(node);
    }

    public void inAExpbisExpbis(AExpbisExpbis node)
    {
        defaultIn(node);
    }

    public void outAExpbisExpbis(AExpbisExpbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpbisExpbis(AExpbisExpbis node)
    {
        inAExpbisExpbis(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getExpbis() != null)
        {
            node.getExpbis().apply(this);
        }
        outAExpbisExpbis(node);
    }

    public void inAVideExpbis(AVideExpbis node)
    {
        defaultIn(node);
    }

    public void outAVideExpbis(AVideExpbis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideExpbis(AVideExpbis node)
    {
        inAVideExpbis(node);
        outAVideExpbis(node);
    }

    public void inAVarVar(AVarVar node)
    {
        defaultIn(node);
    }

    public void outAVarVar(AVarVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarVar(AVarVar node)
    {
        inAVarVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        outAVarVar(node);
    }

    public void inATabVar(ATabVar node)
    {
        defaultIn(node);
    }

    public void outATabVar(ATabVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATabVar(ATabVar node)
    {
        inATabVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getCrochetOuvrant() != null)
        {
            node.getCrochetOuvrant().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getCrochetFermant() != null)
        {
            node.getCrochetFermant().apply(this);
        }
        outATabVar(node);
    }
}
