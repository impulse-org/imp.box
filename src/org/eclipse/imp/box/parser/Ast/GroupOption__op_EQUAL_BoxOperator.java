package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 24:  GroupOption ::= op =$ BoxOperator
 *</b>
 */
public class GroupOption__op_EQUAL_BoxOperator extends ASTNode implements IGroupOption
{
    private ASTNodeToken _op;
    private IBoxOperator _BoxOperator;

    public ASTNodeToken getop() { return _op; }
    /**
     * The value returned by <b>getBoxOperator</b> may be <b>null</b>
     */
    public IBoxOperator getBoxOperator() { return _BoxOperator; }

    public GroupOption__op_EQUAL_BoxOperator(IToken leftIToken, IToken rightIToken,
                                             ASTNodeToken _op,
                                             IBoxOperator _BoxOperator)
    {
        super(leftIToken, rightIToken);

        this._op = _op;
        ((ASTNode) _op).setParent(this);
        this._BoxOperator = _BoxOperator;
        if (_BoxOperator != null) ((ASTNode) _BoxOperator).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_op);
        list.add(_BoxOperator);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof GroupOption__op_EQUAL_BoxOperator)) return false;
        if (! super.equals(o)) return false;
        GroupOption__op_EQUAL_BoxOperator other = (GroupOption__op_EQUAL_BoxOperator) o;
        if (! _op.equals(other._op)) return false;
        if (_BoxOperator == null)
            if (other._BoxOperator != null) return false;
            else; // continue
        else if (! _BoxOperator.equals(other._BoxOperator)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_op.hashCode());
        hash = hash * 31 + (_BoxOperator == null ? 0 : _BoxOperator.hashCode());
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
            _op.accept(v);
            if (_BoxOperator != null) _BoxOperator.accept(v);
        }
        v.endVisit(this);
    }
}


