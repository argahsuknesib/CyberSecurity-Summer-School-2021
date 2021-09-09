package com.xiaomi.accountsdk.account.data;

import android.os.Parcel;
import android.os.Parcelable;

public class MetaLoginData implements Parcelable {
    public static final Parcelable.Creator<MetaLoginData> CREATOR = new Parcelable.Creator<MetaLoginData>() {
        /* class com.xiaomi.accountsdk.account.data.MetaLoginData.AnonymousClass1 */

        public final MetaLoginData createFromParcel(Parcel parcel) {
            return new MetaLoginData(parcel);
        }

        public final MetaLoginData[] newArray(int i) {
            return new MetaLoginData[i];
        }
    };
    public final String callback;
    public final String qs;
    public final String sign;

    public int describeContents() {
        return 0;
    }

    public MetaLoginData(String str, String str2, String str3) {
        this.sign = str;
        this.qs = str2;
        this.callback = str3;
    }

    public MetaLoginData(Parcel parcel) {
        this.sign = parcel.readString();
        this.qs = parcel.readString();
        this.callback = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sign);
        parcel.writeString(this.qs);
        parcel.writeString(this.callback);
    }
}
