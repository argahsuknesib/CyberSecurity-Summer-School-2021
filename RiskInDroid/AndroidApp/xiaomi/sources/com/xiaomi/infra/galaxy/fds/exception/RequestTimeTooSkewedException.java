package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class RequestTimeTooSkewedException extends GalaxyFDSException {
    private static final long serialVersionUID = -8352893688045280710L;

    public RequestTimeTooSkewedException() {
        super("Date in your request header differs with local time in FDS too much, Check local time of client");
    }

    public FDSError getError() {
        return FDSError.RequestTimeTooSkewed;
    }
}
