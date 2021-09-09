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

public class ij implements ja<ij, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6421O000000o = new esg("XmPushActionCommand");
    private static final esa O00000Oo = new esa("", (byte) 12, 2);
    private static final esa O00000o = new esa("", (byte) 11, 4);
    private static final esa O00000o0 = new esa("", (byte) 11, 3);
    private static final esa O00000oO = new esa("", (byte) 11, 5);
    private static final esa O00000oo = new esa("", (byte) 15, 6);
    private static final esa O0000O0o = new esa("", (byte) 11, 7);
    private static final esa O0000OOo = new esa("", (byte) 11, 9);
    private static final esa O0000Oo = new esa("", (byte) 2, 11);
    private static final esa O0000Oo0 = new esa("", (byte) 2, 10);
    private static final esa O0000OoO = new esa("", (byte) 10, 12);

    /* renamed from: a  reason: collision with root package name */
    public long f6422a;

    /* renamed from: a  reason: collision with other field name */
    public ie f111a;

    /* renamed from: a  reason: collision with other field name */
    public String f112a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f113a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public List<String> f114a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f115a = false;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f116b = true;
    public String c;
    public String d;
    public String e;

    private boolean O000000o() {
        return this.f111a != null;
    }

    private boolean O00000Oo() {
        return this.f112a != null;
    }

    private boolean O00000o() {
        return this.c != null;
    }

    private boolean O00000o0() {
        return this.b != null;
    }

    private boolean O00000oO() {
        return this.f114a != null;
    }

    private boolean O00000oo() {
        return this.d != null;
    }

    private boolean O0000O0o() {
        return this.e != null;
    }

    private boolean O0000OOo() {
        return this.f113a.get(0);
    }

    private boolean O0000Oo() {
        return this.f113a.get(2);
    }

    private boolean O0000Oo0() {
        return this.f113a.get(1);
    }

    private void O0000OoO() {
        if (this.f112a == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new jm("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public final void O00000Oo(esd esd) {
        O0000OoO();
        if (this.f111a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            this.f111a.O00000Oo(esd);
        }
        if (this.f112a != null) {
            esd.O000000o(O00000o0);
            esd.O000000o(this.f112a);
        }
        if (this.b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.b);
        }
        if (this.c != null) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.c);
        }
        if (this.f114a != null && O00000oO()) {
            esd.O000000o(O00000oo);
            esd.O000000o(new esb((byte) 11, this.f114a.size()));
            for (String O000000o2 : this.f114a) {
                esd.O000000o(O000000o2);
            }
        }
        if (this.d != null && O00000oo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.d);
        }
        if (this.e != null && O0000O0o()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.e);
        }
        if (O0000OOo()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(this.f115a);
        }
        if (O0000Oo0()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.f116b);
        }
        if (O0000Oo()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.f6422a);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (O000000o()) {
            sb.append("target:");
            ie ieVar = this.f111a;
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
        String str = this.f112a;
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
        if (O00000oO()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f114a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("packageName:");
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
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f115a);
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f116b);
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f6422a);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        ij ijVar;
        if (obj == null || !(obj instanceof ij) || (ijVar = (ij) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = ijVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f111a.O000000o(ijVar.f111a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = ijVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f112a.equals(ijVar.f112a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = ijVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.b.equals(ijVar.b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = ijVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.c.equals(ijVar.c))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = ijVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || !this.f114a.equals(ijVar.f114a))) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = ijVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.d.equals(ijVar.d))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = ijVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.e.equals(ijVar.e))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = ijVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || this.f115a != ijVar.f115a)) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = ijVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || this.f116b != ijVar.f116b)) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = ijVar.O0000Oo();
        if (O0000Oo2 || O0000Oo3) {
            return O0000Oo2 && O0000Oo3 && this.f6422a == ijVar.f6422a;
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
                    case 2:
                        if (O00000Oo2.O00000Oo == 12) {
                            this.f111a = new ie();
                            this.f111a.O000000o(esd);
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 3:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f112a = esd.O0000Ooo();
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
                        if (O00000Oo2.O00000Oo == 15) {
                            esb O00000o2 = esd.O00000o();
                            this.f114a = new ArrayList(O00000o2.O00000Oo);
                            for (int i = 0; i < O00000o2.O00000Oo; i++) {
                                this.f114a.add(esd.O0000Ooo());
                            }
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
                    default:
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
                        if (O00000Oo2.O00000Oo != 2) {
                            ese.O000000o(esd, O00000Oo2.O00000Oo);
                            break;
                        } else {
                            this.f115a = esd.O00000oo();
                            this.f113a.set(0, true);
                            break;
                        }
                    case 11:
                        if (O00000Oo2.O00000Oo != 2) {
                            ese.O000000o(esd, O00000Oo2.O00000Oo);
                            break;
                        } else {
                            this.f116b = esd.O00000oo();
                            this.f113a.set(1, true);
                            break;
                        }
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        if (O00000Oo2.O00000Oo == 10) {
                            this.f6422a = esd.O0000Oo();
                            this.f113a.set(2, true);
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                }
            } else {
                O0000OoO();
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
        ij ijVar = (ij) obj;
        if (!getClass().equals(ijVar.getClass())) {
            return getClass().getName().compareTo(ijVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(ijVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o11 = erw.O000000o(this.f111a, ijVar.f111a)) != 0) {
            return O000000o11;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(ijVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o10 = erw.O000000o(this.f112a, ijVar.f112a)) != 0) {
            return O000000o10;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ijVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o9 = erw.O000000o(this.b, ijVar.b)) != 0) {
            return O000000o9;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(ijVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o8 = erw.O000000o(this.c, ijVar.c)) != 0) {
            return O000000o8;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(ijVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o7 = erw.O000000o(this.f114a, ijVar.f114a)) != 0) {
            return O000000o7;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(ijVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o6 = erw.O000000o(this.d, ijVar.d)) != 0) {
            return O000000o6;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(ijVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000O0o() && (O000000o5 = erw.O000000o(this.e, ijVar.e)) != 0) {
            return O000000o5;
        }
        int compareTo8 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(ijVar.O0000OOo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000OOo() && (O000000o4 = erw.O000000o(this.f115a, ijVar.f115a)) != 0) {
            return O000000o4;
        }
        int compareTo9 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(ijVar.O0000Oo0()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000Oo0() && (O000000o3 = erw.O000000o(this.f116b, ijVar.f116b)) != 0) {
            return O000000o3;
        }
        int compareTo10 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(ijVar.O0000Oo()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!O0000Oo() || (O000000o2 = erw.O000000o(this.f6422a, ijVar.f6422a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
