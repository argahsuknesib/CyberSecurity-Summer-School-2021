package com.mijia.model.alarmcloud;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AlarmVideo implements Parcelable {
    public static final Parcelable.Creator<AlarmVideo> CREATOR = new Parcelable.Creator<AlarmVideo>() {
        /* class com.mijia.model.alarmcloud.AlarmVideo.AnonymousClass1 */

        public final AlarmVideo createFromParcel(Parcel parcel) {
            return new AlarmVideo(parcel);
        }

        public final AlarmVideo[] newArray(int i) {
            return new AlarmVideo[i];
        }
    };
    private static SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm", Locale.CHINA);
    public long createTime;
    public String eventType;
    public long expireTime;
    public String extraInfo;
    public String fileId;
    public FileIdMetaResult fileIdMetaResult;
    public String imgStoreId;
    public String imgStoreUrl;
    public boolean isAlarm;
    public boolean isKnownFace;
    public boolean isPlaying;
    public boolean isRead;
    public int offset;
    public double startDuration;
    public String videoStoreId;

    public int describeContents() {
        return 0;
    }

    public AlarmVideo() {
    }

    public AlarmVideo(AlarmVideo alarmVideo) {
        this.fileId = alarmVideo.fileId;
        this.createTime = alarmVideo.createTime;
        this.expireTime = alarmVideo.expireTime;
        this.videoStoreId = alarmVideo.videoStoreId;
        this.imgStoreId = alarmVideo.imgStoreId;
        this.extraInfo = alarmVideo.extraInfo;
        this.isAlarm = alarmVideo.isAlarm;
        this.eventType = alarmVideo.eventType;
        this.offset = alarmVideo.offset;
        this.startDuration = alarmVideo.startDuration;
        this.imgStoreUrl = alarmVideo.imgStoreUrl;
        this.fileIdMetaResult = alarmVideo.fileIdMetaResult;
        this.isRead = alarmVideo.isRead;
        this.isPlaying = alarmVideo.isPlaying;
        this.isKnownFace = alarmVideo.isKnownFace;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fileId);
        parcel.writeLong(this.createTime);
        parcel.writeLong(this.expireTime);
        parcel.writeString(this.videoStoreId);
        parcel.writeString(this.imgStoreId);
        parcel.writeString(this.extraInfo);
        parcel.writeByte(this.isAlarm ? (byte) 1 : 0);
        parcel.writeString(this.eventType);
        parcel.writeInt(this.offset);
        parcel.writeDouble(this.startDuration);
        parcel.writeString(this.imgStoreUrl);
        parcel.writeParcelable(this.fileIdMetaResult, i);
        parcel.writeByte(this.isRead ? (byte) 1 : 0);
    }

    protected AlarmVideo(Parcel parcel) {
        this.fileId = parcel.readString();
        this.createTime = parcel.readLong();
        this.expireTime = parcel.readLong();
        this.videoStoreId = parcel.readString();
        this.imgStoreId = parcel.readString();
        this.extraInfo = parcel.readString();
        boolean z = true;
        this.isAlarm = parcel.readByte() != 0;
        this.eventType = parcel.readString();
        this.offset = parcel.readInt();
        this.startDuration = parcel.readDouble();
        this.imgStoreUrl = parcel.readString();
        this.fileIdMetaResult = (FileIdMetaResult) parcel.readParcelable(FileIdMetaResult.class.getClassLoader());
        this.isRead = parcel.readByte() == 0 ? false : z;
    }

    public String toString() {
        return "AlarmVideo{fileId='" + this.fileId + '\'' + ", createTime=" + this.createTime + "(" + mSdf.format(Long.valueOf(this.createTime)) + "), expireTime=" + this.expireTime + ", eventType='" + this.eventType + '\'' + ", offset=" + this.offset + ", startDuration=" + this.startDuration + ", fileIdMetaResult=" + this.fileIdMetaResult + ", isRead=" + this.isRead + ", isPlaying=" + this.isPlaying + ", isAlarm=" + this.isAlarm + '}';
    }
}
