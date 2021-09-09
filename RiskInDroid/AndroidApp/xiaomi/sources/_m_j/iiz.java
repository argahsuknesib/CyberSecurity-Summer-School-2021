package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class iiz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f1352O000000o = 0;
    public static int O00000Oo = 3000;
    public static Context O00000o = null;
    public static int O00000o0 = 603;
    public static String O00000oo = "x-a1-httpdns-switch";
    public static String O0000O0o = "x-a1-xdcs-collector-switch";
    public static boolean O0000OOo = false;
    private static volatile iiz O0000Oo = null;
    public static boolean O0000Oo0 = true;
    private static Class O0000o00;
    public OkHttpClient O00000oO = new OkHttpClient();
    private OkHttpClient O0000OoO;
    private O000000o O0000Ooo;

    public interface O000000o {
        boolean O000000o();
    }

    private iiz() {
    }

    public static synchronized iiz O000000o() {
        iiz iiz;
        synchronized (iiz.class) {
            if (O0000Oo == null) {
                synchronized (iiz.class) {
                    if (O0000Oo == null) {
                        O0000Oo = new iiz();
                    }
                }
            }
            iiz = O0000Oo;
        }
        return iiz;
    }

    public final synchronized void O000000o(Interceptor interceptor) {
        if (this.O00000oO != null) {
            OkHttpClient.Builder newBuilder = this.O00000oO.newBuilder();
            if (!newBuilder.interceptors().contains(interceptor)) {
                newBuilder.addInterceptor(interceptor);
            }
            this.O00000oO = newBuilder.build();
        }
    }

    public final OkHttpClient O000000o(Request request) {
        if (!(this.O0000Ooo == null || request.url() == null)) {
            O000000o o000000o = this.O0000Ooo;
            request.url().url();
            if (o000000o.O000000o()) {
                return O00000o0();
            }
        }
        return request.isHttps() ? O00000o0() : this.O00000oO;
    }

    public final Response O00000Oo(Request request) throws Exception {
        if (this.O00000oO == null) {
            return null;
        }
        return O000000o(request).newCall(request).execute();
    }

    public final void O000000o(Request request, final ijf ijf) {
        if (this.O00000oO != null) {
            try {
                O000000o(request).newCall(request).enqueue(new Callback() {
                    /* class _m_j.iiz.AnonymousClass2 */

                    public final void onResponse(Call call, Response response) throws IOException {
                        if (ijf == null) {
                            response.body().close();
                            return;
                        }
                        if (!ilg.O000000o()) {
                            ijf.O000000o(response);
                        } else if (response.code() >= 400) {
                            String O000000o2 = new ija(response).O000000o();
                            if (TextUtils.isEmpty(O000000o2) || !O000000o2.contains("ret")) {
                                ijf ijf = ijf;
                                int code = response.code();
                                ijf.O000000o(code, "网络请求失败(" + response.code() + ")");
                            } else {
                                ijf.O000000o(response.code(), O000000o2);
                            }
                        } else {
                            ijf.O000000o(response);
                        }
                        response.body().close();
                    }

                    public final void onFailure(Call call, IOException iOException) {
                        if (ijf != null) {
                            String str = "网络请求失败";
                            if (iio.f1319O000000o) {
                                String message = iOException.getMessage();
                                if (!TextUtils.isEmpty(message)) {
                                    str = message;
                                }
                            }
                            ijf.O000000o(604, str);
                        }
                    }
                });
            } catch (Exception unused) {
                if (ijf != null) {
                    ijf.O000000o(604, "网络请求失败");
                }
            }
        }
    }

    public static Class O00000Oo() {
        Class cls = O0000o00;
        if (cls != null) {
            return cls;
        }
        try {
            Class<?> cls2 = Class.forName("com.ximalaya.ting.android.host.manager.request.CommonRequestM");
            O0000o00 = cls2;
            return cls2;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private OkHttpClient O00000o0() {
        OkHttpClient okHttpClient = this.O0000OoO;
        if (okHttpClient != null) {
            return okHttpClient;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        this.O0000OoO = builder.connectionPool(new ConnectionPool(1, 1, TimeUnit.MINUTES)).build();
        return this.O0000OoO;
    }

    public final OkHttpClient O000000o(URL url) {
        if (url == null) {
            return this.O00000oO;
        }
        O000000o o000000o = this.O0000Ooo;
        if (o000000o == null || !o000000o.O000000o()) {
            return url.getPath().startsWith("https") ? O00000o0() : this.O00000oO;
        }
        return O00000o0();
    }
}
