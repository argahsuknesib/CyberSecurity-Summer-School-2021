package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class GalaxyFDSException extends Exception {
    private static String locationInfo = null;
    private static final long serialVersionUID = -7688381775178948719L;

    public GalaxyFDSException() {
    }

    public static void setLocationInfo(String str) {
        locationInfo = str;
    }

    public GalaxyFDSException(String str, Throwable th) {
        super(str, th);
    }

    public GalaxyFDSException(String str) {
        super(str, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalaxyFDSException(Throwable th) {
        super(th == null ? null : th.getMessage(), th);
    }

    public FDSError getError() {
        return FDSError.InternalServerError;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Galaxy FDS Error: ");
        sb.append(getError().description());
        String message = getMessage();
        if (message != null) {
            sb.append(" [");
            sb.append(message);
            sb.append("]");
        }
        if (locationInfo != null) {
            sb.append(" ");
            sb.append(locationInfo);
        }
        return sb.toString();
    }
}
