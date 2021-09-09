package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esc;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import com.google.android.exoplayer2.C;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class ig implements ja<ig, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6415O000000o = new esg("XmPushActionAckNotification");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 12, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 11, 5);
    private static final esa O0000O0o = new esa("", (byte) 10, 7);
    private static final esa O0000OOo = new esa("", (byte) 11, 8);
    private static final esa O0000Oo = new esa("", (byte) 11, 10);
    private static final esa O0000Oo0 = new esa("", (byte) 13, 9);
    private static final esa O0000OoO = new esa("", (byte) 11, 11);

    /* renamed from: a  reason: collision with root package name */
    public long f6416a = 0;

    /* renamed from: a  reason: collision with other field name */
    public ie f106a;

    /* renamed from: a  reason: collision with other field name */
    public String f107a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f108a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f109a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    private boolean O00000o() {
        return this.f106a != null;
    }

    private boolean O00000o0() {
        return this.f107a != null;
    }

    private boolean O00000oO() {
        return this.b != null;
    }

    private boolean O00000oo() {
        return this.c != null;
    }

    private boolean O0000O0o() {
        return this.d != null;
    }

    private boolean O0000OOo() {
        return this.f108a.get(0);
    }

    private boolean O0000Oo() {
        return this.f109a != null;
    }

    private boolean O0000Oo0() {
        return this.e != null;
    }

    private boolean O0000OoO() {
        return this.f != null;
    }

    private boolean O0000Ooo() {
        return this.g != null;
    }

    private void O0000o00() {
        if (this.b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public final ig O000000o() {
        this.f6416a = 0;
        O00000Oo();
        return this;
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo != 0) {
                switch (O00000Oo2.O00000o0) {
                    case 1:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f107a = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 2:
                        if (O00000Oo2.O00000Oo == 12) {
                            this.f106a = new ie();
                            this.f106a.O000000o(esd);
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
                    case 7:
                        if (O00000Oo2.O00000Oo == 10) {
                            this.f6416a = esd.O0000Oo();
                            O00000Oo();
                            continue;
                        }
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.e = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 9:
                        if (O00000Oo2.O00000Oo == 13) {
                            esc O00000o02 = esd.O00000o0();
                            this.f109a = new HashMap(O00000o02.O00000o0 * 2);
                            for (int i = 0; i < O00000o02.O00000o0; i++) {
                                this.f109a.put(esd.O0000Ooo(), esd.O0000Ooo());
                            }
                            continue;
                        }
                        break;
                    case 10:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 11:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.g = esd.O0000Ooo();
                            continue;
                        }
                        break;
                }
                ese.O000000o(esd, O00000Oo2.O00000Oo);
            } else {
                O0000o00();
                return;
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    public final void O00000Oo() {
        this.f108a.set(0, true);
    }

    public final void O00000Oo(esd esd) {
        O0000o00();
        if (this.f107a != null && O00000o0()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f107a);
        }
        if (this.f106a != null && O00000o()) {
            esd.O000000o(O00000o0);
            this.f106a.O00000Oo(esd);
        }
        if (this.b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.b);
        }
        if (this.c != null && O00000oo()) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.c);
        }
        if (this.d != null && O0000O0o()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.d);
        }
        if (O0000OOo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.f6416a);
        }
        if (this.e != null && O0000Oo0()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.e);
        }
        if (this.f109a != null && O0000Oo()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(new esc((byte) 11, (byte) 11, this.f109a.size()));
            for (Map.Entry next : this.f109a.entrySet()) {
                esd.O000000o((String) next.getKey());
                esd.O000000o((String) next.getValue());
            }
        }
        if (this.f != null && O0000OoO()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.f);
        }
        if (this.g != null && O0000Ooo()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.g);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        if (O00000o0()) {
            sb.append("debug:");
            String str = this.f107a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (O00000o()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            ie ieVar = this.f106a;
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
        if (O00000oo()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (O0000O0o()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f6416a);
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f109a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000Ooo()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        ig igVar;
        if (obj == null || !(obj instanceof ig) || (igVar = (ig) obj) == null) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = igVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.f107a.equals(igVar.f107a))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = igVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.f106a.O000000o(igVar.f106a))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = igVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || !this.b.equals(igVar.b))) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = igVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.c.equals(igVar.c))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = igVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.d.equals(igVar.d))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = igVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || this.f6416a != igVar.f6416a)) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = igVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || !this.e.equals(igVar.e))) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = igVar.O0000Oo();
        if ((O0000Oo2 || O0000Oo3) && (!O0000Oo2 || !O0000Oo3 || !this.f109a.equals(igVar.f109a))) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = igVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || !this.f.equals(igVar.f))) {
            return false;
        }
        boolean O0000Ooo = O0000Ooo();
        boolean O0000Ooo2 = igVar.O0000Ooo();
        if (O0000Ooo || O0000Ooo2) {
            return O0000Ooo && O0000Ooo2 && this.g.equals(igVar.g);
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
        int O000000o10;
        int O000000o11;
        ig igVar = (ig) obj;
        if (!getClass().equals(igVar.getClass())) {
            return getClass().getName().compareTo(igVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(igVar.O00000o0()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O00000o0() && (O000000o11 = erw.O000000o(this.f107a, igVar.f107a)) != 0) {
            return O000000o11;
        }
        int compareTo2 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(igVar.O00000o()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000o() && (O000000o10 = erw.O000000o(this.f106a, igVar.f106a)) != 0) {
            return O000000o10;
        }
        int compareTo3 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(igVar.O00000oO()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000oO() && (O000000o9 = erw.O000000o(this.b, igVar.b)) != 0) {
            return O000000o9;
        }
        int compareTo4 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(igVar.O00000oo()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000oo() && (O000000o8 = erw.O000000o(this.c, igVar.c)) != 0) {
            return O000000o8;
        }
        int compareTo5 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(igVar.O0000O0o()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O0000O0o() && (O000000o7 = erw.O000000o(this.d, igVar.d)) != 0) {
            return O000000o7;
        }
        int compareTo6 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(igVar.O0000OOo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O0000OOo() && (O000000o6 = erw.O000000o(this.f6416a, igVar.f6416a)) != 0) {
            return O000000o6;
        }
        int compareTo7 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(igVar.O0000Oo0()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000Oo0() && (O000000o5 = erw.O000000o(this.e, igVar.e)) != 0) {
            return O000000o5;
        }
        int compareTo8 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(igVar.O0000Oo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000Oo() && (O000000o4 = erw.O000000o(this.f109a, igVar.f109a)) != 0) {
            return O000000o4;
        }
        int compareTo9 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(igVar.O0000OoO()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000OoO() && (O000000o3 = erw.O000000o(this.f, igVar.f)) != 0) {
            return O000000o3;
        }
        int compareTo10 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(igVar.O0000Ooo()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!O0000Ooo() || (O000000o2 = erw.O000000o(this.g, igVar.g)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
