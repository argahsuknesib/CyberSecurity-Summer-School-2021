package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.StbList;

class u extends a.C0035a {
    final /* synthetic */ String e;
    final /* synthetic */ int f;
    final /* synthetic */ q g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    u(q qVar, a.c cVar, String str, String str2, int i) {
        super(cVar, str);
        this.g = qVar;
        this.e = str2;
        this.f = i;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<StbList> a2 = i.a(this.e, this.f);
            return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, a2.e);
        } catch (Exception unused) {
            return null;
        }
    }
}
