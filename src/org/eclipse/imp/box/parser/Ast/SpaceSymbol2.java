package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 *<b>
 *<li>Rule 17:  SpaceSymbol ::= is
 *</b>
 */
public class SpaceSymbol2 extends ASTNodeToken implements ISpaceSymbol
{
    public IToken getis() { return leftIToken; }

    public SpaceSymbol2(IToken token) { super(token); initialize(); }

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


