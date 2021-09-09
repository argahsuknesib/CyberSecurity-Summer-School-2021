package com.sina.weibo.sdk.share;

import _m_j.dbt;
import android.content.Intent;
import android.os.Bundle;

public class WbShareResultActivity extends BaseActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        dbt.O00000Oo("Share", "startShareResultActivity");
        try {
            Intent intent = getIntent();
            if (intent.getIntExtra("startFlag", -1) == 0) {
                finish();
                return;
            }
            if ("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY".equals(intent.getAction())) {
                intent.setClass(this, WbShareTransActivity.class);
            } else {
                intent.setClass(this, WbShareToStoryActivity.class);
            }
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
