package com.google.firebase.inject;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface Provider<T> {
    @KeepForSdk
    T get();
}
