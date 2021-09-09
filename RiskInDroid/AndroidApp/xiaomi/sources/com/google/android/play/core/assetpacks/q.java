package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.bl;
import com.google.android.play.core.internal.ci;

public final class q implements ci<AssetPackManager> {

    /* renamed from: a  reason: collision with root package name */
    private final ci<j> f3729a;
    private final ci<Context> b;

    public q(ci<j> ciVar, ci<Context> ciVar2) {
        this.f3729a = ciVar;
        this.b = ciVar2;
    }

    public final /* synthetic */ Object a() {
        j a2 = this.f3729a.a();
        Context b2 = ((s) this.b).a();
        j jVar = a2;
        bl.a(b2.getPackageManager(), new ComponentName(b2.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"));
        PlayCoreDialogWrapperActivity.a(b2);
        bl.a(jVar, "Cannot return null from a non-@Nullable @Provides method");
        return jVar;
    }
}
