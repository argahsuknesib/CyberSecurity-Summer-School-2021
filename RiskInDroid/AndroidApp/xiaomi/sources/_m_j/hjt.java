package _m_j;

public final class hjt extends hju {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f19003O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;

    public final boolean O000000o() {
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hjt hjt = (hjt) obj;
        String str = this.f19003O000000o;
        if (str == null ? hjt.f19003O000000o != null : !str.equals(hjt.f19003O000000o)) {
            return false;
        }
        String str2 = this.O00000Oo;
        return str2 == null ? hjt.O00000Oo == null : str2.equals(hjt.O00000Oo);
    }

    public final int hashCode() {
        String str = this.f19003O000000o;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.O00000Oo;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
