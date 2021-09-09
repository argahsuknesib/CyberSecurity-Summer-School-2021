package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class zzf extends Binder {
    /* access modifiers changed from: private */
    public final zzb zzw;

    zzf(zzb zzb) {
        this.zzw = zzb;
    }

    public final void zza(zzd zzd) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (this.zzw.zzc(zzd.intent)) {
                zzd.finish();
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.zzw.zzl.execute(new zzg(this, zzd));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
