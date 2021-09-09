package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new Parcelable.Creator<RoutePOIItem>() {
        /* class com.amap.api.services.routepoisearch.RoutePOIItem.AnonymousClass1 */

        /* renamed from: a */
        public final RoutePOIItem createFromParcel(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }

        /* renamed from: a */
        public final RoutePOIItem[] newArray(int i) {
            return new RoutePOIItem[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3530a;
    private String b;
    private LatLonPoint c;
    private float d;
    private float e;

    public int describeContents() {
        return 0;
    }

    public RoutePOIItem() {
    }

    public String getID() {
        return this.f3530a;
    }

    public void setID(String str) {
        this.f3530a = str;
    }

    public String getTitle() {
        return this.b;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public LatLonPoint getPoint() {
        return this.c;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public float getDistance() {
        return this.d;
    }

    public void setDistance(float f) {
        this.d = f;
    }

    public float getDuration() {
        return this.e;
    }

    public void setDuration(float f) {
        this.e = f;
    }

    protected RoutePOIItem(Parcel parcel) {
        this.f3530a = parcel.readString();
        this.b = parcel.readString();
        this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.d = parcel.readFloat();
        this.e = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3530a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
    }
}
