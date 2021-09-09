package com.xiaomi.smarthome.camera.activity.setting.bean;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class GetLeavMsgData {
    @SerializedName("isContinue")
    public boolean isContinue;
    @SerializedName("nextStartItemId")
    public long nextStartItemId;
    @SerializedName("resultList")
    public ArrayList<LeaveMsg> resultList;

    public String toString() {
        return "GetLeavMsgData{nextStartItemId=" + this.nextStartItemId + ", isContinue=" + this.isContinue + ", resultList=" + this.resultList + '}';
    }
}
