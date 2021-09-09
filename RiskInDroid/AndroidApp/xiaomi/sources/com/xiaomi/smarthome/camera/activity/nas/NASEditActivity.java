package com.xiaomi.smarthome.camera.activity.nas;

import _m_j.gqg;
import _m_j.izb;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.mijia.camera.nas.NASInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public class NASEditActivity extends CameraBaseActivity {
    private NASInfo mNASInfo;
    private EditText mNASName;
    private EditText mNASPassword;
    private EditText mNASUserName;
    public XQProgressDialog mXQProgressDialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_activity_device_smb_edit);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.mNASInfo = (NASInfo) intent.getParcelableExtra("data");
        if (this.mNASInfo == null) {
            finish();
            return;
        }
        initViews();
        initProgressDialog();
    }

    private void initViews() {
        findViewById(R.id.title_bar_more).setVisibility(8);
        ((TextView) findViewById(R.id.title_bar_title)).setText(this.mNASInfo.O00000oo.f5188O000000o);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASEditActivity.AnonymousClass1 */

            public void onClick(View view) {
                NASEditActivity.this.finish();
            }
        });
        this.mNASName = (EditText) findViewById(R.id.smb_name_et);
        this.mNASName.setText(this.mNASInfo.O00000oo.f5188O000000o);
        this.mNASUserName = (EditText) findViewById(R.id.smb_username_et);
        this.mNASUserName.setText(this.mNASInfo.O00000oo.O00000oO);
        this.mNASPassword = (EditText) findViewById(R.id.smb_password_et);
        this.mNASPassword.setText(this.mNASInfo.O00000oo.O00000oo);
        findViewById(R.id.complete_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASEditActivity.AnonymousClass2 */

            public void onClick(View view) {
                NASEditActivity.this.onComplete();
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        XQProgressDialog xQProgressDialog = this.mXQProgressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mXQProgressDialog.dismiss();
        }
    }

    private void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
    }

    public void onComplete() {
        String obj = this.mNASName.getText().toString();
        String obj2 = this.mNASUserName.getText().toString();
        String obj3 = this.mNASPassword.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            izb.O000000o(this, (int) R.string.smb_warning_name_empty, 0).show();
            return;
        }
        this.mNASInfo.O00000oo.O00000oo = obj3;
        this.mNASInfo.O00000oo.O00000oO = obj2;
        NASInfo nASInfo = this.mNASInfo;
        if (!(nASInfo == null || nASInfo.O00000oo == null)) {
            this.mNASInfo.O00000oo.O00000o = this.mNASInfo.O00000oo.O00000o;
        }
        this.mNASInfo.O00000oo.f5188O000000o = obj;
        this.mXQProgressDialog.show();
        this.mCameraDevice.O0000oO0().O000000o(this.mNASInfo, new Callback<Object>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASEditActivity.AnonymousClass3 */

            public void onSuccess(Object obj) {
                if (!NASEditActivity.this.isFinishing()) {
                    NASEditActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.smb_tip_set_success);
                    NASEditActivity.this.setResult(-1);
                    NASEditActivity.this.finish();
                }
            }

            public void onFailure(int i, String str) {
                if (!NASEditActivity.this.isFinishing()) {
                    NASEditActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                }
            }
        });
    }
}
