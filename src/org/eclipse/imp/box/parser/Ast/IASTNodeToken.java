package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

/**
 * is always implemented by <b>ASTNodeToken</b>. It is also implemented by:
 *<b>
 *<ul>
 *<li>Box__STRING
 *<li>Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET
 *<li>BoxOperator__H_SpaceOptionList
 *<li>BoxOperator__V_SpaceOptionList
 *<li>BoxOperator__HV_SpaceOptionList
 *<li>BoxOperator__HOV_SpaceOptionList
 *<li>BoxOperator__I_SpaceOptionList
 *<li>BoxOperator__G_GroupOptionList
 *<li>BoxOperator__WD
 *<li>SpaceSymbol__vs
 *<li>SpaceSymbol__hs
 *<li>SpaceSymbol__is
 *<li>SpaceSymbol__ts
 *<li>SpaceValue__NUMBER
 *<li>SpaceValue__IDENT
 *</ul>
 *</b>
 */
public interface IASTNodeToken
{
    public IToken getLeftIToken();
    public IToken getRightIToken();

    void accept(IAstVisitor v);
}


