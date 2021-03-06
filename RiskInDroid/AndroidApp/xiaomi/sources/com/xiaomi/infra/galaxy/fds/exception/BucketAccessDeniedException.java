package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class BucketAccessDeniedException extends GalaxyFDSException {
    private static final long serialVersionUID = -974711420428687663L;

    public BucketAccessDeniedException() {
        super("Only owner is allowed to edit bucket property");
    }

    public BucketAccessDeniedException(String str) {
        super(str);
    }

    public BucketAccessDeniedException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.BucketAccessDenied;
    }
}
