package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<x> f3840a = new AtomicReference<>(null);

    static x a() {
        return f3840a.get();
    }

    public static void a(x xVar) {
        f3840a.compareAndSet(null, xVar);
    }
}
