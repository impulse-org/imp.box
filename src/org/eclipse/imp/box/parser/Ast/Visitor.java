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

    boolean visit(Box0 n);
    void endVisit(Box0 n);

    boolean visit(Box1 n);
    void endVisit(Box1 n);

    boolean visit(BoxOperator0 n);
    void endVisit(BoxOperator0 n);

    boolean visit(BoxOperator1 n);
    void endVisit(BoxOperator1 n);

    boolean visit(BoxOperator2 n);
    void endVisit(BoxOperator2 n);

    boolean visit(BoxOperator3 n);
    void endVisit(BoxOperator3 n);

    boolean visit(BoxOperator4 n);
    void endVisit(BoxOperator4 n);

    boolean visit(BoxOperator5 n);
    void endVisit(BoxOperator5 n);

    boolean visit(BoxOperator6 n);
    void endVisit(BoxOperator6 n);

    boolean visit(SpaceSymbol0 n);
    void endVisit(SpaceSymbol0 n);

    boolean visit(SpaceSymbol1 n);
    void endVisit(SpaceSymbol1 n);

    boolean visit(SpaceSymbol2 n);
    void endVisit(SpaceSymbol2 n);

    boolean visit(SpaceSymbol3 n);
    void endVisit(SpaceSymbol3 n);

    boolean visit(SpaceValue0 n);
    void endVisit(SpaceValue0 n);

    boolean visit(SpaceValue1 n);
    void endVisit(SpaceValue1 n);

    boolean visit(GroupOption0 n);
    void endVisit(GroupOption0 n);

    boolean visit(GroupOption1 n);
    void endVisit(GroupOption1 n);

}


