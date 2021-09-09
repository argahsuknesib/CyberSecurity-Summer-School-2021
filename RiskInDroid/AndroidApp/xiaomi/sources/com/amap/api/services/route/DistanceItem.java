package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

public class DistanceItem implements Parcelable {
    public static final Parcelable.Creator<DistanceItem> CREATOR = new Parcelable.Creator<DistanceItem>() {
        /* class com.amap.api.services.route.DistanceItem.AnonymousClass1 */

        /* renamed from: a */
        public final DistanceItem createFromParcel(Parcel parcel) {
            return new DistanceItem(parcel);
        }

        /* renamed from: a */
        public final DistanceItem[] newArray(int i) {
            return new DistanceItem[i];
        }
    };
    public final int ERROR_CODE_NOT_IN_CHINA = 3;
    public final int ERROR_CODE_NO_DRIVE = 1;
    public final int ERROR_CODE_TOO_FAR = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f3486a = 1;
    private int b = 1;
    private float c = 0.0f;
    private float d = 0.0f;
    private String e;
    private int f;

    public int describeContents() {
        return 0;
    }

    public int getOriginId() {
        return this.f3486a;
    }

    public int getDestId() {
        return this.b;
    }

    public float getDistance() {
        return this.c;
    }

    public float getDuration() {
        return this.d;
    }

    public String getErrorInfo() {
        return this.e;
    }

    public int getErrorCode() {
        return this.f;
    }

    public void setOriginId(int i) {
        this.f3486a = i;
    }

    public void setDestId(int i) {
        this.b = i;
    }

    public void setDistance(float f2) {
        this.c = f2;
    }

    public void setDuration(float f2) {
        this.d = f2;
    }

    public void setErrorInfo(String str) {
        this.e = str;
    }

    public void setErrorCode(int i) {
        this.f = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3486a);
        parcel.writeInt(this.b);
        parcel.writeFloat(this.c);
        parcel.writeFloat(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
    }

    public DistanceItem() {
    }

    protected DistanceItem(Parcel parcel) {
        this.f3486a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
        this.e = parcel.readString();
        this.f = parcel.readInt();
    }
}
