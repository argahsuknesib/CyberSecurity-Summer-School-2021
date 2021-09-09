package io.realm.internal;

public class IOException extends RuntimeException {
    public IOException(Throwable th) {
        super(th);
    }

    public IOException() {
    }

    public IOException(String str) {
        super(str);
    }

    public IOException(String str, Throwable th) {
        super(str, th);
    }
}
