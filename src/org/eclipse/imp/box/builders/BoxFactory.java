/*******************************************************************************
* Copyright (c) 2008 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Jurgen Vinju (jurgen@vinju.org) - initial API and implementation
*******************************************************************************/
package org.eclipse.imp.box.builders;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.imp.box.Activator;
import org.eclipse.imp.box.interpreter.BoxInterpreter;
import org.eclipse.imp.box.parser.BoxParseController;
import org.eclipse.imp.box.parser.Ast.AbstractVisitor;
import org.eclipse.imp.box.parser.Ast.Box__STRING;
import org.eclipse.imp.box.parser.Ast.IBox;
import org.eclipse.imp.box.parser.Ast.Visitor;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.utils.NullMessageHandler;
import org.osgi.framework.Bundle;
import org.syntax_definition.sdf.Tools;
       
public class BoxFactory {
	private static String BoxParsetablePath;

	private static String BoxParsetablePathReflexive;

	/**
	 * The external tools called by this class need some files that are stored
	 * in the plugin bundle.
	 */
	static {
		Bundle bundle = Platform.getBundle(Activator.kPluginID);
		URL url = bundle.getResource("resources/Box.tbl");
		URL urlReflexive = bundle.getResource("resources/Box.trm.tbl");

		try {
			BoxParsetablePath = new File(FileLocator.toFileURL(url).getPath()).toString();
			BoxParsetablePathReflexive = new File(FileLocator.toFileURL(urlReflexive).getPath()).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method does not format the box text. Instead it just returns and
	 * unquotes and unescapes all the literals of the term.
	 * 
	 * @param boxString
	 * @return An unformatted string
	 */
	public static String extractText(IBox boxAst) {
		if (boxAst != null) {
			Visitor v = new AbstractVisitor() {
				private StringBuffer buffer = new StringBuffer();

				public void unimplementedVisitor(String s) { }

				public boolean visit(Box__STRING n) {
					String lit = n.toString();

					buffer.append(unquote(lit));
					buffer.append(' ');
					return true;
				}

				private String unquote(String lit) {
					if (lit.length() > 2) {
						return lit.substring(1, lit.length() - 1).replaceAll(
								"\\n", "\n").replaceAll("\\t", "\t");
					} else {
						return "";
					}
				}

				public String toString() {
					return buffer.toString();
				}
			};

			boxAst.accept(v);
			return v.toString();
		} else {
			return null;
		}
	}

	/**
     * Formats a Box term. The term is parsed and then interpreted to produce
     * formatted text.
     * @deprecated Because this method takes a Box term as a String, it must be
     * parsed before being interpreted, which is probably unnecessary. It would be
     * much better to translate the target language AST directly into an IBox structure,
     * which can be interpreted directly.
	 */
    @Deprecated
    public static String box2Text(String boxString) {
        return box2Text(boxString, new NullMessageHandler());
    }

    /**
	 * Formats a Box term. The term is parsed and then interpreted to produce
     * formatted text.
	 * @deprecated Because this method takes a Box term as a String, it must be
	 * parsed before being interpreted, which is probably unnecessary. It would be
	 * much better to translate the target language AST directly into an IBox structure,
	 * which can be interpreted directly.
	 */
	@Deprecated
	public static String box2Text(String boxString, IMessageHandler msgHandler) {
	    msgHandler.clearMessages();

	    IBox box= BoxParseController.parseBox(boxString, msgHandler);

	    msgHandler.endMessages();

	    BoxInterpreter bi = new BoxInterpreter();

        return bi.interpret(box);
	}

	/**
	 * This methods calls external tools to execute the formatting of a box
	 * term. The term is parsed and then processed to finally result in a
	 * formatted text. TODO: this implementation may be slow due to the calling
	 * of external tools, also the tools are required to be on the search path
	 * are: "sglr" and "pandora". This is obviously only going to work on Un*x
	 * platforms like this.
	 * 
	 * @param box
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @deprecated
	 */
	@Deprecated
	public static String box2textSDF(String boxString) throws BoxException {
	    // RMF 2/20/2008 -t in the following puts sglr in text output mode,
	    // which is currently required for this to work on Windows.
		String sglr = "sglr -p " + BoxParsetablePath;
		String pandora = "pandora";

		try {
			InputStream input = Tools.cat(boxString);
			InputStream output = Tools.pipeline(new String[] { sglr, pandora }, input);
			return Tools.uncat(output);
		} catch (IOException e) {
			throw new BoxException("IOException while formatting", boxString, e);
		} catch (InterruptedException e) {
			throw new BoxException("Formatting was interrupted", boxString, e);
		}
	}

	public static String formatBox(String boxString) throws IOException, InterruptedException {
	    return boxString; // Don't bother formatting it, for now - we don't have a pure Java Box formatter yet
	}

	/**
	 * RMF 1 Nov 2010 - I'm guessing this formats a Box source program using some
	 * predefined Box formatting rules.
	 * @deprecated
	 */
	@Deprecated
	public static String formatBoxSDF(String boxString) throws IOException, InterruptedException {
		String sglr = "sglr -p " + BoxParsetablePathReflexive;
		String boxFormat = "BoxFormatter";
		String pandora = "pandora";

		InputStream input = Tools.cat(boxString);
		InputStream output = Tools.pipeline(new String[] { sglr, boxFormat, pandora }, input);

		return Tools.uncat(output);
	}
}
