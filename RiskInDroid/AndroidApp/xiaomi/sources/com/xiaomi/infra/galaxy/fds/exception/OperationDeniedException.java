package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class OperationDeniedException extends GalaxyFDSException {
    private static final long serialVersionUID = -974711420428687663L;

    public OperationDeniedException() {
        super("This operation is denied");
    }

    public OperationDeniedException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.OperationDenied;
    }
}
