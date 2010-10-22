/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
 *******************************************************************************/
package org.eclipse.imp.box.interpreter;

import org.eclipse.imp.box.parser.BoxParseController;
import org.eclipse.imp.box.parser.Ast.IBox;
import org.eclipse.imp.utils.SystemOutErrMessageHandler;

/**
 * @author rfuhrer
 */
public class BoxInterpreterTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Don't bother creating the box program as a string, just create a Box AST
        // Turning everything into a String causes ambiguity in emitOp() below -- it
        // can't assume that "H hs =" isn't a valid fragment in the target language.
        runTest(V(2, H(5, H(2, "public", "static", "def", "main(Array[String])"), "{"),
                     I(8, "Console.OUT.println(Hello, World!);"),
                     "}"),
                80);
        runTest(V( H("public", "def", H(0, "foo(", HV( "x: int,", "y:int,", "sa: Array[String]"), ")"), "{"),
                        I("Console.OUT.println(Hello, World!);"),
                        "}"),
                20);

        runTest(HOV("abcd", "abcd", "abcd", "abcd", "abcd", "abcd"),
                20);
        runTest(HOV("abcd", "abcd", "abcd"),
                20);
    }

    private static void runTest(String boxString, int width) {
        System.out.println(boxString);
        BoxInterpreter bi= new BoxInterpreter(width, true, 4);
        IBox boxPrg= parseBox(boxString);
        String result= bi.interpret(boxPrg);

        System.out.println(result);
    }

    private static IBox parseBox(String boxString) {
        BoxParseController bpc= new BoxParseController(true);
        bpc.initialize(null, null, new SystemOutErrMessageHandler());
        IBox box= (IBox) bpc.parse(boxString, null);
        return box;
    }

    public static String H(String... args) {
        return emitOp("H", null, args);
    }

    public static String H(int horizSpace, String... args) {
        return emitOp("H", "hs=" + horizSpace, args);
    }

    public static String V(String... args) {
        return emitOp("V", null, args);
    }

    public static String V(int vertSpace, String... args) {
        return emitOp("V", "vs=" + vertSpace, args);
    }

    public static String I(String... args) {
        return emitOp("I", null, args);
    }

    public static String I(int indent, String... args) {
        return emitOp("I", "is=" + indent, args);
    }

    public static String HV(String... args) {
        return emitOp("HV", null, args);
    }

    public static String HV(int horizSpace, int vertSpace, String... args) {
        return emitOp("HV", "hs=" + horizSpace + " vs=" + vertSpace, args);
    }

    public static String HOV(String... args) {
        return emitOp("HOV", null, args);
    }

    public static String HOV(int horizSpace, int vertSpace, String... args) {
        return emitOp("HOV", "hs=" + horizSpace + " vs=" + vertSpace, args);
    }

    private static String emitOp(String operator, String options, String[] args) {
        StringBuffer sb= new StringBuffer();
        sb.append(operator);
        if (options != null) {
            sb.append(' ');
            sb.append(options);
            sb.append(' ');
        }
        sb.append("[ ");
        for(String arg: args) {
            boolean isLiteralArg= !(arg.startsWith("H[") || arg.startsWith("H hs=") || arg.startsWith("V[") || arg.startsWith("V vs=") ||
                                    arg.startsWith("I[") || arg.startsWith("I is=") || arg.startsWith("HV[") || arg.startsWith("HV hs=") ||
                                    arg.startsWith("HOV[") || arg.startsWith("HOV hs="));
            String escapedArg= arg;
            if (isLiteralArg) {
                sb.append("\"");
                escapedArg= arg.replace("\"", "\\\""); // only escape once, at the literal leaf nodes
            }
            sb.append(escapedArg);
            if (isLiteralArg) {
                sb.append("\"");
            }
            sb.append(' ');
        }
        sb.append("]");
        return sb.toString();
    }
}
