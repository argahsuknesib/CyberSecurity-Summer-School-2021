package com.google.firebase.internal.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseException;

@KeepForSdk
public class FirebaseNoSignedInUserException extends FirebaseException {
    @KeepForSdk
    public FirebaseNoSignedInUserException(String str) {
        super(str);
    }
}
