package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import com.google.android.exoplayer2.C;
import java.io.Serializable;
import java.util.BitSet;

public class fh implements ja<fh, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6379O000000o = new esg("StatsEvent");
    private static final esa O00000Oo = new esa("", (byte) 3, 1);
    private static final esa O00000o = new esa("", (byte) 8, 3);
    private static final esa O00000o0 = new esa("", (byte) 8, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 11, 5);
    private static final esa O0000O0o = new esa("", (byte) 8, 6);
    private static final esa O0000OOo = new esa("", (byte) 11, 7);
    private static final esa O0000Oo = new esa("", (byte) 8, 9);
    private static final esa O0000Oo0 = new esa("", (byte) 11, 8);
    private static final esa O0000OoO = new esa("", (byte) 8, 10);

    /* renamed from: a  reason: collision with root package name */
    public byte f6380a;

    /* renamed from: a  reason: collision with other field name */
    public int f33a;

    /* renamed from: a  reason: collision with other field name */
    public String f34a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f35a = new BitSet(6);
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public String f36b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f37c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public String f38d;
    public int e;

    private boolean O000000o() {
        return this.f35a.get(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000Oo() {
        this.f35a.set(0, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000o() {
        this.f35a.set(1, true);
    }

    private boolean O00000o0() {
        return this.f35a.get(1);
    }

    private boolean O00000oO() {
        return this.f35a.get(2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000oo() {
        this.f35a.set(2, true);
    }

    private boolean O0000O0o() {
        return this.f34a != null;
    }

    private boolean O0000OOo() {
        return this.f36b != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000Oo() {
        this.f35a.set(3, true);
    }

    private boolean O0000Oo0() {
        return this.f35a.get(3);
    }

    private boolean O0000OoO() {
        return this.f37c != null;
    }

    private boolean O0000Ooo() {
        return this.f38d != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000o0() {
        this.f35a.set(4, true);
    }

    private boolean O0000o00() {
        return this.f35a.get(4);
    }

    private boolean O0000o0O() {
        return this.f35a.get(5);
    }

    private void O0000o0o() {
        if (this.f34a == null) {
            throw new jm("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    public final fh O000000o(byte b2) {
        this.f6380a = b2;
        O00000Oo();
        return this;
    }

    public final fh O000000o(int i) {
        this.f33a = i;
        O00000o();
        return this;
    }

    public final fh O00000Oo(int i) {
        this.b = i;
        O00000oo();
        return this;
    }

    public final void O00000Oo(esd esd) {
        O0000o0o();
        esd.O000000o(O00000Oo);
        esd.O000000o(this.f6380a);
        esd.O000000o(O00000o0);
        esd.O000000o(this.f33a);
        esd.O000000o(O00000o);
        esd.O000000o(this.b);
        if (this.f34a != null) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.f34a);
        }
        if (this.f36b != null && O0000OOo()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.f36b);
        }
        if (O0000Oo0()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.c);
        }
        if (this.f37c != null && O0000OoO()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.f37c);
        }
        if (this.f38d != null && O0000Ooo()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(this.f38d);
        }
        if (O0000o00()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.d);
        }
        if (O0000o0O()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.e);
        }
        esd.O000000o();
    }

    public final fh O00000o(int i) {
        this.d = i;
        O0000o0();
        return this;
    }

    public final fh O00000o0(int i) {
        this.c = i;
        O0000Oo();
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f6380a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f33a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f34a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f36b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.c);
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f37c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (O0000Ooo()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f38d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (O0000o00()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.d);
        }
        if (O0000o0O()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.e);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        fh fhVar;
        if (obj == null || !(obj instanceof fh) || (fhVar = (fh) obj) == null || this.f6380a != fhVar.f6380a || this.f33a != fhVar.f33a || this.b != fhVar.b) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = fhVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.f34a.equals(fhVar.f34a))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = fhVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.f36b.equals(fhVar.f36b))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = fhVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || this.c != fhVar.c)) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = fhVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || !this.f37c.equals(fhVar.f37c))) {
            return false;
        }
        boolean O0000Ooo = O0000Ooo();
        boolean O0000Ooo2 = fhVar.O0000Ooo();
        if ((O0000Ooo || O0000Ooo2) && (!O0000Ooo || !O0000Ooo2 || !this.f38d.equals(fhVar.f38d))) {
            return false;
        }
        boolean O0000o00 = O0000o00();
        boolean O0000o002 = fhVar.O0000o00();
        if ((O0000o00 || O0000o002) && (!O0000o00 || !O0000o002 || this.d != fhVar.d)) {
            return false;
        }
        boolean O0000o0O = O0000o0O();
        boolean O0000o0O2 = fhVar.O0000o0O();
        if (O0000o0O || O0000o0O2) {
            return O0000o0O && O0000o0O2 && this.e == fhVar.e;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo == 0) {
                break;
            }
            switch (O00000Oo2.O00000o0) {
                case 1:
                    if (O00000Oo2.O00000Oo == 3) {
                        this.f6380a = esd.O0000O0o();
                        O00000Oo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 2:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.f33a = esd.O0000Oo0();
                        O00000o();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 3:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.b = esd.O0000Oo0();
                        O00000oo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 4:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f34a = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 5:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f36b = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 6:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.c = esd.O0000Oo0();
                        O0000Oo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 7:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f37c = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f38d = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 9:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.d = esd.O0000Oo0();
                        O0000o0();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 10:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.e = esd.O0000Oo0();
                        this.f35a.set(5, true);
                        break;
                    }
                default:
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
            }
        }
        if (!O000000o()) {
            throw new jm("Required field 'chid' was not found in serialized data! Struct: " + toString());
        } else if (!O00000o0()) {
            throw new jm("Required field 'type' was not found in serialized data! Struct: " + toString());
        } else if (O00000oO()) {
            O0000o0o();
        } else {
            throw new jm("Required field 'value' was not found in serialized data! Struct: " + toString());
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        int O000000o3;
        int O000000o4;
        int O000000o5;
        int O000000o6;
        int O000000o7;
        int O000000o8;
        int O000000o9;
        int O000000o10;
        int O000000o11;
        fh fhVar = (fh) obj;
        if (!getClass().equals(fhVar.getClass())) {
            return getClass().getName().compareTo(fhVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(fhVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o11 = erw.O000000o(this.f6380a, fhVar.f6380a)) != 0) {
            return O000000o11;
        }
        int compareTo2 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(fhVar.O00000o0()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000o0() && (O000000o10 = erw.O000000o(this.f33a, fhVar.f33a)) != 0) {
            return O000000o10;
        }
        int compareTo3 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(fhVar.O00000oO()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000oO() && (O000000o9 = erw.O000000o(this.b, fhVar.b)) != 0) {
            return O000000o9;
        }
        int compareTo4 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(fhVar.O0000O0o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O0000O0o() && (O000000o8 = erw.O000000o(this.f34a, fhVar.f34a)) != 0) {
            return O000000o8;
        }
        int compareTo5 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(fhVar.O0000OOo()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O0000OOo() && (O000000o7 = erw.O000000o(this.f36b, fhVar.f36b)) != 0) {
            return O000000o7;
        }
        int compareTo6 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(fhVar.O0000Oo0()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O0000Oo0() && (O000000o6 = erw.O000000o(this.c, fhVar.c)) != 0) {
            return O000000o6;
        }
        int compareTo7 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(fhVar.O0000OoO()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000OoO() && (O000000o5 = erw.O000000o(this.f37c, fhVar.f37c)) != 0) {
            return O000000o5;
        }
        int compareTo8 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(fhVar.O0000Ooo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000Ooo() && (O000000o4 = erw.O000000o(this.f38d, fhVar.f38d)) != 0) {
            return O000000o4;
        }
        int compareTo9 = Boolean.valueOf(O0000o00()).compareTo(Boolean.valueOf(fhVar.O0000o00()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000o00() && (O000000o3 = erw.O000000o(this.d, fhVar.d)) != 0) {
            return O000000o3;
        }
        int compareTo10 = Boolean.valueOf(O0000o0O()).compareTo(Boolean.valueOf(fhVar.O0000o0O()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!O0000o0O() || (O000000o2 = erw.O000000o(this.e, fhVar.e)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
