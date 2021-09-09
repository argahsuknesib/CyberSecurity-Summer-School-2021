package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import java.util.concurrent.ConcurrentHashMap;

public class APayEntranceActivity extends Activity {
    public static final ConcurrentHashMap<String, a> e = new ConcurrentHashMap<>();
    private String f;
    private String g;

    public interface a {
        void a(String str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            String string = extras.getString("ap_order_info");
            String string2 = extras.getString("ap_target_packagename");
            this.g = extras.getString("ap_session");
            String string3 = extras.getString("ap_local_info", "{}");
            Intent intent = new Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (Throwable unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    public void finish() {
        a remove = e.remove(this.g);
        if (remove != null) {
            remove.a(this.f);
        }
        try {
            super.finish();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            this.f = intent.getStringExtra("result");
            finish();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
