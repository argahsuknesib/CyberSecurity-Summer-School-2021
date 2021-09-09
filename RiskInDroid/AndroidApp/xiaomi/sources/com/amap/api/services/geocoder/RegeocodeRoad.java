package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new Parcelable.Creator<RegeocodeRoad>() {
        /* class com.amap.api.services.geocoder.RegeocodeRoad.AnonymousClass1 */

        /* renamed from: a */
        public final RegeocodeRoad[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final RegeocodeRoad createFromParcel(Parcel parcel) {
            return new RegeocodeRoad(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3461a;
    private String b;
    private float c;
    private String d;
    private LatLonPoint e;

    public final int describeContents() {
        return 0;
    }

    public RegeocodeRoad() {
    }

    public final String getId() {
        return this.f3461a;
    }

    public final void setId(String str) {
        this.f3461a = str;
    }

    public final String getName() {
        return this.b;
    }

    public final void setName(String str) {
        this.b = str;
    }

    public final float getDistance() {
        return this.c;
    }

    public final void setDistance(float f) {
        this.c = f;
    }

    public final String getDirection() {
        return this.d;
    }

    public final void setDirection(String str) {
        this.d = str;
    }

    public final LatLonPoint getLatLngPoint() {
        return this.e;
    }

    public final void setLatLngPoint(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3461a);
        parcel.writeString(this.b);
        parcel.writeFloat(this.c);
        parcel.writeString(this.d);
        parcel.writeValue(this.e);
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f3461a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readFloat();
        this.d = parcel.readString();
        this.e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
