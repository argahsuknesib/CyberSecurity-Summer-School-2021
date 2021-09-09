package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.l;
import com.alipay.sdk.widget.c;
import com.alipay.sdk.widget.d;

public class H5PayActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private c f3170a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;
    private String g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            a a2 = a.C0019a.a(getIntent());
            if (a2 == null) {
                finish();
                return;
            }
            if (!com.alipay.sdk.data.a.s().b()) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(3);
            }
            try {
                Bundle extras = getIntent().getExtras();
                this.b = extras.getString("url", null);
                if (!l.d(this.b)) {
                    finish();
                    return;
                }
                this.d = extras.getString("cookie", null);
                this.c = extras.getString("method", null);
                this.e = extras.getString("title", null);
                this.g = extras.getString("version", "v1");
                this.f = extras.getBoolean("backisexit", false);
                try {
                    d dVar = new d(this, a2, this.g);
                    setContentView(dVar);
                    dVar.a(this.e, this.c, this.f);
                    dVar.a(this.b, this.d);
                    dVar.a(this.b);
                    this.f3170a = dVar;
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a(a2, "biz", "GetInstalledAppEx", th);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    private void b() {
        try {
            super.requestWindowFeature(1);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public void onBackPressed() {
        c cVar = this.f3170a;
        if (cVar == null) {
            finish();
        } else if (cVar.c()) {
            cVar.b();
        } else {
            if (!cVar.b()) {
                super.onBackPressed();
            }
            b.a(b.c());
            finish();
        }
    }

    public void finish() {
        a();
        super.finish();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    public void a() {
        Object obj = PayTask.f3176a;
        synchronized (obj) {
            obj.notify();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f3170a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void setRequestedOrientation(int i) {
        try {
            super.setRequestedOrientation(i);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010) {
            d.a(a.C0019a.a(getIntent()), i, i2, intent);
        }
    }
}
