package _m_j;

import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class dyr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ArrayList<String> f15076O000000o = new ArrayList<>();
    private static dyr O00000o;
    private static final ArrayList<String> O00000oO = new ArrayList<>();
    OkHttpClient O00000Oo;
    public int O00000o0 = 0;
    private Map<String, dys> O00000oo = new HashMap();
    private int O0000O0o = 0;

    private dyr() {
    }

    public static synchronized dyr O000000o() {
        dyr dyr;
        synchronized (dyr.class) {
            if (O00000o == null) {
                O00000o = new dyr();
            }
            dyr = O00000o;
        }
        return dyr;
    }

    static {
        f15076O000000o.add("110.43.0.242");
        f15076O000000o.add("110.43.0.82");
        O00000oO.add("api.io.mi.com");
    }

    private void O00000Oo() {
        try {
            if (this.O00000Oo == null) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                fkb.O000000o(builder);
                this.O00000Oo = builder.hostnameVerifier(new HostnameVerifier() {
                    /* class _m_j.dyr.AnonymousClass1 */

                    public final boolean verify(String str, SSLSession sSLSession) {
                        return dyr.f15076O000000o.contains(str);
                    }
                }).connectTimeout(2, TimeUnit.SECONDS).readTimeout(2, TimeUnit.SECONDS).build();
            }
            if (f15076O000000o == null) {
                return;
            }
            if (f15076O000000o.size() != 0) {
                if (this.O0000O0o < f15076O000000o.size()) {
                    StringBuilder sb = new StringBuilder("https://" + f15076O000000o.get(this.O0000O0o) + "/gslb?tver=4&dm=api.io.mi.com");
                    new StringBuilder("loadDnsCache: ").append((Object) sb);
                    Request build = new Request.Builder().url(sb.toString()).build();
                    if (Build.VERSION.SDK_INT >= 19) {
                        O000000o(build, "api.io.mi.com");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean O000000o(Request request, String str) {
        Response execute;
        try {
            execute = this.O00000Oo.newCall(request).execute();
            boolean O000000o2 = O000000o(execute, str);
            if (execute != null) {
                execute.close();
            }
            return O000000o2;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            new StringBuilder("requestCacheSync: ").append(e.getMessage());
            return false;
        } catch (Throwable th) {
            r0.addSuppressed(th);
        }
        throw th;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: _m_j.dys} */
    /* JADX WARNING: Multi-variable type inference failed */
    private boolean O000000o(Response response, String str) {
        try {
            if (response.isSuccessful()) {
                String string = response.body().string();
                dys dys = null;
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    if (!jSONObject.isNull("info")) {
                        dys = new Gson().fromJson(jSONObject.optJSONObject("info").toString(), dys.class);
                    }
                }
                if (!(dys == null || dys.O00000Oo == null || dys.O00000Oo.size() == 0)) {
                    if (dys.f15078O000000o == 1) {
                        this.O00000oo.put(str, dys);
                        return true;
                    }
                }
                this.O0000O0o++;
                O00000Oo();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final dys O000000o(String str) {
        ArrayList<String> arrayList;
        gsy.O000000o(3, "HttpDnsCache", "getIpByHostSync: ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str) || (arrayList = O00000oO) == null || !arrayList.contains(str)) {
            return null;
        }
        Map<String, dys> map = this.O00000oo;
        if (map != null && map.containsKey(str) && !this.O00000oo.get(str).O00000Oo()) {
            return this.O00000oo.get(str);
        }
        synchronized (dyr.class) {
            if (!this.O00000oo.containsKey(str) || this.O00000oo.get(str).O00000Oo()) {
                this.O00000oo.clear();
                O00000Oo();
            }
        }
        return this.O00000oo.get(str);
    }

    public static boolean O00000Oo(String str) {
        ArrayList<String> arrayList;
        return !TextUtils.isEmpty(str) && (arrayList = O00000oO) != null && arrayList.contains(str);
    }
}
