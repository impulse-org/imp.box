package org.eclipse.imp.box.parser;

public class BoxParserprs implements lpg.runtime.ParseTable, BoxParsersym {
    public final static int ERROR_SYMBOL = 25;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 1;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 19;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 28;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 25;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 112;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 27;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 10;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 35;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 28;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 19;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 19;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 84;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 85;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return BoxParsersym.isValidForParser; }


    public interface IsNullable {
        public final static byte isNullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,1,0,0,1,0,
            1,1,0,0,0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            5,7,8,3,2,4,6,9,10,1
        };
    };
    public final static byte prosthesesIndex[] = ProsthesesIndex.prosthesesIndex;
    public final int prosthesesIndex(int index) { return prosthesesIndex[index]; }

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            1,4,0,2,2,2,2,2,2,5,
            1,0,2,0,2,1,1,1,1,1,
            3,1,1,0,2,3,3,-1,-6,0,
            -26,0,0,-14,0,0,0,-15,-2,0,
            0,-16,-3,0,0,-17,-5,0,0,-18,
            -19,0,0,0,0,0,-28,-4,0,0,
            -7,0,-8,0,-9,0,-10,0,-11,-13,
            -24,0,-27,-12,0,-20,-21,-22,0,-23,
            0,-25,0
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static byte baseAction[] = {
            5,5,5,4,4,4,4,4,4,4,
            4,4,6,6,1,1,3,3,3,3,
            3,2,8,8,7,7,9,9,17,20,
            34,33,43,39,2,26,15,80,34,21,
            15,80,49,75,15,80,55,19,15,80,
            61,1,15,80,70,43,13,67,74,15,
            80,20,38,20,42,20,46,20,50,22,
            73,20,57,76,77,51,78,80,81,25,
            82,21,84,85,85
        };
    };
    public final static byte baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static byte lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,0,1,2,3,4,5,7,8,9,
            10,11,12,13,14,15,0,17,0,0,
            0,0,0,7,8,9,10,11,12,13,
            14,15,0,0,1,2,3,4,5,19,
            8,9,10,11,12,13,14,15,0,1,
            2,3,4,5,0,1,2,3,4,5,
            0,1,2,3,4,5,0,1,2,3,
            4,5,0,0,0,0,0,0,0,0,
            0,0,6,0,7,6,6,6,0,0,
            0,16,18,21,22,20,23,0,0,16,
            0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static byte termAction[] = {0,
            3,8,101,102,103,104,105,86,67,65,
            63,61,29,96,47,58,3,87,24,14,
            85,12,85,86,67,65,63,61,29,96,
            47,58,3,7,101,102,103,104,105,84,
            67,65,63,61,29,96,47,58,6,101,
            102,103,104,105,5,101,102,103,104,105,
            4,101,102,103,104,105,10,101,102,103,
            104,105,9,85,85,85,85,85,85,85,
            85,85,76,85,71,82,31,73,85,85,
            85,107,69,77,78,108,74,85,85,112
        };
    };
    public final static byte termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }

    public interface Asb {
        public final static byte asb[] = {0,
            27,22,20,24,18,1,1,1,1,1,
            26,41,18,1,1,1,1,1,26,36,
            41,41,41,1,39,10,38,1
        };
    };
    public final static byte asb[] = Asb.asb;
    public final int asb(int index) { return asb[index]; }

    public interface Asr {
        public final static byte asr[] = {0,
            18,1,21,2,3,22,4,5,0,8,
            9,10,11,12,14,15,13,21,22,18,
            0,19,0,23,0,17,18,8,9,10,
            11,12,14,15,13,7,0,20,16,0,
            6,0
        };
    };
    public final static byte asr[] = Asr.asr;
    public final int asr(int index) { return asr[index]; }

    public interface Nasb {
        public final static byte nasb[] = {0,
            1,8,8,8,9,4,4,4,4,4,
            11,8,13,6,6,6,6,6,1,8,
            8,8,8,4,8,2,15,6
        };
    };
    public final static byte nasb[] = Nasb.nasb;
    public final int nasb(int index) { return nasb[index]; }

    public interface Nasr {
        public final static byte nasr[] = {0,
            5,4,0,1,0,3,2,0,7,0,
            6,0,9,0,8,0
        };
    };
    public final static byte nasr[] = Nasr.nasr;
    public final int nasr(int index) { return nasr[index]; }

    public interface TerminalIndex {
        public final static byte terminalIndex[] = {0,
            18,20,21,24,25,3,8,10,11,12,
            13,14,15,16,17,5,1,2,6,9,
            19,22,23,7,26
        };
    };
    public final static byte terminalIndex[] = TerminalIndex.terminalIndex;
    public final int terminalIndex(int index) { return terminalIndex[index]; }

    public interface NonterminalIndex {
        public final static byte nonterminalIndex[] = {0,
            0,28,29,0,27,0,0,30,31,0
        };
    };
    public final static byte nonterminalIndex[] = NonterminalIndex.nonterminalIndex;
    public final int nonterminalIndex(int index) { return nonterminalIndex[index]; }

    public interface ScopePrefix {
        public final static byte scopePrefix[] = {
            1
        };
    };
    public final static byte scopePrefix[] = ScopePrefix.scopePrefix;
    public final int scopePrefix(int index) { return scopePrefix[index]; }

    public interface ScopeSuffix {
        public final static byte scopeSuffix[] = {
            5
        };
    };
    public final static byte scopeSuffix[] = ScopeSuffix.scopeSuffix;
    public final int scopeSuffix(int index) { return scopeSuffix[index]; }

    public interface ScopeLhs {
        public final static byte scopeLhs[] = {
            5
        };
    };
    public final static byte scopeLhs[] = ScopeLhs.scopeLhs;
    public final int scopeLhs(int index) { return scopeLhs[index]; }

    public interface ScopeLa {
        public final static byte scopeLa[] = {
            17
        };
    };
    public final static byte scopeLa[] = ScopeLa.scopeLa;
    public final int scopeLa(int index) { return scopeLa[index]; }

    public interface ScopeStateSet {
        public final static byte scopeStateSet[] = {
            1
        };
    };
    public final static byte scopeStateSet[] = ScopeStateSet.scopeStateSet;
    public final int scopeStateSet(int index) { return scopeStateSet[index]; }

    public interface ScopeRhs {
        public final static byte scopeRhs[] = {0,
            31,18,29,0,17,0
        };
    };
    public final static byte scopeRhs[] = ScopeRhs.scopeRhs;
    public final int scopeRhs(int index) { return scopeRhs[index]; }

    public interface ScopeState {
        public final static byte scopeState[] = {0,
            51,28,0
        };
    };
    public final static byte scopeState[] = ScopeState.scopeState;
    public final int scopeState(int index) { return scopeState[index]; }

    public interface InSymb {
        public final static byte inSymb[] = {0,
            0,30,29,15,14,12,11,10,9,8,
            18,23,32,26,26,26,26,26,31,6,
            21,22,28,7,6,6,6,26
        };
    };
    public final static byte inSymb[] = InSymb.inSymb;
    public final int inSymb(int index) { return inSymb[index]; }

    public interface Name {
        public final static String name[] = {
            "",
            "]",
            "[",
            "=",
            "$empty",
            "NUMBER",
            "EOF_TOKEN",
            "SINGLE_LINE_COMMENT",
            "STRING",
            "IDENT",
            "H",
            "V",
            "HV",
            "HOV",
            "I",
            "WD",
            "G",
            "SL",
            "cs",
            "gs",
            "hs",
            "is",
            "op",
            "sep",
            "ts",
            "vs",
            "ERROR_TOKEN",
            "Box",
            "SpaceOption",
            "SpaceSymbol",
            "SpaceValue",
            "GroupOption"
        };
    };
    public final static String name[] = Name.name;
    public final String name(int index) { return name[index]; }

    public final int originalState(int state) {
        return -baseCheck[state];
    }
    public final int asi(int state) {
        return asb[originalState(state)];
    }
    public final int nasi(int state) {
        return nasb[originalState(state)];
    }
    public final int inSymbol(int state) {
        return inSymb[originalState(state)];
    }

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
