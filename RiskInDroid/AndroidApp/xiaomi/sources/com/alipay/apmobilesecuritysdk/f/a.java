package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import com.alipay.security.mobile.module.a.a.c;
import com.alipay.security.mobile.module.c.b;
import com.alipay.security.mobile.module.c.e;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public class a {
    public static String a(Context context, String str, String str2) {
        if (context == null || com.alipay.security.mobile.module.a.a.a(str) || com.alipay.security.mobile.module.a.a.a(str2)) {
            return null;
        }
        try {
            String a2 = e.a(context, str, str2, "");
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                return null;
            }
            return c.b(c.a(), a2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003b, code lost:
        return null;
     */
    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (!com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2)) {
                try {
                    String a2 = b.a(str);
                    if (com.alipay.security.mobile.module.a.a.a(a2)) {
                        return null;
                    }
                    String string = new JSONObject(a2).getString(str2);
                    if (com.alipay.security.mobile.module.a.a.a(string)) {
                        return null;
                    }
                    String b = c.b(c.a(), string);
                    return b;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2) && context != null) {
            try {
                String a2 = c.a(c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, a2);
                e.a(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:7|8|(4:10|11|12|13)|14|15|16|17|18|(4:20|21|22|(2:24|(1:28)))|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0072, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006f */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[Catch:{  }] */
    public static void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (!com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2)) {
                String a2 = b.a(str);
                JSONObject jSONObject = new JSONObject();
                if (com.alipay.security.mobile.module.a.a.b(a2)) {
                    jSONObject = new JSONObject(a2);
                    jSONObject = new JSONObject();
                }
                jSONObject.put(str2, c.a(c.a(), str3));
                System.clearProperty(str);
                if (com.alipay.security.mobile.module.c.c.a()) {
                    String str4 = ".SystemConfig" + File.separator + str;
                    if (com.alipay.security.mobile.module.c.c.a()) {
                        File file = new File(Environment.getExternalStorageDirectory(), str4);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }
}
