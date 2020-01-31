/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AInstrecriture extends PInstrecriture
{
    private TEcrire _ecrire_;
    private TParentheseOuvrante _parentheseOuvrante_;
    private PListeexp _listeexp_;
    private TParentheseFermante _parentheseFermante_;
    private TPointVirgule _pointVirgule_;

    public AInstrecriture()
    {
        // Constructor
    }

    public AInstrecriture(
        @SuppressWarnings("hiding") TEcrire _ecrire_,
        @SuppressWarnings("hiding") TParentheseOuvrante _parentheseOuvrante_,
        @SuppressWarnings("hiding") PListeexp _listeexp_,
        @SuppressWarnings("hiding") TParentheseFermante _parentheseFermante_,
        @SuppressWarnings("hiding") TPointVirgule _pointVirgule_)
    {
        // Constructor
        setEcrire(_ecrire_);

        setParentheseOuvrante(_parentheseOuvrante_);

        setListeexp(_listeexp_);

        setParentheseFermante(_parentheseFermante_);

        setPointVirgule(_pointVirgule_);

    }

    @Override
    public Object clone()
    {
        return new AInstrecriture(
            cloneNode(this._ecrire_),
            cloneNode(this._parentheseOuvrante_),
            cloneNode(this._listeexp_),
            cloneNode(this._parentheseFermante_),
            cloneNode(this._pointVirgule_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInstrecriture(this);
    }

    public TEcrire getEcrire()
    {
        return this._ecrire_;
    }

    public void setEcrire(TEcrire node)
    {
        if(this._ecrire_ != null)
        {
            this._ecrire_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ecrire_ = node;
    }

    public TParentheseOuvrante getParentheseOuvrante()
    {
        return this._parentheseOuvrante_;
    }

    public void setParentheseOuvrante(TParentheseOuvrante node)
    {
        if(this._parentheseOuvrante_ != null)
        {
            this._parentheseOuvrante_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parentheseOuvrante_ = node;
    }

    public PListeexp getListeexp()
    {
        return this._listeexp_;
    }

    public void setListeexp(PListeexp node)
    {
        if(this._listeexp_ != null)
        {
            this._listeexp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeexp_ = node;
    }

    public TParentheseFermante getParentheseFermante()
    {
        return this._parentheseFermante_;
    }

    public void setParentheseFermante(TParentheseFermante node)
    {
        if(this._parentheseFermante_ != null)
        {
            this._parentheseFermante_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parentheseFermante_ = node;
    }

    public TPointVirgule getPointVirgule()
    {
        return this._pointVirgule_;
    }

    public void setPointVirgule(TPointVirgule node)
    {
        if(this._pointVirgule_ != null)
        {
            this._pointVirgule_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pointVirgule_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ecrire_)
            + toString(this._parentheseOuvrante_)
            + toString(this._listeexp_)
            + toString(this._parentheseFermante_)
            + toString(this._pointVirgule_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ecrire_ == child)
        {
            this._ecrire_ = null;
            return;
        }

        if(this._parentheseOuvrante_ == child)
        {
            this._parentheseOuvrante_ = null;
            return;
        }

        if(this._listeexp_ == child)
        {
            this._listeexp_ = null;
            return;
        }

        if(this._parentheseFermante_ == child)
        {
            this._parentheseFermante_ = null;
            return;
        }

        if(this._pointVirgule_ == child)
        {
            this._pointVirgule_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ecrire_ == oldChild)
        {
            setEcrire((TEcrire) newChild);
            return;
        }

        if(this._parentheseOuvrante_ == oldChild)
        {
            setParentheseOuvrante((TParentheseOuvrante) newChild);
            return;
        }

        if(this._listeexp_ == oldChild)
        {
            setListeexp((PListeexp) newChild);
            return;
        }

        if(this._parentheseFermante_ == oldChild)
        {
            setParentheseFermante((TParentheseFermante) newChild);
            return;
        }

        if(this._pointVirgule_ == oldChild)
        {
            setPointVirgule((TPointVirgule) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
