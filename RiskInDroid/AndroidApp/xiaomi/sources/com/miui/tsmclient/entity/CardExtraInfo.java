package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;

public class CardExtraInfo extends CommonResponseInfo {
    @SerializedName("cardNumber")
    private String mCardNumber;
    @SerializedName("realCardNumber")
    public String mRealCardNumber;

    public String getCardNumber() {
        return this.mCardNumber;
    }

    public String getRealCardNumber() {
        return this.mRealCardNumber;
    }
}
