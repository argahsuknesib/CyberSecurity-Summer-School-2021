package com.xiaomi.smarthome.activity;

import _m_j.gsy;
import _m_j.hca;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.framework.page.CommonActivity;

public class SystemUIJumperActivity extends CommonActivity {
    @TargetApi(26)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
        if (!keyguardManager.isKeyguardLocked()) {
            String stringExtra = getIntent().getStringExtra("controlId");
            if (!TextUtils.isEmpty(stringExtra)) {
                hca.O000000o(stringExtra);
            }
            finish();
        }
        keyguardManager.requestDismissKeyguard(this, new KeyguardManager.KeyguardDismissCallback() {
            /* class com.xiaomi.smarthome.activity.SystemUIJumperActivity.AnonymousClass1 */

            public final void onDismissError() {
                super.onDismissError();
                if (!SystemUIJumperActivity.this.isFinishing()) {
                    gsy.O00000Oo("SystemUIJumperActivity", "onDismissError");
                    SystemUIJumperActivity.this.finish();
                }
            }

            public final void onDismissSucceeded() {
                super.onDismissSucceeded();
                if (!SystemUIJumperActivity.this.isFinishing()) {
                    gsy.O00000Oo("SystemUIJumperActivity", "onDismissSucceeded");
                    String stringExtra = SystemUIJumperActivity.this.getIntent().getStringExtra("controlId");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        hca.O000000o(stringExtra);
                    }
                    SystemUIJumperActivity.this.finish();
                }
            }

            public final void onDismissCancelled() {
                super.onDismissCancelled();
                if (!SystemUIJumperActivity.this.isFinishing()) {
                    gsy.O00000Oo("SystemUIJumperActivity", "onDismissCancelled");
                    SystemUIJumperActivity.this.finish();
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        gsy.O00000Oo("SystemUIJumperActivity", "onDestroy");
    }
}
