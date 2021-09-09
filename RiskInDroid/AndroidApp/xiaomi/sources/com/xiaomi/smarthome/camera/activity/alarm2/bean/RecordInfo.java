package com.xiaomi.smarthome.camera.activity.alarm2.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class RecordInfo implements Parcelable {
    public static final Parcelable.Creator<RecordInfo> CREATOR = new Parcelable.Creator<RecordInfo>() {
        /* class com.xiaomi.smarthome.camera.activity.alarm2.bean.RecordInfo.AnonymousClass1 */

        public final RecordInfo[] newArray(int i) {
            return new RecordInfo[i];
        }

        public final RecordInfo createFromParcel(Parcel parcel) {
            return new RecordInfo(parcel);
        }
    };
    private String desc;
    private String did;
    private String key;
    private long time;
    private String type;
    private String uid;
    private VideoInfo value;

    public int describeContents() {
        return 0;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public VideoInfo getValue() {
        return this.value;
    }

    public void setValue(VideoInfo videoInfo) {
        this.value = videoInfo;
    }

    public RecordInfo() {
    }

    public RecordInfo(Parcel parcel) {
        this.uid = parcel.readString();
        this.time = parcel.readLong();
        this.type = parcel.readString();
        this.did = parcel.readString();
        this.key = parcel.readString();
        this.value = (VideoInfo) parcel.readParcelable(VideoInfo.class.getClassLoader());
        this.desc = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeLong(this.time);
        parcel.writeString(this.type);
        parcel.writeString(this.did);
        parcel.writeString(this.key);
        parcel.writeParcelable(this.value, 1);
        parcel.writeString(this.desc);
    }
}
