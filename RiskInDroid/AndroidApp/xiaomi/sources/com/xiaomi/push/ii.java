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

public class ii implements ja<ii, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6419O000000o = new esg("XmPushActionCollectData");
    private static final esa O00000Oo = new esa("", (byte) 15, 1);

    /* renamed from: a  reason: collision with root package name */
    public List<hx> f6420a;

    private boolean O000000o() {
        return this.f6420a != null;
    }

    private void O00000Oo() {
        if (this.f6420a == null) {
            throw new jm("Required field 'dataCollectionItems' was not present! Struct: " + toString());
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
                this.f6420a = new ArrayList(O00000o.O00000Oo);
                for (int i = 0; i < O00000o.O00000Oo; i++) {
                    hx hxVar = new hx();
                    hxVar.O000000o(esd);
                    this.f6420a.add(hxVar);
                }
            } else {
                ese.O000000o(esd, O00000Oo2.O00000Oo);
            }
        }
    }

    public final void O00000Oo(esd esd) {
        O00000Oo();
        if (this.f6420a != null) {
            esd.O000000o(O00000Oo);
            esd.O000000o(new esb((byte) 12, this.f6420a.size()));
            for (hx O00000Oo2 : this.f6420a) {
                O00000Oo2.O00000Oo(esd);
            }
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<hx> list = this.f6420a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        ii iiVar;
        if (obj == null || !(obj instanceof ii) || (iiVar = (ii) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = iiVar.O000000o();
        if (O000000o2 || O000000o3) {
            return O000000o2 && O000000o3 && this.f6420a.equals(iiVar.f6420a);
        }
        return true;
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        ii iiVar = (ii) obj;
        if (!getClass().equals(iiVar.getClass())) {
            return getClass().getName().compareTo(iiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(iiVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!O000000o() || (O000000o2 = erw.O000000o(this.f6420a, iiVar.f6420a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
