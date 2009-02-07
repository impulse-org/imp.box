package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 19:  SpaceOption ::= SpaceSymbol = SpaceValue
 *</b>
 */
public class SpaceOption extends ASTNode implements ISpaceOption
{
    private ISpaceSymbol _SpaceSymbol;
    private ASTNodeToken _EQUAL;
    private ISpaceValue _SpaceValue;

    public ISpaceSymbol getSpaceSymbol() { return _SpaceSymbol; }
    public ASTNodeToken getEQUAL() { return _EQUAL; }
    public ISpaceValue getSpaceValue() { return _SpaceValue; }

    public SpaceOption(IToken leftIToken, IToken rightIToken,
                       ISpaceSymbol _SpaceSymbol,
                       ASTNodeToken _EQUAL,
                       ISpaceValue _SpaceValue)
    {
        super(leftIToken, rightIToken);

        this._SpaceSymbol = _SpaceSymbol;
        ((ASTNode) _SpaceSymbol).setParent(this);
        this._EQUAL = _EQUAL;
        ((ASTNode) _EQUAL).setParent(this);
        this._SpaceValue = _SpaceValue;
        ((ASTNode) _SpaceValue).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_SpaceSymbol);
        list.add(_EQUAL);
        list.add(_SpaceValue);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof SpaceOption)) return false;
        if (! super.equals(o)) return false;
        SpaceOption other = (SpaceOption) o;
        if (! _SpaceSymbol.equals(other._SpaceSymbol)) return false;
        if (! _EQUAL.equals(other._EQUAL)) return false;
        if (! _SpaceValue.equals(other._SpaceValue)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_SpaceSymbol.hashCode());
        hash = hash * 31 + (_EQUAL.hashCode());
        hash = hash * 31 + (_SpaceValue.hashCode());
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
            _SpaceSymbol.accept(v);
            _EQUAL.accept(v);
            _SpaceValue.accept(v);
        }
        v.endVisit(this);
    }
}


