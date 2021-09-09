package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.StbList;

class t extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ q f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    t(q qVar, a.c cVar, String str, int i) {
        super(cVar, str);
        this.f = qVar;
        this.e = i;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<StbList> a2 = i.a(this.e);
            return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, a2.e);
        } catch (Exception unused) {
            return null;
        }
    }
}
