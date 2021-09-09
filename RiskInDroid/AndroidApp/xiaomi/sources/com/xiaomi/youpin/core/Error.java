package com.xiaomi.youpin.core;

import android.os.Parcel;
import android.os.Parcelable;

public class Error implements Parcelable {
    public static final Parcelable.Creator<Error> CREATOR = new Parcelable.Creator<Error>() {
        /* class com.xiaomi.youpin.core.Error.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Error[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Error(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private int f12060O000000o;
    private String O00000Oo;

    public int describeContents() {
        return 0;
    }

    protected Error(Parcel parcel) {
        this.f12060O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12060O000000o);
        parcel.writeString(this.O00000Oo);
    }
}
