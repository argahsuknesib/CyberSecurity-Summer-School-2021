package _m_j;

abstract class ifu extends ift {
    /* access modifiers changed from: protected */
    public abstract int O000000o(int i);

    /* access modifiers changed from: protected */
    public abstract void O000000o(StringBuilder sb, int i);

    ifu(idl idl) {
        super(idl);
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(StringBuilder sb, int i, int i2) {
        int O000000o2 = this.O00000Oo.O000000o(i, i2);
        O000000o(sb, O000000o2);
        int O000000o3 = O000000o(O000000o2);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (O000000o3 / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(O000000o3);
    }
}
