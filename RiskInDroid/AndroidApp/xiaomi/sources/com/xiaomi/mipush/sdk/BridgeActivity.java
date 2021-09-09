package com.xiaomi.mipush.sdk;

import _m_j.duv;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class BridgeActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = 1;
        attributes.width = 1;
        attributes.gravity = 51;
        window.setAttributes(attributes);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Intent intent;
        super.onResume();
        try {
            Intent intent2 = getIntent();
            if (!(intent2 == null || (intent = (Intent) intent2.getParcelableExtra("mipush_serviceIntent")) == null)) {
                PushMessageHandler.a(getApplicationContext(), intent);
            }
        } catch (Exception e) {
            duv.O000000o(e);
        } finally {
            finish();
        }
    }
}
