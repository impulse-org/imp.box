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

import org.eclipse.imp.box.Activator;
import org.eclipse.imp.box.parser.Ast.IBox;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.SimpleLPGParseController;
import org.eclipse.imp.services.ILanguageSyntaxProperties;
import org.eclipse.imp.services.base.LanguageSyntaxPropertiesBase;
import org.eclipse.imp.utils.SystemOutErrMessageHandler;

public class BoxParseController extends SimpleLPGParseController implements IParseController {
    public BoxParseController() {
        super(Activator.kLanguageName);
        fLexer= new BoxLexer();
        fParser= new BoxParser();
    }

    public BoxParseController(boolean standalone) {
        super();
        fLexer= new BoxLexer();
        fParser= new BoxParser();
    }

    public ILanguageSyntaxProperties getSyntaxProperties() {
        return new LanguageSyntaxPropertiesBase() {
            public String getSingleLineCommentPrefix() {
                return "";
            }

            public String getBlockCommentStart() {
                return null;
            }

            public String getBlockCommentContinuation() {
                return null;
            }

            public String getBlockCommentEnd() {
                return null;
            } };
    }

    public static IBox parseBox(String boxString) {
        return parseBox(boxString, new SystemOutErrMessageHandler());
    }

    public static IBox parseBox(String boxString, IMessageHandler msgHandler) {
        BoxParseController bpc= new BoxParseController(true);
        bpc.initialize(null, null, msgHandler);
        IBox box= (IBox) bpc.parse(boxString, null);
        return box;
    }
}
