package com.mijia.model.band;

import android.os.Parcel;
import android.os.Parcelable;

public class CameraBand implements Parcelable, Comparable<CameraBand> {
    public static final Parcelable.Creator<CameraBand> CREATOR = new Parcelable.Creator<CameraBand>() {
        /* class com.mijia.model.band.CameraBand.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CameraBand[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CameraBand(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private String f5241O000000o;
    private String O00000Oo;
    private int O00000o;
    private int O00000o0;

    public int describeContents() {
        return 0;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int i = this.O00000o0;
        int i2 = ((CameraBand) obj).O00000o0;
        if (i > i2) {
            return -1;
        }
        return (i != i2 && i < i2) ? 1 : 0;
    }

    public CameraBand() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5241O000000o);
        parcel.writeString(this.O00000Oo);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
    }

    protected CameraBand(Parcel parcel) {
        this.f5241O000000o = parcel.readString();
        this.O00000Oo = parcel.readString();
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
    }
}
