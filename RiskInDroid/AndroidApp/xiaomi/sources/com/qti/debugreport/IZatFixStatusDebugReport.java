package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class IZatFixStatusDebugReport implements Parcelable {
    public static final Parcelable.Creator<IZatFixStatusDebugReport> CREATOR = new Parcelable.Creator<IZatFixStatusDebugReport>() {
        /* class com.qti.debugreport.IZatFixStatusDebugReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatFixStatusDebugReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatFixStatusDebugReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5422O000000o = "IZatFixStatus";
    private static final boolean O00000Oo = Log.isLoggable("IZatFixStatus", 2);
    private IzatFixStatus O00000o;
    private int O00000o0;
    private long O00000oO;
    private IZatUtcSpec O00000oo;
    private IZatUtcSpec O0000O0o;

    public int describeContents() {
        return 0;
    }

    public enum IzatFixStatus {
        FINAL_FIX_SUCCESSFUL(0),
        TOO_FEW_SV(1),
        HEPE_CHECK_FAIL(2),
        VERY_LOW_RELAIBILITY_FIX(3);
        
        private final int mFixStatus;

        private IzatFixStatus(int i) {
            this.mFixStatus = i;
        }

        public final int getValue() {
            return this.mFixStatus;
        }
    }

    public IZatFixStatusDebugReport(Parcel parcel) {
        this.O00000oo = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O0000O0o = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000o0 = parcel.readInt();
        int i = this.O00000o0;
        if ((i & 1) != 0) {
            this.O00000o = IzatFixStatus.values()[0];
        } else if ((i & 2) != 0) {
            this.O00000o = IzatFixStatus.values()[1];
        } else if ((i & 4) != 0) {
            this.O00000o = IzatFixStatus.values()[2];
        } else if ((i & 8) != 0) {
            this.O00000o = IzatFixStatus.values()[3];
        }
        this.O00000oO = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.O00000oo, 0);
        parcel.writeParcelable(this.O0000O0o, 0);
        parcel.writeInt(this.O00000o0);
        parcel.writeLong(this.O00000oO);
    }
}
