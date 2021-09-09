package com.xiaomi.mico.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class LanGroupInfo {
    @SerializedName("multiRoomInfo")
    public List<LanGroup> multiRoomLanList;
    @SerializedName("stereoInfo")
    public List<LanGroup> stereoLanList;
    @SerializedName("wakeUpInfo")
    public List<LanGroup> wakeUpLanList;

    public static class LanGroup {
        public List<DeviceState> devices;
        public int lanId;
        public boolean select;
        public int selectState = 0;
    }
}
