package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import java.io.Serializable;
import java.util.BitSet;

public class ie implements ja<ie, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6411O000000o = new esg("Target");
    private static final esa O00000Oo = new esa("", (byte) 10, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 11, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 2, 5);
    private static final esa O0000O0o = new esa("", (byte) 11, 7);

    /* renamed from: a  reason: collision with root package name */
    public long f6412a = 5;

    /* renamed from: a  reason: collision with other field name */
    public String f94a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f95a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f96a = false;
    public String b = "xiaomi.com";
    public String c = "";
    public String d;

    private boolean O000000o() {
        return this.f95a.get(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000Oo() {
        this.f95a.set(0, true);
    }

    private boolean O00000o() {
        return this.b != null;
    }

    private boolean O00000o0() {
        return this.f94a != null;
    }

    private boolean O00000oO() {
        return this.c != null;
    }

    private boolean O00000oo() {
        return this.f95a.get(1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000O0o() {
        this.f95a.set(1, true);
    }

    private boolean O0000OOo() {
        return this.d != null;
    }

    private void O0000Oo0() {
        if (this.f94a == null) {
            throw new jm("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo == 0) {
                break;
            }
            short s = O00000Oo2.O00000o0;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s == 7 && O00000Oo2.O00000Oo == 11) {
                                    this.d = esd.O0000Ooo();
                                }
                            } else if (O00000Oo2.O00000Oo == 2) {
                                this.f96a = esd.O00000oo();
                                O0000O0o();
                            }
                        } else if (O00000Oo2.O00000Oo == 11) {
                            this.c = esd.O0000Ooo();
                        }
                    } else if (O00000Oo2.O00000Oo == 11) {
                        this.b = esd.O0000Ooo();
                    }
                } else if (O00000Oo2.O00000Oo == 11) {
                    this.f94a = esd.O0000Ooo();
                }
            } else if (O00000Oo2.O00000Oo == 10) {
                this.f6412a = esd.O0000Oo();
                O00000Oo();
            }
            ese.O000000o(esd, O00000Oo2.O00000Oo);
        }
        if (O000000o()) {
            O0000Oo0();
            return;
        }
        throw new jm("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public final boolean O000000o(ie ieVar) {
        if (ieVar == null || this.f6412a != ieVar.f6412a) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = ieVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.f94a.equals(ieVar.f94a))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = ieVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.b.equals(ieVar.b))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = ieVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || !this.c.equals(ieVar.c))) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = ieVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || this.f96a != ieVar.f96a)) {
            return false;
        }
        boolean O0000OOo = O0000OOo();
        boolean O0000OOo2 = ieVar.O0000OOo();
        if (O0000OOo || O0000OOo2) {
            return O0000OOo && O0000OOo2 && this.d.equals(ieVar.d);
        }
        return true;
    }

    public final void O00000Oo(esd esd) {
        O0000Oo0();
        esd.O000000o(O00000Oo);
        esd.O000000o(this.f6412a);
        if (this.f94a != null) {
            esd.O000000o(O00000o0);
            esd.O000000o(this.f94a);
        }
        if (this.b != null && O00000o()) {
            esd.O000000o(O00000o);
            esd.O000000o(this.b);
        }
        if (this.c != null && O00000oO()) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.c);
        }
        if (O00000oo()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.f96a);
        }
        if (this.d != null && O0000OOo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.d);
        }
        esd.O000000o();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return O000000o((ie) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f6412a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f94a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (O00000o()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (O00000oO()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f96a);
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        int O000000o3;
        int O000000o4;
        int O000000o5;
        int O000000o6;
        int O000000o7;
        ie ieVar = (ie) obj;
        if (!getClass().equals(ieVar.getClass())) {
            return getClass().getName().compareTo(ieVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(ieVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o7 = erw.O000000o(this.f6412a, ieVar.f6412a)) != 0) {
            return O000000o7;
        }
        int compareTo2 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ieVar.O00000o0()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000o0() && (O000000o6 = erw.O000000o(this.f94a, ieVar.f94a)) != 0) {
            return O000000o6;
        }
        int compareTo3 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(ieVar.O00000o()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o() && (O000000o5 = erw.O000000o(this.b, ieVar.b)) != 0) {
            return O000000o5;
        }
        int compareTo4 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(ieVar.O00000oO()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000oO() && (O000000o4 = erw.O000000o(this.c, ieVar.c)) != 0) {
            return O000000o4;
        }
        int compareTo5 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(ieVar.O00000oo()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oo() && (O000000o3 = erw.O000000o(this.f96a, ieVar.f96a)) != 0) {
            return O000000o3;
        }
        int compareTo6 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(ieVar.O0000OOo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!O0000OOo() || (O000000o2 = erw.O000000o(this.d, ieVar.d)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
