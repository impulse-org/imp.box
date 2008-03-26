package org.eclipse.imp.box.builders;


public class BoxException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String boxString;

	public BoxException(String string, String boxString, Throwable cause) {
		super(string, cause);
		this.boxString = boxString;
	}

	public String getBoxString() {
		return boxString;
	}
}
