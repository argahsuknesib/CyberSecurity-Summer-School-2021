package com.miui.tsmclient.entity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.tsmclient.smartcard.ByteArray;

public class InAppTransData implements Parcelable {
    public static final Parcelable.Creator<InAppTransData> CREATOR = new Parcelable.Creator<InAppTransData>() {
        /* class com.miui.tsmclient.entity.InAppTransData.AnonymousClass1 */

        public final InAppTransData createFromParcel(Parcel parcel) {
            return new InAppTransData(parcel);
        }

        public final InAppTransData[] newArray(int i) {
            return new InAppTransData[i];
        }
    };
    private int mChannel;
    private String mCurrencyCode;
    private long mDiscountAmount;
    private String mEncryptPayAmount;
    private String mIccData;
    private String mMerchantId;
    private String mMerchantName;
    private int mMiTsmSignKeyIndex;
    private String mMiTsmSignedData;
    private long mOrderAmount;
    private String mOrderNumber;
    private long mPayAmount;
    private String mPayCardAppletAid;
    private String mPayCardPan;
    private String mPayCardVcReferenceId;
    private String mPromotionValue;
    private String mQueryId;
    private int mSignKeyIndex;
    private String mSignedData;
    private String mSupCardAttr;
    private int mVerifyMethod;

    public int describeContents() {
        return 0;
    }

    public InAppTransData() {
    }

    protected InAppTransData(Parcel parcel) {
        this.mOrderNumber = parcel.readString();
        this.mMerchantName = parcel.readString();
        this.mMerchantId = parcel.readString();
        this.mEncryptPayAmount = parcel.readString();
        this.mSignedData = parcel.readString();
        this.mCurrencyCode = parcel.readString();
        this.mSupCardAttr = parcel.readString();
        this.mOrderAmount = parcel.readLong();
        this.mDiscountAmount = parcel.readLong();
        this.mPayAmount = parcel.readLong();
        this.mSignKeyIndex = parcel.readInt();
        this.mChannel = parcel.readInt();
        this.mQueryId = parcel.readString();
        this.mPromotionValue = parcel.readString();
        this.mPayCardAppletAid = parcel.readString();
        this.mPayCardPan = parcel.readString();
        this.mPayCardVcReferenceId = parcel.readString();
        this.mIccData = parcel.readString();
        this.mMiTsmSignedData = parcel.readString();
        this.mVerifyMethod = parcel.readInt();
        this.mMiTsmSignKeyIndex = parcel.readInt();
    }

    public void setVerifyMethod(int i) {
        this.mVerifyMethod = i;
    }

    public void setQrToken(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPayCardPan = str;
        }
    }

    public String getMerchantName() {
        String str = this.mMerchantName;
        return str == null ? "" : str;
    }

    public String getOrderNumber() {
        String str = this.mOrderNumber;
        return str == null ? "" : str;
    }

    public String getMerchantId() {
        String str = this.mMerchantId;
        return str == null ? "" : str;
    }

    public String getEncryptPayAmount() {
        String str = this.mEncryptPayAmount;
        return str == null ? "" : str;
    }

    public String getSignedData() {
        String str = this.mSignedData;
        return str == null ? "" : str;
    }

    public String getCurrencyCode() {
        String str = this.mCurrencyCode;
        return str == null ? "" : str;
    }

    public String getPan() {
        String str = this.mPayCardPan;
        return str == null ? "" : str;
    }

    public String getPayCardAppletAid() {
        String str = this.mPayCardAppletAid;
        return str == null ? "" : str;
    }

    public void setMiTsmSignKeyIndex(int i) {
        this.mMiTsmSignKeyIndex = i;
    }

    public void setMiTsmSignedData(String str) {
        this.mMiTsmSignedData = str;
    }

    public long getOrderAmount() {
        return this.mOrderAmount;
    }

    public long getDiscountAmount() {
        return this.mDiscountAmount;
    }

    public long getPayAmount() {
        return this.mPayAmount;
    }

    public int getSignKeyIndex() {
        return this.mSignKeyIndex;
    }

    public int getChannel() {
        return this.mChannel;
    }

    public String getQueryId() {
        return this.mQueryId;
    }

    public void setPromotionValue(String str) {
        this.mPromotionValue = str;
    }

    public int getVerifyMethod() {
        return this.mVerifyMethod;
    }

    public void fillTransResponseData(ByteArray byteArray) {
        if (byteArray != null) {
            this.mIccData = byteArray.toString();
        }
    }

    public boolean isOrderSupPayCard(BankCardInfo bankCardInfo) {
        if (bankCardInfo == null) {
            return false;
        }
        String supCardAttr = getSupCardAttr();
        if (2 == bankCardInfo.mBankCardType) {
            if ("00".equals(supCardAttr) || "02".equals(supCardAttr)) {
                return true;
            }
            return false;
        } else if ("00".equals(supCardAttr) || "01".equals(supCardAttr)) {
            return true;
        } else {
            return false;
        }
    }

    public String getSupCardAttr() {
        return TextUtils.isEmpty(this.mSupCardAttr) ? "00" : this.mSupCardAttr;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("inapp_order_number", this.mOrderNumber);
        bundle.putString("inapp_merchant_name", this.mMerchantName);
        bundle.putString("inapp_merchant_id", this.mMerchantId);
        bundle.putString("inapp_signed_data", this.mMiTsmSignedData);
        bundle.putString("inapp_currency_code", this.mCurrencyCode);
        bundle.putString("inapp_vc_reference_id", this.mPayCardVcReferenceId);
        bundle.putLong("inapp_order_amount", this.mOrderAmount);
        bundle.putLong("inapp_discount_amount", this.mDiscountAmount);
        bundle.putLong("inapp_pay_amount", this.mPayAmount);
        bundle.putString("inapp_encrypt_pay_amount", this.mEncryptPayAmount);
        bundle.putInt("inapp_sign_key_index", this.mMiTsmSignKeyIndex);
        bundle.putInt("inapp_verify_method", this.mVerifyMethod);
        bundle.putString("inapp_order_sup_card_attr", this.mSupCardAttr);
        bundle.putString("inapp_query_Id", this.mQueryId);
        bundle.putString("inapp_promotion_value", this.mPromotionValue);
        bundle.putString("inapp_pan", this.mPayCardPan);
        if (EnvironmentConfig.isSupportNfc()) {
            bundle.putString("inapp_icc_data", this.mIccData);
        }
        return bundle;
    }

    public static InAppTransData newInstance(Bundle bundle) {
        InAppTransData inAppTransData = new InAppTransData();
        if (bundle != null) {
            inAppTransData.mOrderNumber = bundle.getString("inapp_order_number", "");
            inAppTransData.mMerchantName = bundle.getString("inapp_merchant_name", "");
            inAppTransData.mMerchantId = bundle.getString("inapp_merchant_id", "");
            inAppTransData.mOrderAmount = bundle.getLong("inapp_order_amount", 0);
            inAppTransData.mDiscountAmount = bundle.getLong("inapp_discount_amount", 0);
            inAppTransData.mPayAmount = bundle.getLong("inapp_pay_amount", 0);
            inAppTransData.mSignedData = bundle.getString("inapp_signed_data", "");
            inAppTransData.mSignKeyIndex = bundle.getInt("inapp_sign_key_index", 0);
            inAppTransData.mCurrencyCode = bundle.getString("inapp_currency_code", "");
            inAppTransData.mEncryptPayAmount = bundle.getString("inapp_encrypt_pay_amount", "");
            inAppTransData.mChannel = bundle.getInt("inapp_channel", -1);
            inAppTransData.mQueryId = bundle.getString("inapp_query_Id", "");
            inAppTransData.mPromotionValue = bundle.getString("inapp_promotion_value", "");
            inAppTransData.mSupCardAttr = bundle.getString("inapp_order_sup_card_attr", "00");
        }
        return inAppTransData;
    }

    public void fillPayCardInfo(BankCardInfo bankCardInfo) {
        if (bankCardInfo != null) {
            this.mPayCardPan = bankCardInfo.mVCardNumber;
            this.mPayCardVcReferenceId = bankCardInfo.mVCReferenceId;
            this.mPayCardAppletAid = bankCardInfo.mAid;
        }
    }

    public String toString() {
        return "InAppTransData{mOrderNumber='" + this.mOrderNumber + '\'' + ", mMerchantName='" + this.mMerchantName + '\'' + ", mMerchantId='" + this.mMerchantId + '\'' + ", mEncryptPayAmount='" + this.mEncryptPayAmount + '\'' + ", mSignedData='" + this.mSignedData + '\'' + ", mCurrencyCode='" + this.mCurrencyCode + '\'' + ", mSupCardAttr='" + this.mSupCardAttr + '\'' + ", mOrderAmount=" + this.mOrderAmount + ", mDiscountAmount=" + this.mDiscountAmount + ", mPayAmount=" + this.mPayAmount + ", mSignKeyIndex=" + this.mSignKeyIndex + ", mChannel=" + this.mChannel + ", mQueryId=" + this.mQueryId + ", mPromotionValue=" + this.mPromotionValue + ", mPayCardAppletAid='" + this.mPayCardAppletAid + '\'' + ", mPayCardPan='" + this.mPayCardPan + '\'' + ", mPayCardVcReferenceId='" + this.mPayCardVcReferenceId + '\'' + ", mIccData='" + this.mIccData + '\'' + ", mMiTsmSignedData='" + this.mMiTsmSignedData + '\'' + ", mVerifyMethod=" + this.mVerifyMethod + ", mMiTsmSignKeyIndex=" + this.mMiTsmSignKeyIndex + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mOrderNumber);
        parcel.writeString(this.mMerchantName);
        parcel.writeString(this.mMerchantId);
        parcel.writeString(this.mEncryptPayAmount);
        parcel.writeString(this.mSignedData);
        parcel.writeString(this.mCurrencyCode);
        parcel.writeString(this.mSupCardAttr);
        parcel.writeLong(this.mOrderAmount);
        parcel.writeLong(this.mDiscountAmount);
        parcel.writeLong(this.mPayAmount);
        parcel.writeInt(this.mSignKeyIndex);
        parcel.writeInt(this.mChannel);
        parcel.writeString(this.mQueryId);
        parcel.writeString(this.mPromotionValue);
        parcel.writeString(this.mPayCardAppletAid);
        parcel.writeString(this.mPayCardPan);
        parcel.writeString(this.mPayCardVcReferenceId);
        parcel.writeString(this.mIccData);
        parcel.writeString(this.mMiTsmSignedData);
        parcel.writeInt(this.mVerifyMethod);
        parcel.writeInt(this.mMiTsmSignKeyIndex);
    }
}
