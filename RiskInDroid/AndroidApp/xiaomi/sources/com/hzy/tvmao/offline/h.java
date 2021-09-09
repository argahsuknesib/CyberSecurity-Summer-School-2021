package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.e;
import com.kookong.app.data.RemoteList;
import com.kookong.app.service.RemoteListServlet;

class h implements e.a<RemoteList> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4446a;
    final /* synthetic */ int b;
    final /* synthetic */ e c;

    h(e eVar, int i, int i2) {
        this.c = eVar;
        this.f4446a = i;
        this.b = i2;
    }

    /* renamed from: a */
    public RemoteList b() throws Exception {
        return new RemoteListServlet().serviceImpl(this.c.a(), this.f4446a, this.b, 0, 0, b.a());
    }
}
