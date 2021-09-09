package _m_j;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.huc.OkHttpURLConnection;

public final class ijk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Interceptor f1363O000000o;

    public interface O000000o {
        void O000000o(HttpURLConnection httpURLConnection);
    }

    public static OkHttpClient.Builder O000000o(final Config config, OkHttpClient.Builder builder, boolean z) {
        builder.retryOnConnectionFailure(true);
        if (config != null) {
            builder.connectTimeout((long) config.O0000O0o, TimeUnit.MILLISECONDS);
            builder.readTimeout((long) config.O0000O0o, TimeUnit.MILLISECONDS);
            builder.writeTimeout((long) config.O0000Oo0, TimeUnit.MILLISECONDS);
        }
        if (config == null || !config.f12165O000000o || TextUtils.isEmpty(config.O00000o0) || config.O00000o <= 0) {
            builder.proxy(null);
            if (f1363O000000o != null) {
                builder.interceptors().remove(f1363O000000o);
            }
            if (O000000o(builder, TimeUnit.MINUTES.toNanos(5))) {
                builder.connectionPool(new ConnectionPool());
            }
            builder.authenticator(Authenticator.NONE);
            builder.proxyAuthenticator(Authenticator.NONE);
        } else {
            if (O000000o(builder, TimeUnit.SECONDS.toNanos(10))) {
                builder.connectionPool(new ConnectionPool(10, 10, TimeUnit.SECONDS));
            }
            final int i = config.O00000o;
            final Proxy[] proxyArr = new Proxy[1];
            Thread thread = new Thread(new Runnable() {
                /* class _m_j.ijk.AnonymousClass1 */

                public final void run() {
                    try {
                        proxyArr[0] = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(config.O00000o0, i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "Config.java Create Proxy");
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            builder.proxy(proxyArr[0]);
            if (f1363O000000o == null) {
                f1363O000000o = new Interceptor() {
                    /* class _m_j.ijk.AnonymousClass2 */

                    public final Response intercept(Interceptor.Chain chain) throws IOException {
                        Request.Builder newBuilder = chain.request().newBuilder();
                        Map<String, String> map = config.O0000OoO;
                        if (map != null) {
                            for (Map.Entry next : map.entrySet()) {
                                newBuilder.header((String) next.getKey(), (String) next.getValue());
                            }
                        }
                        return chain.proceed(newBuilder.build());
                    }
                };
            }
            if (!builder.interceptors().contains(f1363O000000o)) {
                builder.addInterceptor(f1363O000000o);
            }
        }
        return builder;
    }

    private static boolean O000000o(OkHttpClient.Builder builder, long j) {
        try {
            Field declaredField = OkHttpClient.Builder.class.getDeclaredField("connectionPool");
            declaredField.setAccessible(true);
            ConnectionPool connectionPool = (ConnectionPool) declaredField.get(builder);
            if (connectionPool == null) {
                return true;
            }
            Field declaredField2 = ConnectionPool.class.getDeclaredField("keepAliveDurationNs");
            declaredField2.setAccessible(true);
            if (((Long) declaredField2.get(connectionPool)).longValue() == j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            if (!iio.f1319O000000o) {
                e.printStackTrace();
                return true;
            }
            throw new RuntimeException("Config -> OKHTTP 底层框架发生改变需要做相应的处理!!!");
        }
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    public static HttpURLConnection O000000o(Config config, String str, String str2, O000000o o000000o) throws IOException {
        HttpURLConnection httpURLConnection;
        Proxy proxy = null;
        if (str == null) {
            return null;
        }
        try {
            URL url = new URL(str);
            try {
                boolean equalsIgnoreCase = "https".equalsIgnoreCase(url.toURI().getScheme());
                if (config != null) {
                    if (config.f12165O000000o) {
                        int i = config.O00000o;
                        if (equalsIgnoreCase && config.O00000oO > 0) {
                            i = config.O00000oO;
                        }
                        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(config.O00000o0, i));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean z = config != null ? config.f12165O000000o : false;
            if (proxy == null || proxy == Proxy.NO_PROXY || !z) {
                httpURLConnection = url.openConnection();
            } else {
                httpURLConnection = new OkHttpURLConnection(url, iiz.O000000o().O000000o(url));
                Map<String, String> map = config.O0000OoO;
                if (map != null) {
                    for (Map.Entry next : map.entrySet()) {
                        httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                }
                httpURLConnection.setInstanceFollowRedirects(false);
            }
            if (config != null) {
                httpURLConnection.setConnectTimeout(config.O0000O0o);
                httpURLConnection.setReadTimeout(config.O0000OOo);
            }
            httpURLConnection.setRequestMethod(str2);
            o000000o.O000000o(httpURLConnection);
            return httpURLConnection;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static imu O000000o(final Config config) {
        if (config == null) {
            return null;
        }
        imu imu = new imu();
        imu.f1485O000000o = config.f12165O000000o;
        imu.O00000Oo = config.O00000Oo;
        imu.O00000o0 = config.O00000o0;
        imu.O00000o = config.O00000o;
        imu.O00000oO = config.O00000oO;
        imu.O00000oo = config.O00000oo;
        imu.O0000O0o = config.O0000O0o;
        imu.O0000OOo = config.O0000OOo;
        imu.O0000Oo0 = config.O0000Oo0;
        imu.O0000Oo = config.O0000Oo;
        imu.O0000OoO = config.O0000OoO;
        if (ilg.O000000o()) {
            imu.O0000Ooo = new imb() {
                /* class _m_j.ijk.AnonymousClass3 */

                public final HttpURLConnection O000000o(String str, String str2, final imu imu) {
                    try {
                        return ijk.O000000o(config, str, str2, new O000000o() {
                            /* class _m_j.ijk.AnonymousClass3.AnonymousClass1 */

                            public final void O000000o(HttpURLConnection httpURLConnection) {
                                imu imu = imu;
                                if (imu != null) {
                                    httpURLConnection.setReadTimeout(imu.O0000OOo);
                                    httpURLConnection.setConnectTimeout(imu.O0000O0o);
                                    if (imu.O0000OoO != null) {
                                        for (Map.Entry next : imu.O0000OoO.entrySet()) {
                                            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
                                        }
                                    }
                                }
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            };
        }
        return imu;
    }
}
