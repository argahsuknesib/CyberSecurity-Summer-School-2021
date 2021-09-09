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

public class ip implements ja<ip, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6433O000000o = new esg("XmPushActionRegistration");
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
    private static final esa O0000Ooo = new esa("", (byte) 11, 11);
    private static final esa O0000o = new esa("", (byte) 11, 16);
    private static final esa O0000o0 = new esa("", (byte) 8, 13);
    private static final esa O0000o00 = new esa("", (byte) 11, 12);
    private static final esa O0000o0O = new esa("", (byte) 8, 14);
    private static final esa O0000o0o = new esa("", (byte) 11, 15);
    private static final esa O0000oO = new esa("", (byte) 11, 18);
    private static final esa O0000oO0 = new esa("", (byte) 11, 17);
    private static final esa O0000oOO = new esa("", (byte) 8, 19);
    private static final esa O0000oOo = new esa("", (byte) 8, 20);
    private static final esa O0000oo = new esa("", (byte) 10, 22);
    private static final esa O0000oo0 = new esa("", (byte) 2, 21);
    private static final esa O0000ooO = new esa("", (byte) 10, 23);
    private static final esa O0000ooo = new esa("", (byte) 11, 24);
    private static final esa O000O00o = new esa("", (byte) 13, 100);
    private static final esa O000O0OO = new esa("", (byte) 2, 101);
    private static final esa O000O0Oo = new esa("", (byte) 11, 102);
    private static final esa O00oOooO = new esa("", (byte) 11, 25);
    private static final esa O00oOooo = new esa("", (byte) 2, 26);

    /* renamed from: a  reason: collision with root package name */
    public int f6434a;

    /* renamed from: a  reason: collision with other field name */
    public long f136a;

    /* renamed from: a  reason: collision with other field name */
    public id f137a;

    /* renamed from: a  reason: collision with other field name */
    public ie f138a;

    /* renamed from: a  reason: collision with other field name */
    public String f139a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f140a = new BitSet(8);

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f141a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f142a = true;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public long f143b;

    /* renamed from: b  reason: collision with other field name */
    public String f144b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f145b = false;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f146c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f147c = false;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;

    private boolean O00000Oo() {
        return this.f139a != null;
    }

    private boolean O00000o() {
        return this.f144b != null;
    }

    private boolean O00000o0() {
        return this.f138a != null;
    }

    private boolean O00000oO() {
        return this.f146c != null;
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
        return this.h != null;
    }

    private boolean O0000Oo0() {
        return this.g != null;
    }

    private boolean O0000OoO() {
        return this.i != null;
    }

    private boolean O0000Ooo() {
        return this.j != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000o() {
        this.f140a.set(1, true);
    }

    private boolean O0000o0() {
        return this.f140a.get(0);
    }

    private boolean O0000o00() {
        return this.k != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000o0O() {
        this.f140a.set(0, true);
    }

    private boolean O0000o0o() {
        return this.f140a.get(1);
    }

    private boolean O0000oO() {
        return this.m != null;
    }

    private boolean O0000oO0() {
        return this.l != null;
    }

    private boolean O0000oOO() {
        return this.n != null;
    }

    private boolean O0000oOo() {
        return this.o != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000oo() {
        this.f140a.set(2, true);
    }

    private boolean O0000oo0() {
        return this.f140a.get(2);
    }

    private boolean O0000ooO() {
        return this.f137a != null;
    }

    private boolean O0000ooo() {
        return this.f140a.get(3);
    }

    private boolean O000O00o() {
        return this.p != null;
    }

    private boolean O000O0OO() {
        return this.q != null;
    }

    private boolean O000O0Oo() {
        return this.f140a.get(6);
    }

    private boolean O000O0o() {
        return this.r != null;
    }

    private boolean O000O0o0() {
        return this.f140a.get(7);
    }

    private void O000O0oO() {
        if (this.f144b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f146c == null) {
            throw new jm("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f == null) {
            throw new jm("Required field 'token' was not present! Struct: " + toString());
        }
    }

    private boolean O00oOoOo() {
        return this.f141a != null;
    }

    private boolean O00oOooO() {
        return this.f140a.get(4);
    }

    private boolean O00oOooo() {
        return this.f140a.get(5);
    }

    public final ip O000000o() {
        this.f6434a = 40020;
        O0000o0O();
        return this;
    }

    public final ip O000000o(int i2) {
        this.b = i2;
        O0000o();
        return this;
    }

    public final ip O00000Oo(int i2) {
        this.c = i2;
        O0000oo();
        return this;
    }

    public final void O00000Oo(esd esd) {
        O000O0oO();
        if (this.f139a != null && O00000Oo()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f139a);
        }
        if (this.f138a != null && O00000o0()) {
            esd.O000000o(O00000o0);
            this.f138a.O00000Oo(esd);
        }
        if (this.f144b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.f144b);
        }
        if (this.f146c != null) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.f146c);
        }
        if (this.d != null && O00000oo()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.d);
        }
        if (this.e != null && O0000O0o()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.e);
        }
        if (this.f != null) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.f);
        }
        if (this.g != null && O0000Oo0()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(this.g);
        }
        if (this.h != null && O0000Oo()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.h);
        }
        if (this.i != null && O0000OoO()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.i);
        }
        if (this.j != null && O0000Ooo()) {
            esd.O000000o(O0000Ooo);
            esd.O000000o(this.j);
        }
        if (this.k != null && O0000o00()) {
            esd.O000000o(O0000o00);
            esd.O000000o(this.k);
        }
        if (O0000o0()) {
            esd.O000000o(O0000o0);
            esd.O000000o(this.f6434a);
        }
        if (O0000o0o()) {
            esd.O000000o(O0000o0O);
            esd.O000000o(this.b);
        }
        if (this.l != null && O0000oO0()) {
            esd.O000000o(O0000o0o);
            esd.O000000o(this.l);
        }
        if (this.m != null && O0000oO()) {
            esd.O000000o(O0000o);
            esd.O000000o(this.m);
        }
        if (this.n != null && O0000oOO()) {
            esd.O000000o(O0000oO0);
            esd.O000000o(this.n);
        }
        if (this.o != null && O0000oOo()) {
            esd.O000000o(O0000oO);
            esd.O000000o(this.o);
        }
        if (O0000oo0()) {
            esd.O000000o(O0000oOO);
            esd.O000000o(this.c);
        }
        if (this.f137a != null && O0000ooO()) {
            esd.O000000o(O0000oOo);
            esd.O000000o(this.f137a.a());
        }
        if (O0000ooo()) {
            esd.O000000o(O0000oo0);
            esd.O000000o(this.f142a);
        }
        if (O00oOooO()) {
            esd.O000000o(O0000oo);
            esd.O000000o(this.f136a);
        }
        if (O00oOooo()) {
            esd.O000000o(O0000ooO);
            esd.O000000o(this.f143b);
        }
        if (this.p != null && O000O00o()) {
            esd.O000000o(O0000ooo);
            esd.O000000o(this.p);
        }
        if (this.q != null && O000O0OO()) {
            esd.O000000o(O00oOooO);
            esd.O000000o(this.q);
        }
        if (O000O0Oo()) {
            esd.O000000o(O00oOooo);
            esd.O000000o(this.f145b);
        }
        if (this.f141a != null && O00oOoOo()) {
            esd.O000000o(O000O00o);
            esd.O000000o(new esc((byte) 11, (byte) 11, this.f141a.size()));
            for (Map.Entry next : this.f141a.entrySet()) {
                esd.O000000o((String) next.getKey());
                esd.O000000o((String) next.getValue());
            }
        }
        if (O000O0o0()) {
            esd.O000000o(O000O0OO);
            esd.O000000o(this.f147c);
        }
        if (this.r != null && O000O0o()) {
            esd.O000000o(O000O0Oo);
            esd.O000000o(this.r);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        if (O00000Oo()) {
            sb.append("debug:");
            String str = this.f139a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (O00000o0()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            ie ieVar = this.f138a;
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
        String str2 = this.f144b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f146c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("appVersion:");
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
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (O0000Ooo()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (O0000o00()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (O0000o0()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f6434a);
        }
        if (O0000o0o()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.b);
        }
        if (O0000oO0()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (O0000oO()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.m;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (O0000oOO()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.n;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (O0000oOo()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.o;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (O0000oo0()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.c);
        }
        if (O0000ooO()) {
            sb.append(", ");
            sb.append("reason:");
            id idVar = this.f137a;
            if (idVar == null) {
                sb.append("null");
            } else {
                sb.append(idVar);
            }
        }
        if (O0000ooo()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f142a);
        }
        if (O00oOooO()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f136a);
        }
        if (O00oOooo()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f143b);
        }
        if (O000O00o()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.p;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (O000O0OO()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.q;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (O000O0Oo()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f145b);
        }
        if (O00oOoOo()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f141a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (O000O0o0()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f147c);
        }
        if (O000O0o()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.r;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        ip ipVar;
        if (obj == null || !(obj instanceof ip) || (ipVar = (ip) obj) == null) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = ipVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f139a.equals(ipVar.f139a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = ipVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.f138a.O000000o(ipVar.f138a))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = ipVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.f144b.equals(ipVar.f144b))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = ipVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || !this.f146c.equals(ipVar.f146c))) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = ipVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.d.equals(ipVar.d))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = ipVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.e.equals(ipVar.e))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = ipVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.f.equals(ipVar.f))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = ipVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || !this.g.equals(ipVar.g))) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = ipVar.O0000Oo();
        if ((O0000Oo2 || O0000Oo3) && (!O0000Oo2 || !O0000Oo3 || !this.h.equals(ipVar.h))) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = ipVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || !this.i.equals(ipVar.i))) {
            return false;
        }
        boolean O0000Ooo2 = O0000Ooo();
        boolean O0000Ooo3 = ipVar.O0000Ooo();
        if ((O0000Ooo2 || O0000Ooo3) && (!O0000Ooo2 || !O0000Ooo3 || !this.j.equals(ipVar.j))) {
            return false;
        }
        boolean O0000o002 = O0000o00();
        boolean O0000o003 = ipVar.O0000o00();
        if ((O0000o002 || O0000o003) && (!O0000o002 || !O0000o003 || !this.k.equals(ipVar.k))) {
            return false;
        }
        boolean O0000o02 = O0000o0();
        boolean O0000o03 = ipVar.O0000o0();
        if ((O0000o02 || O0000o03) && (!O0000o02 || !O0000o03 || this.f6434a != ipVar.f6434a)) {
            return false;
        }
        boolean O0000o0o2 = O0000o0o();
        boolean O0000o0o3 = ipVar.O0000o0o();
        if ((O0000o0o2 || O0000o0o3) && (!O0000o0o2 || !O0000o0o3 || this.b != ipVar.b)) {
            return false;
        }
        boolean O0000oO02 = O0000oO0();
        boolean O0000oO03 = ipVar.O0000oO0();
        if ((O0000oO02 || O0000oO03) && (!O0000oO02 || !O0000oO03 || !this.l.equals(ipVar.l))) {
            return false;
        }
        boolean O0000oO2 = O0000oO();
        boolean O0000oO3 = ipVar.O0000oO();
        if ((O0000oO2 || O0000oO3) && (!O0000oO2 || !O0000oO3 || !this.m.equals(ipVar.m))) {
            return false;
        }
        boolean O0000oOO2 = O0000oOO();
        boolean O0000oOO3 = ipVar.O0000oOO();
        if ((O0000oOO2 || O0000oOO3) && (!O0000oOO2 || !O0000oOO3 || !this.n.equals(ipVar.n))) {
            return false;
        }
        boolean O0000oOo2 = O0000oOo();
        boolean O0000oOo3 = ipVar.O0000oOo();
        if ((O0000oOo2 || O0000oOo3) && (!O0000oOo2 || !O0000oOo3 || !this.o.equals(ipVar.o))) {
            return false;
        }
        boolean O0000oo02 = O0000oo0();
        boolean O0000oo03 = ipVar.O0000oo0();
        if ((O0000oo02 || O0000oo03) && (!O0000oo02 || !O0000oo03 || this.c != ipVar.c)) {
            return false;
        }
        boolean O0000ooO2 = O0000ooO();
        boolean O0000ooO3 = ipVar.O0000ooO();
        if ((O0000ooO2 || O0000ooO3) && (!O0000ooO2 || !O0000ooO3 || !this.f137a.equals(ipVar.f137a))) {
            return false;
        }
        boolean O0000ooo2 = O0000ooo();
        boolean O0000ooo3 = ipVar.O0000ooo();
        if ((O0000ooo2 || O0000ooo3) && (!O0000ooo2 || !O0000ooo3 || this.f142a != ipVar.f142a)) {
            return false;
        }
        boolean O00oOooO2 = O00oOooO();
        boolean O00oOooO3 = ipVar.O00oOooO();
        if ((O00oOooO2 || O00oOooO3) && (!O00oOooO2 || !O00oOooO3 || this.f136a != ipVar.f136a)) {
            return false;
        }
        boolean O00oOooo2 = O00oOooo();
        boolean O00oOooo3 = ipVar.O00oOooo();
        if ((O00oOooo2 || O00oOooo3) && (!O00oOooo2 || !O00oOooo3 || this.f143b != ipVar.f143b)) {
            return false;
        }
        boolean O000O00o2 = O000O00o();
        boolean O000O00o3 = ipVar.O000O00o();
        if ((O000O00o2 || O000O00o3) && (!O000O00o2 || !O000O00o3 || !this.p.equals(ipVar.p))) {
            return false;
        }
        boolean O000O0OO2 = O000O0OO();
        boolean O000O0OO3 = ipVar.O000O0OO();
        if ((O000O0OO2 || O000O0OO3) && (!O000O0OO2 || !O000O0OO3 || !this.q.equals(ipVar.q))) {
            return false;
        }
        boolean O000O0Oo2 = O000O0Oo();
        boolean O000O0Oo3 = ipVar.O000O0Oo();
        if ((O000O0Oo2 || O000O0Oo3) && (!O000O0Oo2 || !O000O0Oo3 || this.f145b != ipVar.f145b)) {
            return false;
        }
        boolean O00oOoOo = O00oOoOo();
        boolean O00oOoOo2 = ipVar.O00oOoOo();
        if ((O00oOoOo || O00oOoOo2) && (!O00oOoOo || !O00oOoOo2 || !this.f141a.equals(ipVar.f141a))) {
            return false;
        }
        boolean O000O0o0 = O000O0o0();
        boolean O000O0o02 = ipVar.O000O0o0();
        if ((O000O0o0 || O000O0o02) && (!O000O0o0 || !O000O0o02 || this.f147c != ipVar.f147c)) {
            return false;
        }
        boolean O000O0o = O000O0o();
        boolean O000O0o2 = ipVar.O000O0o();
        if (O000O0o || O000O0o2) {
            return O000O0o && O000O0o2 && this.r.equals(ipVar.r);
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
                short s = O00000Oo2.O00000o0;
                switch (s) {
                    case 1:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f139a = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 2:
                        if (O00000Oo2.O00000Oo == 12) {
                            this.f138a = new ie();
                            this.f138a.O000000o(esd);
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 3:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f144b = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 4:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.f146c = esd.O0000Ooo();
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
                        if (O00000Oo2.O00000Oo == 11) {
                            this.j = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.k = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 13:
                        if (O00000Oo2.O00000Oo == 8) {
                            this.f6434a = esd.O0000Oo0();
                            O0000o0O();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 14:
                        if (O00000Oo2.O00000Oo == 8) {
                            this.b = esd.O0000Oo0();
                            O0000o();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.l = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 16:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.m = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 17:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.n = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 18:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.o = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 19:
                        if (O00000Oo2.O00000Oo == 8) {
                            this.c = esd.O0000Oo0();
                            O0000oo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 20:
                        if (O00000Oo2.O00000Oo == 8) {
                            this.f137a = id.a(esd.O0000Oo0());
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 21:
                        if (O00000Oo2.O00000Oo != 2) {
                            ese.O000000o(esd, O00000Oo2.O00000Oo);
                            break;
                        } else {
                            this.f142a = esd.O00000oo();
                            this.f140a.set(3, true);
                            break;
                        }
                    case 22:
                        if (O00000Oo2.O00000Oo != 10) {
                            ese.O000000o(esd, O00000Oo2.O00000Oo);
                            break;
                        } else {
                            this.f136a = esd.O0000Oo();
                            this.f140a.set(4, true);
                            break;
                        }
                    case 23:
                        if (O00000Oo2.O00000Oo == 10) {
                            this.f143b = esd.O0000Oo();
                            this.f140a.set(5, true);
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 24:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.p = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 25:
                        if (O00000Oo2.O00000Oo == 11) {
                            this.q = esd.O0000Ooo();
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    case 26:
                        if (O00000Oo2.O00000Oo == 2) {
                            this.f145b = esd.O00000oo();
                            this.f140a.set(6, true);
                            break;
                        }
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    default:
                        switch (s) {
                            case 100:
                                if (O00000Oo2.O00000Oo == 13) {
                                    esc O00000o02 = esd.O00000o0();
                                    this.f141a = new HashMap(O00000o02.O00000o0 * 2);
                                    for (int i2 = 0; i2 < O00000o02.O00000o0; i2++) {
                                        this.f141a.put(esd.O0000Ooo(), esd.O0000Ooo());
                                    }
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case 101:
                                if (O00000Oo2.O00000Oo == 2) {
                                    this.f147c = esd.O00000oo();
                                    this.f140a.set(7, true);
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            case 102:
                                if (O00000Oo2.O00000Oo == 11) {
                                    this.r = esd.O0000Ooo();
                                    break;
                                }
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                            default:
                                ese.O000000o(esd, O00000Oo2.O00000Oo);
                                break;
                        }
                }
            } else {
                O000O0oO();
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
        int O000000o20;
        int O000000o21;
        int O000000o22;
        int O000000o23;
        int O000000o24;
        int O000000o25;
        int O000000o26;
        int O000000o27;
        int O000000o28;
        int O000000o29;
        int O000000o30;
        ip ipVar = (ip) obj;
        if (!getClass().equals(ipVar.getClass())) {
            return getClass().getName().compareTo(ipVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(ipVar.O00000Oo()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O00000Oo() && (O000000o30 = erw.O000000o(this.f139a, ipVar.f139a)) != 0) {
            return O000000o30;
        }
        int compareTo2 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ipVar.O00000o0()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000o0() && (O000000o29 = erw.O000000o(this.f138a, ipVar.f138a)) != 0) {
            return O000000o29;
        }
        int compareTo3 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(ipVar.O00000o()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o() && (O000000o28 = erw.O000000o(this.f144b, ipVar.f144b)) != 0) {
            return O000000o28;
        }
        int compareTo4 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(ipVar.O00000oO()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000oO() && (O000000o27 = erw.O000000o(this.f146c, ipVar.f146c)) != 0) {
            return O000000o27;
        }
        int compareTo5 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(ipVar.O00000oo()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oo() && (O000000o26 = erw.O000000o(this.d, ipVar.d)) != 0) {
            return O000000o26;
        }
        int compareTo6 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(ipVar.O0000O0o()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O0000O0o() && (O000000o25 = erw.O000000o(this.e, ipVar.e)) != 0) {
            return O000000o25;
        }
        int compareTo7 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(ipVar.O0000OOo()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000OOo() && (O000000o24 = erw.O000000o(this.f, ipVar.f)) != 0) {
            return O000000o24;
        }
        int compareTo8 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(ipVar.O0000Oo0()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000Oo0() && (O000000o23 = erw.O000000o(this.g, ipVar.g)) != 0) {
            return O000000o23;
        }
        int compareTo9 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(ipVar.O0000Oo()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000Oo() && (O000000o22 = erw.O000000o(this.h, ipVar.h)) != 0) {
            return O000000o22;
        }
        int compareTo10 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(ipVar.O0000OoO()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (O0000OoO() && (O000000o21 = erw.O000000o(this.i, ipVar.i)) != 0) {
            return O000000o21;
        }
        int compareTo11 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(ipVar.O0000Ooo()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (O0000Ooo() && (O000000o20 = erw.O000000o(this.j, ipVar.j)) != 0) {
            return O000000o20;
        }
        int compareTo12 = Boolean.valueOf(O0000o00()).compareTo(Boolean.valueOf(ipVar.O0000o00()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (O0000o00() && (O000000o19 = erw.O000000o(this.k, ipVar.k)) != 0) {
            return O000000o19;
        }
        int compareTo13 = Boolean.valueOf(O0000o0()).compareTo(Boolean.valueOf(ipVar.O0000o0()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (O0000o0() && (O000000o18 = erw.O000000o(this.f6434a, ipVar.f6434a)) != 0) {
            return O000000o18;
        }
        int compareTo14 = Boolean.valueOf(O0000o0o()).compareTo(Boolean.valueOf(ipVar.O0000o0o()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (O0000o0o() && (O000000o17 = erw.O000000o(this.b, ipVar.b)) != 0) {
            return O000000o17;
        }
        int compareTo15 = Boolean.valueOf(O0000oO0()).compareTo(Boolean.valueOf(ipVar.O0000oO0()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (O0000oO0() && (O000000o16 = erw.O000000o(this.l, ipVar.l)) != 0) {
            return O000000o16;
        }
        int compareTo16 = Boolean.valueOf(O0000oO()).compareTo(Boolean.valueOf(ipVar.O0000oO()));
        if (compareTo16 != 0) {
            return compareTo16;
        }
        if (O0000oO() && (O000000o15 = erw.O000000o(this.m, ipVar.m)) != 0) {
            return O000000o15;
        }
        int compareTo17 = Boolean.valueOf(O0000oOO()).compareTo(Boolean.valueOf(ipVar.O0000oOO()));
        if (compareTo17 != 0) {
            return compareTo17;
        }
        if (O0000oOO() && (O000000o14 = erw.O000000o(this.n, ipVar.n)) != 0) {
            return O000000o14;
        }
        int compareTo18 = Boolean.valueOf(O0000oOo()).compareTo(Boolean.valueOf(ipVar.O0000oOo()));
        if (compareTo18 != 0) {
            return compareTo18;
        }
        if (O0000oOo() && (O000000o13 = erw.O000000o(this.o, ipVar.o)) != 0) {
            return O000000o13;
        }
        int compareTo19 = Boolean.valueOf(O0000oo0()).compareTo(Boolean.valueOf(ipVar.O0000oo0()));
        if (compareTo19 != 0) {
            return compareTo19;
        }
        if (O0000oo0() && (O000000o12 = erw.O000000o(this.c, ipVar.c)) != 0) {
            return O000000o12;
        }
        int compareTo20 = Boolean.valueOf(O0000ooO()).compareTo(Boolean.valueOf(ipVar.O0000ooO()));
        if (compareTo20 != 0) {
            return compareTo20;
        }
        if (O0000ooO() && (O000000o11 = erw.O000000o(this.f137a, ipVar.f137a)) != 0) {
            return O000000o11;
        }
        int compareTo21 = Boolean.valueOf(O0000ooo()).compareTo(Boolean.valueOf(ipVar.O0000ooo()));
        if (compareTo21 != 0) {
            return compareTo21;
        }
        if (O0000ooo() && (O000000o10 = erw.O000000o(this.f142a, ipVar.f142a)) != 0) {
            return O000000o10;
        }
        int compareTo22 = Boolean.valueOf(O00oOooO()).compareTo(Boolean.valueOf(ipVar.O00oOooO()));
        if (compareTo22 != 0) {
            return compareTo22;
        }
        if (O00oOooO() && (O000000o9 = erw.O000000o(this.f136a, ipVar.f136a)) != 0) {
            return O000000o9;
        }
        int compareTo23 = Boolean.valueOf(O00oOooo()).compareTo(Boolean.valueOf(ipVar.O00oOooo()));
        if (compareTo23 != 0) {
            return compareTo23;
        }
        if (O00oOooo() && (O000000o8 = erw.O000000o(this.f143b, ipVar.f143b)) != 0) {
            return O000000o8;
        }
        int compareTo24 = Boolean.valueOf(O000O00o()).compareTo(Boolean.valueOf(ipVar.O000O00o()));
        if (compareTo24 != 0) {
            return compareTo24;
        }
        if (O000O00o() && (O000000o7 = erw.O000000o(this.p, ipVar.p)) != 0) {
            return O000000o7;
        }
        int compareTo25 = Boolean.valueOf(O000O0OO()).compareTo(Boolean.valueOf(ipVar.O000O0OO()));
        if (compareTo25 != 0) {
            return compareTo25;
        }
        if (O000O0OO() && (O000000o6 = erw.O000000o(this.q, ipVar.q)) != 0) {
            return O000000o6;
        }
        int compareTo26 = Boolean.valueOf(O000O0Oo()).compareTo(Boolean.valueOf(ipVar.O000O0Oo()));
        if (compareTo26 != 0) {
            return compareTo26;
        }
        if (O000O0Oo() && (O000000o5 = erw.O000000o(this.f145b, ipVar.f145b)) != 0) {
            return O000000o5;
        }
        int compareTo27 = Boolean.valueOf(O00oOoOo()).compareTo(Boolean.valueOf(ipVar.O00oOoOo()));
        if (compareTo27 != 0) {
            return compareTo27;
        }
        if (O00oOoOo() && (O000000o4 = erw.O000000o(this.f141a, ipVar.f141a)) != 0) {
            return O000000o4;
        }
        int compareTo28 = Boolean.valueOf(O000O0o0()).compareTo(Boolean.valueOf(ipVar.O000O0o0()));
        if (compareTo28 != 0) {
            return compareTo28;
        }
        if (O000O0o0() && (O000000o3 = erw.O000000o(this.f147c, ipVar.f147c)) != 0) {
            return O000000o3;
        }
        int compareTo29 = Boolean.valueOf(O000O0o()).compareTo(Boolean.valueOf(ipVar.O000O0o()));
        if (compareTo29 != 0) {
            return compareTo29;
        }
        if (!O000O0o() || (O000000o2 = erw.O000000o(this.r, ipVar.r)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
