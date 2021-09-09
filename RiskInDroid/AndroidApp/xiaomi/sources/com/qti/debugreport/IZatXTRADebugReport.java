package com.qti.debugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class IZatXTRADebugReport implements Parcelable {
    public static final Parcelable.Creator<IZatXTRADebugReport> CREATOR = new Parcelable.Creator<IZatXTRADebugReport>() {
        /* class com.qti.debugreport.IZatXTRADebugReport.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IZatXTRADebugReport[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IZatXTRADebugReport(parcel);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f5429O000000o = "IZatXTRAReport";
    private static final boolean O00000Oo = Log.isLoggable("IZatXTRAReport", 2);
    private O00000o0 O00000o;
    private O00000o O00000o0;
    private O000000o O00000oO;
    private O00000Oo O00000oo;
    private O0000O0o O0000O0o;
    private byte O0000OOo;
    private IZatUtcSpec O0000Oo;
    private IZatUtcSpec O0000Oo0;

    public int describeContents() {
        return 0;
    }

    public class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5432O000000o;
        public int O00000Oo;

        public O00000o() {
        }
    }

    public class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5433O000000o;
        public int O00000Oo;

        public O00000o0() {
        }
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5430O000000o;
        public long O00000Oo;

        public O000000o() {
        }
    }

    public class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5431O000000o;
        public long O00000Oo;

        public O00000Oo() {
        }
    }

    public class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5434O000000o;
        public byte O00000Oo;

        public O0000O0o() {
        }
    }

    public IZatXTRADebugReport(Parcel parcel) {
        this.O0000Oo0 = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O0000Oo = (IZatUtcSpec) parcel.readParcelable(IZatUtcSpec.class.getClassLoader());
        this.O0000OOo = parcel.readByte();
        if ((this.O0000OOo & 1) != 0) {
            this.O00000o0 = new O00000o();
            this.O00000o0.O00000Oo = parcel.readInt();
            this.O00000o0.f5432O000000o = parcel.readInt();
        }
        if ((this.O0000OOo & 2) != 0) {
            this.O00000o = new O00000o0();
            this.O00000o.O00000Oo = parcel.readInt();
            this.O00000o.f5433O000000o = parcel.readInt();
        }
        if ((this.O0000OOo & 4) != 0) {
            this.O00000oO = new O000000o();
            this.O00000oO.O00000Oo = parcel.readLong();
            this.O00000oO.f5430O000000o = parcel.readInt();
        }
        if ((this.O0000OOo & 8) != 0) {
            this.O00000oo = new O00000Oo();
            this.O00000oo.O00000Oo = parcel.readLong();
            this.O00000oo.f5431O000000o = parcel.readInt();
        }
        if ((this.O0000OOo & 16) != 0) {
            this.O0000O0o = new O0000O0o();
            this.O0000O0o.O00000Oo = parcel.readByte();
            this.O0000O0o.f5434O000000o = parcel.readInt();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.O0000Oo0, 0);
        parcel.writeParcelable(this.O0000Oo, 0);
        parcel.writeByte(this.O0000OOo);
        if ((this.O0000OOo & 1) != 0) {
            parcel.writeInt(this.O00000o0.O00000Oo);
            parcel.writeInt(this.O00000o0.f5432O000000o);
        }
        if ((this.O0000OOo & 2) != 0) {
            parcel.writeInt(this.O00000o.O00000Oo);
            parcel.writeInt(this.O00000o.f5433O000000o);
        }
        if ((this.O0000OOo & 4) != 0) {
            parcel.writeLong(this.O00000oO.O00000Oo);
            parcel.writeInt(this.O00000oO.f5430O000000o);
        }
        if ((this.O0000OOo & 8) != 0) {
            parcel.writeLong(this.O00000oo.O00000Oo);
            parcel.writeInt(this.O00000oo.f5431O000000o);
        }
        if ((this.O0000OOo & 16) != 0) {
            parcel.writeByte(this.O0000O0o.O00000Oo);
            parcel.writeInt(this.O0000O0o.f5434O000000o);
        }
    }
}
