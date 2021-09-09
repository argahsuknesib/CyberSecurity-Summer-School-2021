package com.hannto.circledialog.params;

import android.os.Parcel;
import android.os.Parcelable;

public class DialogParams implements Parcelable {
    public static final Parcelable.Creator<DialogParams> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public int f4341O000000o;
    public boolean O00000Oo;
    public float O00000o;
    public boolean O00000o0;
    public float O00000oO;
    public int[] O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public int O0000Oo;
    public boolean O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo;
    public int O0000o00;

    public static class O000000o implements Parcelable.Creator<DialogParams> {
        public final Object createFromParcel(Parcel parcel) {
            return new DialogParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DialogParams[i];
        }
    }

    public DialogParams() {
        this.f4341O000000o = 80;
        this.O00000Oo = true;
        this.O00000o0 = true;
        this.O00000o = 1.0f;
        this.O00000oO = 1.0f;
        this.O00000oo = new int[]{0, 0, 0, 0};
        this.O0000Oo0 = true;
        this.O0000Oo = 0;
        this.O0000OoO = 60;
    }

    public DialogParams(Parcel parcel) {
        this.f4341O000000o = 80;
        boolean z = true;
        this.O00000Oo = true;
        this.O00000o0 = true;
        this.O00000o = 1.0f;
        this.O00000oO = 1.0f;
        this.O00000oo = new int[]{0, 0, 0, 0};
        this.O0000Oo0 = true;
        this.O0000Oo = 0;
        this.O0000OoO = 60;
        this.f4341O000000o = parcel.readInt();
        this.O00000Oo = parcel.readByte() != 0;
        this.O00000o0 = parcel.readByte() != 0;
        this.O00000o = parcel.readFloat();
        this.O00000oO = parcel.readFloat();
        this.O00000oo = parcel.createIntArray();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readByte() == 0 ? false : z;
        this.O0000Oo = parcel.readInt();
        this.O0000OoO = parcel.readInt();
        this.O0000Ooo = parcel.readInt();
        this.O0000o00 = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f4341O000000o);
        parcel.writeByte(this.O00000Oo ? (byte) 1 : 0);
        parcel.writeByte(this.O00000o0 ? (byte) 1 : 0);
        parcel.writeFloat(this.O00000o);
        parcel.writeFloat(this.O00000oO);
        parcel.writeIntArray(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeByte(this.O0000Oo0 ? (byte) 1 : 0);
        parcel.writeInt(this.O0000Oo);
        parcel.writeInt(this.O0000OoO);
        parcel.writeInt(this.O0000Ooo);
        parcel.writeInt(this.O0000o00);
    }
}
