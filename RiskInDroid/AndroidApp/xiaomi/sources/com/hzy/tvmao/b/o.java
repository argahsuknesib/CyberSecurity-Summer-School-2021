package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;

class o extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ n g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o(n nVar, a.c cVar, String str, int i, int i2) {
        super(cVar, str);
        this.g = nVar;
        this.e = i;
        this.f = i2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        return new com.hzy.tvmao.b.a.a(i.b(this.e, this.f));
    }
}
