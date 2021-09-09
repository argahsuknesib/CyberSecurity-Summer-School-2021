package _m_j;

public final class dgv implements Comparable<dgv> {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f14619O000000o = -1;
    public long O00000Oo = -1;
    public boolean O00000o = false;
    public String O00000o0 = null;
    public boolean O00000oO = false;
    public int O00000oo = 0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        dgv dgv = (dgv) obj;
        if (dgv == null) {
            return 1;
        }
        long j = this.O00000Oo - dgv.O00000Oo;
        if (j <= 0) {
            return j < 0 ? -1 : 0;
        }
        return 1;
    }
}
