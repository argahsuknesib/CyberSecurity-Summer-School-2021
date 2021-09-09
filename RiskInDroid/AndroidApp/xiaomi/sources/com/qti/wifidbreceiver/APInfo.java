package com.qti.wifidbreceiver;

import android.os.Parcel;
import android.os.Parcelable;

public final class APInfo implements Parcelable {
    public static final Parcelable.Creator<APInfo> CREATOR = new Parcelable.Creator<APInfo>() {
        /* class com.qti.wifidbreceiver.APInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new APInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new APInfo(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f5458O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;
    public byte[] O0000O0o;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ APInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public APInfo() {
    }

    private APInfo(Parcel parcel) {
        this.f5458O000000o = parcel.readString();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.createByteArray();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5458O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeByteArray(this.O0000O0o);
    }
}
