package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.a.a.c;
import com.alipay.security.mobile.module.c.e;

public final class g {
    public static synchronized String a(Context context, String str) {
        synchronized (g.class) {
            String a2 = e.a(context, "openapi_file_pri", "openApi".concat(String.valueOf(str)), "");
            if (a.a(a2)) {
                return "";
            }
            String b = c.b(c.a(), a2);
            return a.a(b) ? "" : b;
        }
    }

    public static synchronized void a() {
        synchronized (g.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (g.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public static synchronized void a(Context context, String str, String str2) {
        synchronized (g.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.putString("openApi".concat(String.valueOf(str)), c.a(c.a(), str2));
                edit.commit();
            }
        }
    }
}
