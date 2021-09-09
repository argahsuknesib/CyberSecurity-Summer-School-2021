package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzk extends WeakReference<Throwable> {
    private final int zzj;

    public zzk(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zzj = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzk zzk = (zzk) obj;
            return this.zzj == zzk.zzj && get() == zzk.get();
        }
    }

    public final int hashCode() {
        return this.zzj;
    }
}
