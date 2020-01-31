/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AListeexpListeexp extends PListeexp
{
    private PExp _exp_;
    private PExpbis _expbis_;

    public AListeexpListeexp()
    {
        // Constructor
    }

    public AListeexpListeexp(
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") PExpbis _expbis_)
    {
        // Constructor
        setExp(_exp_);

        setExpbis(_expbis_);

    }

    @Override
    public Object clone()
    {
        return new AListeexpListeexp(
            cloneNode(this._exp_),
            cloneNode(this._expbis_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListeexpListeexp(this);
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

    public PExpbis getExpbis()
    {
        return this._expbis_;
    }

    public void setExpbis(PExpbis node)
    {
        if(this._expbis_ != null)
        {
            this._expbis_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expbis_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp_)
            + toString(this._expbis_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._expbis_ == child)
        {
            this._expbis_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._expbis_ == oldChild)
        {
            setExpbis((PExpbis) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}