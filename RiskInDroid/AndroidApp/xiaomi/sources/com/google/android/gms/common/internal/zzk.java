package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;

final class zzk implements PendingResultUtil.StatusConverter {
    zzk() {
    }

    public final ApiException convert(Status status) {
        return ApiExceptionUtil.fromStatus(status);
    }
}
