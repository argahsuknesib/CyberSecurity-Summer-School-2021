package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import com.google.android.exoplayer2.C;
import java.io.Serializable;
import java.util.BitSet;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class iv implements ja<iv, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6445O000000o = new esg("XmPushActionUnRegistration");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 12, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 11, 5);
    private static final esa O0000O0o = new esa("", (byte) 11, 6);
    private static final esa O0000OOo = new esa("", (byte) 11, 7);
    private static final esa O0000Oo = new esa("", (byte) 11, 9);
    private static final esa O0000Oo0 = new esa("", (byte) 11, 8);
    private static final esa O0000OoO = new esa("", (byte) 11, 10);
    private static final esa O0000Ooo = new esa("", (byte) 2, 11);
    private static final esa O0000o00 = new esa("", (byte) 10, 12);

    /* renamed from: a  reason: collision with root package name */
    public long f6446a;

    /* renamed from: a  reason: collision with other field name */
    public ie f168a;

    /* renamed from: a  reason: collision with other field name */
    public String f169a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f170a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f171a = true;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    private boolean O000000o() {
        return this.f169a != null;
    }

    private boolean O00000Oo() {
        return this.f168a != null;
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
        return this.g != null;
    }

    private boolean O0000Oo() {
        return this.i != null;
    }

    private boolean O0000Oo0() {
        return this.h != null;
    }

    private boolean O0000OoO() {
        return this.f170a.get(0);
    }

    private boolean O0000Ooo() {
        return this.f170a.get(1);
    }

    private void O0000o00() {
        if (this.b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public final void O00000Oo(esd esd) {
        O0000o00();
        if (this.f169a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f169a);
        }
        if (this.f168a != null && O00000Oo()) {
            esd.O000000o(O00000o0);
            this.f168a.O00000Oo(esd);
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
        if (this.g != null && O0000OOo()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(this.g);
        }
        if (this.h != null && O0000Oo0()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.h);
        }
        if (this.i != null && O0000Oo()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.i);
        }
        if (O0000OoO()) {
            esd.O000000o(O0000Ooo);
            esd.O000000o(this.f171a);
        }
        if (O0000Ooo()) {
            esd.O000000o(O0000o00);
            esd.O000000o(this.f6446a);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        if (O000000o()) {
            sb.append("debug:");
            String str = this.f169a;
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
            ie ieVar = this.f168a;
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
            sb.append("regId:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000O0o()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f171a);
        }
        if (O0000Ooo()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f6446a);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        iv ivVar;
        if (obj == null || !(obj instanceof iv) || (ivVar = (iv) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = ivVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f169a.equals(ivVar.f169a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = ivVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f168a.O000000o(ivVar.f168a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = ivVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.b.equals(ivVar.b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = ivVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.c.equals(ivVar.c))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = ivVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || !this.d.equals(ivVar.d))) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = ivVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.e.equals(ivVar.e))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = ivVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.f.equals(ivVar.f))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = ivVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.g.equals(ivVar.g))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = ivVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || !this.h.equals(ivVar.h))) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = ivVar.O0000Oo();
        if ((O0000Oo2 || O0000Oo3) && (!O0000Oo2 || !O0000Oo3 || !this.i.equals(ivVar.i))) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = ivVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || this.f171a != ivVar.f171a)) {
            return false;
        }
        boolean O0000Ooo2 = O0000Ooo();
        boolean O0000Ooo3 = ivVar.O0000Ooo();
        if (O0000Ooo2 || O0000Ooo3) {
            return O0000Ooo2 && O0000Ooo3 && this.f6446a == ivVar.f6446a;
        }
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo != 0) {
                switch (O00000Oo2.O00000o0) {
                    case 1:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f169a = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 2:
                        if (O00000Oo2.O00000Oo == 12) {
                            this.f168a = new ie();
                            this.f168a.O000000o(esd);
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 3:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.b = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 4:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.c = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 5:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.d = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 6:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.e = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 7:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.g = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 9:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.h = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 10:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.i = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 11:
                        if (O00000Oo2.O00000Oo != 2) {
                            ese.O000000o(esd, O00000Oo2.O00000Oo);
                            break;
                        } else {
                            this.f171a = esd.O00000oo();
                            this.f170a.set(0, true);
                            break;
                        }
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        if (O00000Oo2.O00000Oo == 10) {
                            this.f6446a = esd.O0000Oo();
                            this.f170a.set(1, true);
                            break;
                        }
                    default:
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                }
            } else {
                O0000o00();
                return;
            }
        }
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
        iv ivVar = (iv) obj;
        if (!getClass().equals(ivVar.getClass())) {
            return getClass().getName().compareTo(ivVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(ivVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o13 = erw.O000000o(this.f169a, ivVar.f169a)) != 0) {
            return O000000o13;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(ivVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o12 = erw.O000000o(this.f168a, ivVar.f168a)) != 0) {
            return O000000o12;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ivVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o11 = erw.O000000o(this.b, ivVar.b)) != 0) {
            return O000000o11;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(ivVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o10 = erw.O000000o(this.c, ivVar.c)) != 0) {
            return O000000o10;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(ivVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o9 = erw.O000000o(this.d, ivVar.d)) != 0) {
            return O000000o9;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(ivVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o8 = erw.O000000o(this.e, ivVar.e)) != 0) {
            return O000000o8;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(ivVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000O0o() && (O000000o7 = erw.O000000o(this.f, ivVar.f)) != 0) {
            return O000000o7;
        }
        int compareTo8 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(ivVar.O0000OOo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000OOo() && (O000000o6 = erw.O000000o(this.g, ivVar.g)) != 0) {
            return O000000o6;
        }
        int compareTo9 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(ivVar.O0000Oo0()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000Oo0() && (O000000o5 = erw.O000000o(this.h, ivVar.h)) != 0) {
            return O000000o5;
        }
        int compareTo10 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(ivVar.O0000Oo()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (O0000Oo() && (O000000o4 = erw.O000000o(this.i, ivVar.i)) != 0) {
            return O000000o4;
        }
        int compareTo11 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(ivVar.O0000OoO()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (O0000OoO() && (O000000o3 = erw.O000000o(this.f171a, ivVar.f171a)) != 0) {
            return O000000o3;
        }
        int compareTo12 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(ivVar.O0000Ooo()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!O0000Ooo() || (O000000o2 = erw.O000000o(this.f6446a, ivVar.f6446a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
