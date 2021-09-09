package com.facebook.places.internal;

public class ScannerException extends Exception {
    public Type type;

    public enum Type {
        NOT_SUPPORTED,
        PERMISSION_DENIED,
        DISABLED,
        SCAN_ALREADY_IN_PROGRESS,
        UNKNOWN_ERROR,
        TIMEOUT
    }

    public ScannerException(Type type2) {
        super("Type: " + type2.name());
        this.type = type2;
    }

    public ScannerException(Type type2, String str) {
        super(str);
        this.type = type2;
    }

    public ScannerException(Type type2, Exception exc) {
        super("Type: " + type2.name(), exc);
        this.type = type2;
    }
}
