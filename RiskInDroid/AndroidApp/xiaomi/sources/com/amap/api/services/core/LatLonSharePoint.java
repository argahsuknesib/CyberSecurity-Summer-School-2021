package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLonSharePoint extends LatLonPoint implements Parcelable {
    public static final Parcelable.Creator<LatLonSharePoint> CREATOR = new Parcelable.Creator<LatLonSharePoint>() {
        /* class com.amap.api.services.core.LatLonSharePoint.AnonymousClass1 */

        /* renamed from: a */
        public final LatLonSharePoint createFromParcel(Parcel parcel) {
            return new LatLonSharePoint(parcel);
        }

        /* renamed from: a */
        public final LatLonSharePoint[] newArray(int i) {
            return new LatLonSharePoint[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3443a;

    public int describeContents() {
        return 0;
    }

    public LatLonSharePoint(double d, double d2, String str) {
        super(d, d2);
        this.f3443a = str;
    }

    public String getSharePointName() {
        return this.f3443a;
    }

    public void setSharePointName(String str) {
        this.f3443a = str;
    }

    protected LatLonSharePoint(Parcel parcel) {
        super(parcel);
        this.f3443a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f3443a);
    }

    public int hashCode() {
        int i;
        int hashCode = super.hashCode() * 31;
        String str = this.f3443a;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        LatLonSharePoint latLonSharePoint = (LatLonSharePoint) obj;
        String str = this.f3443a;
        if (str == null) {
            if (latLonSharePoint.f3443a != null) {
                return false;
            }
        } else if (!str.equals(latLonSharePoint.f3443a)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return super.toString() + "," + this.f3443a;
    }
}
