package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzam extends Handler {
    private final /* synthetic */ zzal zzck;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzal zzal, Looper looper) {
        super(looper);
        this.zzck = zzal;
    }

    public final void handleMessage(Message message) {
        this.zzck.zzb(message);
    }
}
