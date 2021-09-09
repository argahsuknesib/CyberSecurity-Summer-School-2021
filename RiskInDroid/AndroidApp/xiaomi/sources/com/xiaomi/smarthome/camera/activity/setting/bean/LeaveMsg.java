package com.xiaomi.smarthome.camera.activity.setting.bean;

import com.google.gson.annotations.SerializedName;

public class LeaveMsg {
    @SerializedName("desc")
    public String desc;
    @SerializedName("descObj")
    public Desc descObj;
    @SerializedName("isPlaying")
    public boolean isPlaying;
    @SerializedName("itemData")
    public String itemData;
    @SerializedName("itemId")
    public long itemId;
    @SerializedName("selected")
    public boolean selected;
}
