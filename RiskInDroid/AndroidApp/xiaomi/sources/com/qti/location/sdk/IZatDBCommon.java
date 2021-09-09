package com.qti.location.sdk;

import java.util.HashMap;
import java.util.Map;

public abstract class IZatDBCommon {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Integer f5437O000000o = 99;
    public static final Integer O00000Oo = 68;
    public static final Integer O00000o0 = 99;

    public enum IZatCellTypes {
        GSM,
        WCDMA,
        CDMA,
        LTE
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final int f5439O000000o;
        protected final int O00000Oo;
        protected final int O00000o;
        protected final int O00000o0;
        protected IZatCellTypes O00000oO;
        protected int O00000oo;
        protected int O0000O0o;

        public O00000Oo(int i, int i2, int i3, int i4, IZatCellTypes iZatCellTypes) {
            this.f5439O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
            this.O00000o = i4;
            this.O00000oO = iZatCellTypes;
            this.O0000O0o = 0;
        }

        public O00000Oo(int i, int i2, int i3, int i4, Integer num) {
            this(i, i2, i3, i4, IZatCellTypes.values()[num.intValue()]);
        }

        public final int O000000o() {
            if ((this.O0000O0o & 1) != 0) {
                return this.O00000oo;
            }
            throw new IZatStaleDataException("Local timestamp is not valid");
        }

        public final void O000000o(int i) {
            this.O00000oo = i;
            this.O0000O0o |= 1;
        }

        public final int O00000Oo() {
            return this.f5439O000000o;
        }

        public final int O00000o0() {
            return this.O00000Oo;
        }

        public final int O00000o() {
            return this.O00000o0;
        }

        public final int O00000oO() {
            return this.O00000o;
        }

        public final IZatCellTypes O00000oo() {
            return this.O00000oO;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public byte[] f5438O000000o = new byte[0];

        public O000000o(byte[] bArr, short s) {
            if (s > 0) {
                this.f5438O000000o = (byte[]) bArr.clone();
            }
        }
    }

    public enum IZatApBsListStatus {
        STD_CONT(0),
        STD_FINAL(1),
        SCAN_FINAL(2);
        
        private static final Map<Integer, IZatApBsListStatus> typesByValue = new HashMap();
        private final int cValue;

        static {
            for (IZatApBsListStatus iZatApBsListStatus : values()) {
                typesByValue.put(Integer.valueOf(iZatApBsListStatus.cValue), iZatApBsListStatus);
            }
        }

        private IZatApBsListStatus(int i) {
            this.cValue = i;
        }

        protected static IZatApBsListStatus fromInt(int i) {
            return typesByValue.get(Integer.valueOf(i));
        }
    }
}
