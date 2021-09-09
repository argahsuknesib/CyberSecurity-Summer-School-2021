package com.miui.tsmclient.model.a;

import android.content.Context;
import android.os.Bundle;
import com.miui.tsmclient.entity.QrBankCardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.e;
import com.miui.tsmclient.seitsm.TsmRpcModels;

public class d extends e<c, QrBankCardInfo> {
    public BaseResponse a(Context context, QrBankCardInfo qrBankCardInfo) {
        BaseResponse a2 = ((c) this.b).a(context);
        if (a2.mResultCode == 0) {
            a2.mDatas[0] = c.a(((TsmRpcModels.BankCardListForQrResponse) a2.mDatas[0]).getCardInfoListList());
        }
        return a2;
    }

    /* renamed from: a */
    public BaseResponse c(Context context, QrBankCardInfo qrBankCardInfo, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("card_reference_id", qrBankCardInfo.mVCReferenceId);
        return ((c) this.b).a(context, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public c c() {
        return new c();
    }
}
