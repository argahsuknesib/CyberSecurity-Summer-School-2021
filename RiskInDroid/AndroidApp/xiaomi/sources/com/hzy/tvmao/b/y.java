package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.b;
import com.hzy.tvmao.model.legacy.api.data.EPGProgramData;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.PlayingTimeData;

class y extends a.C0035a {
    final /* synthetic */ short e;
    final /* synthetic */ String f;
    final /* synthetic */ int g;
    final /* synthetic */ String h;
    final /* synthetic */ boolean i;
    final /* synthetic */ w j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    y(w wVar, a.c cVar, String str, short s, String str2, int i2, String str3, boolean z) {
        super(cVar, str);
        this.j = wVar;
        this.e = s;
        this.f = str2;
        this.g = i2;
        this.h = str3;
        this.i = z;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        n<PlayingTimeData> a2 = i.a(this.e, this.f, this.g, this.h, this.i);
        EPGProgramData ePGProgramData = new EPGProgramData();
        b.a(((PlayingTimeData) a2.e).tvs, ePGProgramData);
        return new com.hzy.tvmao.b.a.a(a2.f4436a, a2.b, ePGProgramData);
    }
}
