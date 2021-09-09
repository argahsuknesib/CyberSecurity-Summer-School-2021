package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.RcTestRemoteKeyList;

class i extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ f g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    i(f fVar, a.c cVar, String str, int i, int i2) {
        super(cVar, str);
        this.g = fVar;
        this.e = i;
        this.f = i2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        int i;
        n<RcTestRemoteKeyList> nVar = null;
        try {
            nVar = com.hzy.tvmao.model.legacy.api.i.d(this.e, this.f);
            i = nVar.f4436a;
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        return new com.hzy.tvmao.b.a.a(i, "", nVar.e);
    }
}
