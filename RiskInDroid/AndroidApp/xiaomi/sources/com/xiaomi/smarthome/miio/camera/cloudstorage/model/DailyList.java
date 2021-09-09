package com.xiaomi.smarthome.miio.camera.cloudstorage.model;

public class DailyList {
    public long createTime;
    public long duration;
    public long expireTime;
    public String fileId;
    public String imgStoreId;
    public boolean isHuman;

    public String toString() {
        return "duration:" + this.duration + " expireTime:" + this.expireTime + " createTime:" + this.createTime + " imgStoreId:" + this.imgStoreId + " fileId:" + this.fileId + " isHuman:" + this.isHuman;
    }
}
