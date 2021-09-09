package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class InvalidBucketNameException extends GalaxyFDSException {
    private static final long serialVersionUID = 436771419220254068L;
    private String message;

    public InvalidBucketNameException(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public FDSError getError() {
        return FDSError.InvalidBucketName;
    }
}
