package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class UpstreamServiceException extends GalaxyFDSException {
    public UpstreamServiceException() {
        super("An exception occurred in the upstream service");
    }

    public UpstreamServiceException(String str) {
        super(str);
    }

    public UpstreamServiceException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.UpstreamServiceError;
    }
}
