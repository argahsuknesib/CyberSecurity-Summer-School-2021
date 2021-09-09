package com.alipay.apmobilesecuritysdk.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.alipay.apmobilesecuritysdk.d.e;
import com.alipay.apmobilesecuritysdk.e.b;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.security.mobile.module.http.model.c;
import com.alipay.security.mobile.module.http.model.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f3151a;
    private com.alipay.apmobilesecuritysdk.b.a b = com.alipay.apmobilesecuritysdk.b.a.a();
    private int c = 4;

    public a(Context context) {
        this.f3151a = context;
    }

    public static String a(Context context) {
        String b2 = b(context);
        return com.alipay.security.mobile.module.a.a.a(b2) ? h.f(context) : b2;
    }

    public static String a(Context context, String str) {
        try {
            b();
            String a2 = i.a(str);
            if (!com.alipay.security.mobile.module.a.a.a(a2)) {
                return a2;
            }
            String a3 = g.a(context, str);
            i.a(str, a3);
            return !com.alipay.security.mobile.module.a.a.a(a3) ? a3 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] strArr = {"2017-01-27 2017-01-28", "2017-11-10 2017-11-11", "2017-12-11 2017-12-12"};
        int random = ((int) (Math.random() * 24.0d * 60.0d * 60.0d)) * 1;
        int i = 0;
        while (i < 3) {
            try {
                String[] split = strArr[i].split(" ");
                if (split != null && split.length == 2) {
                    Date date = new Date();
                    Date parse = simpleDateFormat.parse(split[0] + " 00:00:00");
                    Date parse2 = simpleDateFormat.parse(split[1] + " 23:59:59");
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(parse2);
                    instance.add(13, random);
                    Date time = instance.getTime();
                    if (date.after(parse) && date.before(time)) {
                        return true;
                    }
                }
                i++;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private c b(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        b b2;
        b c2;
        String str4 = "";
        try {
            Context context = this.f3151a;
            d dVar = new d();
            String a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", str4);
            String a3 = com.alipay.security.mobile.module.a.a.a(map, "sessionId", str4);
            String a4 = com.alipay.security.mobile.module.a.a.a(map, "rpcVersion", str4);
            String a5 = a(context, a2);
            String securityToken = UmidSdkWrapper.getSecurityToken(context);
            String d = h.d(context);
            if (com.alipay.security.mobile.module.a.a.b(a3)) {
                dVar.c = a3;
            } else {
                dVar.c = a5;
            }
            dVar.d = securityToken;
            dVar.e = d;
            dVar.f3245a = "android";
            com.alipay.apmobilesecuritysdk.e.c c3 = com.alipay.apmobilesecuritysdk.e.d.c(context);
            if (c3 != null) {
                str = c3.f3155a;
                str2 = c3.c;
            } else {
                str2 = str4;
                str = str2;
            }
            if (com.alipay.security.mobile.module.a.a.a(str) && (c2 = com.alipay.apmobilesecuritysdk.e.a.c(context)) != null) {
                str = c2.f3154a;
                str2 = c2.c;
            }
            com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b();
            if (b3 != null) {
                str4 = b3.f3155a;
                str3 = b3.c;
            } else {
                str3 = str4;
            }
            if (com.alipay.security.mobile.module.a.a.a(str4) && (b2 = com.alipay.apmobilesecuritysdk.e.a.b()) != null) {
                str4 = b2.f3154a;
                str3 = b2.c;
            }
            dVar.h = str;
            dVar.g = str4;
            dVar.j = a4;
            if (com.alipay.security.mobile.module.a.a.a(str)) {
                dVar.b = str4;
                dVar.i = str3;
            } else {
                dVar.b = str;
                dVar.i = str2;
            }
            dVar.f = e.a(context, map);
            return com.alipay.security.mobile.module.http.d.b(this.f3151a, this.b.c()).a(dVar);
        } catch (Throwable th) {
            th.printStackTrace();
            com.alipay.apmobilesecuritysdk.c.a.a(th);
            return null;
        }
    }

    private static String b(Context context) {
        try {
            String b2 = i.b();
            if (!com.alipay.security.mobile.module.a.a.a(b2)) {
                return b2;
            }
            com.alipay.apmobilesecuritysdk.e.c b3 = com.alipay.apmobilesecuritysdk.e.d.b(context);
            if (b3 != null) {
                i.a(b3);
                String str = b3.f3155a;
                if (com.alipay.security.mobile.module.a.a.b(str)) {
                    return str;
                }
            }
            b b4 = com.alipay.apmobilesecuritysdk.e.a.b(context);
            if (b4 == null) {
                return "";
            }
            i.a(b4);
            String str2 = b4.f3154a;
            return com.alipay.security.mobile.module.a.a.b(str2) ? str2 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void b() {
        try {
            String[] strArr = {"device_feature_file_name", "wallet_times", "wxcasxx_v3", "wxcasxx_v4", "wxxzyy_v1"};
            for (int i = 0; i < 5; i++) {
                File file = new File(Environment.getExternalStorageDirectory(), ".SystemConfig/".concat(String.valueOf(strArr[i])));
                if (file.exists() && file.canWrite()) {
                    file.delete();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d3 A[Catch:{ Exception -> 0x023c }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ff A[Catch:{ Exception -> 0x023c }] */
    public final int a(Map<String, String> map) {
        boolean z;
        int i;
        Context context;
        ConnectivityManager connectivityManager;
        String str;
        try {
            com.alipay.apmobilesecuritysdk.c.a.a(this.f3151a, com.alipay.security.mobile.module.a.a.a(map, "tid", ""), com.alipay.security.mobile.module.a.a.a(map, "utdid", ""), a(this.f3151a));
            String a2 = com.alipay.security.mobile.module.a.a.a(map, "appName", "");
            b();
            b(this.f3151a);
            a(this.f3151a, a2);
            i.a();
            boolean z2 = false;
            if (!a()) {
                if (!com.alipay.apmobilesecuritysdk.common.a.a(this.f3151a)) {
                    e.a();
                    if (!(!com.alipay.security.mobile.module.a.a.a(e.b(this.f3151a, map), i.c()))) {
                        String a3 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                        String a4 = com.alipay.security.mobile.module.a.a.a(map, "utdid", "");
                        if (!com.alipay.security.mobile.module.a.a.b(a3) || com.alipay.security.mobile.module.a.a.a(a3, i.d())) {
                            if (!com.alipay.security.mobile.module.a.a.b(a4) || com.alipay.security.mobile.module.a.a.a(a4, i.e())) {
                                if (i.a(this.f3151a, a2)) {
                                    if (!com.alipay.security.mobile.module.a.a.a(a(this.f3151a, a2))) {
                                        if (com.alipay.security.mobile.module.a.a.a(b(this.f3151a))) {
                                        }
                                        z = false;
                                        Context context2 = this.f3151a;
                                        com.alipay.security.mobile.module.b.b.a();
                                        h.b(context2, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                                        if (z) {
                                            new com.alipay.apmobilesecuritysdk.c.b();
                                            UmidSdkWrapper.startUmidTaskSync(this.f3151a, com.alipay.apmobilesecuritysdk.b.a.a().b());
                                            c b2 = b(map);
                                            int a5 = b2 != null ? b2.a() : 2;
                                            if (a5 != 1) {
                                                if (a5 != 3) {
                                                    if (b2 != null) {
                                                        str = "Server error, result:" + b2.b;
                                                    } else {
                                                        str = "Server error, returned null";
                                                    }
                                                    com.alipay.apmobilesecuritysdk.c.a.a(str);
                                                    if (com.alipay.security.mobile.module.a.a.a(a(this.f3151a, a2))) {
                                                        i = 4;
                                                    }
                                                } else {
                                                    i = 1;
                                                }
                                                this.c = i;
                                                com.alipay.security.mobile.module.http.v2.a b3 = com.alipay.security.mobile.module.http.d.b(this.f3151a, this.b.c());
                                                context = this.f3151a;
                                                NetworkInfo networkInfo = null;
                                                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                                if (connectivityManager != null) {
                                                    networkInfo = connectivityManager.getActiveNetworkInfo();
                                                }
                                                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1) {
                                                    z2 = true;
                                                }
                                                if (z2 && h.c(context)) {
                                                    new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b3).a();
                                                }
                                                return this.c;
                                            }
                                            h.a(this.f3151a, b2.b());
                                            h.d(this.f3151a, b2.c());
                                            h.e(this.f3151a, b2.l);
                                            h.a(this.f3151a, b2.m);
                                            h.f(this.f3151a, b2.n);
                                            h.g(this.f3151a, b2.p);
                                            i.c(e.b(this.f3151a, map));
                                            i.a(a2, b2.i);
                                            i.b(b2.h);
                                            i.d(b2.o);
                                            String a6 = com.alipay.security.mobile.module.a.a.a(map, "tid", "");
                                            if (!com.alipay.security.mobile.module.a.a.b(a6) || com.alipay.security.mobile.module.a.a.a(a6, i.d())) {
                                                a6 = i.d();
                                            } else {
                                                i.e(a6);
                                            }
                                            i.e(a6);
                                            String a7 = com.alipay.security.mobile.module.a.a.a(map, "utdid", "");
                                            if (!com.alipay.security.mobile.module.a.a.b(a7) || com.alipay.security.mobile.module.a.a.a(a7, i.e())) {
                                                a7 = i.e();
                                            } else {
                                                i.f(a7);
                                            }
                                            i.f(a7);
                                            i.a();
                                            com.alipay.apmobilesecuritysdk.e.d.a(this.f3151a, i.g());
                                            com.alipay.apmobilesecuritysdk.e.d.a();
                                            com.alipay.apmobilesecuritysdk.e.a.a(this.f3151a, new b(i.b(), i.c(), i.f()));
                                            com.alipay.apmobilesecuritysdk.e.a.a();
                                            g.a(this.f3151a, a2, i.a(a2));
                                            g.a();
                                            h.a(this.f3151a, a2, System.currentTimeMillis());
                                        }
                                        i = 0;
                                        this.c = i;
                                        com.alipay.security.mobile.module.http.v2.a b32 = com.alipay.security.mobile.module.http.d.b(this.f3151a, this.b.c());
                                        context = this.f3151a;
                                        NetworkInfo networkInfo2 = null;
                                        connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                                        if (connectivityManager != null) {
                                        }
                                        z2 = true;
                                        new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b32).a();
                                        return this.c;
                                    }
                                }
                            }
                        }
                    }
                    z = true;
                    Context context22 = this.f3151a;
                    com.alipay.security.mobile.module.b.b.a();
                    h.b(context22, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                    if (z) {
                    }
                    i = 0;
                    this.c = i;
                    com.alipay.security.mobile.module.http.v2.a b322 = com.alipay.security.mobile.module.http.d.b(this.f3151a, this.b.c());
                    context = this.f3151a;
                    NetworkInfo networkInfo22 = null;
                    connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null) {
                    }
                    z2 = true;
                    new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b322).a();
                    return this.c;
                }
            }
            if (!com.alipay.security.mobile.module.a.a.a(a(this.f3151a, a2))) {
                if (com.alipay.security.mobile.module.a.a.a(b(this.f3151a))) {
                }
                z = false;
                Context context222 = this.f3151a;
                com.alipay.security.mobile.module.b.b.a();
                h.b(context222, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
                if (z) {
                }
                i = 0;
                this.c = i;
                com.alipay.security.mobile.module.http.v2.a b3222 = com.alipay.security.mobile.module.http.d.b(this.f3151a, this.b.c());
                context = this.f3151a;
                NetworkInfo networkInfo222 = null;
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                }
                z2 = true;
                new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b3222).a();
                return this.c;
            }
            z = true;
            Context context2222 = this.f3151a;
            com.alipay.security.mobile.module.b.b.a();
            h.b(context2222, String.valueOf(com.alipay.security.mobile.module.b.b.n()));
            if (z) {
            }
            i = 0;
            this.c = i;
            com.alipay.security.mobile.module.http.v2.a b32222 = com.alipay.security.mobile.module.http.d.b(this.f3151a, this.b.c());
            context = this.f3151a;
            NetworkInfo networkInfo2222 = null;
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
            }
            z2 = true;
            new com.alipay.security.mobile.module.d.b(context.getFilesDir().getAbsolutePath() + "/log/ap", b32222).a();
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
        }
        return this.c;
    }
}
