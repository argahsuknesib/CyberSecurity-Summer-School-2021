package com.xiaomi.mico.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Miot {

    public static class Device implements Serializable {
        private static final long serialVersionUID = -337157334942626855L;
        public String deviceID;
        public String imageURL;
        public boolean isIrDevice;
        public boolean isOnline;
        public String miotDid;
        public String model;
        public String name;
        public String productID;
        public String productURN;
        public Map<String, String> properties;
        public boolean supported;
        public List<String> tips;
    }

    public static class DeviceCmdItem {
        public String description;
        public String name;
    }

    public static class HomeInfo {
        public List<Home> homelist;
    }

    public static class HomeResult {
        public int code;
        public String message;
        public HomeInfo result;
    }

    public class DeviceCmdDetail implements Serializable {
        private static final long serialVersionUID = 8022947269750255553L;
        @SerializedName("commandList")
        public List<DeviceCmdItem> commands;
        public String imageURL;

        public DeviceCmdDetail() {
        }
    }

    public class DeviceCmdDetailV2 implements Serializable {
        private static final long serialVersionUID = -89769313524907491L;
        @SerializedName("commandList")
        public List<DeviceCmdItem> commands;
        public String icon;
        public String name;
        public String template;

        public DeviceCmdDetailV2() {
        }
    }

    public static class Home {
        public List<String> dids;
        public String id;
        public String name;
        public List<Room> roomlist;

        public String toString() {
            return this.name;
        }
    }

    public static class Room {
        public String bssid;
        public List<String> dids;
        public String id;
        public String name;
        public String parentid;

        public String toString() {
            return this.name;
        }
    }
}
