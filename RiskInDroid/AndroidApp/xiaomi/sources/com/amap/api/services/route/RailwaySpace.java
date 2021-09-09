package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class RailwaySpace implements Parcelable {
    public static final Parcelable.Creator<RailwaySpace> CREATOR = new Parcelable.Creator<RailwaySpace>() {
        /* class com.amap.api.services.route.RailwaySpace.AnonymousClass1 */

        /* renamed from: a */
        public final RailwaySpace createFromParcel(Parcel parcel) {
            return new RailwaySpace(parcel);
        }

        /* renamed from: a */
        public final RailwaySpace[] newArray(int i) {
            return new RailwaySpace[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3500a;
    private float b;

    public int describeContents() {
        return 0;
    }

    public RailwaySpace(String str, float f) {
        this.f3500a = str;
        this.b = f;
    }

    public String getCode() {
        return this.f3500a;
    }

    public float getCost() {
        return this.b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3500a);
        parcel.writeFloat(this.b);
    }

    protected RailwaySpace(Parcel parcel) {
        this.f3500a = parcel.readString();
        this.b = parcel.readFloat();
    }
}
