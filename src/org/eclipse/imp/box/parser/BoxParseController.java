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
package org.eclipse.imp.box.parser;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.box.Activator;
import org.eclipse.imp.box.parser.Ast.ASTNode;
import org.eclipse.imp.parser.ILexer;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.IParser;
import org.eclipse.imp.parser.MessageHandlerAdapter;
import org.eclipse.imp.parser.SimpleLPGParseController;
import org.eclipse.imp.services.ILanguageSyntaxProperties;

public class BoxParseController extends SimpleLPGParseController implements IParseController {
	private BoxParser parser;

	private BoxLexer lexer;

	public BoxParseController() {
	    super(Activator.kLanguageName);
	}

	@Override
	public ILexer getLexer() {
	    return lexer;
	}

	@Override
	public IParser getParser() {
	    return parser;
	}

	public Object parse(String contents, IProgressMonitor monitor) {
		PMMonitor my_monitor = new PMMonitor(monitor);
		char[] contentsArray = contents.toCharArray();

		if (lexer == null) {
			lexer = new BoxLexer(contentsArray, fFilePath.toOSString());
		} else {
		    lexer.reset(contentsArray, fFilePath.toOSString());
		}
		
		if (parser == null) {
			parser = new BoxParser(lexer.getILexStream());
		} else {
		    parser.reset(lexer.getILexStream());
		}
		
		parser.getIPrsStream().setMessageHandler(new MessageHandlerAdapter(handler));

		lexer.lexer(my_monitor, parser.getIPrsStream()); // Lex the stream to produce the token stream
		if (my_monitor.isCancelled()) {
			return fCurrentAst; 
		}
		
		fCurrentAst = (ASTNode) parser.parser(my_monitor, 0);

		return fCurrentAst;
	}

	public ILanguageSyntaxProperties getSyntaxProperties() {
		// TODO Auto-generated method stub
		return null;
	}
}
