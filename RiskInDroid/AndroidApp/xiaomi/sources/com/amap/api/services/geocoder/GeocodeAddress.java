package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public final class GeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<GeocodeAddress> CREATOR = new Parcelable.Creator<GeocodeAddress>() {
        /* class com.amap.api.services.geocoder.GeocodeAddress.AnonymousClass1 */

        /* renamed from: a */
        public final GeocodeAddress[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final GeocodeAddress createFromParcel(Parcel parcel) {
            return new GeocodeAddress(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3454a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private LatLonPoint i;
    private String j;

    public final int describeContents() {
        return 0;
    }

    public GeocodeAddress() {
    }

    public final String getFormatAddress() {
        return this.f3454a;
    }

    public final void setFormatAddress(String str) {
        this.f3454a = str;
    }

    public final String getProvince() {
        return this.b;
    }

    public final void setProvince(String str) {
        this.b = str;
    }

    public final String getCity() {
        return this.c;
    }

    public final void setCity(String str) {
        this.c = str;
    }

    public final String getDistrict() {
        return this.d;
    }

    public final void setDistrict(String str) {
        this.d = str;
    }

    public final String getTownship() {
        return this.e;
    }

    public final void setTownship(String str) {
        this.e = str;
    }

    public final String getNeighborhood() {
        return this.f;
    }

    public final void setNeighborhood(String str) {
        this.f = str;
    }

    public final String getBuilding() {
        return this.g;
    }

    public final void setBuilding(String str) {
        this.g = str;
    }

    public final String getAdcode() {
        return this.h;
    }

    public final void setAdcode(String str) {
        this.h = str;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.i;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.i = latLonPoint;
    }

    public final String getLevel() {
        return this.j;
    }

    public final void setLevel(String str) {
        this.j = str;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f3454a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeValue(this.i);
        parcel.writeString(this.j);
    }

    private GeocodeAddress(Parcel parcel) {
        this.f3454a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.j = parcel.readString();
    }
}
