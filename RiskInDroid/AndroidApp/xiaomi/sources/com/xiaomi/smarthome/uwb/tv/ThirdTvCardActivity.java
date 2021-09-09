package com.xiaomi.smarthome.uwb.tv;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.utils.UIUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;
import org.json.JSONObject;

public class ThirdTvCardActivity extends UwbBaseActivity {
    MLAlertDialog dialog;
    UwbConEngine.IEngineStateCallback mEngineStateCallback = new UwbConEngine.IEngineStateCallback() {
        /* class com.xiaomi.smarthome.uwb.tv.ThirdTvCardActivity.AnonymousClass1 */

        public void onConnectionError(int i, String str) {
        }

        public void onEstablishSecurityError(int i, String str) {
        }

        public void onRetryKeyRetrieve() {
        }

        public void onSwitchCommunication(int i, String str) {
        }

        public void onConnEstablished() {
            UwbLogUtil.d("UWBPERFORMANCE", "UWBPERFORMANCE-9-mijia-card-ready:" + System.currentTimeMillis());
        }
    };
    boolean mHasLog = false;
    View mTvCardView;
    UwbScanDevice mUwbScanDevice;

    public static void startCardActivity(Context context, UwbScanDevice uwbScanDevice) {
        Intent intent = new Intent();
        intent.setClass(context, ThirdTvCardActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("UWB_SCAN_DEVICE", uwbScanDevice.toJSON().toString());
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(17170444));
        try {
            this.mUwbScanDevice = UwbScanDevice.parse(new JSONObject(getIntent().getStringExtra("UWB_SCAN_DEVICE")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        UwbLogUtil.d("Mijia-UWB-ThirdTvCardActivity", "UwbLogUtilPlus mUwbScanDevice: " + this.mUwbScanDevice);
        if (this.mUwbScanDevice == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_third_tv_card);
        UIUtils.initBottomMargin(this, findViewById(R.id.tvcard_v));
        startShowAni(null, findViewById(R.id.tvcard_v));
        if (!checkIfValidTag()) {
            showTagNotValidDialog();
        } else {
            UwbApi.getInstance().isEngineReady(this.mEngineStateCallback);
        }
    }

    private boolean checkIfValidTag() {
        if (this.mUwbScanDevice.getPid() == 5662) {
            return true;
        }
        UwbLogUtil.d("Mijia-UWB-ThirdTvCardActivity", "checkIfValidTag false:" + this.mUwbScanDevice.getPid());
        return false;
    }

    private void showTagNotValidDialog() {
        UwbLogUtil.d("Mijia-UWB-ThirdTvCardActivity", "showTagNotValidDialog");
        this.dialog = new MLAlertDialog.Builder(this).O000000o(getResources().getString(R.string.mj_uwb_uwb_third_tv_tag_not_valid_title)).O00000Oo(getResources().getString(R.string.mj_uwb_uwb_third_tv_tag_not_valid)).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.uwb.tv.ThirdTvCardActivity.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                ThirdTvCardActivity.this.finish();
            }
        }).O00000Oo((int) R.string.mj_uwb_see_help, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.uwb.tv.ThirdTvCardActivity.AnonymousClass2 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).O000000o(false).O00000o();
        this.dialog.show();
    }

    public void onDestroy() {
        super.onDestroy();
        UwbLogUtil.d("Mijia-UWB-ThirdTvCardActivity", "onDestroy");
        MLAlertDialog mLAlertDialog = this.dialog;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        UwbLogUtil.d("Mijia-UWB-ThirdTvCardActivity", "onPause");
    }

    public void onResume() {
        super.onResume();
        UwbLogUtil.d("Mijia-UWB-ThirdTvCardActivity", "onResume");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.mHasLog) {
            this.mHasLog = true;
            UwbLogUtil.d("UWBPERFORMANCE", "UWBPERFORMANCE-9-mijia-card-complete:" + System.currentTimeMillis());
        }
    }
}
