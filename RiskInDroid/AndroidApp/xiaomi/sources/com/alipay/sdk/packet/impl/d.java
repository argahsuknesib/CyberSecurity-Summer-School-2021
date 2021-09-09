package com.alipay.sdk.packet.impl;

import android.content.Context;
import com.alipay.sdk.packet.b;
import com.alipay.sdk.packet.e;
import com.alipay.sdk.sys.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends e {
    public String a(a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    public JSONObject a() throws JSONException {
        return null;
    }

    public Map<String, String> a(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msp-gzip", String.valueOf(z));
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put("des-mode", "CBC");
        return hashMap;
    }

    public String c() throws JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put("api_name", "/sdk/log");
        hashMap.put("api_version", "1.0.0");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("log_v", "1.0");
        return a(hashMap, hashMap2);
    }

    public b a(a aVar, Context context, String str) throws Throwable {
        return a(aVar, context, str, "https://mcgw.alipay.com/sdklog.do", true);
    }
}
