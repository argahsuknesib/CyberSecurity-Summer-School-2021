package com.xiaomi.smarthome.miio.camera.cloudstorage.model;

import java.text.SimpleDateFormat;

public class CloudVideoUserStatus {
    public long endTime;
    private boolean isDefault;
    public boolean isRenew;
    public String packageType;
    public boolean renewStatus;
    public int rollingSaveInterval;
    public long startTime;
    public int status;
    public boolean vip;

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "vip:" + this.vip + " status:" + this.status + " startTime:" + simpleDateFormat.format(Long.valueOf(this.startTime)) + " endTime:" + simpleDateFormat.format(Long.valueOf(this.endTime)) + " packageType:" + this.packageType + " informationDay:" + this.rollingSaveInterval;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void setDefault(boolean z) {
        this.isDefault = z;
    }
}
