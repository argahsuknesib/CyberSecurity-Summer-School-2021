package com.miot.spec.exception;

public class SpecException extends Exception {
    private int errorCode = 0;

    public SpecException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public SpecException(String str) {
        super(str);
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
