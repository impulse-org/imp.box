package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 12:  BoxList ::= $Empty
 *<li>Rule 13:  BoxList ::= BoxList Box
 *</b>
 */
public class BoxList extends AbstractASTNodeList implements IBoxList
{
    public IBox getBoxAt(int i) { return (IBox) getElementAt(i); }

    public BoxList(IToken leftIToken, IToken rightIToken, boolean leftRecursive)
    {
        super(leftIToken, rightIToken, leftRecursive);
    }

    public BoxList(IBox _Box, boolean leftRecursive)
    {
        super((ASTNode) _Box, leftRecursive);
        ((ASTNode) _Box).setParent(this);
    }

    public void add(IBox _Box)
    {
        super.add((ASTNode) _Box);
        ((ASTNode) _Box).setParent(this);
    }

    public boolean equals(Object o)
    {
        if (o == this) return true;
        if (! (o instanceof BoxList)) return false;
        if (! super.equals(o)) return false;
        BoxList other = (BoxList) o;
        if (size() != other.size()) return false;
        for (int i = 0; i < size(); i++)
        {
            IBox element = getBoxAt(i);
            if (! element.equals(other.getBoxAt(i))) return false;
        }
        return true;
    }

    public int hashCode()
    {
        int hash = super.hashCode();
        for (int i = 0; i < size(); i++)
            hash = hash * 31 + (getBoxAt(i).hashCode());
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
                IBox element = getBoxAt(i);
                element.accept(v);
            }
        }
        v.endVisit(this);
    }
}


