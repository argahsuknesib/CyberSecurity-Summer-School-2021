package _m_j;

public final class ash implements Comparable<ash> {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f12569O000000o;
    private Class<?> O00000Oo;
    private int O00000o0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f12569O000000o.compareTo(((ash) obj).f12569O000000o);
    }

    public ash() {
        this.O00000Oo = null;
        this.f12569O000000o = null;
        this.O00000o0 = 0;
    }

    public ash(Class<?> cls) {
        this.O00000Oo = cls;
        this.f12569O000000o = cls.getName();
        this.O00000o0 = this.f12569O000000o.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == getClass() && ((ash) obj).O00000Oo == this.O00000Oo;
    }

    public final int hashCode() {
        return this.O00000o0;
    }

    public final String toString() {
        return this.f12569O000000o;
    }
}
