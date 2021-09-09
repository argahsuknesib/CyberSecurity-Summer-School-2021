package com.xiaomi.smarthome.uwb.ui;

import _m_j.dcp;
import android.os.Bundle;
import android.view.View;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.uwb.lib.ui.UwbBaseCallback;
import com.xiaomi.smarthome.uwb.lib.ui.UwbBaseHelper;

public class UwbBaseActivity extends BaseActivity implements UwbBaseCallback {
    private static final String TAG = "com.xiaomi.smarthome.uwb.ui.UwbBaseActivity";
    private final UwbBaseHelper uwbBaseHelper = new UwbBaseHelper();

    public boolean isPlugin() {
        return false;
    }

    public boolean needExitUwb() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        getWindow().addFlags(524288);
        setRequestedOrientation(1);
        super.onCreate(bundle);
        this.uwbBaseHelper.onCreate(this, this);
        dcp.O000000o().O00000Oo(true);
    }

    public void onDestroy() {
        super.onDestroy();
        this.uwbBaseHelper.onDestroy(this);
        dcp.O000000o().O00000Oo(false);
    }

    /* access modifiers changed from: protected */
    public void startShowAni(View view, View view2) {
        this.uwbBaseHelper.startShowAni(getWindow().getDecorView().getRootView(), view, view2);
    }
}
