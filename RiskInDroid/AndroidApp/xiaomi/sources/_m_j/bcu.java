package _m_j;

import java.util.Objects;

public final class bcu {

    /* renamed from: O000000o  reason: collision with root package name */
    public final float f12873O000000o;
    public final String O00000Oo;

    public bcu(float f, String str) {
        this.f12873O000000o = f;
        this.O00000Oo = str;
    }

    public final int hashCode() {
        return Objects.hash(Float.valueOf(this.f12873O000000o), this.O00000Oo);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bcu)) {
            return false;
        }
        bcu bcu = (bcu) obj;
        if (this.f12873O000000o != bcu.f12873O000000o || !Objects.equals(this.O00000Oo, bcu.O00000Oo)) {
            return false;
        }
        return true;
    }
}
