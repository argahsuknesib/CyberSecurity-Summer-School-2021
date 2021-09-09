package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.gqg;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public class InfraredSettingActivity extends CameraBaseActivity implements SettingsItemView.OnSelectedListener {
    public int MSG_PROGRESS = 7001;
    private SettingsItemView mInfraredAuto;
    private SettingsItemView mInfraredClose;
    private SettingsItemView mInfraredOpen;
    public int mLastType = 0;
    private XQProgressDialog mXQProgressDialog;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_setting_infrared);
        findViewById(R.id.title_bar_more).setVisibility(8);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.setttings_infared);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.InfraredSettingActivity.AnonymousClass1 */

            public void onClick(View view) {
                InfraredSettingActivity.this.finish();
            }
        });
        initView();
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == this.MSG_PROGRESS) {
            showProgress();
        }
    }

    private void initView() {
        this.mInfraredAuto = (SettingsItemView) findViewById(R.id.infrared_auto);
        this.mInfraredClose = (SettingsItemView) findViewById(R.id.infrared_close);
        this.mInfraredOpen = (SettingsItemView) findViewById(R.id.infrared_open);
        this.mInfraredAuto.setOnSelectedListener(this);
        this.mInfraredClose.setOnSelectedListener(this);
        this.mInfraredOpen.setOnSelectedListener(this);
        this.mLastType = this.mCameraDevice.O000000o().O000000o("night_mode");
        initType(this.mLastType);
    }

    public void initType(int i) {
        this.mInfraredAuto.setSelect(false);
        this.mInfraredClose.setSelect(false);
        this.mInfraredOpen.setSelect(false);
        if (i == 0) {
            this.mInfraredAuto.setSelect(true);
        } else if (i == 1) {
            this.mInfraredClose.setSelect(true);
        } else if (i == 2) {
            this.mInfraredOpen.setSelect(true);
        }
    }

    private void showProgress() {
        if (this.mXQProgressDialog == null) {
            this.mXQProgressDialog = new XQProgressDialog(activity());
        }
        this.mXQProgressDialog.show();
    }

    public void hideProgress() {
        XQProgressDialog xQProgressDialog = this.mXQProgressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mXQProgressDialog.dismiss();
        }
    }

    private void changeType(final int i) {
        initType(i);
        this.mHandler.sendEmptyMessageDelayed(this.MSG_PROGRESS, 500);
        this.mCameraDevice.O000000o().O000000o("night_mode", Integer.valueOf(i), new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.InfraredSettingActivity.AnonymousClass2 */

            public void onSuccess(Void voidR) {
                if (!InfraredSettingActivity.this.isFinishing()) {
                    InfraredSettingActivity infraredSettingActivity = InfraredSettingActivity.this;
                    int i = i;
                    infraredSettingActivity.mLastType = i;
                    infraredSettingActivity.initType(i);
                    InfraredSettingActivity.this.mHandler.removeMessages(InfraredSettingActivity.this.MSG_PROGRESS);
                    InfraredSettingActivity.this.hideProgress();
                }
            }

            public void onFailure(int i, String str) {
                if (!InfraredSettingActivity.this.isFinishing()) {
                    InfraredSettingActivity infraredSettingActivity = InfraredSettingActivity.this;
                    infraredSettingActivity.initType(infraredSettingActivity.mLastType);
                    InfraredSettingActivity.this.mHandler.removeMessages(InfraredSettingActivity.this.MSG_PROGRESS);
                    InfraredSettingActivity.this.activity();
                    gqg.O000000o((int) R.string.set_failed);
                    InfraredSettingActivity.this.hideProgress();
                }
            }
        });
    }

    public void onSelected(View view) {
        int id = view.getId();
        if (id == R.id.infrared_auto) {
            changeType(0);
        } else if (id == R.id.infrared_close) {
            changeType(1);
        } else if (id == R.id.infrared_open) {
            changeType(2);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(this.MSG_PROGRESS);
        hideProgress();
    }
}
