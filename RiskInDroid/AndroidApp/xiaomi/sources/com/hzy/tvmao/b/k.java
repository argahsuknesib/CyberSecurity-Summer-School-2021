package com.hzy.tvmao.b;

import android.util.Log;
import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.RemoteList;

class k extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ int h;
    final /* synthetic */ f i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(f fVar, a.c cVar, String str, int i2, int i3, int i4, int i5) {
        super(cVar, str);
        this.i = fVar;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<RemoteList> a2 = i.a(this.e, this.f, this.g, this.h);
            return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, a2.e);
        } catch (Exception e2) {
            Log.wtf("listRidsBySameKey", e2);
            return null;
        }
    }
}
