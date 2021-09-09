package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class IZatLocationReport implements Parcelable {
    public static final Parcelable.Creator<IZatLocationReport> CREATOR = new Parcelable.Creator<IZatLocationReport>() {
        /* class com.qti.debugreport.IZatLocationReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatLocationReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatLocationReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5424O000000o = "IZatLocationReport";
    private static final boolean O00000Oo = Log.isLoggable("IZatLocationReport", 2);
    private double O00000o;
    private int O00000o0;
    private double O00000oO;
    private float O00000oo;
    private double O0000O0o;
    private float O0000OOo;
    private IZatUtcSpec O0000Oo;
    private IzatLocationSource O0000Oo0;
    private IZatUtcSpec O0000OoO;

    public int describeContents() {
        return 0;
    }

    public enum IzatLocationSource {
        POSITION_SOURCE_UNKNOWN(0),
        POSITION_SOURCE_CPI(1),
        POSITION_SOURCE_REFERENCE_LOCATION(2),
        POSITION_SOURCE_TLE(3);
        
        private final int mValue;

        private IzatLocationSource(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public IZatLocationReport(Parcel parcel) {
        this.O0000Oo = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O0000OoO = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000o0 = parcel.readInt();
        if ((this.O00000o0 & 1) != 0) {
            this.O00000o = parcel.readDouble();
            this.O00000oO = parcel.readDouble();
            this.O00000oo = parcel.readFloat();
        }
        if ((this.O00000o0 & 2) != 0) {
            this.O0000O0o = parcel.readDouble();
            this.O0000OOo = parcel.readFloat();
        }
        if ((this.O00000o0 & 4) != 0) {
            try {
                this.O0000Oo0 = IzatLocationSource.values()[parcel.readInt()];
            } catch (ArrayIndexOutOfBoundsException unused) {
                this.O0000Oo0 = IzatLocationSource.POSITION_SOURCE_UNKNOWN;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.O0000Oo, 0);
        parcel.writeParcelable(this.O0000OoO, 0);
        parcel.writeInt(this.O00000o0);
        if ((this.O00000o0 & 1) != 0) {
            parcel.writeDouble(this.O00000o);
            parcel.writeDouble(this.O00000oO);
            parcel.writeFloat(this.O00000oo);
        }
        if ((this.O00000o0 & 2) != 0) {
            parcel.writeDouble(this.O0000O0o);
            parcel.writeFloat(this.O0000OOo);
        }
        if ((this.O00000o0 & 4) != 0) {
            parcel.writeInt(this.O0000Oo0.getValue());
        }
    }
}
