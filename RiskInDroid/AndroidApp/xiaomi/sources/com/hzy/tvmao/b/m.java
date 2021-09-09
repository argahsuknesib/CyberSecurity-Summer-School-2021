package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.hzy.tvmao.utils.LogUtil;
import com.kookong.app.data.RemoteList;

class m extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ String g;
    final /* synthetic */ f h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(f fVar, a.c cVar, String str, int i, int i2, String str2) {
        super(cVar, str);
        this.h = fVar;
        this.e = i;
        this.f = i2;
        this.g = str2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        try {
            n<RemoteList> b = i.b(this.e, this.f, this.g);
            LogUtil.d("TestIRcodelist==" + b.f4436a);
            return new com.hzy.tvmao.b.a.a(b.f4436a, "", b.e);
        } catch (Exception unused) {
            return null;
        }
    }
}
