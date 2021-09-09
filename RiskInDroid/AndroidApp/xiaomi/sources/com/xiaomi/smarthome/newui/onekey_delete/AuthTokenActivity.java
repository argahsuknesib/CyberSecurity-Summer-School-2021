package com.xiaomi.smarthome.newui.onekey_delete;

import _m_j.gsy;
import _m_j.hgi;
import _m_j.hgj;
import _m_j.hte;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.operation.js_sdk.base.BaseFragmentWebViewActivity;

public class AuthTokenActivity extends BaseFragmentWebViewActivity implements hgi {
    public int getFragmentContainerId() {
        return R.id.container;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_operation_common_web_view);
        String stringExtra = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(stringExtra)) {
            openNewWindow(null, hgj.O000000o(stringExtra, ""));
        } else {
            finish();
        }
    }

    public void onAuthSuccess(String str) {
        gsy.O00000Oo("AuthTokenActivity", "onAuthSuccess: ");
        Intent intent = new Intent();
        intent.putExtra("arg_auth_token", str);
        setResult(-1, intent);
        finish();
    }

    public void onAuthFailed(String str) {
        hte.O000000o(this, "auth failed: ".concat(String.valueOf(str)));
    }
}
