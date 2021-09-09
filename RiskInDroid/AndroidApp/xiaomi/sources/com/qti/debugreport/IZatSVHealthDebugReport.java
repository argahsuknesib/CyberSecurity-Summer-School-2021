package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class IZatSVHealthDebugReport implements Parcelable {
    public static final Parcelable.Creator<IZatSVHealthDebugReport> CREATOR = new Parcelable.Creator<IZatSVHealthDebugReport>() {
        /* class com.qti.debugreport.IZatSVHealthDebugReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatSVHealthDebugReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatSVHealthDebugReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5427O000000o = "IZatSVHealthReport";
    private static final boolean O00000Oo = Log.isLoggable("IZatSVHealthReport", 2);
    private List<IzatSVHealthState> O00000o = new ArrayList();
    private List<IzatSVHealthState> O00000o0 = new ArrayList();
    private List<IzatSVHealthState> O00000oO = new ArrayList();
    private List<IzatSVHealthState> O00000oo = new ArrayList();
    private List<IzatSVHealthState> O0000O0o = new ArrayList();
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private long O0000o;
    private long O0000o0;
    private int O0000o00;
    private long O0000o0O;
    private long O0000o0o;
    private long O0000oO;
    private long O0000oO0;
    private byte O0000oOO;
    private byte O0000oOo;
    private IZatUtcSpec O0000oo;
    private byte O0000oo0;
    private IZatUtcSpec O0000ooO;

    public int describeContents() {
        return 0;
    }

    public enum IzatSVHealthState {
        SV_HEALTH_UNKNOWN(0),
        SV_HEALTH_GOOD(1),
        SV_HEALTH_BAD(2);
        
        private final int mValue;

        private IzatSVHealthState(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }
    }

    public IZatSVHealthDebugReport(Parcel parcel) {
        this.O0000oo = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O0000ooO = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O0000OOo = parcel.readInt();
        this.O0000Oo0 = parcel.readInt();
        this.O0000Oo = parcel.readInt();
        this.O0000OoO = parcel.readInt();
        this.O0000Ooo = parcel.readInt();
        this.O0000o00 = parcel.readInt();
        this.O0000o0 = parcel.readLong();
        this.O0000o0O = parcel.readLong();
        this.O0000o0o = parcel.readLong();
        this.O0000o = parcel.readLong();
        this.O0000oO0 = parcel.readLong();
        this.O0000oO = parcel.readLong();
        this.O0000oOO = parcel.readByte();
        this.O0000oOo = parcel.readByte();
        this.O0000oo0 = parcel.readByte();
        O000000o(this.O00000o0, this.O0000OOo, this.O0000Oo0);
        O000000o(this.O00000o, this.O0000OoO, this.O0000Ooo);
        O000000o(this.O00000oO, this.O0000o0, this.O0000o0O);
        O000000o(this.O00000oo, this.O0000o, this.O0000oO0);
        O000000o(this.O0000O0o, this.O0000oOO, this.O0000oOo);
    }

    private static void O000000o(List<IzatSVHealthState> list, int i, int i2) {
        for (int i3 = 0; i3 < 32; i3++) {
            int i4 = 1 << i3;
            if ((i4 & i) != 0) {
                list.add(IzatSVHealthState.SV_HEALTH_GOOD);
            } else if ((i4 & i2) != 0) {
                list.add(IzatSVHealthState.SV_HEALTH_BAD);
            } else {
                list.add(IzatSVHealthState.SV_HEALTH_UNKNOWN);
            }
        }
    }

    private static void O000000o(List<IzatSVHealthState> list, long j, long j2) {
        for (long j3 = 0; j3 < 64; j3++) {
            long j4 = 1 << ((int) j3);
            if ((j4 & j) != 0) {
                list.add(IzatSVHealthState.SV_HEALTH_GOOD);
            } else if ((j4 & j2) != 0) {
                list.add(IzatSVHealthState.SV_HEALTH_BAD);
            } else {
                list.add(IzatSVHealthState.SV_HEALTH_UNKNOWN);
            }
        }
    }

    private static void O000000o(List<IzatSVHealthState> list, byte b, byte b2) {
        for (byte b3 = 0; b3 < 8; b3 = (byte) (b3 + 1)) {
            int i = 1 << b3;
            if ((i & b) != 0) {
                list.add(IzatSVHealthState.SV_HEALTH_GOOD);
            } else if ((i & b2) != 0) {
                list.add(IzatSVHealthState.SV_HEALTH_BAD);
            } else {
                list.add(IzatSVHealthState.SV_HEALTH_UNKNOWN);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.O0000oo, 0);
        parcel.writeParcelable(this.O0000ooO, 0);
        parcel.writeInt(this.O0000OOo);
        parcel.writeInt(this.O0000Oo0);
        parcel.writeInt(this.O0000Oo);
        parcel.writeInt(this.O0000OoO);
        parcel.writeInt(this.O0000Ooo);
        parcel.writeInt(this.O0000o00);
        parcel.writeLong(this.O0000o0);
        parcel.writeLong(this.O0000o0O);
        parcel.writeLong(this.O0000o0o);
        parcel.writeLong(this.O0000o);
        parcel.writeLong(this.O0000oO0);
        parcel.writeLong(this.O0000oO);
        parcel.writeByte(this.O0000oOO);
        parcel.writeByte(this.O0000oOo);
        parcel.writeByte(this.O0000oo0);
    }
}
