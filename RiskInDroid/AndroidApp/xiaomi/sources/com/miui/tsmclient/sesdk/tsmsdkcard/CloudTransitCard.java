package com.miui.tsmclient.sesdk.tsmsdkcard;

import android.content.Context;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.net.request.g;
import com.miui.tsmclient.sesdk.CardCategory;
import com.miui.tsmclient.sesdk.CloudTransitCardDetail;
import com.miui.tsmclient.sesdk.SeCard;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import java.io.IOException;

class CloudTransitCard extends SeCard {
    CloudTransitCard(CardInfo cardInfo) {
        super(cardInfo);
    }

    public void cloneExtraCardInfo() {
        if (this.mCardInfo.mCardUIInfo != null) {
            this.mCardFace = this.mCardInfo.mCardUIInfo.getBackground();
        }
    }

    public SeCard.IOnlineProperties createOnlineProperties() {
        return new CloudTransitCardDetail(this);
    }

    public CardCategory getCategory() {
        return CardCategory.CLOUD_TRANSIT;
    }

    public String getDetail() {
        return new CloudTransitCardDetail(this).toJson();
    }

    public BaseResponse transferIn(String str) {
        Context context = EnvironmentConfig.getContext();
        if (!(this.mCardInfo instanceof PayableCardInfo)) {
            return new BaseResponse(1, new Object[0]);
        }
        PayableCardInfo payableCardInfo = (PayableCardInfo) this.mCardInfo;
        if (!payableCardInfo.hasTransferInOrder()) {
            LogUtils.e("cloud card has no transfer order");
            return new BaseResponse(1, new Object[0]);
        }
        g gVar = new g(context, payableCardInfo, null);
        try {
            com.miui.tsmclient.entity.g gVar2 = (com.miui.tsmclient.entity.g) HttpClient.getInstance(context).execute(gVar).getResult();
            if (!gVar.isSuccess()) {
                return new BaseResponse(gVar2.getErrorCode(), gVar2.getErrorDesc(), new Object[0]);
            }
            if (!(gVar2.a() == null || gVar2.a().getIssueOrWithdrawOrderToken() == null)) {
                str = gVar2.a().getIssueOrWithdrawOrderToken().mToken;
            }
            return this.mCardOperation.g(EnvironmentConfig.getContext(), this.mCardInfo, buildExtras(str));
        } catch (IOException e) {
            LogUtils.e("StartTransferInRequest failed", e);
            return new BaseResponse(2, new Object[0]);
        }
    }
}
