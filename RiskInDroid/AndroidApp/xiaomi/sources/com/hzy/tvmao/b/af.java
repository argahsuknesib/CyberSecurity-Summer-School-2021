package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.kookong.app.data.RcTestRemoteKeyListV3;

class af extends a.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4412a;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ boolean g;
    final /* synthetic */ ae h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    af(ae aeVar, a.c cVar, String str, String str2, String str3, String str4, boolean z) {
        super(cVar, str);
        this.h = aeVar;
        this.f4412a = str2;
        this.e = str3;
        this.f = str4;
        this.g = z;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        n<RcTestRemoteKeyListV3> nVar;
        try {
            nVar = i.a(this.f4412a, this.e, this.f, this.g);
        } catch (Exception e2) {
            e2.printStackTrace();
            nVar = null;
        }
        return new com.hzy.tvmao.b.a.a(nVar);
    }
}
