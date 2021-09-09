package _m_j;

public final class dan implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f14417O000000o;
    private Runnable O00000Oo = null;

    public dan(Runnable runnable, long j) {
        this.O00000Oo = runnable;
        this.f14417O000000o = j;
    }

    public final void run() {
        try {
            if (this.O00000Oo != null) {
                this.O00000Oo.run();
                this.O00000Oo = null;
            }
        } catch (Throwable th) {
            if (!(th instanceof NoClassDefFoundError)) {
                th.printStackTrace();
            }
        }
    }
}
