package com.xiaomi.smarthome.device.api;

import java.util.List;

public class SecurityKeyInfo {
    public long activeTime;
    public long expireTime;
    public int isoutofdate;
    public String keyId;
    public String shareUid;
    public int status;
    public List<Integer> weekdays;

    public String toString() {
        return "SecurityKeyInfo{keyId='" + this.keyId + '\'' + ", shareUid='" + this.shareUid + '\'' + ", status=" + this.status + ", activeTime=" + this.activeTime + ", expireTime=" + this.expireTime + ", weekdays=" + this.weekdays + ", isoutofdate=" + this.isoutofdate + '}';
    }
}
