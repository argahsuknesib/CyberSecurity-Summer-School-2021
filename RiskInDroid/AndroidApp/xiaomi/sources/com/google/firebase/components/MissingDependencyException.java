package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class MissingDependencyException extends DependencyException {
    @KeepForSdk
    public MissingDependencyException(String str) {
        super(str);
    }
}
