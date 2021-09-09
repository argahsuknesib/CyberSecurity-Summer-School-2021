package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.RemoteList;

class g extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ int h;
    final /* synthetic */ String i;
    final /* synthetic */ f j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g(f fVar, a.c cVar, String str, int i2, int i3, int i4, int i5, String str2) {
        super(cVar, str);
        this.j = fVar;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = str2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<RemoteList> a2 = i.a(this.e, this.f, this.g, this.h, this.i);
            return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, a2.e);
        } catch (Exception unused) {
            return null;
        }
    }
}
