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

public class iq implements ja<iq, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6435O000000o = new esg("XmPushActionRegistrationResult");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 12, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 10, 6);
    private static final esa O0000O0o = new esa("", (byte) 11, 7);
    private static final esa O0000OOo = new esa("", (byte) 11, 8);
    private static final esa O0000Oo = new esa("", (byte) 11, 10);
    private static final esa O0000Oo0 = new esa("", (byte) 11, 9);
    private static final esa O0000OoO = new esa("", (byte) 10, 11);
    private static final esa O0000Ooo = new esa("", (byte) 11, 12);
    private static final esa O0000o = new esa("", (byte) 11, 17);
    private static final esa O0000o0 = new esa("", (byte) 10, 14);
    private static final esa O0000o00 = new esa("", (byte) 11, 13);
    private static final esa O0000o0O = new esa("", (byte) 11, 15);
    private static final esa O0000o0o = new esa("", (byte) 8, 16);
    private static final esa O0000oO = new esa("", (byte) 11, 19);
    private static final esa O0000oO0 = new esa("", (byte) 8, 18);

    /* renamed from: a  reason: collision with root package name */
    public int f6436a;

    /* renamed from: a  reason: collision with other field name */
    public long f148a;

    /* renamed from: a  reason: collision with other field name */
    public ie f149a;

    /* renamed from: a  reason: collision with other field name */
    public String f150a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f151a = new BitSet(5);
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f152b;

    /* renamed from: b  reason: collision with other field name */
    public String f153b;
    public long c;

    /* renamed from: c  reason: collision with other field name */
    public String f154c;
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
        return this.f150a != null;
    }

    private boolean O00000Oo() {
        return this.f149a != null;
    }

    private boolean O00000o() {
        return this.f154c != null;
    }

    private boolean O00000o0() {
        return this.f153b != null;
    }

    private boolean O00000oO() {
        return this.f151a.get(0);
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

    private boolean O0000Oo() {
        return this.f151a.get(1);
    }

    private boolean O0000Oo0() {
        return this.g != null;
    }

    private boolean O0000OoO() {
        return this.h != null;
    }

    private boolean O0000Ooo() {
        return this.i != null;
    }

    private boolean O0000o() {
        return this.f151a.get(4);
    }

    private boolean O0000o0() {
        return this.j != null;
    }

    private boolean O0000o00() {
        return this.f151a.get(2);
    }

    private boolean O0000o0O() {
        return this.f151a.get(3);
    }

    private boolean O0000o0o() {
        return this.k != null;
    }

    private void O0000oO() {
        if (this.f153b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f154c == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    private boolean O0000oO0() {
        return this.l != null;
    }

    public final void O00000Oo(esd esd) {
        O0000oO();
        if (this.f150a != null && O000000o()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f150a);
        }
        if (this.f149a != null && O00000Oo()) {
            esd.O000000o(O00000o0);
            this.f149a.O00000Oo(esd);
        }
        if (this.f153b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.f153b);
        }
        if (this.f154c != null) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.f154c);
        }
        esd.O000000o(O00000oo);
        esd.O000000o(this.f148a);
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
        if (O0000Oo()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.f152b);
        }
        if (this.h != null && O0000OoO()) {
            esd.O000000o(O0000Ooo);
            esd.O000000o(this.h);
        }
        if (this.i != null && O0000Ooo()) {
            esd.O000000o(O0000o00);
            esd.O000000o(this.i);
        }
        if (O0000o00()) {
            esd.O000000o(O0000o0);
            esd.O000000o(this.c);
        }
        if (this.j != null && O0000o0()) {
            esd.O000000o(O0000o0O);
            esd.O000000o(this.j);
        }
        if (O0000o0O()) {
            esd.O000000o(O0000o0o);
            esd.O000000o(this.f6436a);
        }
        if (this.k != null && O0000o0o()) {
            esd.O000000o(O0000o);
            esd.O000000o(this.k);
        }
        if (O0000o()) {
            esd.O000000o(O0000oO0);
            esd.O000000o(this.b);
        }
        if (this.l != null && O0000oO0()) {
            esd.O000000o(O0000oO);
            esd.O000000o(this.l);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        if (O000000o()) {
            sb.append("debug:");
            String str = this.f150a;
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
            ie ieVar = this.f149a;
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
        String str2 = this.f153b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f154c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f148a);
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
            sb.append("regId:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("regSecret:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("packageName:");
            String str7 = this.g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f152b);
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (O0000Ooo()) {
            sb.append(", ");
            sb.append("clientId:");
            String str9 = this.i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (O0000o00()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.c);
        }
        if (O0000o0()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str10 = this.j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (O0000o0O()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f6436a);
        }
        if (O0000o0o()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str11 = this.k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (O0000o()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.b);
        }
        if (O0000oO0()) {
            sb.append(", ");
            sb.append("region:");
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

    public boolean equals(Object obj) {
        iq iqVar;
        if (obj == null || !(obj instanceof iq) || (iqVar = (iq) obj) == null) {
            return false;
        }
        boolean O000000o2 = O000000o();
        boolean O000000o3 = iqVar.O000000o();
        if ((O000000o2 || O000000o3) && (!O000000o2 || !O000000o3 || !this.f150a.equals(iqVar.f150a))) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = iqVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f149a.O000000o(iqVar.f149a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = iqVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.f153b.equals(iqVar.f153b))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = iqVar.O00000o();
        if (((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.f154c.equals(iqVar.f154c))) || this.f148a != iqVar.f148a) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = iqVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.d.equals(iqVar.d))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = iqVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.e.equals(iqVar.e))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = iqVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.f.equals(iqVar.f))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = iqVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || !this.g.equals(iqVar.g))) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = iqVar.O0000Oo();
        if ((O0000Oo2 || O0000Oo3) && (!O0000Oo2 || !O0000Oo3 || this.f152b != iqVar.f152b)) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = iqVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || !this.h.equals(iqVar.h))) {
            return false;
        }
        boolean O0000Ooo2 = O0000Ooo();
        boolean O0000Ooo3 = iqVar.O0000Ooo();
        if ((O0000Ooo2 || O0000Ooo3) && (!O0000Ooo2 || !O0000Ooo3 || !this.i.equals(iqVar.i))) {
            return false;
        }
        boolean O0000o002 = O0000o00();
        boolean O0000o003 = iqVar.O0000o00();
        if ((O0000o002 || O0000o003) && (!O0000o002 || !O0000o003 || this.c != iqVar.c)) {
            return false;
        }
        boolean O0000o02 = O0000o0();
        boolean O0000o03 = iqVar.O0000o0();
        if ((O0000o02 || O0000o03) && (!O0000o02 || !O0000o03 || !this.j.equals(iqVar.j))) {
            return false;
        }
        boolean O0000o0O2 = O0000o0O();
        boolean O0000o0O3 = iqVar.O0000o0O();
        if ((O0000o0O2 || O0000o0O3) && (!O0000o0O2 || !O0000o0O3 || this.f6436a != iqVar.f6436a)) {
            return false;
        }
        boolean O0000o0o2 = O0000o0o();
        boolean O0000o0o3 = iqVar.O0000o0o();
        if ((O0000o0o2 || O0000o0o3) && (!O0000o0o2 || !O0000o0o3 || !this.k.equals(iqVar.k))) {
            return false;
        }
        boolean O0000o2 = O0000o();
        boolean O0000o3 = iqVar.O0000o();
        if ((O0000o2 || O0000o3) && (!O0000o2 || !O0000o3 || this.b != iqVar.b)) {
            return false;
        }
        boolean O0000oO02 = O0000oO0();
        boolean O0000oO03 = iqVar.O0000oO0();
        if (O0000oO02 || O0000oO03) {
            return O0000oO02 && O0000oO03 && this.l.equals(iqVar.l);
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
                        this.f150a = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 2:
                    if (O00000Oo2.O00000Oo == 12) {
                        this.f149a = new ie();
                        this.f149a.O000000o(esd);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 3:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f153b = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 4:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f154c = esd.O0000Ooo();
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
                        this.f148a = esd.O0000Oo();
                        this.f151a.set(0, true);
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
                    if (O00000Oo2.O00000Oo == 10) {
                        this.f152b = esd.O0000Oo();
                        this.f151a.set(1, true);
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
                    if (O00000Oo2.O00000Oo == 10) {
                        this.c = esd.O0000Oo();
                        this.f151a.set(2, true);
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
                    if (O00000Oo2.O00000Oo == 8) {
                        this.f6436a = esd.O0000Oo0();
                        this.f151a.set(3, true);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 17:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.k = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 18:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.b = esd.O0000Oo0();
                        this.f151a.set(4, true);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 19:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.l = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
            }
        }
        if (O00000oO()) {
            O0000oO();
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
        int O000000o12;
        int O000000o13;
        int O000000o14;
        int O000000o15;
        int O000000o16;
        int O000000o17;
        int O000000o18;
        int O000000o19;
        iq iqVar = (iq) obj;
        if (!getClass().equals(iqVar.getClass())) {
            return getClass().getName().compareTo(iqVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O000000o()).compareTo(Boolean.valueOf(iqVar.O000000o()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O000000o() && (O000000o19 = erw.O000000o(this.f150a, iqVar.f150a)) != 0) {
            return O000000o19;
        }
        int compareTo2 = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(iqVar.O00000Oo()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000Oo() && (O000000o18 = erw.O000000o(this.f149a, iqVar.f149a)) != 0) {
            return O000000o18;
        }
        int compareTo3 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(iqVar.O00000o0()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o0() && (O000000o17 = erw.O000000o(this.f153b, iqVar.f153b)) != 0) {
            return O000000o17;
        }
        int compareTo4 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(iqVar.O00000o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000o() && (O000000o16 = erw.O000000o(this.f154c, iqVar.f154c)) != 0) {
            return O000000o16;
        }
        int compareTo5 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(iqVar.O00000oO()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oO() && (O000000o15 = erw.O000000o(this.f148a, iqVar.f148a)) != 0) {
            return O000000o15;
        }
        int compareTo6 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(iqVar.O00000oo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O00000oo() && (O000000o14 = erw.O000000o(this.d, iqVar.d)) != 0) {
            return O000000o14;
        }
        int compareTo7 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(iqVar.O0000O0o()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000O0o() && (O000000o13 = erw.O000000o(this.e, iqVar.e)) != 0) {
            return O000000o13;
        }
        int compareTo8 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(iqVar.O0000OOo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000OOo() && (O000000o12 = erw.O000000o(this.f, iqVar.f)) != 0) {
            return O000000o12;
        }
        int compareTo9 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(iqVar.O0000Oo0()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000Oo0() && (O000000o11 = erw.O000000o(this.g, iqVar.g)) != 0) {
            return O000000o11;
        }
        int compareTo10 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(iqVar.O0000Oo()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (O0000Oo() && (O000000o10 = erw.O000000o(this.f152b, iqVar.f152b)) != 0) {
            return O000000o10;
        }
        int compareTo11 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(iqVar.O0000OoO()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (O0000OoO() && (O000000o9 = erw.O000000o(this.h, iqVar.h)) != 0) {
            return O000000o9;
        }
        int compareTo12 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(iqVar.O0000Ooo()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (O0000Ooo() && (O000000o8 = erw.O000000o(this.i, iqVar.i)) != 0) {
            return O000000o8;
        }
        int compareTo13 = Boolean.valueOf(O0000o00()).compareTo(Boolean.valueOf(iqVar.O0000o00()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (O0000o00() && (O000000o7 = erw.O000000o(this.c, iqVar.c)) != 0) {
            return O000000o7;
        }
        int compareTo14 = Boolean.valueOf(O0000o0()).compareTo(Boolean.valueOf(iqVar.O0000o0()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (O0000o0() && (O000000o6 = erw.O000000o(this.j, iqVar.j)) != 0) {
            return O000000o6;
        }
        int compareTo15 = Boolean.valueOf(O0000o0O()).compareTo(Boolean.valueOf(iqVar.O0000o0O()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (O0000o0O() && (O000000o5 = erw.O000000o(this.f6436a, iqVar.f6436a)) != 0) {
            return O000000o5;
        }
        int compareTo16 = Boolean.valueOf(O0000o0o()).compareTo(Boolean.valueOf(iqVar.O0000o0o()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (O0000o0o() && (O000000o4 = erw.O000000o(this.k, iqVar.k)) != 0) {
            return O000000o4;
        }
        int compareTo17 = Boolean.valueOf(O0000o()).compareTo(Boolean.valueOf(iqVar.O0000o()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (O0000o() && (O000000o3 = erw.O000000o(this.b, iqVar.b)) != 0) {
            return O000000o3;
        }
        int compareTo18 = Boolean.valueOf(O0000oO0()).compareTo(Boolean.valueOf(iqVar.O0000oO0()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (!O0000oO0() || (O000000o2 = erw.O000000o(this.l, iqVar.l)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
