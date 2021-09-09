package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;

class x extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ String g;
    final /* synthetic */ String h;
    final /* synthetic */ w i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    x(w wVar, a.c cVar, String str, int i2, int i3, String str2, String str3) {
        super(cVar, str);
        this.i = wVar;
        this.e = i2;
        this.f = i3;
        this.g = str2;
        this.h = str3;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        return new com.hzy.tvmao.b.a.a(1, "", i.a(this.e, this.f, this.g, this.h).e);
    }
}
