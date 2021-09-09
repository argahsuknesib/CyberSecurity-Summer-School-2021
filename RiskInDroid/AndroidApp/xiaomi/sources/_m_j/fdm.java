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

public final class fdm {
    private static volatile fdm O00000oo;
    private static Object O0000O0o = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public OkHttpClient f16108O000000o;
    public CookieManager O00000Oo;
    public Object O00000o = new Object();
    public MiServiceTokenInfo O00000o0;
    public boolean O00000oO = false;
    private boolean O0000OOo = false;

    private fdm() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        OkHttpClient.Builder writeTimeout = builder.connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
        CookieManager cookieManager = new CookieManager();
        this.O00000Oo = cookieManager;
        this.f16108O000000o = writeTimeout.cookieJar(new JavaNetCookieJar(cookieManager)).build();
    }

    public static fdm O000000o() {
        if (O00000oo == null) {
            synchronized (O0000O0o) {
                if (O00000oo == null) {
                    O00000oo = new fdm();
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
        return "https://web.recharge.mipay.com" + netRequest.O00000Oo;
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
                    fcn.O000000o().O000000o("mipaycom");
                } catch (Exception unused) {
                    synchronized (this.O00000o) {
                        this.O00000oO = false;
                        if (O00000oO2) {
                            fcn.O000000o().O000000o("mipaycom");
                        }
                        O000000o(false);
                        return;
                    }
                }
            }
            fcn.O000000o().O000000o("mipaycom", O00000Oo2, O00000oO2, O00000oo2, new fdh<Bundle, Error>() {
                /* class _m_j.fdm.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    Bundle bundle = (Bundle) obj;
                    synchronized (fdm.this.O00000o) {
                        fdm.this.O00000oO = false;
                    }
                    bundle.setClassLoader(RefreshServiceTokenResult.class.getClassLoader());
                    RefreshServiceTokenResult refreshServiceTokenResult = (RefreshServiceTokenResult) bundle.getParcelable("result");
                    fcn.O000000o().O000000o("mipaycom", refreshServiceTokenResult.O00000o, refreshServiceTokenResult.O00000Oo, refreshServiceTokenResult.O00000oO, "web.recharge.pay.xiaomi.com", refreshServiceTokenResult.O00000oo);
                    fcn.O000000o().O0000Oo();
                    fdm.this.O000000o(false);
                }

                public final void onFailure(Error error) {
                    synchronized (fdm.this.O00000o) {
                        fdm.this.O00000oO = false;
                    }
                    fdm.this.O000000o(false);
                }
            });
        }
    }
}
