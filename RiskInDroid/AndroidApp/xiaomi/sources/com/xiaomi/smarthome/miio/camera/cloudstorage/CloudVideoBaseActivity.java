package com.xiaomi.smarthome.miio.camera.cloudstorage;

import android.os.Bundle;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.BaseOrientationSupportActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public class CloudVideoBaseActivity extends BaseOrientationSupportActivity {
    private XQProgressDialog loadingDialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void showLoading() {
        if (this.loadingDialog == null) {
            this.loadingDialog = new XQProgressDialog(this);
            this.loadingDialog.setMessage(getString(R.string.device_more_security_loading_operation));
        }
        this.loadingDialog.show();
    }

    /* access modifiers changed from: protected */
    public void hideLoading() {
        XQProgressDialog xQProgressDialog = this.loadingDialog;
        if (xQProgressDialog != null) {
            xQProgressDialog.hide();
        }
    }
}
