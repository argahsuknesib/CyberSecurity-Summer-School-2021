package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class DDLDDisabledException extends GalaxyFDSException {
    private static final long serialVersionUID = -3118772366981446834L;

    public DDLDDisabledException() {
        super("DDL is disabled at the moment");
    }

    public DDLDDisabledException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.DDLDisabled;
    }
}
