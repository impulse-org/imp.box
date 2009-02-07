package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 24:  GroupOption ::= op = BoxOperator
 *</b>
 */
public class GroupOption0 extends ASTNode implements IGroupOption
{
    private ASTNodeToken _op;
    private ASTNodeToken _EQUAL;
    private IBoxOperator _BoxOperator;

    public ASTNodeToken getop() { return _op; }
    public ASTNodeToken getEQUAL() { return _EQUAL; }
    /**
     * The value returned by <b>getBoxOperator</b> may be <b>null</b>
     */
    public IBoxOperator getBoxOperator() { return _BoxOperator; }

    public GroupOption0(IToken leftIToken, IToken rightIToken,
                        ASTNodeToken _op,
                        ASTNodeToken _EQUAL,
                        IBoxOperator _BoxOperator)
    {
        super(leftIToken, rightIToken);

        this._op = _op;
        ((ASTNode) _op).setParent(this);
        this._EQUAL = _EQUAL;
        ((ASTNode) _EQUAL).setParent(this);
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
        list.add(_EQUAL);
        list.add(_BoxOperator);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof GroupOption0)) return false;
        if (! super.equals(o)) return false;
        GroupOption0 other = (GroupOption0) o;
        if (! _op.equals(other._op)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
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
        hash = hash * 31 + (_EQUAL.hashCode());
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
            _EQUAL.accept(v);
            if (_BoxOperator != null) _BoxOperator.accept(v);
        }
        v.endVisit(this);
    }
}


