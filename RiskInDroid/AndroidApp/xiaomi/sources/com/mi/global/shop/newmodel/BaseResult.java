package com.mi.global.shop.newmodel;

import com.google.gson.annotations.SerializedName;

public class BaseResult {
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
}
