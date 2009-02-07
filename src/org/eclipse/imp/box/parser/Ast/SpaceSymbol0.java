package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 15:  SpaceSymbol ::= vs
 *</b>
 */
public class SpaceSymbol0 extends ASTNodeToken implements ISpaceSymbol
{
    public IToken getvs() { return leftIToken; }

    public SpaceSymbol0(IToken token) { super(token); initialize(); }

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


