package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class w extends Enum<w> implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final w f3839a = new w("INSTANCE");
    private static final AtomicReference<d> b = new AtomicReference<>(null);

    static {
        new w[1][0] = f3839a;
    }

    private w(String str) {
    }

    public final d a() {
        return b.get();
    }

    public final void a(d dVar) {
        b.set(dVar);
    }
}
