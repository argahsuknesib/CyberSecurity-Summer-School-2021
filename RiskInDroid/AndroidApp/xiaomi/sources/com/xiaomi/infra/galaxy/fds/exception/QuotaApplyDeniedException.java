package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class QuotaApplyDeniedException extends GalaxyFDSException {
    private static final long serialVersionUID = -974711420428687663L;

    public QuotaApplyDeniedException() {
        super("Only admin is allowed to access Quota Apply");
    }

    public QuotaApplyDeniedException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.QuotaApplyDenied;
    }
}
