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

    public boolean visit(Box0 n) { unimplementedVisitor("visit(Box0)"); return true; }
    public void endVisit(Box0 n) { unimplementedVisitor("endVisit(Box0)"); }

    public boolean visit(Box1 n) { unimplementedVisitor("visit(Box1)"); return true; }
    public void endVisit(Box1 n) { unimplementedVisitor("endVisit(Box1)"); }

    public boolean visit(BoxOperator0 n) { unimplementedVisitor("visit(BoxOperator0)"); return true; }
    public void endVisit(BoxOperator0 n) { unimplementedVisitor("endVisit(BoxOperator0)"); }

    public boolean visit(BoxOperator1 n) { unimplementedVisitor("visit(BoxOperator1)"); return true; }
    public void endVisit(BoxOperator1 n) { unimplementedVisitor("endVisit(BoxOperator1)"); }

    public boolean visit(BoxOperator2 n) { unimplementedVisitor("visit(BoxOperator2)"); return true; }
    public void endVisit(BoxOperator2 n) { unimplementedVisitor("endVisit(BoxOperator2)"); }

    public boolean visit(BoxOperator3 n) { unimplementedVisitor("visit(BoxOperator3)"); return true; }
    public void endVisit(BoxOperator3 n) { unimplementedVisitor("endVisit(BoxOperator3)"); }

    public boolean visit(BoxOperator4 n) { unimplementedVisitor("visit(BoxOperator4)"); return true; }
    public void endVisit(BoxOperator4 n) { unimplementedVisitor("endVisit(BoxOperator4)"); }

    public boolean visit(BoxOperator5 n) { unimplementedVisitor("visit(BoxOperator5)"); return true; }
    public void endVisit(BoxOperator5 n) { unimplementedVisitor("endVisit(BoxOperator5)"); }

    public boolean visit(BoxOperator6 n) { unimplementedVisitor("visit(BoxOperator6)"); return true; }
    public void endVisit(BoxOperator6 n) { unimplementedVisitor("endVisit(BoxOperator6)"); }

    public boolean visit(SpaceSymbol0 n) { unimplementedVisitor("visit(SpaceSymbol0)"); return true; }
    public void endVisit(SpaceSymbol0 n) { unimplementedVisitor("endVisit(SpaceSymbol0)"); }

    public boolean visit(SpaceSymbol1 n) { unimplementedVisitor("visit(SpaceSymbol1)"); return true; }
    public void endVisit(SpaceSymbol1 n) { unimplementedVisitor("endVisit(SpaceSymbol1)"); }

    public boolean visit(SpaceSymbol2 n) { unimplementedVisitor("visit(SpaceSymbol2)"); return true; }
    public void endVisit(SpaceSymbol2 n) { unimplementedVisitor("endVisit(SpaceSymbol2)"); }

    public boolean visit(SpaceSymbol3 n) { unimplementedVisitor("visit(SpaceSymbol3)"); return true; }
    public void endVisit(SpaceSymbol3 n) { unimplementedVisitor("endVisit(SpaceSymbol3)"); }

    public boolean visit(SpaceValue0 n) { unimplementedVisitor("visit(SpaceValue0)"); return true; }
    public void endVisit(SpaceValue0 n) { unimplementedVisitor("endVisit(SpaceValue0)"); }

    public boolean visit(SpaceValue1 n) { unimplementedVisitor("visit(SpaceValue1)"); return true; }
    public void endVisit(SpaceValue1 n) { unimplementedVisitor("endVisit(SpaceValue1)"); }

    public boolean visit(GroupOption0 n) { unimplementedVisitor("visit(GroupOption0)"); return true; }
    public void endVisit(GroupOption0 n) { unimplementedVisitor("endVisit(GroupOption0)"); }

    public boolean visit(GroupOption1 n) { unimplementedVisitor("visit(GroupOption1)"); return true; }
    public void endVisit(GroupOption1 n) { unimplementedVisitor("endVisit(GroupOption1)"); }


    public boolean visit(ASTNode n)
    {
        if (n instanceof ASTNodeToken) return visit((ASTNodeToken) n);
        else if (n instanceof BoxList) return visit((BoxList) n);
        else if (n instanceof SpaceOptionList) return visit((SpaceOptionList) n);
        else if (n instanceof SpaceOption) return visit((SpaceOption) n);
        else if (n instanceof GroupOptionList) return visit((GroupOptionList) n);
        else if (n instanceof Box0) return visit((Box0) n);
        else if (n instanceof Box1) return visit((Box1) n);
        else if (n instanceof BoxOperator0) return visit((BoxOperator0) n);
        else if (n instanceof BoxOperator1) return visit((BoxOperator1) n);
        else if (n instanceof BoxOperator2) return visit((BoxOperator2) n);
        else if (n instanceof BoxOperator3) return visit((BoxOperator3) n);
        else if (n instanceof BoxOperator4) return visit((BoxOperator4) n);
        else if (n instanceof BoxOperator5) return visit((BoxOperator5) n);
        else if (n instanceof BoxOperator6) return visit((BoxOperator6) n);
        else if (n instanceof SpaceSymbol0) return visit((SpaceSymbol0) n);
        else if (n instanceof SpaceSymbol1) return visit((SpaceSymbol1) n);
        else if (n instanceof SpaceSymbol2) return visit((SpaceSymbol2) n);
        else if (n instanceof SpaceSymbol3) return visit((SpaceSymbol3) n);
        else if (n instanceof SpaceValue0) return visit((SpaceValue0) n);
        else if (n instanceof SpaceValue1) return visit((SpaceValue1) n);
        else if (n instanceof GroupOption0) return visit((GroupOption0) n);
        else if (n instanceof GroupOption1) return visit((GroupOption1) n);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
    public void endVisit(ASTNode n)
    {
        if (n instanceof ASTNodeToken) endVisit((ASTNodeToken) n);
        else if (n instanceof BoxList) endVisit((BoxList) n);
        else if (n instanceof SpaceOptionList) endVisit((SpaceOptionList) n);
        else if (n instanceof SpaceOption) endVisit((SpaceOption) n);
        else if (n instanceof GroupOptionList) endVisit((GroupOptionList) n);
        else if (n instanceof Box0) endVisit((Box0) n);
        else if (n instanceof Box1) endVisit((Box1) n);
        else if (n instanceof BoxOperator0) endVisit((BoxOperator0) n);
        else if (n instanceof BoxOperator1) endVisit((BoxOperator1) n);
        else if (n instanceof BoxOperator2) endVisit((BoxOperator2) n);
        else if (n instanceof BoxOperator3) endVisit((BoxOperator3) n);
        else if (n instanceof BoxOperator4) endVisit((BoxOperator4) n);
        else if (n instanceof BoxOperator5) endVisit((BoxOperator5) n);
        else if (n instanceof BoxOperator6) endVisit((BoxOperator6) n);
        else if (n instanceof SpaceSymbol0) endVisit((SpaceSymbol0) n);
        else if (n instanceof SpaceSymbol1) endVisit((SpaceSymbol1) n);
        else if (n instanceof SpaceSymbol2) endVisit((SpaceSymbol2) n);
        else if (n instanceof SpaceSymbol3) endVisit((SpaceSymbol3) n);
        else if (n instanceof SpaceValue0) endVisit((SpaceValue0) n);
        else if (n instanceof SpaceValue1) endVisit((SpaceValue1) n);
        else if (n instanceof GroupOption0) endVisit((GroupOption0) n);
        else if (n instanceof GroupOption1) endVisit((GroupOption1) n);
        throw new UnsupportedOperationException("visit(" + n.getClass().toString() + ")");
    }
}

