package _m_j;

public abstract class jpp implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final String f2028O000000o;

    public jpp(String str, Object... objArr) {
        this.f2028O000000o = String.format(str, objArr);
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f2028O000000o);
        try {
            O000000o();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
