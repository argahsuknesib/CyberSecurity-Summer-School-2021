package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.miui.tsmclient.util.LogUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class BankCardInfo extends CardInfo {
    public static final Parcelable.Creator<BankCardInfo> CREATOR = new Parcelable.Creator<BankCardInfo>() {
        /* class com.miui.tsmclient.entity.BankCardInfo.AnonymousClass1 */

        public final BankCardInfo createFromParcel(Parcel parcel) {
            BankCardInfo bankCardInfo = new BankCardInfo();
            bankCardInfo.readFromParcel(parcel);
            return bankCardInfo;
        }

        public final BankCardInfo[] newArray(int i) {
            return new BankCardInfo[i];
        }
    };
    public String mBankCardPan;
    public int mBankCardType;
    public String mBankContactNum;
    public String mBankLogoUrl;
    public String mBankLogoWithNameUrl;
    public String mBankName;
    public String mCardArt;
    private int mCardElementsOption;
    public String mCardFrontColor;
    public String mCardProductName;
    public String mCardProductTypeId;
    public boolean mHasQRToken;
    public int mIssuerChannel;
    public String mIssuerId;
    public String mPanLastDigits;
    public String mPhoneLastDigits;
    public String mServiceHotline;
    public boolean mShowBankNameSuffix;
    public String mSuggestion;
    public String mUserTerms;
    public String mVCReferenceId;
    public int mVCStatus;
    public String mVCardNumber;

    public boolean hasQRProperty() {
        return true;
    }

    public boolean isBankCard() {
        return true;
    }

    public boolean isQrBankCard() {
        return false;
    }

    public BankCardInfo() {
        this("BANKCARD");
    }

    public BankCardInfo(String str) {
        super(str);
        this.mShowBankNameSuffix = true;
        this.mCardName = "Mi Pay";
        this.mIsSecure = true;
        this.mCardGroupId = CardGroupType.BANKCARD.getId();
    }

    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.mCardName);
            jSONObject.put("card_no", this.mCardNo);
            jSONObject.put("aid", this.mAid);
            jSONObject.put("bank_card_pan", this.mBankCardPan);
            jSONObject.put("bank_card_type", this.mBankCardType);
            jSONObject.put("bank_card_vc_reference_id", this.mVCReferenceId);
            jSONObject.put("bank_card_vc_card_num", this.mVCardNumber);
            jSONObject.put("bank_card_product_id", this.mCardProductTypeId);
            jSONObject.put("bank_card_issuer_id", this.mIssuerId);
            jSONObject.put("bank_card_product_name", this.mCardProductName);
            jSONObject.put("card_user_terms", this.mUserTerms);
            jSONObject.put("card_art", this.mCardArt);
            jSONObject.put("card_vc_status", this.mVCStatus);
            jSONObject.put("bank_card_issuer_channel", this.mIssuerChannel);
            jSONObject.put("bank_card_pan_last_digits", this.mPanLastDigits);
            jSONObject.put("bank_name", this.mBankName);
            jSONObject.put("bank_logo_url", this.mBankLogoUrl);
            jSONObject.put("bank_logo_with_name_url", this.mBankLogoWithNameUrl);
            jSONObject.put("bank_card_front_color", this.mCardFrontColor);
            jSONObject.put("bank_contact_num", this.mBankContactNum);
            jSONObject.put("card_qr_token", this.mHasQRToken);
            jSONObject.put("card_service_hotline", this.mServiceHotline);
            jSONObject.put("card_suggestion", this.mSuggestion);
            jSONObject.put("card_element_option", this.mCardElementsOption);
        } catch (JSONException e) {
            LogUtils.e("serialize bankcard info to json object failed!", e);
        }
        return jSONObject;
    }

    public CardInfo parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mCardName = jSONObject.optString("title");
            if (jSONObject.has("card_no")) {
                this.mCardNo = jSONObject.optString("card_no");
            }
            this.mAid = jSONObject.optString("aid");
            this.mBankCardPan = jSONObject.optString("bank_card_pan");
            this.mBankCardType = jSONObject.optInt("bank_card_type");
            this.mVCReferenceId = jSONObject.optString("bank_card_vc_reference_id");
            this.mVCardNumber = jSONObject.optString("bank_card_vc_card_num");
            this.mCardProductTypeId = jSONObject.optString("bank_card_product_id");
            this.mIssuerId = jSONObject.optString("bank_card_issuer_id");
            this.mCardProductName = jSONObject.optString("bank_card_product_name");
            this.mUserTerms = jSONObject.optString("card_user_terms");
            this.mCardArt = jSONObject.optString("card_art");
            this.mVCStatus = jSONObject.optInt("card_vc_status");
            this.mIssuerChannel = jSONObject.optInt("bank_card_issuer_channel");
            this.mPanLastDigits = jSONObject.optString("bank_card_pan_last_digits");
            this.mBankName = jSONObject.optString("bank_name");
            this.mBankLogoUrl = jSONObject.optString("bank_logo_url");
            this.mBankLogoWithNameUrl = jSONObject.optString("bank_logo_with_name_url");
            this.mCardFrontColor = jSONObject.optString("bank_card_front_color");
            this.mBankContactNum = jSONObject.optString("bank_contact_num");
            this.mHasQRToken = jSONObject.optBoolean("card_qr_token");
            this.mServiceHotline = jSONObject.optString("card_service_hotline");
            this.mSuggestion = jSONObject.optString("card_suggestion");
            this.mCardElementsOption = jSONObject.optInt("card_element_option");
        }
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCardName);
        parcel.writeString(this.mCardNo);
        parcel.writeString(this.mAid);
        parcel.writeString(this.mBankCardPan);
        parcel.writeInt(this.mBankCardType);
        parcel.writeString(this.mVCReferenceId);
        parcel.writeString(this.mVCardNumber);
        parcel.writeString(this.mCardProductTypeId);
        parcel.writeString(this.mIssuerId);
        parcel.writeString(this.mCardProductName);
        parcel.writeString(this.mUserTerms);
        parcel.writeString(this.mCardArt);
        parcel.writeInt(this.mVCStatus);
        parcel.writeString(this.mPhoneLastDigits);
        parcel.writeInt(this.mIssuerChannel);
        parcel.writeString(this.mPanLastDigits);
        parcel.writeString(this.mBankName);
        parcel.writeString(this.mBankLogoUrl);
        parcel.writeString(this.mBankLogoWithNameUrl);
        parcel.writeString(this.mCardFrontColor);
        parcel.writeString(this.mBankContactNum);
        parcel.writeInt(this.mHasQRToken ^ true ? 1 : 0);
        parcel.writeString(this.mServiceHotline);
        parcel.writeInt(this.mShowBankNameSuffix ? 1 : 0);
        parcel.writeInt(this.mCardElementsOption);
    }

    public void readFromParcel(Parcel parcel) {
        this.mCardName = parcel.readString();
        this.mCardNo = parcel.readString();
        this.mAid = parcel.readString();
        this.mBankCardPan = parcel.readString();
        this.mBankCardType = parcel.readInt();
        this.mVCReferenceId = parcel.readString();
        this.mVCardNumber = parcel.readString();
        this.mCardProductTypeId = parcel.readString();
        this.mIssuerId = parcel.readString();
        this.mCardProductName = parcel.readString();
        this.mUserTerms = parcel.readString();
        this.mCardArt = parcel.readString();
        this.mVCStatus = parcel.readInt();
        this.mPhoneLastDigits = parcel.readString();
        this.mIssuerChannel = parcel.readInt();
        this.mPanLastDigits = parcel.readString();
        this.mBankName = parcel.readString();
        this.mBankLogoUrl = parcel.readString();
        this.mBankLogoWithNameUrl = parcel.readString();
        this.mCardFrontColor = parcel.readString();
        this.mBankContactNum = parcel.readString();
        boolean z = false;
        this.mHasQRToken = parcel.readInt() == 0;
        this.mServiceHotline = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        }
        this.mShowBankNameSuffix = z;
        this.mCardElementsOption = parcel.readInt();
    }

    public boolean hasQRToken() {
        return this.mHasQRToken;
    }

    public String getContentDescription(Map<Class<? extends CardInfo>, String> map) {
        String str;
        if (map == null || (str = map.get(getClass())) == null) {
            return super.getContentDescription(null);
        }
        return String.format(str, this.mBankName, this.mPanLastDigits);
    }

    public boolean isCardActive() {
        return this.mVCStatus == 0;
    }

    public boolean isBankCardLocked() {
        return this.mVCStatus == 2;
    }

    public boolean isCardPersonalized() {
        return this.mVCStatus == 5;
    }

    public boolean isActivateTimeOut() {
        return "DELETE".equals(this.mSuggestion);
    }

    public boolean isNeedPwdCardElement() {
        return (this.mCardElementsOption & 1) > 0;
    }

    public boolean isNeedExpireCardElement() {
        return (this.mCardElementsOption & 2) > 0;
    }

    public void setCardElementsOption(int i) {
        this.mCardElementsOption = i;
    }
}
