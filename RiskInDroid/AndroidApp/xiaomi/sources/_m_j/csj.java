package _m_j;

public final class csj {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14303O000000o;
    public String O00000Oo;
    public Double O00000o;
    public String O00000o0;

    public csj(String str, String str2, String str3, Double d) {
        this.f14303O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
        this.O00000o = d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            csj csj = (csj) obj;
            String str = this.f14303O000000o;
            if (str == null ? csj.f14303O000000o != null : !str.equals(csj.f14303O000000o)) {
                return false;
            }
            String str2 = this.O00000Oo;
            if (str2 == null ? csj.O00000Oo != null : !str2.equals(csj.O00000Oo)) {
                return false;
            }
            String str3 = this.O00000o0;
            if (str3 == null ? csj.O00000o0 != null : !str3.equals(csj.O00000o0)) {
                return false;
            }
            Double d = this.O00000o;
            return d == null ? csj.O00000o == null : d.equals(csj.O00000o);
        }
    }

    public final int hashCode() {
        String str = this.f14303O000000o;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.O00000Oo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.O00000o0;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d = this.O00000o;
        if (d != null) {
            i = d.hashCode();
        }
        return hashCode3 + i;
    }
}
