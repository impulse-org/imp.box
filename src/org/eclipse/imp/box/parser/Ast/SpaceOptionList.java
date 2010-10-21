package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 13:  SpaceOptionList ::= $Empty
 *<li>Rule 14:  SpaceOptionList ::= SpaceOptionList SpaceOption
 *</b>
 */
public class SpaceOptionList extends AbstractASTNodeList implements ISpaceOptionList
{
    public SpaceOption getSpaceOptionAt(int i) { return (SpaceOption) getElementAt(i); }

    public SpaceOptionList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public SpaceOptionList(SpaceOption _SpaceOption, boolean leftRecursive)
    {
        super((ASTNode) _SpaceOption, leftRecursive);
        ((ASTNode) _SpaceOption).setParent(this);
    }

    public void add(SpaceOption _SpaceOption)
    {
        super.add((ASTNode) _SpaceOption);
        ((ASTNode) _SpaceOption).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof SpaceOptionList)) return false;
        if (! super.equals(o)) return false;
        SpaceOptionList other = (SpaceOptionList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            SpaceOption element = getSpaceOptionAt(i);
            if (! element.equals(other.getSpaceOptionAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getSpaceOptionAt(i).hashCode());
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
                SpaceOption element = getSpaceOptionAt(i);
                if (! v.preVisit(element)) continue;
                element.enter(v);
                v.postVisit(element);
            }
        }
        v.endVisit(this);
    }
}


