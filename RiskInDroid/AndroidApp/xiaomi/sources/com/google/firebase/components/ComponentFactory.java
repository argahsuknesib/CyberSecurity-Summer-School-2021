package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface ComponentFactory<T> {
    @KeepForSdk
    T create(ComponentContainer componentContainer);
}
