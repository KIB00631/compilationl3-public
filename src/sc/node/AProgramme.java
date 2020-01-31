/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AProgramme extends PProgramme
{
    private PBase _base_;
    private PListdecfonction _listdecfonction_;

    public AProgramme()
    {
        // Constructor
    }

    public AProgramme(
        @SuppressWarnings("hiding") PBase _base_,
        @SuppressWarnings("hiding") PListdecfonction _listdecfonction_)
    {
        // Constructor
        setBase(_base_);

        setListdecfonction(_listdecfonction_);

    }

    @Override
    public Object clone()
    {
        return new AProgramme(
            cloneNode(this._base_),
            cloneNode(this._listdecfonction_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAProgramme(this);
    }

    public PBase getBase()
    {
        return this._base_;
    }

    public void setBase(PBase node)
    {
        if(this._base_ != null)
        {
            this._base_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._base_ = node;
    }

    public PListdecfonction getListdecfonction()
    {
        return this._listdecfonction_;
    }

    public void setListdecfonction(PListdecfonction node)
    {
        if(this._listdecfonction_ != null)
        {
            this._listdecfonction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listdecfonction_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._base_)
            + toString(this._listdecfonction_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._base_ == child)
        {
            this._base_ = null;
            return;
        }

        if(this._listdecfonction_ == child)
        {
            this._listdecfonction_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._base_ == oldChild)
        {
            setBase((PBase) newChild);
            return;
        }

        if(this._listdecfonction_ == oldChild)
        {
            setListdecfonction((PListdecfonction) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}