package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 7:  BoxOperator ::= HOV SpaceOptionList
 *</b>
 */
public class BoxOperator__HOV_SpaceOptionList extends ASTNode implements IBoxOperator
{
    private ASTNodeToken _HOV;
    private SpaceOptionList _SpaceOptionList;

    public ASTNodeToken getHOV() { return _HOV; }
    public SpaceOptionList getSpaceOptionList() { return _SpaceOptionList; }

    public BoxOperator__HOV_SpaceOptionList(IToken leftIToken, IToken rightIToken,
                                            ASTNodeToken _HOV,
                                            SpaceOptionList _SpaceOptionList)
    {
        super(leftIToken, rightIToken);

        this._HOV = _HOV;
        ((ASTNode) _HOV).setParent(this);
        this._SpaceOptionList = _SpaceOptionList;
        ((ASTNode) _SpaceOptionList).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_HOV);
        list.add(_SpaceOptionList);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof BoxOperator__HOV_SpaceOptionList)) return false;
        if (! super.equals(o)) return false;
        BoxOperator__HOV_SpaceOptionList other = (BoxOperator__HOV_SpaceOptionList) o;
        if (! _HOV.equals(other._HOV)) return false;
        if (! _SpaceOptionList.equals(other._SpaceOptionList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_HOV.hashCode());
        hash = hash * 31 + (_SpaceOptionList.hashCode());
        return hash;
    }

    public void accept(IAstVisitor v)
    {
        if (! v.preVisit(this)) return;
        enter((Visitor) v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        boolean checkChildren = v.visit(this);
        if (checkChildren)
        {
            _HOV.accept(v);
            _SpaceOptionList.accept(v);
        }
        v.endVisit(this);
    }
}


