package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class IZatUtcSpec implements Parcelable {
    public static final Parcelable.Creator<IZatUtcSpec> CREATOR = new Parcelable.Creator<IZatUtcSpec>() {
        /* class com.qti.debugreport.IZatUtcSpec.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatUtcSpec[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatUtcSpec(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5428O000000o = "IZatUtcSpec";
    private static final boolean O00000Oo = Log.isLoggable("IZatUtcSpec", 2);
    private long O00000o;
    private long O00000o0;

    public int describeContents() {
        return 0;
    }

    public IZatUtcSpec(Parcel parcel) {
        this.O00000o0 = parcel.readLong();
        this.O00000o = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.O00000o0);
        parcel.writeLong(this.O00000o);
    }
}
