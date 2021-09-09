package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.e;
import com.kookong.app.service.AddressServlet;

class j implements e.a<Integer> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4448a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ e d;

    j(e eVar, String str, String str2, String str3) {
        this.d = eVar;
        this.f4448a = str;
        this.b = str2;
        this.c = str3;
    }

    /* renamed from: a */
    public Integer b() throws Exception {
        return Integer.valueOf(new AddressServlet().serviceImpl(this.d.a(), this.f4448a, this.b, this.c));
    }
}
