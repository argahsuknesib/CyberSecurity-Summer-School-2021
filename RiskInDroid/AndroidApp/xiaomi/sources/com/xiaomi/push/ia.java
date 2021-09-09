package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import java.io.Serializable;
import java.util.BitSet;

public class ia implements ja<ia, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6404O000000o = new esg("OnlineConfigItem");
    private static final esa O00000Oo = new esa("", (byte) 8, 1);
    private static final esa O00000o = new esa("", (byte) 2, 3);
    private static final esa O00000o0 = new esa("", (byte) 8, 2);
    private static final esa O00000oO = new esa("", (byte) 8, 4);
    private static final esa O00000oo = new esa("", (byte) 10, 5);
    private static final esa O0000O0o = new esa("", (byte) 11, 6);
    private static final esa O0000OOo = new esa("", (byte) 2, 7);

    /* renamed from: a  reason: collision with root package name */
    public int f6405a;

    /* renamed from: a  reason: collision with other field name */
    public long f71a;

    /* renamed from: a  reason: collision with other field name */
    public String f72a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f73a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f74a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f75b;
    public int c;

    private boolean O000000o() {
        return this.f73a.get(0);
    }

    private boolean O00000Oo() {
        return this.f73a.get(1);
    }

    private boolean O00000o() {
        return this.f73a.get(3);
    }

    private boolean O00000o0() {
        return this.f73a.get(2);
    }

    private boolean O00000oO() {
        return this.f73a.get(4);
    }

    private boolean O00000oo() {
        return this.f72a != null;
    }

    private boolean O0000O0o() {
        return this.f73a.get(5);
    }

    public final void O00000Oo(esd esd) {
        if (O000000o()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f6405a);
        }
        if (O00000Oo()) {
            esd.O000000o(O00000o0);
            esd.O000000o(this.b);
        }
        if (O00000o0()) {
            esd.O000000o(O00000o);
            esd.O000000o(this.f74a);
        }
        if (O00000o()) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.c);
        }
        if (O00000oO()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.f71a);
        }
        if (this.f72a != null && O00000oo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.f72a);
        }
        if (O0000O0o()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.f75b);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        if (O000000o()) {
            sb.append("key:");
            sb.append(this.f6405a);
            z = false;
        } else {
            z = true;
        }
        if (O00000Oo()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.b);
            z = false;
        }
        if (O00000o0()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f74a);
            z = false;
        }
        if (O00000o()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.c);
            z = false;
        }
        if (O00000oO()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f71a);
            z = false;
        }
        if (O00000oo()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f72a;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            z = false;
        }
        if (O0000O0o()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f75b);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        ia iaVar;
        if (obj == null || !(obj instanceof ia) || (iaVar = (ia) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = iaVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || this.f6405a != iaVar.f6405a)) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = iaVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || this.b != iaVar.b)) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = iaVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || this.f74a != iaVar.f74a)) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = iaVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || this.c != iaVar.c)) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = iaVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || this.f71a != iaVar.f71a)) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = iaVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.f72a.equals(iaVar.f72a))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = iaVar.O0000O0o();
        if (O0000O0o2 || O0000O0o3) {
            return O0000O0o2 && O0000O0o3 && this.f75b == iaVar.f75b;
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
            if (O00000Oo2.O00000Oo != 0) {
                switch (O00000Oo2.O00000o0) {
                    case 1:
                        if (O00000Oo2.O00000Oo != 8) {
                            ese.O000000o(esd, O00000Oo2.O00000Oo);
                            break;
                        } else {
                            this.f6405a = esd.O0000Oo0();
                            this.f73a.set(0, true);
                            break;
                        }
                    case 2:
                        if (O00000Oo2.O00000Oo != 8) {
                            ese.O000000o(esd, O00000Oo2.O00000Oo);
                            break;
                        } else {
                            this.b = esd.O0000Oo0();
                            this.f73a.set(1, true);
                            break;
                        }
                    case 3:
                        if (O00000Oo2.O00000Oo != 2) {
                            ese.O000000o(esd, O00000Oo2.O00000Oo);
                            break;
                        } else {
                            this.f74a = esd.O00000oo();
                            this.f73a.set(2, true);
                            break;
                        }
                    case 4:
                        if (O00000Oo2.O00000Oo != 8) {
                            ese.O000000o(esd, O00000Oo2.O00000Oo);
                            break;
                        } else {
                            this.c = esd.O0000Oo0();
                            this.f73a.set(3, true);
                            break;
                        }
                    case 5:
                        if (O00000Oo2.O00000Oo == 10) {
                            this.f71a = esd.O0000Oo();
                            this.f73a.set(4, true);
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 6:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f72a = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 7:
                        if (O00000Oo2.O00000Oo == 2) {
                            this.f75b = esd.O00000oo();
                            this.f73a.set(5, true);
                            break;
                        }
                    default:
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                }
            } else {
                return;
            }
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
        ia iaVar = (ia) obj;
        if (!getClass().equals(iaVar.getClass())) {
            return getClass().getName().compareTo(iaVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(iaVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o8 = erw.O000000o(this.f6405a, iaVar.f6405a)) != 0) {
            return O000000o8;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(iaVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o7 = erw.O000000o(this.b, iaVar.b)) != 0) {
            return O000000o7;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(iaVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o6 = erw.O000000o(this.f74a, iaVar.f74a)) != 0) {
            return O000000o6;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(iaVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o5 = erw.O000000o(this.c, iaVar.c)) != 0) {
            return O000000o5;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(iaVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o4 = erw.O000000o(this.f71a, iaVar.f71a)) != 0) {
            return O000000o4;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(iaVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o3 = erw.O000000o(this.f72a, iaVar.f72a)) != 0) {
            return O000000o3;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(iaVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!O0000O0o() || (O000000o2 = erw.O000000o(this.f75b, iaVar.f75b)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
