package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class FmshUserInfo implements Parcelable {
    public static final Parcelable.Creator<FmshUserInfo> CREATOR = new Parcelable.Creator<FmshUserInfo>() {
        /* class com.miui.tsmclient.entity.FmshUserInfo.AnonymousClass1 */

        public final FmshUserInfo createFromParcel(Parcel parcel) {
            FmshUserInfo fmshUserInfo = new FmshUserInfo();
            fmshUserInfo.mUserName = parcel.readString();
            fmshUserInfo.mPassword = parcel.readString();
            return fmshUserInfo;
        }

        public final FmshUserInfo[] newArray(int i) {
            return new FmshUserInfo[i];
        }
    };
    @SerializedName("bizPass")
    public String mPassword;
    @SerializedName("userName")
    public String mUserName;

    public int describeContents() {
        return 0;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public void setUserName(String str) {
        this.mUserName = str;
    }

    public String getPassword() {
        return this.mPassword;
    }

    public void setPassword(String str) {
        this.mPassword = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUserName);
        parcel.writeString(this.mPassword);
    }
}
