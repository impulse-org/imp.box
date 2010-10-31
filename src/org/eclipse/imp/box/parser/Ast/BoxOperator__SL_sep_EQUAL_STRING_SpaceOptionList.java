package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 10:  BoxOperator ::= SL sep$ =$ STRING$sep SpaceOptionList
 *</b>
 */
public class BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList extends ASTNode implements IBoxOperator
{
    private ASTNodeToken _SL;
    private ASTNodeToken _sep;
    private SpaceOptionList _SpaceOptionList;

    public ASTNodeToken getSL() { return _SL; }
    public ASTNodeToken getsep() { return _sep; }
    public SpaceOptionList getSpaceOptionList() { return _SpaceOptionList; }

    public BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList(IToken leftIToken, IToken rightIToken,
                                                            ASTNodeToken _SL,
                                                            ASTNodeToken _sep,
                                                            SpaceOptionList _SpaceOptionList)
    {
        super(leftIToken, rightIToken);

        this._SL = _SL;
        ((ASTNode) _SL).setParent(this);
        this._sep = _sep;
        ((ASTNode) _sep).setParent(this);
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
        list.add(_SL);
        list.add(_sep);
        list.add(_SpaceOptionList);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList)) return false;
        if (! super.equals(o)) return false;
        BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList other = (BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList) o;
        if (! _SL.equals(other._SL)) return false;
        if (! _sep.equals(other._sep)) return false;
        if (! _SpaceOptionList.equals(other._SpaceOptionList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_SL.hashCode());
        hash = hash * 31 + (_sep.hashCode());
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
            _SL.accept(v);
            _sep.accept(v);
            _SpaceOptionList.accept(v);
        }
        v.endVisit(this);
    }
}


