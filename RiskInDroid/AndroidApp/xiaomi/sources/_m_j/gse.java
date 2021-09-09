package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.IOException;
import java.net.CookieManager;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public final class gse {

    /* renamed from: O000000o  reason: collision with root package name */
    static ConnectionPool f18203O000000o = new ConnectionPool(5, 60000, TimeUnit.MILLISECONDS);
    static Dispatcher O00000Oo = new Dispatcher(goq.O000000o());
    static CookieManager O00000o0;

    public static OkHttpClient O000000o() {
        final String str;
        try {
            str = fln.O000000o(CommonApplication.getAppContext());
        } catch (Exception e) {
            gsy.O000000o(6, "ClientUtil", "create: " + e.getLocalizedMessage());
            str = null;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        OkHttpClient.Builder writeTimeout = builder.dispatcher(O00000Oo).connectionPool(f18203O000000o).connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
        CookieManager cookieManager = new CookieManager();
        O00000o0 = cookieManager;
        OkHttpClient.Builder cookieJar = writeTimeout.cookieJar(new JavaNetCookieJar(cookieManager));
        if (!TextUtils.isEmpty(str)) {
            cookieJar.addNetworkInterceptor(new Interceptor() {
                /* class _m_j.gse.AnonymousClass1 */

                public final Response intercept(Interceptor.Chain chain) throws IOException {
                    return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", str).build());
                }
            });
        }
        return cookieJar.build();
    }
}
