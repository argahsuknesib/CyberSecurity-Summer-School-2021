package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.api.LineupData;

class p extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ n h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(n nVar, a.c cVar, String str, int i, int i2, int i3) {
        super(cVar, str);
        this.h = nVar;
        this.e = i;
        this.f = i2;
        this.g = i3;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        n<LineupData> c = i.c(this.e, this.f);
        if (c.e != null) {
            com.hzy.tvmao.model.db.a.a.a().a(this.g, this.f, ((LineupData) c.e).list);
        }
        this.h.a(this.g);
        return new com.hzy.tvmao.b.a.a(1, null, "Save lineup data whose lineupid is " + this.f + " success !");
    }
}
