package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esb;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hy implements ja<hy, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6401O000000o = new esg("NormalConfig");
    private static final esa O00000Oo = new esa("", (byte) 8, 1);
    private static final esa O00000o = new esa("", (byte) 8, 3);
    private static final esa O00000o0 = new esa("", (byte) 15, 2);

    /* renamed from: a  reason: collision with root package name */
    public int f6402a;

    /* renamed from: a  reason: collision with other field name */
    public hv f66a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f67a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<ia> f68a;

    private boolean O000000o() {
        return this.f67a.get(0);
    }

    private boolean O00000Oo() {
        return this.f68a != null;
    }

    private void O00000o() {
        if (this.f68a == null) {
            throw new jm("Required field 'configItems' was not present! Struct: " + toString());
        }
    }

    private boolean O00000o0() {
        return this.f66a != null;
    }

    public final void O00000Oo(esd esd) {
        O00000o();
        esd.O000000o(O00000Oo);
        esd.O000000o(this.f6402a);
        if (this.f68a != null) {
            esd.O000000o(O00000o0);
            esd.O000000o(new esb((byte) 12, this.f68a.size()));
            for (ia O00000Oo2 : this.f68a) {
                O00000Oo2.O00000Oo(esd);
            }
        }
        if (this.f66a != null && O00000o0()) {
            esd.O000000o(O00000o);
            esd.O000000o(this.f66a.a());
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f6402a);
        sb.append(", ");
        sb.append("configItems:");
        List<ia> list = this.f68a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (O00000o0()) {
            sb.append(", ");
            sb.append("type:");
            hv hvVar = this.f66a;
            if (hvVar == null) {
                sb.append("null");
            } else {
                sb.append(hvVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        hy hyVar;
        if (obj == null || !(obj instanceof hy) || (hyVar = (hy) obj) == null || this.f6402a != hyVar.f6402a) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = hyVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f68a.equals(hyVar.f68a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = hyVar.O00000o0();
        if (O00000o02 || O00000o03) {
            return O00000o02 && O00000o03 && this.f66a.equals(hyVar.f66a);
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
            short s = O00000Oo2.O00000o0;
            if (s != 1) {
                if (s != 2) {
                    if (s == 3 && O00000Oo2.O00000Oo == 8) {
                        this.f66a = hv.a(esd.O0000Oo0());
                    }
                } else if (O00000Oo2.O00000Oo == 15) {
                    esb O00000o2 = esd.O00000o();
                    this.f68a = new ArrayList(O00000o2.O00000Oo);
                    for (int i = 0; i < O00000o2.O00000Oo; i++) {
                        ia iaVar = new ia();
                        iaVar.O000000o(esd);
                        this.f68a.add(iaVar);
                    }
                }
            } else if (O00000Oo2.O00000Oo == 8) {
                this.f6402a = esd.O0000Oo0();
                this.f67a.set(0, true);
            }
            ese.O000000o(esd, O00000Oo2.O00000Oo);
        }
        if (O000000o()) {
            O00000o();
            return;
        }
        throw new jm("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        int O000000o3;
        int O000000o4;
        hy hyVar = (hy) obj;
        if (!getClass().equals(hyVar.getClass())) {
            return getClass().getName().compareTo(hyVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(hyVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o4 = erw.O000000o(this.f6402a, hyVar.f6402a)) != 0) {
            return O000000o4;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(hyVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o3 = erw.O000000o(this.f68a, hyVar.f68a)) != 0) {
            return O000000o3;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(hyVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!O00000o0() || (O000000o2 = erw.O000000o(this.f66a, hyVar.f66a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
