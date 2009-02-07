package org.eclipse.imp.box.parser;

public interface BoxParsersym {
    public final static int
      TK_NUMBER = 13,
      TK_RIGHTBRACKET = 15,
      TK_LEFTBRACKET = 16,
      TK_EQUAL = 5,
      TK_EOF_TOKEN = 17,
      TK_SINGLE_LINE_COMMENT = 21,
      TK_STRING = 14,
      TK_IDENT = 18,
      TK_H = 6,
      TK_V = 7,
      TK_HV = 8,
      TK_HOV = 9,
      TK_I = 10,
      TK_WD = 11,
      TK_G = 12,
      TK_is = 1,
      TK_vs = 2,
      TK_hs = 3,
      TK_op = 19,
      TK_gs = 20,
      TK_ts = 4,
      TK_ERROR_TOKEN = 22;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "is",
                 "vs",
                 "hs",
                 "ts",
                 "EQUAL",
                 "H",
                 "V",
                 "HV",
                 "HOV",
                 "I",
                 "WD",
                 "G",
                 "NUMBER",
                 "STRING",
                 "RIGHTBRACKET",
                 "LEFTBRACKET",
                 "EOF_TOKEN",
                 "IDENT",
                 "op",
                 "gs",
                 "SINGLE_LINE_COMMENT",
                 "ERROR_TOKEN"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
