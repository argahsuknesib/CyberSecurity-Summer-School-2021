package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new Parcelable.Creator<IndoorData>() {
        /* class com.amap.api.services.poisearch.IndoorData.AnonymousClass1 */

        /* renamed from: a */
        public final IndoorData createFromParcel(Parcel parcel) {
            return new IndoorData(parcel);
        }

        /* renamed from: a */
        public final IndoorData[] newArray(int i) {
            return new IndoorData[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f3473a;
    private int b;
    private String c;

    public int describeContents() {
        return 0;
    }

    public IndoorData(String str, int i, String str2) {
        this.f3473a = str;
        this.b = i;
        this.c = str2;
    }

    public String getPoiId() {
        return this.f3473a;
    }

    public void setPoiId(String str) {
        this.f3473a = str;
    }

    public int getFloor() {
        return this.b;
    }

    public void setFloor(int i) {
        this.b = i;
    }

    public String getFloorName() {
        return this.c;
    }

    public void setFloorName(String str) {
        this.c = str;
    }

    protected IndoorData(Parcel parcel) {
        this.f3473a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3473a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
    }
}
