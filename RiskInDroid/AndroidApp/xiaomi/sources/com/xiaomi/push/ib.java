package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.Serializable;
import java.util.BitSet;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class ib implements ja<ib, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6406O000000o = new esg("PushMessage");
    private static final esa O00000Oo = new esa("", (byte) 12, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 11, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 10, 5);
    private static final esa O0000O0o = new esa("", (byte) 10, 6);
    private static final esa O0000OOo = new esa("", (byte) 11, 7);
    private static final esa O0000Oo = new esa("", (byte) 11, 9);
    private static final esa O0000Oo0 = new esa("", (byte) 11, 8);
    private static final esa O0000OoO = new esa("", (byte) 11, 10);
    private static final esa O0000Ooo = new esa("", (byte) 11, 11);
    private static final esa O0000o = new esa("", (byte) 10, 16);
    private static final esa O0000o0 = new esa("", (byte) 11, 13);
    private static final esa O0000o00 = new esa("", (byte) 12, 12);
    private static final esa O0000o0O = new esa("", (byte) 2, 14);
    private static final esa O0000o0o = new esa("", (byte) 11, 15);
    private static final esa O0000oO = new esa("", (byte) 11, 21);
    private static final esa O0000oO0 = new esa("", (byte) 11, 20);

    /* renamed from: a  reason: collision with root package name */
    public long f6407a;

    /* renamed from: a  reason: collision with other field name */
    public ic f76a;

    /* renamed from: a  reason: collision with other field name */
    public ie f77a;

    /* renamed from: a  reason: collision with other field name */
    public String f78a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f79a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f80a = false;
    public long b;

    /* renamed from: b  reason: collision with other field name */
    public String f81b;
    public long c;

    /* renamed from: c  reason: collision with other field name */
    public String f82c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    private boolean O000000o() {
        return this.f77a != null;
    }

    private boolean O00000Oo() {
        return this.f78a != null;
    }

    private boolean O00000o() {
        return this.f82c != null;
    }

    private boolean O00000o0() {
        return this.f81b != null;
    }

    private boolean O00000oO() {
        return this.f79a.get(0);
    }

    private boolean O00000oo() {
        return this.f79a.get(1);
    }

    private boolean O0000O0o() {
        return this.d != null;
    }

    private boolean O0000OOo() {
        return this.e != null;
    }

    private boolean O0000Oo() {
        return this.g != null;
    }

    private boolean O0000Oo0() {
        return this.f != null;
    }

    private boolean O0000OoO() {
        return this.h != null;
    }

    private boolean O0000Ooo() {
        return this.f76a != null;
    }

    private boolean O0000o() {
        return this.k != null;
    }

    private boolean O0000o0() {
        return this.f79a.get(2);
    }

    private boolean O0000o00() {
        return this.i != null;
    }

    private boolean O0000o0O() {
        return this.j != null;
    }

    private boolean O0000o0o() {
        return this.f79a.get(3);
    }

    private void O0000oO() {
        if (this.f78a == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f81b == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f82c == null) {
            throw new jm("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    private boolean O0000oO0() {
        return this.l != null;
    }

    public final boolean O000000o(ib ibVar) {
        if (ibVar == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = ibVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f77a.O000000o(ibVar.f77a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = ibVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f78a.equals(ibVar.f78a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = ibVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.f81b.equals(ibVar.f81b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = ibVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.f82c.equals(ibVar.f82c))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = ibVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || this.f6407a != ibVar.f6407a)) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = ibVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || this.b != ibVar.b)) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = ibVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.d.equals(ibVar.d))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = ibVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.e.equals(ibVar.e))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = ibVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || !this.f.equals(ibVar.f))) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = ibVar.O0000Oo();
        if ((O0000Oo2 || O0000Oo3) && (!O0000Oo2 || !O0000Oo3 || !this.g.equals(ibVar.g))) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = ibVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || !this.h.equals(ibVar.h))) {
            return false;
        }
        boolean O0000Ooo2 = O0000Ooo();
        boolean O0000Ooo3 = ibVar.O0000Ooo();
        if ((O0000Ooo2 || O0000Ooo3) && (!O0000Ooo2 || !O0000Ooo3 || !this.f76a.O000000o(ibVar.f76a))) {
            return false;
        }
        boolean O0000o002 = O0000o00();
        boolean O0000o003 = ibVar.O0000o00();
        if ((O0000o002 || O0000o003) && (!O0000o002 || !O0000o003 || !this.i.equals(ibVar.i))) {
            return false;
        }
        boolean O0000o02 = O0000o0();
        boolean O0000o03 = ibVar.O0000o0();
        if ((O0000o02 || O0000o03) && (!O0000o02 || !O0000o03 || this.f80a != ibVar.f80a)) {
            return false;
        }
        boolean O0000o0O2 = O0000o0O();
        boolean O0000o0O3 = ibVar.O0000o0O();
        if ((O0000o0O2 || O0000o0O3) && (!O0000o0O2 || !O0000o0O3 || !this.j.equals(ibVar.j))) {
            return false;
        }
        boolean O0000o0o2 = O0000o0o();
        boolean O0000o0o3 = ibVar.O0000o0o();
        if ((O0000o0o2 || O0000o0o3) && (!O0000o0o2 || !O0000o0o3 || this.c != ibVar.c)) {
            return false;
        }
        boolean O0000o2 = O0000o();
        boolean O0000o3 = ibVar.O0000o();
        if ((O0000o2 || O0000o3) && (!O0000o2 || !O0000o3 || !this.k.equals(ibVar.k))) {
            return false;
        }
        boolean O0000oO02 = O0000oO0();
        boolean O0000oO03 = ibVar.O0000oO0();
        if (O0000oO02 || O0000oO03) {
            return O0000oO02 && O0000oO03 && this.l.equals(ibVar.l);
        }
        return true;
    }

    public final void O00000Oo(esd esd) {
        O0000oO();
        if (this.f77a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            this.f77a.O00000Oo(esd);
        }
        if (this.f78a != null) {
            esd.O000000o(O00000o0);
            esd.O000000o(this.f78a);
        }
        if (this.f81b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.f81b);
        }
        if (this.f82c != null) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.f82c);
        }
        if (O00000oO()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.f6407a);
        }
        if (O00000oo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.b);
        }
        if (this.d != null && O0000O0o()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.d);
        }
        if (this.e != null && O0000OOo()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(this.e);
        }
        if (this.f != null && O0000Oo0()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.f);
        }
        if (this.g != null && O0000Oo()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.g);
        }
        if (this.h != null && O0000OoO()) {
            esd.O000000o(O0000Ooo);
            esd.O000000o(this.h);
        }
        if (this.f76a != null && O0000Ooo()) {
            esd.O000000o(O0000o00);
            this.f76a.O00000Oo(esd);
        }
        if (this.i != null && O0000o00()) {
            esd.O000000o(O0000o0);
            esd.O000000o(this.i);
        }
        if (O0000o0()) {
            esd.O000000o(O0000o0O);
            esd.O000000o(this.f80a);
        }
        if (this.j != null && O0000o0O()) {
            esd.O000000o(O0000o0o);
            esd.O000000o(this.j);
        }
        if (O0000o0o()) {
            esd.O000000o(O0000o);
            esd.O000000o(this.c);
        }
        if (this.k != null && O0000o()) {
            esd.O000000o(O0000oO0);
            esd.O000000o(this.k);
        }
        if (this.l != null && O0000oO0()) {
            esd.O000000o(O0000oO);
            esd.O000000o(this.l);
        }
        esd.O000000o();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return O000000o((ib) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (O000000o()) {
            sb.append("to:");
            ie ieVar = this.f77a;
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
        String str = this.f78a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f81b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f82c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (O00000oO()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f6407a);
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.b);
        }
        if (O0000O0o()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (O0000Ooo()) {
            sb.append(", ");
            sb.append("metaInfo:");
            ic icVar = this.f76a;
            if (icVar == null) {
                sb.append("null");
            } else {
                sb.append(icVar);
            }
        }
        if (O0000o00()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (O0000o0()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f80a);
        }
        if (O0000o0O()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (O0000o0o()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.c);
        }
        if (O0000o()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (O0000oO0()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
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
                short s = O00000Oo2.O00000o0;
                if (s != 20) {
                    if (s != 21) {
                        switch (s) {
                            case 1:
                                if (O00000Oo2.O00000Oo == 12) {
                                    this.f77a = new ie();
                                    this.f77a.O000000o(esd);
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case 2:
                                if (O00000Oo2.O00000Oo == 11) {
                                    this.f78a = esd.O0000Ooo();
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case 3:
                                if (O00000Oo2.O00000Oo == 11) {
                                    this.f81b = esd.O0000Ooo();
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case 4:
                                if (O00000Oo2.O00000Oo == 11) {
                                    this.f82c = esd.O0000Ooo();
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case 5:
                                if (O00000Oo2.O00000Oo != 10) {
                                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                                    break;
                                } else {
                                    this.f6407a = esd.O0000Oo();
                                    this.f79a.set(0, true);
                                    break;
                                }
                            case 6:
                                if (O00000Oo2.O00000Oo == 10) {
                                    this.b = esd.O0000Oo();
                                    this.f79a.set(1, true);
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
                            case 11:
                                if (O00000Oo2.O00000Oo == 11) {
                                    this.h = esd.O0000Ooo();
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                                if (O00000Oo2.O00000Oo == 12) {
                                    this.f76a = new ic();
                                    this.f76a.O000000o(esd);
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case 13:
                                if (O00000Oo2.O00000Oo == 11) {
                                    this.i = esd.O0000Ooo();
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case 14:
                                if (O00000Oo2.O00000Oo == 2) {
                                    this.f80a = esd.O00000oo();
                                    this.f79a.set(2, true);
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case GmsLogger.MAX_PII_TAG_LENGTH:
                                if (O00000Oo2.O00000Oo == 11) {
                                    this.j = esd.O0000Ooo();
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case 16:
                                if (O00000Oo2.O00000Oo == 10) {
                                    this.c = esd.O0000Oo();
                                    this.f79a.set(3, true);
                                    break;
                                }
                            default:
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                        }
                    } else if (O00000Oo2.O00000Oo == 11) {
                        this.l = esd.O0000Ooo();
                    }
                } else if (O00000Oo2.O00000Oo == 11) {
                    this.k = esd.O0000Ooo();
                }
                ese.O000000o(esd, O00000Oo2.O00000Oo);
            } else {
                O0000oO();
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
        int O000000o14;
        int O000000o15;
        int O000000o16;
        int O000000o17;
        int O000000o18;
        int O000000o19;
        ib ibVar = (ib) obj;
        if (!getClass().equals(ibVar.getClass())) {
            return getClass().getName().compareTo(ibVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(ibVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o19 = erw.O000000o(this.f77a, ibVar.f77a)) != 0) {
            return O000000o19;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(ibVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o18 = erw.O000000o(this.f78a, ibVar.f78a)) != 0) {
            return O000000o18;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ibVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o17 = erw.O000000o(this.f81b, ibVar.f81b)) != 0) {
            return O000000o17;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(ibVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o16 = erw.O000000o(this.f82c, ibVar.f82c)) != 0) {
            return O000000o16;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(ibVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o15 = erw.O000000o(this.f6407a, ibVar.f6407a)) != 0) {
            return O000000o15;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(ibVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o14 = erw.O000000o(this.b, ibVar.b)) != 0) {
            return O000000o14;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(ibVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000O0o() && (O000000o13 = erw.O000000o(this.d, ibVar.d)) != 0) {
            return O000000o13;
        }
        int compareTo8 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(ibVar.O0000OOo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000OOo() && (O000000o12 = erw.O000000o(this.e, ibVar.e)) != 0) {
            return O000000o12;
        }
        int compareTo9 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(ibVar.O0000Oo0()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000Oo0() && (O000000o11 = erw.O000000o(this.f, ibVar.f)) != 0) {
            return O000000o11;
        }
        int compareTo10 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(ibVar.O0000Oo()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (O0000Oo() && (O000000o10 = erw.O000000o(this.g, ibVar.g)) != 0) {
            return O000000o10;
        }
        int compareTo11 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(ibVar.O0000OoO()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (O0000OoO() && (O000000o9 = erw.O000000o(this.h, ibVar.h)) != 0) {
            return O000000o9;
        }
        int compareTo12 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(ibVar.O0000Ooo()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (O0000Ooo() && (O000000o8 = erw.O000000o(this.f76a, ibVar.f76a)) != 0) {
            return O000000o8;
        }
        int compareTo13 = Boolean.valueOf(O0000o00()).compareTo(Boolean.valueOf(ibVar.O0000o00()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (O0000o00() && (O000000o7 = erw.O000000o(this.i, ibVar.i)) != 0) {
            return O000000o7;
        }
        int compareTo14 = Boolean.valueOf(O0000o0()).compareTo(Boolean.valueOf(ibVar.O0000o0()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (O0000o0() && (O000000o6 = erw.O000000o(this.f80a, ibVar.f80a)) != 0) {
            return O000000o6;
        }
        int compareTo15 = Boolean.valueOf(O0000o0O()).compareTo(Boolean.valueOf(ibVar.O0000o0O()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (O0000o0O() && (O000000o5 = erw.O000000o(this.j, ibVar.j)) != 0) {
            return O000000o5;
        }
        int compareTo16 = Boolean.valueOf(O0000o0o()).compareTo(Boolean.valueOf(ibVar.O0000o0o()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (O0000o0o() && (O000000o4 = erw.O000000o(this.c, ibVar.c)) != 0) {
            return O000000o4;
        }
        int compareTo17 = Boolean.valueOf(O0000o()).compareTo(Boolean.valueOf(ibVar.O0000o()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (O0000o() && (O000000o3 = erw.O000000o(this.k, ibVar.k)) != 0) {
            return O000000o3;
        }
        int compareTo18 = Boolean.valueOf(O0000oO0()).compareTo(Boolean.valueOf(ibVar.O0000oO0()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!O0000oO0() || (O000000o2 = erw.O000000o(this.l, ibVar.l)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
