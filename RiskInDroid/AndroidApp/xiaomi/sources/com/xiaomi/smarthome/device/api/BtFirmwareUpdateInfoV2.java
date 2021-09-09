package com.xiaomi.smarthome.device.api;

public class BtFirmwareUpdateInfoV2 {
    public String changeLog;
    public String md5;
    public String safeUrl;
    public long uploadTime;
    public String url;
    public String version;

    public String toString() {
        return "BtFirmwareUpdateInfoV2{version='" + this.version + '\'' + ", url='" + this.url + '\'' + ", safeUrl='" + this.safeUrl + '\'' + ", changeLog='" + this.changeLog + '\'' + ", md5='" + this.md5 + '\'' + ", uploadTime='" + this.uploadTime + '\'' + '}';
    }
}
