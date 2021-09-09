package com.qti.wifidbreceiver;

import android.os.Parcel;
import android.os.Parcelable;

public final class APSpecialInfo implements Parcelable {
    public static final Parcelable.Creator<APSpecialInfo> CREATOR = new Parcelable.Creator<APSpecialInfo>() {
        /* class com.qti.wifidbreceiver.APSpecialInfo.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new APSpecialInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new APSpecialInfo(parcel, (byte) 0);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public String f5461O000000o;
    public int O00000Oo;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ APSpecialInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public APSpecialInfo() {
    }

    private APSpecialInfo(Parcel parcel) {
        this.f5461O000000o = parcel.readString();
        this.O00000Oo = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5461O000000o);
        parcel.writeInt(this.O00000Oo);
    }
}
