package com.xiaomi.mipush.sdk.help;

import _m_j.ebh;
import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;

public class HelpService extends IntentService {
    public HelpService() {
        super("intentService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (!TextUtils.isEmpty(intent.getStringExtra("awake_info"))) {
            ebh.O000000o(this, intent, null);
        }
    }
}
