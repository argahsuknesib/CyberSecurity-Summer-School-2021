package com.xiaomi.push;

import _m_j.erw;
import _m_j.esa;
import _m_j.esd;
import _m_j.ese;
import _m_j.esg;
import com.google.android.exoplayer2.C;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

public class il implements ja<il, Object>, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final esg f6425O000000o = new esg("XmPushActionContainer");
    private static final esa O00000Oo = new esa("", (byte) 8, 1);
    private static final esa O00000o = new esa("", (byte) 2, 3);
    private static final esa O00000o0 = new esa("", (byte) 2, 2);
    private static final esa O00000oO = new esa("", (byte) 11, 4);
    private static final esa O00000oo = new esa("", (byte) 11, 5);
    private static final esa O0000O0o = new esa("", (byte) 11, 6);
    private static final esa O0000OOo = new esa("", (byte) 12, 7);
    private static final esa O0000Oo0 = new esa("", (byte) 12, 8);

    /* renamed from: a  reason: collision with root package name */
    public hp f6426a;

    /* renamed from: a  reason: collision with other field name */
    public ic f122a;

    /* renamed from: a  reason: collision with other field name */
    public ie f123a;

    /* renamed from: a  reason: collision with other field name */
    public String f124a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f125a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f126a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f127a = true;
    public String b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f128b = true;

    private boolean O00000Oo() {
        return this.f6426a != null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000o() {
        this.f126a.set(0, true);
    }

    private boolean O00000o0() {
        return this.f126a.get(0);
    }

    private boolean O00000oO() {
        return this.f126a.get(1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.BitSet.set(int, boolean):void}
     arg types: [int, int]
     candidates:
      ClspMth{java.util.BitSet.set(int, int):void}
      ClspMth{java.util.BitSet.set(int, boolean):void} */
    private void O00000oo() {
        this.f126a.set(1, true);
    }

    private boolean O0000O0o() {
        return this.f125a != null;
    }

    private boolean O0000OOo() {
        return this.f124a != null;
    }

    private boolean O0000Oo() {
        return this.f123a != null;
    }

    private boolean O0000Oo0() {
        return this.b != null;
    }

    private boolean O0000OoO() {
        return this.f122a != null;
    }

    private void O0000Ooo() {
        if (this.f6426a == null) {
            throw new jm("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f125a == null) {
            throw new jm("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f123a == null) {
            throw new jm("Required field 'target' was not present! Struct: " + toString());
        }
    }

    public final il O000000o(boolean z) {
        this.f127a = z;
        O00000o();
        return this;
    }

    public final void O000000o(esd esd) {
        while (true) {
            esa O00000Oo2 = esd.O00000Oo();
            if (O00000Oo2.O00000Oo == 0) {
                break;
            }
            switch (O00000Oo2.O00000o0) {
                case 1:
                    if (O00000Oo2.O00000Oo == 8) {
                        this.f6426a = hp.a(esd.O0000Oo0());
                        continue;
                    }
                    break;
                case 2:
                    if (O00000Oo2.O00000Oo == 2) {
                        this.f127a = esd.O00000oo();
                        O00000o();
                        continue;
                    }
                    break;
                case 3:
                    if (O00000Oo2.O00000Oo == 2) {
                        this.f128b = esd.O00000oo();
                        O00000oo();
                        continue;
                    }
                    break;
                case 4:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f125a = esd.O0000o00();
                        continue;
                    }
                    break;
                case 5:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.f124a = esd.O0000Ooo();
                        continue;
                    }
                    break;
                case 6:
                    if (O00000Oo2.O00000Oo == 11) {
                        this.b = esd.O0000Ooo();
                        continue;
                    }
                    break;
                case 7:
                    if (O00000Oo2.O00000Oo == 12) {
                        this.f123a = new ie();
                        this.f123a.O000000o(esd);
                        continue;
                    }
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    if (O00000Oo2.O00000Oo == 12) {
                        this.f122a = new ic();
                        this.f122a.O000000o(esd);
                        continue;
                    }
                    break;
            }
            ese.O000000o(esd, O00000Oo2.O00000Oo);
        }
        if (!O00000o0()) {
            throw new jm("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
        } else if (O00000oO()) {
            O0000Ooo();
        } else {
            throw new jm("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
        }
    }

    public final il O00000Oo(boolean z) {
        this.f128b = z;
        O00000oo();
        return this;
    }

    public final void O00000Oo(esd esd) {
        O0000Ooo();
        if (this.f6426a != null) {
            esd.O000000o(O00000Oo);
            esd.O000000o(this.f6426a.a());
        }
        esd.O000000o(O00000o0);
        esd.O000000o(this.f127a);
        esd.O000000o(O00000o);
        esd.O000000o(this.f128b);
        if (this.f125a != null) {
            esd.O000000o(O00000oO);
            esd.O000000o(this.f125a);
        }
        if (this.f124a != null && O0000OOo()) {
            esd.O000000o(O00000oo);
            esd.O000000o(this.f124a);
        }
        if (this.b != null && O0000Oo0()) {
            esd.O000000o(O0000O0o);
            esd.O000000o(this.b);
        }
        if (this.f123a != null) {
            esd.O000000o(O0000OOo);
            this.f123a.O00000Oo(esd);
        }
        if (this.f122a != null && O0000OoO()) {
            esd.O000000o(O0000Oo0);
            this.f122a.O00000Oo(esd);
        }
        esd.O000000o();
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        hp hpVar = this.f6426a;
        if (hpVar == null) {
            sb.append("null");
        } else {
            sb.append(hpVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f127a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f128b);
        sb.append(", ");
        sb.append("pushAction:");
        ByteBuffer byteBuffer = this.f125a;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            erw.O000000o(byteBuffer, sb);
        }
        if (O0000OOo()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f124a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (O0000Oo0()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        ie ieVar = this.f123a;
        if (ieVar == null) {
            sb.append("null");
        } else {
            sb.append(ieVar);
        }
        if (O0000OoO()) {
            sb.append(", ");
            sb.append("metaInfo:");
            ic icVar = this.f122a;
            if (icVar == null) {
                sb.append("null");
            } else {
                sb.append(icVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public final byte[] O000000o() {
        this.f125a = erw.O000000o(this.f125a);
        return this.f125a.array();
    }

    public boolean equals(Object obj) {
        il ilVar;
        if (obj == null || !(obj instanceof il) || (ilVar = (il) obj) == null) {
            return false;
        }
        boolean O00000Oo2 = O00000Oo();
        boolean O00000Oo3 = ilVar.O00000Oo();
        if (((O00000Oo2 || O00000Oo3) && (!O00000Oo2 || !O00000Oo3 || !this.f6426a.equals(ilVar.f6426a))) || this.f127a != ilVar.f127a || this.f128b != ilVar.f128b) {
            return false;
        }
        boolean O0000O0o2 = O0000O0o();
        boolean O0000O0o3 = ilVar.O0000O0o();
        if ((O0000O0o2 || O0000O0o3) && (!O0000O0o2 || !O0000O0o3 || !this.f125a.equals(ilVar.f125a))) {
            return false;
        }
        boolean O0000OOo2 = O0000OOo();
        boolean O0000OOo3 = ilVar.O0000OOo();
        if ((O0000OOo2 || O0000OOo3) && (!O0000OOo2 || !O0000OOo3 || !this.f124a.equals(ilVar.f124a))) {
            return false;
        }
        boolean O0000Oo02 = O0000Oo0();
        boolean O0000Oo03 = ilVar.O0000Oo0();
        if ((O0000Oo02 || O0000Oo03) && (!O0000Oo02 || !O0000Oo03 || !this.b.equals(ilVar.b))) {
            return false;
        }
        boolean O0000Oo = O0000Oo();
        boolean O0000Oo2 = ilVar.O0000Oo();
        if ((O0000Oo || O0000Oo2) && (!O0000Oo || !O0000Oo2 || !this.f123a.O000000o(ilVar.f123a))) {
            return false;
        }
        boolean O0000OoO = O0000OoO();
        boolean O0000OoO2 = ilVar.O0000OoO();
        if (O0000OoO || O0000OoO2) {
            return O0000OoO && O0000OoO2 && this.f122a.O000000o(ilVar.f122a);
        }
        return true;
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
        il ilVar = (il) obj;
        if (!getClass().equals(ilVar.getClass())) {
            return getClass().getName().compareTo(ilVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(O00000Oo()).compareTo(Boolean.valueOf(ilVar.O00000Oo()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (O00000Oo() && (O000000o9 = erw.O000000o(this.f6426a, ilVar.f6426a)) != 0) {
            return O000000o9;
        }
        int compareTo2 = Boolean.valueOf(O00000o0()).compareTo(Boolean.valueOf(ilVar.O00000o0()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (O00000o0() && (O000000o8 = erw.O000000o(this.f127a, ilVar.f127a)) != 0) {
            return O000000o8;
        }
        int compareTo3 = Boolean.valueOf(O00000oO()).compareTo(Boolean.valueOf(ilVar.O00000oO()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (O00000oO() && (O000000o7 = erw.O000000o(this.f128b, ilVar.f128b)) != 0) {
            return O000000o7;
        }
        int compareTo4 = Boolean.valueOf(O0000O0o()).compareTo(Boolean.valueOf(ilVar.O0000O0o()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (O0000O0o() && (O000000o6 = erw.O000000o(this.f125a, ilVar.f125a)) != 0) {
            return O000000o6;
        }
        int compareTo5 = Boolean.valueOf(O0000OOo()).compareTo(Boolean.valueOf(ilVar.O0000OOo()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (O0000OOo() && (O000000o5 = erw.O000000o(this.f124a, ilVar.f124a)) != 0) {
            return O000000o5;
        }
        int compareTo6 = Boolean.valueOf(O0000Oo0()).compareTo(Boolean.valueOf(ilVar.O0000Oo0()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (O0000Oo0() && (O000000o4 = erw.O000000o(this.b, ilVar.b)) != 0) {
            return O000000o4;
        }
        int compareTo7 = Boolean.valueOf(O0000Oo()).compareTo(Boolean.valueOf(ilVar.O0000Oo()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (O0000Oo() && (O000000o3 = erw.O000000o(this.f123a, ilVar.f123a)) != 0) {
            return O000000o3;
        }
        int compareTo8 = Boolean.valueOf(O0000OoO()).compareTo(Boolean.valueOf(ilVar.O0000OoO()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!O0000OoO() || (O000000o2 = erw.O000000o(this.f122a, ilVar.f122a)) == 0) {
            return 0;
        }
        return O000000o2;
    }
}
