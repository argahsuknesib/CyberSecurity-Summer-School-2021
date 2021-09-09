package _m_j;

final class jgm {

    /* renamed from: O000000o  reason: collision with root package name */
    final Object f1826O000000o;
    final jgk O00000Oo;
    volatile boolean O00000o0 = true;

    jgm(Object obj, jgk jgk) {
        this.f1826O000000o = obj;
        this.O00000Oo = jgk;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof jgm) {
            jgm jgm = (jgm) obj;
            if (this.f1826O000000o != jgm.f1826O000000o || !this.O00000Oo.equals(jgm.O00000Oo)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f1826O000000o.hashCode() + this.O00000Oo.O00000oo.hashCode();
    }
}
