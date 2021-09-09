package com.hzy.tvmao;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.interf.IRequestResult;

final class i implements a.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IRequestResult f4420a;

    i(IRequestResult iRequestResult) {
        this.f4420a = iRequestResult;
    }

    public final void a(com.hzy.tvmao.b.a.a aVar) {
        KookongSDK.parseControlResponseBean(aVar, this.f4420a);
    }
}
