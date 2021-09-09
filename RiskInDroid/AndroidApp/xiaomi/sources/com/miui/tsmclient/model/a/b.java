package com.miui.tsmclient.model.a;

import android.content.Context;
import android.os.Bundle;
import com.miui.tsmclient.entity.BankCardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.e;
import com.miui.tsmclient.seitsm.TsmRpcModels;

public class b extends e<a, BankCardInfo> {
    public BaseResponse a(Context context) {
        return ((a) this.b).a(context);
    }

    public BaseResponse a(Context context, BankCardInfo bankCardInfo) {
        BaseResponse a2 = ((a) this.b).a(context, bankCardInfo == null ? null : bankCardInfo.mAid);
        if (a2.mResultCode == 0) {
            a2.mDatas[0] = a.a(((TsmRpcModels.QueryBankCardInfoResponse) a2.mDatas[0]).getBankCardInfoListList());
        }
        return a2;
    }

    /* renamed from: a */
    public BaseResponse b(Context context, BankCardInfo bankCardInfo, Bundle bundle) {
        return ((a) this.b).a(context, bankCardInfo, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public a c() {
        return new a();
    }
}
