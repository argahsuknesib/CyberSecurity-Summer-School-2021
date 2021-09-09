package com.miot.spec.exception;

public class NotSupportValueException extends SpecException {
    public NotSupportValueException(int i, String str) {
        super(i, str);
    }

    public NotSupportValueException(String str) {
        super(str);
    }
}
