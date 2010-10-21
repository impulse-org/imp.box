package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 2:  Box ::= BoxOperator [$ BoxList ]$
 *</b>
 */
public class Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET extends ASTNode implements IBox
{
    private IBoxOperator _BoxOperator;
    private BoxList _BoxList;

    /**
     * The value returned by <b>getBoxOperator</b> may be <b>null</b>
     */
    public IBoxOperator getBoxOperator() { return _BoxOperator; }
    public BoxList getBoxList() { return _BoxList; }

    public Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET(IToken leftIToken, IToken rightIToken,
                                                             IBoxOperator _BoxOperator,
                                                             BoxList _BoxList)
    {
        super(leftIToken, rightIToken);

        this._BoxOperator = _BoxOperator;
        if (_BoxOperator != null) ((ASTNode) _BoxOperator).setParent(this);
        this._BoxList = _BoxList;
        ((ASTNode) _BoxList).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_BoxOperator);
        list.add(_BoxList);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET)) return false;
        if (! super.equals(o)) return false;
        Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET other = (Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET) o;
        if (_BoxOperator == null)
            if (other._BoxOperator != null) return false;
            else; // continue
        else if (! _BoxOperator.equals(other._BoxOperator)) return false;
        if (! _BoxList.equals(other._BoxList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_BoxOperator == null ? 0 : _BoxOperator.hashCode());
        hash = hash * 31 + (_BoxList.hashCode());
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
            if (_BoxOperator != null) _BoxOperator.accept(v);
            _BoxList.accept(v);
        }
        v.endVisit(this);
    }
}


