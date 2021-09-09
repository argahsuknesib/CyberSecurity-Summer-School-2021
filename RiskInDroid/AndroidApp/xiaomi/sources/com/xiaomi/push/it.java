package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esb;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import com.google.android.exoplayer2.C;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class it implements ja<it, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6441O000000o = new esg("XmPushActionSubscription");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 12, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 11, 5);
    private static final esa O0000O0o = new esa("", (byte) 11, 6);
    private static final esa O0000OOo = new esa("", (byte) 11, 7);
    private static final esa O0000Oo0 = new esa("", (byte) 15, 8);

    /* renamed from: a  reason: collision with root package name */
    public ie f6442a;

    /* renamed from: a  reason: collision with other field name */
    public String f163a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f164a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    private boolean O000000o() {
        return this.f163a != null;
    }

    private boolean O00000Oo() {
        return this.f6442a != null;
    }

    private boolean O00000o() {
        return this.c != null;
    }

    private boolean O00000o0() {
        return this.b != null;
    }

    private boolean O00000oO() {
        return this.d != null;
    }

    private boolean O00000oo() {
        return this.e != null;
    }

    private boolean O0000O0o() {
        return this.f != null;
    }

    private boolean O0000OOo() {
        return this.f164a != null;
    }

    private void O0000Oo0() {
        if (this.b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.d == null) {
            throw new jm("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo != 0) {
                switch (O00000Oo2.O00000o0) {
                    case 1:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f163a = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 2:
                        if (O00000Oo2.O00000Oo == 12) {
                            this.f6442a = new ie();
                            this.f6442a.O000000o(esd);
                            continue;
                        }
                        break;
                    case 3:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.b = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 4:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.c = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 5:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.d = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 6:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.e = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 7:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        if (O00000Oo2.O00000Oo == 15) {
                            esb O00000o2 = esd.O00000o();
                            this.f164a = new ArrayList(O00000o2.O00000Oo);
                            for (int i = 0; i < O00000o2.O00000Oo; i++) {
                                this.f164a.add(esd.O0000Ooo());
                            }
                            continue;
                        }
                        break;
                }
                ese.O000000o(esd, O00000Oo2.O00000Oo);
            } else {
                O0000Oo0();
                return;
            }
        }
    }

    public final void O00000Oo(esd esd) {
        O0000Oo0();
        if (this.f163a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f163a);
        }
        if (this.f6442a != null && O00000Oo()) {
            esd.O000000o(O00000o0);
            this.f6442a.O00000Oo(esd);
        }
        if (this.b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.b);
        }
        if (this.c != null) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.c);
        }
        if (this.d != null) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.d);
        }
        if (this.e != null && O00000oo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.e);
        }
        if (this.f != null && O0000O0o()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.f);
        }
        if (this.f164a != null && O0000OOo()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(new esb((byte) 11, this.f164a.size()));
            for (String O000000o2 : this.f164a) {
                esd.O000000o(O000000o2);
            }
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        if (O000000o()) {
            sb.append("debug:");
            String str = this.f163a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (O00000Oo()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            ie ieVar = this.f6442a;
            if (ieVar == null) {
                sb.append("null");
            } else {
                sb.append(ieVar);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000O0o()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f164a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        it itVar;
        if (obj == null || !(obj instanceof it) || (itVar = (it) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = itVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f163a.equals(itVar.f163a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = itVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f6442a.O000000o(itVar.f6442a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = itVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.b.equals(itVar.b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = itVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.c.equals(itVar.c))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = itVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || !this.d.equals(itVar.d))) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = itVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.e.equals(itVar.e))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = itVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.f.equals(itVar.f))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = itVar.O0000OOo();
        if (O0000OOo2 || O0000OOo3) {
            return O0000OOo2 && O0000OOo3 && this.f164a.equals(itVar.f164a);
        }
        return true;
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        int O000000o3;
        int O000000o4;
        int O000000o5;
        int O000000o6;
        int O000000o7;
        int O000000o8;
        int O000000o9;
        it itVar = (it) obj;
        if (!getClass().equals(itVar.getClass())) {
            return getClass().getName().compareTo(itVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(itVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o9 = erw.O000000o(this.f163a, itVar.f163a)) != 0) {
            return O000000o9;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(itVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o8 = erw.O000000o(this.f6442a, itVar.f6442a)) != 0) {
            return O000000o8;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(itVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o7 = erw.O000000o(this.b, itVar.b)) != 0) {
            return O000000o7;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(itVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o6 = erw.O000000o(this.c, itVar.c)) != 0) {
            return O000000o6;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(itVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o5 = erw.O000000o(this.d, itVar.d)) != 0) {
            return O000000o5;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(itVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o4 = erw.O000000o(this.e, itVar.e)) != 0) {
            return O000000o4;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(itVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000O0o() && (O000000o3 = erw.O000000o(this.f, itVar.f)) != 0) {
            return O000000o3;
        }
        int compareTo8 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(itVar.O0000OOo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!O0000OOo() || (O000000o2 = erw.O000000o(this.f164a, itVar.f164a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
