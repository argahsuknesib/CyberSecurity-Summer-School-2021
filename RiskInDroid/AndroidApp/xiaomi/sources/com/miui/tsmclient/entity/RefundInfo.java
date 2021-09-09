package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;

public class RefundInfo {
    @SerializedName("applyRefundAmount")
    private int mApplyRefundAmount;
    @SerializedName("responseCode")
    private String mResponseCode;
    @SerializedName("responseDesc")
    private String mResponseDesc;
    @SerializedName("success")
    private boolean mSuccess = false;

    public boolean isSuccess() {
        return this.mSuccess;
    }

    public void setResponseCode(String str) {
        this.mResponseCode = str;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public void setResponseDesc(String str) {
        this.mResponseDesc = str;
    }

    public String getResponseDesc() {
        return this.mResponseDesc;
    }

    public int getApplyRefundAmount() {
        return this.mApplyRefundAmount;
    }
}
