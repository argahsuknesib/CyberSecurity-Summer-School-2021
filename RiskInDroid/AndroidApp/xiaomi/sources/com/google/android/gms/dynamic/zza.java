package com.google.android.gms.dynamic;

import android.os.Bundle;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import java.util.Iterator;

final class zza implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper zzabg;

    zza(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zzabg = deferredLifecycleHelper;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.dynamic.DeferredLifecycleHelper.zza(com.google.android.gms.dynamic.DeferredLifecycleHelper, com.google.android.gms.dynamic.LifecycleDelegate):com.google.android.gms.dynamic.LifecycleDelegate
     arg types: [com.google.android.gms.dynamic.DeferredLifecycleHelper, T]
     candidates:
      com.google.android.gms.dynamic.DeferredLifecycleHelper.zza(com.google.android.gms.dynamic.DeferredLifecycleHelper, android.os.Bundle):android.os.Bundle
      com.google.android.gms.dynamic.DeferredLifecycleHelper.zza(android.os.Bundle, com.google.android.gms.dynamic.DeferredLifecycleHelper$zza):void
      com.google.android.gms.dynamic.DeferredLifecycleHelper.zza(com.google.android.gms.dynamic.DeferredLifecycleHelper, com.google.android.gms.dynamic.LifecycleDelegate):com.google.android.gms.dynamic.LifecycleDelegate */
    public final void onDelegateCreated(T t) {
        LifecycleDelegate unused = this.zzabg.zzabc = (LifecycleDelegate) t;
        Iterator it = this.zzabg.zzabe.iterator();
        while (it.hasNext()) {
            ((DeferredLifecycleHelper.zza) it.next()).zza(this.zzabg.zzabc);
        }
        this.zzabg.zzabe.clear();
        Bundle unused2 = this.zzabg.zzabd = null;
    }
}
