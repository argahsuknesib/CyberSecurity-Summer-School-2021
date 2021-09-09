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

public class ht implements ja<ht, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6394O000000o = new esg("ClientUploadDataItem");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 11, 2);
    private static final esa O00000oO = new esa("", (byte) 10, 4);
    private static final esa O00000oo = new esa("", (byte) 10, 5);
    private static final esa O0000O0o = new esa("", (byte) 2, 6);
    private static final esa O0000OOo = new esa("", (byte) 11, 7);
    private static final esa O0000Oo = new esa("", (byte) 11, 9);
    private static final esa O0000Oo0 = new esa("", (byte) 11, 8);
    private static final esa O0000OoO = new esa("", (byte) 13, 10);
    private static final esa O0000Ooo = new esa("", (byte) 11, 11);

    /* renamed from: a  reason: collision with root package name */
    public long f6395a;

    /* renamed from: a  reason: collision with other field name */
    public String f52a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f53a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f54a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f55a;
    public long b;

    /* renamed from: b  reason: collision with other field name */
    public String f56b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    private boolean O000000o() {
        return this.f52a != null;
    }

    private boolean O00000Oo() {
        return this.f56b != null;
    }

    private boolean O00000o() {
        return this.f53a.get(0);
    }

    private boolean O00000o0() {
        return this.c != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000oO() {
        this.f53a.set(0, true);
    }

    private boolean O00000oo() {
        return this.f53a.get(1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000O0o() {
        this.f53a.set(1, true);
    }

    private boolean O0000OOo() {
        return this.f53a.get(2);
    }

    private boolean O0000Oo() {
        return this.d != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000Oo0() {
        this.f53a.set(2, true);
    }

    private boolean O0000OoO() {
        return this.e != null;
    }

    private boolean O0000Ooo() {
        return this.f != null;
    }

    private boolean O0000o0() {
        return this.g != null;
    }

    private boolean O0000o00() {
        return this.f54a != null;
    }

    public final ht O000000o(long j) {
        this.f6395a = j;
        O00000oO();
        return this;
    }

    public final ht O000000o(boolean z) {
        this.f55a = z;
        O0000Oo0();
        return this;
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo != 0) {
                switch (O00000Oo2.O00000o0) {
                    case 1:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f52a = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 2:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f56b = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 3:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.c = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 4:
                        if (O00000Oo2.O00000Oo == 10) {
                            this.f6395a = esd.O0000Oo();
                            O00000oO();
                            continue;
                        }
                        break;
                    case 5:
                        if (O00000Oo2.O00000Oo == 10) {
                            this.b = esd.O0000Oo();
                            O0000O0o();
                            continue;
                        }
                        break;
                    case 6:
                        if (O00000Oo2.O00000Oo == 2) {
                            this.f55a = esd.O00000oo();
                            O0000Oo0();
                            continue;
                        }
                        break;
                    case 7:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.d = esd.O0000Ooo();
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
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 10:
                        if (O00000Oo2.O00000Oo == 13) {
                            esc O00000o02 = esd.O00000o0();
                            this.f54a = new HashMap(O00000o02.O00000o0 * 2);
                            for (int i = 0; i < O00000o02.O00000o0; i++) {
                                this.f54a.put(esd.O0000Ooo(), esd.O0000Ooo());
                            }
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
                return;
            }
        }
    }

    public final ht O00000Oo(long j) {
        this.b = j;
        O0000O0o();
        return this;
    }

    public final void O00000Oo(esd esd) {
        if (this.f52a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f52a);
        }
        if (this.f56b != null && O00000Oo()) {
            esd.O000000o(O00000o0);
            esd.O000000o(this.f56b);
        }
        if (this.c != null && O00000o0()) {
            esd.O000000o(O00000o);
            esd.O000000o(this.c);
        }
        if (O00000o()) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.f6395a);
        }
        if (O00000oo()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.b);
        }
        if (O0000OOo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.f55a);
        }
        if (this.d != null && O0000Oo()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.d);
        }
        if (this.e != null && O0000OoO()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(this.e);
        }
        if (this.f != null && O0000Ooo()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.f);
        }
        if (this.f54a != null && O0000o00()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(new esc((byte) 11, (byte) 11, this.f54a.size()));
            for (Map.Entry next : this.f54a.entrySet()) {
                esd.O000000o((String) next.getKey());
                esd.O000000o((String) next.getValue());
            }
        }
        if (this.g != null && O0000o0()) {
            esd.O000000o(O0000Ooo);
            esd.O000000o(this.g);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        if (O000000o()) {
            sb.append("channel:");
            String str = this.f52a;
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
            sb.append("data:");
            String str2 = this.f56b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (O00000o0()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (O00000o()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f6395a);
            z = false;
        }
        if (O00000oo()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.b);
            z = false;
        }
        if (O0000OOo()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f55a);
            z = false;
        }
        if (O0000Oo()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (O0000OoO()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (O0000Ooo()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (O0000o00()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f54a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
            z = false;
        }
        if (O0000o0()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("pkgName:");
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
        ht htVar;
        if (obj == null || !(obj instanceof ht) || (htVar = (ht) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = htVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f52a.equals(htVar.f52a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = htVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f56b.equals(htVar.f56b))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = htVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.c.equals(htVar.c))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = htVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || this.f6395a != htVar.f6395a)) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = htVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || this.b != htVar.b)) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = htVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || this.f55a != htVar.f55a)) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = htVar.O0000Oo();
        if ((O0000Oo2 || O0000Oo3) && (!O0000Oo2 || !O0000Oo3 || !this.d.equals(htVar.d))) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = htVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || !this.e.equals(htVar.e))) {
            return false;
        }
        boolean O0000Ooo2 = O0000Ooo();
        boolean O0000Ooo3 = htVar.O0000Ooo();
        if ((O0000Ooo2 || O0000Ooo3) && (!O0000Ooo2 || !O0000Ooo3 || !this.f.equals(htVar.f))) {
            return false;
        }
        boolean O0000o00 = O0000o00();
        boolean O0000o002 = htVar.O0000o00();
        if ((O0000o00 || O0000o002) && (!O0000o00 || !O0000o002 || !this.f54a.equals(htVar.f54a))) {
            return false;
        }
        boolean O0000o0 = O0000o0();
        boolean O0000o02 = htVar.O0000o0();
        if (O0000o0 || O0000o02) {
            return O0000o0 && O0000o02 && this.g.equals(htVar.g);
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
        int O000000o12;
        ht htVar = (ht) obj;
        if (!getClass().equals(htVar.getClass())) {
            return getClass().getName().compareTo(htVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(htVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o12 = erw.O000000o(this.f52a, htVar.f52a)) != 0) {
            return O000000o12;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(htVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o11 = erw.O000000o(this.f56b, htVar.f56b)) != 0) {
            return O000000o11;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(htVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o10 = erw.O000000o(this.c, htVar.c)) != 0) {
            return O000000o10;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(htVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o9 = erw.O000000o(this.f6395a, htVar.f6395a)) != 0) {
            return O000000o9;
        }
        int compareTo5 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(htVar.O00000oo()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oo() && (O000000o8 = erw.O000000o(this.b, htVar.b)) != 0) {
            return O000000o8;
        }
        int compareTo6 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(htVar.O0000OOo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O0000OOo() && (O000000o7 = erw.O000000o(this.f55a, htVar.f55a)) != 0) {
            return O000000o7;
        }
        int compareTo7 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(htVar.O0000Oo()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000Oo() && (O000000o6 = erw.O000000o(this.d, htVar.d)) != 0) {
            return O000000o6;
        }
        int compareTo8 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(htVar.O0000OoO()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000OoO() && (O000000o5 = erw.O000000o(this.e, htVar.e)) != 0) {
            return O000000o5;
        }
        int compareTo9 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(htVar.O0000Ooo()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000Ooo() && (O000000o4 = erw.O000000o(this.f, htVar.f)) != 0) {
            return O000000o4;
        }
        int compareTo10 = Boolean.valueOf(O0000o00()).compareTo(Boolean.valueOf(htVar.O0000o00()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (O0000o00() && (O000000o3 = erw.O000000o(this.f54a, htVar.f54a)) != 0) {
            return O000000o3;
        }
        int compareTo11 = Boolean.valueOf(O0000o0()).compareTo(Boolean.valueOf(htVar.O0000o0()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!O0000o0() || (O000000o2 = erw.O000000o(this.g, htVar.g)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
