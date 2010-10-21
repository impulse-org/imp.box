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

    public final static int LA_STATE_OFFSET = 653;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 273;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 45;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 147;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 342;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 101;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 103;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 379;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 380;
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
            1,1,1,1,1,1,1,2,2,2,
            2,2,2,2,2,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1
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
            32,42,42,42,42,42,42,42,44,44,
            44,44,44,44,44,44,43,43,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,43,43,43,102,224,223,76,93,94,
            95,96,97,98,99,100,101,102,103,104,
            105,106,107,108,109,110,111,112,113,114,
            115,116,117,118,293,305,26,28,1,308,
            30,225,202,24,23,75,93,94,95,96,
            97,98,99,100,101,102,103,104,105,106,
            107,108,109,110,111,112,113,114,115,116,
            117,118,270,25,300,27,231,156,157,232,
            230,233,237,216,234,306,286,319,321,294,
            323,332,330,380,380,380,380,380,380,380,
            380,380,315,305,380,304,274,312,380,380
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
            70,71,72,73,0,0,76,77,78,79,
            80,81,82,83,84,85,86,87,88,89,
            90,91,92,93,94,95,96,97,98,99,
            100,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,15,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,72,73,101,0,76,77,78,
            79,80,81,82,83,84,85,86,87,88,
            89,90,91,92,93,94,95,96,97,98,
            99,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,0,1,16,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,0,1,0,35,36,37,38,
            39,40,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,0,
            0,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,0,1,18,19,20,
            0,22,0,0,25,2,27,28,29,0,
            31,32,33,34,0,0,14,15,4,5,
            6,7,8,9,10,11,12,13,0,1,
            0,1,0,30,32,26,0,0,23,0,
            0,0,3,2,0,0,0,0,69,0,
            71,72,73,74,75,16,17,0,0,0,
            21,0,0,24,0,0,34,0,0,0,
            0,0,33,0,0,0,74,75,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,68,0,70,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            380,559,588,560,593,594,595,596,597,598,
            599,600,601,602,615,616,542,546,547,548,
            549,554,555,556,558,562,570,573,574,575,
            581,589,614,395,628,541,543,544,545,550,
            551,552,553,557,561,563,564,565,566,567,
            568,569,571,572,576,577,578,579,580,582,
            583,584,585,586,587,590,591,592,641,539,
            362,645,646,652,380,229,538,636,642,632,
            633,634,635,653,637,638,639,640,643,644,
            648,647,649,650,651,626,627,631,629,630,
            540,17,457,464,459,411,412,413,414,415,
            416,417,418,419,420,607,608,423,431,433,
            435,437,447,449,451,455,463,428,434,436,
            438,450,466,606,508,534,421,425,427,429,
            439,441,443,445,453,461,465,467,469,471,
            422,424,426,430,432,440,442,444,446,448,
            452,454,456,458,460,462,468,470,472,519,
            535,520,524,525,530,379,380,533,514,521,
            509,510,511,512,531,515,516,517,518,522,
            523,527,526,513,528,529,504,505,532,506,
            507,21,457,464,459,411,412,413,414,415,
            416,417,418,419,420,380,390,423,431,433,
            435,437,447,449,451,455,463,428,434,436,
            438,450,466,380,389,380,421,425,427,429,
            439,441,443,445,453,461,465,467,469,471,
            422,424,426,430,432,440,442,444,446,448,
            452,454,456,458,460,462,468,470,472,380,
            380,381,353,411,412,413,414,415,416,417,
            418,419,420,502,503,380,387,354,357,358,
            380,355,16,2,356,384,392,359,393,380,
            344,499,277,360,14,380,502,503,411,412,
            413,414,415,416,417,418,419,420,380,386,
            380,385,380,361,499,391,380,380,388,380,
            380,380,619,383,380,380,380,380,402,380,
            399,400,398,500,501,618,621,380,380,380,
            620,380,380,622,380,380,409,380,380,380,
            380,380,623,380,380,380,500,501,380,380,
            380,380,380,380,380,380,380,380,380,380,
            380,380,380,380,380,380,380,380,380,380,
            380,380,380,380,380,380,380,624,380,625
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
