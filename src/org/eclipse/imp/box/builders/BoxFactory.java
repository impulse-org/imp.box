package org.eclipse.imp.box.builders;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.imp.box.Activator;
import org.eclipse.imp.utils.StreamUtils;
import org.osgi.framework.Bundle;

public class BoxFactory {
	private static String BoxParsetablePath;

	static {
		Bundle bundle = Platform.getBundle(Activator.kPluginID);
		URL url = bundle.getResource("Box.tbl");
		try {
			BoxParsetablePath = new File(FileLocator.toFileURL(url).getPath()).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String box2text(String box) throws IOException, InterruptedException {
		System.err.println("box =" + box);
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
		
		
		System.err.println("tree " + output);
		return output;
	}
}
