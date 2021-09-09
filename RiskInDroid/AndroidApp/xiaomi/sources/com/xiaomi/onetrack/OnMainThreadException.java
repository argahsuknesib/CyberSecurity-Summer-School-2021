package com.xiaomi.onetrack;

public class OnMainThreadException extends OneTrackException {
    public OnMainThreadException() {
    }

    public OnMainThreadException(String str) {
        super(str);
    }

    public OnMainThreadException(String str, Throwable th) {
        super(str, th);
    }

    public OnMainThreadException(Throwable th) {
        super(th);
    }
}
