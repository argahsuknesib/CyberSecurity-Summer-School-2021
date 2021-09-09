package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import com.alipay.security.mobile.module.d.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class a {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            com.alipay.security.mobile.module.d.a b = b(context, str, str2, str3);
            d.a(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", b.toString());
        }
    }

    public static synchronized void a(String str) {
        synchronized (a.class) {
            d.a(str);
        }
    }

    public static synchronized void a(Throwable th) {
        synchronized (a.class) {
            d.a(th);
        }
    }

    private static com.alipay.security.mobile.module.d.a b(Context context, String str, String str2, String str3) {
        String str4;
        try {
            str4 = context.getPackageName();
        } catch (Throwable unused) {
            str4 = "";
        }
        return new com.alipay.security.mobile.module.d.a(Build.MODEL, str4, "APPSecuritySDK-ALIPAYSDK", "3.4.0.201910161639", str, str2, str3);
    }
}
