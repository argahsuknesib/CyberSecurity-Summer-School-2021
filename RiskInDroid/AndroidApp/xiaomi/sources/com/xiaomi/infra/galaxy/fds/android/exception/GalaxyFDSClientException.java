package com.xiaomi.infra.galaxy.fds.android.exception;

public class GalaxyFDSClientException extends Exception {
    public GalaxyFDSClientException() {
    }

    public GalaxyFDSClientException(String str) {
        super(str);
    }

    public GalaxyFDSClientException(Throwable th) {
        super(th);
    }

    public GalaxyFDSClientException(String str, Throwable th) {
        super(str, th);
    }
}
