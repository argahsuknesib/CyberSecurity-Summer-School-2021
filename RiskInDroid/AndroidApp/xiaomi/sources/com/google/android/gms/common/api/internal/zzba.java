package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzba extends Handler {
    private final /* synthetic */ zzav zzit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzba(zzav zzav, Looper looper) {
        super(looper);
        this.zzit = zzav;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.zzit.zzay();
        } else if (i != 2) {
            int i2 = message.what;
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GoogleApiClientImpl", sb.toString());
        } else {
            this.zzit.resume();
        }
    }
}
