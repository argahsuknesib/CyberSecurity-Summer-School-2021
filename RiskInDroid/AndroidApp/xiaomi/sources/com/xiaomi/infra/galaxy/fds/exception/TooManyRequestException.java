package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class TooManyRequestException extends GalaxyFDSException {
    private static final long serialVersionUID = -3445453442098066940L;

    public TooManyRequestException(String str) {
        super(str);
    }

    public FDSError getError() {
        return FDSError.TooManyRequests;
    }
}
