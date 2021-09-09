package com.smarthome.uwb.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;

public class UwbTranslucentTempActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            /* class com.smarthome.uwb.ui.$$Lambda$UwbTranslucentTempActivity$OjLNdASuASoGjeYBm_S8BfmlU */

            public final void run() {
                UwbTranslucentTempActivity.this.O000000o();
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() {
        if (isValid()) {
            finish();
        }
    }

    public static void start() {
        Intent intent = new Intent(UwbSdk.getApplication(), UwbTranslucentTempActivity.class);
        intent.addFlags(268435456);
        UwbSdk.getApplication().startActivity(intent);
    }
}
