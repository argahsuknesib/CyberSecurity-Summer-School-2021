package _m_j;

final class enz extends ere {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ eny f15663O000000o;

    enz(eny eny) {
        this.f15663O000000o = eny;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0038 */
    public final void O000000o(Thread thread, Throwable th) {
        duv.O000000o("scr receive ex t:" + thread + " p:3", th);
        try {
            eny.O00000Oo.execute(new eoa(this, thread, th, 3));
            synchronized (this.f15663O000000o.O00000o0) {
                this.f15663O000000o.O00000o0.wait(500);
            }
        } catch (Throwable unused) {
            this.f15663O000000o.O000000o(thread, th);
        }
    }
}
