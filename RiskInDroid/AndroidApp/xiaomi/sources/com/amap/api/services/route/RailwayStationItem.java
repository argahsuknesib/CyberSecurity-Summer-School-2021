package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = new Parcelable.Creator<RailwayStationItem>() {
        /* class com.amap.api.services.route.RailwayStationItem.AnonymousClass1 */

        /* renamed from: a */
        public final RailwayStationItem createFromParcel(Parcel parcel) {
            return new RailwayStationItem(parcel);
        }

        /* renamed from: a */
        public final RailwayStationItem[] newArray(int i) {
            return new RailwayStationItem[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3501a;
    private String b;
    private LatLonPoint c;
    private String d;
    private String e;
    private boolean f = false;
    private boolean g = false;
    private float h;

    public int describeContents() {
        return 0;
    }

    public RailwayStationItem() {
    }

    public String getID() {
        return this.f3501a;
    }

    public String getName() {
        return this.b;
    }

    public LatLonPoint getLocation() {
        return this.c;
    }

    public String getAdcode() {
        return this.d;
    }

    public String getTime() {
        return this.e;
    }

    public boolean isStart() {
        return this.f;
    }

    public boolean isEnd() {
        return this.g;
    }

    public float getWait() {
        return this.h;
    }

    public void setID(String str) {
        this.f3501a = str;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setAdcode(String str) {
        this.d = str;
    }

    public void setTime(String str) {
        this.e = str;
    }

    public void setisStart(boolean z) {
        this.f = z;
    }

    public void setisEnd(boolean z) {
        this.g = z;
    }

    public void setWait(float f2) {
        this.h = f2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3501a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeBooleanArray(new boolean[]{this.f, this.g});
        parcel.writeFloat(this.h);
    }

    protected RailwayStationItem(Parcel parcel) {
        this.f3501a = parcel.readString();
        this.b = parcel.readString();
        this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f = zArr[0];
        this.g = zArr[1];
        this.h = parcel.readFloat();
    }
}
