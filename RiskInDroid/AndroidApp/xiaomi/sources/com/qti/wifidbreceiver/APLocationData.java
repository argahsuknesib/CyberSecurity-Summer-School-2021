package com.qti.wifidbreceiver;

import android.os.Parcel;
import android.os.Parcelable;

public final class APLocationData implements Parcelable {
    public static final Parcelable.Creator<APLocationData> CREATOR = new Parcelable.Creator<APLocationData>() {
        /* class com.qti.wifidbreceiver.APLocationData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new APLocationData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new APLocationData(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f5460O000000o;
    public float O00000Oo;
    public float O00000o;
    public float O00000o0;
    public float O00000oO;
    public int O00000oo;
    public int O0000O0o;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ APLocationData(Parcel parcel, byte b) {
        this(parcel);
    }

    public APLocationData() {
    }

    private APLocationData(Parcel parcel) {
        this.f5460O000000o = parcel.readString();
        this.O00000Oo = parcel.readFloat();
        this.O00000o0 = parcel.readFloat();
        this.O00000o = parcel.readFloat();
        this.O00000oO = parcel.readFloat();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5460O000000o);
        parcel.writeFloat(this.O00000Oo);
        parcel.writeFloat(this.O00000o0);
        parcel.writeFloat(this.O00000o);
        parcel.writeFloat(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
    }
}
