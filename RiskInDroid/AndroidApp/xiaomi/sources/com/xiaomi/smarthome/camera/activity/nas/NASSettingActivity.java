package com.xiaomi.smarthome.camera.activity.nas;

import _m_j.civ;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.mijia.camera.nas.NASInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public class NASSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    public NASInfo mNASInfo;
    private SettingsItemView mSivChangeSetting;
    private SettingsItemView mSivChangeStorageDir;
    public XQProgressDialog mXQProgressDialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_activity_device_nas_setting);
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
        initProgressDialog();
        initViews();
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.mSivChangeSetting = (SettingsItemView) findViewById(R.id.sivChangeSetting);
        this.mSivChangeStorageDir = (SettingsItemView) findViewById(R.id.sivChangeStorageDir);
        this.mSivChangeSetting.setOnClickListener(this);
        this.mSivChangeStorageDir.setOnClickListener(this);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        refreshViews();
    }

    /* access modifiers changed from: protected */
    public void refreshViews() {
        NASInfo nASInfo = this.mNASInfo;
        if (nASInfo != null && nASInfo.O00000oo != null) {
            this.mSivChangeSetting.setInfo(this.mNASInfo.O00000oo.f5188O000000o);
            this.mSivChangeStorageDir.setInfo(this.mNASInfo.O00000oo.O000000o());
        }
    }

    public void onResume() {
        super.onResume();
        loadNASServerInfo();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.sivChangeSetting) {
            Intent intent = new Intent(this, NASEditActivity.class);
            intent.putExtra("data", this.mNASInfo);
            startActivity(intent);
        } else if (id == R.id.sivChangeStorageDir) {
            Intent intent2 = new Intent(this, NASDirListActivity.class);
            intent2.putExtra("data", this.mNASInfo);
            startActivity(intent2);
        }
    }

    private void loadNASServerInfo() {
        this.mXQProgressDialog.show();
        this.mCameraDevice.O0000oO0().O000000o(new Callback<NASInfo>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASSettingActivity.AnonymousClass1 */

            public void onSuccess(NASInfo nASInfo) {
                if (!NASSettingActivity.this.isFinishing()) {
                    NASSettingActivity nASSettingActivity = NASSettingActivity.this;
                    nASSettingActivity.mNASInfo = nASSettingActivity.mCameraDevice.O0000oO0().O00000o;
                    if (NASSettingActivity.this.mXQProgressDialog.isShowing()) {
                        NASSettingActivity.this.mXQProgressDialog.dismiss();
                    }
                    NASSettingActivity.this.refreshViews();
                    if (nASInfo.O00000o == 0) {
                        NASSettingActivity nASSettingActivity2 = NASSettingActivity.this;
                        nASSettingActivity2.startActivity(new Intent(nASSettingActivity2, NASDiscoveryActivity.class));
                        NASSettingActivity.this.finish();
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!NASSettingActivity.this.isFinishing()) {
                    civ.O00000o0("CameraPlay", " loadNAS fail " + i + " : " + str);
                    if (NASSettingActivity.this.mXQProgressDialog.isShowing()) {
                        NASSettingActivity.this.mXQProgressDialog.dismiss();
                    }
                }
            }
        });
    }

    private void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
    }
}
