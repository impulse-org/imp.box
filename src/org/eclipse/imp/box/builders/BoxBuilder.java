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

import java.io.PrintStream;
import java.io.StringBufferInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.box.Activator;
import org.eclipse.imp.box.interpreter.BoxInterpreter;
import org.eclipse.imp.box.parser.BoxParseController;
import org.eclipse.imp.box.parser.Ast.IBox;
import org.eclipse.imp.builder.BuilderBase;
import org.eclipse.imp.builder.BuilderUtils;
import org.eclipse.imp.builder.MarkerCreator;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.model.ISourceProject;
import org.eclipse.imp.model.ModelFactory;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.runtime.PluginBase;
import org.eclipse.ui.console.MessageConsoleStream;

public class BoxBuilder extends BuilderBase {
    public static final String BUILDER_ID= Activator.kPluginID + ".builder";

    public static final String PROBLEM_MARKER_ID= Activator.kPluginID + ".problem";

    public static final String LANGUAGE_NAME= "Box";

    public static final Language LANGUAGE= LanguageRegistry.findLanguage(LANGUAGE_NAME);

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
        IPath path= file.getRawLocation();
        if (path == null)
            return false;

        String pathString= path.toString();
        if (pathString.indexOf("/bin/") != -1)
            return false;

        return LANGUAGE.hasExtension(path.getFileExtension());
    }

    /**
     * @return true iff the given file is a source file that this builder should scan for dependencies, but not compile
     *         as a top-level compilation unit.<br>
     *         <code>isNonRootSourceFile()</code> and <code>isSourceFile()</code> should never return true for the same
     *         file.
     */
    protected boolean isNonRootSourceFile(IFile resource) {
        return false;
    }

    /**
     * Collects compilation-unit dependencies for the given file, and records them via calls to
     * <code>fDependency.addDependency()</code>.
     */
    protected void collectDependencies(IFile file) {
        return;
    }

    protected boolean isOutputFolder(IResource resource) {
        return resource.getFullPath().lastSegment().equals("bin");
    }

    protected String getConsoleName() {
        return "Box Console";
    }

    protected void compile(final IFile file, IProgressMonitor monitor) {
        IBox boxProg= parseAndCreateMarkers(file, monitor);

        if (boxProg != null) {
            try {
                BoxInterpreter bi= new BoxInterpreter();
                String result= bi.interpret(boxProg);

                MessageConsoleStream mcs= getConsoleStream();
                PrintStream ps= new PrintStream(mcs);

                mcs.getConsole().clearConsole();
                ps.println(result);

                IPath filePath= file.getFullPath();
                IPath outPath= filePath.removeFileExtension().addFileExtension("txt");
                IFile outFile= file.getWorkspace().getRoot().getFile(outPath);

                if (outFile.exists()) {
                    outFile.setContents(new StringBufferInputStream(result), true, false, monitor);
                } else {
                    outFile.create(new StringBufferInputStream(result), true, monitor);
//                FileOutputStream out= new FileOutputStream(outPath.toOSString());
//
//                out.write(result.getBytes());
//                out.close();
                }

                doRefresh(file.getParent());
            } catch (Exception e) {
                getPlugin().logException("Error while interpreting Box program", e);
            }
        }
    }

    protected IBox parseAndCreateMarkers(final IFile file, IProgressMonitor monitor) {
        // Parse the box program using the BoxParseController, and send the parser
        // messages to a MarkerCreator to produce resource markers.
        try {
            IParseController parseController= new BoxParseController();
            MarkerCreator markerCreator= new MarkerCreator(file, PROBLEM_MARKER_ID);
            ISourceProject sourceProject= ModelFactory.open(file.getProject());
            String contents= BuilderUtils.getFileContents(file);

            parseController.initialize(file.getProjectRelativePath(), sourceProject, markerCreator);

            return (IBox) parseController.parse(contents, monitor);
        } catch (Exception e) {
            getPlugin().logException("Exception encountered while parsing Box program", e);
        }
        return null;
    }
}
