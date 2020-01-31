/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AFoisExp5 extends PExp5
{
    private PExp5 _exp5_;
    private TFois _fois_;
    private PExp6 _exp6_;

    public AFoisExp5()
    {
        // Constructor
    }

    public AFoisExp5(
        @SuppressWarnings("hiding") PExp5 _exp5_,
        @SuppressWarnings("hiding") TFois _fois_,
        @SuppressWarnings("hiding") PExp6 _exp6_)
    {
        // Constructor
        setExp5(_exp5_);

        setFois(_fois_);

        setExp6(_exp6_);

    }

    @Override
    public Object clone()
    {
        return new AFoisExp5(
            cloneNode(this._exp5_),
            cloneNode(this._fois_),
            cloneNode(this._exp6_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFoisExp5(this);
    }

    public PExp5 getExp5()
    {
        return this._exp5_;
    }

    public void setExp5(PExp5 node)
    {
        if(this._exp5_ != null)
        {
            this._exp5_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp5_ = node;
    }

    public TFois getFois()
    {
        return this._fois_;
    }

    public void setFois(TFois node)
    {
        if(this._fois_ != null)
        {
            this._fois_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fois_ = node;
    }

    public PExp6 getExp6()
    {
        return this._exp6_;
    }

    public void setExp6(PExp6 node)
    {
        if(this._exp6_ != null)
        {
            this._exp6_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exp6_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exp5_)
            + toString(this._fois_)
            + toString(this._exp6_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exp5_ == child)
        {
            this._exp5_ = null;
            return;
        }

        if(this._fois_ == child)
        {
            this._fois_ = null;
            return;
        }

        if(this._exp6_ == child)
        {
            this._exp6_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exp5_ == oldChild)
        {
            setExp5((PExp5) newChild);
            return;
        }

        if(this._fois_ == oldChild)
        {
            setFois((TFois) newChild);
            return;
        }

        if(this._exp6_ == oldChild)
        {
            setExp6((PExp6) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
