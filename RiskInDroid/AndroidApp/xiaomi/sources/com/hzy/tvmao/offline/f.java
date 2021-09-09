package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.e;
import com.kookong.app.data.BrandList;
import com.kookong.app.service.BrandListServlet;

class f implements e.a<BrandList> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f4444a;
    final /* synthetic */ e b;

    f(e eVar, int i) {
        this.b = eVar;
        this.f4444a = i;
    }

    /* renamed from: a */
    public BrandList b() throws Exception {
        return new BrandListServlet().serviceImpl(this.b.a(), this.f4444a, b.a(), b.b());
    }
}
