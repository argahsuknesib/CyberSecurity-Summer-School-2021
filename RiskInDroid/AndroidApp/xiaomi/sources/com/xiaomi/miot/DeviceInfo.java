package com.xiaomi.miot;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new Parcelable.Creator<DeviceInfo>() {
        /* class com.xiaomi.miot.DeviceInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DeviceInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DeviceInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6032O000000o;
    public String O00000Oo;
    public String O00000o = "";
    public String O00000o0 = "";
    public String O00000oO = "";
    public Bundle O00000oo = new Bundle();
    public boolean O0000O0o;
    public boolean O0000OOo;
    public boolean O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public DeviceInfo(Parcel parcel) {
        this.f6032O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000oO = parcel.readString();
        boolean z = true;
        this.O0000O0o = parcel.readInt() != 0;
        this.O00000oo = parcel.readBundle(ClassLoader.getSystemClassLoader());
        this.O0000OOo = parcel.readInt() != 0;
        this.O0000Oo0 = parcel.readInt() == 0 ? false : z;
        this.O00000o = parcel.readString();
    }

    public DeviceInfo() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6032O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000oO);
        parcel.writeInt(this.O0000O0o ? 1 : 0);
        parcel.writeBundle(this.O00000oo);
        parcel.writeInt(this.O0000OOo ? 1 : 0);
        parcel.writeInt(this.O0000Oo0 ? 1 : 0);
        parcel.writeString(this.O00000o);
    }

    public String toString() {
        return "DeviceInfo{did='" + this.f6032O000000o + '\'' + ", deviceName='" + this.O00000Oo + '\'' + ", icon='" + this.O00000o0 + '\'' + ", model='" + this.O00000o + '\'' + ", subtitle='" + this.O00000oO + '\'' + ", subtitleMap=" + this.O00000oo + ", isOnline=" + this.O0000O0o + ", showSlideButton=" + this.O0000OOo + ", currentStatus=" + this.O0000Oo0 + '}';
    }
}
