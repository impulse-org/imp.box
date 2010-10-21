package org.eclipse.imp.box.parser;

import org.eclipse.imp.box.parser.Ast.*;
import lpg.runtime.*;
import org.eclipse.imp.parser.IParser;

public class BoxParser implements RuleAction, IParser
{
    private PrsStream prsStream = null;
    
    private boolean unimplementedSymbolsWarning = false;

    private static ParseTable prsTable = new BoxParserprs();
    public ParseTable getParseTable() { return prsTable; }

    private DeterministicParser dtParser = null;
    public DeterministicParser getParser() { return dtParser; }

    private void setResult(Object object) { dtParser.setSym1(object); }
    public Object getRhsSym(int i) { return dtParser.getSym(i); }

    public int getRhsTokenIndex(int i) { return dtParser.getToken(i); }
    public IToken getRhsIToken(int i) { return prsStream.getIToken(getRhsTokenIndex(i)); }
    
    public int getRhsFirstTokenIndex(int i) { return dtParser.getFirstToken(i); }
    public IToken getRhsFirstIToken(int i) { return prsStream.getIToken(getRhsFirstTokenIndex(i)); }

    public int getRhsLastTokenIndex(int i) { return dtParser.getLastToken(i); }
    public IToken getRhsLastIToken(int i) { return prsStream.getIToken(getRhsLastTokenIndex(i)); }

    public int getLeftSpan() { return dtParser.getFirstToken(); }
    public IToken getLeftIToken()  { return prsStream.getIToken(getLeftSpan()); }

    public int getRightSpan() { return dtParser.getLastToken(); }
    public IToken getRightIToken() { return prsStream.getIToken(getRightSpan()); }

    public int getRhsErrorTokenIndex(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    public ErrorToken getRhsErrorIToken(int i)
    {
        int index = dtParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

    public void reset(ILexStream lexStream)
    {
        prsStream = new PrsStream(lexStream);
        dtParser.reset(prsStream);

        try
        {
            prsStream.remapTerminalSymbols(orderedTerminalSymbols(), prsTable.getEoftSymbol());
        }
        catch(NullExportedSymbolsException e) {
        }
        catch(NullTerminalSymbolsException e) {
        }
        catch(UnimplementedTerminalsException e)
        {
            if (unimplementedSymbolsWarning) {
                java.util.ArrayList unimplemented_symbols = e.getSymbols();
                System.out.println("The Lexer will not scan the following token(s):");
                for (int i = 0; i < unimplemented_symbols.size(); i++)
                {
                    Integer id = (Integer) unimplemented_symbols.get(i);
                    System.out.println("    " + BoxParsersym.orderedTerminalSymbols[id.intValue()]);               
                }
                System.out.println();
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 BoxParsersym.orderedTerminalSymbols[prsTable.getEoftSymbol()]));
        }
    }
    
    public BoxParser()
    {
        try
        {
            dtParser = new DeterministicParser(prsStream, prsTable, (RuleAction) this);
        }
        catch (NotDeterministicParseTableException e)
        {
            throw new Error(new NotDeterministicParseTableException
                                ("Regenerate BoxParserprs.java with -NOBACKTRACK option"));
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- BoxParsersym.java. Regenerate BoxParserprs.java"));
        }
    }

    public BoxParser(ILexStream lexStream)
    {
        this();
        reset(lexStream);
    }

    public int numTokenKinds() { return BoxParsersym.numTokenKinds; }
    public String[] orderedTerminalSymbols() { return BoxParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return BoxParsersym.orderedTerminalSymbols[kind]; }            
    public int getEOFTokenKind() { return prsTable.getEoftSymbol(); }
    public IPrsStream getIPrsStream() { return prsStream; }

    /**
     * @deprecated replaced by {@link #getIPrsStream()}
     *
     */
    public PrsStream getPrsStream() { return prsStream; }

    /**
     * @deprecated replaced by {@link #getIPrsStream()}
     *
     */
    public PrsStream getParseStream() { return prsStream; }

    public Object parser()
    {
        return parser(null, 0);
    }
        
    public Object parser(Monitor monitor)
    {
        return parser(monitor, 0);
    }
        
    public Object parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }
        
    public Object parser(Monitor monitor, int error_repair_count)
    {
        dtParser.setMonitor(monitor);

        try
        {
            return (Object) dtParser.parse();
        }
        catch (BadParseException e)
        {
            prsStream.reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }

    //
    // Additional entry points, if any
    //
    

    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {

            //
            // Rule 1:  Box ::= STRING
            //
            case 1: {
                setResult(
                    new Box__STRING(getRhsIToken(1))
                );
                break;
            }
            //
            // Rule 2:  Box ::= BoxOperator [$ BoxList ]$
            //
            case 2: {
                setResult(
                    new Box__BoxOperator_LEFTBRACKET_BoxList_RIGHTBRACKET(getLeftIToken(), getRightIToken(),
                                                                          (IBoxOperator)getRhsSym(1),
                                                                          (BoxList)getRhsSym(3))
                );
                break;
            }
            //
            // Rule 3:  BoxOperator ::=
            //
            case 3: {
                setResult(null);
                break;
            }
            //
            // Rule 4:  BoxOperator ::= H SpaceOptionList
            //
            case 4: {
                setResult(
                    new BoxOperator__H_SpaceOptionList(getLeftIToken(), getRightIToken(),
                                                       new ASTNodeToken(getRhsIToken(1)),
                                                       (SpaceOptionList)getRhsSym(2))
                );
                break;
            }
            //
            // Rule 5:  BoxOperator ::= V SpaceOptionList
            //
            case 5: {
                setResult(
                    new BoxOperator__V_SpaceOptionList(getLeftIToken(), getRightIToken(),
                                                       new ASTNodeToken(getRhsIToken(1)),
                                                       (SpaceOptionList)getRhsSym(2))
                );
                break;
            }
            //
            // Rule 6:  BoxOperator ::= HV SpaceOptionList
            //
            case 6: {
                setResult(
                    new BoxOperator__HV_SpaceOptionList(getLeftIToken(), getRightIToken(),
                                                        new ASTNodeToken(getRhsIToken(1)),
                                                        (SpaceOptionList)getRhsSym(2))
                );
                break;
            }
            //
            // Rule 7:  BoxOperator ::= HOV SpaceOptionList
            //
            case 7: {
                setResult(
                    new BoxOperator__HOV_SpaceOptionList(getLeftIToken(), getRightIToken(),
                                                         new ASTNodeToken(getRhsIToken(1)),
                                                         (SpaceOptionList)getRhsSym(2))
                );
                break;
            }
            //
            // Rule 8:  BoxOperator ::= I SpaceOptionList
            //
            case 8: {
                setResult(
                    new BoxOperator__I_SpaceOptionList(getLeftIToken(), getRightIToken(),
                                                       new ASTNodeToken(getRhsIToken(1)),
                                                       (SpaceOptionList)getRhsSym(2))
                );
                break;
            }
            //
            // Rule 9:  BoxOperator ::= G GroupOptionList
            //
            case 9: {
                setResult(
                    new BoxOperator__G_GroupOptionList(getLeftIToken(), getRightIToken(),
                                                       new ASTNodeToken(getRhsIToken(1)),
                                                       (GroupOptionList)getRhsSym(2))
                );
                break;
            }
            //
            // Rule 10:  BoxOperator ::= WD
            //
            case 10: {
                setResult(
                    new BoxOperator__WD(getRhsIToken(1))
                );
                break;
            }
            //
            // Rule 11:  BoxList ::= $Empty
            //
            case 11: {
                setResult(
                    new BoxList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
                break;
            }
            //
            // Rule 12:  BoxList ::= BoxList Box
            //
            case 12: {
                ((BoxList)getRhsSym(1)).add((IBox)getRhsSym(2));
                break;
            }
            //
            // Rule 13:  SpaceOptionList ::= $Empty
            //
            case 13: {
                setResult(
                    new SpaceOptionList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
                break;
            }
            //
            // Rule 14:  SpaceOptionList ::= SpaceOptionList SpaceOption
            //
            case 14: {
                ((SpaceOptionList)getRhsSym(1)).add((SpaceOption)getRhsSym(2));
                break;
            }
            //
            // Rule 15:  SpaceSymbol ::= vs
            //
            case 15: {
                setResult(
                    new SpaceSymbol__vs(getRhsIToken(1))
                );
                break;
            }
            //
            // Rule 16:  SpaceSymbol ::= hs
            //
            case 16: {
                setResult(
                    new SpaceSymbol__hs(getRhsIToken(1))
                );
                break;
            }
            //
            // Rule 17:  SpaceSymbol ::= is
            //
            case 17: {
                setResult(
                    new SpaceSymbol__is(getRhsIToken(1))
                );
                break;
            }
            //
            // Rule 18:  SpaceSymbol ::= ts
            //
            case 18: {
                setResult(
                    new SpaceSymbol__ts(getRhsIToken(1))
                );
                break;
            }
            //
            // Rule 19:  SpaceOption ::= SpaceSymbol =$ SpaceValue
            //
            case 19: {
                setResult(
                    new SpaceOption(getLeftIToken(), getRightIToken(),
                                    (ISpaceSymbol)getRhsSym(1),
                                    (ISpaceValue)getRhsSym(3))
                );
                break;
            }
            //
            // Rule 20:  SpaceValue ::= NUMBER
            //
            case 20: {
                setResult(
                    new SpaceValue__NUMBER(getRhsIToken(1))
                );
                break;
            }
            //
            // Rule 21:  SpaceValue ::= IDENT
            //
            case 21: {
                setResult(
                    new SpaceValue__IDENT(getRhsIToken(1))
                );
                break;
            }
            //
            // Rule 22:  GroupOptionList ::= $Empty
            //
            case 22: {
                setResult(
                    new GroupOptionList(getLeftIToken(), getRightIToken(), true /* left recursive */)
                );
                break;
            }
            //
            // Rule 23:  GroupOptionList ::= GroupOptionList GroupOption
            //
            case 23: {
                ((GroupOptionList)getRhsSym(1)).add((IGroupOption)getRhsSym(2));
                break;
            }
            //
            // Rule 24:  GroupOption ::= op =$ BoxOperator
            //
            case 24: {
                setResult(
                    new GroupOption__op_EQUAL_BoxOperator(getLeftIToken(), getRightIToken(),
                                                          new ASTNodeToken(getRhsIToken(1)),
                                                          (IBoxOperator)getRhsSym(3))
                );
                break;
            }
            //
            // Rule 25:  GroupOption ::= gs =$ NUMBER
            //
            case 25: {
                setResult(
                    new GroupOption__gs_EQUAL_NUMBER(getLeftIToken(), getRightIToken(),
                                                     new ASTNodeToken(getRhsIToken(1)),
                                                     new ASTNodeToken(getRhsIToken(3)))
                );
                break;
            }
    
            default:
                break;
        }
        return;
    }
}

