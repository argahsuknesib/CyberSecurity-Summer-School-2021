package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import java.io.Serializable;
import java.util.BitSet;

public class hx implements ja<hx, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6399O000000o = new esg("DataCollectionItem");
    private static final esa O00000Oo = new esa("", (byte) 10, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 8, 2);

    /* renamed from: a  reason: collision with root package name */
    public long f6400a;

    /* renamed from: a  reason: collision with other field name */
    public hr f63a;

    /* renamed from: a  reason: collision with other field name */
    public String f64a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f65a = new BitSet(1);

    private boolean O000000o() {
        return this.f65a.get(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000Oo() {
        this.f65a.set(0, true);
    }

    private boolean O00000o() {
        return this.f64a != null;
    }

    private boolean O00000o0() {
        return this.f63a != null;
    }

    private void O00000oO() {
        if (this.f63a == null) {
            throw new jm("Required field 'collectionType' was not present! Struct: " + toString());
        } else if (this.f64a == null) {
            throw new jm("Required field 'content' was not present! Struct: " + toString());
        }
    }

    public final hx O000000o(long j) {
        this.f6400a = j;
        O00000Oo();
        return this;
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
                    if (s == 3 && O00000Oo2.O00000Oo == 11) {
                        this.f64a = esd.O0000Ooo();
                    }
                } else if (O00000Oo2.O00000Oo == 8) {
                    this.f63a = hr.a(esd.O0000Oo0());
                }
            } else if (O00000Oo2.O00000Oo == 10) {
                this.f6400a = esd.O0000Oo();
                O00000Oo();
            }
            ese.O000000o(esd, O00000Oo2.O00000Oo);
        }
        if (O000000o()) {
            O00000oO();
            return;
        }
        throw new jm("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    public final void O00000Oo(esd esd) {
        O00000oO();
        esd.O000000o(O00000Oo);
        esd.O000000o(this.f6400a);
        if (this.f63a != null) {
            esd.O000000o(O00000o0);
            esd.O000000o(this.f63a.a());
        }
        if (this.f64a != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.f64a);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f6400a);
        sb.append(", ");
        sb.append("collectionType:");
        hr hrVar = this.f63a;
        if (hrVar == null) {
            sb.append("null");
        } else {
            sb.append(hrVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f64a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        hx hxVar;
        if (obj == null || !(obj instanceof hx) || (hxVar = (hx) obj) == null || this.f6400a != hxVar.f6400a) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = hxVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.f63a.equals(hxVar.f63a))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = hxVar.O00000o();
        if (O00000o2 || O00000o3) {
            return O00000o2 && O00000o3 && this.f64a.equals(hxVar.f64a);
        }
        return true;
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        int O000000o3;
        int O000000o4;
        hx hxVar = (hx) obj;
        if (!getClass().equals(hxVar.getClass())) {
            return getClass().getName().compareTo(hxVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(hxVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o4 = erw.O000000o(this.f6400a, hxVar.f6400a)) != 0) {
            return O000000o4;
        }
        int compareTo2 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(hxVar.O00000o0()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000o0() && (O000000o3 = erw.O000000o(this.f63a, hxVar.f63a)) != 0) {
            return O000000o3;
        }
        int compareTo3 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(hxVar.O00000o()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!O00000o() || (O000000o2 = erw.O000000o(this.f64a, hxVar.f64a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
