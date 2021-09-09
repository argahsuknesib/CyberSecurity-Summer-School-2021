package com.xiaomi.smarthome.shop.activity;

import _m_j.gsy;
import android.os.Bundle;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;

public abstract class DeviceShopBaseActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f11386O000000o = "DeviceShopBaseActivity";

    public void onRefreshPage() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        gsy.O000000o(LogType.GENERAL, f11386O000000o, "onCreate");
    }

    public void onStart() {
        super.onStart();
        gsy.O000000o(LogType.GENERAL, f11386O000000o, "onStart");
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onPressBackButton() {
        super.onBackPressed();
    }
}
