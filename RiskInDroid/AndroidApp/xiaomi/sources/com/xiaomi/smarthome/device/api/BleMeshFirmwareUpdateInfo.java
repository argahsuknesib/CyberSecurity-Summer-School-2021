package com.xiaomi.smarthome.device.api;

import java.io.Serializable;

public class BleMeshFirmwareUpdateInfo implements Serializable {
    public String changeLog;
    public McuUpdateInfo mcuUpdateInfo;
    public String md5;
    public String safeUrl;
    public int timeout;
    public String url;
    public String version;

    public String getLatestVersion() {
        if (this.mcuUpdateInfo == null) {
            return this.version;
        }
        return this.version + "." + this.mcuUpdateInfo.version;
    }

    public String getCurrentVersion(String str) {
        if (this.mcuUpdateInfo == null) {
            return str;
        }
        return str + "." + this.mcuUpdateInfo.currentMcuVersion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BtFirmwareUpdateInfo{version='");
        sb.append(this.version);
        sb.append('\'');
        sb.append(", safeUrl='");
        sb.append(this.safeUrl);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", changeLog='");
        sb.append(this.changeLog);
        sb.append('\'');
        sb.append(", md5='");
        sb.append(this.md5);
        sb.append('\'');
        sb.append(", timeout=");
        sb.append(this.timeout);
        sb.append('\'');
        sb.append(",mcuUpdateInfo=");
        McuUpdateInfo mcuUpdateInfo2 = this.mcuUpdateInfo;
        sb.append(mcuUpdateInfo2 != null ? mcuUpdateInfo2.toString() : "Null");
        sb.append('}');
        return sb.toString();
    }
}
