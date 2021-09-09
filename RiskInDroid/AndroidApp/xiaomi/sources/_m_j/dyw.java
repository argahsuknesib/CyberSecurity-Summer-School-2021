package _m_j;

public interface dyw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final dyw f15087O000000o = new dyw() {
        /* class _m_j.dyw.AnonymousClass1 */

        public final void O000000o() {
            Runtime.getRuntime().gc();
            try {
                Thread.sleep(100);
                System.runFinalization();
            } catch (InterruptedException unused) {
                throw new AssertionError();
            }
        }
    };

    void O000000o();
}
