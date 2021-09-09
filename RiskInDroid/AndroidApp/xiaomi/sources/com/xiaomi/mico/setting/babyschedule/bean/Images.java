package com.xiaomi.mico.setting.babyschedule.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Images implements Parcelable {
    public static final Parcelable.Creator<Images> CREATOR = new Parcelable.Creator<Images>() {
        /* class com.xiaomi.mico.setting.babyschedule.bean.Images.AnonymousClass1 */

        public final Images createFromParcel(Parcel parcel) {
            return new Images(parcel);
        }

        public final Images[] newArray(int i) {
            return new Images[i];
        }
    };
    private String background;
    public Poster poster;

    public int describeContents() {
        return 0;
    }

    protected Images(Parcel parcel) {
        this.background = parcel.readString();
        this.poster = (Poster) parcel.readParcelable(Poster.class.getClassLoader());
    }

    public Images(String str) {
        this.poster = new Poster(str);
    }

    public void setBackground(String str) {
        this.background = str;
    }

    public String getBackground() {
        return this.background;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.background);
        parcel.writeParcelable(this.poster, i);
    }
}
