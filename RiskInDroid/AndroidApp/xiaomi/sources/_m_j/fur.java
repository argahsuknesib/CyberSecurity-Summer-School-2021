package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class fur {
    private static volatile fur O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    Handler f17203O000000o = new Handler(Looper.getMainLooper());
    private Context O00000o = CommonApplication.getAppContext();
    private final Object O00000o0 = new Object();
    private volatile OkHttpClient O00000oO = null;

    private fur() {
    }

    public static fur O000000o() {
        if (O00000Oo == null) {
            synchronized (fur.class) {
                if (O00000Oo == null) {
                    O00000Oo = new fur();
                }
            }
        }
        return O00000Oo;
    }

    /* access modifiers changed from: protected */
    public final OkHttpClient O00000Oo() {
        if (this.O00000oO == null) {
            synchronized (this.O00000o0) {
                if (this.O00000oO == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    fkb.O000000o(builder);
                    this.O00000oO = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(3, TimeUnit.SECONDS).readTimeout(3, TimeUnit.SECONDS).writeTimeout(3, TimeUnit.SECONDS).addNetworkInterceptor(new O000000o(fus.O00000Oo())).build();
                }
            }
        }
        return this.O00000oO;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x014c */
    public final fsn O000000o(Context context, long j, long j2, String str, String str2, String str3, ftt<Void> ftt, long j3) {
        final String str4;
        String str5;
        long j4 = j3;
        final ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            boolean O0000O0o = ftn.O0000O0o(context);
            grr.O000000o();
            String O000000o2 = grr.O000000o(context);
            jSONObject.put("userId", CoreApi.O000000o().O0000o0());
            jSONObject.put("exception_class", str);
            jSONObject.put("exception_method", str2);
            jSONObject.put("exception_stack", str3);
            grr.O000000o();
            jSONObject.put("version_code", grr.O00000o0(context));
            grr.O000000o();
            jSONObject.put("version_name", grr.O00000o(context));
            grr.O000000o();
            Context context2 = context;
            jSONObject.put("device_id", grr.O000000o(context, O0000O0o));
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
            jSONObject.put("imei", O0000O0o ? grw.O00000Oo(O000000o2) : gqb.O00000oO(O000000o2));
            jSONObject.put("channel", gfr.O0000o0O);
            jSONObject.put("time", System.currentTimeMillis());
            long j5 = j;
            jSONObject.put("plugin_id", j);
            long j6 = j2;
            jSONObject.put("plugin_package_id", j2);
            arrayList.add(new gky("data", grs.O000000o(jSONObject.toString().getBytes())));
            if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                StringBuilder sb = new StringBuilder("https://");
                if (O0000ooO != null) {
                    str5 = O0000ooO.f7546O000000o + ".";
                } else {
                    str5 = "";
                }
                sb.append(str5);
                sb.append("api.io.mi.com/app/crashlog");
                str4 = sb.toString();
            } else {
                str4 = "https://api.io.mi.com/app/crashlog";
            }
            final Object obj = new Object();
            AnonymousClass1 r7 = new Runnable() {
                /* class _m_j.fur.AnonymousClass1 */

                public final void run() {
                    fur.this.O00000Oo().newCall(new Request.Builder().url(str4).post(gsu.O000000o(arrayList)).build()).enqueue(new Callback() {
                        /* class _m_j.fur.AnonymousClass1.AnonymousClass1 */

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
                }
            };
            if (Looper.myLooper() == null) {
                this.f17203O000000o.post(r7);
            } else {
                r7.run();
            }
            synchronized (obj) {
                if (j4 == -1) {
                    obj.wait();
                } else {
                    obj.wait(j4);
                }
            }
            return new fsn(null);
        } catch (JSONException unused) {
            return null;
        }
    }

    class O000000o implements Interceptor {
        private final String O00000Oo;

        public O000000o(String str) {
            this.O00000Oo = str;
        }

        public final Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", this.O00000Oo).build());
        }
    }
}
