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

public class fi implements ja<fi, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6381O000000o = new esg("StatsEvents");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 15, 3);
    private static final esa O00000o0 = new esa("", (byte) 11, 2);

    /* renamed from: a  reason: collision with root package name */
    public String f6382a;

    /* renamed from: a  reason: collision with other field name */
    public List<fh> f39a;
    public String b;

    public fi() {
    }

    public fi(String str, List<fh> list) {
        this();
        this.f6382a = str;
        this.f39a = list;
    }

    private boolean O000000o() {
        return this.f6382a != null;
    }

    private boolean O00000Oo() {
        return this.b != null;
    }

    private void O00000o() {
        if (this.f6382a == null) {
            throw new jm("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f39a == null) {
            throw new jm("Required field 'events' was not present! Struct: " + toString());
        }
    }

    private boolean O00000o0() {
        return this.f39a != null;
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo != 0) {
                short s = O00000Oo2.O00000o0;
                if (s != 1) {
                    if (s != 2) {
                        if (s == 3 && O00000Oo2.O00000Oo == 15) {
                            esb O00000o2 = esd.O00000o();
                            this.f39a = new ArrayList(O00000o2.O00000Oo);
                            for (int i = 0; i < O00000o2.O00000Oo; i++) {
                                fh fhVar = new fh();
                                fhVar.O000000o(esd);
                                this.f39a.add(fhVar);
                            }
                        }
                    } else if (O00000Oo2.O00000Oo == 11) {
                        this.b = esd.O0000Ooo();
                    }
                } else if (O00000Oo2.O00000Oo == 11) {
                    this.f6382a = esd.O0000Ooo();
                }
                ese.O000000o(esd, O00000Oo2.O00000Oo);
            } else {
                O00000o();
                return;
            }
        }
    }

    public final void O00000Oo(esd esd) {
        O00000o();
        if (this.f6382a != null) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f6382a);
        }
        if (this.b != null && O00000Oo()) {
            esd.O000000o(O00000o0);
            esd.O000000o(this.b);
        }
        if (this.f39a != null) {
            esd.O000000o(O00000o);
            esd.O000000o(new esb((byte) 12, this.f39a.size()));
            for (fh O00000Oo2 : this.f39a) {
                O00000Oo2.O00000Oo(esd);
            }
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f6382a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (O00000Oo()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<fh> list = this.f39a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        fi fiVar;
        if (obj == null || !(obj instanceof fi) || (fiVar = (fi) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = fiVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f6382a.equals(fiVar.f6382a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = fiVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.b.equals(fiVar.b))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = fiVar.O00000o0();
        if (O00000o02 || O00000o03) {
            return O00000o02 && O00000o03 && this.f39a.equals(fiVar.f39a);
        }
        return true;
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        int O000000o3;
        int O000000o4;
        fi fiVar = (fi) obj;
        if (!getClass().equals(fiVar.getClass())) {
            return getClass().getName().compareTo(fiVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(fiVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o4 = erw.O000000o(this.f6382a, fiVar.f6382a)) != 0) {
            return O000000o4;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(fiVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o3 = erw.O000000o(this.b, fiVar.b)) != 0) {
            return O000000o3;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(fiVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!O00000o0() || (O000000o2 = erw.O000000o(this.f39a, fiVar.f39a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
