package com.miui.tsmclient.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class CardInfoExtra {
    @SerializedName("cardConfigs")
    private int mCardConfig;
    @SerializedName("cardToast")
    private String mCardToast;

    public boolean isShowSupportedArea() {
        return (this.mCardConfig & 4) != 0;
    }

    public String getCardToast() {
        return this.mCardToast;
    }

    public static CardInfoExtra get(String str) {
        return (CardInfoExtra) new Gson().fromJson(str, CardInfoExtra.class);
    }
}
