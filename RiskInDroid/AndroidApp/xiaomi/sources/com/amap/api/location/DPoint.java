package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;

public class DPoint implements Parcelable {
    public static final Parcelable.Creator<DPoint> CREATOR = new Parcelable.Creator<DPoint>() {
        /* class com.amap.api.location.DPoint.AnonymousClass1 */

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DPoint(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DPoint[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private double f3265a = 0.0d;
    private double b = 0.0d;

    public DPoint() {
    }

    public DPoint(double d, double d2) {
        d2 = d2 > 180.0d ? 180.0d : d2;
        d2 = d2 < -180.0d ? -180.0d : d2;
        d = d > 90.0d ? 90.0d : d;
        d = d < -90.0d ? -90.0d : d;
        this.f3265a = d2;
        this.b = d;
    }

    protected DPoint(Parcel parcel) {
        this.f3265a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return this.b == dPoint.b && this.f3265a == dPoint.f3265a;
    }

    public double getLatitude() {
        return this.b;
    }

    public double getLongitude() {
        return this.f3265a;
    }

    public int hashCode() {
        return Double.valueOf((this.b + this.f3265a) * 1000000.0d).intValue();
    }

    public void setLatitude(double d) {
        if (d > 90.0d) {
            d = 90.0d;
        }
        if (d < -90.0d) {
            d = -90.0d;
        }
        this.b = d;
    }

    public void setLongitude(double d) {
        if (d > 180.0d) {
            d = 180.0d;
        }
        if (d < -180.0d) {
            d = -180.0d;
        }
        this.f3265a = d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f3265a);
        parcel.writeDouble(this.b);
    }
}
