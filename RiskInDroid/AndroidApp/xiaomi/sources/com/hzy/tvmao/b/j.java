package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.IrDataList;

class j extends a.C0035a {
    final /* synthetic */ String e;
    final /* synthetic */ int f;
    final /* synthetic */ String g;
    final /* synthetic */ boolean h;
    final /* synthetic */ boolean i;
    final /* synthetic */ f j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j(f fVar, a.c cVar, String str, String str2, int i2, String str3, boolean z, boolean z2) {
        super(cVar, str);
        this.j = fVar;
        this.e = str2;
        this.f = i2;
        this.g = str3;
        this.h = z;
        this.i = z2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<IrDataList> a2 = i.a(this.e, this.f, this.g, this.h, this.i);
            return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, a2.e);
        } catch (Exception unused) {
            return null;
        }
    }
}
