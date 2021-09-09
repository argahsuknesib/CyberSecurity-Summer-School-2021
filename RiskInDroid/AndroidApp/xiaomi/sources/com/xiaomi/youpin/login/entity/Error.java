package com.xiaomi.youpin.login.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Error implements Parcelable {
    public static final Parcelable.Creator<Error> CREATOR = new Parcelable.Creator<Error>() {
        /* class com.xiaomi.youpin.login.entity.Error.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Error[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Error(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12083O000000o;
    public String O00000Oo;

    public int describeContents() {
        return 0;
    }

    public Error(int i, String str) {
        this.f12083O000000o = i;
        this.O00000Oo = str;
    }

    protected Error(Parcel parcel) {
        this.f12083O000000o = parcel.readInt();
        this.O00000Oo = parcel.readString();
    }

    public String toString() {
        return "Error{mCode=" + this.f12083O000000o + ", mDetail='" + this.O00000Oo + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12083O000000o);
        parcel.writeString(this.O00000Oo);
    }
}
