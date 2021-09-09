package com.xiaomi.smarthome.device.api;

public class BtFirmwareUpdateInfo {
    public String changeLog;
    public String md5;
    public String url;
    public String version;

    public String toString() {
        return "BtFirmwareUpdateInfo{version='" + this.version + '\'' + ", url='" + this.url + '\'' + ", changeLog='" + this.changeLog + '\'' + ", md5='" + this.md5 + '\'' + '}';
    }
}
