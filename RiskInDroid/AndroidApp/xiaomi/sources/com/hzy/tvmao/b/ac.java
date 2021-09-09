package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;

class ac extends a.C0035a {
    final /* synthetic */ String e;
    final /* synthetic */ short f;
    final /* synthetic */ w g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ac(w wVar, a.c cVar, String str, String str2, short s) {
        super(cVar, str);
        this.g = wVar;
        this.e = str2;
        this.f = s;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        return new com.hzy.tvmao.b.a.a(i.a(this.e, this.f));
    }
}
