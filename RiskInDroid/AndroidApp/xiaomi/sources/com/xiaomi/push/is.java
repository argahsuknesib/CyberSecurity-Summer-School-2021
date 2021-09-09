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
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class is implements ja<is, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6439O000000o = new esg("XmPushActionSendMessage");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 12, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 11, 5);
    private static final esa O0000O0o = new esa("", (byte) 11, 6);
    private static final esa O0000OOo = new esa("", (byte) 11, 7);
    private static final esa O0000Oo = new esa("", (byte) 2, 9);
    private static final esa O0000Oo0 = new esa("", (byte) 12, 8);
    private static final esa O0000OoO = new esa("", (byte) 13, 10);
    private static final esa O0000Ooo = new esa("", (byte) 11, 11);
    private static final esa O0000o00 = new esa("", (byte) 11, 12);

    /* renamed from: a  reason: collision with root package name */
    public ib f6440a;

    /* renamed from: a  reason: collision with other field name */
    public ie f158a;

    /* renamed from: a  reason: collision with other field name */
    public String f159a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f160a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f161a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f162a = true;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    private boolean O000000o() {
        return this.f159a != null;
    }

    private boolean O00000Oo() {
        return this.f158a != null;
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
        return this.f6440a != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000Oo() {
        this.f160a.set(0, true);
    }

    private boolean O0000Oo0() {
        return this.f160a.get(0);
    }

    private boolean O0000OoO() {
        return this.f161a != null;
    }

    private boolean O0000Ooo() {
        return this.g != null;
    }

    private void O0000o0() {
        if (this.b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    private boolean O0000o00() {
        return this.h != null;
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo != 0) {
                switch (O00000Oo2.O00000o0) {
                    case 1:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f159a = esd.O0000Ooo();
                            continue;
                        }
                        break;
                    case 2:
                        if (O00000Oo2.O00000Oo == 12) {
                            this.f158a = new ie();
                            this.f158a.O000000o(esd);
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
                        if (O00000Oo2.O00000Oo == 12) {
                            this.f6440a = new ib();
                            this.f6440a.O000000o(esd);
                            continue;
                        }
                        break;
                    case 9:
                        if (O00000Oo2.O00000Oo == 2) {
                            this.f162a = esd.O00000oo();
                            O0000Oo();
                            continue;
                        }
                        break;
                    case 10:
                        if (O00000Oo2.O00000Oo == 13) {
                            esc O00000o02 = esd.O00000o0();
                            this.f161a = new HashMap(O00000o02.O00000o0 * 2);
                            for (int i = 0; i < O00000o02.O00000o0; i++) {
                                this.f161a.put(esd.O0000Ooo(), esd.O0000Ooo());
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
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.h = esd.O0000Ooo();
                            continue;
                        }
                        break;
                }
                ese.O000000o(esd, O00000Oo2.O00000Oo);
            } else {
                O0000o0();
                return;
            }
        }
    }

    public final boolean O000000o(is isVar) {
        if (isVar == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = isVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f159a.equals(isVar.f159a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = isVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f158a.O000000o(isVar.f158a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = isVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.b.equals(isVar.b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = isVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.c.equals(isVar.c))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = isVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || !this.d.equals(isVar.d))) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = isVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.e.equals(isVar.e))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = isVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.f.equals(isVar.f))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = isVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.f6440a.O000000o(isVar.f6440a))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = isVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || this.f162a != isVar.f162a)) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = isVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || !this.f161a.equals(isVar.f161a))) {
            return false;
        }
        boolean O0000Ooo2 = O0000Ooo();
        boolean O0000Ooo3 = isVar.O0000Ooo();
        if ((O0000Ooo2 || O0000Ooo3) && (!O0000Ooo2 || !O0000Ooo3 || !this.g.equals(isVar.g))) {
            return false;
        }
        boolean O0000o002 = O0000o00();
        boolean O0000o003 = isVar.O0000o00();
        if (O0000o002 || O0000o003) {
            return O0000o002 && O0000o003 && this.h.equals(isVar.h);
        }
        return true;
    }

    public final void O00000Oo(esd esd) {
        O0000o0();
        if (this.f159a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f159a);
        }
        if (this.f158a != null && O00000Oo()) {
            esd.O000000o(O00000o0);
            this.f158a.O00000Oo(esd);
        }
        if (this.b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.b);
        }
        if (this.c != null) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.c);
        }
        if (this.d != null && O00000oO()) {
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
        if (this.f6440a != null && O0000OOo()) {
            esd.O000000o(O0000Oo0);
            this.f6440a.O00000Oo(esd);
        }
        if (O0000Oo0()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.f162a);
        }
        if (this.f161a != null && O0000OoO()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(new esc((byte) 11, (byte) 11, this.f161a.size()));
            for (Map.Entry next : this.f161a.entrySet()) {
                esd.O000000o((String) next.getKey());
                esd.O000000o((String) next.getValue());
            }
        }
        if (this.g != null && O0000Ooo()) {
            esd.O000000o(O0000Ooo);
            esd.O000000o(this.g);
        }
        if (this.h != null && O0000o00()) {
            esd.O000000o(O0000o00);
            esd.O000000o(this.h);
        }
        esd.O000000o();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof is)) {
            return O000000o((is) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        if (O000000o()) {
            sb.append("debug:");
            String str = this.f159a;
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
            ie ieVar = this.f158a;
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
        if (O00000oO()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000O0o()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("message:");
            ib ibVar = this.f6440a;
            if (ibVar == null) {
                sb.append("null");
            } else {
                sb.append(ibVar);
            }
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f162a);
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f161a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
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
        if (O0000o00()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
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
        int O000000o13;
        is isVar = (is) obj;
        if (!getClass().equals(isVar.getClass())) {
            return getClass().getName().compareTo(isVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(isVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o13 = erw.O000000o(this.f159a, isVar.f159a)) != 0) {
            return O000000o13;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(isVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o12 = erw.O000000o(this.f158a, isVar.f158a)) != 0) {
            return O000000o12;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(isVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o11 = erw.O000000o(this.b, isVar.b)) != 0) {
            return O000000o11;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(isVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o10 = erw.O000000o(this.c, isVar.c)) != 0) {
            return O000000o10;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(isVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o9 = erw.O000000o(this.d, isVar.d)) != 0) {
            return O000000o9;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(isVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o8 = erw.O000000o(this.e, isVar.e)) != 0) {
            return O000000o8;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(isVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000O0o() && (O000000o7 = erw.O000000o(this.f, isVar.f)) != 0) {
            return O000000o7;
        }
        int compareTo8 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(isVar.O0000OOo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000OOo() && (O000000o6 = erw.O000000o(this.f6440a, isVar.f6440a)) != 0) {
            return O000000o6;
        }
        int compareTo9 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(isVar.O0000Oo0()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000Oo0() && (O000000o5 = erw.O000000o(this.f162a, isVar.f162a)) != 0) {
            return O000000o5;
        }
        int compareTo10 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(isVar.O0000OoO()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (O0000OoO() && (O000000o4 = erw.O000000o(this.f161a, isVar.f161a)) != 0) {
            return O000000o4;
        }
        int compareTo11 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(isVar.O0000Ooo()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (O0000Ooo() && (O000000o3 = erw.O000000o(this.g, isVar.g)) != 0) {
            return O000000o3;
        }
        int compareTo12 = Boolean.valueOf(O0000o00()).compareTo(Boolean.valueOf(isVar.O0000o00()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!O0000o00() || (O000000o2 = erw.O000000o(this.h, isVar.h)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
