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
