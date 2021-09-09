package _m_j;

import com.xiaomi.smarthome.frame.core.CoreApi;
import java.net.CookieManager;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

public class frv {
    private static volatile frv O00000oO;
    private static Object O00000oo = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public Object f17036O000000o = new Object();
    public boolean O00000Oo = false;
    private CookieManager O00000o = new CookieManager();
    private OkHttpClient O00000o0;
    private boolean O0000O0o = false;

    public static frv O000000o() {
        if (O00000oO == null) {
            synchronized (frv.class) {
                if (O00000oO == null) {
                    O00000oO = new frv();
                }
            }
        }
        return O00000oO;
    }

    private frv() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        this.O00000o0 = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).cookieJar(new JavaNetCookieJar(this.O00000o)).build();
    }

    public static void O000000o(fsm<Integer, fso> fsm) {
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            fsm.onFailure(new fso(0, "International server"));
        } else {
            fsm.onFailure(new fso(0, "not support"));
        }
    }

    public final void O00000Oo() {
        synchronized (O00000oo) {
            this.O0000O0o = false;
        }
    }
}
