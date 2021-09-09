package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.e;
import com.kookong.app.data.RemoteList;
import com.kookong.app.service.RemoteListServlet;

class g implements e.a<RemoteList> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4445a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ e e;

    g(e eVar, int i, int i2, int i3, int i4) {
        this.e = eVar;
        this.f4445a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    /* renamed from: a */
    public RemoteList b() throws Exception {
        return new RemoteListServlet().serviceImpl(this.e.a(), this.f4445a, this.b, this.c, this.d, b.a());
    }
}
