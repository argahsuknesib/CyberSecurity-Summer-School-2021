package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.security.mobile.module.a.a;
import java.util.HashMap;
import java.util.Map;

public class SecurityClientMobile {
    public static synchronized String GetApdid(Context context, Map<String, String> map) {
        String a2;
        synchronized (SecurityClientMobile.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("utdid", a.a(map, "utdid", ""));
            hashMap.put("tid", a.a(map, "tid", ""));
            hashMap.put("userId", a.a(map, "userId", ""));
            APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
            a2 = com.alipay.apmobilesecuritysdk.a.a.a(context);
        }
        return a2;
    }
}
