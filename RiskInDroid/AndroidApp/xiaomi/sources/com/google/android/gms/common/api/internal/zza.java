package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class zza extends ActivityLifecycleObserver {
    private final WeakReference<C0026zza> zzds;

    /* renamed from: com.google.android.gms.common.api.internal.zza$zza  reason: collision with other inner class name */
    static class C0026zza extends LifecycleCallback {
        private List<Runnable> zzdt = new ArrayList();

        private C0026zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* access modifiers changed from: private */
        public static C0026zza zza(Activity activity) {
            C0026zza zza;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                zza = (C0026zza) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0026zza.class);
                if (zza == null) {
                    zza = new C0026zza(fragment);
                }
            }
            return zza;
        }

        /* access modifiers changed from: private */
        public final synchronized void zza(Runnable runnable) {
            this.zzdt.add(runnable);
        }

        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zzdt;
                this.zzdt = new ArrayList();
            }
            for (Runnable run : list) {
                run.run();
            }
        }
    }

    public zza(Activity activity) {
        this(C0026zza.zza(activity));
    }

    private zza(C0026zza zza) {
        this.zzds = new WeakReference<>(zza);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0026zza zza = this.zzds.get();
        if (zza != null) {
            zza.zza(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }
}
