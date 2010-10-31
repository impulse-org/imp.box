package org.eclipse.imp.box.parser.Ast;

import lpg.runtime.*;

import org.eclipse.imp.parser.IParser;

public abstract class AbstractVisitor implements Visitor
{
    public abstract void unimplementedVisitor(String s);

    public boolean preVisit(IAst element) { return true; }

    public void postVisit(IAst element) {}

    public boolean visit(ASTNodeToken n) { unimplementedVisitor("visit(ASTNodeToken)"); return true; }
    public void endVisit(ASTNodeToken n) { unimplementedVisitor("endVisit(ASTNodeToken)"); }

    public boolean visit(BoxList n) { unimplementedVisitor("visit(BoxList)"); return true; }
    public void endVisit(BoxList n) { unimplementedVisitor("endVisit(BoxList)"); }

    public boolean visit(SpaceOptionList n) { unimplementedVisitor("visit(SpaceOptionList)"); return true; }
    public void endVisit(SpaceOptionList n) { unimplementedVisitor("endVisit(SpaceOptionList)"); }

    public boolean visit(SpaceOption n) { unimplementedVisitor("visit(SpaceOption)"); return true; }
    public void endVisit(SpaceOption n) { unimplementedVisitor("endVisit(SpaceOption)"); }

    public boolean visit(GroupOptionList n) { unimplementedVisitor("visit(GroupOptionList)"); return true; }
    public void endVisit(GroupOptionList n) { unimplementedVisitor("endVisit(GroupOptionList)"); }

    public boolean visit(Box__STRING n) { unimplementedVisitor("visit(Box__STRING)"); return true; }
    public void endVisit(Box__STRING n) { unimplementedVisitor("endVisit(Box__STRING)"); }

    public boolean visit(Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET n) { unimplementedVisitor("visit(Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET)"); return true; }
    public void endVisit(Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET n) { unimplementedVisitor("endVisit(Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET)"); }

    public boolean visit(BoxOperator__H_SpaceOptionList n) { unimplementedVisitor("visit(BoxOperator__H_SpaceOptionList)"); return true; }
    public void endVisit(BoxOperator__H_SpaceOptionList n) { unimplementedVisitor("endVisit(BoxOperator__H_SpaceOptionList)"); }

    public boolean visit(BoxOperator__V_SpaceOptionList n) { unimplementedVisitor("visit(BoxOperator__V_SpaceOptionList)"); return true; }
    public void endVisit(BoxOperator__V_SpaceOptionList n) { unimplementedVisitor("endVisit(BoxOperator__V_SpaceOptionList)"); }

    public boolean visit(BoxOperator__HV_SpaceOptionList n) { unimplementedVisitor("visit(BoxOperator__HV_SpaceOptionList)"); return true; }
    public void endVisit(BoxOperator__HV_SpaceOptionList n) { unimplementedVisitor("endVisit(BoxOperator__HV_SpaceOptionList)"); }

    public boolean visit(BoxOperator__HOV_SpaceOptionList n) { unimplementedVisitor("visit(BoxOperator__HOV_SpaceOptionList)"); return true; }
    public void endVisit(BoxOperator__HOV_SpaceOptionList n) { unimplementedVisitor("endVisit(BoxOperator__HOV_SpaceOptionList)"); }

    public boolean visit(BoxOperator__I_SpaceOptionList n) { unimplementedVisitor("visit(BoxOperator__I_SpaceOptionList)"); return true; }
    public void endVisit(BoxOperator__I_SpaceOptionList n) { unimplementedVisitor("endVisit(BoxOperator__I_SpaceOptionList)"); }

    public boolean visit(BoxOperator__G_GroupOptionList n) { unimplementedVisitor("visit(BoxOperator__G_GroupOptionList)"); return true; }
    public void endVisit(BoxOperator__G_GroupOptionList n) { unimplementedVisitor("endVisit(BoxOperator__G_GroupOptionList)"); }

    public boolean visit(BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList n) { unimplementedVisitor("visit(BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList)"); return true; }
    public void endVisit(BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList n) { unimplementedVisitor("endVisit(BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList)"); }

    public boolean visit(BoxOperator__WD n) { unimplementedVisitor("visit(BoxOperator__WD)"); return true; }
    public void endVisit(BoxOperator__WD n) { unimplementedVisitor("endVisit(BoxOperator__WD)"); }

    public boolean visit(SpaceSymbol__cs n) { unimplementedVisitor("visit(SpaceSymbol__cs)"); return true; }
    public void endVisit(SpaceSymbol__cs n) { unimplementedVisitor("endVisit(SpaceSymbol__cs)"); }

    public boolean visit(SpaceSymbol__hs n) { unimplementedVisitor("visit(SpaceSymbol__hs)"); return true; }
    public void endVisit(SpaceSymbol__hs n) { unimplementedVisitor("endVisit(SpaceSymbol__hs)"); }

    public boolean visit(SpaceSymbol__is n) { unimplementedVisitor("visit(SpaceSymbol__is)"); return true; }
    public void endVisit(SpaceSymbol__is n) { unimplementedVisitor("endVisit(SpaceSymbol__is)"); }

    public boolean visit(SpaceSymbol__ts n) { unimplementedVisitor("visit(SpaceSymbol__ts)"); return true; }
    public void endVisit(SpaceSymbol__ts n) { unimplementedVisitor("endVisit(SpaceSymbol__ts)"); }

    public boolean visit(SpaceSymbol__vs n) { unimplementedVisitor("visit(SpaceSymbol__vs)"); return true; }
    public void endVisit(SpaceSymbol__vs n) { unimplementedVisitor("endVisit(SpaceSymbol__vs)"); }

    public boolean visit(SpaceValue__NUMBER n) { unimplementedVisitor("visit(SpaceValue__NUMBER)"); return true; }
    public void endVisit(SpaceValue__NUMBER n) { unimplementedVisitor("endVisit(SpaceValue__NUMBER)"); }

    public boolean visit(SpaceValue__IDENT n) { unimplementedVisitor("visit(SpaceValue__IDENT)"); return true; }
    public void endVisit(SpaceValue__IDENT n) { unimplementedVisitor("endVisit(SpaceValue__IDENT)"); }

    public boolean visit(GroupOption__op_EQUAL_BoxOperator n) { unimplementedVisitor("visit(GroupOption__op_EQUAL_BoxOperator)"); return true; }
    public void endVisit(GroupOption__op_EQUAL_BoxOperator n) { unimplementedVisitor("endVisit(GroupOption__op_EQUAL_BoxOperator)"); }

    public boolean visit(GroupOption__gs_EQUAL_NUMBER n) { unimplementedVisitor("visit(GroupOption__gs_EQUAL_NUMBER)"); return true; }
    public void endVisit(GroupOption__gs_EQUAL_NUMBER n) { unimplementedVisitor("endVisit(GroupOption__gs_EQUAL_NUMBER)"); }


    public boolean visit(ASTNode n)
    {
        if (n instanceof ASTNodeToken) return visit((ASTNodeToken) n);
        else if (n instanceof BoxList) return visit((BoxList) n);
        else if (n instanceof SpaceOptionList) return visit((SpaceOptionList) n);
        else if (n instanceof SpaceOption) return visit((SpaceOption) n);
        else if (n instanceof GroupOptionList) return visit((GroupOptionList) n);
        else if (n instanceof Box__STRING) return visit((Box__STRING) n);
        else if (n instanceof Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET) return visit((Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET) n);
        else if (n instanceof BoxOperator__H_SpaceOptionList) return visit((BoxOperator__H_SpaceOptionList) n);
        else if (n instanceof BoxOperator__V_SpaceOptionList) return visit((BoxOperator__V_SpaceOptionList) n);
        else if (n instanceof BoxOperator__HV_SpaceOptionList) return visit((BoxOperator__HV_SpaceOptionList) n);
        else if (n instanceof BoxOperator__HOV_SpaceOptionList) return visit((BoxOperator__HOV_SpaceOptionList) n);
        else if (n instanceof BoxOperator__I_SpaceOptionList) return visit((BoxOperator__I_SpaceOptionList) n);
        else if (n instanceof BoxOperator__G_GroupOptionList) return visit((BoxOperator__G_GroupOptionList) n);
        else if (n instanceof BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList) return visit((BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList) n);
        else if (n instanceof BoxOperator__WD) return visit((BoxOperator__WD) n);
        else if (n instanceof SpaceSymbol__cs) return visit((SpaceSymbol__cs) n);
        else if (n instanceof SpaceSymbol__hs) return visit((SpaceSymbol__hs) n);
        else if (n instanceof SpaceSymbol__is) return visit((SpaceSymbol__is) n);
        else if (n instanceof SpaceSymbol__ts) return visit((SpaceSymbol__ts) n);
        else if (n instanceof SpaceSymbol__vs) return visit((SpaceSymbol__vs) n);
        else if (n instanceof SpaceValue__NUMBER) return visit((SpaceValue__NUMBER) n);
        else if (n instanceof SpaceValue__IDENT) return visit((SpaceValue__IDENT) n);
        else if (n instanceof GroupOption__op_EQUAL_BoxOperator) return visit((GroupOption__op_EQUAL_BoxOperator) n);
        else if (n instanceof GroupOption__gs_EQUAL_NUMBER) return visit((GroupOption__gs_EQUAL_NUMBER) n);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
    public void endVisit(ASTNode n)
    {
        if (n instanceof ASTNodeToken) endVisit((ASTNodeToken) n);
        else if (n instanceof BoxList) endVisit((BoxList) n);
        else if (n instanceof SpaceOptionList) endVisit((SpaceOptionList) n);
        else if (n instanceof SpaceOption) endVisit((SpaceOption) n);
        else if (n instanceof GroupOptionList) endVisit((GroupOptionList) n);
        else if (n instanceof Box__STRING) endVisit((Box__STRING) n);
        else if (n instanceof Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET) endVisit((Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET) n);
        else if (n instanceof BoxOperator__H_SpaceOptionList) endVisit((BoxOperator__H_SpaceOptionList) n);
        else if (n instanceof BoxOperator__V_SpaceOptionList) endVisit((BoxOperator__V_SpaceOptionList) n);
        else if (n instanceof BoxOperator__HV_SpaceOptionList) endVisit((BoxOperator__HV_SpaceOptionList) n);
        else if (n instanceof BoxOperator__HOV_SpaceOptionList) endVisit((BoxOperator__HOV_SpaceOptionList) n);
        else if (n instanceof BoxOperator__I_SpaceOptionList) endVisit((BoxOperator__I_SpaceOptionList) n);
        else if (n instanceof BoxOperator__G_GroupOptionList) endVisit((BoxOperator__G_GroupOptionList) n);
        else if (n instanceof BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList) endVisit((BoxOperator__SL_sep_EQUAL_STRING_SpaceOptionList) n);
        else if (n instanceof BoxOperator__WD) endVisit((BoxOperator__WD) n);
        else if (n instanceof SpaceSymbol__cs) endVisit((SpaceSymbol__cs) n);
        else if (n instanceof SpaceSymbol__hs) endVisit((SpaceSymbol__hs) n);
        else if (n instanceof SpaceSymbol__is) endVisit((SpaceSymbol__is) n);
        else if (n instanceof SpaceSymbol__ts) endVisit((SpaceSymbol__ts) n);
        else if (n instanceof SpaceSymbol__vs) endVisit((SpaceSymbol__vs) n);
        else if (n instanceof SpaceValue__NUMBER) endVisit((SpaceValue__NUMBER) n);
        else if (n instanceof SpaceValue__IDENT) endVisit((SpaceValue__IDENT) n);
        else if (n instanceof GroupOption__op_EQUAL_BoxOperator) endVisit((GroupOption__op_EQUAL_BoxOperator) n);
        else if (n instanceof GroupOption__gs_EQUAL_NUMBER) endVisit((GroupOption__gs_EQUAL_NUMBER) n);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
}

