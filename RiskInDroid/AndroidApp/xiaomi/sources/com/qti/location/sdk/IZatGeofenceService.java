package com.qti.location.sdk;

import android.content.ComponentName;
import java.util.Map;

public interface IZatGeofenceService {

    public interface O000000o {
        void O000000o(int i);

        void O000000o(int i, int i2);

        void O00000Oo(int i);
    }

    public interface O00000Oo {
        Object O000000o();

        void O000000o(O00000o o00000o) throws IZatIllegalArgumentException;
    }

    O00000Oo O000000o(Object obj, O00000o o00000o) throws IZatIllegalArgumentException;

    Map<O00000Oo, O00000o> O000000o() throws IZatIllegalArgumentException;

    void O000000o(ComponentName componentName) throws IZatIllegalArgumentException;

    void O000000o(O000000o o000000o) throws IZatIllegalArgumentException;

    void O000000o(O00000Oo o00000Oo) throws IZatIllegalArgumentException;

    public static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5440O000000o;
        public double O00000Oo;
        public double O00000o;
        public double O00000o0;
        IzatGeofenceTransitionTypes O00000oO;
        IzatGeofenceConfidence O00000oo;
        public O00000o0 O0000O0o;
        public int O0000OOo;

        public O00000o(double d, double d2, double d3) {
            this(Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3));
        }

        private O00000o(Double d, Double d2, Double d3) {
            this.O0000OOo = 0;
            if (d != null) {
                this.O00000Oo = d.doubleValue();
                this.O0000OOo |= 1;
            }
            if (d2 != null) {
                this.O00000o0 = d2.doubleValue();
                this.O0000OOo |= 2;
            }
            if (d3 != null) {
                this.O00000o = d3.doubleValue();
                this.O0000OOo |= 4;
            }
            this.f5440O000000o = 1000;
            this.O00000oO = IzatGeofenceTransitionTypes.UNKNOWN;
            this.O00000oo = IzatGeofenceConfidence.LOW;
        }

        public final double O000000o() {
            return this.O00000Oo;
        }

        public final double O00000Oo() {
            return this.O00000o0;
        }

        public final double O00000o0() {
            return this.O00000o;
        }

        public final void O000000o(IzatGeofenceTransitionTypes izatGeofenceTransitionTypes) {
            this.O00000oO = izatGeofenceTransitionTypes;
            this.O0000OOo |= 8;
        }

        public final IzatGeofenceTransitionTypes O00000o() {
            return this.O00000oO;
        }

        public final void O000000o(int i) {
            this.f5440O000000o = i;
            this.O0000OOo |= 64;
        }

        public final void O000000o(IzatGeofenceConfidence izatGeofenceConfidence) {
            this.O00000oo = izatGeofenceConfidence;
            this.O0000OOo |= 16;
        }

        public final void O000000o(O00000o0 o00000o0) {
            this.O0000O0o = o00000o0;
            this.O0000OOo |= 32;
        }

        public final String toString() {
            int i = this.f5440O000000o;
            double d = this.O00000Oo;
            double d2 = this.O00000o0;
            double d3 = this.O00000o;
            int value = this.O00000oO.getValue();
            int value2 = this.O00000oo.getValue();
            int i2 = this.O0000O0o.O00000Oo;
            int i3 = this.O0000O0o.f5441O000000o;
            int i4 = this.O0000OOo;
            return "in IzatGeofence: toString responsiveness is " + i + "; latitude is " + d + "; longitude is " + d2 + "; radius is " + d3 + "; transitionTypes is " + value + "; confidence is " + value2 + "; dwellTimeMask is " + i2 + "; dwellTime is " + i3 + "; mask is " + i4;
        }
    }

    public enum IzatGeofenceTransitionTypes {
        UNKNOWN(0),
        ENTERED_ONLY(1),
        EXITED_ONLY(2),
        ENTERED_AND_EXITED(3);
        
        private final int value;

        private IzatGeofenceTransitionTypes(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public enum IzatGeofenceConfidence {
        LOW(1),
        MEDIUM(2),
        HIGH(3);
        
        private final int value;

        private IzatGeofenceConfidence(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f5441O000000o;
        int O00000Oo;

        public O00000o0(int i, int i2) {
            this.f5441O000000o = i;
            this.O00000Oo = i2;
        }
    }
}
