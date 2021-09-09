package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.BrandList;

class c extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ String f;
    final /* synthetic */ b g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    c(b bVar, a.c cVar, String str, int i, String str2) {
        super(cVar, str);
        this.g = bVar;
        this.e = i;
        this.f = str2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<BrandList> a2 = i.a(String.valueOf(this.e), this.f);
            return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, a2.e);
        } catch (Exception unused) {
            return null;
        }
    }
}
