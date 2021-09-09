package com.xiaomi.smarthome.device;

import java.io.Serializable;

public class WifiRepeater implements Serializable {
    public String deviceMac;
    public long did;
    public String ip;
    public String model;
    public String ssid;
    public String token;

    public WifiRepeater(String str, String str2, String str3) {
        this.model = str;
        this.ip = str2;
        this.ssid = str3;
    }
}
