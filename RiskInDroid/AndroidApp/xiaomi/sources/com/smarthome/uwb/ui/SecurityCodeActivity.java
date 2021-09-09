package com.smarthome.uwb.ui;

import _m_j.hzx;
import _m_j.hzy;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityCallback;
import com.xiaomi.smarthome.uwb.lib.securityCode.SecurityCodeActivityImpl;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.tv.MitvCardActivity;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;

public class SecurityCodeActivity extends UwbBaseActivity implements SecurityCodeActivityCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    SecurityCodeActivityImpl f5660O000000o;

    public static void startSecurityCodeActivity(UwbScanDevice uwbScanDevice) {
        SecurityCodeActivityImpl.startSecurityCodeActivity(uwbScanDevice, SecurityCodeActivity.class);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(17170444));
        this.f5660O000000o = new SecurityCodeActivityImpl();
        this.f5660O000000o.onCreate(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f5660O000000o.onDestroy();
    }

    public boolean needExitUwb() {
        return this.f5660O000000o.needExitUwb();
    }

    public void onAuthSuccess(UwbScanDevice uwbScanDevice, String str, String str2, String str3) {
        UwbDeviceUtil.saveUwbDeviceKey(str, hzx.O000000o(str2));
        hzy O000000o2 = hzy.O000000o();
        if (uwbScanDevice == null || TextUtils.equals(uwbScanDevice.getUwbAddress(), O000000o2.f1047O000000o.getUwbAddress())) {
            O000000o2.O00000Oo.onSuccess(str, 1, str3);
        }
    }

    public void onConnEstablished(UwbScanDevice uwbScanDevice) {
        MitvCardActivity.startCardActivity(UwbSdk.getApplication(), uwbScanDevice);
    }
}
