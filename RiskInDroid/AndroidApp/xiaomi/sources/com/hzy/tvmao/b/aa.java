package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.ProgramData;

class aa extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ w h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aa(w wVar, a.c cVar, String str, int i, String str2, String str3) {
        super(cVar, str);
        this.h = wVar;
        this.e = i;
        this.f = str2;
        this.g = str3;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        n<ProgramData> b = i.b(String.valueOf(this.e), this.f, this.g);
        return new com.hzy.tvmao.b.a.a(b.f4436a, b.b, b.e);
    }
}
