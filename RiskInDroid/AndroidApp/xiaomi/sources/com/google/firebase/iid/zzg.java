package com.google.firebase.iid;

import android.util.Log;

final class zzg implements Runnable {
    private final /* synthetic */ zzd zzx;
    private final /* synthetic */ zzf zzy;

    zzg(zzf zzf, zzd zzd) {
        this.zzy = zzf;
        this.zzx = zzd;
    }

    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.zzy.zzw.zzd(this.zzx.intent);
        this.zzx.finish();
    }
}
