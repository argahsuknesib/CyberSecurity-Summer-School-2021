package com.miui.tsmclient.sesdk;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.sesdk.SeCard;
import org.json.JSONException;
import org.json.JSONObject;

public class TransitCardGroupDetail implements IJsonDeserializer<TransitCardGroupDetail>, IJsonSerializer, SeCard.IOnlineProperties {
    private transient CardInfo mCardInfo;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("descriptions")
    private String mDescriptions;
    @SerializedName("isServiceAvailable")
    private boolean mIsServiceAvailable;
    @SerializedName("label")
    private String mLabel;
    @SerializedName("serviceStatus")
    private String mServiceStatus;
    @SerializedName("tips")
    private String mTips;

    public TransitCardGroupDetail(SeCard seCard) {
        this.mCardInfo = seCard.mCardInfo;
        this.mDescription = this.mCardInfo.mCardUIInfo != null ? this.mCardInfo.mCardUIInfo.mFamilyDesc1 : null;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.mCardInfo.mCardUIInfo != null) {
                jSONObject.put("familyDesc1", this.mCardInfo.mCardUIInfo.mFamilyDesc1);
                jSONObject.put("familyDesc2", this.mCardInfo.mCardUIInfo.mFamilyDesc2);
            }
        } catch (JSONException unused) {
        }
        this.mDescriptions = jSONObject.toString();
        this.mServiceStatus = null;
        this.mIsServiceAvailable = true;
        this.mTips = null;
        this.mLabel = null;
    }

    public static TransitCardGroupDetail fromJson(String str) {
        return (TransitCardGroupDetail) new Gson().fromJson(str, TransitCardGroupDetail.class);
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getDescriptions() {
        return this.mDescriptions;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public String getServiceStatus() {
        return this.mServiceStatus;
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
