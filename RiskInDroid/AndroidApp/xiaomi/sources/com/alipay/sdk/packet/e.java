package com.alipay.sdk.packet;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.net.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.k;
import com.alipay.sdk.util.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e {
    protected boolean r = true;
    protected boolean s = true;

    /* access modifiers changed from: protected */
    public abstract JSONObject a() throws JSONException;

    /* access modifiers changed from: protected */
    public String b() {
        return "4.9.0";
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msp-gzip", String.valueOf(z));
        hashMap.put("Operation-Type", "alipay.msp.cashier.dispatch.bytes");
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put("Version", "2.0");
        hashMap.put("AppId", "TAOBAO");
        hashMap.put("Msp-Param", a.a(str));
        hashMap.put("des-mode", "CBC");
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public String c() throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put("device", Build.MODEL);
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put("api_name", "com.alipay.mcpay");
        hashMap.put("api_version", b());
        return a(hashMap, new HashMap());
    }

    protected static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public String a(a aVar, String str, JSONObject jSONObject) {
        b a2 = b.a();
        com.alipay.sdk.tid.a a3 = com.alipay.sdk.tid.a.a(a2.b());
        JSONObject a4 = com.alipay.sdk.util.b.a(new JSONObject(), jSONObject);
        try {
            a4.put("external_info", str);
            a4.put("tid", a3.a());
            a4.put("user_agent", a2.c().a(aVar, a3));
            a4.put("has_alipay", l.b(aVar, a2.b(), com.alipay.sdk.app.a.f3180a));
            a4.put("has_msp_app", l.a(a2.b()));
            a4.put("app_key", "2014052600006128");
            a4.put("utdid", a2.e());
            a4.put("new_client_key", a3.b());
            a4.put("pa", com.alipay.sdk.data.b.a(a2.b()));
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "BodyErr", th);
            c.a(th);
        }
        return a4.toString();
    }

    protected static boolean a(a.b bVar) {
        return Boolean.valueOf(a(bVar, "msp-gzip")).booleanValue();
    }

    protected static String a(a.b bVar, String str) {
        List list;
        if (bVar == null || str == null || bVar.f3194a == null || (list = bVar.f3194a.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    /* access modifiers changed from: protected */
    public String a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                jSONObject2.put((String) next.getKey(), next.getValue());
            }
        }
        if (hashMap2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry next2 : hashMap2.entrySet()) {
                jSONObject3.put((String) next2.getKey(), next2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has("params")) {
                return false;
            }
            String optString = jSONObject.getJSONObject("params").optString("public_key", null);
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            com.alipay.sdk.data.b.a(optString);
            return true;
        } catch (JSONException e) {
            c.a(e);
            return false;
        }
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context) throws Throwable {
        return a(aVar, context, "");
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, k.a(context));
    }

    public b a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) throws Throwable {
        return a(aVar, context, str, str2, true);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.alipay.sdk.packet.e.a(boolean, java.lang.String):java.util.Map<java.lang.String, java.lang.String>
     arg types: [int, java.lang.String]
     candidates:
      com.alipay.sdk.packet.e.a(com.alipay.sdk.net.a$b, java.lang.String):java.lang.String
      com.alipay.sdk.packet.e.a(java.lang.String, java.lang.String):org.json.JSONObject
      com.alipay.sdk.packet.e.a(com.alipay.sdk.sys.a, android.content.Context):com.alipay.sdk.packet.b
      com.alipay.sdk.packet.e.a(java.util.HashMap<java.lang.String, java.lang.String>, java.util.HashMap<java.lang.String, java.lang.String>):java.lang.String
      com.alipay.sdk.packet.e.a(boolean, java.lang.String):java.util.Map<java.lang.String, java.lang.String> */
    /* access modifiers changed from: protected */
    public b a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2, boolean z) throws Throwable {
        c.a("mspl", "Packet: ".concat(String.valueOf(str2)));
        c cVar = new c(this.s);
        b bVar = new b(c(), a(aVar, str, a()));
        Map<String, String> a2 = a(false, str);
        d a3 = cVar.a(bVar, this.r, a2.get("iSr"));
        a.b a4 = com.alipay.sdk.net.a.a(context, new a.C0018a(str2, a(a3.a(), str), a3.b()));
        if (a4 != null) {
            b a5 = cVar.a(new d(a(a4), a4.c), a2.get("iSr"));
            if (a5 == null || !a(a5.a()) || !z) {
                return a5;
            }
            return a(aVar, context, str, str2, false);
        }
        throw new RuntimeException("Response is null.");
    }
}
