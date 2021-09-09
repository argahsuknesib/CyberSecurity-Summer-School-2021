package com.hannto.circledialog.params;

import _m_j.O0000o00;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class ButtonParams implements Parcelable {
    public static final Parcelable.Creator<ButtonParams> CREATOR = new O000000o();
    public boolean O00000Oo = true;
    public O0000o00 O00000o;
    public View.OnClickListener O00000o0;
    public int O00000oO;
    public int O00000oo = -1;
    public int O0000O0o = 42;
    public int O0000OOo = 216;
    public String O0000Oo;
    public int O0000Oo0 = -1;
    public boolean O0000OoO = true;

    public static class O000000o implements Parcelable.Creator<ButtonParams> {
        public final Object createFromParcel(Parcel parcel) {
            return new ButtonParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ButtonParams[i];
        }
    }

    public ButtonParams() {
    }

    public ButtonParams(Parcel parcel) {
        boolean z = true;
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readInt();
        this.O0000O0o = parcel.readInt();
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readString();
        this.O0000OoO = parcel.readByte() == 0 ? false : z;
    }

    public void O000000o() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O00000oo);
        parcel.writeInt(this.O0000O0o);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
        parcel.writeString(this.O0000Oo);
        parcel.writeByte(this.O0000OoO ? (byte) 1 : 0);
    }
}
