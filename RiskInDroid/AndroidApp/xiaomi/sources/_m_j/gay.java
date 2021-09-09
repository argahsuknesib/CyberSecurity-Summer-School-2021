package _m_j;

public final class gay {

    /* renamed from: O000000o  reason: collision with root package name */
    final int[] f17474O000000o = new int[16];

    public final void O000000o(String str, CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence);
        sb.append('[');
        for (int i = 0; i < this.f17474O000000o.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            if (i < this.f17474O000000o.length - 1) {
                sb.append("<");
                sb.append(1 << i);
            } else {
                sb.append(">=");
                sb.append(1 << (i - 1));
            }
            sb.append(": ");
            sb.append(this.f17474O000000o[i]);
        }
        sb.append("]");
        gsy.O000000o(3, str, sb.toString());
    }
}
