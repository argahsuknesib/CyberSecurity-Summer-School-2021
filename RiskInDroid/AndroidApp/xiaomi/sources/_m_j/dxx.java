package _m_j;

import _m_j.dyq;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.aspectj.lang.NoAspectBoundException;

public final class dxx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final dxx f15048O000000o;
    private static Throwable O00000Oo;

    public static dxx O000000o() {
        dxx dxx = f15048O000000o;
        if (dxx != null) {
            return dxx;
        }
        throw new NoAspectBoundException("com.xiaomi.miot.support.monitor.aop.trace.TraceNetTrafficMonitor", O00000Oo);
    }

    public static URLConnection O000000o(URL url) throws IOException {
        URLConnection openConnection;
        if (!dyq.O000000o.f15075O000000o.O00000Oo("net")) {
            return url.openConnection();
        }
        if (url == null || (openConnection = url.openConnection()) == null) {
            return null;
        }
        if (openConnection instanceof HttpsURLConnection) {
            return new dyl((HttpsURLConnection) openConnection);
        }
        return openConnection instanceof HttpURLConnection ? new dyk((HttpURLConnection) openConnection) : openConnection;
    }

    static {
        try {
            f15048O000000o = new dxx();
        } catch (Throwable th) {
            O00000Oo = th;
        }
    }
}
