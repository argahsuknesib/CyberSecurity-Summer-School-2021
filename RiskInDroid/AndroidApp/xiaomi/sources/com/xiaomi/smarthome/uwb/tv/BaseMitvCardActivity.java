package com.xiaomi.smarthome.uwb.tv;

import _m_j.fno;
import _m_j.hmc;
import _m_j.hme;
import _m_j.hxi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.uwb.api.UwbMitvApi;
import com.xiaomi.smarthome.uwb.lib.mitv.MitvCardActivityImpl;
import com.xiaomi.smarthome.uwb.lib.mitv.MitvCardCallback;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;

public class BaseMitvCardActivity extends UwbBaseActivity implements MitvCardCallback {
    MitvCardActivityImpl mMitvCardActivityImpl;
    View.OnClickListener mStatClicklistener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.uwb.tv.BaseMitvCardActivity.AnonymousClass1 */

        public void onClick(View view) {
            if (view != null) {
                if (view.getId() == R.id.volume_reduce) {
                    hxi.O00000o.O00oOooo(1);
                } else if (view.getId() == R.id.volume_add) {
                    hxi.O00000o.O00oOooo(0);
                } else if (R.id.hdmi_iv == view.getId()) {
                    hxi.O00000o.O0000ooo();
                } else if (R.id.home_iv == view.getId()) {
                    hxi.O00000o.O0000oOo();
                } else if (R.id.back_iv == view.getId()) {
                    hxi.O00000o.O0000oOO();
                } else if (R.id.menu_iv == view.getId()) {
                    hxi.O00000o.O0000oO();
                } else if (R.id.miracast_iv == view.getId()) {
                    hxi.O00000o.O0000ooO();
                } else if (R.id.ok_btn == view.getId()) {
                    hxi.O00000o.O0000oo0();
                } else if (R.id.left_btn == view.getId()) {
                    hxi.O00000o.O000O00o(2);
                } else if (R.id.right_btn == view.getId()) {
                    hxi.O00000o.O000O00o(3);
                } else if (R.id.up_btn == view.getId()) {
                    hxi.O00000o.O000O00o(0);
                } else if (R.id.down_btn == view.getId()) {
                    hxi.O00000o.O000O00o(1);
                } else if (R.id.ai_iv == view.getId()) {
                    hxi.O00000o.O0000oo();
                } else if (R.id.power_iv == view.getId()) {
                    hxi.O00000o.O000O0OO(0);
                } else if (R.id.screen_on_iv == view.getId()) {
                    hxi.O00000o.O000O0OO(1);
                }
            }
        }
    };

    public void initUI() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(17170444));
        this.mMitvCardActivityImpl = new MitvCardActivityImpl();
        this.mMitvCardActivityImpl.onCreate(this, this, false);
        this.mMitvCardActivityImpl.setmStatOnClickListener(this.mStatClicklistener);
    }

    public void onStart() {
        super.onStart();
        this.mMitvCardActivityImpl.onStart();
    }

    public void onStop() {
        super.onStop();
        this.mMitvCardActivityImpl.onStop();
    }

    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mMitvCardActivityImpl.onWindowFocusChanged(z);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.mMitvCardActivityImpl.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onDestroy() {
        super.onDestroy();
        UwbLogUtil.w("BaseMitvCardActivity", "UwbLogUtilPlus MitvCardActivity ondestroy");
        this.mMitvCardActivityImpl.onDestroy();
    }

    public void saveMitvBleMac(String str) {
        UwbDeviceUtil.saveMitvBleMac(str);
    }

    public void setContentView() {
        setContentView((int) R.layout.activity_mitv_card);
    }

    public void onLoginClick() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.CAMERA") != 0) {
            ActivityCompat.requestPermissions((Activity) getContext(), new String[]{"android.permission.CAMERA"}, 2);
            return;
        }
        hxi.O00000o.O0000o();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.xiaomi.smarthome", "com.xiaomi.qrcode.ScanBarcodeActivity"));
        intent.putExtra("from", 600);
        startActivity(intent);
        UwbMitvApi.doLogin();
        finish();
    }

    public void refreshUI() {
        if (!UwbDeviceUtil.isMitvLogin(this.mMitvCardActivityImpl.getmUwbScanDevice())) {
            return;
        }
        if (Util.canGotoMitvPlugin(this.mMitvCardActivityImpl.getmMitvInfo())) {
            this.mMitvCardActivityImpl.getmMitvCardView().showMoreView(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.uwb.tv.BaseMitvCardActivity.AnonymousClass2 */

                public void onClick(View view) {
                    DeviceStat O0000o00 = fno.O000000o().O0000o00(BaseMitvCardActivity.this.mMitvCardActivityImpl.getmMitvInfo().getPartnerId());
                    hme.O000000o(BaseMitvCardActivity.this, O0000o00.model, BaseMitvCardActivity.this.getIntent(), O0000o00, new hmc() {
                        /* class com.xiaomi.smarthome.uwb.tv.BaseMitvCardActivity.AnonymousClass2.AnonymousClass1 */

                        public void onLoadingFinish(boolean z) {
                        }

                        public void onLoadingStart() {
                        }
                    });
                    hxi.O00000o.O0000oO0();
                    BaseMitvCardActivity.this.finish();
                }
            });
        } else {
            this.mMitvCardActivityImpl.getmMitvCardView().hideMoreView();
        }
    }

    public void startShowAni() {
        startShowAni(findViewById(R.id.top_layout), findViewById(R.id.tvcard_v));
    }
}
