package com.xiaomi.smarthome.miio.camera.face.model;

import java.io.Serializable;

public class FaceEvent implements Serializable {
    public long createTime;
    public String eventType;
    public long expireTime;
    public String extraInfo;
    public String faceId;
    public String fileId;
    public String imgStoreId;
    public boolean isAlarm;
    public boolean isRead;
    public int offset;
    public double startDuration;
    public String videoStoreId;

    public String toString() {
        return "FaceEvent{fileId='" + this.fileId + '\'' + ", faceId='" + this.faceId + '\'' + ", createTime=" + this.createTime + ", expireTime=" + this.expireTime + ", videoStoreId='" + this.videoStoreId + '\'' + ", imgStoreId='" + this.imgStoreId + '\'' + ", extraInfo='" + this.extraInfo + '\'' + ", offset=" + this.offset + ", eventType='" + this.eventType + '\'' + ", isAlarm=" + this.isAlarm + ", isRead=" + this.isRead + ", startDuration=" + this.startDuration + '}';
    }
}
