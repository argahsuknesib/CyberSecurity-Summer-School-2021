package com.miui.tsmclient.entity;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.util.Constants;
import com.miui.tsmclient.util.PrefUtils;

public class TravelInfo {
    @SerializedName("consumptionType")
    private String mConsumptionType;
    @SerializedName("helpInfo")
    private String mHelpInfo;
    @SerializedName("inboundSite")
    private String mInboundSite;
    @SerializedName("lineNo")
    private String mLineNo;
    @SerializedName("outboundSite")
    private String mOutboundSite;
    private Long mTradeTime;
    private String mTrafficCardName;
    @SerializedName("trafficType")
    private String mTrafficType;

    public TravelInfo() {
    }

    public TravelInfo(TravelInfo travelInfo) {
        this.mTrafficType = travelInfo.mTrafficType;
        this.mConsumptionType = travelInfo.mConsumptionType;
        this.mInboundSite = travelInfo.mInboundSite;
        this.mOutboundSite = travelInfo.mOutboundSite;
        this.mTrafficCardName = travelInfo.mTrafficCardName;
        this.mTradeTime = travelInfo.mTradeTime;
    }

    public String getTrafficType() {
        return this.mTrafficType;
    }

    public void setTrafficType(String str) {
        this.mTrafficType = str;
    }

    public void setConsumptionType(String str) {
        this.mConsumptionType = str;
    }

    public String getConsumptionType() {
        return this.mConsumptionType;
    }

    public void setStartSiteName(String str) {
        this.mInboundSite = str;
    }

    public String getStartSiteName() {
        return this.mInboundSite;
    }

    public void setEndSiteName(String str) {
        this.mOutboundSite = str;
    }

    public String getEndSiteName() {
        return this.mOutboundSite;
    }

    public boolean isSubway() {
        return Constants.TrafficType.SUBWAY == Constants.TrafficType.getTrafficType(this.mTrafficType);
    }

    public boolean isInbound() {
        return "00".equals(this.mConsumptionType) || "03".equals(this.mConsumptionType);
    }

    public boolean isOneWay() {
        return "02".equals(this.mConsumptionType);
    }

    public boolean isUnknownTrafficType() {
        return Constants.TrafficType.TRAFFIC_UNKNOWN == Constants.TrafficType.getTrafficType(this.mTrafficType);
    }

    public boolean isEndSiteInfoSanity() {
        return !TextUtils.isEmpty(this.mOutboundSite);
    }

    public boolean isSiteInfoSanity(Context context) {
        if (TextUtils.isEmpty(this.mInboundSite) || TextUtils.isEmpty(this.mOutboundSite)) {
            return !TextUtils.isEmpty(PrefUtils.getString(context, "inbound_site", "")) && !TextUtils.isEmpty(this.mOutboundSite);
        }
        return true;
    }

    public void setTradeTime(Long l) {
        this.mTradeTime = l;
    }

    public Long getTradeTime() {
        return this.mTradeTime;
    }

    public void setTrafficCardName(String str) {
        this.mTrafficCardName = str;
    }

    public String getTrafficCardName() {
        return this.mTrafficCardName;
    }

    public String getLineNo() {
        return this.mLineNo;
    }

    public String toString() {
        return this.mConsumptionType + "|" + this.mTrafficType + "|" + this.mInboundSite + "|" + this.mOutboundSite;
    }
}
