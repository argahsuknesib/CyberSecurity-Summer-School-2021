package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.io.IOException;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class ftc {
    private static String O00000Oo = "8007236f-";
    private static String O00000o = "c49395ad6d65";
    private static String O00000o0 = "a2d6-4847-ac83-";
    private static volatile ftc O00000oO;
    private static Object O00000oo = new Object();
    private static String O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    Handler f17087O000000o = new Handler(Looper.getMainLooper());
    private volatile OkHttpClient O0000OOo;

    private ftc() {
    }

    public static ftc O000000o() {
        if (O00000oO == null) {
            synchronized (O00000oo) {
                if (O00000oO == null) {
                    O00000oO = new ftc();
                }
            }
        }
        return O00000oO;
    }

    public static String O00000Oo() {
        String str;
        synchronized (O00000oo) {
            if (O0000O0o == null) {
                Context context = fsp.O000000o().O00000Oo;
                boolean O0000O0o2 = ftn.O0000O0o(context);
                grr.O000000o();
                String O000000o2 = grr.O000000o(context);
                StringBuilder sb = new StringBuilder();
                grr.O000000o();
                sb.append(grr.O0000O0o().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000Oo0().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O00000Oo(context).replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000Oo().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000o00().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O000000o(context, O0000O0o2).replace("-", ""));
                sb.append("-");
                sb.append((O0000O0o2 ? grw.O00000Oo(O000000o2) : gqb.O00000oO(O000000o2)).replace("-", ""));
                sb.append("-");
                sb.append(CoreApi.O000000o().O0000o0());
                O0000O0o = sb.toString();
            }
            str = O0000O0o;
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final OkHttpClient O00000o0() {
        if (this.O0000OOo == null) {
            synchronized (O00000oo) {
                if (this.O0000OOo == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    fkb.O000000o(builder);
                    OkHttpClient.Builder cookieJar = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(3, TimeUnit.SECONDS).readTimeout(3, TimeUnit.SECONDS).writeTimeout(3, TimeUnit.SECONDS).cookieJar(new JavaNetCookieJar(new CookieManager()));
                    cookieJar.addNetworkInterceptor(new Interceptor() {
                        /* class _m_j.ftc.AnonymousClass1 */

                        public final Response intercept(Interceptor.Chain chain) throws IOException {
                            return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", ftc.O00000Oo()).build());
                        }
                    });
                    this.O0000OOo = cookieJar.build();
                }
            }
        }
        return this.O0000OOo;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0135 */
    public final void O000000o(Context context, String str, String str2, String str3, String str4, String str5, long j, long j2) {
        final String str6;
        final ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            boolean O0000O0o2 = ftn.O0000O0o(context);
            grr.O000000o();
            String O000000o2 = grr.O000000o(context);
            jSONObject.put("userId", CoreApi.O000000o().O0000o0());
            String str7 = str;
            jSONObject.put("exception_class", str);
            String str8 = str2;
            jSONObject.put("exception_method", str2);
            String str9 = str3;
            jSONObject.put("exception_stack", str3);
            grr.O000000o();
            jSONObject.put("version_code", grr.O00000o0(context));
            grr.O000000o();
            jSONObject.put("version_name", grr.O00000o(context));
            grr.O000000o();
            Context context2 = context;
            jSONObject.put("device_id", grr.O000000o(context, O0000O0o2));
            grr.O000000o();
            jSONObject.put("device_model", grr.O0000Oo());
            grr.O000000o();
            jSONObject.put("os_name", grr.O0000O0o());
            grr.O000000o();
            jSONObject.put("os_version", grr.O0000Oo0());
            grr.O000000o();
            jSONObject.put("os_sdk_int", grr.O0000OOo());
            grr.O000000o();
            jSONObject.put("os_version_incre", grr.O0000o00());
            jSONObject.put("imei", O0000O0o2 ? grw.O00000Oo(O000000o2) : grv.O000000o(O000000o2));
            String str10 = str5;
            jSONObject.put("channel", str5);
            jSONObject.put("time", System.currentTimeMillis());
            String str11 = str4;
            jSONObject.put("process", str4);
            long j3 = j;
            jSONObject.put("plugin_id", j);
            jSONObject.put("plugin_package_id", j2);
            jSONObject.put("extra", new JSONObject().toString());
            arrayList.add(new gky("data", grs.O000000o(jSONObject.toString().getBytes())));
            ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
            if (O0000ooO == null || ftn.O00000o0(O0000ooO)) {
                str6 = "https://api.io.mi.com/app/crashlog";
            } else {
                str6 = "https://" + O0000ooO.f7546O000000o + ".api.io.mi.com/app/crashlog";
            }
            final Object obj = new Object();
            AnonymousClass2 r4 = new Runnable() {
                /* class _m_j.ftc.AnonymousClass2 */

                public final void run() {
                    try {
                        ftc.this.O00000o0().newCall(new Request.Builder().url(str6).post(gsu.O000000o(arrayList)).build()).enqueue(new Callback() {
                            /* class _m_j.ftc.AnonymousClass2.AnonymousClass1 */

                            public final void onFailure(Call call, IOException iOException) {
                                synchronized (obj) {
                                    obj.notify();
                                }
                            }

                            public final void onResponse(Call call, Response response) throws IOException {
                                synchronized (obj) {
                                    obj.notify();
                                }
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            };
            if (Looper.myLooper() == null) {
                this.f17087O000000o.post(r4);
            } else {
                r4.run();
            }
            synchronized (obj) {
                obj.wait();
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x013e */
    public final void O000000o(Context context, String str, String str2, String str3, String str4, String str5, String str6, long j, long j2, String str7, String str8, String str9) {
        final String str10;
        final ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            boolean O0000O0o2 = ftn.O0000O0o(context);
            grr.O000000o();
            String O000000o2 = grr.O000000o(context);
            jSONObject.put("userId", CoreApi.O000000o().O0000o0());
            String str11 = str;
            jSONObject.put("exception_class", str);
            String str12 = str2;
            jSONObject.put("exception_method", str2);
            String str13 = str3;
            jSONObject.put("exception_stack", str3);
            grr.O000000o();
            jSONObject.put("version_code", grr.O00000o0(context));
            grr.O000000o();
            jSONObject.put("version_name", grr.O00000o(context));
            String str14 = str6;
            jSONObject.put("device_id", str6);
            jSONObject.put("device_model", str7);
            grr.O000000o();
            jSONObject.put("os_name", grr.O0000O0o());
            grr.O000000o();
            jSONObject.put("os_version", grr.O0000Oo0());
            jSONObject.put("os_sdk_int", "10058");
            grr.O000000o();
            jSONObject.put("os_version_incre", grr.O0000o00());
            jSONObject.put("imei", O0000O0o2 ? grw.O00000Oo(O000000o2) : grv.O000000o(O000000o2));
            String str15 = str5;
            jSONObject.put("channel", str5);
            jSONObject.put("time", System.currentTimeMillis());
            String str16 = str4;
            jSONObject.put("process", str4);
            jSONObject.put("plugin_id", j);
            jSONObject.put("plugin_package_id", j2);
            JSONObject jSONObject2 = new JSONObject();
            grr.O000000o();
            jSONObject2.put("phone_model", grr.O0000Oo());
            jSONObject2.put("package_name", str8);
            jSONObject2.put("sdk_version_name", str9);
            jSONObject.put("extra", jSONObject2.toString());
            arrayList.add(new gky("data", grs.O000000o(jSONObject.toString().getBytes())));
            ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
            if (O0000ooO == null || ftn.O00000o0(O0000ooO)) {
                str10 = "https://api.io.mi.com/app/crashlog";
            } else {
                str10 = "https://" + O0000ooO.f7546O000000o + ".api.io.mi.com/app/crashlog";
            }
            final Object obj = new Object();
            AnonymousClass3 r4 = new Runnable() {
                /* class _m_j.ftc.AnonymousClass3 */

                public final void run() {
                    try {
                        ftc.this.O00000o0().newCall(new Request.Builder().url(str10).post(gsu.O000000o(arrayList)).build()).enqueue(new Callback() {
                            /* class _m_j.ftc.AnonymousClass3.AnonymousClass1 */

                            public final void onFailure(Call call, IOException iOException) {
                                synchronized (obj) {
                                    obj.notify();
                                }
                            }

                            public final void onResponse(Call call, Response response) throws IOException {
                                synchronized (obj) {
                                    obj.notify();
                                }
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            };
            if (Looper.myLooper() == null) {
                this.f17087O000000o.post(r4);
            } else {
                r4.run();
            }
            synchronized (obj) {
                obj.wait();
            }
        } catch (JSONException unused) {
        }
    }
}
