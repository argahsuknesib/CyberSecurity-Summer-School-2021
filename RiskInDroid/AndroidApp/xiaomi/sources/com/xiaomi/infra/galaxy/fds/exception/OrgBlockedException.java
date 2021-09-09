package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class OrgBlockedException extends GalaxyFDSException {
    private static final long serialVersionUID = -434711420428127663L;

    public OrgBlockedException() {
        super("This resource is freeze");
    }

    public OrgBlockedException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.QuotaApplyDenied;
    }
}
