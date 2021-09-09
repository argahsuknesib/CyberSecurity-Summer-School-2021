package com.xiaomi.smarthome.device.api;

import android.text.TextUtils;
import java.io.Serializable;

public class McuUpdateInfo implements Serializable {
    public String changeLog;
    public String currentMcuVersion;
    public String md5;
    public String url;
    public String version;

    public boolean isNoNeedUpgrade() {
        return TextUtils.equals(this.currentMcuVersion, this.version);
    }

    public String toString() {
        return "McuUpdateInfo{version='" + this.version + '\'' + ", url='" + this.url + '\'' + ", changeLog='" + this.changeLog + '\'' + ", md5='" + this.md5 + '\'' + '}';
    }
}
