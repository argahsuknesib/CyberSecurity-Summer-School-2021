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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class fdq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fdq f16120O000000o;
    private static Object O00000Oo = new Object();
    private OkHttpClient O00000o;
    private boolean O00000o0 = false;
    private CookieManager O00000oO;

    private fdq() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        OkHttpClient.Builder writeTimeout = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(20, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS);
        CookieManager cookieManager = new CookieManager();
        this.O00000oO = cookieManager;
        this.O00000o = writeTimeout.cookieJar(new JavaNetCookieJar(cookieManager)).addNetworkInterceptor(new Interceptor() {
            /* class _m_j.fdq.AnonymousClass1 */

            public final Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", fln.O000000o(CommonApplication.getAppContext())).build());
            }
        }).sslSocketFactory(fkb.O000000o(), fkb.O00000Oo()).build();
    }

    public static fdq O000000o() {
        if (f16120O000000o == null) {
            synchronized (O00000Oo) {
                if (f16120O000000o == null) {
                    f16120O000000o = new fdq();
                }
            }
        }
        return f16120O000000o;
    }

    private boolean O00000Oo() {
        boolean z;
        synchronized (O00000Oo) {
            z = this.O00000o0;
        }
        return z;
    }

    public final void O000000o(boolean z) {
        synchronized (O00000Oo) {
            this.O00000o0 = z;
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
            gsr.O000000o(this.O00000oO, O00000o0(), "countryCode", O000000o2.O00000Oo, ".io.mi.com", "/");
        }
    }

    private void O00000oO() {
        Locale O0000O0o = fju.O000000o().O0000O0o();
        if (O0000O0o == null) {
            gsr.O000000o(this.O00000oO, O00000o0(), "locale", flk.O000000o(Locale.getDefault()), ".io.mi.com", "/");
            return;
        }
        gsr.O000000o(this.O00000oO, O00000o0(), "locale", flk.O000000o(O0000O0o), ".io.mi.com", "/");
    }

    private void O00000oo() {
        String str;
        try {
            grr.O000000o();
            str = URLEncoder.encode(grr.O0000o0o(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        gsr.O000000o(this.O00000oO, O00000o0(), "timezone", str, ".io.mi.com", "/");
    }

    public final fdi O000000o(final NetRequest netRequest, final fdh<NetResult, NetError> fdh) {
        Request request;
        if (netRequest == null) {
            if (fdh != null) {
                fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
            }
            return new fdi(null);
        }
        String O000000o2 = O000000o(netRequest);
        if (!O00000Oo()) {
            gsr.O000000o(this.O00000oO);
            O00000o();
            O00000oO();
            O00000oo();
            O000000o(true);
        }
        if (netRequest.f6729O000000o.equals("POST")) {
            RequestBody O00000Oo2 = flj.O00000Oo(netRequest.O00000oO);
            Request.Builder headers = new Request.Builder().url(O000000o2).headers(flj.O000000o(netRequest.O00000o));
            if (O00000Oo2 == null) {
                O00000Oo2 = new FormBody.Builder().build();
            }
            request = headers.post(O00000Oo2).build();
        } else {
            request = netRequest.f6729O000000o.equals("GET") ? new Request.Builder().url(flj.O000000o(O000000o2, netRequest.O00000oO)).headers(flj.O000000o(netRequest.O00000o)).build() : null;
        }
        if (request == null) {
            if (fdh != null) {
                fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), ""));
            }
            return new fdi(null);
        }
        Call newCall = this.O00000o.newCall(request);
        newCall.enqueue(new Callback() {
            /* class _m_j.fdq.AnonymousClass2 */

            public final void onFailure(Call call, IOException iOException) {
                if (gfr.O0000OOo || gfr.O0000Oo) {
                    gsy.O000000o(6, "MIIO", netRequest.toString());
                    if (iOException != null) {
                        gsy.O000000o(6, "MIIO", iOException.toString());
                    }
                }
                fdh fdh = fdh;
                if (fdh != null) {
                    fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), iOException == null ? "net request failure" : iOException.getMessage()));
                }
            }

            public final void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    if (response.code() == 401) {
                        try {
                            response.body().string();
                        } catch (Exception unused) {
                        }
                    }
                    fdh fdh = fdh;
                    if (fdh != null) {
                        fdh.onFailure(new NetError(response.code(), ""));
                        return;
                    }
                    return;
                }
                ResponseBody body = response.body();
                try {
                    String string = body.string();
                    if (body != null) {
                        body.close();
                    }
                    if (gfr.O0000OOo || gfr.O0000Oo) {
                        if (gfr.O0000OOo || gfr.O0000Oo) {
                            gsy.O00000Oo("MIIO", netRequest.toString());
                            gsy.O00000Oo("MIIO", string);
                        }
                        if (!TextUtils.isEmpty(string)) {
                            gsy.O000000o(3, "CoreService", string);
                        }
                    }
                    NetResult netResult = new NetResult();
                    netResult.O00000o0 = string;
                    fdh fdh2 = fdh;
                    if (fdh2 != null) {
                        fdh2.onSuccess(netResult);
                    }
                } catch (Exception e) {
                    if (fdh != null) {
                        fdh.onFailure(new NetError(ErrorCode.INVALID.getCode(), e.getMessage()));
                    }
                    if (body != null) {
                        body.close();
                    }
                } catch (Throwable th) {
                    if (body != null) {
                        body.close();
                    }
                    throw th;
                }
            }
        });
        return new fdi(newCall);
    }
}
