package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.CookieManager;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class fdp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fdp f16117O000000o;
    private static Object O00000Oo = new Object();
    private CookieManager O00000o;
    private OkHttpClient O00000o0;
    private boolean O00000oO = false;

    private fdp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        OkHttpClient.Builder writeTimeout = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
        CookieManager cookieManager = new CookieManager();
        this.O00000o = cookieManager;
        this.O00000o0 = writeTimeout.cookieJar(new JavaNetCookieJar(cookieManager)).addNetworkInterceptor(new Interceptor() {
            /* class _m_j.fdp.AnonymousClass1 */

            public final Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", fln.O000000o(CommonApplication.getAppContext())).build());
            }
        }).sslSocketFactory(fkb.O000000o(), fkb.O00000Oo()).build();
    }

    public static fdp O000000o() {
        if (f16117O000000o == null) {
            synchronized (O00000Oo) {
                if (f16117O000000o == null) {
                    f16117O000000o = new fdp();
                }
            }
        }
        return f16117O000000o;
    }

    private boolean O00000Oo() {
        boolean z;
        synchronized (O00000Oo) {
            z = this.O00000oO;
        }
        return z;
    }

    public final void O000000o(boolean z) {
        synchronized (O00000Oo) {
            this.O00000oO = z;
        }
    }

    private static String O00000o0() {
        ServerBean O00000o2 = fju.O000000o().O00000o();
        String O00000oo = fju.O000000o().O00000oo();
        if (O00000o2 == null || ftn.O00000o0(O00000o2)) {
            return (TextUtils.isEmpty(O00000oo) || O00000oo.equalsIgnoreCase("release") || !O00000oo.equalsIgnoreCase("preview")) ? "https://api.io.mi.com" : "https://pv.api.io.mi.com";
        }
        if (TextUtils.isEmpty(O00000oo) || O00000oo.equalsIgnoreCase("release") || !O00000oo.equalsIgnoreCase("preview")) {
            return "https://" + O00000o2.f7546O000000o + ".api.io.mi.com";
        }
        return "https://pv-" + O00000o2.f7546O000000o + ".api.io.mi.com";
    }

    private static String O000000o(NetRequest netRequest) {
        return O00000o0() + "/app" + netRequest.O00000Oo;
    }

    private void O00000o() {
        ServerBean O000000o2 = ftn.O000000o(CommonApplication.getAppContext());
        if (O000000o2 != null) {
            gsr.O000000o(this.O00000o, O00000o0(), "countryCode", O000000o2.O00000Oo, ".io.mi.com", "/");
        }
    }

    private void O00000oO() {
        Locale O0000O0o = fju.O000000o().O0000O0o();
        if (O0000O0o == null) {
            gsr.O000000o(this.O00000o, O00000o0(), "locale", flk.O000000o(Locale.getDefault()), ".io.mi.com", "/");
            return;
        }
        gsr.O000000o(this.O00000o, O00000o0(), "locale", flk.O000000o(O0000O0o), ".io.mi.com", "/");
    }

    private void O00000oo() {
        String str;
        try {
            grr.O000000o();
            str = URLEncoder.encode(grr.O0000o0o(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        gsr.O000000o(this.O00000o, O00000o0(), "timezone", str, ".io.mi.com", "/");
    }

    public final fdi O000000o(final NetRequest netRequest, final fdh<NetResult, NetError> fdh) {
        Request request;
        if (netRequest == null) {
            if (fdh != null) {
                fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), "netRequest == null"));
            }
            return new fdi(null);
        }
        String O000000o2 = O000000o(netRequest);
        if (!O00000Oo()) {
            O00000o();
            O00000oO();
            O00000oo();
            O000000o(true);
        }
        if (netRequest.f6729O000000o.equals("POST")) {
            request = new Request.Builder().url(O000000o2).post(flj.O00000Oo(netRequest.O00000oO)).build();
        } else {
            request = netRequest.f6729O000000o.equals("GET") ? new Request.Builder().url(flj.O000000o(O000000o2, netRequest.O00000oO)).build() : null;
        }
        if (request == null) {
            if (fdh != null) {
                fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), "request == null"));
            }
            return new fdi(null);
        }
        Call newCall = this.O00000o0.newCall(request);
        newCall.enqueue(new Callback() {
            /* class _m_j.fdp.AnonymousClass2 */

            public final void onFailure(Call call, IOException iOException) {
                fdh fdh = fdh;
                if (fdh != null) {
                    fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), iOException == null ? "net request failure" : iOException.getMessage()));
                }
            }

            public final void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    fdh fdh = fdh;
                    if (fdh != null) {
                        fdh.onFailure(new NetError(response.code(), "Response error"));
                        return;
                    }
                    return;
                }
                try {
                    byte[] O000000o2 = grs.O000000o(response.body().string());
                    SecretKeySpec secretKeySpec = new SecretKeySpec("https&&&START&&&".getBytes(), "AES");
                    Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
                    instance.init(2, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
                    String str = new String(instance.doFinal(O000000o2));
                    if ((gfr.O0000OOo || gfr.O0000Oo) && !TextUtils.isEmpty(str)) {
                        gsy.O00000Oo("MIIO", netRequest.toString());
                        gsy.O00000Oo("MIIO", str);
                    }
                    NetResult netResult = new NetResult();
                    netResult.O00000o0 = str;
                    fdh fdh2 = fdh;
                    if (fdh2 != null) {
                        fdh2.onSuccess(netResult);
                    }
                } catch (Exception e) {
                    fdh fdh3 = fdh;
                    if (fdh3 != null) {
                        fdh3.onFailure(new NetError(ErrorCode.INVALID.getCode(), e.getMessage()));
                    }
                }
            }
        });
        return new fdi(newCall);
    }
}
