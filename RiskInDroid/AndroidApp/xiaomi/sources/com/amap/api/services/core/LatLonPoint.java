package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonPoint> CREATOR = new Parcelable.Creator<LatLonPoint>() {
        /* class com.amap.api.services.core.LatLonPoint.AnonymousClass1 */

        /* renamed from: a */
        public final LatLonPoint createFromParcel(Parcel parcel) {
            return new LatLonPoint(parcel);
        }

        /* renamed from: a */
        public final LatLonPoint[] newArray(int i) {
            return new LatLonPoint[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private double f3442a;
    private double b;

    public int describeContents() {
        return 0;
    }

    public LatLonPoint(double d, double d2) {
        this.f3442a = d;
        this.b = d2;
    }

    public double getLongitude() {
        return this.b;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public double getLatitude() {
        return this.f3442a;
    }

    public void setLatitude(double d) {
        this.f3442a = d;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f3442a, this.b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f3442a);
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        return Double.doubleToLongBits(this.f3442a) == Double.doubleToLongBits(latLonPoint.f3442a) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(latLonPoint.b);
    }

    public String toString() {
        return this.f3442a + "," + this.b;
    }

    protected LatLonPoint(Parcel parcel) {
        this.f3442a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f3442a);
        parcel.writeDouble(this.b);
    }
}
