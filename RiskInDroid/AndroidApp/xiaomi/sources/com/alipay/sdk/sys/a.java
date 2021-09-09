package com.alipay.sdk.sys;

import _m_j.jdn;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.b;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.l;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public final String q;
    public final long r;
    public final int s;
    public final String t;
    public final b u;
    private String v = "";
    private String w = "";
    private Context x = null;
    private final ActivityInfo y;

    public static a a() {
        return null;
    }

    /* renamed from: com.alipay.sdk.sys.a$a  reason: collision with other inner class name */
    public static final class C0019a {

        /* renamed from: a  reason: collision with root package name */
        private static final HashMap<UUID, a> f3200a = new HashMap<>();
        private static final HashMap<String, a> b = new HashMap<>();

        public static void a(a aVar, Intent intent) {
            if (aVar != null && intent != null) {
                UUID randomUUID = UUID.randomUUID();
                f3200a.put(randomUUID, aVar);
                intent.putExtra("i_uuid_b_c", randomUUID);
            }
        }

        public static a a(Intent intent) {
            if (intent == null) {
                return null;
            }
            Serializable serializableExtra = intent.getSerializableExtra("i_uuid_b_c");
            if (serializableExtra instanceof UUID) {
                return f3200a.remove((UUID) serializableExtra);
            }
            return null;
        }

        public static void a(a aVar, String str) {
            if (aVar != null && !TextUtils.isEmpty(str)) {
                b.put(str, aVar);
            }
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b.remove(str);
        }
    }

    public a(Context context, String str, String str2) {
        String str3;
        boolean isEmpty = TextUtils.isEmpty(str2);
        this.u = new b(context, isEmpty);
        this.q = c(str, this.w);
        this.r = SystemClock.elapsedRealtime();
        this.s = l.d();
        this.y = l.h(context);
        this.t = str2;
        if (!isEmpty) {
            com.alipay.sdk.app.statistic.a.b(this, "biz", "eptyp", str2 + "|" + this.q);
            if (this.y != null) {
                str3 = this.y.name + "|" + this.y.launchMode;
            } else {
                str3 = "null";
            }
            com.alipay.sdk.app.statistic.a.b(this, "biz", "actInfo", str3);
            com.alipay.sdk.app.statistic.a.b(this, "biz", "sys", l.a(this));
        }
        try {
            this.x = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.v = packageInfo.versionName;
            this.w = packageInfo.packageName;
        } catch (Exception e) {
            c.a(e);
        }
        if (!isEmpty) {
            com.alipay.sdk.app.statistic.a.a(this, "biz", "u" + l.d());
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            com.alipay.sdk.app.statistic.a.b(this, "biz", "PgApiInvoke", sb.toString());
            com.alipay.sdk.app.statistic.a.a(context, this, str, this.q);
        }
        if (!isEmpty && com.alipay.sdk.data.a.s().n()) {
            com.alipay.sdk.data.a.s().a(this, this.x);
        }
    }

    public String b() {
        return this.w;
    }

    public String c() {
        return this.v;
    }

    public Context d() {
        return this.x;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
            return str;
        }
        if (b(str)) {
            return c(str);
        }
        return d(str);
    }

    private boolean b(String str) {
        return !str.contains("\"&");
    }

    private String c(String str) {
        try {
            String a2 = a(str, "&", "bizcontext=");
            if (TextUtils.isEmpty(a2)) {
                return str + "&" + b("bizcontext=", "");
            }
            int indexOf = str.indexOf(a2);
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + a2.length());
            return substring + a(a2, "bizcontext=", "", true) + substring2;
        } catch (Throwable unused) {
            return str;
        }
    }

    private String d(String str) {
        try {
            String a2 = a(str, "\"&", "bizcontext=\"");
            if (TextUtils.isEmpty(a2)) {
                return str + "&" + b("bizcontext=\"", jdn.f1779O000000o);
            }
            if (!a2.endsWith(jdn.f1779O000000o)) {
                a2 = a2 + jdn.f1779O000000o;
            }
            int indexOf = str.indexOf(a2);
            return str.substring(0, indexOf) + a(a2, "bizcontext=\"", jdn.f1779O000000o, false) + str.substring(indexOf + a2.length());
        } catch (Throwable unused) {
            return str;
        }
    }

    private String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.isEmpty(split[i]) && split[i].startsWith(str3)) {
                return split[i];
            }
        }
        return null;
    }

    private String b(String str, String str2) throws JSONException, UnsupportedEncodingException {
        String a2 = a("", "");
        return str + a2 + str2;
    }

    public String a(String str, String str2) {
        String str3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", "2014052600006128");
            jSONObject.put("ty", "and_lite");
            jSONObject.put("sv", "h.a.3.8.00");
            if (!this.w.contains("setting") || !l.b(this.x)) {
                jSONObject.put("an", this.w);
            }
            jSONObject.put("av", this.v);
            jSONObject.put("sdk_start_time", System.currentTimeMillis());
            jSONObject.put("extInfo", e());
            if (this.y != null) {
                str3 = this.y.name + "|" + this.y.launchMode;
            } else {
                str3 = "null";
            }
            jSONObject.put("act_info", str3);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(str, str2);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            c.a(th);
            return "";
        }
    }

    private String a(String str, String str2, String str3, boolean z) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject;
        String substring = str.substring(str2.length());
        boolean z2 = false;
        String substring2 = substring.substring(0, substring.length() - str3.length());
        if (substring2.length() < 2 || !substring2.startsWith(jdn.f1779O000000o) || !substring2.endsWith(jdn.f1779O000000o)) {
            jSONObject = new JSONObject(substring2);
        } else {
            jSONObject = new JSONObject(substring2.substring(1, substring2.length() - 1));
            z2 = true;
        }
        if (!jSONObject.has("appkey")) {
            jSONObject.put("appkey", "2014052600006128");
        }
        if (!jSONObject.has("ty")) {
            jSONObject.put("ty", "and_lite");
        }
        if (!jSONObject.has("sv")) {
            jSONObject.put("sv", "h.a.3.8.00");
        }
        if (!jSONObject.has("an") && (!this.w.contains("setting") || !l.b(this.x))) {
            jSONObject.put("an", this.w);
        }
        if (!jSONObject.has("av")) {
            jSONObject.put("av", this.v);
        }
        if (!jSONObject.has("sdk_start_time")) {
            jSONObject.put("sdk_start_time", System.currentTimeMillis());
        }
        if (!jSONObject.has("extInfo")) {
            jSONObject.put("extInfo", e());
        }
        String jSONObject2 = jSONObject.toString();
        if (z2) {
            jSONObject2 = jdn.f1779O000000o + jSONObject2 + jdn.f1779O000000o;
        }
        return str2 + jSONObject2 + str3;
    }

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ap_link_token", this.q);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static String c(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            objArr[2] = Long.valueOf(System.currentTimeMillis());
            objArr[3] = UUID.randomUUID().toString();
            return String.format("EP%s%s_%s", "1", l.f(String.format(locale, "%s%s%d%s", objArr)), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return "-";
        }
    }

    public static HashMap<String, String> a(a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (aVar != null) {
            hashMap.put("sdk_ver", "15.8.00");
            hashMap.put("app_name", aVar.w);
            hashMap.put("token", aVar.q);
            hashMap.put("call_type", aVar.t);
            hashMap.put("ts_api_invoke", String.valueOf(aVar.r));
        }
        return hashMap;
    }
}
