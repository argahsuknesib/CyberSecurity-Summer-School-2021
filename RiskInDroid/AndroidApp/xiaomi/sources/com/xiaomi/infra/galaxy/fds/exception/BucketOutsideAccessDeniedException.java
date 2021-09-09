package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class BucketOutsideAccessDeniedException extends GalaxyFDSException {
    public BucketOutsideAccessDeniedException() {
        super("Bucket is not allowed outside access");
    }

    public BucketOutsideAccessDeniedException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.BucketAccessDenied;
    }
}
