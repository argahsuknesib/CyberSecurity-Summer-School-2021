package com.xiaomi.smarthome.smartconfig;

import android.os.Parcel;
import android.os.Parcelable;

public class WifiInfo implements Parcelable {
    public static final Parcelable.Creator<WifiInfo> CREATOR = new Parcelable.Creator<WifiInfo>() {
        /* class com.xiaomi.smarthome.smartconfig.WifiInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WifiInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WifiInfo(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f11472O000000o;
    public boolean O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public WifiInfo() {
    }

    protected WifiInfo(Parcel parcel) {
        this.f11472O000000o = parcel.readInt();
        this.O00000Oo = parcel.readByte() != 0;
        this.O00000o0 = parcel.readString();
        this.O00000o = parcel.readString();
        this.O00000oO = parcel.readString();
        this.O00000oo = parcel.readString();
        this.O0000O0o = parcel.readString();
        this.O0000OOo = parcel.readString();
        this.O0000Oo0 = parcel.readString();
        this.O0000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11472O000000o);
        parcel.writeByte(this.O00000Oo ? (byte) 1 : 0);
        parcel.writeString(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O00000oO);
        parcel.writeString(this.O00000oo);
        parcel.writeString(this.O0000O0o);
        parcel.writeString(this.O0000OOo);
        parcel.writeString(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
    }
}
