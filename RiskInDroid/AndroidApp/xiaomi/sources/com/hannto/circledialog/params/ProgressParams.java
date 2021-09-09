package com.hannto.circledialog.params;

import android.os.Parcel;
import android.os.Parcelable;

public class ProgressParams implements Parcelable {
    public static final Parcelable.Creator<ProgressParams> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int[] f4343O000000o = {20, 45, 20, 45};
    public static final int[] O00000Oo = {0, 0, 0, 45};
    public int[] O00000o = f4343O000000o;
    public int O00000o0 = 0;
    public int[] O00000oO = O00000Oo;
    public int O00000oo;
    public int O0000O0o;
    public int O0000OOo;
    public String O0000Oo = "";
    public int O0000Oo0;
    public int O0000OoO;
    public int O0000Ooo = -872415232;
    public int O0000o00 = 45;

    public static class O000000o implements Parcelable.Creator<ProgressParams> {
        public final Object createFromParcel(Parcel parcel) {
            return new ProgressParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProgressParams[i];
        }
    }

    public ProgressParams() {
    }

    public ProgressParams(Parcel parcel) {
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.createIntArray();
        this.O00000oO = parcel.createIntArray();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readInt();
        this.O0000Ooo = parcel.readInt();
        this.O0000o00 = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000o0);
        parcel.writeIntArray(this.O00000o);
        parcel.writeIntArray(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeInt(this.O0000OoO);
        parcel.writeInt(this.O0000Ooo);
        parcel.writeInt(this.O0000o00);
    }
}
