package com.xiaomi.onetrack.b;

import android.text.TextUtils;
import com.xiaomi.onetrack.g.b;
import com.xiaomi.onetrack.h.a.a;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.r;
import com.xiaomi.onetrack.h.w;
import com.xiaomi.onetrack.h.z;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private static ConcurrentHashMap<Integer, Integer> f = new ConcurrentHashMap<>();

    public static void a() {
        j.a(new d());
    }

    public static void b() {
        if (e()) {
            f();
        } else {
            q.a("CommonConfigUpdater", "CommonConfigUpdater Does not meet prerequisites for request");
        }
    }

    private static boolean e() {
        if (!com.xiaomi.onetrack.g.c.a()) {
            q.b("CommonConfigUpdater", "net is not connected!");
            return false;
        } else if (TextUtils.isEmpty(z.l())) {
            return true;
        } else {
            long j = z.j();
            if (j < System.currentTimeMillis() || j - System.currentTimeMillis() > 172800000) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static void f() {
        if (!r.a("CommonConfigUpdater")) {
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("oa", a.a().a(com.xiaomi.onetrack.f.a.a()));
                hashMap.put("ov", r.b());
                hashMap.put("ob", r.c());
                hashMap.put("ii", r.A() ? "1" : "0");
                hashMap.put("sv", "1.1.5");
                hashMap.put("av", r.l());
                hashMap.put("ml", h.c());
                hashMap.put("re", r.B());
                hashMap.put("platform", "Android");
                String d = w.a().d();
                String b = b.b(d, hashMap, true);
                q.a("CommonConfigUpdater", "url:" + d + " response:" + b);
                a(b);
            } catch (IOException e) {
                q.a("CommonConfigUpdater", "requestCloudData: " + e.toString());
            }
        }
    }

    private static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("code") == 0) {
                    String optString = jSONObject.optString("hash");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("regionUrl");
                        if (optJSONObject2 != null) {
                            w.a().a(optJSONObject2);
                        }
                        z.d(optJSONObject.toString());
                        z.c(optString);
                    }
                    z.j(System.currentTimeMillis() + 86400000 + ((long) new Random().nextInt(86400000)));
                }
            } catch (JSONException e) {
                q.a("CommonConfigUpdater", "saveCommonCloudData: " + e.toString());
            }
        }
    }

    public static Map<Integer, Integer> c() {
        try {
            if (!f.isEmpty()) {
                return f;
            }
            String l = z.l();
            if (!TextUtils.isEmpty(l)) {
                JSONArray optJSONArray = new JSONObject(l).optJSONArray("levels");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    int optInt = jSONObject.optInt("l");
                    int optInt2 = jSONObject.optInt("t");
                    if (optInt > 0 && optInt2 > 0) {
                        f.put(Integer.valueOf(optInt), Integer.valueOf(optInt2));
                    }
                }
            }
            return f.isEmpty() ? g() : f;
        } catch (Exception e) {
            q.a("CommonConfigUpdater", "getLevelIntervalConfig: " + e.toString());
        }
    }

    private static HashMap<Integer, Integer> g() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 5000);
        hashMap.put(2, 15000);
        hashMap.put(3, 900000);
        return hashMap;
    }
}
