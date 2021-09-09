package com.xiaomi.mico.api.model;

import com.google.gson.annotations.SerializedName;
import com.xiaomi.mico.api.model.StereoData;
import java.util.List;

public class PairedGroupInfo {
    @SerializedName(alternate = {"multiRoom"}, value = "multiRoomInfo")
    public MultiRoomData multiRoom;
    @SerializedName(alternate = {"stereoList"}, value = "stereoInfo")
    public List<StereoData.StereoGroup> stereoList;
}
