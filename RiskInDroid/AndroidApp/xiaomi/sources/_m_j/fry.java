package _m_j;

public final class fry {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f17039O000000o;
    private int O00000Oo = 80;

    public final int O000000o(String str) {
        if (this.f17039O000000o == 0) {
            return 0;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.f17039O000000o);
        if (currentTimeMillis > this.O00000Oo) {
            cki.O00000o0("BlockTimeTick", "%s block time:%d", str, Integer.valueOf(currentTimeMillis));
        }
        return currentTimeMillis;
    }
}
