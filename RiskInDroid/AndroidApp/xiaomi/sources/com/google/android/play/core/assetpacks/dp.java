package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;

public final class dp implements ci<Cdo> {

    /* renamed from: a  reason: collision with root package name */
    private final ci<bc> f3710a;
    private final ci<x> b;

    public dp(ci<bc> ciVar, ci<x> ciVar2) {
        this.f3710a = ciVar;
        this.b = ciVar2;
    }

    public final /* synthetic */ Object a() {
        return new Cdo(this.f3710a.a(), cg.b(this.b));
    }
}
