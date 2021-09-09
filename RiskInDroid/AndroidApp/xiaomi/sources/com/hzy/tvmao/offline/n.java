package com.hzy.tvmao.offline;

import com.hzy.tvmao.KKSingleMatchManager;
import com.hzy.tvmao.b.a;
import com.hzy.tvmao.utils.LogUtil;

class n implements KKSingleMatchManager.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f4452a;

    n(e eVar) {
        this.f4452a = eVar;
    }

    public void a(String str, String str2, String str3, boolean z, a.c cVar) {
        try {
            LogUtil.d(str + "|||" + str2 + "|||" + str3 + "|||" + z);
            this.f4452a.b.a(new o(this, str, str2, str3), new p(this, cVar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
