package com.xiaomi.smarthome.scene.geofence.manager.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GeoFenceItem implements Parcelable {
    public static final Parcelable.Creator<GeoFenceItem> CREATOR = new Parcelable.Creator<GeoFenceItem>() {
        /* class com.xiaomi.smarthome.scene.geofence.manager.model.GeoFenceItem.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeoFenceItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeoFenceItem(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public final double f11139O000000o;
    public final double O00000Oo;
    public long O00000o;
    public final double O00000o0;
    public final int O00000oO;

    public int describeContents() {
        return 0;
    }

    public GeoFenceItem(double d, double d2, double d3, int i) {
        this.f11139O000000o = d;
        this.O00000Oo = d2;
        this.O00000o0 = d3;
        this.O00000oO = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f11139O000000o);
        parcel.writeDouble(this.O00000Oo);
        parcel.writeDouble(this.O00000o0);
        parcel.writeInt(this.O00000oO);
        parcel.writeLong(this.O00000o);
    }

    protected GeoFenceItem(Parcel parcel) {
        this.f11139O000000o = parcel.readDouble();
        this.O00000Oo = parcel.readDouble();
        this.O00000o0 = parcel.readDouble();
        this.O00000oO = parcel.readInt();
        this.O00000o = parcel.readLong();
    }
}
