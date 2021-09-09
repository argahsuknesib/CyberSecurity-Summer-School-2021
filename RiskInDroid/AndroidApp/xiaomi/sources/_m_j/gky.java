package _m_j;

public final class gky implements gkw, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f17951O000000o;
    private final String O00000Oo;

    public gky(String str, String str2) {
        if (str != null) {
            this.f17951O000000o = str;
            this.O00000Oo = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public final String O000000o() {
        return this.f17951O000000o;
    }

    public final String O00000Oo() {
        return this.O00000Oo;
    }

    public final String toString() {
        int length = this.f17951O000000o.length();
        String str = this.O00000Oo;
        if (str != null) {
            length += str.length() + 1;
        }
        gkz gkz = new gkz(length);
        gkz.O000000o(this.f17951O000000o);
        if (this.O00000Oo != null) {
            gkz.O000000o("=");
            gkz.O000000o(this.O00000Oo);
        }
        return gkz.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof gkw) {
            gky gky = (gky) obj;
            if (this.f17951O000000o.equals(gky.f17951O000000o)) {
                String str = this.O00000Oo;
                String str2 = gky.O00000Oo;
                if (str == null ? str2 == null : str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return gla.O000000o(gla.O000000o(17, this.f17951O000000o), this.O00000Oo);
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
