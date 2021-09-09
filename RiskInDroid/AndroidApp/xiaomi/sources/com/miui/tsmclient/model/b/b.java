package com.miui.tsmclient.model.b;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.FmshCardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.m;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.util.LogUtils;

public class b extends m<FmshCardInfo> {

    /* renamed from: a  reason: collision with root package name */
    private a f3874a = new a();

    public b(String str) {
        super(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.e.e.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
     arg types: [android.content.Context, com.miui.tsmclient.entity.FmshCardInfo, ?[OBJECT, ARRAY]]
     candidates:
      com.miui.tsmclient.model.b.b.a(android.content.Context, com.miui.tsmclient.entity.FmshCardInfo, boolean):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.b.b.a(android.content.Context, com.miui.tsmclient.entity.FmshCardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.m.a(android.content.Context, com.miui.tsmclient.entity.PayableCardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.e.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse */
    private BaseResponse a(Context context, FmshCardInfo fmshCardInfo, boolean z) {
        if (fmshCardInfo.getUnfinishTransferOutInfo() != null) {
            Bundle bundle = new Bundle();
            if (d(context, fmshCardInfo, bundle).isSuccess()) {
                e(context, fmshCardInfo, bundle);
            }
        }
        BaseResponse a2 = a(context, (CardInfo) fmshCardInfo, (Bundle) null);
        if (!z || a2.mResultCode != 0 || !fmshCardInfo.mHasIssue || !fmshCardInfo.hasUnfinishedOrder()) {
            LogUtils.d(" unfinishedOrders size:" + fmshCardInfo.mUnfinishOrderInfos.size() + ", resultCode:" + a2.mResultCode);
        }
        return a2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.b.b.a(android.content.Context, com.miui.tsmclient.entity.FmshCardInfo, boolean):com.miui.tsmclient.model.BaseResponse
     arg types: [android.content.Context, com.miui.tsmclient.entity.FmshCardInfo, int]
     candidates:
      com.miui.tsmclient.model.b.b.a(android.content.Context, com.miui.tsmclient.entity.FmshCardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.m.a(android.content.Context, com.miui.tsmclient.entity.PayableCardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.e.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.i.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.i.a(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.b.b.a(android.content.Context, com.miui.tsmclient.entity.FmshCardInfo, boolean):com.miui.tsmclient.model.BaseResponse */
    public BaseResponse a(Context context, FmshCardInfo fmshCardInfo) {
        return a(context, fmshCardInfo, false);
    }

    /* renamed from: a */
    public BaseResponse c(Context context, FmshCardInfo fmshCardInfo, Bundle bundle) {
        return new BaseResponse(17, new Object[0]);
    }

    public BaseResponse a(Context context, FmshCardInfo fmshCardInfo, OrderInfo orderInfo, Tag tag, Bundle bundle) {
        return new BaseResponse(17, new Object[0]);
    }

    public void a() {
        this.f3874a.a();
    }

    public BaseResponse b(Context context, FmshCardInfo fmshCardInfo, Bundle bundle) {
        return new BaseResponse(17, new Object[0]);
    }

    /* renamed from: c */
    public BaseResponse g(Context context, FmshCardInfo fmshCardInfo, Bundle bundle) {
        return b(context, fmshCardInfo, bundle);
    }
}
