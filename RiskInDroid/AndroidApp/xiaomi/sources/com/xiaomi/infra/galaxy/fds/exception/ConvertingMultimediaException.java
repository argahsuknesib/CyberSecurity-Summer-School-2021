package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class ConvertingMultimediaException extends GalaxyFDSException {
    private static final long serialVersionUID = 6867994043799397945L;

    public ConvertingMultimediaException() {
    }

    public ConvertingMultimediaException(String str) {
        super(str, null);
    }

    public ConvertingMultimediaException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.ConvertingMultimedia;
    }
}
