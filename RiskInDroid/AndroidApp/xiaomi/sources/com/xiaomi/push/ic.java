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

public class ic implements ja<ic, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6408O000000o = new esg("PushMetaInfo");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 10, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 11, 5);
    private static final esa O0000O0o = new esa("", (byte) 8, 6);
    private static final esa O0000OOo = new esa("", (byte) 11, 7);
    private static final esa O0000Oo = new esa("", (byte) 8, 9);
    private static final esa O0000Oo0 = new esa("", (byte) 8, 8);
    private static final esa O0000OoO = new esa("", (byte) 13, 10);
    private static final esa O0000Ooo = new esa("", (byte) 13, 11);
    private static final esa O0000o0 = new esa("", (byte) 13, 13);
    private static final esa O0000o00 = new esa("", (byte) 2, 12);

    /* renamed from: a  reason: collision with root package name */
    public int f6409a;

    /* renamed from: a  reason: collision with other field name */
    public long f83a;

    /* renamed from: a  reason: collision with other field name */
    public String f84a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f85a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f86a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f87a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public String f88b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f89b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f90c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f91c;
    public String d;
    public String e;

    public ic() {
        this.f85a = new BitSet(5);
        this.f87a = false;
    }

    public ic(ic icVar) {
        this.f85a = new BitSet(5);
        this.f85a.clear();
        this.f85a.or(icVar.f85a);
        if (icVar.O00000Oo()) {
            this.f84a = icVar.f84a;
        }
        this.f83a = icVar.f83a;
        if (icVar.O00000oO()) {
            this.f88b = icVar.f88b;
        }
        if (icVar.O00000oo()) {
            this.f90c = icVar.f90c;
        }
        if (icVar.O0000O0o()) {
            this.d = icVar.d;
        }
        this.f6409a = icVar.f6409a;
        if (icVar.O0000Oo()) {
            this.e = icVar.e;
        }
        this.b = icVar.b;
        this.c = icVar.c;
        if (icVar.O0000o0O()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : icVar.f86a.entrySet()) {
                hashMap.put((String) next.getKey(), (String) next.getValue());
            }
            this.f86a = hashMap;
        }
        if (icVar.O0000o0o()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry next2 : icVar.f89b.entrySet()) {
                hashMap2.put((String) next2.getKey(), (String) next2.getValue());
            }
            this.f89b = hashMap2;
        }
        this.f87a = icVar.f87a;
        if (icVar.O0000oO()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry next3 : icVar.f91c.entrySet()) {
                hashMap3.put((String) next3.getKey(), (String) next3.getValue());
            }
            this.f91c = hashMap3;
        }
    }

    private boolean O00000Oo() {
        return this.f84a != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000o() {
        this.f85a.set(0, true);
    }

    private boolean O00000o0() {
        return this.f85a.get(0);
    }

    private boolean O00000oO() {
        return this.f88b != null;
    }

    private boolean O00000oo() {
        return this.f90c != null;
    }

    private boolean O0000O0o() {
        return this.d != null;
    }

    private boolean O0000OOo() {
        return this.f85a.get(1);
    }

    private boolean O0000Oo() {
        return this.e != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000Oo0() {
        this.f85a.set(1, true);
    }

    private boolean O0000OoO() {
        return this.f85a.get(2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000Ooo() {
        this.f85a.set(2, true);
    }

    private boolean O0000o() {
        return this.f85a.get(4);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000o0() {
        this.f85a.set(3, true);
    }

    private boolean O0000o00() {
        return this.f85a.get(3);
    }

    private boolean O0000o0O() {
        return this.f86a != null;
    }

    private boolean O0000o0o() {
        return this.f89b != null;
    }

    private boolean O0000oO() {
        return this.f91c != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000oO0() {
        this.f85a.set(4, true);
    }

    private void O0000oOO() {
        if (this.f84a == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public final ic O000000o() {
        return new ic(this);
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo == 0) {
                break;
            }
            int i = 0;
            switch (O00000Oo2.O00000o0) {
                case 1:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f84a = esd.O0000Ooo();
                        continue;
                    }
                    break;
                case 2:
                    if (O00000Oo2.O00000Oo == 10) {
                        this.f83a = esd.O0000Oo();
                        O00000o();
                        continue;
                    }
                    break;
                case 3:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f88b = esd.O0000Ooo();
                        continue;
                    }
                    break;
                case 4:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f90c = esd.O0000Ooo();
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
                    if (O00000Oo2.O00000Oo == 8) {
                        this.f6409a = esd.O0000Oo0();
                        O0000Oo0();
                        continue;
                    }
                    break;
                case 7:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.e = esd.O0000Ooo();
                        continue;
                    }
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.b = esd.O0000Oo0();
                        O0000Ooo();
                        continue;
                    }
                    break;
                case 9:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.c = esd.O0000Oo0();
                        O0000o0();
                        continue;
                    }
                    break;
                case 10:
                    if (O00000Oo2.O00000Oo == 13) {
                        esc O00000o02 = esd.O00000o0();
                        this.f86a = new HashMap(O00000o02.O00000o0 * 2);
                        while (i < O00000o02.O00000o0) {
                            this.f86a.put(esd.O0000Ooo(), esd.O0000Ooo());
                            i++;
                        }
                        continue;
                    }
                    break;
                case 11:
                    if (O00000Oo2.O00000Oo == 13) {
                        esc O00000o03 = esd.O00000o0();
                        this.f89b = new HashMap(O00000o03.O00000o0 * 2);
                        while (i < O00000o03.O00000o0) {
                            this.f89b.put(esd.O0000Ooo(), esd.O0000Ooo());
                            i++;
                        }
                        continue;
                    }
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    if (O00000Oo2.O00000Oo == 2) {
                        this.f87a = esd.O00000oo();
                        O0000oO0();
                        continue;
                    }
                    break;
                case 13:
                    if (O00000Oo2.O00000Oo == 13) {
                        esc O00000o04 = esd.O00000o0();
                        this.f91c = new HashMap(O00000o04.O00000o0 * 2);
                        while (i < O00000o04.O00000o0) {
                            this.f91c.put(esd.O0000Ooo(), esd.O0000Ooo());
                            i++;
                        }
                        continue;
                    }
                    break;
            }
            ese.O000000o(esd, O00000Oo2.O00000Oo);
        }
        if (O00000o0()) {
            O0000oOO();
            return;
        }
        throw new jm("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
    }

    public final void O000000o(String str, String str2) {
        if (this.f86a == null) {
            this.f86a = new HashMap();
        }
        this.f86a.put(str, str2);
    }

    public final boolean O000000o(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = icVar.O00000Oo();
        if (((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f84a.equals(icVar.f84a))) || this.f83a != icVar.f83a) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = icVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || !this.f88b.equals(icVar.f88b))) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = icVar.O00000oo();
        if ((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.f90c.equals(icVar.f90c))) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = icVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.d.equals(icVar.d))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = icVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || this.f6409a != icVar.f6409a)) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = icVar.O0000Oo();
        if ((O0000Oo2 || O0000Oo3) && (!O0000Oo2 || !O0000Oo3 || !this.e.equals(icVar.e))) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = icVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || this.b != icVar.b)) {
            return false;
        }
        boolean O0000o002 = O0000o00();
        boolean O0000o003 = icVar.O0000o00();
        if ((O0000o002 || O0000o003) && (!O0000o002 || !O0000o003 || this.c != icVar.c)) {
            return false;
        }
        boolean O0000o0O = O0000o0O();
        boolean O0000o0O2 = icVar.O0000o0O();
        if ((O0000o0O || O0000o0O2) && (!O0000o0O || !O0000o0O2 || !this.f86a.equals(icVar.f86a))) {
            return false;
        }
        boolean O0000o0o = O0000o0o();
        boolean O0000o0o2 = icVar.O0000o0o();
        if ((O0000o0o || O0000o0o2) && (!O0000o0o || !O0000o0o2 || !this.f89b.equals(icVar.f89b))) {
            return false;
        }
        boolean O0000o = O0000o();
        boolean O0000o2 = icVar.O0000o();
        if ((O0000o || O0000o2) && (!O0000o || !O0000o2 || this.f87a != icVar.f87a)) {
            return false;
        }
        boolean O0000oO = O0000oO();
        boolean O0000oO2 = icVar.O0000oO();
        if (O0000oO || O0000oO2) {
            return O0000oO && O0000oO2 && this.f91c.equals(icVar.f91c);
        }
        return true;
    }

    public final void O00000Oo(esd esd) {
        O0000oOO();
        if (this.f84a != null) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f84a);
        }
        esd.O000000o(O00000o0);
        esd.O000000o(this.f83a);
        if (this.f88b != null && O00000oO()) {
            esd.O000000o(O00000o);
            esd.O000000o(this.f88b);
        }
        if (this.f90c != null && O00000oo()) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.f90c);
        }
        if (this.d != null && O0000O0o()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.d);
        }
        if (O0000OOo()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.f6409a);
        }
        if (this.e != null && O0000Oo()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.e);
        }
        if (O0000OoO()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(this.b);
        }
        if (O0000o00()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.c);
        }
        if (this.f86a != null && O0000o0O()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(new esc((byte) 11, (byte) 11, this.f86a.size()));
            for (Map.Entry next : this.f86a.entrySet()) {
                esd.O000000o((String) next.getKey());
                esd.O000000o((String) next.getValue());
            }
        }
        if (this.f89b != null && O0000o0o()) {
            esd.O000000o(O0000Ooo);
            esd.O000000o(new esc((byte) 11, (byte) 11, this.f89b.size()));
            for (Map.Entry next2 : this.f89b.entrySet()) {
                esd.O000000o((String) next2.getKey());
                esd.O000000o((String) next2.getValue());
            }
        }
        if (O0000o()) {
            esd.O000000o(O0000o00);
            esd.O000000o(this.f87a);
        }
        if (this.f91c != null && O0000oO()) {
            esd.O000000o(O0000o0);
            esd.O000000o(new esc((byte) 11, (byte) 11, this.f91c.size()));
            for (Map.Entry next3 : this.f91c.entrySet()) {
                esd.O000000o((String) next3.getKey());
                esd.O000000o((String) next3.getValue());
            }
        }
        esd.O000000o();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return O000000o((ic) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f84a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f83a);
        if (O00000oO()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f88b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f90c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (O0000O0o()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f6409a);
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.b);
        }
        if (O0000o00()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.c);
        }
        if (O0000o0O()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f86a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (O0000o0o()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f89b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (O0000o()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f87a);
        }
        if (O0000oO()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f91c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
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
        int O000000o14;
        ic icVar = (ic) obj;
        if (!getClass().equals(icVar.getClass())) {
            return getClass().getName().compareTo(icVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(icVar.O00000Oo()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O00000Oo() && (O000000o14 = erw.O000000o(this.f84a, icVar.f84a)) != 0) {
            return O000000o14;
        }
        int compareTo2 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(icVar.O00000o0()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000o0() && (O000000o13 = erw.O000000o(this.f83a, icVar.f83a)) != 0) {
            return O000000o13;
        }
        int compareTo3 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(icVar.O00000oO()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000oO() && (O000000o12 = erw.O000000o(this.f88b, icVar.f88b)) != 0) {
            return O000000o12;
        }
        int compareTo4 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(icVar.O00000oo()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000oo() && (O000000o11 = erw.O000000o(this.f90c, icVar.f90c)) != 0) {
            return O000000o11;
        }
        int compareTo5 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(icVar.O0000O0o()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O0000O0o() && (O000000o10 = erw.O000000o(this.d, icVar.d)) != 0) {
            return O000000o10;
        }
        int compareTo6 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(icVar.O0000OOo()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O0000OOo() && (O000000o9 = erw.O000000o(this.f6409a, icVar.f6409a)) != 0) {
            return O000000o9;
        }
        int compareTo7 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(icVar.O0000Oo()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000Oo() && (O000000o8 = erw.O000000o(this.e, icVar.e)) != 0) {
            return O000000o8;
        }
        int compareTo8 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(icVar.O0000OoO()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000OoO() && (O000000o7 = erw.O000000o(this.b, icVar.b)) != 0) {
            return O000000o7;
        }
        int compareTo9 = Boolean.valueOf(O0000o00()).compareTo(Boolean.valueOf(icVar.O0000o00()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000o00() && (O000000o6 = erw.O000000o(this.c, icVar.c)) != 0) {
            return O000000o6;
        }
        int compareTo10 = Boolean.valueOf(O0000o0O()).compareTo(Boolean.valueOf(icVar.O0000o0O()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (O0000o0O() && (O000000o5 = erw.O000000o(this.f86a, icVar.f86a)) != 0) {
            return O000000o5;
        }
        int compareTo11 = Boolean.valueOf(O0000o0o()).compareTo(Boolean.valueOf(icVar.O0000o0o()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (O0000o0o() && (O000000o4 = erw.O000000o(this.f89b, icVar.f89b)) != 0) {
            return O000000o4;
        }
        int compareTo12 = Boolean.valueOf(O0000o()).compareTo(Boolean.valueOf(icVar.O0000o()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (O0000o() && (O000000o3 = erw.O000000o(this.f87a, icVar.f87a)) != 0) {
            return O000000o3;
        }
        int compareTo13 = Boolean.valueOf(O0000oO()).compareTo(Boolean.valueOf(icVar.O0000oO()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (!O0000oO() || (O000000o2 = erw.O000000o(this.f91c, icVar.f91c)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
