package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.miui.tsmclient.util.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class MifareCardInfo extends CardInfo {
    public static final Parcelable.Creator<MifareCardInfo> CREATOR = new Parcelable.Creator<MifareCardInfo>() {
        /* class com.miui.tsmclient.entity.MifareCardInfo.AnonymousClass1 */

        public final MifareCardInfo createFromParcel(Parcel parcel) {
            MifareCardInfo mifareCardInfo = new MifareCardInfo();
            mifareCardInfo.readFromParcel(parcel);
            return mifareCardInfo;
        }

        public final MifareCardInfo[] newArray(int i) {
            return new MifareCardInfo[i];
        }
    };
    private boolean isOverWrite;
    private String mApplyStatus;
    private String mBusinessId;
    public String mCardArt;
    public int mCardFace;
    private int mCommunityCardFlowStatus;
    private String mCommunityCode;
    public int mFingerAuthFlag;
    public int mMifareCardType;
    public String mProductId;
    public String mProductName;
    private String mTicket;
    public String mUserTerms;
    public int mVCStatus;

    enum APPLY_STATUS {
        ISSUED,
        APPLIED,
        DELETED
    }

    public static class MifareType {
    }

    public boolean isMiFareCard() {
        return true;
    }

    public static class CommunityCardFlowStatus {
        private CommunityCardFlowStatus() {
        }
    }

    public MifareCardInfo() {
        super("MIFARE_ENTRANCE");
        this.mIsSecure = false;
        this.mCardGroupId = CardGroupType.MIFARECARD.getId();
    }

    public JSONObject serialize() {
        JSONObject serialize = super.serialize();
        try {
            serialize.put("card_finger_flag", this.mFingerAuthFlag);
            serialize.put("mifare_card_type", this.mMifareCardType);
            serialize.put("door_card_product_id", this.mProductId);
            serialize.put("door_card_product_name", this.mProductName);
            serialize.put("card_user_terms", this.mUserTerms);
            serialize.put("card_art", this.mCardArt);
            serialize.put("card_vc_status", this.mVCStatus);
            serialize.putOpt("card_native_drawable", Integer.valueOf(this.mCardFace));
            serialize.put("community_code", this.mCommunityCode);
            serialize.put("business_id", this.mBusinessId);
            serialize.put("apply_status", this.mApplyStatus);
            serialize.put("community_flow_status", this.mCommunityCardFlowStatus);
            serialize.put("community_ticket", this.mTicket);
        } catch (JSONException e) {
            LogUtils.e("serialize mifarecard info to json object failed!", e);
        }
        return serialize;
    }

    public CardInfo parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.mUserTerms = jSONObject.optString("card_user_terms");
            this.mCardArt = jSONObject.optString("card_art");
            this.mVCStatus = jSONObject.optInt("card_vc_status");
            this.mCardFace = jSONObject.optInt("card_native_drawable");
            this.mFingerAuthFlag = jSONObject.optInt("card_finger_flag");
            this.mMifareCardType = jSONObject.optInt("mifare_card_type");
            this.mProductId = jSONObject.optString("door_card_product_id");
            this.mProductName = jSONObject.optString("door_card_product_name");
            this.mCommunityCode = jSONObject.optString("community_code");
            this.mBusinessId = jSONObject.optString("business_id");
            this.mApplyStatus = jSONObject.optString("apply_status");
            this.mCommunityCardFlowStatus = jSONObject.optInt("community_flow_status", this.mCommunityCardFlowStatus);
            this.mTicket = jSONObject.optString("community_ticket", this.mTicket);
        }
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mUserTerms);
        parcel.writeString(this.mCardArt);
        parcel.writeInt(this.mVCStatus);
        parcel.writeInt(this.mCardFace);
        parcel.writeInt(this.mFingerAuthFlag);
        parcel.writeInt(this.mMifareCardType);
        parcel.writeString(this.mProductId);
        parcel.writeString(this.mProductName);
        parcel.writeString(this.mCommunityCode);
        parcel.writeString(this.mBusinessId);
        parcel.writeString(this.mTicket);
        parcel.writeInt(this.mCommunityCardFlowStatus);
        parcel.writeInt(this.isOverWrite ? 1 : 0);
        parcel.writeString(this.mApplyStatus);
    }

    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mUserTerms = parcel.readString();
        this.mCardArt = parcel.readString();
        this.mVCStatus = parcel.readInt();
        this.mCardFace = parcel.readInt();
        this.mFingerAuthFlag = parcel.readInt();
        this.mMifareCardType = parcel.readInt();
        this.mProductId = parcel.readString();
        this.mProductName = parcel.readString();
        this.mCommunityCode = parcel.readString();
        this.mBusinessId = parcel.readString();
        this.mTicket = parcel.readString();
        this.mCommunityCardFlowStatus = parcel.readInt();
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.isOverWrite = z;
        this.mApplyStatus = parcel.readString();
    }

    public boolean isSecure() {
        return this.mFingerAuthFlag != 1;
    }

    public boolean isCommunityDoorCardV3() {
        return !TextUtils.isEmpty(this.mBusinessId);
    }

    public String getImageUrl() {
        return TextUtils.isEmpty(this.mCardArt) ? String.valueOf(this.mCardFace) : this.mCardArt;
    }

    public void cancelFinger() {
        this.mFingerAuthFlag = 1;
    }

    public String getProductId() {
        String str = this.mProductId;
        return str == null ? "" : str;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public String getBusinessId() {
        String str = this.mBusinessId;
        return str == null ? "" : str;
    }

    public void setBusinessId(String str) {
        this.mBusinessId = str;
    }

    public String getCommunityCode() {
        String str = this.mCommunityCode;
        return str == null ? "" : str;
    }

    public void setCommunityCode(String str) {
        this.mCommunityCode = str;
    }

    public String getTicket() {
        String str = this.mTicket;
        return str == null ? "" : str;
    }

    public void setTicket(String str) {
        this.mTicket = str;
    }

    public boolean isDummy() {
        return !TextUtils.isEmpty(this.mApplyStatus) && !APPLY_STATUS.ISSUED.name().equals(this.mApplyStatus);
    }

    public boolean isApplying() {
        return APPLY_STATUS.APPLIED.name().equals(this.mApplyStatus);
    }

    public boolean isDeletable() {
        int i;
        if (!isCommunityDoorCardV3() || !isApplying() || (i = this.mCommunityCardFlowStatus) == 2 || i == 5) {
            return true;
        }
        return false;
    }

    public int getMifareCardType() {
        int i = this.mMifareCardType;
        if (i != 6 && i > 0) {
            return 1;
        }
        return i;
    }

    public void setCommunityCardFlowStatus(int i) {
        this.mCommunityCardFlowStatus = i;
    }

    public int getCommunityCardFlowStatus() {
        return this.mCommunityCardFlowStatus;
    }

    public boolean isOverWrite() {
        return this.isOverWrite;
    }

    public void setOVerWrite(boolean z) {
        this.isOverWrite = z;
    }

    public void setApplyStatus(String str) {
        this.mApplyStatus = str;
    }

    public String getUpdateArtContent() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", this.mAid);
            jSONObject.put("cardType", this.mCardType);
            jSONObject.put("productId", this.mProductId);
            jSONObject.put("updateKey", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", 1);
            jSONObject.put("updateContent", jSONObject2);
        } catch (JSONException e) {
            LogUtils.e("getUpdateArtContent error", e);
        }
        return jSONObject.toString();
    }

    public void parseCardFromJson(JSONObject jSONObject) {
        super.parseCardFromJson(jSONObject);
        if (jSONObject != null && jSONObject.has("card_art")) {
            this.mCardArt = jSONObject.optString("card_art");
        }
    }
}
