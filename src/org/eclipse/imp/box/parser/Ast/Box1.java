package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 2:  Box ::= BoxOperator [ BoxList ]
 *</b>
 */
public class Box1 extends ASTNode implements IBox
{
    private IBoxOperator _BoxOperator;
    private ASTNodeToken _LEFTBRACKET;
    private BoxList _BoxList;
    private ASTNodeToken _RIGHTBRACKET;

    /**
     * The value returned by <b>getBoxOperator</b> may be <b>null</b>
     */
    public IBoxOperator getBoxOperator() { return _BoxOperator; }
    public ASTNodeToken getLEFTBRACKET() { return _LEFTBRACKET; }
    public BoxList getBoxList() { return _BoxList; }
    public ASTNodeToken getRIGHTBRACKET() { return _RIGHTBRACKET; }

    public Box1(IToken leftIToken, IToken rightIToken,
                IBoxOperator _BoxOperator,
                ASTNodeToken _LEFTBRACKET,
                BoxList _BoxList,
                ASTNodeToken _RIGHTBRACKET)
    {
        super(leftIToken, rightIToken);

        this._BoxOperator = _BoxOperator;
        if (_BoxOperator != null) ((ASTNode) _BoxOperator).setParent(this);
        this._LEFTBRACKET = _LEFTBRACKET;
        ((ASTNode) _LEFTBRACKET).setParent(this);
        this._BoxList = _BoxList;
        ((ASTNode) _BoxList).setParent(this);
        this._RIGHTBRACKET = _RIGHTBRACKET;
        ((ASTNode) _RIGHTBRACKET).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_BoxOperator);
        list.add(_LEFTBRACKET);
        list.add(_BoxList);
        list.add(_RIGHTBRACKET);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof Box1)) return false;
        if (! super.equals(o)) return false;
        Box1 other = (Box1) o;
        if (_BoxOperator == null)
            if (other._BoxOperator != null) return false;
            else; // continue
        else if (! _BoxOperator.equals(other._BoxOperator)) return false;
        if (! _LEFTBRACKET.equals(other._LEFTBRACKET)) return false;
        if (! _BoxList.equals(other._BoxList)) return false;
        if (! _RIGHTBRACKET.equals(other._RIGHTBRACKET)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_BoxOperator == null ? 0 : _BoxOperator.hashCode());
        hash = hash * 31 + (_LEFTBRACKET.hashCode());
        hash = hash * 31 + (_BoxList.hashCode());
        hash = hash * 31 + (_RIGHTBRACKET.hashCode());
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
            _LEFTBRACKET.accept(v);
            _BoxList.accept(v);
            _RIGHTBRACKET.accept(v);
        }
        v.endVisit(this);
    }
}


