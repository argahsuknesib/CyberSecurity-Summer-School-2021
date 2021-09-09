package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class i extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.play.core.tasks.i f3721a;
    final /* synthetic */ j b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    i(j jVar, Handler handler, com.google.android.play.core.tasks.i iVar) {
        super(handler);
        this.b = jVar;
        this.f3721a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.f3721a.b((Object) -1);
            this.b.h.a(null);
        } else if (i != 2) {
            this.f3721a.b((Exception) new AssetPackException(-100));
        } else {
            this.f3721a.b((Object) 0);
        }
    }
}
