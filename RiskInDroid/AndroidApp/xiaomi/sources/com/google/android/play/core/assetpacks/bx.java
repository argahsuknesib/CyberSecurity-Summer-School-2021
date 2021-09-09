package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;

public final class bx implements ci<bw> {

    /* renamed from: a  reason: collision with root package name */
    private final ci<bc> f3667a;
    private final ci<x> b;
    private final ci<ax> c;
    private final ci<cb> d;

    public bx(ci<bc> ciVar, ci<x> ciVar2, ci<ax> ciVar3, ci<cb> ciVar4) {
        this.f3667a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
        this.d = ciVar4;
    }

    public final /* synthetic */ Object a() {
        return new bw(this.f3667a.a(), cg.b(this.b), cg.b(this.c), this.d.a());
    }
}
