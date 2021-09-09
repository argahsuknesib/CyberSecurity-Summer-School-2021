package com.qti.location.sdk;

import com.qti.location.sdk.IZatDBCommon;
import java.util.HashMap;
import java.util.Map;

public abstract class IZatWiFiDBReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    protected O00000Oo f5452O000000o;

    public interface O00000Oo {
    }

    public static class IZatAPInfo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5453O000000o;
        public O000000o O00000Oo;
        protected IZatFdalStatus O00000o = IZatFdalStatus.NA;
        protected int O00000o0;

        public enum IZatFdalStatus {
            NOT_IN_FDAL(0),
            IN_FDAL(1),
            BLACKLISTED(2),
            NA(3);
            
            private static final Map<Integer, IZatFdalStatus> typesByValue = new HashMap();
            private final int cValue;

            static {
                for (IZatFdalStatus iZatFdalStatus : values()) {
                    typesByValue.put(Integer.valueOf(iZatFdalStatus.cValue), iZatFdalStatus);
                }
            }

            private IZatFdalStatus(int i) {
                this.cValue = i;
            }

            protected static IZatFdalStatus fromInt(int i) {
                return typesByValue.get(Integer.valueOf(i));
            }
        }

        public IZatAPInfo(String str, int i, O000000o o000000o) {
            this.f5453O000000o = str;
            this.O00000o0 = i;
            this.O00000Oo = o000000o;
        }

        /* access modifiers changed from: protected */
        public final void O000000o(int i) {
            this.O00000o = IZatFdalStatus.fromInt(i);
        }

        public final int O000000o() {
            return this.O00000o0;
        }

        public final boolean O00000Oo() {
            O000000o o000000o = this.O00000Oo;
            if (o000000o == null) {
                return false;
            }
            return o000000o.O000000o();
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public IZatDBCommon.O00000Oo f5454O000000o;
        IZatDBCommon.O000000o O00000Oo;

        public O000000o(IZatDBCommon.O00000Oo o00000Oo, IZatDBCommon.O000000o o000000o) {
            this.f5454O000000o = o00000Oo;
            this.O00000Oo = o000000o;
        }

        public final boolean O000000o() {
            return (this.O00000Oo == null && this.f5454O000000o == null) ? false : true;
        }
    }
}
