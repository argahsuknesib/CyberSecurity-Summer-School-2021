package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzm implements Runnable {
    private final zzl zzaz;
    private final Bundle zzba;
    private final TaskCompletionSource zzbb;

    zzm(zzl zzl, Bundle bundle, TaskCompletionSource taskCompletionSource) {
        this.zzaz = zzl;
        this.zzba = bundle;
        this.zzbb = taskCompletionSource;
    }

    public final void run() {
        this.zzaz.zza(this.zzba, this.zzbb);
    }
}
