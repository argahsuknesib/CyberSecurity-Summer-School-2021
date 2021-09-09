package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.ci;
import com.google.android.play.core.splitinstall.z;

public final class u implements ci<z> {

    /* renamed from: a  reason: collision with root package name */
    private final ci<Context> f3733a;

    public u(ci<Context> ciVar) {
        this.f3733a = ciVar;
    }

    public final /* synthetic */ Object a() {
        Context b = ((s) this.f3733a).a();
        z zVar = new z(b, b.getPackageName());
        bl.a(zVar, "Cannot return null from a non-@Nullable @Provides method");
        return zVar;
    }
}
