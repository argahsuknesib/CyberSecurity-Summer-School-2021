package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = new Parcelable.Creator<PoiItemExtension>() {
        /* class com.amap.api.services.poisearch.PoiItemExtension.AnonymousClass1 */

        /* renamed from: a */
        public final PoiItemExtension createFromParcel(Parcel parcel) {
            return new PoiItemExtension(parcel);
        }

        /* renamed from: a */
        public final PoiItemExtension[] newArray(int i) {
            return new PoiItemExtension[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3475a;
    private String b;

    public int describeContents() {
        return 0;
    }

    public PoiItemExtension(String str, String str2) {
        this.f3475a = str;
        this.b = str2;
    }

    public String getOpentime() {
        return this.f3475a;
    }

    public String getmRating() {
        return this.b;
    }

    protected PoiItemExtension(Parcel parcel) {
        this.f3475a = parcel.readString();
        this.b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3475a);
        parcel.writeString(this.b);
    }
}
