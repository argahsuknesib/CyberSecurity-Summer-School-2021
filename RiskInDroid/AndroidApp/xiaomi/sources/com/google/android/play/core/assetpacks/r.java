package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.cg;
import com.google.android.play.core.internal.ci;

public final class r implements ci<x> {

    /* renamed from: a  reason: collision with root package name */
    private final ci<Context> f3730a;
    private final ci<as> b;
    private final ci<db> c;

    public r(ci<Context> ciVar, ci<as> ciVar2, ci<db> ciVar3) {
        this.f3730a = ciVar;
        this.b = ciVar2;
        this.c = ciVar3;
    }

    public final /* synthetic */ Object a() {
        x xVar = (x) (n.a(((s) this.f3730a).a()) == null ? cg.b(this.b).a() : cg.b(this.c).a());
        bl.a(xVar, "Cannot return null from a non-@Nullable @Provides method");
        return xVar;
    }
}
