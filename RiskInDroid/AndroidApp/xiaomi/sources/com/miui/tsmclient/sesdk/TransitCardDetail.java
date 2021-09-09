package com.miui.tsmclient.sesdk;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.sesdk.SeCard;
import org.json.JSONException;
import org.json.JSONObject;

public class TransitCardDetail implements IJsonDeserializer<TransitCardDetail>, IJsonSerializer, SeCard.IOnlineProperties {
    @SerializedName("cardGroup")
    private int mCardGroup = this.mCardInfo.mCardGroupId;
    private transient CardInfo mCardInfo;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("descriptions")
    private String mDescriptions;
    @SerializedName("groupName")
    private String mGroupName = this.mCardInfo.mGroupName;
    @SerializedName("isServiceAvailable")
    private boolean mIsServiceAvailable;
    @SerializedName("issueStatusDesc")
    private String mIssueStatusDesc = this.mCardInfo.getIssueStatusDesc();
    @SerializedName("label")
    private String mLabel;
    @SerializedName("rechargeStatusDesc")
    private String mRechargeStatusDesc = this.mCardInfo.getRechargeStatusDesc();
    @SerializedName("serviceFeeDesc")
    private String mServiceFeeDesc = this.mCardInfo.getServiceFeeDesc();
    @SerializedName("serviceStatus")
    private String mServiceStatus;
    @SerializedName("subTitle")
    private String mSubTitle = this.mCardInfo.mCardSubName;
    @SerializedName("tips")
    private String mTips;

    public TransitCardDetail(SeCard seCard) {
        this.mCardInfo = seCard.mCardInfo;
        this.mDescription = this.mCardInfo.mCardUIInfo != null ? this.mCardInfo.mCardUIInfo.mCardDetailDesc : null;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mCardInfo.mCardUIInfo != null) {
                jSONObject.put("simpleSupportAreasDesc", this.mCardInfo.mCardUIInfo.mSimpleSupportAreasDesc);
                jSONObject.put("simpleRideDiscountDesc", this.mCardInfo.mCardUIInfo.mSimpleRideDiscountDesc);
            }
        } catch (JSONException unused) {
        }
        this.mDescriptions = jSONObject.toString();
        this.mServiceStatus = this.mCardInfo.getServiceStatusDesc();
        this.mIsServiceAvailable = this.mCardInfo.isServiceAvailable();
        this.mTips = null;
        this.mLabel = this.mCardInfo.getLabel();
    }

    public static TransitCardDetail fromJson(String str) {
        return (TransitCardDetail) new Gson().fromJson(str, TransitCardDetail.class);
    }

    public int getCardGroup() {
        return this.mCardGroup;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getDescriptions() {
        return this.mDescriptions;
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public String getIssueStatusDesc() {
        return this.mIssueStatusDesc;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getRechargeStatusDesc() {
        return this.mRechargeStatusDesc;
    }

    public String getServiceFeeDesc() {
        return this.mServiceFeeDesc;
    }

    public String getServiceStatus() {
        return this.mServiceStatus;
    }

    public String getSubTitle() {
        return this.mSubTitle;
    }

    public String getTips() {
        return this.mTips;
    }

    public boolean isServiceAvailable() {
        return this.mIsServiceAvailable;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
