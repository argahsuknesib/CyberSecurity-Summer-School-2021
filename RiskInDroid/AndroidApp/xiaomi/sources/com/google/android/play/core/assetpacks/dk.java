package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import java.util.concurrent.Executor;

public final class dk implements ci<dj> {

    /* renamed from: a  reason: collision with root package name */
    private final ci<bc> f3705a;
    private final ci<x> b;
    private final ci<cr> c;
    private final ci<Executor> d;
    private final ci<cb> e;

    public dk(ci<bc> ciVar, ci<x> ciVar2, ci<cr> ciVar3, ci<Executor> ciVar4, ci<cb> ciVar5) {
        this.f3705a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
        this.d = ciVar4;
        this.e = ciVar5;
    }

    public final /* synthetic */ Object a() {
        bc a2 = this.f3705a.a();
        return new dj(a2, cg.b(this.b), this.c.a(), cg.b(this.d), this.e.a());
    }
}
