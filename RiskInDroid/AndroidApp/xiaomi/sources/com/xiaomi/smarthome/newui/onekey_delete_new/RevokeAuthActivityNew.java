package com.xiaomi.smarthome.newui.onekey_delete_new;

import _m_j.gty;
import _m_j.hgl;
import _m_j.hgm;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.operation.js_sdk.base.BaseFragmentWebViewActivity;

public class RevokeAuthActivityNew extends BaseFragmentWebViewActivity implements hgm {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f10257O000000o = false;

    public int getFragmentContainerId() {
        return R.id.container;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_operation_common_web_view);
        String stringExtra = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(stringExtra)) {
            openNewWindow(null, hgl.O000000o(stringExtra, ""));
        } else {
            finish();
        }
    }

    public void onBackPressed() {
        finish();
    }

    public void unRegisterSuccess() {
        this.f10257O000000o = true;
        gty.O000000o().logout(null, "RevokeAuthActivityNew");
    }

    public void endUnRegister() {
        finish();
    }

    public void finish() {
        if (this.f10257O000000o) {
            setResult(-1, new Intent());
        }
        super.finish();
    }
}
