package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 25:  GroupOption ::= gs = NUMBER
 *</b>
 */
public class GroupOption1 extends ASTNode implements IGroupOption
{
    private ASTNodeToken _gs;
    private ASTNodeToken _EQUAL;
    private ASTNodeToken _NUMBER;

    public ASTNodeToken getgs() { return _gs; }
    public ASTNodeToken getEQUAL() { return _EQUAL; }
    public ASTNodeToken getNUMBER() { return _NUMBER; }

    public GroupOption1(IToken leftIToken, IToken rightIToken,
                        ASTNodeToken _gs,
                        ASTNodeToken _EQUAL,
                        ASTNodeToken _NUMBER)
    {
        super(leftIToken, rightIToken);

        this._gs = _gs;
        ((ASTNode) _gs).setParent(this);
        this._EQUAL = _EQUAL;
        ((ASTNode) _EQUAL).setParent(this);
        this._NUMBER = _NUMBER;
        ((ASTNode) _NUMBER).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_gs);
        list.add(_EQUAL);
        list.add(_NUMBER);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof GroupOption1)) return false;
        if (! super.equals(o)) return false;
        GroupOption1 other = (GroupOption1) o;
        if (! _gs.equals(other._gs)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _NUMBER.equals(other._NUMBER)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_gs.hashCode());
        hash = hash * 31 + (_EQUAL.hashCode());
        hash = hash * 31 + (_NUMBER.hashCode());
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
            _gs.accept(v);
            _EQUAL.accept(v);
            _NUMBER.accept(v);
        }
        v.endVisit(this);
    }
}


