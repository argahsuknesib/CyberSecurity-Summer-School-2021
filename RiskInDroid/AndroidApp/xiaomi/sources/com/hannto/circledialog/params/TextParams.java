package com.hannto.circledialog.params;

import _m_j.O0000O0o;
import android.os.Parcel;
import android.os.Parcelable;

public class TextParams implements Parcelable {
    public static final Parcelable.Creator<TextParams> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public int[] f4344O000000o = O0000O0o.f5250O000000o;
    public String O00000Oo;
    public int O00000o;
    public int O00000o0 = 135;
    public int O00000oO = -872415232;
    public int O00000oo = 45;
    public int O0000O0o = 1;

    public static class O000000o implements Parcelable.Creator<TextParams> {
        public final Object createFromParcel(Parcel parcel) {
            return new TextParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TextParams[i];
        }
    }

    public TextParams() {
    }

    public TextParams(Parcel parcel) {
        this.f4344O000000o = parcel.createIntArray();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f4344O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
    }
}
