package org.apache.commons.collections;

public class BufferOverflowException extends RuntimeException {
    private final Throwable throwable;

    public BufferOverflowException() {
        this.throwable = null;
    }

    public BufferOverflowException(String str) {
        this(str, null);
    }

    public BufferOverflowException(String str, Throwable th) {
        super(str);
        this.throwable = th;
    }

    public final Throwable getCause() {
        return this.throwable;
    }
}
