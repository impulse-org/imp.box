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
package org.eclipse.imp.box;

import org.eclipse.imp.runtime.PluginBase;
import org.osgi.framework.BundleContext;

public class Activator extends PluginBase {
	public static final String kPluginID = "org.eclipse.imp.box";

	public static final String kLanguageName = "Box";

	protected static Activator sPlugin;

	public static Activator getInstance() {
		if (sPlugin == null) {
			new Activator();
		}
		return sPlugin;
	}

	public Activator() {
		super();
		sPlugin = this;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	public String getID() {
		return kPluginID;
	}

	@Override
	public String getLanguageID() {
	    return kLanguageName;
	}
}
