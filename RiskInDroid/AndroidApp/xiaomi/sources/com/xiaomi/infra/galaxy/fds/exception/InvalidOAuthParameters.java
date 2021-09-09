package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class InvalidOAuthParameters extends GalaxyFDSException {
    private static final long serialVersionUID = 702036202632771699L;

    public InvalidOAuthParameters() {
        super("Make sure all required parameter is set correctly in request");
    }

    public FDSError getError() {
        return FDSError.InvalidOAuthParameters;
    }
}
