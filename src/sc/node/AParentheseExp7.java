/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AParentheseExp7 extends PExp7
{
    private TParentheseOuvrante _parentheseOuvrante_;
    private PExp _exp_;
    private TParentheseFermante _parentheseFermante_;

    public AParentheseExp7()
    {
        // Constructor
    }

    public AParentheseExp7(
        @SuppressWarnings("hiding") TParentheseOuvrante _parentheseOuvrante_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TParentheseFermante _parentheseFermante_)
    {
        // Constructor
        setParentheseOuvrante(_parentheseOuvrante_);

        setExp(_exp_);

        setParentheseFermante(_parentheseFermante_);

    }

    @Override
    public Object clone()
    {
        return new AParentheseExp7(
            cloneNode(this._parentheseOuvrante_),
            cloneNode(this._exp_),
            cloneNode(this._parentheseFermante_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParentheseExp7(this);
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

    public PExp getExp()
    {
        return this._exp_;
    }

    public void setExp(PExp node)
    {
        if(this._exp_ != null)
        {
            this._exp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._parentheseOuvrante_)
            + toString(this._exp_)
            + toString(this._parentheseFermante_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._parentheseOuvrante_ == child)
        {
            this._parentheseOuvrante_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._parentheseFermante_ == child)
        {
            this._parentheseFermante_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._parentheseOuvrante_ == oldChild)
        {
            setParentheseOuvrante((TParentheseOuvrante) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._parentheseFermante_ == oldChild)
        {
            setParentheseFermante((TParentheseFermante) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
