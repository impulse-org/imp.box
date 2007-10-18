package org.eclipse.imp.box.builders;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Calendar;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.imp.box.Activator;
import org.eclipse.imp.utils.StreamUtils;
import org.osgi.framework.Bundle;

public class BoxFactory {
	private static String BoxParsetablePath;

	/**
	 * The external tools called by this class need some files that are
	 * stored in the plugin bundle. 
	 */
	static {
		Bundle bundle = Platform.getBundle(Activator.kPluginID);
		URL url = bundle.getResource("Box.tbl");
		try {
			BoxParsetablePath = new File(FileLocator.toFileURL(url).getPath()).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This methods calls external tools to execute the formatting of a box term.
	 * The term is parsed and then processed to finally result in a formatted text.
	 * TODO: this implementation may be slow due to the calling of external tools,
	 * also the tools are required to be on the search path are: "sglr" and "pandora".
	 * This is obviously only going to work on Un*x platforms like this. 
	 * 
	 * @param box
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static String box2text(String box) throws IOException, InterruptedException {
		return formatBox(parseBox(box));
	}
	
	private static String formatBox(String boxTree) throws IOException, InterruptedException {
		String command2 = "pandora";
		Process formatter = Runtime.getRuntime().exec(command2);
		formatter.getOutputStream().write(boxTree.getBytes());
		formatter.getOutputStream().close();
		formatter.waitFor();
		
		if (formatter.exitValue() != 0) {
			throw new RuntimeException("Box formatter failed with exit value: " + formatter.exitValue());
		}
		
		String output = StreamUtils.readStreamContents(new BufferedInputStream(formatter.getInputStream()));
		
		return output;
	}

	private static String parseBox(String boxString) throws IOException, InterruptedException {
		String command = "sglr -t -p " + BoxParsetablePath;
		Process parser = Runtime.getRuntime().exec(command);
		parser.getOutputStream().write(boxString.getBytes());
		parser.getOutputStream().close();
		
		String output = StreamUtils.readStreamContents(new BufferedInputStream(parser.getInputStream()));
		
		parser.waitFor();
		if (parser.exitValue() != 0) {
			throw new RuntimeException("Box parser failed with exit value:" + parser.exitValue());
		}
		
		return output;
	}
	
	/** 
	 * This box2text() implementation is faster for larger terms since
	 * it makes sure that communication between sglr and pandora is done
	 * using binary shared ATerms instead of the unshared representation
	 * used in box2text(). 
	 * 
	 * @param boxString
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	public static String fastbox2text(String boxString) throws IOException,
			InterruptedException {
		String sglr = "sglr -p " + BoxParsetablePath;
		Process parser = Runtime.getRuntime().exec(sglr);
		String pandora = "pandora";
		Process formatter = Runtime.getRuntime().exec(pandora);

		parser.getOutputStream().write(boxString.getBytes());
		parser.getOutputStream().close();
		parser.waitFor();

		pipe(parser.getInputStream(), formatter.getOutputStream());
		formatter.getOutputStream().close();
		parser.getOutputStream().close(); 
		formatter.waitFor();

		String result = StreamUtils.readStreamContents(formatter
				.getInputStream());
		formatter.getInputStream().close(); 

		if (parser.exitValue() != 0) {
			throw new RuntimeException("Box parser failed with exit value:"
					+ parser.exitValue());
		}

		if (formatter.exitValue() != 0) {
			throw new RuntimeException("Box formatter failed with exit value: "
					+ formatter.exitValue());
		}
		
		return result;
	}
	
	/**
	 * A helper method that pipes an inputstream to an output stream using
	 * a small intermediate buffer.
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	private static void pipe(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[8192];
		int count;
		while ((count = in.read(buffer)) >= 0) {
			out.write(buffer, 0, count);
		}
	}
}
