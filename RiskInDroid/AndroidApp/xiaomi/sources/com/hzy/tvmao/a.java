package com.hzy.tvmao;

import com.hzy.tvmao.KKSingleMatchManager;
import com.hzy.tvmao.b.a;
import com.hzy.tvmao.b.ae;

class a implements KKSingleMatchManager.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KKSingleMatchManager f4406a;

    a(KKSingleMatchManager kKSingleMatchManager) {
        this.f4406a = kKSingleMatchManager;
    }

    public void a(String str, String str2, String str3, boolean z, a.c cVar) {
        if (this.f4406a.singleKeyControl == null) {
            this.f4406a.singleKeyControl = new ae();
        }
        this.f4406a.singleKeyControl.a(str, str2, str3, z, cVar);
    }
}
