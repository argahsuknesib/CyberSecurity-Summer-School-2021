package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class TaxiItem implements Parcelable {
    public static final Parcelable.Creator<TaxiItem> CREATOR = new Parcelable.Creator<TaxiItem>() {
        /* class com.amap.api.services.route.TaxiItem.AnonymousClass1 */

        /* renamed from: a */
        public final TaxiItem createFromParcel(Parcel parcel) {
            return new TaxiItem(parcel);
        }

        /* renamed from: a */
        public final TaxiItem[] newArray(int i) {
            return new TaxiItem[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f3521a;
    private LatLonPoint b;
    private float c;
    private float d;
    private String e;
    private String f;

    public int describeContents() {
        return 0;
    }

    public TaxiItem() {
    }

    public LatLonPoint getOrigin() {
        return this.f3521a;
    }

    public LatLonPoint getDestination() {
        return this.b;
    }

    public float getDistance() {
        return this.c;
    }

    public float getDuration() {
        return this.d;
    }

    public String getmSname() {
        return this.e;
    }

    public String getmTname() {
        return this.f;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f3521a = latLonPoint;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setDistance(float f2) {
        this.c = f2;
    }

    public void setDuration(float f2) {
        this.d = f2;
    }

    public void setSname(String str) {
        this.e = str;
    }

    public void setTname(String str) {
        this.f = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3521a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }

    protected TaxiItem(Parcel parcel) {
        this.f3521a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }
}
