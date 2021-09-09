package com.xiaomi.onetrack.a;

import android.content.Context;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.ServiceQualityEvent;
import com.xiaomi.onetrack.c.g;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.f.b;
import com.xiaomi.onetrack.h.h;
import com.xiaomi.onetrack.h.r;
import com.xiaomi.onetrack.h.s;
import com.xiaomi.onetrack.h.z;
import java.io.StringWriter;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static String a(String str, JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("H", b.a(str, configuration, iEventHook));
        jSONObject3.put("B", s.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(String str, String str2, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject, boolean z) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("H", b.a(str2, configuration, iEventHook));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("class", str);
        jSONObject3.put("type", 1);
        jSONObject3.put("app_start", z);
        jSONObject2.put("B", s.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(String str, String str2, long j, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("H", b.a(str2, configuration, iEventHook));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("class", str);
        jSONObject3.put("type", 2);
        jSONObject3.put("duration", j);
        jSONObject2.put("B", s.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(String str, String str2, String str3, String str4, String str5, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject a2 = b.a("onetrack_bug_report", configuration, iEventHook);
        if (str5 != null) {
            a2.put(b.C0053b.o, str5);
        }
        jSONObject2.put("H", a2);
        JSONObject jSONObject3 = new JSONObject();
        new StringWriter();
        jSONObject3.put("exception", str);
        jSONObject3.put("type", str3);
        jSONObject3.put("message", str2);
        jSONObject3.put("feature", str4);
        jSONObject2.put("B", s.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
     arg types: [java.lang.String, java.util.List<java.lang.String>]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject */
    public static String a(Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("H", b.a("onetrack_dau", configuration, iEventHook));
        JSONObject jSONObject3 = new JSONObject();
        Context a2 = a.a();
        boolean s = z.s();
        if (s) {
            z.c(false);
        }
        jSONObject3.put("first_open", s);
        if (!(r.a() ? r.A() : configuration.isInternational())) {
            if (configuration.isIMEIEnable()) {
                jSONObject3.put("imeis", (Object) h.q(a2));
            }
            if (configuration.isIMSIEnable()) {
                jSONObject3.put("imsis", h.v(a2));
            }
        }
        jSONObject3.put("config_status", a.a(configuration));
        jSONObject2.put("B", s.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("H", b.a("ot_profile_set", configuration, iEventHook));
        jSONObject3.put("B", s.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String b(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("H", b.a("ot_profile_increment", configuration, iEventHook));
        jSONObject3.put("B", s.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(String str, String str2, JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("H", b.a(str2, configuration, iEventHook, str));
        jSONObject3.put("B", s.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(Configuration configuration, OneTrack.IEventHook iEventHook) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("H", b.a("onetrack_cta_status", configuration, iEventHook));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("value", g.b());
        jSONObject.put("B", jSONObject2);
        return jSONObject.toString();
    }

    public static String c(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("H", b.a("ot_login", configuration, iEventHook));
        jSONObject3.put("B", s.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String d(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("H", b.a("ot_logout", configuration, iEventHook));
        jSONObject3.put("B", s.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(ServiceQualityEvent serviceQualityEvent, Configuration configuration, OneTrack.IEventHook iEventHook) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("H", b.a("ot_service_quality", configuration, iEventHook));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("scheme", serviceQualityEvent.getScheme());
        jSONObject2.put("host", serviceQualityEvent.getHost());
        jSONObject2.put("port", serviceQualityEvent.getPort());
        jSONObject2.put("path", serviceQualityEvent.getPath());
        jSONObject2.put("ips", serviceQualityEvent.getIps());
        jSONObject2.put("response", serviceQualityEvent.getResponseCode());
        jSONObject2.put("status", serviceQualityEvent.getStatusCode());
        jSONObject2.put("exception", serviceQualityEvent.getExceptionTag());
        jSONObject2.put("result", serviceQualityEvent.getResultType());
        jSONObject2.put("retry", serviceQualityEvent.getRetryCount());
        jSONObject2.put("req_ts", serviceQualityEvent.getRequestTimestamp());
        jSONObject2.put("req_net", serviceQualityEvent.getRequestNetType());
        jSONObject2.put("dns", serviceQualityEvent.getDnsLookupTime());
        jSONObject2.put("tcp_connect", serviceQualityEvent.getTcpConnectTime());
        jSONObject2.put("handshake", serviceQualityEvent.getHandshakeTime());
        jSONObject2.put("res_first_byte", serviceQualityEvent.getReceiveFirstByteTime());
        jSONObject2.put("res_all_byte", serviceQualityEvent.getReceiveAllByteTime());
        jSONObject2.put("req_data_send", serviceQualityEvent.getRequestDataSendTime());
        jSONObject2.put("duration", serviceQualityEvent.getDuration());
        jSONObject2.put("net_sdk_ver", serviceQualityEvent.getNetSdkVersion());
        Map<String, Object> extraParams = serviceQualityEvent.getExtraParams();
        if (extraParams != null && extraParams.size() > 0) {
            for (Map.Entry next : extraParams.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (s.b(value)) {
                    jSONObject2.put(str, value);
                }
            }
        }
        jSONObject.put("B", jSONObject2);
        return jSONObject.toString();
    }

    public static String a(long j, String str, long j2, long j3, Configuration configuration, OneTrack.IEventHook iEventHook) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("H", b.a("onetrack_upgrade", configuration, iEventHook));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("last_ver_code", j);
        jSONObject2.put("last_ver_name", str);
        jSONObject2.put("cur_ver_code", j2);
        jSONObject2.put("last_upgrade_time", j3);
        jSONObject.put("B", jSONObject2);
        return jSONObject.toString();
    }
}
