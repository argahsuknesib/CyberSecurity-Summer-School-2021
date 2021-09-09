package com.xiaomi.smarthome.device.api;

import java.io.Serializable;

public class BleMeshFirmwareUpdateInfoV2 implements Serializable {
    public String changeLog;
    public String currentMcuVersion;
    public String currentVersion;
    public String did;
    public String mcuSafeUrl;
    public String mcuVersion;
    public String md5;
    public String safeUrl;
    public int timeout;
    public String uploadTime;
    public String url;
    public String version;

    public String toString() {
        return "BtFirmwareUpdateInfo{version='" + this.version + '\'' + ", safeUrl='" + this.safeUrl + '\'' + ", url='" + this.url + '\'' + ", mcuVersion = '" + this.mcuVersion + '\'' + ", changeLog='" + this.changeLog + '\'' + ", uploadTime='" + this.uploadTime + '\'' + ", currentVersion='" + this.currentVersion + '\'' + ", did='" + this.did + '\'' + ", md5='" + this.md5 + '\'' + '}';
    }
}
