package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;
import org.json.JSONObject;

public final class d {
    private static c a(String str) {
        try {
            if (a.a(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString("tid"), jSONObject.optString("utdid"));
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
            return null;
        }
    }

    public static synchronized void a() {
        synchronized (d.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
        }
    }

    public static synchronized void a(Context context, c cVar) {
        synchronized (d.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", cVar.f3155a);
                jSONObject.put("deviceInfoHash", cVar.b);
                jSONObject.put("timestamp", cVar.c);
                jSONObject.put("tid", cVar.d);
                jSONObject.put("utdid", cVar.e);
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
            } catch (Exception e) {
                com.alipay.apmobilesecuritysdk.c.a.a(e);
            }
        }
    }

    public static synchronized c b() {
        synchronized (d.class) {
            String a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            if (a.a(a2)) {
                return null;
            }
            c a3 = a(a2);
            return a3;
        }
    }

    public static synchronized c b(Context context) {
        c a2;
        synchronized (d.class) {
            String a3 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (a.a(a3)) {
                a3 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            }
            a2 = a(a3);
        }
        return a2;
    }

    public static synchronized c c(Context context) {
        synchronized (d.class) {
            String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (a.a(a2)) {
                return null;
            }
            c a3 = a(a2);
            return a3;
        }
    }
}
