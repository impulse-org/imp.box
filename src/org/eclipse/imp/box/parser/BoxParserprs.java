package org.eclipse.imp.box.parser;

public class BoxParserprs implements lpg.runtime.ParseTable, BoxParsersym {
    public final static int ERROR_SYMBOL = 22;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 1;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 19;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 23;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 22;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 102;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 25;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 10;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 32;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 26;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 17;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 17;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 76;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 77;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return BoxParsersym.isValidForParser; }


    public interface IsNullable {
        public final static byte isNullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,1,0,0,1,0,1,1,0,
            0,0
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
            0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            1,4,0,2,2,2,2,2,2,1,
            0,2,0,2,1,1,1,1,3,1,
            1,0,2,3,3,-1,-5,0,-22,0,
            0,-12,0,0,0,-13,-2,0,0,-14,
            -3,0,0,-15,-4,0,0,-16,-17,0,
            0,0,0,0,-6,0,-7,0,-8,0,
            -9,0,-10,-11,-18,-23,-19,-20,0,-21,
            0,0,0,0,0
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static byte baseAction[] = {
            5,5,5,4,4,4,4,4,4,4,
            4,6,6,1,1,3,3,3,3,2,
            8,8,7,7,9,9,14,19,32,27,
            41,37,2,24,14,68,40,61,14,68,
            45,66,14,68,50,18,14,68,55,1,
            14,68,64,41,12,19,36,19,40,19,
            44,19,48,29,60,62,63,64,65,49,
            17,77,77,23,19,77,77
        };
    };
    public final static byte baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static byte lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,0,1,2,3,4,6,7,8,9,
            10,11,12,0,14,15,0,0,0,6,
            7,8,9,10,11,12,0,14,0,13,
            0,0,6,7,8,9,10,11,12,0,
            1,2,3,4,0,1,2,3,4,0,
            1,2,3,4,0,1,2,3,4,0,
            0,0,0,0,0,0,5,0,5,5,
            0,0,0,0,0,13,0,17,19,20,
            18,16,0,0,0,0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static byte termAction[] = {0,
            3,8,94,92,93,95,61,59,57,55,
            27,87,45,3,78,79,77,22,13,61,
            59,57,55,27,87,45,3,78,11,102,
            77,77,61,59,57,55,27,87,45,7,
            94,92,93,95,6,94,92,93,95,5,
            94,92,93,95,4,94,92,93,95,9,
            77,77,77,77,77,77,70,77,29,66,
            77,77,77,77,77,97,77,76,67,65,
            98,63
        };
    };
    public final static byte termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }

    public interface Asb {
        public final static byte asb[] = {0,
            23,20,18,16,1,1,1,1,1,22,
            16,1,1,1,1,1,22,33,33,33,
            36,9,35
        };
    };
    public final static byte asb[] = Asb.asb;
    public final int asb(int index) { return asb[index]; }

    public interface Asr {
        public final static byte asr[] = {0,
            16,1,2,3,19,20,4,0,6,7,
            8,9,10,12,11,19,20,16,0,17,
            0,15,16,6,7,8,9,10,12,11,
            14,0,5,0,18,13,0
        };
    };
    public final static byte asr[] = Asr.asr;
    public final int asr(int index) { return asr[index]; }

    public interface Nasb {
        public final static byte nasb[] = {0,
            1,8,8,9,4,4,4,4,4,11,
            13,6,6,6,6,6,1,8,8,8,
            8,2,15
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
            17,18,19,22,3,10,11,12,13,14,
            15,16,5,8,1,2,6,9,20,21,
            7,23
        };
    };
    public final static byte terminalIndex[] = TerminalIndex.terminalIndex;
    public final int terminalIndex(int index) { return terminalIndex[index]; }

    public interface NonterminalIndex {
        public final static byte nonterminalIndex[] = {0,
            0,25,26,0,24,0,0,27,28,0
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
            15
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
            28,16,26,0,15,0
        };
    };
    public final static byte scopeRhs[] = ScopeRhs.scopeRhs;
    public final int scopeRhs(int index) { return scopeRhs[index]; }

    public interface ScopeState {
        public final static byte scopeState[] = {0,
            49,26,0
        };
    };
    public final static byte scopeState[] = ScopeState.scopeState;
    public final int scopeState(int index) { return scopeState[index]; }

    public interface InSymb {
        public final static byte inSymb[] = {0,
            0,27,26,12,10,9,8,7,6,16,
            29,23,23,23,23,23,28,20,19,25,
            5,5,5
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
            "is",
            "vs",
            "hs",
            "op",
            "gs",
            "ts",
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
