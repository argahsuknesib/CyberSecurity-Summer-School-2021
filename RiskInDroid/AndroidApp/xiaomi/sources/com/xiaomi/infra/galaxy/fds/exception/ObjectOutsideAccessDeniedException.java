package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class ObjectOutsideAccessDeniedException extends GalaxyFDSException {
    public ObjectOutsideAccessDeniedException() {
        super("Object is not allowed outside access");
    }

    public ObjectOutsideAccessDeniedException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.ObjectAccessDenied;
    }
}
