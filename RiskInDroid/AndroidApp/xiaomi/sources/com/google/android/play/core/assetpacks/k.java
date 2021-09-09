package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.ce;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;
import com.google.android.play.core.splitinstall.z;
import java.util.concurrent.Executor;

public final class k implements ci<j> {

    /* renamed from: a  reason: collision with root package name */
    private final ci<bc> f3723a;
    private final ci<x> b;
    private final ci<ax> c;
    private final ci<z> d;
    private final ci<cr> e;
    private final ci<cb> f;
    private final ci<bq> g;
    private final ci<Executor> h;

    public k(ci<bc> ciVar, ci<x> ciVar2, ci<ax> ciVar3, ci<z> ciVar4, ci<cr> ciVar5, ci<cb> ciVar6, ci<bq> ciVar7, ci<Executor> ciVar8) {
        this.f3723a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
        this.d = ciVar4;
        this.e = ciVar5;
        this.f = ciVar6;
        this.g = ciVar7;
        this.h = ciVar8;
    }

    public final /* synthetic */ Object a() {
        bc a2 = this.f3723a.a();
        ce b2 = cg.b(this.b);
        ax a3 = this.c.a();
        return new j(a2, b2, a3, this.d.a(), this.e.a(), this.f.a(), this.g.a(), cg.b(this.h));
    }
}
