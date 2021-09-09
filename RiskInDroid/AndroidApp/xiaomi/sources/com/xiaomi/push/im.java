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

public class im implements ja<im, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6427O000000o = new esg("XmPushActionCustomConfig");
    private static final esa O00000Oo = new esa("", (byte) 15, 1);

    /* renamed from: a  reason: collision with root package name */
    public List<ia> f6428a;

    private boolean O000000o() {
        return this.f6428a != null;
    }

    private void O00000Oo() {
        if (this.f6428a == null) {
            throw new jm("Required field 'customConfigs' was not present! Struct: " + toString());
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
                this.f6428a = new ArrayList(O00000o.O00000Oo);
                for (int i = 0; i < O00000o.O00000Oo; i++) {
                    ia iaVar = new ia();
                    iaVar.O000000o(esd);
                    this.f6428a.add(iaVar);
                }
            } else {
                ese.O000000o(esd, O00000Oo2.O00000Oo);
            }
        }
    }

    public final void O00000Oo(esd esd) {
        O00000Oo();
        if (this.f6428a != null) {
            esd.O000000o(O00000Oo);
            esd.O000000o(new esb((byte) 12, this.f6428a.size()));
            for (ia O00000Oo2 : this.f6428a) {
                O00000Oo2.O00000Oo(esd);
            }
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<ia> list = this.f6428a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        im imVar;
        if (obj == null || !(obj instanceof im) || (imVar = (im) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = imVar.O000000o();
        if (O000000o2 || O000000o3) {
            return O000000o2 && O000000o3 && this.f6428a.equals(imVar.f6428a);
        }
        return true;
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        im imVar = (im) obj;
        if (!getClass().equals(imVar.getClass())) {
            return getClass().getName().compareTo(imVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(imVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!O000000o() || (O000000o2 = erw.O000000o(this.f6428a, imVar.f6428a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
