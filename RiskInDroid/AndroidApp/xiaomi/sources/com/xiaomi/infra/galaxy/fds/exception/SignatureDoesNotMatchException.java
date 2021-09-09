package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class SignatureDoesNotMatchException extends GalaxyFDSException {
    private static final long serialVersionUID = -5360663813945173831L;

    public SignatureDoesNotMatchException() {
        super("Check http header or query parameter in request, Make sure your request is correctly signed");
    }

    public FDSError getError() {
        return FDSError.SignatureDoesNotMatch;
    }
}
