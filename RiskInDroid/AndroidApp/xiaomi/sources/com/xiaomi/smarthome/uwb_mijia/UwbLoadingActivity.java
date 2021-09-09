package com.xiaomi.smarthome.uwb_mijia;

import _m_j.hzn;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import com.smarthome.uwb.ui.auth.CloseAuthActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.UwbDevice;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;
import org.json.JSONObject;

public class UwbLoadingActivity extends UwbBaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f11911O000000o = "com.xiaomi.smarthome.uwb_mijia.UwbLoadingActivity";
    UwbScanDevice O00000Oo;
    UwbConEngine.IEngineStateCallback O00000o = new UwbConEngine.IEngineStateCallback() {
        /* class com.xiaomi.smarthome.uwb_mijia.UwbLoadingActivity.AnonymousClass1 */

        public final void onSwitchCommunication(int i, String str) {
        }

        public final void onConnEstablished() {
            UwbLogUtil.w(UwbLoadingActivity.f11911O000000o, "UwbLogUtilPlus IEngineStateCallback onConnEstablished");
            hzn.O000000o(new UwbDevice(UwbLoadingActivity.this.O00000Oo, null));
            UwbLoadingActivity uwbLoadingActivity = UwbLoadingActivity.this;
            uwbLoadingActivity.O00000o0 = false;
            uwbLoadingActivity.finish();
        }

        public final void onRetryKeyRetrieve() {
            UwbLogUtil.w(UwbLoadingActivity.f11911O000000o, "UwbLogUtilPlus IEngineStateCallback onRetryKeyRetrieve");
            CloseAuthActivity.startCardActivity(UwbSdk.getApplication(), UwbLoadingActivity.this.O00000Oo);
            UwbLoadingActivity uwbLoadingActivity = UwbLoadingActivity.this;
            uwbLoadingActivity.O00000o0 = false;
            uwbLoadingActivity.finish();
        }

        public final void onConnectionError(int i, String str) {
            UwbLogUtil.w(UwbLoadingActivity.f11911O000000o, "UwbLogUtilPlus IEngineStateCallback onConnectionError: ".concat(String.valueOf(i)));
        }

        public final void onEstablishSecurityError(int i, String str) {
            UwbLogUtil.w(UwbLoadingActivity.f11911O000000o, "UwbLogUtilPlus IEngineStateCallback onEstablishSecurityError: ".concat(String.valueOf(i)));
        }
    };
    boolean O00000o0 = true;

    public static void startCardActivity(Context context, UwbScanDevice uwbScanDevice) {
        Intent intent = new Intent();
        intent.setClass(context, UwbLoadingActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("UWB_SCAN_DEVICE", uwbScanDevice.toJSON().toString());
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(17170444));
        try {
            this.O00000Oo = UwbScanDevice.parse(new JSONObject(getIntent().getStringExtra("UWB_SCAN_DEVICE")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = f11911O000000o;
        UwbLogUtil.w(str, "UwbLogUtilPlus loadding activity mUwbScanDevice: " + this.O00000Oo);
        if (this.O00000Oo == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.mj_card_loading_dialog);
        ((ProgressBar) findViewById(R.id.progress)).startAnimation(AnimationUtils.loadAnimation(this, R.anim.uwb_mj_rotate_loading));
        UwbApi.getInstance().isEngineReady(this.O00000o);
    }

    public void onDestroy() {
        super.onDestroy();
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        if (progressBar != null) {
            progressBar.clearAnimation();
        }
    }

    public boolean needExitUwb() {
        return this.O00000o0;
    }
}
