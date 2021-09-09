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
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class io implements ja<io, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6431O000000o = new esg("XmPushActionNotification");
    private static final esa O00000Oo = new esa("", (byte) 11, 1);
    private static final esa O00000o = new esa("", (byte) 11, 3);
    private static final esa O00000o0 = new esa("", (byte) 12, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 11, 5);
    private static final esa O0000O0o = new esa("", (byte) 2, 6);
    private static final esa O0000OOo = new esa("", (byte) 11, 7);
    private static final esa O0000Oo = new esa("", (byte) 11, 9);
    private static final esa O0000Oo0 = new esa("", (byte) 13, 8);
    private static final esa O0000OoO = new esa("", (byte) 11, 10);
    private static final esa O0000Ooo = new esa("", (byte) 11, 12);
    private static final esa O0000o0 = new esa("", (byte) 11, 14);
    private static final esa O0000o00 = new esa("", (byte) 11, 13);
    private static final esa O0000o0O = new esa("", (byte) 10, 15);
    private static final esa O0000o0o = new esa("", (byte) 2, 20);

    /* renamed from: a  reason: collision with root package name */
    public long f6432a;

    /* renamed from: a  reason: collision with other field name */
    public ie f129a;

    /* renamed from: a  reason: collision with other field name */
    public String f130a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f131a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f132a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f133a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f134a;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f135b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public io() {
        this.f132a = new BitSet(3);
        this.f134a = true;
        this.f135b = false;
    }

    public io(String str, boolean z) {
        this();
        this.b = str;
        this.f134a = z;
        O0000OOo();
    }

    private boolean O00000Oo() {
        return this.f130a != null;
    }

    private boolean O00000o() {
        return this.b != null;
    }

    private boolean O00000o0() {
        return this.f129a != null;
    }

    private boolean O00000oO() {
        return this.c != null;
    }

    private boolean O00000oo() {
        return this.d != null;
    }

    private boolean O0000O0o() {
        return this.f132a.get(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O0000OOo() {
        this.f132a.set(0, true);
    }

    private boolean O0000Oo() {
        return this.f133a != null;
    }

    private boolean O0000Oo0() {
        return this.e != null;
    }

    private boolean O0000OoO() {
        return this.f != null;
    }

    private boolean O0000Ooo() {
        return this.g != null;
    }

    private boolean O0000o() {
        return this.f132a.get(2);
    }

    private boolean O0000o0() {
        return this.i != null;
    }

    private boolean O0000o00() {
        return this.h != null;
    }

    private boolean O0000o0O() {
        return this.f131a != null;
    }

    private boolean O0000o0o() {
        return this.f132a.get(1);
    }

    private void O0000oO0() {
        if (this.b == null) {
            throw new jm("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public final io O000000o(boolean z) {
        this.f134a = z;
        O0000OOo();
        return this;
    }

    public final void O000000o(String str, String str2) {
        if (this.f133a == null) {
            this.f133a = new HashMap();
        }
        this.f133a.put(str, str2);
    }

    public final void O00000Oo(esd esd) {
        O0000oO0();
        if (this.f130a != null && O00000Oo()) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f130a);
        }
        if (this.f129a != null && O00000o0()) {
            esd.O000000o(O00000o0);
            this.f129a.O00000Oo(esd);
        }
        if (this.b != null) {
            esd.O000000o(O00000o);
            esd.O000000o(this.b);
        }
        if (this.c != null && O00000oO()) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.c);
        }
        if (this.d != null && O00000oo()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.d);
        }
        esd.O000000o(O0000O0o);
        esd.O000000o(this.f134a);
        if (this.e != null && O0000Oo0()) {
            esd.O000000o(O0000OOo);
            esd.O000000o(this.e);
        }
        if (this.f133a != null && O0000Oo()) {
            esd.O000000o(O0000Oo0);
            esd.O000000o(new esc((byte) 11, (byte) 11, this.f133a.size()));
            for (Map.Entry next : this.f133a.entrySet()) {
                esd.O000000o((String) next.getKey());
                esd.O000000o((String) next.getValue());
            }
        }
        if (this.f != null && O0000OoO()) {
            esd.O000000o(O0000Oo);
            esd.O000000o(this.f);
        }
        if (this.g != null && O0000Ooo()) {
            esd.O000000o(O0000OoO);
            esd.O000000o(this.g);
        }
        if (this.h != null && O0000o00()) {
            esd.O000000o(O0000Ooo);
            esd.O000000o(this.h);
        }
        if (this.i != null && O0000o0()) {
            esd.O000000o(O0000o00);
            esd.O000000o(this.i);
        }
        if (this.f131a != null && O0000o0O()) {
            esd.O000000o(O0000o0);
            esd.O000000o(this.f131a);
        }
        if (O0000o0o()) {
            esd.O000000o(O0000o0O);
            esd.O000000o(this.f6432a);
        }
        if (O0000o()) {
            esd.O000000o(O0000o0o);
            esd.O000000o(this.f135b);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        if (O00000Oo()) {
            sb.append("debug:");
            String str = this.f130a;
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
            ie ieVar = this.f129a;
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
        if (O00000oO()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (O00000oo()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f134a);
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (O0000Oo()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f133a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (O0000Ooo()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
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
            sb.append("aliasName:");
            String str9 = this.i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (O0000o0O()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f131a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                erw.O000000o(byteBuffer, sb);
            }
        }
        if (O0000o0o()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f6432a);
        }
        if (O0000o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f135b);
        }
        sb.append(")");
        return sb.toString();
    }

    public final byte[] O000000o() {
        this.f131a = erw.O000000o(this.f131a);
        return this.f131a.array();
    }

    public final io O000000o(byte[] bArr) {
        this.f131a = ByteBuffer.wrap(bArr);
        return this;
    }

    public boolean equals(Object obj) {
        io ioVar;
        if (obj == null || !(obj instanceof io) || (ioVar = (io) obj) == null) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = ioVar.O00000Oo();
        if ((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f130a.equals(ioVar.f130a))) {
            return false;
        }
        boolean O00000o02 = O00000o0();
        boolean O00000o03 = ioVar.O00000o0();
        if ((O00000o02 || O00000o03) && (!O00000o02 || !O00000o03 || !this.f129a.O000000o(ioVar.f129a))) {
            return false;
        }
        boolean O00000o2 = O00000o();
        boolean O00000o3 = ioVar.O00000o();
        if ((O00000o2 || O00000o3) && (!O00000o2 || !O00000o3 || !this.b.equals(ioVar.b))) {
            return false;
        }
        boolean O00000oO2 = O00000oO();
        boolean O00000oO3 = ioVar.O00000oO();
        if ((O00000oO2 || O00000oO3) && (!O00000oO2 || !O00000oO3 || !this.c.equals(ioVar.c))) {
            return false;
        }
        boolean O00000oo2 = O00000oo();
        boolean O00000oo3 = ioVar.O00000oo();
        if (((O00000oo2 || O00000oo3) && (!O00000oo2 || !O00000oo3 || !this.d.equals(ioVar.d))) || this.f134a != ioVar.f134a) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = ioVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || !this.e.equals(ioVar.e))) {
            return false;
        }
        boolean O0000Oo2 = O0000Oo();
        boolean O0000Oo3 = ioVar.O0000Oo();
        if ((O0000Oo2 || O0000Oo3) && (!O0000Oo2 || !O0000Oo3 || !this.f133a.equals(ioVar.f133a))) {
            return false;
        }
        boolean O0000OoO2 = O0000OoO();
        boolean O0000OoO3 = ioVar.O0000OoO();
        if ((O0000OoO2 || O0000OoO3) && (!O0000OoO2 || !O0000OoO3 || !this.f.equals(ioVar.f))) {
            return false;
        }
        boolean O0000Ooo2 = O0000Ooo();
        boolean O0000Ooo3 = ioVar.O0000Ooo();
        if ((O0000Ooo2 || O0000Ooo3) && (!O0000Ooo2 || !O0000Ooo3 || !this.g.equals(ioVar.g))) {
            return false;
        }
        boolean O0000o002 = O0000o00();
        boolean O0000o003 = ioVar.O0000o00();
        if ((O0000o002 || O0000o003) && (!O0000o002 || !O0000o003 || !this.h.equals(ioVar.h))) {
            return false;
        }
        boolean O0000o02 = O0000o0();
        boolean O0000o03 = ioVar.O0000o0();
        if ((O0000o02 || O0000o03) && (!O0000o02 || !O0000o03 || !this.i.equals(ioVar.i))) {
            return false;
        }
        boolean O0000o0O2 = O0000o0O();
        boolean O0000o0O3 = ioVar.O0000o0O();
        if ((O0000o0O2 || O0000o0O3) && (!O0000o0O2 || !O0000o0O3 || !this.f131a.equals(ioVar.f131a))) {
            return false;
        }
        boolean O0000o0o2 = O0000o0o();
        boolean O0000o0o3 = ioVar.O0000o0o();
        if ((O0000o0o2 || O0000o0o3) && (!O0000o0o2 || !O0000o0o3 || this.f6432a != ioVar.f6432a)) {
            return false;
        }
        boolean O0000o = O0000o();
        boolean O0000o2 = ioVar.O0000o();
        if (O0000o || O0000o2) {
            return O0000o && O0000o2 && this.f135b == ioVar.f135b;
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
                        this.f130a = esd.O0000Ooo();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case 2:
                    if (O00000Oo2.O00000Oo == 12) {
                        this.f129a = new ie();
                        this.f129a.O000000o(esd);
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
                    if (O00000Oo2.O00000Oo == 2) {
                        this.f134a = esd.O00000oo();
                        O0000OOo();
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
                    if (O00000Oo2.O00000Oo == 13) {
                        esc O00000o02 = esd.O00000o0();
                        this.f133a = new HashMap(O00000o02.O00000o0 * 2);
                        for (int i2 = 0; i2 < O00000o02.O00000o0; i2++) {
                            this.f133a.put(esd.O0000Ooo(), esd.O0000Ooo());
                        }
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
                case 16:
                case 17:
                case 18:
                case 19:
                default:
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
                        this.f131a = esd.O0000o00();
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    if (O00000Oo2.O00000Oo != 10) {
                        ese.O000000o(esd, O00000Oo2.O00000Oo);
                        break;
                    } else {
                        this.f6432a = esd.O0000Oo();
                        this.f132a.set(1, true);
                        break;
                    }
                case 20:
                    if (O00000Oo2.O00000Oo == 2) {
                        this.f135b = esd.O00000oo();
                        this.f132a.set(2, true);
                        break;
                    }
                    ese.O000000o(esd, O00000Oo2.O00000Oo);
                    break;
            }
        }
        if (O0000O0o()) {
            O0000oO0();
            return;
        }
        throw new jm("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
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
        io ioVar = (io) obj;
        if (!getClass().equals(ioVar.getClass())) {
            return getClass().getName().compareTo(ioVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(ioVar.O00000Oo()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O00000Oo() && (O000000o16 = erw.O000000o(this.f130a, ioVar.f130a)) != 0) {
            return O000000o16;
        }
        int compareTo2 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ioVar.O00000o0()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000o0() && (O000000o15 = erw.O000000o(this.f129a, ioVar.f129a)) != 0) {
            return O000000o15;
        }
        int compareTo3 = Boolean.valueOf(O00000o()).compareTo(Boolean.valueOf(ioVar.O00000o()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000o() && (O000000o14 = erw.O000000o(this.b, ioVar.b)) != 0) {
            return O000000o14;
        }
        int compareTo4 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(ioVar.O00000oO()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O00000oO() && (O000000o13 = erw.O000000o(this.c, ioVar.c)) != 0) {
            return O000000o13;
        }
        int compareTo5 = Boolean.valueOf(O00000oo()).compareTo(Boolean.valueOf(ioVar.O00000oo()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O00000oo() && (O000000o12 = erw.O000000o(this.d, ioVar.d)) != 0) {
            return O000000o12;
        }
        int compareTo6 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(ioVar.O0000O0o()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O0000O0o() && (O000000o11 = erw.O000000o(this.f134a, ioVar.f134a)) != 0) {
            return O000000o11;
        }
        int compareTo7 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(ioVar.O0000Oo0()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000Oo0() && (O000000o10 = erw.O000000o(this.e, ioVar.e)) != 0) {
            return O000000o10;
        }
        int compareTo8 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(ioVar.O0000Oo()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (O0000Oo() && (O000000o9 = erw.O000000o(this.f133a, ioVar.f133a)) != 0) {
            return O000000o9;
        }
        int compareTo9 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(ioVar.O0000OoO()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (O0000OoO() && (O000000o8 = erw.O000000o(this.f, ioVar.f)) != 0) {
            return O000000o8;
        }
        int compareTo10 = Boolean.valueOf(O0000Ooo()).compareTo(Boolean.valueOf(ioVar.O0000Ooo()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (O0000Ooo() && (O000000o7 = erw.O000000o(this.g, ioVar.g)) != 0) {
            return O000000o7;
        }
        int compareTo11 = Boolean.valueOf(O0000o00()).compareTo(Boolean.valueOf(ioVar.O0000o00()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (O0000o00() && (O000000o6 = erw.O000000o(this.h, ioVar.h)) != 0) {
            return O000000o6;
        }
        int compareTo12 = Boolean.valueOf(O0000o0()).compareTo(Boolean.valueOf(ioVar.O0000o0()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (O0000o0() && (O000000o5 = erw.O000000o(this.i, ioVar.i)) != 0) {
            return O000000o5;
        }
        int compareTo13 = Boolean.valueOf(O0000o0O()).compareTo(Boolean.valueOf(ioVar.O0000o0O()));
        if (compareTo13 != 0) {
            return compareTo13;
        }
        if (O0000o0O() && (O000000o4 = erw.O000000o(this.f131a, ioVar.f131a)) != 0) {
            return O000000o4;
        }
        int compareTo14 = Boolean.valueOf(O0000o0o()).compareTo(Boolean.valueOf(ioVar.O0000o0o()));
        if (compareTo14 != 0) {
            return compareTo14;
        }
        if (O0000o0o() && (O000000o3 = erw.O000000o(this.f6432a, ioVar.f6432a)) != 0) {
            return O000000o3;
        }
        int compareTo15 = Boolean.valueOf(O0000o()).compareTo(Boolean.valueOf(ioVar.O0000o()));
        if (compareTo15 != 0) {
            return compareTo15;
        }
        if (!O0000o() || (O000000o2 = erw.O000000o(this.f135b, ioVar.f135b)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
