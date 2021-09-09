package com.miui.tsmclient.sesdk;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoExtra;
import com.miui.tsmclient.entity.CloudTransitCardInfo;
import com.miui.tsmclient.sesdk.SeCard;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudTransitCardDetail implements IJsonDeserializer<CloudTransitCardDetail>, IJsonSerializer, SeCard.IOnlineProperties {
    private transient CardInfo mCardInfo;
    @SerializedName("description")
    private String mDescription = ((CloudTransitCardInfo) this.mCardInfo).getCardBalanceTitle();
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

    public CloudTransitCardDetail(SeCard seCard) {
        this.mCardInfo = seCard.mCardInfo;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceModel", ((CloudTransitCardInfo) this.mCardInfo).getCardLastUsedDeviceModel());
        } catch (JSONException unused) {
        }
        this.mDescriptions = jSONObject.toString();
        this.mServiceStatus = this.mCardInfo.getServiceStatusDesc();
        this.mIsServiceAvailable = this.mCardInfo.isServiceAvailable();
        this.mTips = CardInfoExtra.get(this.mCardInfo.getExtra()).getCardToast();
        this.mLabel = null;
    }

    public static CloudTransitCardDetail fromJson(String str) {
        return (CloudTransitCardDetail) new Gson().fromJson(str, CloudTransitCardDetail.class);
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
