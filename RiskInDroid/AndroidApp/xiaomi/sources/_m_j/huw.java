package _m_j;

public final class huw {

    /* renamed from: O000000o  reason: collision with root package name */
    private long f697O000000o;
    private long O00000Oo;
    private long O00000o;
    private long O00000o0;

    public huw(long j, long j2, long j3, long j4) {
        this.O00000o0 = j;
        this.O00000o = j2;
        this.O00000Oo = j4;
        this.f697O000000o = j3;
    }

    public final synchronized boolean O000000o() {
        if (this.O00000Oo > 0) {
            return true;
        }
        return false;
    }

    public final synchronized boolean O00000Oo() {
        if (this.O00000o > 0) {
            return true;
        }
        return false;
    }
}
