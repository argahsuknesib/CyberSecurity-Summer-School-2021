package _m_j;

import com.xiaomi.zxing.NotFoundException;

final class ifq extends ifu {
    private final String O00000o;
    private final String O00000o0;

    ifq(idl idl, String str, String str2) {
        super(idl);
        this.O00000o0 = str2;
        this.O00000o = str;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(StringBuilder sb, int i) {
        sb.append('(');
        sb.append(this.O00000o);
        sb.append(i / 100000);
        sb.append(')');
    }

    /* access modifiers changed from: protected */
    public final int O000000o(int i) {
        return i % 100000;
    }

    public final String O000000o() throws NotFoundException {
        if (this.f1260O000000o.O00000Oo == 84) {
            StringBuilder sb = new StringBuilder();
            O00000Oo(sb, 8);
            O00000Oo(sb, 48, 20);
            int O000000o2 = this.O00000Oo.O000000o(68, 16);
            if (O000000o2 != 38400) {
                sb.append('(');
                sb.append(this.O00000o0);
                sb.append(')');
                int i = O000000o2 % 32;
                int i2 = O000000o2 / 32;
                int i3 = (i2 % 12) + 1;
                int i4 = i2 / 12;
                if (i4 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i4);
                if (i3 / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i3);
                if (i / 10 == 0) {
                    sb.append('0');
                }
                sb.append(i);
            }
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
