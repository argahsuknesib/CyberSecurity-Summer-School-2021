package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;

public class RechargeOrderInfo {
    @SerializedName("amount")
    private int mAmount;
    @SerializedName("orderId")
    private String mOrderId;
    @SerializedName("richStatus")
    private int mRichStatus;
    @SerializedName("statusDesc")
    private String mStatusDesc;
    @SerializedName("time")
    private String mTime;
    @SerializedName("title")
    private String mTitle;

    public String getTitle() {
        return this.mTitle;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public int getAmount() {
        return this.mAmount;
    }

    public String getStatusDesc() {
        return this.mStatusDesc;
    }

    public String getTime() {
        return this.mTime;
    }
}
