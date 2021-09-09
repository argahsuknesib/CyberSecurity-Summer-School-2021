package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class SubPoiItem implements Parcelable {
    public static final Parcelable.Creator<SubPoiItem> CREATOR = new Parcelable.Creator<SubPoiItem>() {
        /* class com.amap.api.services.poisearch.SubPoiItem.AnonymousClass1 */

        /* renamed from: a */
        public final SubPoiItem[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final SubPoiItem createFromParcel(Parcel parcel) {
            return new SubPoiItem(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3480a;
    private String b;
    private String c;
    private int d;
    private LatLonPoint e;
    private String f;
    private String g;

    public int describeContents() {
        return 0;
    }

    public SubPoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f3480a = str;
        this.e = latLonPoint;
        this.b = str2;
        this.f = str3;
    }

    public SubPoiItem(Parcel parcel) {
        this.f3480a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readInt();
        this.e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f = parcel.readString();
        this.g = parcel.readString();
    }

    public String getPoiId() {
        return this.f3480a;
    }

    public void setPoiId(String str) {
        this.f3480a = str;
    }

    public String getTitle() {
        return this.b;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public String getSubName() {
        return this.c;
    }

    public void setSubName(String str) {
        this.c = str;
    }

    public int getDistance() {
        return this.d;
    }

    public void setDistance(int i) {
        this.d = i;
    }

    public LatLonPoint getLatLonPoint() {
        return this.e;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public String getSnippet() {
        return this.f;
    }

    public void setSnippet(String str) {
        this.f = str;
    }

    public String getSubTypeDes() {
        return this.g;
    }

    public void setSubTypeDes(String str) {
        this.g = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3480a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.d);
        parcel.writeValue(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
    }
}
