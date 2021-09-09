package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;

public class IZatErrorRecoveryReport implements Parcelable {
    public static final Parcelable.Creator<IZatErrorRecoveryReport> CREATOR = new Parcelable.Creator<IZatErrorRecoveryReport>() {
        /* class com.qti.debugreport.IZatErrorRecoveryReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatErrorRecoveryReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatErrorRecoveryReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private IZatUtcSpec f5421O000000o;
    private IZatUtcSpec O00000Oo;

    public int describeContents() {
        return 0;
    }

    public IZatErrorRecoveryReport(Parcel parcel) {
        this.f5421O000000o = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000Oo = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5421O000000o, 0);
        parcel.writeParcelable(this.O00000Oo, 0);
    }
}
