package org.eclipse.imp.box.parser;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.language.IAnnotationTypeInfo;
import org.eclipse.imp.language.ILanguageSyntaxProperties;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.parser.ILexer;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.IParser;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.parser.MessageHandlerAdapter;
import org.eclipse.imp.parser.SimpleLPGParseController;

public class BoxParseController extends SimpleLPGParseController implements IParseController {
	private BoxParser parser;

	private BoxLexer lexer;

        public BoxParseController() {
            lexer = new BoxLexer();
            parser = new BoxParser(lexer.getLexStream());
        }

	public void initialize(IPath filePath, ISourceProject project, IMessageHandler handler) {
		super.initialize(filePath, project, handler);
	}

	public IParser getParser() {
		return parser;
	}

	public ILexer getLexer() {
		return lexer;
	}

	public ISourcePositionLocator getNodeLocator() {
		return new BoxASTNodeLocator();
	} 

        public ILanguageSyntaxProperties getSyntaxProperties() {
            return null; // TODO provide an implementation
        }

        public Object parse(String contents, boolean scanOnly,
			IProgressMonitor monitor) {
		PMMonitor my_monitor = new PMMonitor(monitor);
		char[] contentsArray = contents.toCharArray();

		lexer.reset(contentsArray, fFilePath.toOSString());
		parser.reset(lexer.getLexStream());
		parser.getParseStream().setMessageHandler(new MessageHandlerAdapter(handler));

		lexer.lexer(my_monitor, parser.getParseStream()); // Lex the stream to produce the token stream
		if (my_monitor.isCancelled()) {
			return fCurrentAst; 
		}
		
		fCurrentAst = parser.parser(my_monitor, 0);

		return fCurrentAst;
	}
}
