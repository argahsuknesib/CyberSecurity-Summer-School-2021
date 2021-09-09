package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class InvalidPartNumberOrSizeException extends GalaxyFDSException {
    private static final long serialVersionUID = -980535900742856349L;

    public InvalidPartNumberOrSizeException() {
    }

    public InvalidPartNumberOrSizeException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.InvalidPartNumberOrSize;
    }
}
