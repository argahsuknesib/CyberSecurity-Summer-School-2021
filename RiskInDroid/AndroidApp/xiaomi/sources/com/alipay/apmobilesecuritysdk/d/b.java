package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;
import java.util.Map;

public final class b {
    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (b.class) {
            hashMap = new HashMap();
            String a2 = a.a(map, "tid", "");
            String a3 = a.a(map, "utdid", "");
            String a4 = a.a(map, "userId", "");
            String a5 = a.a(map, "appName", "");
            String a6 = a.a(map, "appKeyClient", "");
            String a7 = a.a(map, "tmxSessionId", "");
            String f = h.f(context);
            String a8 = a.a(map, "sessionId", "");
            hashMap.put("AC1", a2);
            hashMap.put("AC2", a3);
            hashMap.put("AC3", "");
            hashMap.put("AC4", f);
            hashMap.put("AC5", a4);
            hashMap.put("AC6", a7);
            hashMap.put("AC7", "");
            hashMap.put("AC8", a5);
            hashMap.put("AC9", a6);
            if (a.b(a8)) {
                hashMap.put("AC10", a8);
            }
        }
        return hashMap;
    }
}
