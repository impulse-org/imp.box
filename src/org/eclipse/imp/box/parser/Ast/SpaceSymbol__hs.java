package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 16:  SpaceSymbol ::= hs
 *</b>
 */
public class SpaceSymbol__hs extends ASTNodeToken implements ISpaceSymbol
{
    public IToken geths() { return leftIToken; }

    public SpaceSymbol__hs(IToken token) { super(token); initialize(); }

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


