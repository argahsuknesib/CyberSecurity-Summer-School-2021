package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class IZatPDRDebugReport implements Parcelable {
    public static final Parcelable.Creator<IZatPDRDebugReport> CREATOR = new Parcelable.Creator<IZatPDRDebugReport>() {
        /* class com.qti.debugreport.IZatPDRDebugReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatPDRDebugReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatPDRDebugReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5425O000000o = "IZatPDR";
    private static final boolean O00000Oo = Log.isLoggable("IZatPDR", 2);
    private IZatUtcSpec O00000o;
    private int O00000o0;
    private IZatUtcSpec O00000oO;

    public int describeContents() {
        return 0;
    }

    public IZatPDRDebugReport(Parcel parcel) {
        this.O00000o = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000oO = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000o0 = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.O00000o, 0);
        parcel.writeParcelable(this.O00000oO, 0);
        parcel.writeInt(this.O00000o0);
    }
}
