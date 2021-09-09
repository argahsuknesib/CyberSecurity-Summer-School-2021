package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.ChannelEpg;

class ab extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ String f;
    final /* synthetic */ int g;
    final /* synthetic */ w h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ab(w wVar, a.c cVar, String str, int i, String str2, int i2) {
        super(cVar, str);
        this.h = wVar;
        this.e = i;
        this.f = str2;
        this.g = i2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        n<ChannelEpg> a2 = i.a(this.e, this.f, this.g);
        return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, a2.e);
    }
}
