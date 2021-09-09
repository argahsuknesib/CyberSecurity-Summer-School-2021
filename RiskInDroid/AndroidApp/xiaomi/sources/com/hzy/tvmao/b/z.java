package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;

class z extends a.C0035a {
    final /* synthetic */ short e;
    final /* synthetic */ String f;
    final /* synthetic */ w g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    z(w wVar, a.c cVar, String str, short s, String str2) {
        super(cVar, str);
        this.g = wVar;
        this.e = s;
        this.f = str2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        return new com.hzy.tvmao.b.a.a(i.a(this.e, this.f));
    }
}
