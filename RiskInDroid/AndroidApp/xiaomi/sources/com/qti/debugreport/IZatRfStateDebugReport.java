package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class IZatRfStateDebugReport implements Parcelable {
    public static final Parcelable.Creator<IZatRfStateDebugReport> CREATOR = new Parcelable.Creator<IZatRfStateDebugReport>() {
        /* class com.qti.debugreport.IZatRfStateDebugReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatRfStateDebugReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatRfStateDebugReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5426O000000o = "IZatRfStateReport";
    private static final boolean O00000Oo = Log.isLoggable("IZatRfStateReport", 2);
    private IZatUtcSpec O00000o;
    private IZatUtcSpec O00000o0;
    private int O00000oO;
    private long O00000oo;
    private long O0000O0o;
    private long O0000OOo;
    private long O0000Oo;
    private long O0000Oo0;
    private long O0000OoO;
    private long O0000Ooo;
    private long O0000o;
    private long O0000o0;
    private long O0000o00;
    private long O0000o0O;
    private long O0000o0o;
    private long O0000oO;
    private long O0000oO0;

    public int describeContents() {
        return 0;
    }

    public IZatRfStateDebugReport(Parcel parcel) {
        this.O00000o0 = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000o = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readLong();
        this.O0000O0o = parcel.readLong();
        this.O0000OOo = parcel.readLong();
        this.O0000Oo0 = parcel.readLong();
        this.O0000Oo = parcel.readLong();
        this.O0000OoO = parcel.readLong();
        this.O0000Ooo = parcel.readLong();
        this.O0000o00 = parcel.readLong();
        this.O0000o0 = parcel.readLong();
        this.O0000o0O = parcel.readLong();
        this.O0000o0o = parcel.readLong();
        this.O0000o = parcel.readLong();
        this.O0000oO0 = parcel.readLong();
        this.O0000oO = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.O00000o0, 0);
        parcel.writeParcelable(this.O00000o, 0);
        parcel.writeInt(this.O00000oO);
        parcel.writeLong(this.O00000oo);
        parcel.writeLong(this.O0000O0o);
        parcel.writeLong(this.O0000OOo);
        parcel.writeLong(this.O0000Oo0);
        parcel.writeLong(this.O0000Oo);
        parcel.writeLong(this.O0000OoO);
        parcel.writeLong(this.O0000Ooo);
        parcel.writeLong(this.O0000o00);
        parcel.writeLong(this.O0000o0);
        parcel.writeLong(this.O0000o0O);
        parcel.writeLong(this.O0000o0o);
        parcel.writeLong(this.O0000o);
        parcel.writeLong(this.O0000oO0);
        parcel.writeLong(this.O0000oO);
    }
}
