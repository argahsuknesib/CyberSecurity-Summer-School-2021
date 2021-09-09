package com.xiaomi.smarthome.camera.activity.alarm2.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoInfo implements Parcelable {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new Parcelable.Creator<VideoInfo>() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.bean.VideoInfo.AnonymousClass1 */

        public final VideoInfo[] newArray(int i) {
            return new VideoInfo[i];
        }

        public final VideoInfo createFromParcel(Parcel parcel) {
            return new VideoInfo(parcel);
        }
    };
    private long createTime;
    private String desc;
    private float duration;
    private long expiretime;
    private String fileId;
    private String imgStoreId;
    private String pic_id;
    private boolean read;
    private String tags;
    private String userid;
    private String video_id;
    private long video_time;
    private int warning_type;

    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.duration;
    }

    public void setDuration(float f) {
        this.duration = f;
    }

    public long getExpiretime() {
        return this.expiretime;
    }

    public void setExpiretime(long j) {
        this.expiretime = j;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public String getImgStoreId() {
        return this.imgStoreId;
    }

    public void setImgStoreId(String str) {
        this.imgStoreId = str;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String str) {
        this.userid = str;
    }

    public long getVideo_time() {
        return this.video_time;
    }

    public void setVideo_time(long j) {
        this.video_time = j;
    }

    public int getWarning_type() {
        return this.warning_type;
    }

    public void setWarning_type(int i) {
        this.warning_type = i;
    }

    public String getVideo_id() {
        return this.video_id;
    }

    public void setVideo_id(String str) {
        this.video_id = str;
    }

    public String getPic_id() {
        return this.pic_id;
    }

    public void setPic_id(String str) {
        this.pic_id = str;
    }

    public boolean isRead() {
        return this.read;
    }

    public void setRead(boolean z) {
        this.read = z;
    }

    public VideoInfo() {
    }

    public VideoInfo(Parcel parcel) {
        this.duration = parcel.readFloat();
        this.expiretime = parcel.readLong();
        this.createTime = parcel.readLong();
        this.imgStoreId = parcel.readString();
        this.fileId = parcel.readString();
        this.desc = parcel.readString();
        this.tags = parcel.readString();
        this.userid = parcel.readString();
        this.video_time = parcel.readLong();
        this.warning_type = parcel.readInt();
        this.read = parcel.readByte() != 1 ? false : true;
        this.video_id = parcel.readString();
        this.pic_id = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.duration);
        parcel.writeLong(this.expiretime);
        parcel.writeLong(this.createTime);
        parcel.writeString(this.imgStoreId);
        parcel.writeString(this.fileId);
        parcel.writeString(this.desc);
        parcel.writeString(this.tags);
        parcel.writeString(this.userid);
        parcel.writeLong(this.video_time);
        parcel.writeInt(this.warning_type);
        parcel.writeByte(this.read ? (byte) 1 : 0);
        parcel.writeString(this.video_id);
        parcel.writeString(this.pic_id);
    }
}
