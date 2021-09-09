package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class MirrorFailedException extends GalaxyFDSException {
    public MirrorFailedException() {
        super("Get mirror object failed");
    }

    public MirrorFailedException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.MirrorFailed;
    }
}
