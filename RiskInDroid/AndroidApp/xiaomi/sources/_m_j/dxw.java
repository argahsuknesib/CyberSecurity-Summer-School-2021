package _m_j;

import org.aspectj.lang.NoAspectBoundException;

public final class dxw {
    public static final dxw O00000Oo;
    private static Throwable O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f15046O000000o = false;

    public static dxw O00000Oo() {
        dxw dxw = O00000Oo;
        if (dxw != null) {
            return dxw;
        }
        throw new NoAspectBoundException("com.xiaomi.miot.support.monitor.aop.trace.TraceActivity", O00000o0);
    }

    public final void O000000o() {
        this.f15046O000000o = true;
        dyb.f15058O000000o = System.currentTimeMillis();
        dzk.O000000o("app_attach", Long.valueOf(dyb.f15058O000000o));
    }

    static {
        try {
            O00000Oo = new dxw();
        } catch (Throwable th) {
            O00000o0 = th;
        }
    }
}
