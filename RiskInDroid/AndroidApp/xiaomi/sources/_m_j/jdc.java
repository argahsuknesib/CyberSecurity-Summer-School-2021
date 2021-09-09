package _m_j;

public final class jdc implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected char[] f1773O000000o;
    protected int O00000Oo;
    private String O00000o0;

    public jdc() {
        this(32);
    }

    public jdc(int i) {
        this.f1773O000000o = new char[(i <= 0 ? 32 : i)];
    }

    public jdc(String str) {
        this.f1773O000000o = new char[(str.length() + 32)];
        O000000o(str);
    }

    private jdc O000000o(int i) {
        char[] cArr = this.f1773O000000o;
        if (i > cArr.length) {
            this.f1773O000000o = new char[(i * 2)];
            System.arraycopy(cArr, 0, this.f1773O000000o, 0, this.O00000Oo);
        }
        return this;
    }

    public final jdc O000000o() {
        String str = this.O00000o0;
        if (str == null) {
            return this;
        }
        return O000000o(str);
    }

    public final jdc O000000o(String str) {
        if (str == null) {
            return O000000o();
        }
        int length = str.length();
        if (length > 0) {
            int i = this.O00000Oo;
            O000000o(i + length);
            str.getChars(0, length, this.f1773O000000o, i);
            this.O00000Oo += length;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jdc)) {
            return false;
        }
        jdc jdc = (jdc) obj;
        if (this != jdc) {
            int i = this.O00000Oo;
            if (i != jdc.O00000Oo) {
                return false;
            }
            char[] cArr = this.f1773O000000o;
            char[] cArr2 = jdc.f1773O000000o;
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (cArr[i2] != cArr2[i2]) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        char[] cArr = this.f1773O000000o;
        int i = 0;
        for (int i2 = this.O00000Oo - 1; i2 >= 0; i2--) {
            i = (i * 31) + cArr[i2];
        }
        return i;
    }

    public final String toString() {
        return new String(this.f1773O000000o, 0, this.O00000Oo);
    }

    public final Object clone() throws CloneNotSupportedException {
        jdc jdc = (jdc) super.clone();
        jdc.f1773O000000o = new char[this.f1773O000000o.length];
        char[] cArr = this.f1773O000000o;
        System.arraycopy(cArr, 0, jdc.f1773O000000o, 0, cArr.length);
        return jdc;
    }
}
