package com.xiaomi.smarthome.device.api;

import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        /* class com.xiaomi.smarthome.device.api.UserInfo.AnonymousClass1 */

        public final UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }

        public final UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    };
    public String birth;
    public String email;
    public String localPath;
    public String nickName;
    public String phone;
    public String sex;
    public long shareTime;
    public String url;
    public String userId;

    public int describeContents() {
        return 0;
    }

    public UserInfo() {
    }

    public UserInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    /* access modifiers changed from: package-private */
    public void writeString(String str, Parcel parcel) {
        if (str == null) {
            parcel.writeString("");
        } else {
            parcel.writeString(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void readFromParcel(Parcel parcel) {
        this.userId = parcel.readString();
        this.nickName = parcel.readString();
        this.url = parcel.readString();
        this.localPath = parcel.readString();
        this.shareTime = parcel.readLong();
        this.phone = parcel.readString();
        this.email = parcel.readString();
        this.sex = parcel.readString();
        this.birth = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeString(this.userId, parcel);
        writeString(this.nickName, parcel);
        writeString(this.url, parcel);
        writeString(this.localPath, parcel);
        parcel.writeLong(this.shareTime);
        writeString(this.phone, parcel);
        writeString(this.email, parcel);
        writeString(this.sex, parcel);
        writeString(this.birth, parcel);
    }
}
