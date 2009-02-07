package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 1:  Box ::= STRING
 *</b>
 */
public class Box0 extends ASTNodeToken implements IBox
{
    public IToken getSTRING() { return leftIToken; }

    public Box0(IToken token) { super(token); initialize(); }

    public void accept(IAstVisitor v)
    {
        if (! v.preVisit(this)) return;
        enter((Visitor) v);
        v.postVisit(this);
    }

    public void enter(Visitor v)
    {
        v.visit(this);
        v.endVisit(this);
    }
}


