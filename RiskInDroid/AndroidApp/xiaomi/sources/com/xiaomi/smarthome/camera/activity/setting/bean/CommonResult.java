package com.xiaomi.smarthome.camera.activity.setting.bean;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

public class CommonResult {
    @SerializedName("code")
    public int code;
    @SerializedName("data")
    public JsonElement data;
    @SerializedName("result")
    public String result;
    @SerializedName("retriable")
    public String retriable;
}
