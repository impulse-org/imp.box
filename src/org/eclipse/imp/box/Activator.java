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

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.imp.preferences.PreferencesService;
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

	protected static PreferencesService preferencesService = null;

	public static PreferencesService getPreferencesService() {
		if (preferencesService == null) {
			preferencesService = new PreferencesService(ResourcesPlugin
					.getWorkspace().getRoot().getProject());
			preferencesService.setLanguageName(kLanguageName);
    		// To trigger the automatic invocation of the preferences initializer:
    		try {
    			new DefaultScope().getNode(kPluginID);
    		} catch (Exception e) {
    			// If this ever happens, it will probably be because the preferences
    			// and their initializer haven't been defined yet.  In that situation
    			// there's not really anything to do--you can't initialize preferences
    			// that don't exist.  So swallow the exception and continue ...
    		}

		}
		return preferencesService;
	}
}
