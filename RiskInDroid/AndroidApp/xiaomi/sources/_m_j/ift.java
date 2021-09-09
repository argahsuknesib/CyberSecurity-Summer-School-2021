package _m_j;

abstract class ift extends ifv {
    ift(idl idl) {
        super(idl);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        O000000o(sb, i, length);
    }

    private static void O000000o(StringBuilder sb, int i) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 13; i4++) {
            int charAt = sb.charAt(i4 + i) - '0';
            if ((i4 & 1) == 0) {
                charAt *= 3;
            }
            i3 += charAt;
        }
        int i5 = 10 - (i3 % 10);
        if (i5 != 10) {
            i2 = i5;
        }
        sb.append(i2);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int O000000o2 = this.O00000Oo.O000000o((i3 * 10) + i, 10);
            if (O000000o2 / 100 == 0) {
                sb.append('0');
            }
            if (O000000o2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(O000000o2);
        }
        O000000o(sb, i2);
    }
}
