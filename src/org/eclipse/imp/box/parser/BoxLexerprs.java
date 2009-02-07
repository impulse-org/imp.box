package org.eclipse.imp.box.parser;

public class BoxLexerprs implements lpg.runtime.ParseTable, BoxLexersym {
    public final static int ERROR_SYMBOL = 0;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 0;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 0;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 18;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 102;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 631;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 262;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 44;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 146;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 331;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 101;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 103;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 368;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 369;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return BoxLexersym.isValidForParser; }


    public interface IsNullable {
        public final static byte isNullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,1,0,0,0,0,0,0,
            0,0,0,0,0,0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            9,8,10,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,36,37,2,
            3,4,5,6,7,11,38,39,40,41,
            42,43,44,1
        };
    };
    public final static byte prosthesesIndex[] = ProsthesesIndex.prosthesesIndex;
    public final int prosthesesIndex(int index) { return prosthesesIndex[index]; }

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            1,1,3,2,2,2,2,2,2,2,
            2,1,1,1,3,1,1,1,1,1,
            1,1,2,2,1,2,1,2,2,2,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,0,2,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            30,30,30,30,30,30,30,30,30,30,
            30,30,30,30,30,30,30,30,30,30,
            30,30,35,35,35,31,31,33,33,34,
            34,1,1,1,1,1,1,1,1,1,
            1,4,4,5,5,6,6,7,7,8,
            8,9,9,10,10,11,11,12,12,13,
            13,14,14,15,15,16,16,17,17,18,
            18,19,19,20,20,21,21,22,22,23,
            23,24,24,25,25,26,26,27,27,28,
            28,29,29,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,3,
            3,3,3,3,37,37,37,37,37,37,
            37,37,37,37,37,37,37,37,37,37,
            37,37,37,37,37,37,37,37,37,37,
            37,37,37,37,37,37,38,38,38,38,
            38,39,39,39,39,39,39,39,39,39,
            39,39,39,39,39,39,39,39,39,39,
            39,39,39,39,39,39,39,40,40,40,
            40,40,40,40,40,40,40,40,40,40,
            40,40,40,40,40,40,40,40,40,40,
            40,40,40,41,41,41,41,41,41,41,
            41,41,41,36,36,36,36,36,36,32,
            32,42,42,42,42,43,43,43,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,43,43,1,224,223,74,93,94,95,
            96,97,98,99,100,101,102,103,104,105,
            106,107,108,109,110,111,112,113,114,115,
            116,117,118,286,299,26,28,102,297,30,
            225,202,24,23,73,93,94,95,96,97,
            98,99,100,101,102,103,104,105,106,107,
            108,109,110,111,112,113,114,115,116,117,
            118,269,25,293,27,231,156,157,232,230,
            233,130,228,300,230,322,324,319,289,318,
            369,369,369,369,369,369,369,369,369,369,
            369,304,294,369,293,263,301,369,369
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,16,17,18,19,
            20,21,22,23,24,25,26,27,28,29,
            30,31,32,33,34,35,36,37,38,39,
            40,41,42,43,44,45,46,47,48,49,
            50,51,52,53,54,55,56,57,58,59,
            60,61,62,63,64,65,66,67,68,69,
            70,71,0,0,74,75,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,97,98,0,
            100,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,0,
            1,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,101,0,74,75,76,77,78,
            79,80,81,82,83,84,85,86,87,88,
            89,90,91,92,93,94,95,96,97,98,
            99,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,0,1,0,
            1,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,0,0,
            2,3,4,5,6,7,8,9,10,11,
            12,13,14,15,16,0,18,19,0,21,
            22,23,0,25,26,27,28,29,0,0,
            0,3,4,5,6,7,8,9,10,11,
            12,26,20,28,29,27,17,0,0,2,
            2,0,1,0,1,0,0,0,0,0,
            0,0,0,0,0,67,68,69,70,71,
            72,73,24,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,72,73,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            17,446,453,400,401,402,403,404,405,406,
            407,408,409,422,424,426,438,440,448,452,
            417,423,425,427,439,455,595,523,596,597,
            410,412,414,416,418,420,428,430,432,434,
            436,442,444,450,454,456,458,460,411,413,
            415,419,421,429,431,433,435,437,441,443,
            445,447,449,451,457,459,461,497,524,513,
            514,519,369,229,522,508,503,510,498,499,
            500,501,520,504,505,506,507,511,512,516,
            515,502,517,518,493,494,521,495,496,369,
            509,369,548,577,582,583,584,585,586,587,
            588,589,590,591,536,537,538,544,545,549,
            551,559,562,563,564,570,578,603,606,369,
            379,530,531,532,533,534,535,539,540,541,
            542,543,546,547,550,552,553,554,555,556,
            557,558,560,561,565,566,567,568,569,571,
            572,573,574,575,576,579,580,581,384,528,
            623,624,630,368,369,527,619,614,620,610,
            611,612,613,631,615,616,617,618,621,622,
            626,625,627,628,629,604,605,609,607,608,
            529,21,446,453,400,401,402,403,404,405,
            406,407,408,409,422,424,426,438,440,448,
            452,417,423,425,427,439,455,369,378,369,
            376,410,412,414,416,418,420,428,430,432,
            434,436,442,444,450,454,456,458,460,411,
            413,415,419,421,429,431,433,435,437,441,
            443,445,447,449,451,457,459,461,369,369,
            370,400,401,402,403,404,405,406,407,408,
            409,342,345,346,343,16,341,344,369,381,
            347,382,369,333,488,348,491,492,14,369,
            369,400,401,402,403,404,405,406,407,408,
            409,488,380,491,492,398,377,369,2,372,
            373,369,375,369,374,369,369,369,369,369,
            369,369,369,369,369,266,391,388,389,387,
            489,490,349,369,369,369,369,369,369,369,
            369,369,369,369,369,369,369,489,490
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    /**
     * assert(! goto_default);
     */
    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    /**
     * assert(! shift_default);
     */
    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
