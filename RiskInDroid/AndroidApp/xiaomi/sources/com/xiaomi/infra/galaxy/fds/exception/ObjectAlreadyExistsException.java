package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class ObjectAlreadyExistsException extends GalaxyFDSException {
    public FDSError getError() {
        return FDSError.ObjectAlreadyExists;
    }
}
