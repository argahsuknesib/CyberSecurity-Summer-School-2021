package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

final class zzb implements DeferredLifecycleHelper.zza {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ DeferredLifecycleHelper zzabg;
    private final /* synthetic */ Bundle zzabh;
    private final /* synthetic */ Bundle zzabi;

    zzb(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.zzabg = deferredLifecycleHelper;
        this.val$activity = activity;
        this.zzabh = bundle;
        this.zzabi = bundle2;
    }

    public final int getState() {
        return 0;
    }

    public final void zza(LifecycleDelegate lifecycleDelegate) {
        this.zzabg.zzabc.onInflate(this.val$activity, this.zzabh, this.zzabi);
    }
}
