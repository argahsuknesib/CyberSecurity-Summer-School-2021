package com.hannto.circledialog.params;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputFilter;

public class InputParams implements Parcelable {
    public static final Parcelable.Creator<InputParams> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int[] f4342O000000o = {50, 20, 50, 40};
    public int[] O00000Oo = f4342O000000o;
    public String O00000o;
    public int O00000o0 = 114;
    public int O00000oO = 1711276032;
    public int O00000oo;
    public int O0000O0o = 1;
    public int O0000OOo = 855638016;
    public int O0000Oo;
    public int O0000Oo0 = 0;
    public int O0000OoO = 45;
    public int O0000Ooo = 1711276032;
    public String O0000o0;
    public InputFilter O0000o00;
    public int O0000o0O = 200;

    public static class O000000o implements Parcelable.Creator<InputParams> {
        public final Object createFromParcel(Parcel parcel) {
            return new InputParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new InputParams[i];
        }
    }

    public InputParams() {
    }

    public InputParams(Parcel parcel) {
        this.O00000Oo = parcel.createIntArray();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readString();
        this.O0000o0 = parcel.readString();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readInt();
        this.O0000OoO = parcel.readInt();
        this.O0000Ooo = parcel.readInt();
        this.O0000o0O = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeString(this.O00000o);
        parcel.writeString(this.O0000o0);
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo);
        parcel.writeInt(this.O0000OoO);
        parcel.writeInt(this.O0000Ooo);
        parcel.writeInt(this.O0000o0O);
    }
}
