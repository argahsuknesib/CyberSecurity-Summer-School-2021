package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ConditionVariable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.app.a;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.l;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class b {
    private static volatile b d;
    private String e;
    private String f = "sdk-and-lite";
    private String g;

    private static String e() {
        return "1";
    }

    private static String f() {
        return "-1;-1";
    }

    public String a() {
        return this.g;
    }

    private b() {
        String a2 = a.a();
        if (!a.b()) {
            this.f += '_' + a2;
        }
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (d == null) {
                d = new b();
            }
            bVar = d;
        }
        return bVar;
    }

    public static synchronized void a(String str) {
        synchronized (b.class) {
            if (!TextUtils.isEmpty(str)) {
                PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.sys.b.a().b()).edit().putString("trideskey", str).apply();
                com.alipay.sdk.cons.a.e = str;
            }
        }
    }

    private static String b(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.tid.a aVar2) {
        Context b = com.alipay.sdk.sys.b.a().b();
        com.alipay.sdk.util.a a2 = com.alipay.sdk.util.a.a(b);
        if (TextUtils.isEmpty(this.e)) {
            String b2 = l.b();
            String c = l.c();
            String d2 = l.d(b);
            String f2 = l.f(b);
            String e2 = l.e(b);
            String b3 = b(b);
            this.e = "Msp/15.8.00" + " (" + b2 + ";" + c + ";" + d2 + ";" + f2 + ";" + e2 + ";" + b3;
        }
        String b4 = com.alipay.sdk.util.a.b(b).b();
        String g2 = l.g(b);
        String e3 = e();
        String a3 = a2.a();
        String b5 = a2.b();
        String d3 = d();
        String c2 = c();
        if (aVar2 != null) {
            this.g = aVar2.b();
        }
        String replace = Build.MANUFACTURER.replace(";", " ");
        String replace2 = Build.MODEL.replace(";", " ");
        boolean d4 = com.alipay.sdk.sys.b.d();
        String d5 = a2.d();
        String c3 = c(b);
        String d6 = d(b);
        Context context = b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.e);
        sb.append(";");
        sb.append(b4);
        sb.append(";");
        sb.append(g2);
        sb.append(";");
        sb.append(e3);
        sb.append(";");
        sb.append(a3);
        sb.append(";");
        sb.append(b5);
        sb.append(";");
        sb.append(this.g);
        sb.append(";");
        sb.append(replace);
        sb.append(";");
        sb.append(replace2);
        sb.append(";");
        sb.append(d4);
        sb.append(";");
        sb.append(d5);
        sb.append(";");
        sb.append(f());
        sb.append(";");
        sb.append(this.f);
        sb.append(";");
        sb.append(d3);
        sb.append(";");
        sb.append(c2);
        sb.append(";");
        sb.append(c3);
        sb.append(";");
        sb.append(d6);
        if (aVar2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("tid", com.alipay.sdk.tid.a.a(context).a());
            hashMap.put("utdid", com.alipay.sdk.sys.b.a().e());
            String c4 = c(aVar, context, hashMap);
            if (!TextUtils.isEmpty(c4)) {
                sb.append(";;;");
                sb.append(c4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static String c() {
        String str;
        Context b = com.alipay.sdk.sys.b.a().b();
        SharedPreferences sharedPreferences = b.getSharedPreferences("virtualImeiAndImsi", 0);
        String string = sharedPreferences.getString("virtual_imei", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.tid.a.a(b).a())) {
            str = g();
        } else {
            str = com.alipay.sdk.util.a.a(b).b();
        }
        String str2 = str;
        sharedPreferences.edit().putString("virtual_imei", str2).apply();
        return str2;
    }

    public static String d() {
        String str;
        Context b = com.alipay.sdk.sys.b.a().b();
        SharedPreferences sharedPreferences = b.getSharedPreferences("virtualImeiAndImsi", 0);
        String string = sharedPreferences.getString("virtual_imsi", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.tid.a.a(b).a())) {
            String e2 = com.alipay.sdk.sys.b.a().e();
            if (TextUtils.isEmpty(e2) || e2.length() < 18) {
                str = g();
            } else {
                str = e2.substring(3, 18);
            }
        } else {
            str = com.alipay.sdk.util.a.a(b).a();
        }
        String str2 = str;
        sharedPreferences.edit().putString("virtual_imsi", str2).apply();
        return str2;
    }

    private static String g() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    private static String c(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "-1";
    }

    private static String d(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "00";
    }

    /* access modifiers changed from: private */
    public static String b(com.alipay.sdk.sys.a aVar, Context context, HashMap<String, String> hashMap) {
        final String[] strArr = {""};
        try {
            APSecuritySdk instance = APSecuritySdk.getInstance(context);
            final ConditionVariable conditionVariable = new ConditionVariable();
            instance.initToken(0, hashMap, new APSecuritySdk.InitResultListener() {
                /* class com.alipay.sdk.data.b.AnonymousClass1 */

                public final void onResult(APSecuritySdk.TokenResult tokenResult) {
                    if (tokenResult != null) {
                        strArr[0] = tokenResult.apdidToken;
                    }
                    conditionVariable.open();
                }
            });
            conditionVariable.block(3000);
        } catch (Throwable th) {
            c.a(th);
            com.alipay.sdk.app.statistic.a.a(aVar, "third", "GetApdidEx", th);
        }
        if (TextUtils.isEmpty(strArr[0])) {
            com.alipay.sdk.app.statistic.a.a(aVar, "third", "GetApdidNull", "missing token");
        }
        c.a("mspl", "ap:" + strArr[0]);
        return strArr[0];
    }

    private static String c(final com.alipay.sdk.sys.a aVar, final Context context, final HashMap<String, String> hashMap) {
        try {
            return (String) Executors.newFixedThreadPool(2).submit(new Callable<String>() {
                /* class com.alipay.sdk.data.b.AnonymousClass2 */

                /* renamed from: a */
                public final String call() throws Exception {
                    return b.b(aVar, context, hashMap);
                }
            }).get(3000, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, "third", "GetApdidTimeout", th);
            return "";
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append("(");
            sb.append(packageName);
            sb.append(";");
            sb.append(packageInfo.versionCode);
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
