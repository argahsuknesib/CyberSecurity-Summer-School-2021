package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class IZatGpsTimeDebugReport implements Parcelable {
    public static final Parcelable.Creator<IZatGpsTimeDebugReport> CREATOR = new Parcelable.Creator<IZatGpsTimeDebugReport>() {
        /* class com.qti.debugreport.IZatGpsTimeDebugReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatGpsTimeDebugReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatGpsTimeDebugReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5423O000000o = "IZatGpsTimeReport";
    private static final boolean O00000Oo = Log.isLoggable("IZatGpsTimeReport", 2);
    private IZatUtcSpec O00000o;
    private IZatUtcSpec O00000o0;
    private int O00000oO;
    private long O00000oo;
    private boolean O0000O0o;
    private IZatTimeSource O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;

    public int describeContents() {
        return 0;
    }

    public enum IZatTimeSource {
        TIME_SOURCE_ESTIMATE_INVALID(0),
        TIME_SOURCE_ESTIMATE_NETWORK_TIME_TRANSFER(1),
        TIME_SOURCE_ESTIMATE_NETWORK_TIME_TAGGING(2),
        TIME_SOURCE_ESTIMATE_EXTERNAL_INPUT(3),
        TIME_SOURCE_ESTIMATE_TOW_DECODE(4),
        TIME_SOURCE_ESTIMATE_TOW_CONFIRMED(5),
        TIME_SOURCE_ESTIMATE_TOW_AND_WEEK_CONFIRMED(6),
        TIME_SOURCE_ESTIMATE_TIME_ALIGNMENT(7),
        TIME_SOURCE_ESTIMATE_NAV_SOLUTION(8),
        TIME_SOURCE_ESTIMATE_SOLVE_FOR_TIME(9),
        TIME_SOURCE_ESTIMATE_GLO_TOD_DECODE(10),
        TIME_SOURCE_ESTIMATE_TIME_CONVERSION(11),
        TIME_SOURCE_ESTIMATE_SLEEP_CLOCK(12),
        TIME_SOURCE_ESTIMATE_SLEEP_CLOCK_TIME_TRANSFER(13),
        TIME_SOURCE_ESTIMATE_UNKNOWN(14),
        TIME_SOURCE_ESTIMATE_WCDMA_SLEEP_TIME_TAGGING(15),
        TIME_SOURCE_ESTIMATE_GSM_SLEEP_TIME_TAGGING(16),
        TIME_SOURCE_ESTIMATE_GAL_TOW_DECODE(17),
        TIME_SOURCE_ESTIMATE_BDS_SOW_DECODE(18),
        TIME_SOURCE_ESTIMATE_QZSS_TOW_DECODE(19);
        
        private final int mValue;

        private IZatTimeSource(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public IZatGpsTimeDebugReport(Parcel parcel) {
        this.O00000o0 = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000o = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000oO = parcel.readInt();
        this.O00000oo = parcel.readLong();
        this.O0000O0o = parcel.readInt() != 1 ? false : true;
        this.O0000OOo = IZatTimeSource.values()[parcel.readInt()];
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readInt();
        this.O0000OoO = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.O00000o0, 0);
        parcel.writeParcelable(this.O00000o, 0);
        parcel.writeInt(this.O00000oO);
        parcel.writeLong(this.O00000oo);
        parcel.writeInt(this.O0000O0o ? 1 : 0);
        parcel.writeInt(this.O0000OOo.getValue());
        parcel.writeInt(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo);
        parcel.writeInt(this.O0000OoO);
    }
}
