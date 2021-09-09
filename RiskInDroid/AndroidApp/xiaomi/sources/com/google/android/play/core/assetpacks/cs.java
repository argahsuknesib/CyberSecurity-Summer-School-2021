package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import java.util.concurrent.Executor;

public final class cs implements ci<cr> {

    /* renamed from: a  reason: collision with root package name */
    private final ci<bc> f3687a;
    private final ci<x> b;
    private final ci<cb> c;
    private final ci<Executor> d;

    public cs(ci<bc> ciVar, ci<x> ciVar2, ci<cb> ciVar3, ci<Executor> ciVar4) {
        this.f3687a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
        this.d = ciVar4;
    }

    public final /* synthetic */ Object a() {
        bc a2 = this.f3687a.a();
        return new cr(a2, cg.b(this.b), this.c.a(), cg.b(this.d));
    }
}
