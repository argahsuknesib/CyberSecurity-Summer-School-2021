package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;

public class DoorCardProduct {
    private boolean isSelected;
    @SerializedName("cardArt")
    private String mCardArt;
    @SerializedName("cardType")
    private int mCardType;
    @SerializedName("fingerFlag")
    private int mFingerFlag;
    @SerializedName("logo")
    private String mLogo;
    @SerializedName("productId")
    private String mProductId;
    @SerializedName("productName")
    private String mProductName;

    public String getProductId() {
        return this.mProductId;
    }

    public String getProductName() {
        return this.mProductName;
    }

    public String getLogo() {
        return this.mLogo;
    }

    public int getCardType() {
        return this.mCardType;
    }

    public boolean needFinger() {
        return this.mFingerFlag == 1;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String getCardArt() {
        return this.mCardArt;
    }

    public String getOpenCardUrl() {
        return String.format("tsmclient://card?action=issue_mifare&type=%1d&product_id=%2s", Integer.valueOf(this.mCardType), this.mProductId);
    }
}
