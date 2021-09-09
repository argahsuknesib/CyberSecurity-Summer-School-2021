package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;

public class FirebaseAuthException extends FirebaseException {
    private final String zzy;

    public FirebaseAuthException(String str, String str2) {
        super(str2);
        this.zzy = Preconditions.checkNotEmpty(str);
    }

    public String getErrorCode() {
        return this.zzy;
    }
}
