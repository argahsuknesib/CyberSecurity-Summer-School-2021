package com.alipay.security.mobile.module.c;

import android.content.Context;
import com.alipay.security.mobile.module.a.a.c;
import java.util.HashMap;

public class a {
    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|18|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0029 */
    public static String a(Context context, String str, String str2) {
        synchronized (a.class) {
            String str3 = null;
            if (context != null) {
                if (!com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2)) {
                    String a2 = e.a(context, str, str2, "");
                    if (com.alipay.security.mobile.module.a.a.a(a2)) {
                        return null;
                    }
                    str3 = c.b(c.a(), a2);
                    return str3;
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0025 */
    public static void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            if (!com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2) && context != null) {
                String a2 = c.a(c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, a2);
                e.a(context, str, hashMap);
            }
        }
    }
}
