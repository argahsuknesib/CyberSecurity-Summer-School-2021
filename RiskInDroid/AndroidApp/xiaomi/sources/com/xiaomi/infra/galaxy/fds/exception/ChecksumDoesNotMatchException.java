package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class ChecksumDoesNotMatchException extends GalaxyFDSException {
    private static final long serialVersionUID = -5962238757745947478L;

    public ChecksumDoesNotMatchException() {
    }

    public ChecksumDoesNotMatchException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.ChecksumDoesNotMatch;
    }
}
