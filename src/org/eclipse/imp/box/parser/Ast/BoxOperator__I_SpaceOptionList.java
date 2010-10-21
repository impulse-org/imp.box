package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 8:  BoxOperator ::= I SpaceOptionList
 *</b>
 */
public class BoxOperator__I_SpaceOptionList extends ASTNode implements IBoxOperator
{
    private ASTNodeToken _I;
    private SpaceOptionList _SpaceOptionList;

    public ASTNodeToken getI() { return _I; }
    public SpaceOptionList getSpaceOptionList() { return _SpaceOptionList; }

    public BoxOperator__I_SpaceOptionList(IToken leftIToken, IToken rightIToken,
                                          ASTNodeToken _I,
                                          SpaceOptionList _SpaceOptionList)
    {
        super(leftIToken, rightIToken);

        this._I = _I;
        ((ASTNode) _I).setParent(this);
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
        list.add(_I);
        list.add(_SpaceOptionList);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof BoxOperator__I_SpaceOptionList)) return false;
        if (! super.equals(o)) return false;
        BoxOperator__I_SpaceOptionList other = (BoxOperator__I_SpaceOptionList) o;
        if (! _I.equals(other._I)) return false;
        if (! _SpaceOptionList.equals(other._SpaceOptionList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_I.hashCode());
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
            _I.accept(v);
            _SpaceOptionList.accept(v);
        }
        v.endVisit(this);
    }
}


