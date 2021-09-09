package com.xiaomi.onetrack.f;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.g.c;
import com.xiaomi.onetrack.h.ab;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.r;
import com.xiaomi.onetrack.h.z;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private long e;
    private String f;
    private String g;
    private String h;
    private int i;
    private JSONObject j;
    private long k;

    /* renamed from: com.xiaomi.onetrack.f.b$b  reason: collision with other inner class name */
    public static class C0053b {
        public static String A = "sdk_mode";
        public static String B = "ot_first_day";
        public static String C = "ot_test_env";

        /* renamed from: a  reason: collision with root package name */
        public static String f6137a = "event";
        public static String b = "imei";
        public static String c = "oaid";
        public static String d = "sn";
        public static String e = "gaid";
        public static String f = "android_id";
        public static String g = "instance_id";
        public static String h = "mfrs";
        public static String i = "model";
        public static String j = "platform";
        public static String k = "miui";
        public static String l = "build";
        public static String m = "os_ver";
        public static String n = "app_id";
        public static String o = "app_ver";
        public static String p = "pkg";
        public static String q = "channel";
        public static String r = "e_ts";
        public static String s = "tz";
        public static String t = "net";
        public static String u = "region";
        public static String v = "plugin_id";
        public static String w = "sdk_ver";
        public static String x = "uid";
        public static String y = "uid_type";
        public static String z = "sid";
    }

    public b() {
    }

    public long a() {
        return this.e;
    }

    public void a(long j2) {
        this.e = j2;
    }

    public String b() {
        return this.f;
    }

    public void a(String str) {
        this.f = str;
    }

    public String c() {
        return this.g;
    }

    public void b(String str) {
        this.g = str;
    }

    public String d() {
        return this.h;
    }

    public void c(String str) {
        this.h = str;
    }

    public int e() {
        return this.i;
    }

    public void a(int i2) {
        this.i = i2;
    }

    public JSONObject f() {
        return this.j;
    }

    public void a(JSONObject jSONObject) {
        this.j = jSONObject;
    }

    public long g() {
        return this.k;
    }

    public void b(long j2) {
        this.k = j2;
    }

    public boolean h() {
        try {
            if (this.j == null || !this.j.has("H") || !this.j.has("B") || TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            q.b("Event", "check event isValid error, ", e2);
            return false;
        }
    }

    private b(a aVar) {
        this.e = aVar.f6136a;
        this.f = aVar.b;
        this.g = aVar.c;
        this.h = aVar.d;
        this.i = aVar.e;
        this.j = aVar.f;
        this.k = aVar.g;
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public long f6136a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public int e;
        /* access modifiers changed from: private */
        public JSONObject f;
        /* access modifiers changed from: private */
        public long g;

        public a a(long j) {
            this.f6136a = this.f6136a;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a a(int i) {
            this.e = i;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f = jSONObject;
            return this;
        }

        public a b(long j) {
            this.g = j;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public static JSONObject a(String str, Configuration configuration, OneTrack.IEventHook iEventHook) throws JSONException {
        return a(str, configuration, iEventHook, "");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public static JSONObject a(String str, Configuration configuration, OneTrack.IEventHook iEventHook, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Context a2 = a.a();
        jSONObject.put(C0053b.f6137a, str);
        if (!(r.a() ? r.A() : configuration.isInternational())) {
            jSONObject.put(C0053b.b, h.b(a2));
            jSONObject.put(C0053b.c, com.xiaomi.onetrack.h.a.a.a().a(a2));
        } else if (iEventHook != null && iEventHook.fillGAID(str)) {
            String p = h.p(a2);
            if (!TextUtils.isEmpty(p)) {
                jSONObject.put(C0053b.e, p);
            }
        }
        jSONObject.put(C0053b.g, p.a().b());
        jSONObject.put(C0053b.h, h.d());
        jSONObject.put(C0053b.i, h.c());
        jSONObject.put(C0053b.j, "Android");
        jSONObject.put(C0053b.k, r.k());
        jSONObject.put(C0053b.l, r.f());
        jSONObject.put(C0053b.m, r.l());
        jSONObject.put(C0053b.o, a.b());
        jSONObject.put(C0053b.r, System.currentTimeMillis());
        jSONObject.put(C0053b.s, r.d());
        jSONObject.put(C0053b.t, c.a(a2).toString());
        jSONObject.put(C0053b.u, r.B());
        jSONObject.put(C0053b.w, "1.1.5");
        jSONObject.put(C0053b.n, configuration.getAppId());
        jSONObject.put(C0053b.p, a.d());
        jSONObject.put(C0053b.q, !TextUtils.isEmpty(configuration.getChannel()) ? configuration.getChannel() : "default");
        a(jSONObject, configuration, str2);
        a(jSONObject, a2);
        jSONObject.put(C0053b.z, r.u());
        jSONObject.put(C0053b.A, (configuration.getMode() != null ? configuration.getMode() : OneTrack.Mode.APP).getType());
        jSONObject.put(C0053b.B, ab.d(z.B()));
        if (q.c) {
            jSONObject.put(C0053b.C, true);
        }
        return jSONObject;
    }

    private static void a(JSONObject jSONObject, Context context) throws JSONException {
        String u = z.u();
        String w = z.w();
        if (!TextUtils.isEmpty(u) && !TextUtils.isEmpty(w)) {
            jSONObject.put(C0053b.x, u);
            jSONObject.put(C0053b.y, w);
        }
    }

    private static void a(JSONObject jSONObject, Configuration configuration, String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put(C0053b.v, str);
        } else {
            jSONObject.put(C0053b.v, configuration.getPluginId());
        }
    }
}
