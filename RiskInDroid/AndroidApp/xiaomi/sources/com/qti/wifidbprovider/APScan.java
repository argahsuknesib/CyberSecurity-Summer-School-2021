package com.qti.wifidbprovider;

import android.os.Parcel;
import android.os.Parcelable;

public final class APScan implements Parcelable {
    public static final Parcelable.Creator<APScan> CREATOR = new Parcelable.Creator<APScan>() {
        /* class com.qti.wifidbprovider.APScan.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new APScan[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new APScan(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f5457O000000o;
    public float O00000Oo;
    public byte[] O00000o;
    public int O00000o0;
    public int O00000oO;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ APScan(Parcel parcel, byte b) {
        this(parcel);
    }

    public APScan() {
    }

    private APScan(Parcel parcel) {
        this.f5457O000000o = parcel.readString();
        this.O00000Oo = parcel.readFloat();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.createByteArray();
        this.O00000oO = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5457O000000o);
        parcel.writeFloat(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeByteArray(this.O00000o);
        parcel.writeInt(this.O00000oO);
    }
}
