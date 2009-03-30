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
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.MessageHandlerAdapter;
import org.eclipse.imp.parser.SimpleLPGParseController;
import org.eclipse.imp.services.ILanguageSyntaxProperties;

public class BoxParseController extends SimpleLPGParseController implements IParseController {
	public BoxParseController() {
	    super(Activator.kLanguageName);
	}

	public Object parse(String contents, IProgressMonitor monitor) {
		PMMonitor my_monitor = new PMMonitor(monitor);
		char[] contentsArray = contents.toCharArray();

		if (fLexer == null) {
			fLexer = new BoxLexer(contentsArray, fFilePath.toOSString());
		} else {
		    fLexer.reset(contentsArray, fFilePath.toOSString());
		}
		
		if (fParser == null) {
			fParser = new BoxParser(fLexer.getILexStream());
		} else {
		    fParser.reset(fLexer.getILexStream());
		}
		
		fParser.getIPrsStream().setMessageHandler(new MessageHandlerAdapter(handler));

		fLexer.lexer(my_monitor, fParser.getIPrsStream()); // Lex the stream to produce the token stream
		if (my_monitor.isCancelled()) {
			return fCurrentAst; 
		}
		
		fCurrentAst = (ASTNode) fParser.parser(my_monitor, 0);

		return fCurrentAst;
	}

	public ILanguageSyntaxProperties getSyntaxProperties() {
		// TODO Auto-generated method stub
		return null;
	}
}
