package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class DependencyException extends RuntimeException {
    @KeepForSdk
    public DependencyException(String str) {
        super(str);
    }
}
