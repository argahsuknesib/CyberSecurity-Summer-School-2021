package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import com.google.android.exoplayer2.C;
import java.io.Serializable;
import java.util.BitSet;

public class ir implements ja<ir, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6437O000000o = new esg("XmPushActionSendFeedbackResult");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 12, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 10, 6);
    private static final esa O0000O0o = new esa("", (byte) 11, 7);
    private static final esa O0000OOo = new esa("", (byte) 11, 8);

    /* renamed from: a  reason: collision with root package name */
    public long f6438a;

    /* renamed from: a  reason: collision with other field name */
    public ie f155a;

    /* renamed from: a  reason: collision with other field name */
    public String f156a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f157a = new BitSet(1);
    public String b;
    public String c;
    public String d;
    public String e;

    private boolean O000000o() {
        return this.f156a != null;
    }

    private boolean O00000Oo() {
        return this.f155a != null;
    }

    private boolean O00000o() {
        return this.c != null;
    }

    private boolean O00000o0() {
        return this.b != null;
    }

    private boolean O00000oO() {
        return this.f157a.get(0);
    }

    private boolean O00000oo() {
        return this.d != null;
    }

    private boolean O0000O0o() {
        return this.e != null;
    }

    private void O0000OOo() {
        if (this.b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public final void O00000Oo(esd esd) {
        O0000OOo();
        if (this.f156a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f156a);
        }
        if (this.f155a != null && O00000Oo()) {
            esd.O000000o(O00000o0);
            this.f155a.O00000Oo(esd);
        }
        if (this.b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.b);
        }
        if (this.c != null) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.c);
        }
        esd.O000000o(O00000oo);
        esd.O000000o(this.f6438a);
        if (this.d != null && O00000oo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.d);
        }
        if (this.e != null && O0000O0o()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.e);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        if (O000000o()) {
            sb.append("debug:");
            String str = this.f156a;
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
            ie ieVar = this.f155a;
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
        sb.append("errorCode:");
        sb.append(this.f6438a);
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
            sb.append("category:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        ir irVar;
        if (obj == null || !(obj instanceof ir) || (irVar = (ir) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = irVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f156a.equals(irVar.f156a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = irVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f155a.O000000o(irVar.f155a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = irVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.b.equals(irVar.b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = irVar.O00000o();
        if (((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.c.equals(irVar.c))) || this.f6438a != irVar.f6438a) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = irVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.d.equals(irVar.d))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = irVar.O0000O0o();
        if (O0000O0o2 || O0000O0o3) {
            return O0000O0o2 && O0000O0o3 && this.e.equals(irVar.e);
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
            if (O00000Oo2.O00000Oo == 0) {
                break;
            }
            switch (O00000Oo2.O00000o0) {
                case 1:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f156a = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 2:
                    if (O00000Oo2.O00000Oo == 12) {
                        this.f155a = new ie();
                        this.f155a.O000000o(esd);
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
                        this.f6438a = esd.O0000Oo();
                        this.f157a.set(0, true);
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
            }
        }
        if (O00000oO()) {
            O0000OOo();
            return;
        }
        throw new jm("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
    }

    public /* synthetic */ int compareTo(Object obj) {
        int O000000o2;
        int O000000o3;
        int O000000o4;
        int O000000o5;
        int O000000o6;
        int O000000o7;
        int O000000o8;
        ir irVar = (ir) obj;
        if (!getClass().equals(irVar.getClass())) {
            return getClass().getName().compareTo(irVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(irVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o8 = erw.O000000o(this.f156a, irVar.f156a)) != 0) {
            return O000000o8;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(irVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o7 = erw.O000000o(this.f155a, irVar.f155a)) != 0) {
            return O000000o7;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(irVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o6 = erw.O000000o(this.b, irVar.b)) != 0) {
            return O000000o6;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(irVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o5 = erw.O000000o(this.c, irVar.c)) != 0) {
            return O000000o5;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(irVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o4 = erw.O000000o(this.f6438a, irVar.f6438a)) != 0) {
            return O000000o4;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(irVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o3 = erw.O000000o(this.d, irVar.d)) != 0) {
            return O000000o3;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(irVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!O0000O0o() || (O000000o2 = erw.O000000o(this.e, irVar.e)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
