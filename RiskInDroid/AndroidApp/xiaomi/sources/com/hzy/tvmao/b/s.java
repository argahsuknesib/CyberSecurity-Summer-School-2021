package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.SpList;

class s extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ q f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    s(q qVar, a.c cVar, String str, int i) {
        super(cVar, str);
        this.f = qVar;
        this.e = i;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<SpList> b = i.b(this.e);
            return new com.hzy.tvmao.b.a.a(b.f4436a, b.b, b.e);
        } catch (Exception unused) {
            return null;
        }
    }
}
