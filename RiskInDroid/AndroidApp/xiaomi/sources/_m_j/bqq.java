package _m_j;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.protocol.HttpContext;

public final class bqq implements HttpRequestRetryHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HashSet<Class<?>> f13203O000000o = new HashSet<>();
    private static HashSet<Class<?>> O00000Oo = new HashSet<>();
    private final int O00000o0 = 3;

    static {
        f13203O000000o.add(NoHttpResponseException.class);
        f13203O000000o.add(UnknownHostException.class);
        f13203O000000o.add(SocketException.class);
        O00000Oo.add(InterruptedIOException.class);
        O00000Oo.add(SSLHandshakeException.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f  */
    public final boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        boolean z = false;
        if (!(iOException == null || httpContext == null)) {
            Object attribute = httpContext.getAttribute("http.request_sent");
            if (attribute != null) {
                boolean booleanValue = ((Boolean) attribute).booleanValue();
            }
            boolean z2 = true;
            if (i <= this.O00000o0 && !O00000Oo.contains(iOException.getClass())) {
                boolean contains = f13203O000000o.contains(iOException.getClass());
            } else {
                z2 = false;
            }
            if (z2) {
                try {
                    Object attribute2 = httpContext.getAttribute("http.request");
                    if (attribute2 == null) {
                        brm.O00000Oo("retry error, curr request is null");
                    } else if (attribute2 instanceof HttpRequestBase) {
                        z = "GET".equals(((HttpRequestBase) attribute2).getMethod());
                    } else if (attribute2 instanceof RequestWrapper) {
                        z = "GET".equals(((RequestWrapper) attribute2).getMethod());
                    }
                } catch (Throwable th) {
                    brm.O000000o("retry error", th);
                }
                if (z) {
                    SystemClock.sleep(500);
                }
            }
            z = z2;
            if (z) {
            }
        }
        return z;
    }
}
