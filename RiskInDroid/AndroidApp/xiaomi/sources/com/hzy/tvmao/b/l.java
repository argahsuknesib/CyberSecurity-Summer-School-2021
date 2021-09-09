package com.hzy.tvmao.b;

import android.util.Log;
import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.IrData;

class l extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ boolean g;
    final /* synthetic */ f h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l(f fVar, a.c cVar, String str, int i, int i2, boolean z) {
        super(cVar, str);
        this.h = fVar;
        this.e = i;
        this.f = i2;
        this.g = z;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<IrData> a2 = i.a(this.e, this.f, this.g);
            return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, a2.e);
        } catch (Exception e2) {
            Log.wtf("listIrDataBySingleKey", e2);
            return null;
        }
    }
}
