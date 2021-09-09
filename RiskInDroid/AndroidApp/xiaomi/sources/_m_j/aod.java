package _m_j;

public final class aod {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Class<?> f12501O000000o;
    protected final int O00000Oo;
    protected String O00000o0;

    public aod(Class<?> cls, String str) {
        this.f12501O000000o = cls;
        this.O00000Oo = cls.getName().hashCode();
        this.O00000o0 = (str == null || str.length() == 0) ? null : str;
    }

    public final Class<?> O000000o() {
        return this.f12501O000000o;
    }

    public final String O00000Oo() {
        return this.O00000o0;
    }

    public final boolean O00000o0() {
        return this.O00000o0 != null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == getClass() && this.f12501O000000o == ((aod) obj).f12501O000000o;
    }

    public final int hashCode() {
        return this.O00000Oo;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[NamedType, class ");
        sb.append(this.f12501O000000o.getName());
        sb.append(", name: ");
        if (this.O00000o0 == null) {
            str = "null";
        } else {
            str = "'" + this.O00000o0 + "'";
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }
}
