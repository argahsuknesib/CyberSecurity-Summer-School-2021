package com.qti.location.sdk;

import android.location.Location;
import com.qti.location.sdk.IZatDBCommon;

public abstract class IZatWWANDBReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    protected O00000o0 f5449O000000o;

    public interface O00000o0 {
    }

    @Deprecated
    public static class O000000o extends IZatDBCommon.O00000Oo {
        @Deprecated
        public final int O0000OOo;
        @Deprecated
        public final int O0000Oo;
        @Deprecated
        public final int O0000Oo0;
        @Deprecated
        public final int O0000OoO;
        @Deprecated
        public IZatDBCommon.IZatCellTypes O0000Ooo;

        public O000000o(IZatDBCommon.O00000Oo o00000Oo) {
            super(o00000Oo.f5439O000000o, o00000Oo.O00000Oo, o00000Oo.O00000o0, o00000Oo.O00000o, o00000Oo.O00000oO);
            this.O0000OOo = o00000Oo.f5439O000000o;
            this.O0000Oo0 = o00000Oo.O00000Oo;
            this.O0000Oo = o00000Oo.O00000o0;
            this.O0000OoO = o00000Oo.O00000o;
            this.O0000Ooo = o00000Oo.O00000oO;
        }
    }

    @Deprecated
    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public O000000o f5451O000000o;

        public O00000Oo(IZatDBCommon.O00000Oo o00000Oo) {
            this.f5451O000000o = new O000000o(o00000Oo);
        }
    }

    public static abstract class IZatBSLocationDataBase {

        /* renamed from: O000000o  reason: collision with root package name */
        protected IZatDBCommon.O00000Oo f5450O000000o;
        protected Location O00000Oo;
        protected IZatReliablityTypes O00000o;
        protected IZatReliablityTypes O00000o0;
        protected int O00000oO = 0;

        public enum IZatReliablityTypes {
            VERY_LOW,
            LOW,
            MEDIUM,
            HIGH,
            VERY_HIGH
        }

        public IZatBSLocationDataBase(IZatDBCommon.O00000Oo o00000Oo, Location location, IZatReliablityTypes iZatReliablityTypes, IZatReliablityTypes iZatReliablityTypes2) {
            this.f5450O000000o = o00000Oo;
            this.O00000Oo = location;
            this.O00000o0 = iZatReliablityTypes;
            this.O00000o = iZatReliablityTypes2;
            this.O00000oO |= 1;
            this.O00000oO |= 2;
            this.O00000oO |= 4;
            this.O00000oO |= 8;
        }

        public final Location O00000Oo() throws IZatStaleDataException {
            if ((this.O00000oO & 1) != 0) {
                return this.O00000Oo;
            }
            throw new IZatStaleDataException("Location information is not valid");
        }

        public final IZatDBCommon.O00000Oo O00000o0() throws IZatStaleDataException {
            if ((this.O00000oO & 2) != 0) {
                return this.f5450O000000o;
            }
            throw new IZatStaleDataException("Cell info information is not valid");
        }
    }
}
