package org.eclipse.imp.box.parser;

import lpg.runtime.*;
import java.util.*;
import org.eclipse.imp.parser.ILexer;

public class BoxLexer implements RuleAction, ILexer
{
    private BoxLexerLpgLexStream lexStream;
    
    private static ParseTable prs = new BoxLexerprs();
    public ParseTable getParseTable() { return prs; }

    private LexParser lexParser = new LexParser();
    public LexParser getParser() { return lexParser; }

    public int getToken(int i) { return lexParser.getToken(i); }
    public int getRhsFirstTokenIndex(int i) { return lexParser.getFirstToken(i); }
    public int getRhsLastTokenIndex(int i) { return lexParser.getLastToken(i); }

    public int getLeftSpan() { return lexParser.getToken(1); }
    public int getRightSpan() { return lexParser.getLastToken(); }

    public void resetKeywordLexer()
    {
        if (kwLexer == null)
              this.kwLexer = new NoKWLexer(lexStream.getInputChars(), 0);
        else this.kwLexer.setInputChars(lexStream.getInputChars());
    }

    public void reset(String filename, int tab) throws java.io.IOException
    {
        lexStream = new BoxLexerLpgLexStream(filename, tab);
        lexParser.reset((ILexStream) lexStream, prs, (RuleAction) this);
        resetKeywordLexer();
    }

    public void reset(char[] input_chars, String filename)
    {
        reset(input_chars, filename, 1);
    }
    
    public void reset(char[] input_chars, String filename, int tab)
    {
        lexStream = new BoxLexerLpgLexStream(input_chars, filename, tab);
        lexParser.reset((ILexStream) lexStream, prs, (RuleAction) this);
        resetKeywordLexer();
    }
    
    public BoxLexer(String filename, int tab) throws java.io.IOException 
    {
        reset(filename, tab);
    }

    public BoxLexer(char[] input_chars, String filename, int tab)
    {
        reset(input_chars, filename, tab);
    }

    public BoxLexer(char[] input_chars, String filename)
    {
        reset(input_chars, filename, 1);
    }

    public BoxLexer() {}

    public ILexStream getILexStream() { return lexStream; }

    /**
     * @deprecated replaced by {@link #getILexStream()}
     */
    public ILexStream getLexStream() { return lexStream; }

    private void initializeLexer(IPrsStream prsStream, int start_offset, int end_offset)
    {
        if (lexStream.getInputChars() == null)
            throw new NullPointerException("LexStream was not initialized");
        lexStream.setPrsStream(prsStream);
        prsStream.makeToken(start_offset, end_offset, 0); // Token list must start with a bad token
    }

    private void addEOF(IPrsStream prsStream, int end_offset)
    {
        prsStream.makeToken(end_offset, end_offset, BoxParsersym.TK_EOF_TOKEN); // and end with the end of file token
        prsStream.setStreamLength(prsStream.getSize());
    }

    public void lexer(IPrsStream prsStream)
    {
        lexer(null, prsStream);
    }
    
    public void lexer(Monitor monitor, IPrsStream prsStream)
    {
        initializeLexer(prsStream, 0, -1);
        lexParser.parseCharacters(monitor);  // Lex the input characters
        addEOF(prsStream, lexStream.getStreamIndex());
    }

    public void lexer(IPrsStream prsStream, int start_offset, int end_offset)
    {
        lexer(null, prsStream, start_offset, end_offset);
    }
    
    public void lexer(Monitor monitor, IPrsStream prsStream, int start_offset, int end_offset)
    {
        if (start_offset <= 1)
             initializeLexer(prsStream, 0, -1);
        else initializeLexer(prsStream, start_offset - 1, start_offset - 1);

        lexParser.parseCharacters(monitor, start_offset, end_offset);

        addEOF(prsStream, (end_offset >= lexStream.getStreamIndex() ? lexStream.getStreamIndex() : end_offset + 1));
    }

    /**
     * If a parse stream was not passed to this Lexical analyser then we
     * simply report a lexical error. Otherwise, we produce a bad token.
     */
    public void reportLexicalError(int startLoc, int endLoc) {
        IPrsStream prs_stream = lexStream.getPrsStream();
        if (prs_stream == null)
            lexStream.reportLexicalError(startLoc, endLoc);
        else {
            //
            // Remove any token that may have been processed that fall in the
            // range of the lexical error... then add one error token that spans
            // the error range.
            //
            for (int i = prs_stream.getSize() - 1; i > 0; i--) {
                if (prs_stream.getStartOffset(i) >= startLoc)
                     prs_stream.removeLastToken();
                else break;
            }
            prs_stream.makeToken(startLoc, endLoc, 0); // add an error token to the prsStream
        }        
    }

    static public class NoKWLexer
    {
        public int[] getKeywordKinds() { return null; }

        public int lexer(int curtok, int lasttok) { return 0; }

        public void setInputChars(char[] inputChars) { }

        final int getKind(int c) { return 0; }

        public NoKWLexer(char[] inputChars, int identifierKind) { }
    }

    //
    // The Lexer contains an array of characters as the input stream to be parsed.
    // There are methods to retrieve and classify characters.
    // The lexparser "token" is implemented simply as the index of the next character in the array.
    // The Lexer extends the abstract class LpgLexStream with an implementation of the abstract
    // method getKind.  The template defines the Lexer class and the lexer() method.
    // A driver creates the action class, "Lexer", passing an Option object to the constructor.
    //
    NoKWLexer kwLexer;
    boolean printTokens;
    private final static int ECLIPSE_TAB_VALUE = 4;

    public int [] getKeywordKinds() { return kwLexer.getKeywordKinds(); }

    public BoxLexer(String filename) throws java.io.IOException
    {
        this(filename, ECLIPSE_TAB_VALUE);
        this.kwLexer = new NoKWLexer(lexStream.getInputChars(), 0);
    }

    /**
     * @deprecated function replaced by {@link #reset(char [] content, String filename)}
     */
    public void initialize(char [] content, String filename)
    {
        reset(content, filename);
    }
    
    final void makeToken(int left_token, int right_token, int kind)
    {
        lexStream.makeToken(left_token, right_token, kind);
    }
    
    final void makeToken(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        lexStream.makeToken(startOffset, endOffset, kind);
        if (printTokens) printValue(startOffset, endOffset);
    }

    final void makeComment(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        lexStream.getIPrsStream().makeAdjunct(startOffset, endOffset, kind);
    }

    final void skipToken()
    {
        if (printTokens) printValue(getLeftSpan(), getRightSpan());
    }
    
    final void checkForKeyWord()
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan(),
            kwKind = kwLexer.lexer(startOffset, endOffset);
        lexStream.makeToken(startOffset, endOffset, kwKind);
        if (printTokens) printValue(startOffset, endOffset);
    }
    
    //
    // This flavor of checkForKeyWord is necessary when the default kind
    // (which is returned when the keyword filter doesn't match) is something
    // other than _IDENTIFIER.
    //
    final void checkForKeyWord(int defaultKind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan(),
            kwKind = kwLexer.lexer(startOffset, endOffset);
        if (kwKind == 0)
            kwKind = defaultKind;
        lexStream.makeToken(startOffset, endOffset, kwKind);
        if (printTokens) printValue(startOffset, endOffset);
    }
    
    final void printValue(int startOffset, int endOffset)
    {
        String s = new String(lexStream.getInputChars(), startOffset, endOffset - startOffset + 1);
        System.out.print(s);
    }

    //
    //
    //
    static class BoxLexerLpgLexStream extends LpgLexStream
    {
    public final static int tokenKind[] =
    {
        BoxLexersym.Char_CtlCharNotWS,    // 000    0x00
        BoxLexersym.Char_CtlCharNotWS,    // 001    0x01
        BoxLexersym.Char_CtlCharNotWS,    // 002    0x02
        BoxLexersym.Char_CtlCharNotWS,    // 003    0x03
        BoxLexersym.Char_CtlCharNotWS,    // 004    0x04
        BoxLexersym.Char_CtlCharNotWS,    // 005    0x05
        BoxLexersym.Char_CtlCharNotWS,    // 006    0x06
        BoxLexersym.Char_CtlCharNotWS,    // 007    0x07
        BoxLexersym.Char_CtlCharNotWS,    // 008    0x08
        BoxLexersym.Char_HT,              // 009    0x09
        BoxLexersym.Char_LF,              // 010    0x0A
        BoxLexersym.Char_CtlCharNotWS,    // 011    0x0B
        BoxLexersym.Char_FF,              // 012    0x0C
        BoxLexersym.Char_CR,              // 013    0x0D
        BoxLexersym.Char_CtlCharNotWS,    // 014    0x0E
        BoxLexersym.Char_CtlCharNotWS,    // 015    0x0F
        BoxLexersym.Char_CtlCharNotWS,    // 016    0x10
        BoxLexersym.Char_CtlCharNotWS,    // 017    0x11
        BoxLexersym.Char_CtlCharNotWS,    // 018    0x12
        BoxLexersym.Char_CtlCharNotWS,    // 019    0x13
        BoxLexersym.Char_CtlCharNotWS,    // 020    0x14
        BoxLexersym.Char_CtlCharNotWS,    // 021    0x15
        BoxLexersym.Char_CtlCharNotWS,    // 022    0x16
        BoxLexersym.Char_CtlCharNotWS,    // 023    0x17
        BoxLexersym.Char_CtlCharNotWS,    // 024    0x18
        BoxLexersym.Char_CtlCharNotWS,    // 025    0x19
        BoxLexersym.Char_CtlCharNotWS,    // 026    0x1A
        BoxLexersym.Char_CtlCharNotWS,    // 027    0x1B
        BoxLexersym.Char_CtlCharNotWS,    // 028    0x1C
        BoxLexersym.Char_CtlCharNotWS,    // 029    0x1D
        BoxLexersym.Char_CtlCharNotWS,    // 030    0x1E
        BoxLexersym.Char_CtlCharNotWS,    // 031    0x1F
        BoxLexersym.Char_Space,           // 032    0x20
        BoxLexersym.Char_Exclamation,     // 033    0x21
        BoxLexersym.Char_DoubleQuote,     // 034    0x22
        BoxLexersym.Char_Sharp,           // 035    0x23
        BoxLexersym.Char_DollarSign,      // 036    0x24
        BoxLexersym.Char_Percent,         // 037    0x25
        BoxLexersym.Char_Ampersand,       // 038    0x26
        BoxLexersym.Char_SingleQuote,     // 039    0x27
        BoxLexersym.Char_LeftParen,       // 040    0x28
        BoxLexersym.Char_RightParen,      // 041    0x29
        BoxLexersym.Char_Star,            // 042    0x2A
        BoxLexersym.Char_Plus,            // 043    0x2B
        BoxLexersym.Char_Comma,           // 044    0x2C
        BoxLexersym.Char_Minus,           // 045    0x2D
        BoxLexersym.Char_Dot,             // 046    0x2E
        BoxLexersym.Char_Slash,           // 047    0x2F
        BoxLexersym.Char_0,               // 048    0x30
        BoxLexersym.Char_1,               // 049    0x31
        BoxLexersym.Char_2,               // 050    0x32
        BoxLexersym.Char_3,               // 051    0x33
        BoxLexersym.Char_4,               // 052    0x34
        BoxLexersym.Char_5,               // 053    0x35
        BoxLexersym.Char_6,               // 054    0x36
        BoxLexersym.Char_7,               // 055    0x37
        BoxLexersym.Char_8,               // 056    0x38
        BoxLexersym.Char_9,               // 057    0x39
        BoxLexersym.Char_Colon,           // 058    0x3A
        BoxLexersym.Char_SemiColon,       // 059    0x3B
        BoxLexersym.Char_LessThan,        // 060    0x3C
        BoxLexersym.Char_Equal,           // 061    0x3D
        BoxLexersym.Char_GreaterThan,     // 062    0x3E
        BoxLexersym.Char_QuestionMark,    // 063    0x3F
        BoxLexersym.Char_AtSign,          // 064    0x40
        BoxLexersym.Char_A,               // 065    0x41
        BoxLexersym.Char_B,               // 066    0x42
        BoxLexersym.Char_C,               // 067    0x43
        BoxLexersym.Char_D,               // 068    0x44
        BoxLexersym.Char_E,               // 069    0x45
        BoxLexersym.Char_F,               // 070    0x46
        BoxLexersym.Char_G,               // 071    0x47
        BoxLexersym.Char_H,               // 072    0x48
        BoxLexersym.Char_I,               // 073    0x49
        BoxLexersym.Char_J,               // 074    0x4A
        BoxLexersym.Char_K,               // 075    0x4B
        BoxLexersym.Char_L,               // 076    0x4C
        BoxLexersym.Char_M,               // 077    0x4D
        BoxLexersym.Char_N,               // 078    0x4E
        BoxLexersym.Char_O,               // 079    0x4F
        BoxLexersym.Char_P,               // 080    0x50
        BoxLexersym.Char_Q,               // 081    0x51
        BoxLexersym.Char_R,               // 082    0x52
        BoxLexersym.Char_S,               // 083    0x53
        BoxLexersym.Char_T,               // 084    0x54
        BoxLexersym.Char_U,               // 085    0x55
        BoxLexersym.Char_V,               // 086    0x56
        BoxLexersym.Char_W,               // 087    0x57
        BoxLexersym.Char_X,               // 088    0x58
        BoxLexersym.Char_Y,               // 089    0x59
        BoxLexersym.Char_Z,               // 090    0x5A
        BoxLexersym.Char_LeftBracket,     // 091    0x5B
        BoxLexersym.Char_BackSlash,       // 092    0x5C
        BoxLexersym.Char_RightBracket,    // 093    0x5D
        BoxLexersym.Char_Caret,           // 094    0x5E
        BoxLexersym.Char__,               // 095    0x5F
        BoxLexersym.Char_BackQuote,       // 096    0x60
        BoxLexersym.Char_a,               // 097    0x61
        BoxLexersym.Char_b,               // 098    0x62
        BoxLexersym.Char_c,               // 099    0x63
        BoxLexersym.Char_d,               // 100    0x64
        BoxLexersym.Char_e,               // 101    0x65
        BoxLexersym.Char_f,               // 102    0x66
        BoxLexersym.Char_g,               // 103    0x67
        BoxLexersym.Char_h,               // 104    0x68
        BoxLexersym.Char_i,               // 105    0x69
        BoxLexersym.Char_j,               // 106    0x6A
        BoxLexersym.Char_k,               // 107    0x6B
        BoxLexersym.Char_l,               // 108    0x6C
        BoxLexersym.Char_m,               // 109    0x6D
        BoxLexersym.Char_n,               // 110    0x6E
        BoxLexersym.Char_o,               // 111    0x6F
        BoxLexersym.Char_p,               // 112    0x70
        BoxLexersym.Char_q,               // 113    0x71
        BoxLexersym.Char_r,               // 114    0x72
        BoxLexersym.Char_s,               // 115    0x73
        BoxLexersym.Char_t,               // 116    0x74
        BoxLexersym.Char_u,               // 117    0x75
        BoxLexersym.Char_v,               // 118    0x76
        BoxLexersym.Char_w,               // 119    0x77
        BoxLexersym.Char_x,               // 120    0x78
        BoxLexersym.Char_y,               // 121    0x79
        BoxLexersym.Char_z,               // 122    0x7A
        BoxLexersym.Char_LeftBrace,       // 123    0x7B
        BoxLexersym.Char_VerticalBar,     // 124    0x7C
        BoxLexersym.Char_RightBrace,      // 125    0x7D
        BoxLexersym.Char_Tilde,           // 126    0x7E

        BoxLexersym.Char_AfterASCII,      // for all chars in range 128..65534
        BoxLexersym.Char_EOF              // for '\uffff' or 65535 
    };
            
    public final int getKind(int i)  // Classify character at ith location
    {
        int c = (i >= getStreamLength() ? '\uffff' : getCharValue(i));
        return (c < 128 // ASCII Character
                  ? tokenKind[c]
                  : c == '\uffff'
                       ? BoxLexersym.Char_EOF
                       : BoxLexersym.Char_AfterASCII);
    }

    public String[] orderedExportedSymbols() { return BoxParsersym.orderedTerminalSymbols; }

    public BoxLexerLpgLexStream(String filename, int tab) throws java.io.IOException
    {
        super(filename, tab);
    }

    public BoxLexerLpgLexStream(char[] input_chars, String filename, int tab)
    {
        super(input_chars, filename, tab);
    }

    public BoxLexerLpgLexStream(char[] input_chars, String filename)
    {
        super(input_chars, filename, 1);
    }
    }

    public void ruleAction(int ruleNumber)
    {
        switch(ruleNumber)
        {

            //
            // Rule 1:  Token ::= G
            //
            case 1: { 
            
                makeToken(BoxParsersym.TK_G);
                  break;
            }
    
            //
            // Rule 2:  Token ::= I
            //
            case 2: { 
            
                makeToken(BoxParsersym.TK_I);
                  break;
            }
    
            //
            // Rule 3:  Token ::= H
            //
            case 3: { 
            
                makeToken(BoxParsersym.TK_H);
                  break;
            }
    
            //
            // Rule 4:  Token ::= H O V
            //
            case 4: { 
            
                makeToken(BoxParsersym.TK_HOV);
                  break;
            }
    
            //
            // Rule 5:  Token ::= H V
            //
            case 5: { 
            
                makeToken(BoxParsersym.TK_HV);
                  break;
            }
    
            //
            // Rule 6:  Token ::= S L
            //
            case 6: { 
            
                makeToken(BoxParsersym.TK_SL);
                  break;
            }
    
            //
            // Rule 7:  Token ::= V
            //
            case 7: { 
            
                makeToken(BoxParsersym.TK_V);
                  break;
            }
    
            //
            // Rule 8:  Token ::= W D
            //
            case 8: { 
            
                makeToken(BoxParsersym.TK_WD);
                  break;
            }
    
            //
            // Rule 9:  Token ::= c s
            //
            case 9: { 
            
                makeToken(BoxParsersym.TK_cs);
                  break;
            }
    
            //
            // Rule 10:  Token ::= g s
            //
            case 10: { 
            
                makeToken(BoxParsersym.TK_gs);
                  break;
            }
    
            //
            // Rule 11:  Token ::= h s
            //
            case 11: { 
            
                makeToken(BoxParsersym.TK_hs);
                  break;
            }
    
            //
            // Rule 12:  Token ::= i s
            //
            case 12: { 
            
                makeToken(BoxParsersym.TK_is);
                  break;
            }
    
            //
            // Rule 13:  Token ::= o p
            //
            case 13: { 
            
                makeToken(BoxParsersym.TK_op);
                  break;
            }
    
            //
            // Rule 14:  Token ::= s e p
            //
            case 14: { 
            
                makeToken(BoxParsersym.TK_sep);
                  break;
            }
    
            //
            // Rule 15:  Token ::= t s
            //
            case 15: { 
            
                makeToken(BoxParsersym.TK_ts);
                  break;
            }
    
            //
            // Rule 16:  Token ::= v s
            //
            case 16: { 
            
                makeToken(BoxParsersym.TK_vs);
                  break;
            }
    
            //
            // Rule 17:  Token ::= number
            //
            case 17: { 
            
                makeToken(BoxParsersym.TK_NUMBER);
                  break;
            }
    
            //
            // Rule 18:  Token ::= " SLBody "
            //
            case 18: { 
                makeToken(BoxParsersym.TK_STRING);
                  break;
            }
    
            //
            // Rule 19:  Token ::= white
            //
            case 19: { 
            
                skipToken();
                  break;
            }
    
            //
            // Rule 20:  Token ::= slc
            //
            case 20: { 
            
                makeComment(BoxParsersym.TK_SINGLE_LINE_COMMENT);
                  break;
            }
    
            //
            // Rule 21:  Token ::= =
            //
            case 21: { 
            
                makeToken(BoxParsersym.TK_EQUAL);
                  break;
            }
    
            //
            // Rule 22:  Token ::= [
            //
            case 22: { 
            
                makeToken(BoxParsersym.TK_LEFTBRACKET);
                  break;
            }
    
            //
            // Rule 23:  Token ::= ]
            //
            case 23: { 
            
                makeToken(BoxParsersym.TK_RIGHTBRACKET);
                  break;
            }
    
            //
            // Rule 24:  Token ::= id
            //
            case 24: { 
            
                 makeToken(BoxParsersym.TK_IDENT);
                  break;
            }
    
    
            default:
                break;
        }
        return;
    }
}

