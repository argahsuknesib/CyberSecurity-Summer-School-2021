package _m_j;

public final class enk {

    /* renamed from: O000000o  reason: collision with root package name */
    int f15652O000000o;
    long O00000Oo;
    String O00000o;
    long O00000o0;
    long O00000oO;

    public enk() {
        this(0, 0, 0, null);
    }

    public enk(int i, long j, long j2, Exception exc) {
        this.f15652O000000o = i;
        this.O00000Oo = j;
        this.O00000oO = j2;
        this.O00000o0 = System.currentTimeMillis();
        if (exc != null) {
            this.O00000o = exc.getClass().getSimpleName();
        }
    }
}
