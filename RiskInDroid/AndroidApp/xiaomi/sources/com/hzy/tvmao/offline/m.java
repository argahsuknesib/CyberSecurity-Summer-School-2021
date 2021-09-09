package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.e;
import com.kookong.app.data.CountryList;
import com.kookong.app.service.CountryListServlet;

class m implements e.a<CountryList> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f4451a;

    m(e eVar) {
        this.f4451a = eVar;
    }

    /* renamed from: a */
    public CountryList b() throws Exception {
        return new CountryListServlet().serviceImpl(this.f4451a.a(), b.b());
    }
}
