package com.miui.tsmclientsdk;

public class OperationCanceledException extends Exception {
    public OperationCanceledException() {
    }

    public OperationCanceledException(String str) {
        super(str);
    }

    public OperationCanceledException(String str, Throwable th) {
        super(str, th);
    }

    public OperationCanceledException(Throwable th) {
        super(th);
    }
}
