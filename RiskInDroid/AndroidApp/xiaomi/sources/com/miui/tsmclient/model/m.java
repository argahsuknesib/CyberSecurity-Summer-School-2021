package com.miui.tsmclient.model;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardConfigManager;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.model.e.b;
import com.miui.tsmclient.model.e.e;
import com.miui.tsmclient.pay.OrderInfo;

public class m<C extends PayableCardInfo> extends e<k, C> implements j<C> {
    public m(String str) {
        if (CardConfigManager.getInstance().getOperationType(str) == CardConfigManager.CardConfig.OperationType.ASYNC) {
            this.b = new a(new b(this.b));
        } else {
            this.b = new k(this.b);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.e.e.a(android.content.Context, com.miui.tsmclient.entity.CardInfo):com.miui.tsmclient.model.BaseResponse
     arg types: [android.content.Context, com.miui.tsmclient.entity.PayableCardInfo]
     candidates:
      com.miui.tsmclient.model.m.a(android.content.Context, com.miui.tsmclient.entity.PayableCardInfo):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.e.a(android.content.Context, com.miui.tsmclient.entity.CardInfo):com.miui.tsmclient.model.BaseResponse */
    public BaseResponse a(Context context, PayableCardInfo payableCardInfo) {
        return super.a(context, (CardInfo) payableCardInfo);
    }

    /* renamed from: a */
    public BaseResponse h(Context context, PayableCardInfo payableCardInfo, Bundle bundle) {
        return ((k) this.b).a_(context, payableCardInfo, bundle);
    }

    public BaseResponse a(Context context, PayableCardInfo payableCardInfo, OrderInfo orderInfo, Tag tag, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (orderInfo != null && !TextUtils.isEmpty(orderInfo.mCityId)) {
            bundle2.putString("extra_city_id", orderInfo.mCityId);
        }
        BaseResponse a2 = ((k) this.b).a(context, payableCardInfo, orderInfo, tag, bundle2);
        if (a2.mResultCode == 0) {
            payableCardInfo.mUnfinishOrderInfos.remove(orderInfo);
        }
        return a2;
    }
}
