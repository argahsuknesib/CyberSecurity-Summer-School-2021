package com.google.firebase.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;

@KeepForSdk
public interface InternalTokenProvider {
    @KeepForSdk
    Task<GetTokenResult> getAccessToken(boolean z);

    @KeepForSdk
    String getUid();
}
