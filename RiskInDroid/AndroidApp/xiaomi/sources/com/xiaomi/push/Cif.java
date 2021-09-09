package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esc;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

/* renamed from: com.xiaomi.push.if  reason: invalid class name */
public class Cif implements ja<Cif, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6413O000000o = new esg("XmPushActionAckMessage");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 12, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 10, 5);
    private static final esa O0000O0o = new esa("", (byte) 11, 6);
    private static final esa O0000OOo = new esa("", (byte) 11, 7);
    private static final esa O0000Oo = new esa("", (byte) 11, 9);
    private static final esa O0000Oo0 = new esa("", (byte) 12, 8);
    private static final esa O0000OoO = new esa("", (byte) 11, 10);
    private static final esa O0000Ooo = new esa("", (byte) 2, 11);
    private static final esa O0000o = new esa("", (byte) 6, 16);
    private static final esa O0000o0 = new esa("", (byte) 11, 13);
    private static final esa O0000o00 = new esa("", (byte) 11, 12);
    private static final esa O0000o0O = new esa("", (byte) 11, 14);
    private static final esa O0000o0o = new esa("", (byte) 6, 15);
    private static final esa O0000oO = new esa("", (byte) 11, 21);
    private static final esa O0000oO0 = new esa("", (byte) 11, 20);
    private static final esa O0000oOO = new esa("", (byte) 8, 22);
    private static final esa O0000oOo = new esa("", (byte) 13, 23);

    /* renamed from: a  reason: collision with root package name */
    public int f6414a;

    /* renamed from: a  reason: collision with other field name */
    public long f97a;

    /* renamed from: a  reason: collision with other field name */
    public ie f98a;

    /* renamed from: a  reason: collision with other field name */
    public is f99a;

    /* renamed from: a  reason: collision with other field name */
    public String f100a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f101a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f102a;

    /* renamed from: a  reason: collision with other field name */
    public short f103a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f104a = false;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public short f105b;
    public String c;
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
        return this.f100a != null;
    }

    private boolean O00000Oo() {
        return this.f98a != null;
    }

    private boolean O00000o() {
        return this.c != null;
    }

    private boolean O00000o0() {
        return this.b != null;
    }

    private boolean O00000oO() {
        return this.f101a.get(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000oo() {
        this.f101a.set(0, true);
    }

    private boolean O0000O0o() {
        return this.d != null;
    }

    private boolean O0000OOo() {
        return this.e != null;
    }

    private boolean O0000Oo() {
        return this.f != null;
    }

    private boolean O0000Oo0() {
        return this.f99a != null;
    }

    private boolean O0000OoO() {
        return this.g != null;
    }

    private boolean O0000Ooo() {
        return this.f101a.get(1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000o() {
        this.f101a.set(2, true);
    }

    private boolean O0000o0() {
        return this.i != null;
    }

    private boolean O0000o00() {
        return this.h != null;
    }

    private boolean O0000o0O() {
        return this.j != null;
    }

    private boolean O0000o0o() {
        return this.f101a.get(2);
    }

    private boolean O0000oO() {
        return this.k != null;
    }

    private boolean O0000oO0() {
        return this.f101a.get(3);
    }

    private boolean O0000oOO() {
        return this.l != null;
    }

    private boolean O0000oOo() {
        return this.f101a.get(4);
    }

    private void O0000oo() {
        if (this.b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    private boolean O0000oo0() {
        return this.f102a != null;
    }

    public final Cif O000000o(long j2) {
        this.f97a = j2;
        O00000oo();
        return this;
    }

    public final Cif O000000o(short s) {
        this.f103a = s;
        O0000o();
        return this;
    }

    public final void O00000Oo(esd esd) {
        O0000oo();
        if (this.f100a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f100a);
        }
        if (this.f98a != null && O00000Oo()) {
            esd.O000000o(O00000o0);
            this.f98a.O00000Oo(esd);
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
        esd.O000000o(this.f97a);
        if (this.d != null && O0000O0o()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.d);
        }
        if (this.e != null && O0000OOo()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.e);
        }
        if (this.f99a != null && O0000Oo0()) {
            esd.O000000o(O0000Oo0);
            this.f99a.O00000Oo(esd);
        }
        if (this.f != null && O0000Oo()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.f);
        }
        if (this.g != null && O0000OoO()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.g);
        }
        if (O0000Ooo()) {
            esd.O000000o(O0000Ooo);
            esd.O000000o(this.f104a);
        }
        if (this.h != null && O0000o00()) {
            esd.O000000o(O0000o00);
            esd.O000000o(this.h);
        }
        if (this.i != null && O0000o0()) {
            esd.O000000o(O0000o0);
            esd.O000000o(this.i);
        }
        if (this.j != null && O0000o0O()) {
            esd.O000000o(O0000o0O);
            esd.O000000o(this.j);
        }
        if (O0000o0o()) {
            esd.O000000o(O0000o0o);
            esd.O000000o(this.f103a);
        }
        if (O0000oO0()) {
            esd.O000000o(O0000o);
            esd.O000000o(this.f105b);
        }
        if (this.k != null && O0000oO()) {
            esd.O000000o(O0000oO0);
            esd.O000000o(this.k);
        }
        if (this.l != null && O0000oOO()) {
            esd.O000000o(O0000oO);
            esd.O000000o(this.l);
        }
        if (O0000oOo()) {
            esd.O000000o(O0000oOO);
            esd.O000000o(this.f6414a);
        }
        if (this.f102a != null && O0000oo0()) {
            esd.O000000o(O0000oOo);
            esd.O000000o(new esc((byte) 11, (byte) 11, this.f102a.size()));
            for (Map.Entry next : this.f102a.entrySet()) {
                esd.O000000o((String) next.getKey());
                esd.O000000o((String) next.getValue());
            }
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        if (O000000o()) {
            sb.append("debug:");
            String str = this.f100a;
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
            ie ieVar = this.f98a;
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
        sb.append("messageTs:");
        sb.append(this.f97a);
        if (O0000O0o()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("request:");
            is isVar = this.f99a;
            if (isVar == null) {
                sb.append("null");
            } else {
                sb.append(isVar);
            }
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (O0000Ooo()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f104a);
        }
        if (O0000o00()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (O0000o0()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
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
            sb.append("deviceStatus:");
            sb.append((int) this.f103a);
        }
        if (O0000oO0()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f105b);
        }
        if (O0000oO()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (O0000oOO()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (O0000oOo()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f6414a);
        }
        if (O0000oo0()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f102a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        Cif ifVar;
        if (obj == null || !(obj instanceof Cif) || (ifVar = (Cif) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = ifVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f100a.equals(ifVar.f100a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = ifVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f98a.O000000o(ifVar.f98a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = ifVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.b.equals(ifVar.b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = ifVar.O00000o();
        if (((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.c.equals(ifVar.c))) || this.f97a != ifVar.f97a) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = ifVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.d.equals(ifVar.d))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = ifVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.e.equals(ifVar.e))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = ifVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || !this.f99a.O000000o(ifVar.f99a))) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = ifVar.O0000Oo();
        if ((O0000Oo2 || O0000Oo3) && (!O0000Oo2 || !O0000Oo3 || !this.f.equals(ifVar.f))) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = ifVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || !this.g.equals(ifVar.g))) {
            return false;
        }
        boolean O0000Ooo2 = O0000Ooo();
        boolean O0000Ooo3 = ifVar.O0000Ooo();
        if ((O0000Ooo2 || O0000Ooo3) && (!O0000Ooo2 || !O0000Ooo3 || this.f104a != ifVar.f104a)) {
            return false;
        }
        boolean O0000o002 = O0000o00();
        boolean O0000o003 = ifVar.O0000o00();
        if ((O0000o002 || O0000o003) && (!O0000o002 || !O0000o003 || !this.h.equals(ifVar.h))) {
            return false;
        }
        boolean O0000o02 = O0000o0();
        boolean O0000o03 = ifVar.O0000o0();
        if ((O0000o02 || O0000o03) && (!O0000o02 || !O0000o03 || !this.i.equals(ifVar.i))) {
            return false;
        }
        boolean O0000o0O2 = O0000o0O();
        boolean O0000o0O3 = ifVar.O0000o0O();
        if ((O0000o0O2 || O0000o0O3) && (!O0000o0O2 || !O0000o0O3 || !this.j.equals(ifVar.j))) {
            return false;
        }
        boolean O0000o0o2 = O0000o0o();
        boolean O0000o0o3 = ifVar.O0000o0o();
        if ((O0000o0o2 || O0000o0o3) && (!O0000o0o2 || !O0000o0o3 || this.f103a != ifVar.f103a)) {
            return false;
        }
        boolean O0000oO02 = O0000oO0();
        boolean O0000oO03 = ifVar.O0000oO0();
        if ((O0000oO02 || O0000oO03) && (!O0000oO02 || !O0000oO03 || this.f105b != ifVar.f105b)) {
            return false;
        }
        boolean O0000oO2 = O0000oO();
        boolean O0000oO3 = ifVar.O0000oO();
        if ((O0000oO2 || O0000oO3) && (!O0000oO2 || !O0000oO3 || !this.k.equals(ifVar.k))) {
            return false;
        }
        boolean O0000oOO2 = O0000oOO();
        boolean O0000oOO3 = ifVar.O0000oOO();
        if ((O0000oOO2 || O0000oOO3) && (!O0000oOO2 || !O0000oOO3 || !this.l.equals(ifVar.l))) {
            return false;
        }
        boolean O0000oOo2 = O0000oOo();
        boolean O0000oOo3 = ifVar.O0000oOo();
        if ((O0000oOo2 || O0000oOo3) && (!O0000oOo2 || !O0000oOo3 || this.f6414a != ifVar.f6414a)) {
            return false;
        }
        boolean O0000oo0 = O0000oo0();
        boolean O0000oo02 = ifVar.O0000oo0();
        if (O0000oo0 || O0000oo02) {
            return O0000oo0 && O0000oo02 && this.f102a.equals(ifVar.f102a);
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
                        this.f100a = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 2:
                    if (O00000Oo2.O00000Oo == 12) {
                        this.f98a = new ie();
                        this.f98a.O000000o(esd);
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
                    if (O00000Oo2.O00000Oo == 10) {
                        this.f97a = esd.O0000Oo();
                        O00000oo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 6:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.d = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 7:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.e = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (O00000Oo2.O00000Oo == 12) {
                        this.f99a = new is();
                        this.f99a.O000000o(esd);
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
                    if (O00000Oo2.O00000Oo == 2) {
                        this.f104a = esd.O00000oo();
                        this.f101a.set(1, true);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.h = esd.O0000Ooo();
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
                    if (O00000Oo2.O00000Oo == 11) {
                        this.j = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    if (O00000Oo2.O00000Oo == 6) {
                        this.f103a = esd.O0000OOo();
                        O0000o();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 16:
                    if (O00000Oo2.O00000Oo == 6) {
                        this.f105b = esd.O0000OOo();
                        this.f101a.set(3, true);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 17:
                case 18:
                case 19:
                default:
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 20:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.k = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 21:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.l = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 22:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.f6414a = esd.O0000Oo0();
                        this.f101a.set(4, true);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 23:
                    if (O00000Oo2.O00000Oo == 13) {
                        esc O00000o02 = esd.O00000o0();
                        this.f102a = new HashMap(O00000o02.O00000o0 * 2);
                        for (int i2 = 0; i2 < O00000o02.O00000o0; i2++) {
                            this.f102a.put(esd.O0000Ooo(), esd.O0000Ooo());
                        }
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
            }
        }
        if (O00000oO()) {
            O0000oo();
            return;
        }
        throw new jm("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
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
        int O000000o20;
        int O000000o21;
        Cif ifVar = (Cif) obj;
        if (!getClass().equals(ifVar.getClass())) {
            return getClass().getName().compareTo(ifVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(ifVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o21 = erw.O000000o(this.f100a, ifVar.f100a)) != 0) {
            return O000000o21;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(ifVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o20 = erw.O000000o(this.f98a, ifVar.f98a)) != 0) {
            return O000000o20;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ifVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o19 = erw.O000000o(this.b, ifVar.b)) != 0) {
            return O000000o19;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(ifVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o18 = erw.O000000o(this.c, ifVar.c)) != 0) {
            return O000000o18;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(ifVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o17 = erw.O000000o(this.f97a, ifVar.f97a)) != 0) {
            return O000000o17;
        }
        int compareTo6 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(ifVar.O0000O0o()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O0000O0o() && (O000000o16 = erw.O000000o(this.d, ifVar.d)) != 0) {
            return O000000o16;
        }
        int compareTo7 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(ifVar.O0000OOo()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000OOo() && (O000000o15 = erw.O000000o(this.e, ifVar.e)) != 0) {
            return O000000o15;
        }
        int compareTo8 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(ifVar.O0000Oo0()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000Oo0() && (O000000o14 = erw.O000000o(this.f99a, ifVar.f99a)) != 0) {
            return O000000o14;
        }
        int compareTo9 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(ifVar.O0000Oo()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000Oo() && (O000000o13 = erw.O000000o(this.f, ifVar.f)) != 0) {
            return O000000o13;
        }
        int compareTo10 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(ifVar.O0000OoO()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (O0000OoO() && (O000000o12 = erw.O000000o(this.g, ifVar.g)) != 0) {
            return O000000o12;
        }
        int compareTo11 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(ifVar.O0000Ooo()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (O0000Ooo() && (O000000o11 = erw.O000000o(this.f104a, ifVar.f104a)) != 0) {
            return O000000o11;
        }
        int compareTo12 = Boolean.valueOf(O0000o00()).compareTo(Boolean.valueOf(ifVar.O0000o00()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (O0000o00() && (O000000o10 = erw.O000000o(this.h, ifVar.h)) != 0) {
            return O000000o10;
        }
        int compareTo13 = Boolean.valueOf(O0000o0()).compareTo(Boolean.valueOf(ifVar.O0000o0()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (O0000o0() && (O000000o9 = erw.O000000o(this.i, ifVar.i)) != 0) {
            return O000000o9;
        }
        int compareTo14 = Boolean.valueOf(O0000o0O()).compareTo(Boolean.valueOf(ifVar.O0000o0O()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (O0000o0O() && (O000000o8 = erw.O000000o(this.j, ifVar.j)) != 0) {
            return O000000o8;
        }
        int compareTo15 = Boolean.valueOf(O0000o0o()).compareTo(Boolean.valueOf(ifVar.O0000o0o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (O0000o0o() && (O000000o7 = erw.O000000o(this.f103a, ifVar.f103a)) != 0) {
            return O000000o7;
        }
        int compareTo16 = Boolean.valueOf(O0000oO0()).compareTo(Boolean.valueOf(ifVar.O0000oO0()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (O0000oO0() && (O000000o6 = erw.O000000o(this.f105b, ifVar.f105b)) != 0) {
            return O000000o6;
        }
        int compareTo17 = Boolean.valueOf(O0000oO()).compareTo(Boolean.valueOf(ifVar.O0000oO()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (O0000oO() && (O000000o5 = erw.O000000o(this.k, ifVar.k)) != 0) {
            return O000000o5;
        }
        int compareTo18 = Boolean.valueOf(O0000oOO()).compareTo(Boolean.valueOf(ifVar.O0000oOO()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (O0000oOO() && (O000000o4 = erw.O000000o(this.l, ifVar.l)) != 0) {
            return O000000o4;
        }
        int compareTo19 = Boolean.valueOf(O0000oOo()).compareTo(Boolean.valueOf(ifVar.O0000oOo()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (O0000oOo() && (O000000o3 = erw.O000000o(this.f6414a, ifVar.f6414a)) != 0) {
            return O000000o3;
        }
        int compareTo20 = Boolean.valueOf(O0000oo0()).compareTo(Boolean.valueOf(ifVar.O0000oo0()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (!O0000oo0() || (O000000o2 = erw.O000000o(this.f102a, ifVar.f102a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
