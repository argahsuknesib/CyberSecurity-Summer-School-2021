package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class InvalidTrashObjectNameException extends GalaxyFDSException {
    private static final long serialVersionUID = 446773419120254067L;
    private String message;

    public InvalidTrashObjectNameException() {
        this("Trash object name should contains at least 2 '/'");
    }

    public InvalidTrashObjectNameException(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public FDSError getError() {
        return FDSError.InvalidTrashObjectName;
    }
}
