package _m_j;

public final class gkz {

    /* renamed from: O000000o  reason: collision with root package name */
    private char[] f17952O000000o;
    private int O00000Oo;

    public gkz(int i) {
        if (i >= 0) {
            this.f17952O000000o = new char[i];
            return;
        }
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    private void O000000o(int i) {
        char[] cArr = new char[Math.max(this.f17952O000000o.length << 1, i)];
        System.arraycopy(this.f17952O000000o, 0, cArr, 0, this.O00000Oo);
        this.f17952O000000o = cArr;
    }

    public final void O000000o(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.O00000Oo + length;
        if (i > this.f17952O000000o.length) {
            O000000o(i);
        }
        str.getChars(0, length, this.f17952O000000o, this.O00000Oo);
        this.O00000Oo = i;
    }

    public final String toString() {
        return new String(this.f17952O000000o, 0, this.O00000Oo);
    }
}
