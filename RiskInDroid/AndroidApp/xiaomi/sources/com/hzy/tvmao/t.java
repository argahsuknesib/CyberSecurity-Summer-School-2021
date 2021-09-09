package com.hzy.tvmao;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.interf.IRequestResult;

final class t implements a.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IRequestResult f4468a;

    t(IRequestResult iRequestResult) {
        this.f4468a = iRequestResult;
    }

    public final void a(com.hzy.tvmao.b.a.a aVar) {
        KookongSDK.parseControlResponseBean(aVar, this.f4468a);
    }
}
