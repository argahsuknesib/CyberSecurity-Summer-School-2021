package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class DomainMappingAccessDeniedException extends GalaxyFDSException {
    private static final long serialVersionUID = 6765549983453165715L;

    public DomainMappingAccessDeniedException() {
        super("Only admin is allowd to edit domain mapping");
    }

    public DomainMappingAccessDeniedException(String str, Throwable th) {
        super(str, th);
    }

    public FDSError getError() {
        return FDSError.DomainMappingAccessDenied;
    }
}
