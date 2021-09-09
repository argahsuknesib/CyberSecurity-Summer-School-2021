package com.hzy.tvmao.offline;

import com.hzy.tvmao.interf.IRequestResult;
import com.hzy.tvmao.offline.SDKSwitcher;
import com.hzy.tvmao.offline.e;

class y implements e.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SDKSwitcher f4462a;

    y(SDKSwitcher sDKSwitcher) {
        this.f4462a = sDKSwitcher;
    }

    public <T> void a(e.a<T> aVar, IRequestResult<T> iRequestResult) {
        new SDKSwitcher.a(aVar, iRequestResult).execute(new Void[0]);
    }
}
