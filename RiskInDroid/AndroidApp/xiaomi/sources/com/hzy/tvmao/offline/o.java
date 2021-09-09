package com.hzy.tvmao.offline;

import com.hzy.tvmao.offline.e;
import com.kookong.app.data.RcTestRemoteKeyListV3;
import com.kookong.app.service.RcTestKeyServlet;

class o implements e.a<RcTestRemoteKeyListV3> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4453a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ n d;

    o(n nVar, String str, String str2, String str3) {
        this.d = nVar;
        this.f4453a = str;
        this.b = str2;
        this.c = str3;
    }

    /* renamed from: a */
    public RcTestRemoteKeyListV3 b() throws Exception {
        return new RcTestKeyServlet().serviceImplV3(this.d.f4452a.a(), Integer.parseInt(this.f4453a), Integer.parseInt(this.b), this.c, b.b());
    }
}
