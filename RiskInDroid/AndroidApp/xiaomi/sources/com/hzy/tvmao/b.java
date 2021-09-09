package com.hzy.tvmao;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.interf.ISingleMatchResult;
import com.hzy.tvmao.utils.LogUtil;
import com.kookong.app.data.RcTestRemoteKeyListV3;

class b implements a.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ISingleMatchResult f4408a;
    final /* synthetic */ KKSingleMatchManager b;

    b(KKSingleMatchManager kKSingleMatchManager, ISingleMatchResult iSingleMatchResult) {
        this.b = kKSingleMatchManager;
        this.f4408a = iSingleMatchResult;
    }

    public void a(com.hzy.tvmao.b.a.a aVar) {
        if (!aVar.d() || aVar.c() == null) {
            LogUtil.d("接口错误：" + aVar.b());
            this.f4408a.onError();
            return;
        }
        RcTestRemoteKeyListV3 rcTestRemoteKeyListV3 = (RcTestRemoteKeyListV3) aVar.c();
        LogUtil.d("group key size：" + rcTestRemoteKeyListV3.remoteKeyList.size());
        LogUtil.d("defaultRemoteId：" + rcTestRemoteKeyListV3.defaultRemoteId);
        if (rcTestRemoteKeyListV3.defaultRemoteId != 0) {
            int i = rcTestRemoteKeyListV3.defaultRemoteId;
            LogUtil.d("匹配到remoteId：".concat(String.valueOf(i)));
            this.f4408a.onMatchedIR(String.valueOf(i));
        } else if (rcTestRemoteKeyListV3.remoteKeyList.size() == 0) {
            LogUtil.d("没有匹配到对应的遥控器");
            this.f4408a.onNotMatchIR();
        } else {
            this.f4408a.onNextGroupKey(rcTestRemoteKeyListV3.remoteKeyList);
        }
    }
}
