package _m_j;

public final class bi {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Object f12986O000000o;

    bi(Object obj) {
        this.f12986O000000o = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bi biVar = (bi) obj;
        Object obj2 = this.f12986O000000o;
        if (obj2 == null) {
            return biVar.f12986O000000o == null;
        }
        return obj2.equals(biVar.f12986O000000o);
    }

    public final int hashCode() {
        Object obj = this.f12986O000000o;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f12986O000000o + "}";
    }
}
