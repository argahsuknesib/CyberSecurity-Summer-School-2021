package _m_j;

import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.oned.rss.expanded.decoders.CurrentParsingState;

final class igd {

    /* renamed from: O000000o  reason: collision with root package name */
    private final idl f1267O000000o;
    private final CurrentParsingState O00000Oo = new CurrentParsingState();
    private final StringBuilder O00000o0 = new StringBuilder();

    igd(idl idl) {
        this.f1267O000000o = idl;
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str;
        String str2 = null;
        while (true) {
            ifz O000000o2 = O000000o(i, str2);
            String O000000o3 = igc.O000000o(O000000o2.f1263O000000o);
            if (O000000o3 != null) {
                sb.append(O000000o3);
            }
            if (O000000o2.O00000o0) {
                str = String.valueOf(O000000o2.O00000Oo);
            } else {
                str = null;
            }
            if (i == O000000o2.O00000o) {
                return sb.toString();
            }
            i = O000000o2.O00000o;
            str2 = str;
        }
    }

    private boolean O000000o(int i) {
        if (i + 7 <= this.f1267O000000o.O00000Oo) {
            int i2 = i;
            while (true) {
                int i3 = i + 3;
                if (i2 >= i3) {
                    return this.f1267O000000o.O000000o(i3);
                }
                if (this.f1267O000000o.O000000o(i2)) {
                    return true;
                }
                i2++;
            }
        } else if (i + 4 <= this.f1267O000000o.O00000Oo) {
            return true;
        } else {
            return false;
        }
    }

    private iga O00000Oo(int i) throws FormatException {
        int i2 = i + 7;
        if (i2 > this.f1267O000000o.O00000Oo) {
            int O000000o2 = O000000o(i, 4);
            if (O000000o2 == 0) {
                return new iga(this.f1267O000000o.O00000Oo, 10, 10);
            }
            return new iga(this.f1267O000000o.O00000Oo, O000000o2 - 1, 10);
        }
        int O000000o3 = O000000o(i, 7) - 8;
        return new iga(i2, O000000o3 / 11, O000000o3 % 11);
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(int i, int i2) {
        return O000000o(this.f1267O000000o, i, i2);
    }

    static int O000000o(idl idl, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (idl.O000000o(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final ifz O000000o(int i, String str) throws FormatException {
        this.O00000o0.setLength(0);
        if (str != null) {
            this.O00000o0.append(str);
        }
        this.O00000Oo.f12116O000000o = i;
        ifz O000000o2 = O000000o();
        if (O000000o2 == null || !O000000o2.O00000o0) {
            return new ifz(this.O00000Oo.f12116O000000o, this.O00000o0.toString());
        }
        return new ifz(this.O00000Oo.f12116O000000o, this.O00000o0.toString(), O000000o2.O00000Oo);
    }

    private ifz O000000o() throws FormatException {
        boolean z;
        ifx ifx;
        do {
            int i = this.O00000Oo.f12116O000000o;
            if (this.O00000Oo.O000000o()) {
                ifx = O00000o();
                z = ifx.O00000Oo;
            } else if (this.O00000Oo.O00000Oo()) {
                ifx = O00000o0();
                z = ifx.O00000Oo;
            } else {
                ifx = O00000Oo();
                z = ifx.O00000Oo;
            }
            if (!(i != this.O00000Oo.f12116O000000o) && !z) {
                break;
            }
        } while (!z);
        return ifx.f1261O000000o;
    }

    private ifx O00000Oo() throws FormatException {
        ifz ifz;
        while (O000000o(this.O00000Oo.f12116O000000o)) {
            iga O00000Oo2 = O00000Oo(this.O00000Oo.f12116O000000o);
            this.O00000Oo.f12116O000000o = O00000Oo2.O00000o;
            if (O00000Oo2.O000000o()) {
                if (O00000Oo2.O00000Oo()) {
                    ifz = new ifz(this.O00000Oo.f12116O000000o, this.O00000o0.toString());
                } else {
                    ifz = new ifz(this.O00000Oo.f12116O000000o, this.O00000o0.toString(), O00000Oo2.O00000Oo);
                }
                return new ifx(ifz, true);
            }
            this.O00000o0.append(O00000Oo2.f1265O000000o);
            if (O00000Oo2.O00000Oo()) {
                return new ifx(new ifz(this.O00000Oo.f12116O000000o, this.O00000o0.toString()), true);
            }
            this.O00000o0.append(O00000Oo2.O00000Oo);
        }
        if (O0000Oo0(this.O00000Oo.f12116O000000o)) {
            this.O00000Oo.O00000Oo = CurrentParsingState.State.ALPHA;
            this.O00000Oo.O000000o(4);
        }
        return new ifx();
    }

    private ifx O00000o0() throws FormatException {
        while (O00000o0(this.O00000Oo.f12116O000000o)) {
            ify O00000o = O00000o(this.O00000Oo.f12116O000000o);
            this.O00000Oo.f12116O000000o = O00000o.O00000o;
            if (O00000o.O000000o()) {
                return new ifx(new ifz(this.O00000Oo.f12116O000000o, this.O00000o0.toString()), true);
            }
            this.O00000o0.append(O00000o.f1262O000000o);
        }
        if (O0000OOo(this.O00000Oo.f12116O000000o)) {
            this.O00000Oo.O000000o(3);
            this.O00000Oo.O00000Oo = CurrentParsingState.State.NUMERIC;
        } else if (O0000O0o(this.O00000Oo.f12116O000000o)) {
            if (this.O00000Oo.f12116O000000o + 5 < this.f1267O000000o.O00000Oo) {
                this.O00000Oo.O000000o(5);
            } else {
                this.O00000Oo.f12116O000000o = this.f1267O000000o.O00000Oo;
            }
            this.O00000Oo.O00000Oo = CurrentParsingState.State.ALPHA;
        }
        return new ifx();
    }

    private ifx O00000o() {
        while (O00000oO(this.O00000Oo.f12116O000000o)) {
            ify O00000oo = O00000oo(this.O00000Oo.f12116O000000o);
            this.O00000Oo.f12116O000000o = O00000oo.O00000o;
            if (O00000oo.O000000o()) {
                return new ifx(new ifz(this.O00000Oo.f12116O000000o, this.O00000o0.toString()), true);
            }
            this.O00000o0.append(O00000oo.f1262O000000o);
        }
        if (O0000OOo(this.O00000Oo.f12116O000000o)) {
            this.O00000Oo.O000000o(3);
            this.O00000Oo.O00000Oo = CurrentParsingState.State.NUMERIC;
        } else if (O0000O0o(this.O00000Oo.f12116O000000o)) {
            if (this.O00000Oo.f12116O000000o + 5 < this.f1267O000000o.O00000Oo) {
                this.O00000Oo.O000000o(5);
            } else {
                this.O00000Oo.f12116O000000o = this.f1267O000000o.O00000Oo;
            }
            this.O00000Oo.O00000Oo = CurrentParsingState.State.ISO_IEC_646;
        }
        return new ifx();
    }

    private boolean O00000o0(int i) {
        int O000000o2;
        if (i + 5 > this.f1267O000000o.O00000Oo) {
            return false;
        }
        int O000000o3 = O000000o(i, 5);
        if (O000000o3 >= 5 && O000000o3 < 16) {
            return true;
        }
        if (i + 7 > this.f1267O000000o.O00000Oo) {
            return false;
        }
        int O000000o4 = O000000o(i, 7);
        if (O000000o4 < 64 || O000000o4 >= 116) {
            return i + 8 <= this.f1267O000000o.O00000Oo && (O000000o2 = O000000o(i, 8)) >= 232 && O000000o2 < 253;
        }
        return true;
    }

    private ify O00000o(int i) throws FormatException {
        char c;
        int O000000o2 = O000000o(i, 5);
        if (O000000o2 == 15) {
            return new ify(i + 5, '$');
        }
        if (O000000o2 >= 5 && O000000o2 < 15) {
            return new ify(i + 5, (char) ((O000000o2 + 48) - 5));
        }
        int O000000o3 = O000000o(i, 7);
        if (O000000o3 >= 64 && O000000o3 < 90) {
            return new ify(i + 7, (char) (O000000o3 + 1));
        }
        if (O000000o3 >= 90 && O000000o3 < 116) {
            return new ify(i + 7, (char) (O000000o3 + 7));
        }
        switch (O000000o(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new ify(i + 8, c);
    }

    private boolean O00000oO(int i) {
        int O000000o2;
        if (i + 5 > this.f1267O000000o.O00000Oo) {
            return false;
        }
        int O000000o3 = O000000o(i, 5);
        if (O000000o3 < 5 || O000000o3 >= 16) {
            return i + 6 <= this.f1267O000000o.O00000Oo && (O000000o2 = O000000o(i, 6)) >= 16 && O000000o2 < 63;
        }
        return true;
    }

    private ify O00000oo(int i) {
        char c;
        int O000000o2 = O000000o(i, 5);
        if (O000000o2 == 15) {
            return new ify(i + 5, '$');
        }
        if (O000000o2 >= 5 && O000000o2 < 15) {
            return new ify(i + 5, (char) ((O000000o2 + 48) - 5));
        }
        int O000000o3 = O000000o(i, 6);
        if (O000000o3 >= 32 && O000000o3 < 58) {
            return new ify(i + 6, (char) (O000000o3 + 33));
        }
        switch (O000000o3) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(O000000o3)));
        }
        return new ify(i + 6, c);
    }

    private boolean O0000O0o(int i) {
        int i2;
        if (i + 1 > this.f1267O000000o.O00000Oo) {
            return false;
        }
        int i3 = 0;
        while (i3 < 5 && (i2 = i3 + i) < this.f1267O000000o.O00000Oo) {
            if (i3 == 2) {
                if (!this.f1267O000000o.O000000o(i + 2)) {
                    return false;
                }
            } else if (this.f1267O000000o.O000000o(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }

    private boolean O0000OOo(int i) {
        int i2 = i + 3;
        if (i2 > this.f1267O000000o.O00000Oo) {
            return false;
        }
        while (i < i2) {
            if (this.f1267O000000o.O000000o(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean O0000Oo0(int i) {
        int i2;
        if (i + 1 > this.f1267O000000o.O00000Oo) {
            return false;
        }
        int i3 = 0;
        while (i3 < 4 && (i2 = i3 + i) < this.f1267O000000o.O00000Oo) {
            if (this.f1267O000000o.O000000o(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }
}
