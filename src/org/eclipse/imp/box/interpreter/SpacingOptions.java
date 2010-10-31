/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
 *******************************************************************************/

package org.eclipse.imp.box.interpreter;

import org.eclipse.imp.box.interpreter.BoxInterpreter.Alignment;

public class SpacingOptions {
    int fHorizontalSpacing= 1;
    int fVerticalSpacing= 0;
    int fIndentationSpacing= 4;
    int fTabStopSpacing= 4;
    int fSeparatorSpacing= 0;
    private int fGroupSize= 4;
    private Alignment fAlignment= Alignment.LEFT;

    SpacingOptions() { }

    public static SpacingOptions DEFAULT() {
        return new SpacingOptions();
    }

    public static SpacingOptions hs(int hs) {
        SpacingOptions opts= new SpacingOptions();
        opts.fHorizontalSpacing= hs;
        return opts;
    }

    public static SpacingOptions vs(int vs) {
        SpacingOptions opts= new SpacingOptions();
        opts.fVerticalSpacing= vs;
        return opts;
    }

    public static SpacingOptions hsvs(int hs, int vs) {
        SpacingOptions opts= new SpacingOptions();
        opts.fHorizontalSpacing= hs;
        opts.fVerticalSpacing= vs;
        return opts;
    }

    public static SpacingOptions is(int indent) {
        SpacingOptions opts= new SpacingOptions();
        opts.fIndentationSpacing= indent;
        return opts;
    }

    public static SpacingOptions ts(int tab) {
        SpacingOptions opts= new SpacingOptions();
        opts.fTabStopSpacing= tab;
        return opts;
    }

    public static SpacingOptions gs(int groupSize) {
        SpacingOptions opts= new SpacingOptions();
        opts.fGroupSize= groupSize;
        return opts;
    }

    public int horizontalSpacing() {
        return fHorizontalSpacing;
    }

    public int verticalSpacing() {
        return fVerticalSpacing;
    }

    public int indentationSpacing() {
        return fIndentationSpacing;
    }

    public int separatorSpacing() {
        return fSeparatorSpacing;
    }

    public int tabStopSpacing() {
        return fTabStopSpacing;
    }

    public int groupSize() {
        return fGroupSize;
    }

    public Alignment alignment() {
        return fAlignment;
    }
}