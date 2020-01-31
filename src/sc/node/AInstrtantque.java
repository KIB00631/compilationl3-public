/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AInstrtantque extends PInstrtantque
{
    private TTantque _tantque_;
    private PExp _exp_;
    private TFaire _faire_;
    private PInstrbloc _instrbloc_;

    public AInstrtantque()
    {
        // Constructor
    }

    public AInstrtantque(
        @SuppressWarnings("hiding") TTantque _tantque_,
        @SuppressWarnings("hiding") PExp _exp_,
        @SuppressWarnings("hiding") TFaire _faire_,
        @SuppressWarnings("hiding") PInstrbloc _instrbloc_)
    {
        // Constructor
        setTantque(_tantque_);

        setExp(_exp_);

        setFaire(_faire_);

        setInstrbloc(_instrbloc_);

    }

    @Override
    public Object clone()
    {
        return new AInstrtantque(
            cloneNode(this._tantque_),
            cloneNode(this._exp_),
            cloneNode(this._faire_),
            cloneNode(this._instrbloc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInstrtantque(this);
    }

    public TTantque getTantque()
    {
        return this._tantque_;
    }

    public void setTantque(TTantque node)
    {
        if(this._tantque_ != null)
        {
            this._tantque_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tantque_ = node;
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

    public TFaire getFaire()
    {
        return this._faire_;
    }

    public void setFaire(TFaire node)
    {
        if(this._faire_ != null)
        {
            this._faire_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._faire_ = node;
    }

    public PInstrbloc getInstrbloc()
    {
        return this._instrbloc_;
    }

    public void setInstrbloc(PInstrbloc node)
    {
        if(this._instrbloc_ != null)
        {
            this._instrbloc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._instrbloc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tantque_)
            + toString(this._exp_)
            + toString(this._faire_)
            + toString(this._instrbloc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tantque_ == child)
        {
            this._tantque_ = null;
            return;
        }

        if(this._exp_ == child)
        {
            this._exp_ = null;
            return;
        }

        if(this._faire_ == child)
        {
            this._faire_ = null;
            return;
        }

        if(this._instrbloc_ == child)
        {
            this._instrbloc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tantque_ == oldChild)
        {
            setTantque((TTantque) newChild);
            return;
        }

        if(this._exp_ == oldChild)
        {
            setExp((PExp) newChild);
            return;
        }

        if(this._faire_ == oldChild)
        {
            setFaire((TFaire) newChild);
            return;
        }

        if(this._instrbloc_ == oldChild)
        {
            setInstrbloc((PInstrbloc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
