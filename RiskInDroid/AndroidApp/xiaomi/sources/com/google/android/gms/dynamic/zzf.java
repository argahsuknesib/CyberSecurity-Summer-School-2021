package com.google.android.gms.dynamic;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;

final class zzf implements DeferredLifecycleHelper.zza {
    private final /* synthetic */ DeferredLifecycleHelper zzabg;

    zzf(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zzabg = deferredLifecycleHelper;
    }

    public final int getState() {
        return 4;
    }

    public final void zza(LifecycleDelegate lifecycleDelegate) {
        this.zzabg.zzabc.onStart();
    }
}
