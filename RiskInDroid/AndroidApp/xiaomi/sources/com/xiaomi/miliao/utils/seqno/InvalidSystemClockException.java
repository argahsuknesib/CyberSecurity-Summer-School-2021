package com.xiaomi.miliao.utils.seqno;

public class InvalidSystemClockException extends RuntimeException {
    private static final long serialVersionUID = 7484001340686229985L;

    public InvalidSystemClockException() {
    }

    public InvalidSystemClockException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidSystemClockException(String str) {
        super(str);
    }

    public InvalidSystemClockException(Throwable th) {
        super(th);
    }
}
