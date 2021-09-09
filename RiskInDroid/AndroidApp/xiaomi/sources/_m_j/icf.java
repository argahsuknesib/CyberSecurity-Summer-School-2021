package _m_j;

import java.net.CookieManager;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

public class icf {
    private static volatile icf O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public CookieManager f1176O000000o = new CookieManager();
    private volatile OkHttpClient O00000o0;

    private icf() {
    }

    public static icf O000000o() {
        if (O00000Oo == null) {
            synchronized (icf.class) {
                if (O00000Oo == null) {
                    O00000Oo = new icf();
                }
            }
        }
        return O00000Oo;
    }

    public final OkHttpClient O00000Oo() {
        if (this.O00000o0 == null) {
            synchronized (icf.class) {
                if (this.O00000o0 == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    fkb.O000000o(builder);
                    OkHttpClient.Builder writeTimeout = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS);
                    CookieManager cookieManager = new CookieManager();
                    this.f1176O000000o = cookieManager;
                    this.O00000o0 = writeTimeout.cookieJar(new JavaNetCookieJar(cookieManager)).build();
                }
            }
        }
        return this.O00000o0;
    }
}
