package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.l;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class OpenAuthTask {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Callback> f3171a = new ConcurrentHashMap();
    private static long b = -1;
    private volatile boolean d = false;
    private final Activity e;
    /* access modifiers changed from: private */
    public Callback f;
    private final Handler g = new Handler(Looper.getMainLooper());

    public interface Callback {
        void onResult(int i, String str, Bundle bundle);
    }

    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");
        
        public String appId;

        private BizType(String str) {
            this.appId = str;
        }
    }

    public OpenAuthTask(Activity activity) {
        this.e = activity;
        b.a().a(activity);
    }

    public final void execute(String str, BizType bizType, Map<String, String> map, Callback callback, boolean z) {
        com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.e, String.valueOf(map), "oa-".concat(String.valueOf(bizType)));
        this.f = callback;
        if (a(aVar, str, bizType, map, z)) {
            com.alipay.sdk.app.statistic.a.b(this.e, aVar, "", aVar.q);
        }
    }

    private boolean a(com.alipay.sdk.sys.a aVar, String str, BizType bizType, Map<String, String> map, boolean z) {
        com.alipay.sdk.sys.a aVar2 = aVar;
        BizType bizType2 = bizType;
        if (this.d) {
            this.g.post(new a(this, 4000, "该 OpenAuthTask 已在执行", null, null));
            return true;
        }
        this.d = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - b <= 3000) {
            this.g.post(new a(this, 5000, "3s 内重复支付", null, null));
            return true;
        }
        b = elapsedRealtime;
        a.a("");
        String a2 = l.a(32);
        HashMap hashMap = new HashMap(map);
        hashMap.put("mqpPkgName", this.e.getPackageName());
        hashMap.put("mqpScene", "sdk");
        List<a.C0017a> r = com.alipay.sdk.data.a.s().r();
        if (!com.alipay.sdk.data.a.s().f3186a || r == null) {
            r = a.f3180a;
        }
        l.a a3 = l.a(aVar2, this.e, r);
        if (a3 != null && !a3.a(aVar2) && !a3.a() && a3.f3211a != null && a3.f3211a.versionCode >= 122) {
            try {
                HashMap<String, String> a4 = com.alipay.sdk.sys.a.a(aVar);
                a4.put("ts_scheme", String.valueOf(SystemClock.elapsedRealtime()));
                hashMap.put("mqpLoc", new JSONObject((Map<?, ?>) a4).toString());
            } catch (Throwable unused) {
                this.g.post(new a(this, 4000, "业务参数错误", null, null));
                return true;
            }
            String a5 = a(bizType2, hashMap);
            f3171a.put(a2, this.f);
            String str2 = null;
            try {
                str2 = a(elapsedRealtime, a2, bizType, a5);
            } catch (JSONException e2) {
                com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "JSONEx", e2);
            }
            String str3 = str2;
            if (TextUtils.isEmpty(str3)) {
                this.g.post(new a(this, 4000, "参数错误", null, null));
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20001129").appendQueryParameter("payload", str3).build());
            intent.addFlags(268435456);
            intent.setPackage(a3.f3211a.packageName);
            try {
                com.alipay.sdk.app.statistic.a.b(aVar2, "biz", "PgOpenStarting", String.valueOf(elapsedRealtime));
                a.C0019a.a(aVar2, a2);
                this.e.startActivity(intent);
            } catch (Throwable th) {
                com.alipay.sdk.app.statistic.a.a(aVar2, "biz", "StartWalletEx", th);
            }
            return false;
        } else if (z) {
            hashMap.put("mqpScheme", String.valueOf(str));
            hashMap.put("mqpNotifyName", a2);
            hashMap.put("mqpScene", "landing");
            String a6 = a(bizType2, hashMap);
            Intent intent2 = new Intent(this.e, H5OpenAuthActivity.class);
            intent2.putExtra("url", String.format("https://render.alipay.com/p/s/i?scheme=%s", Uri.encode(a6)));
            a.C0019a.a(aVar2, intent2);
            this.e.startActivity(intent2);
            return false;
        } else {
            this.g.post(new a(this, 4001, "支付宝未安装或签名错误", null, null));
            return true;
        }
    }

    private String a(BizType bizType, Map<String, String> map) {
        if (bizType != null) {
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", bizType.appId);
            if (AnonymousClass1.f3172a[bizType.ordinal()] == 1) {
                appendQueryParameter.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES");
            }
            for (Map.Entry next : map.entrySet()) {
                appendQueryParameter.appendQueryParameter((String) next.getKey(), (String) next.getValue());
            }
            return appendQueryParameter.build().toString();
        }
        throw new RuntimeException("missing bizType");
    }

    /* renamed from: com.alipay.sdk.app.OpenAuthTask$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3172a = new int[BizType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f3172a[BizType.Deduct.ordinal()] = 1;
            f3172a[BizType.AccountAuth.ordinal()] = 2;
            try {
                f3172a[BizType.Invoice.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private String a(long j, String str, BizType bizType, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startTime", String.valueOf(j));
        jSONObject.put("session", str);
        jSONObject.put("package", this.e.getPackageName());
        if (bizType != null) {
            jSONObject.put("appId", bizType.appId);
        }
        jSONObject.put("sdkVersion", "h.a.3.8.00");
        jSONObject.put("mqpURL", str2);
        return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
    }

    static void a(String str, int i, String str2, Bundle bundle) {
        Callback remove = f3171a.remove(str);
        if (remove != null) {
            try {
                remove.onResult(i, str2, bundle);
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final int f3173a;
        final String b;
        final Bundle c;

        /* synthetic */ a(OpenAuthTask openAuthTask, int i, String str, Bundle bundle, AnonymousClass1 r5) {
            this(i, str, bundle);
        }

        private a(int i, String str, Bundle bundle) {
            this.f3173a = i;
            this.b = str;
            this.c = bundle;
        }

        public final void run() {
            if (OpenAuthTask.this.f != null) {
                OpenAuthTask.this.f.onResult(this.f3173a, this.b, this.c);
            }
        }
    }
}
