package com.xiaomi.smarthome.camera;

public enum MissNetworkType {
    UNKNOWN("unknown"),
    CABLE("cable"),
    WIFI("wifi"),
    MOBILE_4G("4G"),
    MOBILE_5G("5G"),
    OTHER("other"),
    UNEXPECTED("unexpected");
    
    private String networkType;

    private MissNetworkType(String str) {
        this.networkType = str;
    }

    public final String getValue() {
        return this.networkType;
    }
}
