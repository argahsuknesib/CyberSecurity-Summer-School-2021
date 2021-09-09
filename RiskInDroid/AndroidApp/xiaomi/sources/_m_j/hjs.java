package _m_j;

public final class hjs extends hju {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f19002O000000o;
    public String O00000Oo;
    public long O00000o;
    public String O00000o0;
    public long O00000oO;
    public int O00000oo;
    public String O0000O0o;
    public int O0000OOo;
    public String O0000Oo = "";
    public String O0000Oo0 = "";
    public String O0000OoO = "";

    public final boolean O000000o() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis < this.O00000o || currentTimeMillis > this.O00000oO;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        hjs hjs = (hjs) obj;
        if (this.O00000o != hjs.O00000o || this.O00000oO != hjs.O00000oO || this.O00000oo != hjs.O00000oo || this.O0000OOo != hjs.O0000OOo) {
            return false;
        }
        String str = this.f19002O000000o;
        if (str == null ? hjs.f19002O000000o != null : !str.equals(hjs.f19002O000000o)) {
            return false;
        }
        String str2 = this.O00000Oo;
        if (str2 == null ? hjs.O00000Oo != null : !str2.equals(hjs.O00000Oo)) {
            return false;
        }
        String str3 = this.O00000o0;
        if (str3 == null ? hjs.O00000o0 != null : !str3.equals(hjs.O00000o0)) {
            return false;
        }
        String str4 = this.O0000O0o;
        return str4 == null ? hjs.O0000O0o == null : str4.equals(hjs.O0000O0o);
    }

    public final int hashCode() {
        String str = this.f19002O000000o;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.O00000Oo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.O00000o0;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j = this.O00000o;
        long j2 = this.O00000oO;
        int i2 = (((((((hashCode2 + hashCode3) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.O00000oo) * 31;
        String str4 = this.O0000O0o;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((i2 + i) * 31) + this.O0000OOo;
    }
}
