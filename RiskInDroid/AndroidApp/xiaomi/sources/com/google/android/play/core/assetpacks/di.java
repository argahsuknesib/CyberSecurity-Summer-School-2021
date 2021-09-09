package com.google.android.play.core.assetpacks;

final /* synthetic */ class di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final bc f3703a;

    private di(bc bcVar) {
        this.f3703a = bcVar;
    }

    static Runnable a(bc bcVar) {
        return new di(bcVar);
    }

    public final void run() {
        this.f3703a.c();
    }
}
