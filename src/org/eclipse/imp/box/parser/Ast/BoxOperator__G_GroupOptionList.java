package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 9:  BoxOperator ::= G GroupOptionList
 *</b>
 */
public class BoxOperator__G_GroupOptionList extends ASTNode implements IBoxOperator
{
    private ASTNodeToken _G;
    private GroupOptionList _GroupOptionList;

    public ASTNodeToken getG() { return _G; }
    public GroupOptionList getGroupOptionList() { return _GroupOptionList; }

    public BoxOperator__G_GroupOptionList(IToken leftIToken, IToken rightIToken,
                                          ASTNodeToken _G,
                                          GroupOptionList _GroupOptionList)
    {
        super(leftIToken, rightIToken);

        this._G = _G;
        ((ASTNode) _G).setParent(this);
        this._GroupOptionList = _GroupOptionList;
        ((ASTNode) _GroupOptionList).setParent(this);
        initialize();
    }

    /**
     * A list of all children of this node, including the null ones.
     */
    public java.util.ArrayList getAllChildren()
    {
        java.util.ArrayList list = new java.util.ArrayList();
        list.add(_G);
        list.add(_GroupOptionList);
        return list;
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof BoxOperator__G_GroupOptionList)) return false;
        if (! super.equals(o)) return false;
        BoxOperator__G_GroupOptionList other = (BoxOperator__G_GroupOptionList) o;
        if (! _G.equals(other._G)) return false;
        if (! _GroupOptionList.equals(other._GroupOptionList)) return false;
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        hash = hash * 31 + (_G.hashCode());
        hash = hash * 31 + (_GroupOptionList.hashCode());
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
            _G.accept(v);
            _GroupOptionList.accept(v);
        }
        v.endVisit(this);
    }
}


