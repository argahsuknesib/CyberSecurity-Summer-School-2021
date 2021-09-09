package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.content.Intent;
import com.sina.weibo.sdk.auth.BaseSsoHandler;

public class SsoHandler extends BaseSsoHandler {
    public SsoHandler(Activity activity) {
        super(activity);
    }

    public void fillExtraIntent(Intent intent, int i) {
        super.fillExtraIntent(intent, i);
        if (i == 32974) {
            intent.putExtra("com.sina.weibo.intent.extra.REQUEST_CODE", i);
        }
    }

    public void resetIntentFillData() {
        super.resetIntentFillData();
    }
}
