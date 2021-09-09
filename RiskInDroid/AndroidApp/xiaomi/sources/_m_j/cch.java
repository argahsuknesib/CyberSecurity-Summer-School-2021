package _m_j;

public abstract class cch implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public Runnable f13620O000000o;
    public byte O00000Oo = 0;

    public final void O000000o() {
        byte b = this.O00000Oo;
        if (b == 0) {
            this.O00000Oo = 1;
            run();
        } else if (b != 1 && b == 2) {
            O00000Oo();
        }
    }

    public final void O00000Oo() {
        Runnable runnable = this.f13620O000000o;
        if (runnable != null) {
            runnable.run();
        }
        this.O00000Oo = 2;
    }
}
