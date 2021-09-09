package com.alipay.security.mobile.module.c;

import android.content.Context;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.a.a.c;
import java.util.HashMap;

public final class d {
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        return;
     */
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (d.class) {
            if (!a.a(str) && !a.a(str2) && context != null) {
                try {
                    String a2 = c.a(c.a(), str3);
                    HashMap hashMap = new HashMap();
                    hashMap.put(str2, a2);
                    e.a(context, str, hashMap);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
