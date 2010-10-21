package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 6:  BoxOperator ::= HV SpaceOptionList
 *</b>
 */
public class BoxOperator__HV_SpaceOptionList extends ASTNode implements IBoxOperator
{
    private ASTNodeToken _HV;
    private SpaceOptionList _SpaceOptionList;

    public ASTNodeToken getHV() { return _HV; }
    public SpaceOptionList getSpaceOptionList() { return _SpaceOptionList; }

    public BoxOperator__HV_SpaceOptionList(IToken leftIToken, IToken rightIToken,
                                           ASTNodeToken _HV,
                                           SpaceOptionList _SpaceOptionList)
    {
        super(leftIToken, rightIToken);

        this._HV = _HV;
        ((ASTNode) _HV).setParent(this);
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
        list.add(_HV);
        list.add(_SpaceOptionList);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof BoxOperator__HV_SpaceOptionList)) return false;
        if (! super.equals(o)) return false;
        BoxOperator__HV_SpaceOptionList other = (BoxOperator__HV_SpaceOptionList) o;
        if (! _HV.equals(other._HV)) return false;
        if (! _SpaceOptionList.equals(other._SpaceOptionList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_HV.hashCode());
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
            _HV.accept(v);
            _SpaceOptionList.accept(v);
        }
        v.endVisit(this);
    }
}


