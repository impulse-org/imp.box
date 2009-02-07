package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
 *<b>
 *<ul>
 *<li>Box0
 *<li>Box1
 *<li>BoxOperator0
 *<li>BoxOperator1
 *<li>BoxOperator2
 *<li>BoxOperator3
 *<li>BoxOperator4
 *<li>BoxOperator5
 *<li>BoxOperator6
 *<li>SpaceSymbol0
 *<li>SpaceSymbol1
 *<li>SpaceSymbol2
 *<li>SpaceSymbol3
 *<li>SpaceValue0
 *<li>SpaceValue1
 *</ul>
 *</b>
 */
public interface IASTNodeToken
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(IAstVisitor v);
}


