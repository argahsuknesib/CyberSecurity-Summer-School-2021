package com.miui.tsmclient.sesdk.tsmsdkcard;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.HttpClient;
import com.miui.tsmclient.entity.ActionToken;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.PayableCardInfo;
import com.miui.tsmclient.entity.VersionControlInfo;
import com.miui.tsmclient.entity.i;
import com.miui.tsmclient.model.BaseModel;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.BaseTransitCardModel;
import com.miui.tsmclient.model.m;
import com.miui.tsmclient.model.n;
import com.miui.tsmclient.model.o;
import com.miui.tsmclient.net.TSMAuthContants;
import com.miui.tsmclient.pay.OrderInfo;
import com.miui.tsmclient.sesdk.CardCategory;
import com.miui.tsmclient.sesdk.OrderData;
import com.miui.tsmclient.sesdk.SeCard;
import com.miui.tsmclient.sesdk.ServiceProtocolData;
import com.miui.tsmclient.sesdk.TransitCardDetail;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class TransitCard extends SeCard {
    private boolean mIsSupportTransferOut;
    private OrderData mOrderData;
    public ServiceProtocolData mServiceProtocolData;
    private BaseTransitCardModel mTransitCardModel = ((BaseTransitCardModel) BaseModel.create(EnvironmentConfig.getContext(), BaseTransitCardModel.class));

    TransitCard(CardInfo cardInfo) {
        super(cardInfo);
    }

    public void cloneExtraCardInfo() {
        if (this.mCardInfo.mCardUIInfo != null) {
            this.mCardFace = this.mCardInfo.mCardUIInfo.getBackground();
            this.mIsIssued = this.mCardInfo.mHasIssue;
        }
    }

    public SeCard.IOnlineProperties createOnlineProperties() {
        return new TransitCardDetail(this);
    }

    public CardCategory getCategory() {
        return CardCategory.TRANSIT;
    }

    public SeCard.SeData getContent() {
        return this.mSeData;
    }

    public String getDetail() {
        return new TransitCardDetail(this).toJson();
    }

    public int getExtraFlag() {
        if (this.mCardInfo.mSupportWearableReturnCard) {
            return 1;
        }
        return super.getExtraFlag();
    }

    public OrderData getOrderData() {
        if (this.mOrderData == null) {
            this.mOrderData = new OrderData(this, this.mCardInfo.mIssueFee);
        }
        return this.mOrderData;
    }

    public ServiceProtocolData getServiceProtocolData() throws IOException {
        ServiceProtocolData serviceProtocolData = this.mServiceProtocolData;
        if (serviceProtocolData != null) {
            return serviceProtocolData;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            b.a().a(EnvironmentConfig.getContext(), this.mCardInfo.mCardType, TSMAuthContants.ActionType.ISSUE, new b.a() {
                /* class com.miui.tsmclient.sesdk.tsmsdkcard.TransitCard.AnonymousClass1 */

                public void onFailure(Integer num) {
                    LogUtils.d("queryAllServiceProtocol onFailure, errorCode:".concat(String.valueOf(num)));
                    countDownLatch.countDown();
                }

                public void onSuccess(VersionControlInfo versionControlInfo) {
                    LogUtils.d("queryAllServiceProtocol onSuccess");
                    TransitCard transitCard = TransitCard.this;
                    transitCard.mServiceProtocolData = new ServiceProtocolData(versionControlInfo, transitCard.mCardInfo.mCardType);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            return this.mServiceProtocolData;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new IOException("getServiceProtocolData fails");
        }
    }

    public boolean isSupportReturnCard() {
        return this.mCardInfo.mSupportMoveCardReturnCard || this.mCardInfo.mSupportWearableReturnCard;
    }

    public boolean isSupportTransferOut() {
        return this.mIsSupportTransferOut;
    }

    public BaseResponse issue(String str) {
        Bundle buildExtras = buildExtras(str);
        if (this.mCityId != null) {
            buildExtras.putString("extra_city_id", this.mCityId);
        }
        if (this.mChannel != null) {
            buildExtras.putString("extra_source_channel", this.mChannel);
        }
        BaseResponse b = this.mCardOperation.b(EnvironmentConfig.getContext(), this.mCardInfo, buildExtras);
        if (b.isSuccess()) {
            this.mIsIssued = true;
        }
        return b;
    }

    public BaseResponse recharge(String str) {
        OrderInfo orderInfo;
        m mVar = (m) this.mCardOperation;
        Bundle buildExtras = buildExtras(str);
        if (!buildExtras.getBoolean("out_operation")) {
            OrderInfo orderInfo2 = new OrderInfo();
            orderInfo2.mCityId = this.mCityId;
            orderInfo2.mActionTokens = new ArrayList();
            ActionToken actionToken = new ActionToken();
            actionToken.mType = ActionToken.TokenType.recharge;
            actionToken.mToken = str;
            orderInfo2.mActionTokens.add(actionToken);
            orderInfo = orderInfo2;
        } else {
            orderInfo = null;
        }
        return mVar.a(EnvironmentConfig.getContext(), (PayableCardInfo) this.mCardInfo, orderInfo, null, buildExtras);
    }

    public BaseResponse returnCard(String str) {
        if (TextUtils.isEmpty(str)) {
            return ((n) n.create(EnvironmentConfig.getContext(), n.class)).a((PayableCardInfo) this.mCardInfo, this.mExtras);
        }
        Bundle buildExtras = buildExtras(str);
        if (buildExtras.getBoolean("out_operation")) {
            return this.mCardOperation.f(EnvironmentConfig.getContext(), this.mCardInfo, buildExtras);
        }
        throw new IllegalStateException("delete transit card must be call by authorised apps");
    }

    public BaseResponse transferIn(String str) {
        return this.mCardOperation.g(EnvironmentConfig.getContext(), this.mCardInfo, buildExtras(str));
    }

    public BaseResponse transferOut() {
        return ((o) BaseModel.create(EnvironmentConfig.getContext(), o.class)).a((PayableCardInfo) this.mCardInfo);
    }

    public void updateContent() throws IOException {
        ensureNotOnMainThread();
        Context context = EnvironmentConfig.getContext();
        CardInfo cardFromNetwork = this.mTransitCardModel.getCardFromNetwork(getId());
        if (cardFromNetwork != null) {
            this.mCardInfo = cardFromNetwork;
            LogUtils.v("updateContent card:" + cardFromNetwork.mHasIssue);
        }
        this.mIsIssued = this.mCardInfo.mHasIssue;
        try {
            CommonResponseInfo commonResponseInfo = (CommonResponseInfo) HttpClient.getInstance(context).execute(new com.miui.tsmclient.net.request.b(context, new i(this.mCardInfo, i.a.TRANSFER_OUT), null)).getResult();
            if (commonResponseInfo != null) {
                this.mIsSupportTransferOut = commonResponseInfo.isSuccess();
            }
        } catch (IOException e) {
            LogUtils.e("updateContent:isSupportTransferOut failed", e);
        }
        if (!this.mIsIssued) {
            this.mSeData = new SeCard.SeData(null);
            this.mIsSupportTransferOut = false;
            return;
        }
        BaseResponse a2 = this.mCardOperation.a(context, this.mCardInfo, null);
        if (a2.isSuccess()) {
            cloneExtraCardInfo();
            this.mSeData = new SeCard.SeData(this.mCardInfo);
            return;
        }
        throw new IOException(a2.mMsg);
    }
}
