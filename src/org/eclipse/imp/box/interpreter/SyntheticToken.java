package org.eclipse.imp.box.interpreter;

import lpg.runtime.ILexStream;
import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;

/**
 * A semi-bogus implementation of IToken that is functional enough to represent a
 * synthetic token in the construction of various AST nodes whose constructors
 * require left/right token parameters.
 * @author rfuhrer@watson.ibm.com
 */
public class SyntheticToken implements IToken {
    private final int fKind;
    private final String fImage;

    public SyntheticToken(int kind, String image) {
        fKind= kind;
        fImage= image;
    }

    public int getKind() {
        return fKind;
    }

    public void setKind(int kind) {
        throw new UnsupportedOperationException();
    }

    public int getStartOffset() {
        return 0;
    }

    public void setStartOffset(int startOffset) {
        throw new UnsupportedOperationException();
    }

    public int getEndOffset() {
        return 0;
    }

    public void setEndOffset(int endOffset) {
        throw new UnsupportedOperationException();
    }

    public int getTokenIndex() {
        return 0;
    }

    public void setTokenIndex(int i) {
        throw new UnsupportedOperationException();
    }

    public int getAdjunctIndex() {
        return 0;
    }

    public void setAdjunctIndex(int i) {
        throw new UnsupportedOperationException();
    }

    public IToken[] getPrecedingAdjuncts() {
        return null;
    }

    public IToken[] getFollowingAdjuncts() {
        return null;
    }

    public ILexStream getILexStream() {
        return null;
    }

    public ILexStream getLexStream() {
        return null;
    }

    public IPrsStream getIPrsStream() {
        return null;
    }

    public IPrsStream getPrsStream() {
        return null;
    }

    public int getLine() {
        return 0;
    }

    public int getColumn() {
        return 0;
    }

    public int getEndLine() {
        return 0;
    }

    public int getEndColumn() {
        return 0;
    }

    public String getValue(char[] inputChars) {
        return fImage;
    }

    public String toString() {
        return fImage;
    }

    public int hashCode() {
        return fImage.hashCode();
    }
}
