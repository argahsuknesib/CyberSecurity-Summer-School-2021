package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import com.google.android.exoplayer2.C;
import java.io.Serializable;
import java.util.BitSet;

public class iu implements ja<iu, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6443O000000o = new esg("XmPushActionSubscriptionResult");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 12, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 10, 6);
    private static final esa O0000O0o = new esa("", (byte) 11, 7);
    private static final esa O0000OOo = new esa("", (byte) 11, 8);
    private static final esa O0000Oo = new esa("", (byte) 11, 10);
    private static final esa O0000Oo0 = new esa("", (byte) 11, 9);

    /* renamed from: a  reason: collision with root package name */
    public long f6444a;

    /* renamed from: a  reason: collision with other field name */
    public ie f165a;

    /* renamed from: a  reason: collision with other field name */
    public String f166a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f167a = new BitSet(1);
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    private boolean O000000o() {
        return this.f166a != null;
    }

    private boolean O00000Oo() {
        return this.f165a != null;
    }

    private boolean O00000o() {
        return this.c != null;
    }

    private boolean O00000o0() {
        return this.b != null;
    }

    private boolean O00000oO() {
        return this.f167a.get(0);
    }

    private boolean O00000oo() {
        return this.d != null;
    }

    private boolean O0000O0o() {
        return this.e != null;
    }

    private boolean O0000OOo() {
        return this.f != null;
    }

    private void O0000Oo() {
        if (this.b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        }
    }

    private boolean O0000Oo0() {
        return this.g != null;
    }

    public final void O00000Oo(esd esd) {
        O0000Oo();
        if (this.f166a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f166a);
        }
        if (this.f165a != null && O00000Oo()) {
            esd.O000000o(O00000o0);
            this.f165a.O00000Oo(esd);
        }
        if (this.b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.b);
        }
        if (this.c != null && O00000o()) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.c);
        }
        if (O00000oO()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.f6444a);
        }
        if (this.d != null && O00000oo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.d);
        }
        if (this.e != null && O0000O0o()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.e);
        }
        if (this.f != null && O0000OOo()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(this.f);
        }
        if (this.g != null && O0000Oo0()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.g);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        if (O000000o()) {
            sb.append("debug:");
            String str = this.f166a;
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
            ie ieVar = this.f165a;
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
        if (O00000o()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (O00000oO()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f6444a);
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (O0000O0o()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000Oo0()) {
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
        iu iuVar;
        if (obj == null || !(obj instanceof iu) || (iuVar = (iu) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = iuVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f166a.equals(iuVar.f166a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = iuVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f165a.O000000o(iuVar.f165a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = iuVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.b.equals(iuVar.b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = iuVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.c.equals(iuVar.c))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = iuVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || this.f6444a != iuVar.f6444a)) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = iuVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.d.equals(iuVar.d))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = iuVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.e.equals(iuVar.e))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = iuVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.f.equals(iuVar.f))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = iuVar.O0000Oo0();
        if (O0000Oo02 || O0000Oo03) {
            return O0000Oo02 && O0000Oo03 && this.g.equals(iuVar.g);
        }
        return true;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
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
                            this.f166a = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 2:
                        if (O00000Oo2.O00000Oo == 12) {
                            this.f165a = new ie();
                            this.f165a.O000000o(esd);
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
                    default:
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 6:
                        if (O00000Oo2.O00000Oo == 10) {
                            this.f6444a = esd.O0000Oo();
                            this.f167a.set(0, true);
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 7:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.d = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.e = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 9:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 10:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.g = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                }
            } else {
                O0000Oo();
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
        iu iuVar = (iu) obj;
        if (!getClass().equals(iuVar.getClass())) {
            return getClass().getName().compareTo(iuVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(iuVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o10 = erw.O000000o(this.f166a, iuVar.f166a)) != 0) {
            return O000000o10;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(iuVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o9 = erw.O000000o(this.f165a, iuVar.f165a)) != 0) {
            return O000000o9;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(iuVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o8 = erw.O000000o(this.b, iuVar.b)) != 0) {
            return O000000o8;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(iuVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o7 = erw.O000000o(this.c, iuVar.c)) != 0) {
            return O000000o7;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(iuVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o6 = erw.O000000o(this.f6444a, iuVar.f6444a)) != 0) {
            return O000000o6;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(iuVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o5 = erw.O000000o(this.d, iuVar.d)) != 0) {
            return O000000o5;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(iuVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000O0o() && (O000000o4 = erw.O000000o(this.e, iuVar.e)) != 0) {
            return O000000o4;
        }
        int compareTo8 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(iuVar.O0000OOo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000OOo() && (O000000o3 = erw.O000000o(this.f, iuVar.f)) != 0) {
            return O000000o3;
        }
        int compareTo9 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(iuVar.O0000Oo0()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (!O0000Oo0() || (O000000o2 = erw.O000000o(this.g, iuVar.g)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
