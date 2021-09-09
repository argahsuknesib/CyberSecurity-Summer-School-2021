package com.xiaomi.mico.setting.babyschedule.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Poster implements Parcelable {
    public static final Parcelable.Creator<Poster> CREATOR = new Parcelable.Creator<Poster>() {
        /* class com.xiaomi.mico.setting.babyschedule.bean.Poster.AnonymousClass1 */

        public final Poster createFromParcel(Parcel parcel) {
            return new Poster(parcel);
        }

        public final Poster[] newArray(int i) {
            return new Poster[i];
        }
    };
    public String md5;
    public String url;

    public int describeContents() {
        return 0;
    }

    protected Poster(Parcel parcel) {
        this.url = parcel.readString();
        this.md5 = parcel.readString();
    }

    Poster(String str) {
        this.url = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.md5);
    }
}
