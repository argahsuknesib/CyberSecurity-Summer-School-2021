package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;

public class IZatXoStateDebugReport implements Parcelable {
    public static final Parcelable.Creator<IZatXoStateDebugReport> CREATOR = new Parcelable.Creator<IZatXoStateDebugReport>() {
        /* class com.qti.debugreport.IZatXoStateDebugReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatXoStateDebugReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatXoStateDebugReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private IZatUtcSpec f5435O000000o;
    private IZatUtcSpec O00000Oo;
    private IZatXoState O00000o0;

    public int describeContents() {
        return 0;
    }

    public IZatXoStateDebugReport(Parcel parcel) {
        this.f5435O000000o = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000Oo = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O00000o0 = IZatXoState.values()[parcel.readInt()];
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5435O000000o, 0);
        parcel.writeParcelable(this.O00000Oo, 0);
        parcel.writeInt(this.O00000o0.getValue());
    }

    public enum IZatXoState {
        FAILED(0),
        NOT_CAL(1),
        FAC1(2),
        DEFAULT(3),
        WIDE_BINS(4),
        COARSE(5),
        IFC(6),
        FINE(7),
        FT1(8),
        OLD_RGS(9),
        INTERP(10),
        FT2(11),
        EXACT(12),
        RGS(13),
        RGS_RECENT(14),
        VCO_LAST(15);
        
        private final int mValue;

        private IZatXoState(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }
    }
}
