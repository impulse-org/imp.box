package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 * is implemented by:
 *<b>
 *<ul>
 *<li>GroupOption__op_EQUAL_BoxOperator
 *<li>GroupOption__gs_EQUAL_NUMBER
 *</ul>
 *</b>
 */
public interface IGroupOption
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(IAstVisitor v);
}


