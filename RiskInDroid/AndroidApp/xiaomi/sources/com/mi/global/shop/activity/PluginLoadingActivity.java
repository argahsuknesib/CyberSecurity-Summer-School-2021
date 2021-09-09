package com.mi.global.shop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.xiaomi.smarthome.R;

public class PluginLoadingActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) R.layout.shop_activity_plugin_loading_layout);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.alpha = 0.5f;
        window.setAttributes(attributes);
        new Handler().postDelayed(new Runnable() {
            /* class com.mi.global.shop.activity.PluginLoadingActivity.AnonymousClass1 */

            public final void run() {
                PluginLoadingActivity.this.loadTargetActivity();
            }
        }, 1000);
    }

    public void loadTargetActivity() {
        if (getIntent() == null || !getIntent().hasExtra("acName")) {
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("acName");
        Intent intent = new Intent();
        intent.setClassName(this, stringExtra);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        finish();
    }
}
