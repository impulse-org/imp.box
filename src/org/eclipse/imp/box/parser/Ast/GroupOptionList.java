package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 22:  GroupOptionList ::= $Empty
 *<li>Rule 23:  GroupOptionList ::= GroupOptionList GroupOption
 *</b>
 */
public class GroupOptionList extends AbstractASTNodeList implements IGroupOptionList
{
    public IGroupOption getGroupOptionAt(int i) { return (IGroupOption) getElementAt(i); }

    public GroupOptionList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public GroupOptionList(IGroupOption _GroupOption, boolean leftRecursive)
    {
        super((ASTNode) _GroupOption, leftRecursive);
        ((ASTNode) _GroupOption).setParent(this);
    }

    public void add(IGroupOption _GroupOption)
    {
        super.add((ASTNode) _GroupOption);
        ((ASTNode) _GroupOption).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof GroupOptionList)) return false;
        if (! super.equals(o)) return false;
        GroupOptionList other = (GroupOptionList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            IGroupOption element = getGroupOptionAt(i);
            if (! element.equals(other.getGroupOptionAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getGroupOptionAt(i).hashCode());
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
            for (int i = 0; i < size(); i++)
            {
                IGroupOption element = getGroupOptionAt(i);
                element.accept(v);
            }
        }
        v.endVisit(this);
    }
}


