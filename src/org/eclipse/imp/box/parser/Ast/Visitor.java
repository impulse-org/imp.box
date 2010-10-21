package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

public interface Visitor extends IAstVisitor
{
    boolean visit(ASTNode n);
    void endVisit(ASTNode n);

    boolean visit(ASTNodeToken n);
    void endVisit(ASTNodeToken n);

    boolean visit(BoxList n);
    void endVisit(BoxList n);

    boolean visit(SpaceOptionList n);
    void endVisit(SpaceOptionList n);

    boolean visit(SpaceOption n);
    void endVisit(SpaceOption n);

    boolean visit(GroupOptionList n);
    void endVisit(GroupOptionList n);

    boolean visit(Box__STRING n);
    void endVisit(Box__STRING n);

    boolean visit(Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET n);
    void endVisit(Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET n);

    boolean visit(BoxOperator__H_SpaceOptionList n);
    void endVisit(BoxOperator__H_SpaceOptionList n);

    boolean visit(BoxOperator__V_SpaceOptionList n);
    void endVisit(BoxOperator__V_SpaceOptionList n);

    boolean visit(BoxOperator__HV_SpaceOptionList n);
    void endVisit(BoxOperator__HV_SpaceOptionList n);

    boolean visit(BoxOperator__HOV_SpaceOptionList n);
    void endVisit(BoxOperator__HOV_SpaceOptionList n);

    boolean visit(BoxOperator__I_SpaceOptionList n);
    void endVisit(BoxOperator__I_SpaceOptionList n);

    boolean visit(BoxOperator__G_GroupOptionList n);
    void endVisit(BoxOperator__G_GroupOptionList n);

    boolean visit(BoxOperator__WD n);
    void endVisit(BoxOperator__WD n);

    boolean visit(SpaceSymbol__vs n);
    void endVisit(SpaceSymbol__vs n);

    boolean visit(SpaceSymbol__hs n);
    void endVisit(SpaceSymbol__hs n);

    boolean visit(SpaceSymbol__is n);
    void endVisit(SpaceSymbol__is n);

    boolean visit(SpaceSymbol__ts n);
    void endVisit(SpaceSymbol__ts n);

    boolean visit(SpaceValue__NUMBER n);
    void endVisit(SpaceValue__NUMBER n);

    boolean visit(SpaceValue__IDENT n);
    void endVisit(SpaceValue__IDENT n);

    boolean visit(GroupOption__op_EQUAL_BoxOperator n);
    void endVisit(GroupOption__op_EQUAL_BoxOperator n);

    boolean visit(GroupOption__gs_EQUAL_NUMBER n);
    void endVisit(GroupOption__gs_EQUAL_NUMBER n);

}


