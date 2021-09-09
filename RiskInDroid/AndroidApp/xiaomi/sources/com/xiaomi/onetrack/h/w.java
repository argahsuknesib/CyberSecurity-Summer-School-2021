package com.xiaomi.onetrack.h;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.onetrack.b.c;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class w {
    private static ConcurrentHashMap<String, String> w = new ConcurrentHashMap<>();
    private Context v;

    private String g() {
        return "https://";
    }

    private w() {
        w.put("IN", "tracking.india.miui.com");
        w.put("RU", "tracking.rus.miui.com");
        f();
    }

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final w f6180a = new w();

        private a() {
        }
    }

    public static w a() {
        return a.f6180a;
    }

    private void f() {
        try {
            String h = z.h();
            if (!TextUtils.isEmpty(h)) {
                a(new JSONObject(h));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public synchronized void a(JSONObject jSONObject) {
        q.a("RegionDomainManager", "updateHostMap:" + jSONObject.toString());
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                        w.put(next, optString);
                    }
                }
                z.b(new JSONObject((Map<?, ?>) w).toString());
            } catch (Exception e) {
                q.a("RegionDomainManager", "updateHostMap: " + e.toString());
            }
            q.a("RegionDomainManager", "merge config:" + new JSONObject((Map<?, ?>) w).toString());
        }
    }

    public String b() {
        try {
            if (TextUtils.isEmpty(z.l())) {
                c.b();
            }
        } catch (Exception e) {
            q.a("RegionDomainManager", "getTrackingUrl: " + e.toString());
        }
        return a(g(), h(), "/track/v4");
    }

    public String c() {
        return a(g(), i(), "/api/v4/detail/config");
    }

    public String d() {
        return a(g(), i(), "/api/v4/detail/config_common");
    }

    public String e() {
        return a(g(), h(), "/track/key_get");
    }

    public String a(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    private String h() {
        return a(r.A(), r.B());
    }

    private String a(boolean z, String str) {
        if (!z) {
            return "tracking.miui.com";
        }
        String str2 = w.get(str);
        return TextUtils.isEmpty(str2) ? "tracking.intl.miui.com" : str2;
    }

    private String i() {
        boolean A = r.A();
        String B = r.B();
        if (!A) {
            return "sdkconfig.ad.xiaomi.com";
        }
        if (TextUtils.equals(B, "IN")) {
            return "sdkconfig.ad.india.xiaomi.com";
        }
        return TextUtils.equals(B, "RU") ? "sdkconfig.ad.rus.xiaomi.com" : "sdkconfig.ad.intl.xiaomi.com";
    }
}
