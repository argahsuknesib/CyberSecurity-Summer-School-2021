package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.account.RefreshServiceTokenResult;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.net.CookieManager;
import java.util.concurrent.TimeUnit;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

@Deprecated
public final class fdn {
    private static volatile fdn O00000oo;
    private static Object O0000O0o = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public OkHttpClient f16111O000000o;
    public CookieManager O00000Oo;
    public Object O00000o = new Object();
    public MiServiceTokenInfo O00000o0;
    public boolean O00000oO = false;
    private boolean O0000OOo = false;

    private fdn() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        OkHttpClient.Builder writeTimeout = builder.connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
        CookieManager cookieManager = new CookieManager();
        this.O00000Oo = cookieManager;
        this.f16111O000000o = writeTimeout.cookieJar(new JavaNetCookieJar(cookieManager)).build();
    }

    public static fdn O000000o() {
        if (O00000oo == null) {
            synchronized (O0000O0o) {
                if (O00000oo == null) {
                    O00000oo = new fdn();
                }
            }
        }
        return O00000oo;
    }

    public final boolean O00000Oo() {
        boolean z;
        synchronized (O0000O0o) {
            z = this.O0000OOo;
        }
        return z;
    }

    public final void O000000o(boolean z) {
        synchronized (O0000O0o) {
            this.O0000OOo = z;
        }
    }

    public static String O000000o(NetRequest netRequest) {
        return "https://shopapi.io.mi.com" + netRequest.O00000Oo;
    }

    public final void O00000o0() {
        boolean z;
        String O00000Oo2 = fcn.O000000o().O00000Oo();
        boolean O00000oO2 = fcn.O000000o().O00000oO();
        String O00000oo2 = fcn.O000000o().O00000oo();
        synchronized (this.O00000o) {
            z = true;
            if (!this.O00000oO) {
                this.O00000oO = true;
                z = false;
            }
        }
        if (!z) {
            if (O00000oO2) {
                try {
                    fcn.O000000o().O000000o("xiaomiio");
                } catch (Exception unused) {
                    synchronized (this.O00000o) {
                        this.O00000oO = false;
                        if (O00000oO2) {
                            fcn.O000000o().O000000o("xiaomiio");
                        }
                        O000000o(false);
                        return;
                    }
                }
            }
            fcn.O000000o().O000000o("xiaomiio", O00000Oo2, O00000oO2, O00000oo2, new fdh<Bundle, Error>() {
                /* class _m_j.fdn.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    Bundle bundle = (Bundle) obj;
                    synchronized (fdn.this.O00000o) {
                        fdn.this.O00000oO = false;
                    }
                    bundle.setClassLoader(RefreshServiceTokenResult.class.getClassLoader());
                    RefreshServiceTokenResult refreshServiceTokenResult = (RefreshServiceTokenResult) bundle.getParcelable("result");
                    fcn.O000000o().O000000o("xiaomiio", refreshServiceTokenResult.O00000o, refreshServiceTokenResult.O00000Oo, refreshServiceTokenResult.O00000oO, ".io.mi.com", refreshServiceTokenResult.O00000oo);
                    fcn.O000000o().O0000Oo();
                    fdn.this.O000000o(false);
                }

                public final void onFailure(Error error) {
                    synchronized (fdn.this.O00000o) {
                        fdn.this.O00000oO = false;
                    }
                    fdn.this.O000000o(false);
                }
            });
        }
    }
}
