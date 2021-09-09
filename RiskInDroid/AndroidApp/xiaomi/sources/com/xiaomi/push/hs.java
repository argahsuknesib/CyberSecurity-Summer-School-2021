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

public class hs implements ja<hs, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6392O000000o = new esg("ClientUploadData");
    private static final esa O00000Oo = new esa("", (byte) 15, 1);

    /* renamed from: a  reason: collision with root package name */
    public List<ht> f6393a;

    private boolean O000000o() {
        return this.f6393a != null;
    }

    private void O00000Oo() {
        if (this.f6393a == null) {
            throw new jm("Required field 'uploadDataItems' was not present! Struct: " + toString());
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
                this.f6393a = new ArrayList(O00000o.O00000Oo);
                for (int i = 0; i < O00000o.O00000Oo; i++) {
                    ht htVar = new ht();
                    htVar.O000000o(esd);
                    this.f6393a.add(htVar);
                }
            } else {
                ese.O000000o(esd, O00000Oo2.O00000Oo);
            }
        }
    }

    public final void O00000Oo(esd esd) {
        O00000Oo();
        if (this.f6393a != null) {
            esd.O000000o(O00000Oo);
            esd.O000000o(new esb((byte) 12, this.f6393a.size()));
            for (ht O00000Oo2 : this.f6393a) {
                O00000Oo2.O00000Oo(esd);
            }
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<ht> list = this.f6393a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        hs hsVar;
        if (obj == null || !(obj instanceof hs) || (hsVar = (hs) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = hsVar.O000000o();
        if (O000000o2 || O000000o3) {
            return O000000o2 && O000000o3 && this.f6393a.equals(hsVar.f6393a);
        }
        return true;
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        hs hsVar = (hs) obj;
        if (!getClass().equals(hsVar.getClass())) {
            return getClass().getName().compareTo(hsVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(hsVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (!O000000o() || (O000000o2 = erw.O000000o(this.f6393a, hsVar.f6393a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
