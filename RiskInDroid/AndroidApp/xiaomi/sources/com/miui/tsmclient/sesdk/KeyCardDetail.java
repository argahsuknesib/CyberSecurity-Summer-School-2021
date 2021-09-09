package com.miui.tsmclient.sesdk;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.sesdk.SeCard;

public class KeyCardDetail implements IJsonDeserializer<KeyCardDetail>, IJsonSerializer, SeCard.IOnlineProperties {
    private transient CardInfo mCardInfo;
    @SerializedName("description")
    private String mDescription = this.mCardInfo.mCardSubName;
    @SerializedName("descriptions")
    private String mDescriptions = null;
    @SerializedName("isServiceAvailable")
    private boolean mIsServiceAvailable = true;
    @SerializedName("label")
    private String mLabel = null;
    @SerializedName("serviceStatus")
    private String mServiceStatus = this.mCardInfo.getServiceStatusDesc();
    @SerializedName("tips")
    private String mTips = null;

    public KeyCardDetail(SeCard seCard) {
        this.mCardInfo = seCard.mCardInfo;
    }

    public static KeyCardDetail fromJson(String str) {
        return (KeyCardDetail) new Gson().fromJson(str, KeyCardDetail.class);
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
