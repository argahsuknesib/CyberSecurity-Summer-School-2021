package com.qti.wwandbreceiver;

import android.os.Parcel;
import android.os.Parcelable;

public final class BSInfo implements Parcelable {
    public static final Parcelable.Creator<BSInfo> CREATOR = new Parcelable.Creator<BSInfo>() {
        /* class com.qti.wwandbreceiver.BSInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BSInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BSInfo(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5463O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public int O00000oo;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ BSInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public BSInfo() {
    }

    private BSInfo(Parcel parcel) {
        this.f5463O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5463O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O00000oo);
    }
}
