package com.mi.global.shop.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class TrackModel {
    @SerializedName("expressInfo")
    public ExpressInfo expressInfo;

    public static class ExpressInfo {
        @SerializedName("express_name")
        public String expressName;
        @SerializedName("express_sn")
        public String expressSn;
        @SerializedName("express_trace")
        public ArrayList<TrackItem> items;

        public static class TrackItem {
            @SerializedName("city")
            public String city;
            @SerializedName("time")
            public long time;
            @SerializedName("track")
            public String track;
        }
    }
}
