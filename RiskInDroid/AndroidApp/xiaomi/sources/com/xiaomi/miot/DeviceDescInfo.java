package com.xiaomi.miot;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceDescInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceDescInfo> CREATOR = new Parcelable.Creator<DeviceDescInfo>() {
        /* class com.xiaomi.miot.DeviceDescInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DeviceDescInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DeviceDescInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f6031O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public long O0000OOo;

    public int describeContents() {
        return 0;
    }

    public DeviceDescInfo() {
    }

    public DeviceDescInfo(Parcel parcel) {
        this.f6031O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f6031O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeLong(this.O0000OOo);
    }
}
