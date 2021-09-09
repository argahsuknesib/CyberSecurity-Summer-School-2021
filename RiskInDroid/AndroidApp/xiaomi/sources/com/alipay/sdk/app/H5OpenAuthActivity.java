package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.sys.a;

public class H5OpenAuthActivity extends H5PayActivity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3169a = false;

    public void a() {
    }

    public void startActivity(Intent intent) {
        try {
            a a2 = a.C0019a.a(intent);
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data != null && data.toString().startsWith("alipays://platformapi/startapp")) {
                    finish();
                }
            } catch (Throwable th) {
                String uri = (intent == null || intent.getData() == null) ? "null" : intent.getData().toString();
                if (a2 != null) {
                    com.alipay.sdk.app.statistic.a.a(a2, "biz", "StartActivityEx", th, uri);
                }
                this.f3169a = true;
                throw th;
            }
        } catch (Throwable unused) {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.f3169a) {
            try {
                a a2 = a.C0019a.a(getIntent());
                if (a2 != null) {
                    com.alipay.sdk.app.statistic.a.b(this, a2, "", a2.q);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }
}
