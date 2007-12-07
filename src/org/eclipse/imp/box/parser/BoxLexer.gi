%options package=org.eclipse.imp.box.parser
%options template=NoKeywordsLexerTemplateF.gi

%Globals
    /.import java.util.*;
    import org.eclipse.imp.parser.ILexer;
    ./
%End

%Define
    $additional_interfaces /., ILexer./
%End

%Include
    NoKeywordsLexerMapF.gi
%End

%Export
        SINGLE_LINE_COMMENT
        STRING
        EQUAL
        LEFTBRACKET
        RIGHTBRACKET
        NUMBER
        IDENTIFIER
        H 
        V
        HV
        HOV
        I
        WD
        G
        is
        vs
        hs
        op
        gs
        ts
%End

%Terminals
    CtlCharNotWS

    LF   CR   HT   FF

    a    b    c    d    e    f    g    h    i    j    k    l    m
    n    o    p    q    r    s    t    u    v    w    x    y    z
    _

    A    B    C    D    E    F    G    H    I    J    K    L    M
    N    O    P    Q    R    S    T    U    V    W    X    Y    Z

    0    1    2    3    4    5    6    7    8    9

    AfterASCII   ::= '\u0080..\ufffe'
    Space        ::= ' '
    LF           ::= NewLine
    CR           ::= Return
    HT           ::= HorizontalTab
    FF           ::= FormFeed
    DoubleQuote  ::= '"'
    SingleQuote  ::= "'"
    Percent      ::= '%'
    VerticalBar  ::= '|'
    Exclamation  ::= '!'
    AtSign       ::= '@'
    BackQuote    ::= '`'
    Tilde        ::= '~'
    Sharp        ::= '#'
    DollarSign   ::= '$'
    Ampersand    ::= '&'
    Caret        ::= '^'
    Colon        ::= ':'
    SemiColon    ::= ';'
    BackSlash    ::= '\'
    LeftBrace    ::= '{'
    RightBrace   ::= '}'
    LeftBracket  ::= '['
    RightBracket ::= ']'
    Comma        ::= ','
    QuestionMark ::= '?'
    Dot          ::= '.'
    LessThan     ::= '<'
    GreaterThan  ::= '>'
    Plus         ::= '+'
    Minus        ::= '-'
    Slash        ::= '/'
    Star         ::= '*'
    LeftParen    ::= '('
    RightParen   ::= ')'
    Equal        ::= '='
%End

%Start
    Token
%End

%Rules
    Token ::= 'V' 
        /.$BeginJava
                    makeToken($_V);
          $EndJava
        ./
   
    Token ::= 'H' 
        /.$BeginJava
                    makeToken($_H);
          $EndJava
        ./
   
    Token ::= 'H' 'O' 'V' 
        /.$BeginJava
                    makeToken($_HOV);
          $EndJava
        ./
   
    Token ::= 'H' 'V' 
        /.$BeginJava
                    makeToken($_HV);
          $EndJava
        ./
   
    Token ::= 'i' 's' 
        /.$BeginJava
                    makeToken($_is);
          $EndJava
        ./
   
    Token ::= 'h' 's'  
        /.$BeginJava
                    makeToken($_hs);
          $EndJava
        ./
   
    Token ::= 'v' 's' 
        /.$BeginJava
                    makeToken($_vs);
          $EndJava
        ./
   
    
    Token ::= 'o' 'p' 
        /.$BeginJava
                    makeToken($_op);
          $EndJava
        ./
        
    
    Token ::= 'g' 's' 
        /.$BeginJava
                    makeToken($_gs);
          $EndJava
        ./
   
    Token ::= 't' 's' 
        /.$BeginJava
                    makeToken($_ts);
          $EndJava
        ./
   
    Token ::= 'W' 'D' 
        /.$BeginJava
                    makeToken($_WD);
          $EndJava
        ./
        
    Token ::= 'G'
        /.$BeginJava
                    makeToken($_G);
          $EndJava
        ./

    Token ::= 'I'  
        /.$BeginJava
                    makeToken($_I);
          $EndJava
        ./
   
    
    Token ::= number
        /.$BeginJava
                    makeToken($_NUMBER);
          $EndJava
        ./
        
    Token ::= '"' SLBody '"'
        /.$BeginAction
                    makeToken($_STRING);
          $EndAction
        ./
        
    Token ::= white
        /.$BeginJava
                    skipToken();
          $EndJava
        ./
    Token ::= slc
        /.$BeginJava
                    makeComment($_SINGLE_LINE_COMMENT);
          $EndJava
        ./

    Token ::= '='
        /.$BeginJava
                    makeToken($_EQUAL);
          $EndJava
        ./

    Token ::= '['
        /.$BeginJava
                    makeToken($_LEFTBRACKET);
          $EndJava
        ./

    Token ::= ']'
        /.$BeginJava
                    makeToken($_RIGHTBRACKET);
          $EndJava
        ./

    number ::= digit
             | number digit

    white ::= whiteChar
            | white whiteChar

    slc ::= '/' '/'
          | slc notEOL

    digit ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    aA ::= a | A
    bB ::= b | B
    cC ::= c | C
    dD ::= d | D
    eE ::= e | E
    fF ::= f | F
    gG ::= g | G
    hH ::= h | H
    iI ::= i | I
    jJ ::= j | J
    kK ::= k | K
    lL ::= l | L
    mM ::= m | M
    nN ::= n | N
    oO ::= o | O
    pP ::= p | P
    qQ ::= q | Q
    rR ::= r | R
    sS ::= s | S
    tT ::= t | T
    uU ::= u | U
    vV ::= v | V
    wW ::= w | W
    xX ::= x | X
    yY ::= y | Y
    zZ ::= z | Z

    letter ::= aA | bB | cC | dD | eE | fF | gG | hH | iI | jJ | kK | lL | mM | nN | oO | pP | qQ | rR | sS | tT | uU | vV | wW | xX | yY | zZ

    -- any ::= letter | digit | special | white

    whiteChar ::= Space | LF | CR | HT | FF

    special ::= '+' | '-' | '(' | ')' | '"' | '!' | '@' | '`' | '~' | '.' |
                '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                '[' | ']' | '?' | ',' | '<' | '>' | '=' | '#' | '*' | '_' |
                '/' | '$'

    Letter -> LowerCaseLetter
            | UpperCaseLetter
            | _
            | '$'
            | '\u0080..\ufffe'

    LowerCaseLetter -> a | b | c | d | e | f | g | h | i | j | k | l | m |
                       n | o | p | q | r | s | t | u | v | w | x | y | z

    UpperCaseLetter -> A | B | C | D | E | F | G | H | I | J | K | L | M |
                       N | O | P | Q | R | S | T | U | V | W | X | Y | Z

    Digit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
    
    notEOL ::= letter | digit | special | Space | HT | FF
    
    SLBody ::= %Empty
             | SLBody NotDQ
    
    NotDQ ::= Letter
           | Digit
           | SpecialNotDQ
           | Space
           
    SpecialNotDQ ::= '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | "'" | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'
                    
%End
