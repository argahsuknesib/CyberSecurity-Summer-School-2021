package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

public final class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        /* class com.amap.api.services.poisearch.Photo.AnonymousClass1 */

        /* renamed from: a */
        public final Photo[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final Photo createFromParcel(Parcel parcel) {
            return new Photo(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3474a;
    private String b;

    public final int describeContents() {
        return 0;
    }

    public Photo() {
    }

    public Photo(String str, String str2) {
        this.f3474a = str;
        this.b = str2;
    }

    public final String getTitle() {
        return this.f3474a;
    }

    public final void setTitle(String str) {
        this.f3474a = str;
    }

    public final String getUrl() {
        return this.b;
    }

    public final void setUrl(String str) {
        this.b = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3474a);
        parcel.writeString(this.b);
    }

    public Photo(Parcel parcel) {
        this.f3474a = parcel.readString();
        this.b = parcel.readString();
    }
}
