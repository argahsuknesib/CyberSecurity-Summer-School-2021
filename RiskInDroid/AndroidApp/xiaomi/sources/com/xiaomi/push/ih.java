package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import java.io.Serializable;
import java.util.BitSet;

public class ih implements ja<ih, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6417O000000o = new esg("XmPushActionCheckClientInfo");
    private static final esa O00000Oo = new esa("", (byte) 8, 1);
    private static final esa O00000o0 = new esa("", (byte) 8, 2);

    /* renamed from: a  reason: collision with root package name */
    public int f6418a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f110a = new BitSet(2);
    public int b;

    private boolean O00000o() {
        return this.f110a.get(1);
    }

    private boolean O00000o0() {
        return this.f110a.get(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    public final void O000000o() {
        this.f110a.set(0, true);
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo == 0) {
                break;
            }
            short s = O00000Oo2.O00000o0;
            if (s != 1) {
                if (s == 2 && O00000Oo2.O00000Oo == 8) {
                    this.b = esd.O0000Oo0();
                    O00000Oo();
                }
            } else if (O00000Oo2.O00000Oo == 8) {
                this.f6418a = esd.O0000Oo0();
                O000000o();
            }
            ese.O000000o(esd, O00000Oo2.O00000Oo);
        }
        if (!O00000o0()) {
            throw new jm("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (!O00000o()) {
            throw new jm("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    public final void O00000Oo() {
        this.f110a.set(1, true);
    }

    public final void O00000Oo(esd esd) {
        esd.O000000o(O00000Oo);
        esd.O000000o(this.f6418a);
        esd.O000000o(O00000o0);
        esd.O000000o(this.b);
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(" + "miscConfigVersion:" + this.f6418a + ", " + "pluginConfigVersion:" + this.b + ")";
    }

    public boolean equals(Object obj) {
        ih ihVar;
        return obj != null && (obj instanceof ih) && (ihVar = (ih) obj) != null && this.f6418a == ihVar.f6418a && this.b == ihVar.b;
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        int O000000o3;
        ih ihVar = (ih) obj;
        if (!getClass().equals(ihVar.getClass())) {
            return getClass().getName().compareTo(ihVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ihVar.O00000o0()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O00000o0() && (O000000o3 = erw.O000000o(this.f6418a, ihVar.f6418a)) != 0) {
            return O000000o3;
        }
        int compareTo2 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(ihVar.O00000o()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!O00000o() || (O000000o2 = erw.O000000o(this.b, ihVar.b)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
