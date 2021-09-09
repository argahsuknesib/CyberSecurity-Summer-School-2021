package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.io.IOException;
import java.net.CookieManager;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public final class fdr {
    private static volatile fdr O00000Oo;
    private static Object O00000o0 = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public OkHttpClient f16123O000000o;
    private boolean O00000o = false;
    private CookieManager O00000oO;

    private fdr() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        OkHttpClient.Builder writeTimeout = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
        CookieManager cookieManager = new CookieManager();
        this.O00000oO = cookieManager;
        this.f16123O000000o = writeTimeout.cookieJar(new JavaNetCookieJar(cookieManager)).addNetworkInterceptor(new Interceptor() {
            /* class _m_j.fdr.AnonymousClass1 */

            public final Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", fln.O000000o(CommonApplication.getAppContext())).build());
            }
        }).sslSocketFactory(fkb.O000000o(), fkb.O00000Oo()).build();
    }

    public static fdr O000000o() {
        if (O00000Oo == null) {
            synchronized (O00000o0) {
                if (O00000Oo == null) {
                    O00000Oo = new fdr();
                }
            }
        }
        return O00000Oo;
    }

    public final void O00000Oo() {
        synchronized (O00000o0) {
            this.O00000o = false;
        }
    }

    public static String O000000o(NetRequest netRequest) {
        ServerBean O00000o2 = fju.O000000o().O00000o();
        if (O00000o2 == null || ftn.O00000o0(O00000o2)) {
            return "https://api.io.mi.com/app" + netRequest.O00000Oo;
        }
        return "https://" + O00000o2.f7546O000000o + ".api.io.mi.com/app" + netRequest.O00000Oo;
    }
}
