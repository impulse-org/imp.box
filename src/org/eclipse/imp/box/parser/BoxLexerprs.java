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

    public final static int NUM_STATES = 23;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 102;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 663;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 278;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 45;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 147;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 347;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 101;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 103;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 384;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 385;
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
            1,1,1,3,2,2,1,2,2,2,
            2,2,2,3,2,2,1,3,1,1,
            1,1,1,1,1,2,2,1,2,1,
            2,2,2,1,1,1,1,1,1,1,
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
            1,0,2,1,1,1,1,1,1,1,
            1,1,2,2,2,2,2,2,2,2,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1
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
            30,30,30,30,30,35,35,35,31,31,
            33,33,34,34,1,1,1,1,1,1,
            1,1,1,1,4,4,5,5,6,6,
            7,7,8,8,9,9,10,10,11,11,
            12,12,13,13,14,14,15,15,16,16,
            17,17,18,18,19,19,20,20,21,21,
            22,22,23,23,24,24,25,25,26,26,
            27,27,28,28,29,29,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,3,3,3,3,3,37,37,37,
            37,37,37,37,37,37,37,37,37,37,
            37,37,37,37,37,37,37,37,37,37,
            37,37,37,37,37,37,37,37,37,38,
            38,38,38,38,39,39,39,39,39,39,
            39,39,39,39,39,39,39,39,39,39,
            39,39,39,39,39,39,39,39,39,39,
            40,40,40,40,40,40,40,40,40,40,
            40,40,40,40,40,40,40,40,40,40,
            40,40,40,40,40,40,41,41,41,41,
            41,41,41,41,41,41,36,36,36,36,
            36,36,32,32,42,42,42,42,42,42,
            42,42,42,44,44,44,44,44,44,44,
            44,43,43,43,43,43,43,43,43,43,
            43,43,43,43,43,43,43,43,43,43,
            43,43,43,43,43,43,43,43,43,102,
            227,226,142,96,97,98,99,100,101,102,
            103,104,105,106,107,108,109,110,111,112,
            113,114,115,116,117,118,119,120,121,300,
            313,29,31,1,313,33,228,202,27,26,
            141,96,97,98,99,100,101,102,103,104,
            105,106,107,108,109,110,111,112,113,114,
            115,116,117,118,119,120,121,272,28,217,
            30,234,159,160,235,233,236,242,238,314,
            289,240,304,337,341,328,317,296,332,350,
            352,331,385,385,385,385,385,320,310,385,
            309,279,317,385,385
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
            29,30,31,32,33,34,35,36,37,38,
            0,0,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,70,71,72,73,74,75,76,77,78,
            79,80,81,82,83,84,85,86,87,88,
            89,90,91,92,93,94,95,96,97,98,
            99,0,1,2,3,4,5,6,7,8,
            9,10,11,12,13,14,0,1,17,18,
            19,20,21,22,23,24,25,26,27,28,
            29,30,31,32,33,34,35,0,1,0,
            1,101,41,42,43,44,45,46,47,48,
            49,50,51,52,53,54,55,56,57,58,
            59,60,61,62,63,64,65,66,67,68,
            69,0,1,2,0,4,5,6,7,8,
            9,10,11,12,13,14,15,16,0,18,
            0,3,21,22,23,0,25,2,27,0,
            29,30,31,0,1,34,35,36,37,38,
            39,40,0,0,15,16,0,5,6,7,
            8,9,10,11,12,13,14,0,33,0,
            0,0,19,0,4,36,0,1,39,40,
            0,1,71,0,73,74,75,17,32,0,
            20,0,3,2,24,28,26,0,0,0,
            0,0,0,0,0,0,0,37,0,38,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            70,0,72,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
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
            385,567,596,564,568,601,602,603,604,605,
            606,607,608,609,610,623,624,550,551,553,
            554,555,556,557,562,563,566,570,578,581,
            582,583,586,589,593,597,622,403,638,625,
            626,549,552,558,559,560,561,565,569,571,
            572,573,574,575,576,577,579,580,584,585,
            587,588,590,591,592,594,595,598,599,600,
            651,547,371,655,656,662,546,646,652,642,
            643,644,645,663,647,648,649,650,653,654,
            658,657,659,660,661,636,637,641,639,640,
            548,20,465,472,459,467,419,420,421,422,
            423,424,425,426,427,428,615,616,431,433,
            437,439,441,443,445,455,457,463,471,436,
            442,444,446,452,458,466,474,614,516,542,
            385,232,429,435,447,449,451,453,461,469,
            473,475,477,479,430,432,434,438,440,448,
            450,454,456,460,462,464,468,470,476,478,
            480,527,543,528,532,533,538,541,522,529,
            517,518,519,520,539,523,524,525,526,530,
            531,535,534,521,536,537,512,513,540,514,
            515,24,465,472,459,467,419,420,421,422,
            423,424,425,426,427,428,385,401,431,433,
            437,439,441,443,445,455,457,463,471,436,
            442,444,446,452,458,466,474,385,400,385,
            397,384,429,435,447,449,451,453,461,469,
            473,475,477,479,430,432,434,438,440,448,
            450,454,456,460,462,464,468,470,476,478,
            480,385,359,392,385,358,419,420,421,422,
            423,424,425,426,427,428,510,511,385,364,
            385,398,363,362,361,3,360,390,349,19,
            386,367,387,385,396,366,365,507,282,368,
            508,509,17,385,510,511,385,419,420,421,
            422,423,424,425,426,427,428,385,370,385,
            385,385,369,385,629,507,385,395,508,509,
            385,394,410,385,407,408,406,628,391,385,
            631,385,399,389,630,393,632,385,385,385,
            385,385,385,385,385,385,385,633,385,417,
            385,385,385,385,385,385,385,385,385,385,
            385,385,385,385,385,385,385,385,385,385,
            385,385,385,385,385,385,385,385,385,385,
            634,385,635
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
