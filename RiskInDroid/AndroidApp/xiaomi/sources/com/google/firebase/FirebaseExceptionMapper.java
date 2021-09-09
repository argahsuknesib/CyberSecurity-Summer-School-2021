package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;

public class FirebaseExceptionMapper implements StatusExceptionMapper {
    public Exception getException(Status status) {
        return status.getStatusCode() == 8 ? new FirebaseException(status.zzp()) : new FirebaseApiNotAvailableException(status.zzp());
    }
}
