package com.google.android.play.core.internal;

public final class cf<T> implements ci<T> {

    /* renamed from: a  reason: collision with root package name */
    private ci<T> f3763a;

    public static <T> void a(ci<T> ciVar, ci<T> ciVar2) {
        bl.a(ciVar2);
        cf cfVar = (cf) ciVar;
        if (cfVar.f3763a == null) {
            cfVar.f3763a = ciVar2;
            return;
        }
        throw new IllegalStateException();
    }

    public final T a() {
        ci<T> ciVar = this.f3763a;
        if (ciVar != null) {
            return ciVar.a();
        }
        throw new IllegalStateException();
    }
}
