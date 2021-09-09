package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;

final class zzd implements DeferredLifecycleHelper.zza {
    private final /* synthetic */ ViewGroup val$container;
    private final /* synthetic */ DeferredLifecycleHelper zzabg;
    private final /* synthetic */ Bundle zzabi;
    private final /* synthetic */ FrameLayout zzabj;
    private final /* synthetic */ LayoutInflater zzabk;

    zzd(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.zzabg = deferredLifecycleHelper;
        this.zzabj = frameLayout;
        this.zzabk = layoutInflater;
        this.val$container = viewGroup;
        this.zzabi = bundle;
    }

    public final int getState() {
        return 2;
    }

    public final void zza(LifecycleDelegate lifecycleDelegate) {
        this.zzabj.removeAllViews();
        this.zzabj.addView(this.zzabg.zzabc.onCreateView(this.zzabk, this.val$container, this.zzabi));
    }
}
