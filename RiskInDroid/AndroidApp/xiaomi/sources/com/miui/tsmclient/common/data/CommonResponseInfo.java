package com.miui.tsmclient.common.data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class CommonResponseInfo {
    @SerializedName("errCode")
    private int mErrorCode;
    @SerializedName("errDesc")
    private String mErrorDesc;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorDesc() {
        return this.mErrorDesc;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public boolean isSuccess() {
        return this.mErrorCode == 200;
    }
}
