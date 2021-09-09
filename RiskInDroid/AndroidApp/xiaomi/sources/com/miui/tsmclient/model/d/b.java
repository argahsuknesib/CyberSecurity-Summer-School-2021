package com.miui.tsmclient.model.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.entity.e;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.e;
import com.miui.tsmclient.model.h;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.PrefUtils;
import com.miui.tsmclient.util.a;
import java.util.List;

public class b extends e<a, MifareCardInfo> {
    private void a(Context context, e.a aVar, CardInfo cardInfo) {
        if (aVar != null && cardInfo != null) {
            cardInfo.setKeepActivated(aVar.a(cardInfo.mAid));
            if (cardInfo.isKeepActivated()) {
                String str = PrefUtils.PREF_KEY_KEEP_ACTIVATED_STATUS_PREFIX + cardInfo.mAid;
                if (!PrefUtils.getBoolean(context, str, false)) {
                    PrefUtils.putBoolean(context, str, a.b(context, cardInfo));
                }
            }
        }
    }

    private BaseResponse b(Context context, CardInfo cardInfo) {
        if (cardInfo != null && cardInfo.isMiFareCard()) {
            MifareCardInfo mifareCardInfo = (MifareCardInfo) cardInfo;
            if (mifareCardInfo.isCommunityDoorCardV3()) {
                return ((a) this.b).a(context, mifareCardInfo);
            }
        }
        return new BaseResponse(0, new Object[0]);
    }

    public BaseResponse a(Context context, MifareCardInfo mifareCardInfo) {
        BaseResponse a2;
        h.a().b();
        e.a b = e.a.b(context);
        if (b == null) {
            b = e.a.a(context);
        }
        if (mifareCardInfo == null || TextUtils.isEmpty(mifareCardInfo.mAid)) {
            if (PrefUtils.getBoolean(context, "key_notify_server_update_card", false)) {
                List<CardInfo> a3 = com.miui.tsmclient.database.a.a(context, "MIFARE_ENTRANCE");
                if (a3 != null && ((a2 = ((a) this.b).a(context, (MifareCardInfo[]) a3.toArray(new MifareCardInfo[a3.size()]))) == null || a2.mResultCode != 0)) {
                    return a2;
                }
                PrefUtils.putBoolean(context, "key_notify_server_update_card", false);
            }
            BaseResponse a4 = ((a) this.b).a(context);
            if (a4.mResultCode == 0) {
                List<MifareCardInfo> a5 = a.a(context, ((TsmRpcModels.QueryDoorCardInfoResponse) a4.mDatas[0]).getCardInfoListList());
                a4.mDatas[0] = a5;
                for (CardInfo next : a5) {
                    a(context, b, next);
                    if (!b(context, next).isSuccess()) {
                        LogUtils.d(next.mAid + "updateCommunityCardFlowStatus failed");
                    }
                }
            }
            return a4;
        }
        BaseResponse a6 = ((a) this.b).a(context, mifareCardInfo);
        a(context, b, mifareCardInfo);
        if (a6 == null || !a6.isSuccess()) {
            return a6;
        }
        BaseResponse b2 = b(context, mifareCardInfo);
        if (b2.isSuccess()) {
            return b2;
        }
        LogUtils.d(mifareCardInfo.mAid + " updateCommunityCardFlowStatus failed");
        return b2;
    }

    /* renamed from: a */
    public BaseResponse b(Context context, MifareCardInfo mifareCardInfo, Bundle bundle) {
        BaseResponse a2 = ((a) this.b).a(context, mifareCardInfo, bundle);
        if (a2 != null && a2.isSuccess()) {
            e.a.a(context);
        }
        return a2;
    }

    /* renamed from: b */
    public BaseResponse a(Context context, MifareCardInfo mifareCardInfo, Bundle bundle) {
        return new BaseResponse(0, mifareCardInfo);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public a c() {
        return new a();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.miui.tsmclient.model.e.e.c(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
     arg types: [android.content.Context, com.miui.tsmclient.entity.MifareCardInfo, android.os.Bundle]
     candidates:
      com.miui.tsmclient.model.d.b.c(android.content.Context, com.miui.tsmclient.entity.MifareCardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse
      com.miui.tsmclient.model.e.e.c(android.content.Context, com.miui.tsmclient.entity.CardInfo, android.os.Bundle):com.miui.tsmclient.model.BaseResponse */
    public BaseResponse c(Context context, MifareCardInfo mifareCardInfo, Bundle bundle) {
        if (mifareCardInfo.isApplying()) {
            return ((a) this.b).b(context, mifareCardInfo.getBusinessId());
        }
        bundle.putString("door_card_business_id", mifareCardInfo.getBusinessId());
        BaseResponse c = super.c(context, (CardInfo) mifareCardInfo, bundle);
        if (c.isSuccess()) {
            PrefUtils.remove(context, PrefUtils.PREF_KEY_KEEP_ACTIVATED_STATUS_PREFIX + mifareCardInfo.mAid);
        }
        return c;
    }
}
