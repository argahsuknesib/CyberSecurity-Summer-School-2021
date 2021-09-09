package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.sys.a;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class AlipayResultActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f3166a = new ConcurrentHashMap<>();

    public interface a {
        void a(int i, String str, String str2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b8 A[ADDED_TO_REGION] */
    public void onCreate(Bundle bundle) {
        com.alipay.sdk.sys.a a2;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            try {
                String stringExtra = intent.getStringExtra("session");
                Bundle bundleExtra = intent.getBundleExtra("result");
                String stringExtra2 = intent.getStringExtra("scene");
                a2 = a.C0019a.a(stringExtra);
                if (a2 == null) {
                    finish();
                    return;
                }
                com.alipay.sdk.app.statistic.a.b(a2, "biz", "BSPSession", stringExtra + "|" + SystemClock.elapsedRealtime());
                if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    a(stringExtra, bundleExtra);
                    return;
                }
                if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                        stringExtra = jSONObject.getString("session");
                        com.alipay.sdk.app.statistic.a.b(a2, "biz", "BSPUriSession", stringExtra);
                        Bundle bundle2 = new Bundle();
                        try {
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                bundle2.putString(next, jSONObject2.getString(next));
                            }
                            bundleExtra = bundle2;
                        } catch (Throwable th) {
                            th = th;
                            bundleExtra = bundle2;
                            com.alipay.sdk.app.statistic.a.a(a2, "biz", "BSPResEx", th);
                            com.alipay.sdk.app.statistic.a.a(a2, "biz", "ParseSchemeQueryError", th);
                            if (!TextUtils.isEmpty(stringExtra)) {
                            }
                            com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.q);
                            finish();
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.alipay.sdk.app.statistic.a.a(a2, "biz", "BSPResEx", th);
                        com.alipay.sdk.app.statistic.a.a(a2, "biz", "ParseSchemeQueryError", th);
                        if (!TextUtils.isEmpty(stringExtra)) {
                        }
                        com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.q);
                        finish();
                        return;
                    }
                }
                if (!TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                    com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.q);
                    finish();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(SystemClock.elapsedRealtime());
                com.alipay.sdk.app.statistic.a.b(a2, "biz", "PgReturn", sb.toString());
                com.alipay.sdk.app.statistic.a.b(a2, "biz", "PgReturnV", bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString("memo", "-"));
                OpenAuthTask.a(stringExtra, 9000, "OK", bundleExtra);
                com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.q);
                finish();
            } catch (Throwable th3) {
                com.alipay.sdk.app.statistic.a.a((com.alipay.sdk.sys.a) null, "biz", "BSPSerError", th3);
                com.alipay.sdk.app.statistic.a.a((com.alipay.sdk.sys.a) null, "biz", "ParseBundleSerializableError", th3);
                finish();
            }
        } catch (Throwable unused) {
            finish();
        }
    }

    private void a(String str, Bundle bundle) {
        a remove = f3166a.remove(str);
        if (remove == null) {
            finish();
            return;
        }
        try {
            remove.a(bundle.getInt("endCode"), bundle.getString("memo"), bundle.getString("result"));
        } finally {
            finish();
        }
    }
}
