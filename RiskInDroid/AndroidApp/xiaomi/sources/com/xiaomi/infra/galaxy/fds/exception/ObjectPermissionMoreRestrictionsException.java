package com.xiaomi.infra.galaxy.fds.exception;

import com.xiaomi.infra.galaxy.fds.FDSError;

public class ObjectPermissionMoreRestrictionsException extends GalaxyFDSException {
    private static final long serialVersionUID = -1962231754285924349L;

    public ObjectPermissionMoreRestrictionsException() {
        super("According to the requirements of the Xiaomi company security department, we take back the user's write related permission to the object when object allows outside accessing");
    }

    public FDSError getError() {
        return FDSError.CannotSetWriteRelatedPermission;
    }
}
