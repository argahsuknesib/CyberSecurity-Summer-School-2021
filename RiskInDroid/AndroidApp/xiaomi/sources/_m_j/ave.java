package _m_j;

public final class ave implements Comparable<ave> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f12637O000000o;
    private final String O00000Oo;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        ave ave = (ave) obj;
        int compareTo = this.f12637O000000o.compareTo(ave.f12637O000000o);
        return compareTo == 0 ? this.O00000Oo.compareTo(ave.O00000Oo) : compareTo;
    }

    public ave(String str, String str2) {
        this.f12637O000000o = str;
        this.O00000Oo = str2;
    }

    public final String O000000o() {
        return avs.O000000o(this.f12637O000000o).concat("=").concat(avs.O000000o(this.O00000Oo));
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ave)) {
            return false;
        }
        ave ave = (ave) obj;
        return ave.f12637O000000o.equals(this.f12637O000000o) && ave.O00000Oo.equals(this.O00000Oo);
    }

    public final int hashCode() {
        return this.f12637O000000o.hashCode() + this.O00000Oo.hashCode();
    }
}
