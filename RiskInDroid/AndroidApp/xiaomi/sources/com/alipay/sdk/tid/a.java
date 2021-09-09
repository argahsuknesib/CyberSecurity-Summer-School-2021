package com.alipay.sdk.tid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.encrypt.e;
import com.alipay.sdk.util.c;
import java.util.Random;
import org.json.JSONObject;

public class a {
    /* access modifiers changed from: private */
    public static Context h;
    private static a n;
    private String i;
    private String j;
    private long k;
    private String l;
    private String m;
    private boolean o = false;

    private void n() {
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (n == null) {
                n = new a();
            }
            if (h == null) {
                n.b(context);
            }
            aVar = n;
        }
        return aVar;
    }

    private void b(Context context) {
        if (context != null) {
            h = context.getApplicationContext();
        }
        if (!this.o) {
            this.o = true;
            k();
        }
    }

    public String a() {
        return this.i;
    }

    public String b() {
        return this.j;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return this.m;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.alipay.sdk.tid.a.a.a(java.lang.String, java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      com.alipay.sdk.tid.a.a.a(java.lang.String, java.lang.String, java.lang.String):void
      com.alipay.sdk.tid.a.a.a(java.lang.String, java.lang.String, boolean):java.lang.String */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    private void k() {
        String str;
        String str2;
        String str3;
        String str4;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        String str5 = null;
        try {
            String a2 = C0020a.a("alipay_tid_storage", "tidinfo", true);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(a2);
                str4 = jSONObject.optString("tid", "");
                try {
                    str2 = jSONObject.optString("client_key", "");
                } catch (Exception e) {
                    e = e;
                    str2 = null;
                    str = str2;
                    c.a(e);
                    str3 = null;
                    str5 = str4;
                    c.a("mspl", "tid_str: load");
                    if (!a(str5, str2, str, str3)) {
                    }
                }
                try {
                    valueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                    str = jSONObject.optString("vimei", "");
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                    c.a(e);
                    str3 = null;
                    str5 = str4;
                    c.a("mspl", "tid_str: load");
                    if (!a(str5, str2, str, str3)) {
                    }
                }
                try {
                    str3 = jSONObject.optString("vimsi", "");
                } catch (Exception e3) {
                    e = e3;
                    c.a(e);
                    str3 = null;
                    str5 = str4;
                    c.a("mspl", "tid_str: load");
                    if (!a(str5, str2, str, str3)) {
                    }
                }
                str5 = str4;
                c.a("mspl", "tid_str: load");
                if (!a(str5, str2, str, str3)) {
                    l();
                    return;
                }
                this.i = str5;
                this.j = str2;
                this.k = valueOf.longValue();
                this.l = str;
                this.m = str3;
                return;
            }
            str3 = null;
            str2 = null;
            str = null;
            c.a("mspl", "tid_str: load");
            if (!a(str5, str2, str, str3)) {
            }
        } catch (Exception e4) {
            e = e4;
            str4 = null;
            str2 = null;
            str = str2;
            c.a(e);
            str3 = null;
            str5 = str4;
            c.a("mspl", "tid_str: load");
            if (!a(str5, str2, str, str3)) {
            }
        }
    }

    private boolean a(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public boolean e() {
        return TextUtils.isEmpty(this.i) || TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m);
    }

    private void l() {
        this.i = "";
        this.j = f();
        this.k = System.currentTimeMillis();
        this.l = m();
        this.m = m();
        C0020a.b("alipay_tid_storage", "tidinfo");
    }

    private String m() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    public String f() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public void g() {
        c.a("mspl", "tid_str: del");
        l();
    }

    public boolean h() {
        return e();
    }

    public Long i() {
        return Long.valueOf(this.k);
    }

    public void a(String str, String str2) {
        c.a("mspl", "tid_str: save");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.i = str;
            this.j = str2;
            this.k = System.currentTimeMillis();
            o();
            n();
        }
    }

    private void a(String str, String str2, String str3, String str4, Long l2) {
        if (!a(str, str2, str3, str4)) {
            this.i = str;
            this.j = str2;
            this.l = str3;
            this.m = str4;
            if (l2 == null) {
                this.k = System.currentTimeMillis();
            } else {
                this.k = l2.longValue();
            }
            o();
        }
    }

    private void o() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.i);
            jSONObject.put("client_key", this.j);
            jSONObject.put("timestamp", this.k);
            jSONObject.put("vimei", this.l);
            jSONObject.put("vimsi", this.m);
            C0020a.a("alipay_tid_storage", "tidinfo", jSONObject.toString(), true);
        } catch (Exception e) {
            c.a(e);
        }
    }

    /* renamed from: com.alipay.sdk.tid.a$a  reason: collision with other inner class name */
    public static class C0020a {
        public static boolean a(String str, String str2) {
            if (a.h == null) {
                return false;
            }
            return a.h.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(String str, String str2) {
            if (a.h != null) {
                a.h.getSharedPreferences(str, 0).edit().remove(str2).apply();
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.alipay.sdk.tid.a.a.a(java.lang.String, java.lang.String, boolean):java.lang.String
         arg types: [java.lang.String, java.lang.String, int]
         candidates:
          com.alipay.sdk.tid.a.a.a(java.lang.String, java.lang.String, java.lang.String):void
          com.alipay.sdk.tid.a.a.a(java.lang.String, java.lang.String, boolean):java.lang.String */
        public static String c(String str, String str2) {
            return a(str, str2, true);
        }

        public static boolean d(String str, String str2) {
            if (a.h == null) {
                return false;
            }
            return a.h.getSharedPreferences(str, 0).contains(str2);
        }

        public static String a(String str, String str2, boolean z) {
            if (a.h == null) {
                return null;
            }
            String string = a.h.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z) {
                string = e.b(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    c.a("mspl", "tid_str: pref failed");
                }
            }
            c.a("mspl", "tid_str: from local");
            return string;
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z) {
            if (a.h != null) {
                SharedPreferences sharedPreferences = a.h.getSharedPreferences(str, 0);
                if (z) {
                    String a2 = a();
                    String a3 = e.a(a2, str3, str3);
                    if (TextUtils.isEmpty(a3)) {
                        String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, a2);
                    }
                    str3 = a3;
                }
                sharedPreferences.edit().putString(str2, str3).apply();
            }
        }

        private static String a() {
            String str;
            try {
                str = a.h.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                c.a(th);
                str = "";
            }
            return (str + "0000000000000000000000000000").substring(0, 24);
        }
    }
}
