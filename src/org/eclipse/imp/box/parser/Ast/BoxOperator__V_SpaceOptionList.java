package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 5:  BoxOperator ::= V SpaceOptionList
 *</b>
 */
public class BoxOperator__V_SpaceOptionList extends ASTNode implements IBoxOperator
{
    private ASTNodeToken _V;
    private SpaceOptionList _SpaceOptionList;

    public ASTNodeToken getV() { return _V; }
    public SpaceOptionList getSpaceOptionList() { return _SpaceOptionList; }

    public BoxOperator__V_SpaceOptionList(IToken leftIToken, IToken rightIToken,
                                          ASTNodeToken _V,
                                          SpaceOptionList _SpaceOptionList)
    {
        super(leftIToken, rightIToken);

        this._V = _V;
        ((ASTNode) _V).setParent(this);
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
        list.add(_V);
        list.add(_SpaceOptionList);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof BoxOperator__V_SpaceOptionList)) return false;
        if (! super.equals(o)) return false;
        BoxOperator__V_SpaceOptionList other = (BoxOperator__V_SpaceOptionList) o;
        if (! _V.equals(other._V)) return false;
        if (! _SpaceOptionList.equals(other._SpaceOptionList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_V.hashCode());
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
            _V.accept(v);
            _SpaceOptionList.accept(v);
        }
        v.endVisit(this);
    }
}


