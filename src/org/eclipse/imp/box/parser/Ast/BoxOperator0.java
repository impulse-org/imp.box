package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 4:  BoxOperator ::= H SpaceOptionList
 *</b>
 */
public class BoxOperator0 extends ASTNode implements IBoxOperator
{
    private ASTNodeToken _H;
    private SpaceOptionList _SpaceOptionList;

    public ASTNodeToken getH() { return _H; }
    public SpaceOptionList getSpaceOptionList() { return _SpaceOptionList; }

    public BoxOperator0(IToken leftIToken, IToken rightIToken,
                        ASTNodeToken _H,
                        SpaceOptionList _SpaceOptionList)
    {
        super(leftIToken, rightIToken);

        this._H = _H;
        ((ASTNode) _H).setParent(this);
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
        list.add(_H);
        list.add(_SpaceOptionList);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof BoxOperator0)) return false;
        if (! super.equals(o)) return false;
        BoxOperator0 other = (BoxOperator0) o;
        if (! _H.equals(other._H)) return false;
        if (! _SpaceOptionList.equals(other._SpaceOptionList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_H.hashCode());
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
            _H.accept(v);
            _SpaceOptionList.accept(v);
        }
        v.endVisit(this);
    }
}


