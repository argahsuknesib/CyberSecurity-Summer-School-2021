package com.xiaomi.miot;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import java.util.ArrayList;

public class DeviceShowInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceShowInfo> CREATOR = new Parcelable.Creator<DeviceShowInfo>() {
        /* class com.xiaomi.miot.DeviceShowInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DeviceShowInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new DeviceShowInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6033O000000o;
    public String O00000Oo;
    public String O00000o = "";
    public String O00000o0 = "";
    public String O00000oO = "";
    public final ArrayList<Pair<String, String>> O00000oo = new ArrayList<>();
    public boolean O0000O0o;
    public boolean O0000OOo;
    public boolean O0000Oo;
    public boolean O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public DeviceShowInfo(Parcel parcel) {
        this.f6033O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readString();
        this.O00000oO = parcel.readString();
        boolean z = true;
        this.O0000O0o = parcel.readInt() != 0;
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.O00000oo.add(new Pair(parcel.readString(), parcel.readString()));
        }
        this.O0000OOo = parcel.readInt() != 0;
        this.O0000Oo0 = parcel.readInt() != 0;
        this.O00000o = parcel.readString();
        this.O0000Oo = parcel.readByte() == 0 ? false : z;
    }

    public DeviceShowInfo() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6033O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000oO);
        parcel.writeInt(this.O0000O0o ? 1 : 0);
        parcel.writeInt(this.O00000oo.size());
        for (int i2 = 0; i2 < this.O00000oo.size(); i2++) {
            Pair pair = this.O00000oo.get(i2);
            parcel.writeString((String) pair.first);
            parcel.writeString((String) pair.second);
        }
        parcel.writeInt(this.O0000OOo ? 1 : 0);
        parcel.writeInt(this.O0000Oo0 ? 1 : 0);
        parcel.writeString(this.O00000o);
        parcel.writeByte(this.O0000Oo ? (byte) 1 : 0);
    }

    public String toString() {
        return "DeviceInfo{did='" + this.f6033O000000o + '\'' + ", deviceName='" + this.O00000Oo + '\'' + ", icon='" + this.O00000o0 + '\'' + ", model='" + this.O00000o + '\'' + ", subtitle='" + this.O00000oO + '\'' + ", subtitleMap=" + this.O00000oo + ", isOnline=" + this.O0000O0o + ", showSlideButton=" + this.O0000OOo + ", currentStatus=" + this.O0000Oo0 + ", currentStatus=" + this.O0000Oo + '}';
    }
}
