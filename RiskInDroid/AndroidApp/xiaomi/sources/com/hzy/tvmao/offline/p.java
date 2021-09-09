package com.hzy.tvmao.offline;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.interf.IRequestResult;
import com.kookong.app.data.RcTestRemoteKeyListV3;

class p implements IRequestResult<RcTestRemoteKeyListV3> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a.c f4454a;
    final /* synthetic */ n b;

    p(n nVar, a.c cVar) {
        this.b = nVar;
        this.f4454a = cVar;
    }

    /* renamed from: a */
    public void onSuccess(String str, RcTestRemoteKeyListV3 rcTestRemoteKeyListV3) {
        this.f4454a.a(new com.hzy.tvmao.b.a.a(1, "", rcTestRemoteKeyListV3));
    }

    public void onFail(Integer num, String str) {
        this.f4454a.a(new com.hzy.tvmao.b.a.a(0));
    }
}
