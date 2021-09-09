package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.f;
import com.alipay.sdk.util.j;
import com.alipay.sdk.util.l;
import com.alipay.sdk.widget.a;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AuthTask {

    /* renamed from: a  reason: collision with root package name */
    static final Object f3167a = f.class;
    private Activity b;
    private a c;

    public AuthTask(Activity activity) {
        this.b = activity;
        b.a().a(this.b);
        this.c = new a(activity, "去支付宝授权");
    }

    private f.c a() {
        return new f.c() {
            /* class com.alipay.sdk.app.AuthTask.AnonymousClass1 */

            public void a() {
            }

            public void b() {
                AuthTask.this.c();
            }
        };
    }

    private void b() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        com.alipay.sdk.sys.a aVar;
        aVar = new com.alipay.sdk.sys.a(this.b, str, "authV2");
        return j.a(aVar, innerAuth(aVar, str, z));
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new com.alipay.sdk.sys.a(this.b, str, "auth"), str, z);
    }

    public synchronized String innerAuth(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        String c2;
        Activity activity;
        String str2;
        if (z) {
            b();
        }
        b.a().a(this.b);
        c2 = b.c();
        a.a("");
        try {
            c2 = a(this.b, str, aVar);
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturn", sb.toString());
            com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturnV", j.a(c2, "resultStatus") + "|" + j.a(c2, "memo"));
            if (!com.alipay.sdk.data.a.s().n()) {
                com.alipay.sdk.data.a.s().a(aVar, this.b);
            }
            c();
            activity = this.b;
            str2 = aVar.q;
        } catch (Exception e) {
            try {
                c.a(e);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(SystemClock.elapsedRealtime());
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturn", sb2.toString());
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturnV", j.a(c2, "resultStatus") + "|" + j.a(c2, "memo"));
                if (!com.alipay.sdk.data.a.s().n()) {
                    com.alipay.sdk.data.a.s().a(aVar, this.b);
                }
                c();
                activity = this.b;
                str2 = aVar.q;
            } catch (Throwable th) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(SystemClock.elapsedRealtime());
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturn", sb3.toString());
                com.alipay.sdk.app.statistic.a.b(aVar, "biz", "PgReturnV", j.a(c2, "resultStatus") + "|" + j.a(c2, "memo"));
                if (!com.alipay.sdk.data.a.s().n()) {
                    com.alipay.sdk.data.a.s().a(aVar, this.b);
                }
                c();
                com.alipay.sdk.app.statistic.a.b(this.b, aVar, str, aVar.q);
                throw th;
            }
        }
        com.alipay.sdk.app.statistic.a.b(activity, aVar, str, str2);
        return c2;
    }

    private String a(Activity activity, String str, com.alipay.sdk.sys.a aVar) {
        String a2 = aVar.a(str);
        List<a.C0017a> r = com.alipay.sdk.data.a.s().r();
        if (!com.alipay.sdk.data.a.s().f3186a || r == null) {
            r = a.f3180a;
        }
        if (l.b(aVar, this.b, r)) {
            String a3 = new f(activity, aVar, a()).a(a2);
            if (!TextUtils.equals(a3, "failed") && !TextUtils.equals(a3, "scheme_failed")) {
                return TextUtils.isEmpty(a3) ? b.c() : a3;
            }
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "LogBindCalledH5");
            return b(activity, a2, aVar);
        }
        com.alipay.sdk.app.statistic.a.a(aVar, "biz", "LogCalledH5");
        return b(activity, a2, aVar);
    }

    private String b(Activity activity, String str, com.alipay.sdk.sys.a aVar) {
        c cVar;
        b();
        try {
            List<com.alipay.sdk.protocol.b> a2 = com.alipay.sdk.protocol.b.a(new com.alipay.sdk.packet.impl.a().a(aVar, activity, str).c().optJSONObject("form").optJSONObject("onload"));
            c();
            for (int i = 0; i < a2.size(); i++) {
                if (a2.get(i).b() == com.alipay.sdk.protocol.a.WapPay) {
                    String a3 = a(aVar, a2.get(i));
                    c();
                    return a3;
                }
            }
        } catch (IOException e) {
            c b2 = c.b(c.NETWORK_ERROR.a());
            com.alipay.sdk.app.statistic.a.a(aVar, "net", e);
            c();
            cVar = b2;
        } catch (Throwable th) {
            c();
            throw th;
        }
        c();
        cVar = null;
        if (cVar == null) {
            cVar = c.b(c.FAILED.a());
        }
        return b.a(cVar.a(), cVar.b(), "");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r5 = com.alipay.sdk.app.b.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return com.alipay.sdk.app.b.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002e, code lost:
        r4 = com.alipay.sdk.app.b.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0036, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L_?;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003f */
    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        String[] c2 = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        Intent intent = new Intent(this.b, H5AuthActivity.class);
        intent.putExtras(bundle);
        a.C0019a.a(aVar, intent);
        this.b.startActivity(intent);
        synchronized (f3167a) {
            f3167a.wait();
        }
    }
}
