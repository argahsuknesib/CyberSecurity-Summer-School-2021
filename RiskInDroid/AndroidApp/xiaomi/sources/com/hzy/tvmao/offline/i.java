package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.e;
import com.kookong.app.data.IrDataList;
import com.kookong.app.service.IRListServlet;

class i implements e.a<IrDataList> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4447a;
    final /* synthetic */ e b;

    i(e eVar, String str) {
        this.b = eVar;
        this.f4447a = str;
    }

    /* renamed from: a */
    public IrDataList b() throws Exception {
        return new IRListServlet().serviceImpl(this.b.a(), this.f4447a, b.b());
    }
}
