package com.miui.tsmclient.sesdk.tsmsdkcard;

import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.net.AuthApiException;
import com.miui.tsmclient.sesdk.CardCategory;
import com.miui.tsmclient.sesdk.KeyCardDetail;
import com.miui.tsmclient.sesdk.SeCard;
import com.miui.tsmclient.sesdk.SeCardStatus;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import java.io.IOException;

class KeyCard extends SeCard {
    KeyCard(CardInfo cardInfo, boolean z) {
        super(cardInfo, z);
    }

    public BaseResponse activate(String str) {
        int i;
        String str2;
        LogUtils.d("activateCode:".concat(String.valueOf(str)));
        ensureNotOnMainThread();
        try {
            this.mCardInfo.parseCardFromJson(this.mTSMAuthManager.updateCardBaseInfo(EnvironmentConfig.getContext(), this.mCardInfo.getUpdateArtContent()));
            ((MifareCardInfo) this.mCardInfo).mVCStatus = SeCardStatus.ACTIVE.ordinal();
            cloneCard(this.mCardInfo);
            str2 = "";
            i = 0;
        } catch (AuthApiException e) {
            LogUtils.e("activate failed", e);
            i = 7;
            str2 = e.getMessage();
        }
        return new BaseResponse(i, str2, new Object[0]);
    }

    public void cloneExtraCardInfo() {
        MifareCardInfo mifareCardInfo = (MifareCardInfo) this.mCardInfo;
        this.mCardFace = mifareCardInfo.mCardArt;
        this.mProductId = mifareCardInfo.getProductId();
        this.mIsIssued = !TextUtils.isEmpty(this.mCardInfo.mAid);
    }

    public SeCard.IOnlineProperties createOnlineProperties() {
        return new KeyCardDetail(this);
    }

    public BaseResponse delete(String str) {
        return this.mCardOperation.c(EnvironmentConfig.getContext(), this.mCardInfo, buildExtras(str));
    }

    public CardCategory getCategory() {
        return CardCategory.DOOR;
    }

    public SeCard.SeData getContent() {
        return this.mSeData;
    }

    public String getDetail() {
        return new KeyCardDetail(this).toJson();
    }

    public BaseResponse issue(String str) {
        Bundle buildExtras = buildExtras(str);
        buildExtras.putString("extra_mifare_door_card_issuer_token", str);
        if (this.mProductId != null) {
            buildExtras.putString("extra_door_card_product_id", this.mProductId);
        }
        BaseResponse b = this.mCardOperation.b(EnvironmentConfig.getContext(), this.mCardInfo, buildExtras);
        if (b.isSuccess()) {
            this.mIsIssued = true;
            cloneCard(this.mCardInfo);
        }
        return b;
    }

    public void setCardName(String str) {
        this.mCardName = str;
        this.mCardInfo.mCardName = str;
    }

    public void updateContent() throws IOException {
        ensureNotOnMainThread();
        LogUtils.d("updateContent door card aid = " + this.mCardInfo.mAid);
        BaseResponse a2 = this.mCardOperation.a(EnvironmentConfig.getContext(), this.mCardInfo);
        if (a2.isSuccess()) {
            cloneCard(this.mCardInfo);
            this.mCardInfo.mHasIssue = this.mIsIssued;
            this.mSeData = new SeCard.SeData(this.mCardInfo, ((MifareCardInfo) this.mCardInfo).mVCStatus);
            return;
        }
        throw new IOException(a2.mMsg);
    }
}
