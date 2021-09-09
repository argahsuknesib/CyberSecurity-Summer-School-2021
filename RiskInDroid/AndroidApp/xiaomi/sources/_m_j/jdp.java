package _m_j;

public final class jdp extends jdu {
    public static jdp O000000o() {
        return new jdp(32, 127);
    }

    private jdp(int i, int i2) {
        super(32, 127, false);
    }

    /* access modifiers changed from: protected */
    public final String O00000Oo(int i) {
        char[] chars = Character.toChars(i);
        return "\\u" + O000000o(chars[0]) + "\\u" + O000000o(chars[1]);
    }
}
