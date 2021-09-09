package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new Parcelable.Creator<StreetNumber>() {
        /* class com.amap.api.services.geocoder.StreetNumber.AnonymousClass1 */

        /* renamed from: a */
        public final StreetNumber[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final StreetNumber createFromParcel(Parcel parcel) {
            return new StreetNumber(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3462a;
    private String b;
    private LatLonPoint c;
    private String d;
    private float e;

    public final int describeContents() {
        return 0;
    }

    public StreetNumber() {
    }

    public final String getStreet() {
        return this.f3462a;
    }

    public final void setStreet(String str) {
        this.f3462a = str;
    }

    public final String getNumber() {
        return this.b;
    }

    public final void setNumber(String str) {
        this.b = str;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.c;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public final String getDirection() {
        return this.d;
    }

    public final void setDirection(String str) {
        this.d = str;
    }

    public final float getDistance() {
        return this.e;
    }

    public final void setDistance(float f) {
        this.e = f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3462a);
        parcel.writeString(this.b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        parcel.writeFloat(this.e);
    }

    private StreetNumber(Parcel parcel) {
        this.f3462a = parcel.readString();
        this.b = parcel.readString();
        this.c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readFloat();
    }
}
