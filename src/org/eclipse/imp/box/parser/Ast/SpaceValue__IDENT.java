package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 21:  SpaceValue ::= IDENT
 *</b>
 */
public class SpaceValue__IDENT extends ASTNodeToken implements ISpaceValue
{
    public IToken getIDENT() { return leftIToken; }

    public SpaceValue__IDENT(IToken token) { super(token); initialize(); }

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


