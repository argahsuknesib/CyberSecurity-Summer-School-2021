package com.getkeepsafe.relinker;

public class MissingLibraryException extends RuntimeException {
    public MissingLibraryException(String str) {
        super(str);
    }
}
