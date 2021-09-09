package com.mijia.model.sdcard;

import android.os.Parcel;
import android.os.Parcelable;

public class SDCardInfo implements Parcelable {
    public static final Parcelable.Creator<SDCardInfo> CREATOR = new Parcelable.Creator<SDCardInfo>() {
        /* class com.mijia.model.sdcard.SDCardInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SDCardInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SDCardInfo(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public long f5242O000000o;
    public long O00000Oo;
    public long O00000o;
    public long O00000o0;
    public int O00000oO;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ SDCardInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    private SDCardInfo(Parcel parcel) {
        this.f5242O000000o = 0;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        this.O00000o = 0;
        this.O00000oO = -1;
        this.f5242O000000o = parcel.readLong();
        this.O00000Oo = parcel.readLong();
        this.O00000o0 = parcel.readLong();
        this.O00000oO = parcel.readInt();
        this.O00000o = (this.f5242O000000o - this.O00000Oo) - this.O00000o0;
    }

    public SDCardInfo(long j, long j2, long j3, int i) {
        this.f5242O000000o = 0;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
        this.O00000o = 0;
        this.O00000oO = -1;
        this.f5242O000000o = j;
        this.O00000o0 = j2;
        this.O00000Oo = j3;
        this.O00000oO = i;
        this.O00000o = (this.f5242O000000o - this.O00000Oo) - this.O00000o0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f5242O000000o);
        parcel.writeLong(this.O00000Oo);
        parcel.writeLong(this.O00000o0);
        parcel.writeInt(this.O00000oO);
    }
}
