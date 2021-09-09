package com.alipay.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

public class f {
    /* access modifiers changed from: private */
    public Activity c;
    /* access modifiers changed from: private */
    public volatile IAlixPay d;
    /* access modifiers changed from: private */
    public final Object e = IAlixPay.class;
    private boolean f;
    /* access modifiers changed from: private */
    public c g;
    /* access modifiers changed from: private */
    public final com.alipay.sdk.sys.a h;
    private boolean i = false;
    /* access modifiers changed from: private */
    public String j = null;
    /* access modifiers changed from: private */
    public String k = null;

    public interface c {
        void a();

        void b();
    }

    public f(Activity activity, com.alipay.sdk.sys.a aVar, c cVar) {
        this.c = activity;
        this.h = aVar;
        this.g = cVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:18|(2:20|(1:22)(10:23|25|(1:27)|28|(3:32|33|(2:37|(4:41|(3:45|46|(1:66)(0))|63|38))(0))(0)|48|49|(1:53)|57|(2:59|60)(2:61|62)))|24|25|(0)|28|30|32|33|35|37|(1:38)|48|49|51|53|57|(0)(0)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00af */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[Catch:{ Throwable -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0087 A[Catch:{ Throwable -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d5  */
    public String a(String str) {
        String q;
        JSONObject optJSONObject;
        Iterator<String> keys;
        String str2 = "";
        PackageInfo packageInfo = null;
        try {
            List<a.C0017a> r = com.alipay.sdk.data.a.s().r();
            if (!com.alipay.sdk.data.a.s().f3186a || r == null) {
                r = com.alipay.sdk.app.a.f3180a;
            }
            l.a a2 = l.a(this.h, this.c, r);
            if (a2 != null) {
                if (!a2.a(this.h)) {
                    if (!a2.a()) {
                        if (l.a(a2.f3211a)) {
                            return "failed";
                        }
                        if (a2.f3211a != null) {
                            if (!"com.eg.android.AlipayGphone".equals(a2.f3211a.packageName)) {
                                str2 = a2.f3211a.packageName;
                                if (a2.f3211a != null) {
                                    packageInfo = a2.f3211a;
                                }
                                q = com.alipay.sdk.data.a.s().q();
                                if (q != null && q.length() > 0) {
                                    optJSONObject = new JSONObject(q).optJSONObject(str2);
                                    if (optJSONObject != null && optJSONObject.length() > 0) {
                                        keys = optJSONObject.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            int parseInt = Integer.parseInt(next);
                                            if (packageInfo != null && packageInfo.versionCode >= parseInt) {
                                                try {
                                                    this.i = com.alipay.sdk.data.a.s().a(this.c, Integer.parseInt(optJSONObject.getString(next)));
                                                    if (!this.i) {
                                                    }
                                                } catch (Exception unused) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (!this.i && !com.alipay.sdk.data.a.s().m()) {
                                    a(a2);
                                }
                                if (!this.i) {
                                    return a(str, str2, packageInfo);
                                }
                                return b(str, str2, packageInfo);
                            }
                        }
                        str2 = l.a();
                        if (a2.f3211a != null) {
                        }
                        q = com.alipay.sdk.data.a.s().q();
                        optJSONObject = new JSONObject(q).optJSONObject(str2);
                        keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                        }
                        a(a2);
                        if (!this.i) {
                        }
                    }
                }
            }
            return "failed";
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(this.h, "biz", "CheckClientSignEx", th);
        }
    }

    private void a(l.a aVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (aVar != null && (packageInfo = aVar.f3211a) != null) {
            String str = packageInfo.packageName;
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
            try {
                this.c.startActivity(intent);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(this.h, "biz", "StartLaunchAppTransEx", th);
            }
            Thread.sleep(200);
        }
    }

    private String a(String str, String str2, PackageInfo packageInfo) {
        if (packageInfo != null) {
            int i2 = packageInfo.versionCode;
        }
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        c.b("mspl", "pay bind or scheme");
        com.alipay.sdk.sys.a aVar = this.h;
        com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgWltVer", str2 + "|" + str3);
        Activity activity = this.c;
        com.alipay.sdk.sys.a aVar2 = this.h;
        com.alipay.sdk.app.statistic.a.a(activity, aVar2, str, aVar2.q);
        return b(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae  */
    private String b(String str, String str2, PackageInfo packageInfo) {
        String str3;
        String str4;
        com.alipay.sdk.sys.a aVar;
        int i2 = packageInfo != null ? packageInfo.versionCode : 0;
        if (packageInfo != null) {
            str3 = packageInfo.versionName;
        } else {
            str3 = "";
        }
        c.b("mspl", "pay bind or scheme");
        com.alipay.sdk.sys.a aVar2 = this.h;
        com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgWltVer", str2 + "|" + str3);
        if (l.e()) {
            com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BindSkipByModel");
        } else if (l.c(this.h, str2)) {
            com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BindSkipByL");
        } else {
            Pair<String, Boolean> a2 = a(str, str2, this.h);
            String str5 = (String) a2.first;
            try {
                if ("failed".equals(str5) && ((Boolean) a2.second).booleanValue() && com.alipay.sdk.data.a.s().l()) {
                    com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BindRetry");
                    str4 = (String) a(str, str2, this.h).first;
                    c.b("mspl", "pay bind result: ".concat(String.valueOf(str4)));
                    Activity activity = this.c;
                    com.alipay.sdk.sys.a aVar3 = this.h;
                    com.alipay.sdk.app.statistic.a.a(activity, aVar3, str, aVar3.q);
                    if ("failed".equals(str4)) {
                        if (!com.alipay.sdk.data.a.s().c()) {
                            com.alipay.sdk.app.statistic.a.b(this.h, "biz", "BSPNotStartByConfig", "");
                            return str4;
                        } else if (!"com.eg.android.AlipayGphone".equals(str2) || i2 <= 125) {
                            com.alipay.sdk.sys.a aVar4 = this.h;
                            com.alipay.sdk.app.statistic.a.b(aVar4, "biz", "BSPNotStartByPkg", str2 + "|" + i2);
                        } else if (!com.alipay.sdk.data.a.s().i() || (aVar = this.h) == null || l.b(aVar.s) == 0) {
                            Activity activity2 = this.c;
                            if (activity2 == null || !a(str2, activity2, this.h)) {
                                return "scheme_failed";
                            }
                            return a(str, str2);
                        } else {
                            com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BSPNotStartByUsr");
                            return str4;
                        }
                    }
                    return str4;
                }
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BindRetryEx", th);
            }
            str4 = str5;
            c.b("mspl", "pay bind result: ".concat(String.valueOf(str4)));
            Activity activity3 = this.c;
            com.alipay.sdk.sys.a aVar32 = this.h;
            com.alipay.sdk.app.statistic.a.a(activity3, aVar32, str, aVar32.q);
            if ("failed".equals(str4)) {
            }
            return str4;
        }
        str4 = "failed";
        c.b("mspl", "pay bind result: ".concat(String.valueOf(str4)));
        Activity activity32 = this.c;
        com.alipay.sdk.sys.a aVar322 = this.h;
        com.alipay.sdk.app.statistic.a.a(activity32, aVar322, str, aVar322.q);
        if ("failed".equals(str4)) {
        }
        return str4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00e5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x016d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        com.alipay.sdk.app.statistic.a.a(r1.h, "biz", "BSPLocEx", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01de, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01df, code lost:
        r6 = "unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        com.alipay.sdk.app.statistic.a.a(r1.h, "biz", "BSPStatEx", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x020e, code lost:
        com.alipay.sdk.app.statistic.a.a(r1.h, "biz", "BSPWaiting", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return com.alipay.sdk.app.b.a(com.alipay.sdk.app.c.PAY_WAITTING.a(), com.alipay.sdk.app.c.PAY_WAITTING.b(), "");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e5 A[ExcHandler: InterruptedException (r0v21 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:25:0x00e9] */
    private String a(String str, String str2) {
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject;
        String str6 = str;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        String a2 = l.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.app.statistic.a.b(this.h, "biz", "BSPStart", a2 + "|" + elapsedRealtime);
        a.C0019a.a(this.h, a2);
        AlipayResultActivity.f3166a.put(a2, new AlipayResultActivity.a() {
            /* class com.alipay.sdk.util.f.AnonymousClass1 */

            public void a(int i, String str, String str2) {
                String unused = f.this.j = com.alipay.sdk.app.b.a(i, str, str2);
                countDownLatch.countDown();
            }
        });
        try {
            String[] split = str6.split("&", -1);
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str3 = "";
                    str4 = str3;
                    str5 = null;
                    jSONObject = null;
                    break;
                }
                str5 = split[i2];
                if (str5.startsWith("bizcontext=")) {
                    String substring = str5.substring(str5.indexOf("{"), str5.lastIndexOf("}") + 1);
                    int indexOf = str5.indexOf(substring);
                    str4 = str5.substring(0, indexOf);
                    str3 = str5.substring(indexOf + substring.length());
                    jSONObject = new JSONObject(substring);
                    if (jSONObject.optString("sc").equals("h5tonative")) {
                        jSONObject.put("sc", "h5tonative_scheme");
                    } else {
                        jSONObject.put("sc", "h5tonative_sdkscheme");
                    }
                } else {
                    i2++;
                }
            }
            if (TextUtils.isEmpty(str5)) {
                throw new RuntimeException("empty ctx_args");
            } else if (str6.indexOf(str5) == str6.lastIndexOf(str5)) {
                str6 = str6.replace(str5, str4 + jSONObject.toString() + str3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sourcePid", Binder.getCallingPid());
                jSONObject2.put("external_info", str6);
                jSONObject2.put("pkgName", this.c.getPackageName());
                jSONObject2.put("session", a2);
                String encodeToString = Base64.encodeToString(jSONObject2.toString().getBytes("UTF-8"), 2);
                Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20000125");
                appendQueryParameter.appendQueryParameter("mqpSchemePay", encodeToString);
                HashMap<String, String> a3 = com.alipay.sdk.sys.a.a(this.h);
                a3.put("ts_scheme", String.valueOf(elapsedRealtime));
                appendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject((Map<?, ?>) a3).toString());
                String uri = appendQueryParameter.build().toString();
                Intent intent = new Intent();
                intent.setPackage(str2);
                intent.addFlags(268435456);
                intent.setData(Uri.parse(uri));
                com.alipay.sdk.app.statistic.a.a(this.c, this.h, str6, this.h.q);
                this.c.startActivity(intent);
                com.alipay.sdk.data.a.s().a(this.h, this.c.getApplicationContext());
                c.b("mspl", "pay scheme waiting ".concat(String.valueOf(uri)));
                countDownLatch.await();
                String str7 = this.j;
                String str8 = j.a(this.h, str7).get("resultStatus");
                if (str8 == null) {
                    str8 = "null";
                }
                com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BSPDone-".concat(String.valueOf(str8)));
                if (!TextUtils.isEmpty(str7)) {
                    return str7;
                }
                com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BSPEmpty");
                return "scheme_failed";
            } else {
                throw new RuntimeException("multi ctx_args");
            }
        } catch (Exception e2) {
            try {
                com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BSPSCReplaceEx", e2, Base64.encodeToString(str.getBytes(), 2));
            } catch (InterruptedException e3) {
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BSPEx", th);
                return "scheme_failed";
            }
        }
    }

    private static boolean a(String str, Context context, com.alipay.sdk.sys.a aVar) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "BSPDetectFail");
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "BSPDetectFail", th);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x021f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0220, code lost:
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        r5.unregisterCallback(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x028d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x028e, code lost:
        com.alipay.sdk.util.c.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        com.alipay.sdk.app.statistic.a.a(r4, "biz", "ClientBindException", r0);
        r0 = com.alipay.sdk.app.b.c();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x021f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:72:0x0177] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0240 A[SYNTHETIC, Splitter:B:115:0x0240] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0289 A[SYNTHETIC, Splitter:B:130:0x0289] */
    private Pair<String, Boolean> a(String str, String str2, com.alipay.sdk.sys.a aVar) {
        int i2;
        Throwable th;
        Activity activity;
        Activity activity2;
        int i3;
        String str3;
        Activity activity3;
        Activity activity4;
        String str4 = str;
        String str5 = str2;
        com.alipay.sdk.sys.a aVar2 = aVar;
        Intent intent = new Intent();
        intent.setPackage(str5);
        intent.setAction(l.a(str2));
        String a2 = l.a(this.c, str5);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append(elapsedRealtime);
        sb.append("|");
        sb.append(str4 != null ? str.length() : 0);
        com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgBindStarting", sb.toString());
        com.alipay.sdk.app.statistic.a.a(this.c, aVar2, str4, aVar2.q);
        try {
            if (!com.alipay.sdk.data.a.s().h()) {
                ComponentName startService = this.c.getApplication().startService(intent);
                com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "stSrv", startService != null ? startService.getPackageName() : "null");
            } else {
                com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "stSrv", "skipped");
            }
        } catch (Throwable th2) {
            com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "ClientBindServiceFailed", th2);
            return new Pair<>("failed", Boolean.TRUE);
        }
        if (com.alipay.sdk.data.a.s().k()) {
            i2 = 65;
            com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "bindFlg", "imp");
        } else {
            i2 = 1;
        }
        a aVar3 = null;
        b bVar = new b();
        if (this.c.getApplicationContext().bindService(intent, bVar, i2)) {
            synchronized (this.e) {
                if (this.d == null) {
                    try {
                        this.e.wait((long) com.alipay.sdk.data.a.s().a());
                    } catch (InterruptedException e2) {
                        com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "BindWaitTimeoutEx", e2);
                    }
                }
            }
            IAlixPay iAlixPay = this.d;
            if (iAlixPay == null) {
                try {
                    String a3 = l.a(this.c, str5);
                    com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "ClientBindFailed", a2 + "|" + a3);
                    Pair<String, Boolean> pair = new Pair<>("failed", Boolean.TRUE);
                    try {
                        this.c.getApplicationContext().unbindService(bVar);
                    } catch (Throwable th3) {
                        c.a(th3);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgBindEnd", sb2.toString());
                    com.alipay.sdk.app.statistic.a.a(this.c, aVar2, str4, aVar2.q);
                    this.d = null;
                    if (this.f && (activity4 = this.c) != null) {
                        activity4.setRequestedOrientation(0);
                        this.f = false;
                    }
                    return pair;
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "ClientBindFailed", th, "in_bind");
                        Pair<String, Boolean> pair2 = new Pair<>("failed", Boolean.TRUE);
                        if (aVar3 != null) {
                        }
                        try {
                            this.c.getApplicationContext().unbindService(bVar);
                        } catch (Throwable th5) {
                            c.a(th5);
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(SystemClock.elapsedRealtime());
                        com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgBindEnd", sb3.toString());
                        com.alipay.sdk.app.statistic.a.a(this.c, aVar2, str4, aVar2.q);
                        this.d = null;
                        activity2.setRequestedOrientation(0);
                        this.f = false;
                        return pair2;
                    } catch (Throwable th6) {
                        th = th6;
                        th = th;
                        if (aVar3 != null) {
                        }
                        try {
                            this.c.getApplicationContext().unbindService(bVar);
                        } catch (Throwable th7) {
                            c.a(th7);
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(SystemClock.elapsedRealtime());
                        com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgBindEnd", sb4.toString());
                        com.alipay.sdk.app.statistic.a.a(this.c, aVar2, str4, aVar2.q);
                        this.d = null;
                        activity.setRequestedOrientation(0);
                        this.f = false;
                        throw th;
                    }
                }
            } else {
                try {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgBinded", String.valueOf(elapsedRealtime2));
                    if (this.g != null) {
                        this.g.a();
                    }
                    if (this.c.getRequestedOrientation() == 0) {
                        this.c.setRequestedOrientation(1);
                        this.f = true;
                    }
                    try {
                        i3 = iAlixPay.getVersion();
                    } catch (Throwable th8) {
                        c.a(th8);
                        i3 = 0;
                    }
                    a aVar4 = new a();
                    if (i3 >= 3) {
                        try {
                            iAlixPay.registerCallback03(aVar4, str4, null);
                        } catch (Throwable th9) {
                        }
                    } else {
                        iAlixPay.registerCallback(aVar4);
                    }
                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                    com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgBindPay", String.valueOf(elapsedRealtime3));
                    if (i3 >= 3) {
                        iAlixPay.r03("biz", "bind_pay", null);
                    }
                    if (i3 >= 2) {
                        HashMap<String, String> a4 = com.alipay.sdk.sys.a.a(aVar);
                        a4.put("ts_bind", String.valueOf(elapsedRealtime));
                        a4.put("ts_bend", String.valueOf(elapsedRealtime2));
                        a4.put("ts_pay", String.valueOf(elapsedRealtime3));
                        str3 = iAlixPay.pay02(str4, a4);
                    } else {
                        str3 = iAlixPay.Pay(str4);
                    }
                    String str6 = str3;
                    try {
                        iAlixPay.unregisterCallback(aVar4);
                    } catch (Throwable th10) {
                        c.a(th10);
                    }
                    try {
                        this.c.getApplicationContext().unbindService(bVar);
                    } catch (Throwable th11) {
                        c.a(th11);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgBindEnd", sb5.toString());
                    com.alipay.sdk.app.statistic.a.a(this.c, aVar2, str4, aVar2.q);
                    this.d = null;
                    if (this.f && (activity3 = this.c) != null) {
                        activity3.setRequestedOrientation(0);
                        this.f = false;
                    }
                    return new Pair<>(str6, Boolean.FALSE);
                } catch (Throwable th12) {
                    th = th12;
                    aVar3 = null;
                    if (aVar3 != null) {
                    }
                    this.c.getApplicationContext().unbindService(bVar);
                    StringBuilder sb42 = new StringBuilder();
                    sb42.append(SystemClock.elapsedRealtime());
                    com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgBindEnd", sb42.toString());
                    com.alipay.sdk.app.statistic.a.a(this.c, aVar2, str4, aVar2.q);
                    this.d = null;
                    activity.setRequestedOrientation(0);
                    this.f = false;
                    throw th;
                }
            }
        } else {
            throw new Throwable("bindService fail");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ea, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00eb, code lost:
        com.alipay.sdk.app.statistic.a.a(r10.h, "biz", "BSAEx", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00f3, code lost:
        com.alipay.sdk.app.statistic.a.a(r10.h, "biz", "BSAWaiting", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return com.alipay.sdk.app.b.a(com.alipay.sdk.app.c.PAY_WAITTING.a(), com.alipay.sdk.app.c.PAY_WAITTING.b(), "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return "scheme_failed";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0054, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0057, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        com.alipay.sdk.app.statistic.a.a(r10.h, "biz", "BSALocEx", r3);
        r3 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0054 A[ExcHandler: InterruptedException (r11v6 'e' java.lang.InterruptedException A[CUSTOM_DECLARE]), Splitter:B:1:0x003f] */
    private String b(String str, String str2) {
        String str3;
        String str4;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        String a2 = l.a(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.app.statistic.a.b(this.h, "biz", "BSAStart", a2 + "|" + elapsedRealtime);
        a.C0019a.a(this.h, a2);
        APayEntranceActivity.e.put(a2, new APayEntranceActivity.a() {
            /* class com.alipay.sdk.util.f.AnonymousClass2 */

            public void a(String str) {
                String unused = f.this.k = str;
                countDownLatch.countDown();
            }
        });
        try {
            HashMap<String, String> a3 = com.alipay.sdk.sys.a.a(this.h);
            a3.put("ts_intent", String.valueOf(elapsedRealtime));
            JSONObject jSONObject = new JSONObject((Map<?, ?>) a3);
            Intent intent = new Intent(this.c, APayEntranceActivity.class);
            intent.putExtra("ap_order_info", str);
            intent.putExtra("ap_target_packagename", str2);
            intent.putExtra("ap_session", a2);
            if (jSONObject != null) {
                intent.putExtra("ap_local_info", jSONObject.toString());
            }
            com.alipay.sdk.app.statistic.a.a(this.c, this.h, str, this.h.q);
            this.c.startActivity(intent);
            com.alipay.sdk.data.a.s().a(this.h, this.c.getApplicationContext());
            countDownLatch.await();
            str3 = this.k;
            str4 = "unknown";
            String str5 = j.a(this.h, str3).get("resultStatus");
            if (str5 == null) {
                str5 = "null";
            }
            str4 = str5;
        } catch (InterruptedException e2) {
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BSAStatEx", th);
        }
        com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BSADone-".concat(String.valueOf(str4)));
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        com.alipay.sdk.app.statistic.a.a(this.h, "biz", "BSAEmpty");
        return "scheme_failed";
    }

    public void a() {
        this.c = null;
        this.g = null;
    }

    class b implements ServiceConnection {
        private b() {
        }

        public void onServiceDisconnected(ComponentName componentName) {
            com.alipay.sdk.app.statistic.a.a(f.this.h, "biz", "srvDis");
            IAlixPay unused = f.this.d = (IAlixPay) null;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.alipay.sdk.app.statistic.a.a(f.this.h, "biz", "srvCon");
            synchronized (f.this.e) {
                IAlixPay unused = f.this.d = IAlixPay.Stub.asInterface(iBinder);
                f.this.e.notify();
            }
        }
    }

    class a extends IRemoteServiceCallback.Stub {
        public int getVersion() throws RemoteException {
            return 3;
        }

        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        public void payEnd(boolean z, String str) throws RemoteException {
        }

        private a() {
        }

        public void r03(String str, String str2, Map map) throws RemoteException {
            com.alipay.sdk.app.statistic.a.b(f.this.h, "wlt", str, str2);
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x005f */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0067 A[Catch:{ Throwable -> 0x00b5 }] */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0091 A[Catch:{ Throwable -> 0x00b5 }] */
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (Exception e) {
                com.alipay.sdk.app.statistic.a.a(f.this.h, "biz", "ErrIntentEx", e);
            }
            intent.setClassName(str, str2);
            if (Build.VERSION.SDK_INT >= 16) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                com.alipay.sdk.sys.a a2 = f.this.h;
                com.alipay.sdk.app.statistic.a.b(a2, "biz", "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
            }
            try {
                if (f.this.c == null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    f.this.c.startActivity(intent);
                    com.alipay.sdk.sys.a a3 = f.this.h;
                    StringBuilder sb = new StringBuilder();
                    sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                    com.alipay.sdk.app.statistic.a.b(a3, "biz", "stAct2", sb.toString());
                } else {
                    com.alipay.sdk.app.statistic.a.a(f.this.h, "biz", "ErrActNull", "");
                    Context d = f.this.h.d();
                    if (d != null) {
                        d.startActivity(intent);
                    }
                }
                f.this.g.b();
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(f.this.h, "biz", "ErrActNull", th);
                throw th;
            }
        }
    }
}
