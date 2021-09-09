package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.util.LogUtils;
import com.tsmclient.smartcard.terminal.IScTerminal;
import org.json.JSONException;
import org.json.JSONObject;

public class QrBankCardInfo extends BankCardInfo {
    public static final Parcelable.Creator<QrBankCardInfo> CREATOR = new Parcelable.Creator<QrBankCardInfo>() {
        /* class com.miui.tsmclient.entity.QrBankCardInfo.AnonymousClass1 */

        public final QrBankCardInfo createFromParcel(Parcel parcel) {
            QrBankCardInfo qrBankCardInfo = new QrBankCardInfo();
            qrBankCardInfo.readFromParcel(parcel);
            return qrBankCardInfo;
        }

        public final QrBankCardInfo[] newArray(int i) {
            return new QrBankCardInfo[i];
        }
    };
    public String mBgImage;

    public boolean hasQRToken() {
        return true;
    }

    public boolean isQrBankCard() {
        return true;
    }

    public QrBankCardInfo() {
        super("QRBANKCARD");
        this.mCardGroupId = CardGroupType.QRBANKCARD.getId();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mBgImage);
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mBgImage = parcel.readString();
    }

    public IScTerminal getTerminal() {
        throw new UnsupportedOperationException("this card not support terminal");
    }

    public JSONObject serialize() {
        JSONObject serialize = super.serialize();
        try {
            serialize.put("bg_image", this.mBgImage);
        } catch (JSONException e) {
            LogUtils.e("serialize qrbankcard info to json object failed!", e);
        }
        return serialize;
    }

    public CardInfo parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            super.parse(jSONObject);
            this.mBgImage = jSONObject.optString("bg_image");
        }
        return this;
    }

    public boolean isSameReferenceId(String str) {
        return TextUtils.equals(this.mVCReferenceId, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardInfo)) {
            return false;
        }
        return TextUtils.equals(this.mVCReferenceId, ((QrBankCardInfo) obj).mVCReferenceId);
    }

    public void setQrBankCardInfo(TsmRpcModels.CardIssuerInfo cardIssuerInfo) {
        this.mIssuerChannel = cardIssuerInfo.getCardIssueChannel().getNumber();
        this.mIssuerId = cardIssuerInfo.getIssuerId();
        this.mBankName = cardIssuerInfo.getBankName();
        this.mBankLogoUrl = cardIssuerInfo.getLogoUrl();
        this.mBankLogoWithNameUrl = cardIssuerInfo.getLogoWithBankNameUrl();
        this.mBankContactNum = cardIssuerInfo.getContactNumber();
        this.mBgImage = cardIssuerInfo.getBgImage();
        this.mServiceHotline = cardIssuerInfo.getHotline();
    }
}
