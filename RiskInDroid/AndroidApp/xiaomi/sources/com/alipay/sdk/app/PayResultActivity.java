package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public final class PayResultActivity extends Activity {
    public static final HashMap<String, Object> b = new HashMap<>();
    private com.alipay.sdk.sys.a i = null;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static volatile String f3175a;
        public static volatile String b;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra("orderSuffix"))) {
                a.f3175a = intent.getStringExtra("phonecashier.pay.hash");
                String stringExtra = intent.getStringExtra("orderSuffix");
                String stringExtra2 = intent.getStringExtra("externalPkgName");
                this.i = a.C0019a.a(intent);
                if (this.i == null) {
                    finish();
                }
                a(this, a.f3175a, stringExtra, stringExtra2);
                a(this, 300);
                return;
            }
            if (this.i == null) {
                finish();
            }
            String stringExtra3 = intent.getStringExtra("phonecashier.pay.result");
            int intExtra = intent.getIntExtra("phonecashier.pay.resultOrderHash", 0);
            if (intExtra != 0) {
                if (TextUtils.equals(a.f3175a, String.valueOf(intExtra))) {
                    if (!TextUtils.isEmpty(stringExtra3)) {
                        a(stringExtra3, a.f3175a);
                    } else {
                        a(a.f3175a);
                    }
                    a.f3175a = "";
                    a(this, 300);
                    return;
                }
            }
            com.alipay.sdk.sys.a aVar = this.i;
            com.alipay.sdk.app.statistic.a.a(aVar, "biz", "SchemePayWrongHashEx", "Expected " + a.f3175a + ", got " + intExtra);
            a(a.f3175a);
            a(this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }

    private static void a(Activity activity, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Intent intent = new Intent();
            try {
                intent.setPackage("hk.alipay.wallet");
                intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, "UTF-8") + "&orderSuffix=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(str3, "UTF-8") + "&externalPkgName=" + URLEncoder.encode(str3, "UTF-8")));
            } catch (UnsupportedEncodingException e) {
                c.a(e);
            }
            if (activity != null) {
                try {
                    activity.startActivity(intent);
                } catch (Throwable unused) {
                    activity.finish();
                }
            }
        }
    }

    private static void a(String str) {
        a.b = b.c();
        a(b, str);
    }

    private static void a(String str, String str2) {
        a.b = str;
        a(b, str2);
    }

    private static void a(final Activity activity, int i2) {
        new Handler().postDelayed(new Runnable() {
            /* class com.alipay.sdk.app.PayResultActivity.AnonymousClass1 */

            public final void run() {
                activity.finish();
            }
        }, (long) i2);
    }

    private static boolean a(HashMap<String, Object> hashMap, String str) {
        Object obj;
        if (hashMap == null || str == null || (obj = hashMap.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }
}
