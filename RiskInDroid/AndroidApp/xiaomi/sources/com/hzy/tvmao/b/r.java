package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;

class r extends a.C0035a {
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ q h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    r(q qVar, a.c cVar, String str, String str2, String str3, String str4) {
        super(cVar, str);
        this.h = qVar;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<Integer> a2 = i.a(this.e, this.f, this.g);
            return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, a2.e);
        } catch (Exception unused) {
            return null;
        }
    }
}
