package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.e;
import com.kookong.app.data.StbList;
import com.kookong.app.service.IPTVListServlet;

class l implements e.a<StbList> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f4450a;

    l(e eVar) {
        this.f4450a = eVar;
    }

    /* renamed from: a */
    public StbList b() throws Exception {
        return new IPTVListServlet().serviceImpl(this.f4450a.a());
    }
}
