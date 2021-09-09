package com.google.firebase.iid.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface FirebaseInstanceIdInternal {
    @KeepForSdk
    String getId();

    @KeepForSdk
    String getToken();
}
