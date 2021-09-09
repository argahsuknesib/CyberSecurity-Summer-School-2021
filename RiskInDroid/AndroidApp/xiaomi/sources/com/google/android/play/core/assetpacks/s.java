package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.ci;

public final class s implements ci<Context> {

    /* renamed from: a  reason: collision with root package name */
    private final n f3731a;

    public s(n nVar) {
        this.f3731a = nVar;
    }

    public static Context a(n nVar) {
        Context a2 = nVar.a();
        bl.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    /* renamed from: b */
    public final Context a() {
        return a(this.f3731a);
    }
}
