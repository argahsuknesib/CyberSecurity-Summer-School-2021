package com.github.scribejava.core.exceptions;

public class OAuthException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public OAuthException(String str, Exception exc) {
        super(str, exc);
    }

    public OAuthException(String str) {
        super(str, null);
    }

    public OAuthException(Exception exc) {
        super(exc);
    }
}
