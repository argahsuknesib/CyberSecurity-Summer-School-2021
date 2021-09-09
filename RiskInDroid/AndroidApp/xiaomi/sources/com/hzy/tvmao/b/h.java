package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.IrDataList;

class h extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ f f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    h(f fVar, a.c cVar, String str, int i) {
        super(cVar, str);
        this.f = fVar;
        this.e = i;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        int i;
        n<IrDataList> nVar = null;
        try {
            nVar = i.a(this.e, 5);
            i = nVar.f4436a;
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 0;
        }
        return new com.hzy.tvmao.b.a.a(i, "", nVar.e);
    }
}
