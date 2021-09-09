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
import java.util.BitSet;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class ik implements ja<ik, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6423O000000o = new esg("XmPushActionCommandResult");
    private static final esa O00000Oo = new esa("", (byte) 12, 2);
    private static final esa O00000o = new esa("", (byte) 11, 4);
    private static final esa O00000o0 = new esa("", (byte) 11, 3);
    private static final esa O00000oO = new esa("", (byte) 11, 5);
    private static final esa O00000oo = new esa("", (byte) 10, 7);
    private static final esa O0000O0o = new esa("", (byte) 11, 8);
    private static final esa O0000OOo = new esa("", (byte) 11, 9);
    private static final esa O0000Oo = new esa("", (byte) 11, 12);
    private static final esa O0000Oo0 = new esa("", (byte) 15, 10);
    private static final esa O0000OoO = new esa("", (byte) 2, 13);

    /* renamed from: a  reason: collision with root package name */
    public long f6424a;

    /* renamed from: a  reason: collision with other field name */
    public ie f117a;

    /* renamed from: a  reason: collision with other field name */
    public String f118a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f119a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public List<String> f120a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f121a = true;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    private boolean O000000o() {
        return this.f117a != null;
    }

    private boolean O00000Oo() {
        return this.f118a != null;
    }

    private boolean O00000o() {
        return this.c != null;
    }

    private boolean O00000o0() {
        return this.b != null;
    }

    private boolean O00000oO() {
        return this.f119a.get(0);
    }

    private boolean O00000oo() {
        return this.d != null;
    }

    private boolean O0000O0o() {
        return this.e != null;
    }

    private boolean O0000OOo() {
        return this.f120a != null;
    }

    private boolean O0000Oo() {
        return this.f119a.get(1);
    }

    private boolean O0000Oo0() {
        return this.f != null;
    }

    private void O0000OoO() {
        if (this.f118a == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new jm("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public final void O00000Oo(esd esd) {
        O0000OoO();
        if (this.f117a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            this.f117a.O00000Oo(esd);
        }
        if (this.f118a != null) {
            esd.O000000o(O00000o0);
            esd.O000000o(this.f118a);
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
        esd.O000000o(this.f6424a);
        if (this.d != null && O00000oo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.d);
        }
        if (this.e != null && O0000O0o()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.e);
        }
        if (this.f120a != null && O0000OOo()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(new esb((byte) 11, this.f120a.size()));
            for (String O000000o2 : this.f120a) {
                esd.O000000o(O000000o2);
            }
        }
        if (this.f != null && O0000Oo0()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.f);
        }
        if (O0000Oo()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.f121a);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (O000000o()) {
            sb.append("target:");
            ie ieVar = this.f117a;
            if (ieVar == null) {
                sb.append("null");
            } else {
                sb.append(ieVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f118a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f6424a);
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
            sb.append("packageName:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f120a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f121a);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        ik ikVar;
        if (obj == null || !(obj instanceof ik) || (ikVar = (ik) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = ikVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f117a.O000000o(ikVar.f117a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = ikVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f118a.equals(ikVar.f118a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = ikVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.b.equals(ikVar.b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = ikVar.O00000o();
        if (((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.c.equals(ikVar.c))) || this.f6424a != ikVar.f6424a) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = ikVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.d.equals(ikVar.d))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = ikVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.e.equals(ikVar.e))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = ikVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.f120a.equals(ikVar.f120a))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = ikVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || !this.f.equals(ikVar.f))) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = ikVar.O0000Oo();
        if (O0000Oo2 || O0000Oo3) {
            return O0000Oo2 && O0000Oo3 && this.f121a == ikVar.f121a;
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
                case 2:
                    if (O00000Oo2.O00000Oo == 12) {
                        this.f117a = new ie();
                        this.f117a.O000000o(esd);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 3:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f118a = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 4:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.b = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 5:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.c = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 6:
                case 11:
                default:
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 7:
                    if (O00000Oo2.O00000Oo == 10) {
                        this.f6424a = esd.O0000Oo();
                        this.f119a.set(0, true);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.d = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 9:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.e = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 10:
                    if (O00000Oo2.O00000Oo == 15) {
                        esb O00000o2 = esd.O00000o();
                        this.f120a = new ArrayList(O00000o2.O00000Oo);
                        for (int i = 0; i < O00000o2.O00000Oo; i++) {
                            this.f120a.add(esd.O0000Ooo());
                        }
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 13:
                    if (O00000Oo2.O00000Oo == 2) {
                        this.f121a = esd.O00000oo();
                        this.f119a.set(1, true);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
            }
        }
        if (O00000oO()) {
            O0000OoO();
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
        int O000000o9;
        int O000000o10;
        int O000000o11;
        ik ikVar = (ik) obj;
        if (!getClass().equals(ikVar.getClass())) {
            return getClass().getName().compareTo(ikVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(ikVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o11 = erw.O000000o(this.f117a, ikVar.f117a)) != 0) {
            return O000000o11;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(ikVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o10 = erw.O000000o(this.f118a, ikVar.f118a)) != 0) {
            return O000000o10;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ikVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o9 = erw.O000000o(this.b, ikVar.b)) != 0) {
            return O000000o9;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(ikVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o8 = erw.O000000o(this.c, ikVar.c)) != 0) {
            return O000000o8;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(ikVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o7 = erw.O000000o(this.f6424a, ikVar.f6424a)) != 0) {
            return O000000o7;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(ikVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o6 = erw.O000000o(this.d, ikVar.d)) != 0) {
            return O000000o6;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(ikVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000O0o() && (O000000o5 = erw.O000000o(this.e, ikVar.e)) != 0) {
            return O000000o5;
        }
        int compareTo8 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(ikVar.O0000OOo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000OOo() && (O000000o4 = erw.O000000o(this.f120a, ikVar.f120a)) != 0) {
            return O000000o4;
        }
        int compareTo9 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(ikVar.O0000Oo0()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000Oo0() && (O000000o3 = erw.O000000o(this.f, ikVar.f)) != 0) {
            return O000000o3;
        }
        int compareTo10 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(ikVar.O0000Oo()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!O0000Oo() || (O000000o2 = erw.O000000o(this.f121a, ikVar.f121a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
