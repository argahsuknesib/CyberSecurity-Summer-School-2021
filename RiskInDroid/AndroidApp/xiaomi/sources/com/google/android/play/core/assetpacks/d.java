package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.i;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f3694a;
    private final String b;
    private final i c;

    d(j jVar, String str, i iVar) {
        this.f3694a = jVar;
        this.b = str;
        this.c = iVar;
    }

    public final void run() {
        this.f3694a.a(this.b, this.c);
    }
}
