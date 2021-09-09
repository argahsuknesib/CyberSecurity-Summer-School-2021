package com.xiaomi.onetrack.d;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.onetrack.g.b;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.r;
import com.xiaomi.onetrack.h.w;
import com.xiaomi.onetrack.h.z;
import java.util.HashMap;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final JSONObject f6133a = new JSONObject();
    private Context f;
    private JSONObject g;
    private String[] h;

    private f() {
        this.g = null;
        this.h = new String[2];
        this.f = com.xiaomi.onetrack.f.a.a();
    }

    static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final f f6134a = new f();

        private a() {
        }
    }

    public static f a() {
        return a.f6134a;
    }

    public synchronized String[] b() {
        JSONObject e = e();
        this.h[0] = e != null ? e.optString("key") : "";
        this.h[1] = e != null ? e.optString("sid") : "";
        d();
        return this.h;
    }

    private void d() {
        if (!q.f6178a) {
            return;
        }
        if (TextUtils.isEmpty(this.h[0]) || TextUtils.isEmpty(this.h[1])) {
            q.a("SecretKeyManager", "key or sid is invalid!");
        } else {
            q.a("SecretKeyManager", "key  and sid is valid! ");
        }
    }

    public JSONObject c() {
        try {
            if (r.a("SecretKeyManager")) {
                return f6133a;
            }
            byte[] a2 = a.a();
            String a3 = c.a(e.a(a2));
            HashMap hashMap = new HashMap();
            hashMap.put("secretKey", a3);
            String b = b.b(w.a().e(), hashMap, true);
            if (!TextUtils.isEmpty(b)) {
                JSONObject jSONObject = new JSONObject(b);
                int optInt = jSONObject.optInt("code");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optInt == 0 && optJSONObject != null) {
                    String optString = optJSONObject.optString("key");
                    String optString2 = optJSONObject.optString("sid");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        String a4 = c.a(a.b(c.a(optString), a2));
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("key", a4);
                        jSONObject2.put("sid", optString2);
                        this.g = jSONObject2;
                        z.a(b.a(this.f, jSONObject2.toString()));
                        z.i(System.currentTimeMillis());
                    }
                }
            }
            return this.g;
        } catch (Exception e) {
            q.b("SecretKeyManager", "requestSecretData: " + e.toString());
        }
    }

    private JSONObject e() {
        JSONObject jSONObject = this.g;
        if (jSONObject == null && (jSONObject = f()) != null) {
            this.g = jSONObject;
        }
        return jSONObject == null ? c() : jSONObject;
    }

    private JSONObject f() {
        try {
            String g2 = z.g();
            if (TextUtils.isEmpty(g2)) {
                return null;
            }
            return new JSONObject(b.b(this.f, g2));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
