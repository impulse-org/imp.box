package org.eclipse.imp.box.builders;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.imp.box.Activator;
import org.eclipse.imp.box.parser.BoxParseController;
import org.eclipse.imp.builder.BuilderBase;
import org.eclipse.imp.builder.BuilderUtils;
import org.eclipse.imp.builder.MarkerCreator;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.model.ModelFactory;
import org.eclipse.imp.model.ModelFactory.ModelException;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.runtime.PluginBase;
import org.osgi.framework.Bundle;

/**
 * @author
 */
public class BoxBuilder extends BuilderBase {
	public static final String BUILDER_ID = Activator.kPluginID
			+ ".builder";

	public static final String PROBLEM_MARKER_ID = Activator.kPluginID
			+ ".problem";

	public static final String LANGUAGE_NAME = "Box";

	public static final Language LANGUAGE = LanguageRegistry
			.findLanguage(LANGUAGE_NAME);

	public static final String[] EXTENSIONS = LANGUAGE.getFilenameExtensions();
	
	static {
		Bundle bundle = Platform.getBundle(Activator.kPluginID);
		URL url = bundle.getResource("Box.tbl");
		try {
			BoxParsetablePath = new File(FileLocator.toFileURL(url).getPath()).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected static String BoxParsetablePath;

	protected PluginBase getPlugin() {
		return Activator.getInstance();
	}

	protected String getErrorMarkerID() {
		return PROBLEM_MARKER_ID;
	}

	protected String getWarningMarkerID() {
		return PROBLEM_MARKER_ID;
	}

	protected String getInfoMarkerID() {
		return PROBLEM_MARKER_ID;
	}

	protected boolean isSourceFile(IFile file) {
		IPath path = file.getRawLocation();
		if (path == null)
			return false;

		String pathString = path.toString();
		if (pathString.indexOf("/bin/") != -1)
			return false;

		for (int i = 0; i < EXTENSIONS.length; i++) {
			if (EXTENSIONS[i].equals(path.getFileExtension()))
				return true;
		}
		return false;
	}

	/**
	 * @return true iff the given file is a source file that this builder should scan
	 * for dependencies, but not compile as a top-level compilation unit.<br>
	 * <code>isNonRootSourceFile()</code> and <code>isSourceFile()</code> should never
	 * return true for the same file.
	 */
	protected boolean isNonRootSourceFile(IFile resource) {
		return false;
	}

	/**
	 * Collects compilation-unit dependencies for the given file, and records
	 * them via calls to <code>fDependency.addDependency()</code>.
	 */
	protected void collectDependencies(IFile file) {
		return;
	}

	protected boolean isOutputFolder(IResource resource) {
		return resource.getFullPath().lastSegment().equals("bin");
	}

	protected void compile(final IFile file, IProgressMonitor monitor) {
		try {
			runParserForCompiler(file, monitor);
			doRefresh(file.getParent());
			
			String absPath = file.getLocation().toOSString();
			String temp = tempName().getAbsolutePath();
			
			parseBox(absPath, temp);
			formatBox(temp, absPath + ".fmt");
	
			doRefresh(file);
		} catch (Exception e) {
			System.err.println(e.getMessage());

			e.printStackTrace();
		}
	}

	private void formatBox(String input, String output) throws IOException, InterruptedException {
		String command2 = "pandora -i " + input + " -o "+ output;
		Process formatter = Runtime.getRuntime().exec(command2);
		formatter.waitFor();
		
		if (formatter.exitValue() != 0) {
			throw new RuntimeException("Box formatter failed with exit value: " + formatter.exitValue());
		}
	}

	private void parseBox(String input, String output) throws IOException, InterruptedException {
		String command = "sglr -i " + input + " -p " + BoxParsetablePath + " -o " + output;
		Process parser = Runtime.getRuntime().exec(command);
		parser.waitFor();
		
		if (parser.exitValue() != 0) {
			throw new RuntimeException("Box parser failed with exit value:" + parser.exitValue());
		}
	}

	File tempName() {
		try {
	        File temp = File.createTempFile("temp", ".pt");
	        temp.deleteOnExit();
	    
	    
	        return temp;
	    } catch (IOException e) {
	    	System.err.println("Could not generate tempfile.");
	    	return null;
	    }
	}
	
	protected void runParserForCompiler(final IFile file,
			IProgressMonitor monitor) {
		try {
			// Parse controller is the "compiler" here; parses and reports errors
			IParseController parseController = new BoxParseController();

			// Marker creator handles error messages from the parse controller (and
			// uses the parse controller to get additional information about the errors)
			MarkerCreator markerCreator = new MarkerCreator(file,
					parseController, PROBLEM_MARKER_ID);

			// If we have a kind of parser that might be receptive, tell it
			// what types of problem marker the builder will create
			parseController.addProblemMarkerType(getErrorMarkerID());

			// Need to tell the parse controller which file in which project to parse
			// and also the message handler to which to report errors
			IProject project = file.getProject();
			ISourceProject sourceProject = null;
			try {
				sourceProject = ModelFactory.open(project);
			} catch (ModelException me) {
				System.err
						.println("BoxParseController.runParserForComplier(..):  Model exception:\n"
								+ me.getMessage()
								+ "\nReturning without parsing");
				return;
			}
			parseController.initialize(file.getProjectRelativePath(),
					sourceProject, markerCreator);

			String contents = BuilderUtils.getFileContents(file);

			// Finally parse it
			parseController.parse(contents, false, monitor);

			doRefresh(file.getParent());
		} catch (Exception e) {
			getPlugin().writeErrorMsg(e.getMessage());
			e.printStackTrace();
		}
	}
}
