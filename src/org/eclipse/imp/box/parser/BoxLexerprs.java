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

    public final static int NUM_STATES = 19;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 102;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 657;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 275;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 45;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 147;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 344;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 101;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 103;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 381;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 382;
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
            0,0,0,0,0,0,0
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
            42,43,44,45,1
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
            1,1,1,1,1,1,1,1,1,2,
            2,2,2,2,2,2,2,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1
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
            32,42,42,42,42,42,42,42,42,42,
            44,44,44,44,44,44,44,44,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,43,43,43,43,43,102,224,223,138,
            93,94,95,96,97,98,99,100,101,102,
            103,104,105,106,107,108,109,110,111,112,
            113,114,115,116,117,118,323,309,26,28,
            1,310,30,225,202,24,23,137,93,94,
            95,96,97,98,99,100,101,102,103,104,
            105,106,107,108,109,110,111,112,113,114,
            115,116,117,118,272,25,302,27,231,156,
            157,232,230,233,239,216,234,288,236,324,
            329,296,293,310,332,382,382,382,382,382,
            382,382,382,382,317,307,382,306,276,314,
            382,382
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
            70,71,72,73,74,75,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,97,98,99,
            100,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,0,0,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,72,73,74,75,76,77,78,
            79,80,81,82,83,84,85,86,87,88,
            89,90,91,92,93,94,95,96,97,98,
            99,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,0,1,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,0,1,0,1,101,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,0,0,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,0,0,18,
            19,20,0,22,0,0,25,2,27,28,
            29,0,31,32,33,34,35,36,0,0,
            23,2,4,5,6,7,8,9,10,11,
            12,13,0,0,1,30,34,26,0,1,
            0,0,0,0,3,0,14,15,0,0,
            0,0,71,0,73,74,75,16,17,0,
            0,0,21,0,32,24,0,35,36,0,
            0,0,0,0,33,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,70,0,72,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            382,561,590,562,595,596,597,598,599,600,
            601,602,603,604,617,618,544,548,549,550,
            551,556,557,558,560,564,572,575,576,577,
            583,591,616,397,632,619,620,543,545,546,
            547,552,553,554,555,559,563,565,566,567,
            568,569,570,571,573,574,578,579,580,581,
            582,584,585,586,587,588,589,592,593,594,
            645,541,364,649,650,656,540,640,646,636,
            637,638,639,657,641,642,643,644,647,648,
            652,651,653,654,655,630,631,635,633,634,
            542,17,459,466,461,413,414,415,416,417,
            418,419,420,421,422,609,610,425,433,435,
            437,439,449,451,453,457,465,430,436,438,
            440,452,468,608,510,536,382,229,423,427,
            429,431,441,443,445,447,455,463,467,469,
            471,473,424,426,428,432,434,442,444,446,
            448,450,454,456,458,460,462,464,470,472,
            474,521,537,522,526,527,532,535,516,523,
            511,512,513,514,533,517,518,519,520,524,
            525,529,528,515,530,531,506,507,534,508,
            509,21,459,466,461,413,414,415,416,417,
            418,419,420,421,422,382,392,425,433,435,
            437,439,449,451,453,457,465,430,436,438,
            440,452,468,382,391,382,389,381,423,427,
            429,431,441,443,445,447,455,463,467,469,
            471,473,424,426,428,432,434,442,444,446,
            448,450,454,456,458,460,462,464,470,472,
            474,382,382,383,355,413,414,415,416,417,
            418,419,420,421,422,504,505,382,382,356,
            359,360,382,357,382,2,358,386,394,361,
            395,382,346,501,279,362,502,503,14,382,
            390,385,413,414,415,416,417,418,419,420,
            421,422,16,382,388,363,411,393,382,387,
            382,382,382,382,623,382,504,505,382,382,
            382,382,404,382,401,402,400,622,625,382,
            382,382,624,382,501,626,382,502,503,382,
            382,382,382,382,627,382,382,382,382,382,
            382,382,382,382,382,382,382,382,382,382,
            382,382,382,382,382,382,382,382,382,382,
            382,382,382,382,382,382,382,382,382,382,
            382,628,382,629
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
