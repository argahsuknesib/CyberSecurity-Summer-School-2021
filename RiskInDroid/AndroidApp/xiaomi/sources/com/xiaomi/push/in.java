package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esb;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class in implements ja<in, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6429O000000o = new esg("XmPushActionNormalConfig");
    private static final esa O00000Oo = new esa("", (byte) 15, 1);

    /* renamed from: a  reason: collision with root package name */
    public List<hy> f6430a;

    private boolean O000000o() {
        return this.f6430a != null;
    }

    private void O00000Oo() {
        if (this.f6430a == null) {
            throw new jm("Required field 'normalConfigs' was not present! Struct: " + toString());
        }
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo == 0) {
                O00000Oo();
                return;
            } else if (O00000Oo2.O00000o0 == 1 && O00000Oo2.O00000Oo == 15) {
                esb O00000o = esd.O00000o();
                this.f6430a = new ArrayList(O00000o.O00000Oo);
                for (int i = 0; i < O00000o.O00000Oo; i++) {
                    hy hyVar = new hy();
                    hyVar.O000000o(esd);
                    this.f6430a.add(hyVar);
                }
            } else {
                ese.O000000o(esd, O00000Oo2.O00000Oo);
            }
        }
    }

    public final void O00000Oo(esd esd) {
        O00000Oo();
        if (this.f6430a != null) {
            esd.O000000o(O00000Oo);
            esd.O000000o(new esb((byte) 12, this.f6430a.size()));
            for (hy O00000Oo2 : this.f6430a) {
                O00000Oo2.O00000Oo(esd);
            }
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<hy> list = this.f6430a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        in inVar;
        if (obj == null || !(obj instanceof in) || (inVar = (in) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = inVar.O000000o();
        if (O000000o2 || O000000o3) {
            return O000000o2 && O000000o3 && this.f6430a.equals(inVar.f6430a);
        }
        return true;
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        in inVar = (in) obj;
        if (!getClass().equals(inVar.getClass())) {
            return getClass().getName().compareTo(inVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(inVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!O000000o() || (O000000o2 = erw.O000000o(this.f6430a, inVar.f6430a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
