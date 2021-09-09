package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;

final /* synthetic */ class zzv implements Handler.Callback {
    private final zzu zzbo;

    zzv(zzu zzu) {
        this.zzbo = zzu;
    }

    public final boolean handleMessage(Message message) {
        return this.zzbo.zza(message);
    }
}
