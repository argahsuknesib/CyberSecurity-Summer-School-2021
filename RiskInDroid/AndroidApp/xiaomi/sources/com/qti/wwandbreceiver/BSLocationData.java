package com.qti.wwandbreceiver;

import android.os.Parcel;
import android.os.Parcelable;

public final class BSLocationData implements Parcelable {
    public static final Parcelable.Creator<BSLocationData> CREATOR = new Parcelable.Creator<BSLocationData>() {
        /* class com.qti.wwandbreceiver.BSLocationData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BSLocationData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BSLocationData(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f5464O000000o;
    public int O00000Oo;
    public int O00000o;
    public int O00000o0;
    public int O00000oO;
    public float O00000oo;
    public float O0000O0o;
    public int O0000OOo;
    public int O0000Oo;
    public float O0000Oo0;
    public int O0000OoO;
    public float O0000Ooo;
    public float O0000o0;
    public float O0000o00;
    public int O0000o0O;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ BSLocationData(Parcel parcel, byte b) {
        this(parcel);
    }

    public BSLocationData() {
        this.O0000OOo = 0;
    }

    private BSLocationData(Parcel parcel) {
        this.f5464O000000o = parcel.readInt();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readFloat();
        this.O0000O0o = parcel.readFloat();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readFloat();
        this.O0000Oo = parcel.readInt();
        this.O0000OoO = parcel.readInt();
        this.O0000Ooo = parcel.readFloat();
        this.O0000o00 = parcel.readFloat();
        this.O0000o0 = parcel.readFloat();
        this.O0000o0O = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5464O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeFloat(this.O00000oo);
        parcel.writeFloat(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeFloat(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo);
        parcel.writeInt(this.O0000OoO);
        parcel.writeFloat(this.O0000Ooo);
        parcel.writeFloat(this.O0000o00);
        parcel.writeFloat(this.O0000o0);
        parcel.writeInt(this.O0000o0O);
    }
}
