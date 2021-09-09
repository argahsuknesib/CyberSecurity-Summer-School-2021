package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class ObjectNotFoundException extends GalaxyFDSException {
    private static final long serialVersionUID = 1034434809193644031L;

    public ObjectNotFoundException() {
        super("Make sure your object exist in current region");
    }

    public ObjectNotFoundException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.ObjectNotFound;
    }
}
