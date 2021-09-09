package com.miui.tsmclient.analytics.entity;

import android.annotation.TargetApi;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.analytics.TSMStatConvertUtils;
import java.util.List;

public class DataStatInfo {
    @SerializedName("dataID")
    private int mDataID;
    @SerializedName("dataTime")
    private String mDataTime;
    @SerializedName("dataValue")
    private String mDataValue;

    @TargetApi(26)
    public DataStatInfo() {
        this.mDataValue = "";
        this.mDataTime = TSMStatConvertUtils.getStatFormatTime(System.currentTimeMillis());
    }

    public DataStatInfo(int i) {
        this();
        this.mDataID = i;
    }

    public int getDataID() {
        return this.mDataID;
    }

    public void setDataID(int i) {
        this.mDataID = i;
    }

    public String getDataValue() {
        return this.mDataValue;
    }

    public void setDataValue(String str) {
        this.mDataValue = str;
    }

    @TargetApi(26)
    public void setDataTime(String str) {
        this.mDataTime = str;
    }

    public String getDataTime() {
        return this.mDataTime;
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public static String toServerData(List<DataStatInfo> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            DataStatInfo dataStatInfo = list.get(i);
            sb.append("{");
            sb.append(dataStatInfo.getDataID());
            sb.append(";");
            sb.append(dataStatInfo.getDataValue());
            sb.append(";");
            sb.append(dataStatInfo.getDataTime());
            sb.append("}");
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
