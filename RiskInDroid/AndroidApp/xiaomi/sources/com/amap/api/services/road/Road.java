package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new Parcelable.Creator<Road>() {
        /* class com.amap.api.services.road.Road.AnonymousClass1 */

        /* renamed from: a */
        public final Road[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public final Road createFromParcel(Parcel parcel) {
            return new Road(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3482a;
    private String b;
    private String c;
    private float d;
    private String e;
    private LatLonPoint f;

    public int describeContents() {
        return 0;
    }

    public Road() {
    }

    public Road(String str, String str2) {
        this.f3482a = str;
        this.b = str2;
    }

    public void setId(String str) {
        this.f3482a = str;
    }

    public void setName(String str) {
        this.b = str;
    }

    public String getCityCode() {
        return this.c;
    }

    public void setCityCode(String str) {
        this.c = str;
    }

    public float getRoadWidth() {
        return this.d;
    }

    public void setRoadWidth(float f2) {
        this.d = f2;
    }

    public String getType() {
        return this.e;
    }

    public void setType(String str) {
        this.e = str;
    }

    public LatLonPoint getCenterPoint() {
        return this.f;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f = latLonPoint;
    }

    public String getId() {
        return this.f3482a;
    }

    public String getName() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3482a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeFloat(this.d);
        parcel.writeString(this.e);
        parcel.writeValue(this.f);
    }

    protected Road(Parcel parcel) {
        this.f3482a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readString();
        this.f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
