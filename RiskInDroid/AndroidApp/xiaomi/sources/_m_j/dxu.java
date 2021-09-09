package _m_j;

import _m_j.dxr;
import okhttp3.OkHttpClient;
import org.aspectj.lang.NoAspectBoundException;

public final class dxu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final dxu f15044O000000o;
    private static Throwable O00000o0;
    private int O00000Oo = 0;

    public static dxu O000000o() {
        dxu dxu = f15044O000000o;
        if (dxu != null) {
            return dxu;
        }
        throw new NoAspectBoundException("com.xiaomi.miot.support.monitor.aop.okhttp3.OkHttp3Aspect", O00000o0);
    }

    public final Object O000000o(jfl jfl) throws Throwable {
        try {
            Object O000000o2 = jfl.O000000o();
            if ((O000000o2 instanceof OkHttpClient.Builder) && dxr.O000000o.f15041O000000o.O000000o().O0000OOo.switchFlag) {
                this.O00000Oo++;
                OkHttpClient.Builder builder = (OkHttpClient.Builder) O000000o2;
                builder.eventListenerFactory(dxs.O00000Oo);
                builder.dns(dyt.O000000o());
                builder.addInterceptor(new dxt());
            }
            return jfl.O00000Oo();
        } catch (Throwable th) {
            th.printStackTrace();
            return jfl.O00000Oo();
        }
    }

    static {
        try {
            f15044O000000o = new dxu();
        } catch (Throwable th) {
            O00000o0 = th;
        }
    }
}
