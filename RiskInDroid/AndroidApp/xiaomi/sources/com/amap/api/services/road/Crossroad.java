package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

public final class Crossroad extends Road implements Parcelable {
    public static final Parcelable.Creator<Crossroad> CREATOR = new Parcelable.Creator<Crossroad>() {
        /* class com.amap.api.services.road.Crossroad.AnonymousClass1 */

        /* renamed from: a */
        public final Crossroad[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final Crossroad createFromParcel(Parcel parcel) {
            return new Crossroad(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f3481a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public final int describeContents() {
        return 0;
    }

    public Crossroad() {
    }

    public final float getDistance() {
        return this.f3481a;
    }

    public final void setDistance(float f2) {
        this.f3481a = f2;
    }

    public final String getDirection() {
        return this.b;
    }

    public final void setDirection(String str) {
        this.b = str;
    }

    public final String getFirstRoadId() {
        return this.c;
    }

    public final void setFirstRoadId(String str) {
        this.c = str;
    }

    public final String getFirstRoadName() {
        return this.d;
    }

    public final void setFirstRoadName(String str) {
        this.d = str;
    }

    public final String getSecondRoadId() {
        return this.e;
    }

    public final void setSecondRoadId(String str) {
        this.e = str;
    }

    public final String getSecondRoadName() {
        return this.f;
    }

    public final void setSecondRoadName(String str) {
        this.f = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f3481a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.f3481a = parcel.readFloat();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
    }
}
