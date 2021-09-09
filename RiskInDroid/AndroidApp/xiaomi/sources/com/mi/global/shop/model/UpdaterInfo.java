package com.mi.global.shop.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

public class UpdaterInfo implements Parcelable {
    public static final Parcelable.Creator<UpdaterInfo> CREATOR = new Parcelable.Creator<UpdaterInfo>() {
        /* class com.mi.global.shop.model.UpdaterInfo.AnonymousClass1 */

        public final UpdaterInfo[] newArray(int i) {
            return new UpdaterInfo[i];
        }

        public final UpdaterInfo createFromParcel(Parcel parcel) {
            UpdaterInfo updaterInfo = new UpdaterInfo();
            updaterInfo.mUpdateUrl = parcel.readString();
            updaterInfo.mVersion = parcel.readString();
            updaterInfo.mVersionCode = parcel.readInt();
            updaterInfo.forceUpdate = parcel.readByte() != 0;
            updaterInfo.mDescList = new ArrayList<>();
            parcel.readList(updaterInfo.mDescList, DescType.class.getClassLoader());
            return updaterInfo;
        }
    };
    public boolean forceUpdate;
    public ArrayList<DescType> mDescList;
    public String mUpdateUrl;
    public String mVersion;
    public int mVersionCode;

    public static class DescType implements Serializable {
        public String mDesc;
        public String mDescType;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUpdateUrl);
        parcel.writeString(this.mVersion);
        parcel.writeInt(this.mVersionCode);
        parcel.writeByte(this.forceUpdate ? (byte) 1 : 0);
        parcel.writeList(this.mDescList);
    }
}
