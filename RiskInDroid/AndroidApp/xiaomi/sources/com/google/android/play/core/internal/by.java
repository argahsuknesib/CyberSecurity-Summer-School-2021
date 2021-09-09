package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class by extends WeakReference<Throwable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f3758a;

    public by(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f3758a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        by byVar = (by) obj;
        return this.f3758a == byVar.f3758a && get() == byVar.get();
    }

    public final int hashCode() {
        return this.f3758a;
    }
}
