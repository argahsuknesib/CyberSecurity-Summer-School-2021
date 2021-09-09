package com.xiaomi.onetrack;

public class OneTrackException extends Exception {
    public OneTrackException() {
    }

    public OneTrackException(String str) {
        super(str);
    }

    public OneTrackException(String str, Throwable th) {
        super(str, th);
    }

    public OneTrackException(Throwable th) {
        super(th);
    }
}
