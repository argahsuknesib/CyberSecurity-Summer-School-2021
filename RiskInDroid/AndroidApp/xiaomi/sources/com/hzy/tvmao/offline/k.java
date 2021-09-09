package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.e;
import com.kookong.app.data.SpList;
import com.kookong.app.service.SpListServlet;

class k implements e.a<SpList> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4449a;
    final /* synthetic */ e b;

    k(e eVar, int i) {
        this.b = eVar;
        this.f4449a = i;
    }

    /* renamed from: a */
    public SpList b() throws Exception {
        return new SpListServlet().serviceImpl(this.b.a(), this.f4449a);
    }
}
