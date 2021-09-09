package com.hannto.circledialog.params;

import android.os.Parcel;
import android.os.Parcelable;

public class TitleParams implements Parcelable {
    public static final Parcelable.Creator<TitleParams> CREATOR = new O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public String f4345O000000o;
    public int O00000Oo = 204;
    public int O00000o = -16777216;
    public int O00000o0 = 45;
    public int O00000oO;
    public int O00000oo = 17;

    public static class O000000o implements Parcelable.Creator<TitleParams> {
        public final Object createFromParcel(Parcel parcel) {
            return new TitleParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TitleParams[i];
        }
    }

    public TitleParams() {
    }

    public TitleParams(Parcel parcel) {
        this.f4345O000000o = parcel.readString();
        this.O00000Oo = parcel.readInt();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4345O000000o);
        parcel.writeInt(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeInt(this.O00000oO);
        parcel.writeInt(this.O00000oo);
    }
}
