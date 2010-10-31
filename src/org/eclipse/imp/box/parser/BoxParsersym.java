package org.eclipse.imp.box.parser;

public interface BoxParsersym {
    public final static int
      TK_NUMBER = 16,
      TK_RIGHTBRACKET = 17,
      TK_LEFTBRACKET = 18,
      TK_EQUAL = 6,
      TK_EOF_TOKEN = 19,
      TK_SINGLE_LINE_COMMENT = 24,
      TK_STRING = 7,
      TK_IDENT = 20,
      TK_H = 8,
      TK_V = 9,
      TK_HV = 10,
      TK_HOV = 11,
      TK_I = 12,
      TK_WD = 13,
      TK_G = 14,
      TK_SL = 15,
      TK_cs = 1,
      TK_gs = 21,
      TK_hs = 2,
      TK_is = 3,
      TK_op = 22,
      TK_sep = 23,
      TK_ts = 4,
      TK_vs = 5,
      TK_ERROR_TOKEN = 25;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "cs",
                 "hs",
                 "is",
                 "ts",
                 "vs",
                 "EQUAL",
                 "STRING",
                 "H",
                 "V",
                 "HV",
                 "HOV",
                 "I",
                 "WD",
                 "G",
                 "SL",
                 "NUMBER",
                 "RIGHTBRACKET",
                 "LEFTBRACKET",
                 "EOF_TOKEN",
                 "IDENT",
                 "gs",
                 "op",
                 "sep",
                 "SINGLE_LINE_COMMENT",
                 "ERROR_TOKEN"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
