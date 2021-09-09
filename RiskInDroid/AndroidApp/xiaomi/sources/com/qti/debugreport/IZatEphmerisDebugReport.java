package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class IZatEphmerisDebugReport implements Parcelable {
    public static final Parcelable.Creator<IZatEphmerisDebugReport> CREATOR = new Parcelable.Creator<IZatEphmerisDebugReport>() {
        /* class com.qti.debugreport.IZatEphmerisDebugReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatEphmerisDebugReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatEphmerisDebugReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5420O000000o = "IZatEphmeris";
    private static final boolean O00000Oo = Log.isLoggable("IZatEphmeris", 2);
    private int O00000o;
    private int O00000o0;
    private long O00000oO;
    private long O00000oo;
    private byte O0000O0o;
    private IZatUtcSpec O0000OOo;
    private IZatUtcSpec O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public IZatEphmerisDebugReport(Parcel parcel) {
        this.O0000OOo = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O0000Oo0 = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000o0 = parcel.readInt();
        this.O00000o = parcel.readInt();
        this.O00000oO = parcel.readLong();
        this.O00000oo = parcel.readLong();
        this.O0000O0o = parcel.readByte();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.O0000OOo, 0);
        parcel.writeParcelable(this.O0000Oo0, 0);
        parcel.writeInt(this.O00000o0);
        parcel.writeInt(this.O00000o);
        parcel.writeLong(this.O00000oO);
        parcel.writeLong(this.O00000oo);
        parcel.writeByte(this.O0000O0o);
    }
}
