package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class zzcj extends Handler {
    private final /* synthetic */ zzch zzml;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcj(zzch zzch, Looper looper) {
        super(looper);
        this.zzml = zzch;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            PendingResult pendingResult = (PendingResult) message.obj;
            synchronized (this.zzml.zzfa) {
                if (pendingResult == null) {
                    this.zzml.zzme.zzd(new Status(13, "Transform returned null"));
                } else if (pendingResult instanceof zzbx) {
                    this.zzml.zzme.zzd(((zzbx) pendingResult).getStatus());
                } else {
                    this.zzml.zzme.zza(pendingResult);
                }
            }
        } else if (i != 1) {
            int i2 = message.what;
            StringBuilder sb = new StringBuilder(70);
            sb.append("TransformationResultHandler received unknown message type: ");
            sb.append(i2);
            Log.e("TransformedResultImpl", sb.toString());
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
            throw runtimeException;
        }
    }
}
