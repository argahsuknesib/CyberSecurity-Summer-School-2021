package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.e;
import com.alipay.sdk.sys.a;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f3209a;

    public static synchronized boolean a(Context context, String str) {
        boolean z;
        synchronized (h.class) {
            z = false;
            try {
                z = PreferenceManager.getDefaultSharedPreferences(context).contains(str);
            } catch (Throwable th) {
                c.a(th);
            }
        }
        return z;
    }

    public static synchronized void b(Context context, String str) {
        synchronized (h.class) {
            try {
                PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    public static synchronized void a(a aVar, Context context, String str, String str2) {
        synchronized (h.class) {
            try {
                String a2 = e.a(a(context), str2, str);
                if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(a2)) {
                    com.alipay.sdk.app.statistic.a.a(aVar, "cp", "TriDesDecryptError", String.format("%s,%s", str, str2));
                }
                PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, a2).apply();
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    public static synchronized String b(a aVar, Context context, String str, String str2) {
        String str3;
        synchronized (h.class) {
            str3 = null;
            try {
                String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                if (!TextUtils.isEmpty(string)) {
                    str3 = e.b(a(context), string, str);
                }
                if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(str3)) {
                    com.alipay.sdk.app.statistic.a.a(aVar, "cp", "TriDesEncryptError", String.format("%s,%s", str, string));
                }
            } catch (Exception e) {
                c.a(e);
            }
        }
        return str3;
    }

    private static String a(Context context) {
        String str;
        if (TextUtils.isEmpty(f3209a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                c.a(th);
                str = "";
            }
            f3209a = (str + "0000000000000000000000000000").substring(0, 24);
        }
        return f3209a;
    }
}
