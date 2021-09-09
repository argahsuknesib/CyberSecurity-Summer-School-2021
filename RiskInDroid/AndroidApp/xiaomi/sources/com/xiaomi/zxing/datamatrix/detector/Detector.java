package com.xiaomi.zxing.datamatrix.detector;

import _m_j.idg;
import _m_j.idm;
import _m_j.ids;
import _m_j.idw;
import _m_j.idx;
import com.xiaomi.zxing.NotFoundException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

public final class Detector {

    /* renamed from: O000000o  reason: collision with root package name */
    public final idm f12114O000000o;
    public final idx O00000Oo;

    public Detector(idm idm) throws NotFoundException {
        this.f12114O000000o = idm;
        this.O00000Oo = new idx(idm);
    }

    public static int O000000o(idg idg, idg idg2) {
        return idw.O000000o(idg.O000000o(idg, idg2));
    }

    public static void O000000o(Map<idg, Integer> map, idg idg) {
        Integer num = map.get(idg);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(idg, Integer.valueOf(i));
    }

    public static idm O000000o(idm idm, idg idg, idg idg2, idg idg3, idg idg4, int i, int i2) throws NotFoundException {
        idg idg5 = idg;
        idg idg6 = idg2;
        idg idg7 = idg3;
        idg idg8 = idg4;
        float f = ((float) i) - 0.5f;
        float f2 = ((float) i2) - 0.5f;
        return ids.O000000o().O000000o(idm, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, idg5.f1209O000000o, idg5.O00000Oo, idg8.f1209O000000o, idg8.O00000Oo, idg7.f1209O000000o, idg7.O00000Oo, idg6.f1209O000000o, idg6.O00000Oo);
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final idg f12115O000000o;
        public final idg O00000Oo;
        public final int O00000o0;

        /* synthetic */ O000000o(idg idg, idg idg2, int i, byte b) {
            this(idg, idg2, i);
        }

        private O000000o(idg idg, idg idg2, int i) {
            this.f12115O000000o = idg;
            this.O00000Oo = idg2;
            this.O00000o0 = i;
        }

        public final String toString() {
            return this.f12115O000000o + "/" + this.O00000Oo + '/' + this.O00000o0;
        }
    }

    public static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<O000000o> {
        private ResultPointsAndTransitionsComparator() {
        }

        public /* synthetic */ ResultPointsAndTransitionsComparator(byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((O000000o) obj).O00000o0 - ((O000000o) obj2).O00000o0;
        }
    }

    public final boolean O000000o(idg idg) {
        return idg.f1209O000000o >= 0.0f && idg.f1209O000000o < ((float) this.f12114O000000o.f1214O000000o) && idg.O00000Oo > 0.0f && idg.O00000Oo < ((float) this.f12114O000000o.O00000Oo);
    }

    public final O000000o O00000Oo(idg idg, idg idg2) {
        int i;
        int i2;
        Detector detector = this;
        idg idg3 = idg;
        idg idg4 = idg2;
        int i3 = (int) idg3.f1209O000000o;
        int i4 = (int) idg3.O00000Oo;
        int i5 = (int) idg4.f1209O000000o;
        int i6 = (int) idg4.O00000Oo;
        boolean z = Math.abs(i6 - i4) > Math.abs(i5 - i3);
        if (z) {
            int i7 = i4;
            i4 = i3;
            i3 = i7;
            int i8 = i6;
            i6 = i5;
            i5 = i8;
        }
        int abs = Math.abs(i5 - i3);
        int abs2 = Math.abs(i6 - i4);
        int i9 = (-abs) / 2;
        int i10 = -1;
        int i11 = i4 < i6 ? 1 : -1;
        if (i3 < i5) {
            i10 = 1;
        }
        boolean O000000o2 = detector.f12114O000000o.O000000o(z ? i4 : i3, z ? i3 : i4);
        int i12 = 0;
        while (i3 != i5) {
            idm idm = detector.f12114O000000o;
            int i13 = z ? i4 : i3;
            if (z) {
                i = i5;
                i2 = i3;
            } else {
                i = i5;
                i2 = i4;
            }
            boolean O000000o3 = idm.O000000o(i13, i2);
            if (O000000o3 != O000000o2) {
                i12++;
                O000000o2 = O000000o3;
            }
            i9 += abs2;
            if (i9 > 0) {
                if (i4 == i6) {
                    break;
                }
                i4 += i11;
                i9 -= abs;
            }
            i3 += i10;
            detector = this;
            i5 = i;
        }
        return new O000000o(idg3, idg4, i12, (byte) 0);
    }
}
