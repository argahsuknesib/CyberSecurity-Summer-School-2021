package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.chr;
import _m_j.chx;
import _m_j.civ;
import _m_j.gqg;
import _m_j.mk;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.timelapse.TimeLapsePhotographyActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public class MoreCameraSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    chx mCameraProperties;
    private boolean mIsGpu = false;
    SettingsItemView mLightItem;
    SettingsItemView mOnlyWifi;
    private TextView mSubTitle;
    SettingsItemView smartPictureFrame;
    private TextView tvReset;

    public void showCameraInfo() {
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_more_camera_activity);
        this.mCameraProperties = (chx) this.mCameraDevice.O000000o();
        Intent intent = getIntent();
        if (intent != null) {
            this.mIsGpu = intent.getBooleanExtra("gpu", false);
        }
        initView();
        refreshUI();
        chr.O000000o(chr.O0000OoO);
        if (this.mCameraDevice != null && this.mCameraDevice.O000000o() != null) {
            this.mCameraDevice.O000000o().O000000o("isa.camera.hlc6".equals(this.mCameraDevice.getModel()) ? chx.O00000Oo : chx.f13863O000000o, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity.AnonymousClass1 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(Void voidR) {
                    if (!MoreCameraSettingActivity.this.isFinishing()) {
                        MoreCameraSettingActivity.this.refreshUI();
                    }
                }
            });
        }
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.title_bar_title);
        textView.setText((int) R.string.more_camera_setting);
        this.mSubTitle = (TextView) findViewById(R.id.sub_title_bar_title);
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity.AnonymousClass2 */

            public boolean onLongClick(View view) {
                MoreCameraSettingActivity.this.showCameraInfo();
                return true;
            }
        });
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mLightItem = (SettingsItemView) findViewById(R.id.settings_light);
        this.mOnlyWifi = (SettingsItemView) findViewById(R.id.only_wifi);
        this.tvReset = (TextView) findViewById(R.id.tvReset);
        this.mLightItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity.AnonymousClass3 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MoreCameraSettingActivity.this.mLightItem.setSwitchEnable(false);
                chr.O000000o(chr.O0000oO0);
                MoreCameraSettingActivity.this.mCameraProperties.O000000o("light", z, new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity.AnonymousClass3.AnonymousClass1 */

                    public void onSuccess(Void voidR) {
                        if (!MoreCameraSettingActivity.this.isFinishing()) {
                            MoreCameraSettingActivity.this.refreshUI();
                            MoreCameraSettingActivity.this.mLightItem.setSwitchEnable(true);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!MoreCameraSettingActivity.this.isFinishing()) {
                            MoreCameraSettingActivity.this.refreshUI();
                            MoreCameraSettingActivity.this.mLightItem.setSwitchEnable(true);
                        }
                    }
                });
            }
        });
        this.mOnlyWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity.AnonymousClass4 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O0000oOo);
                MoreCameraSettingActivity.this.mCameraDevice.O00000oO().O00000Oo(z);
                MoreCameraSettingActivity.this.mCameraDevice.O00000Oo().O000000o("only_wifi");
            }
        });
        this.tvReset.setOnClickListener(this);
        findViewById(R.id.settings_infrared).setOnClickListener(this);
        findViewById(R.id.settings_view).setOnClickListener(this);
        findViewById(R.id.settings_power).setOnClickListener(this);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.smartPictureFrame = (SettingsItemView) findViewById(R.id.smart_picture_frame);
        if (TextUtils.isEmpty(this.mCameraDevice.getModel()) || !this.mCameraDevice.getModel().equals("isa.camera.hlc6")) {
            this.smartPictureFrame.setVisibility(8);
        } else {
            this.smartPictureFrame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity.AnonymousClass5 */

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    MoreCameraSettingActivity.this.smartPictureFrame.setSwitchEnable(false);
                    MoreCameraSettingActivity.this.mCameraProperties.O000000o("rect", z, new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity.AnonymousClass5.AnonymousClass1 */

                        public void onSuccess(Void voidR) {
                            if (!MoreCameraSettingActivity.this.isFinishing()) {
                                MoreCameraSettingActivity.this.refreshUI();
                                MoreCameraSettingActivity.this.smartPictureFrame.setSwitchEnable(true);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!MoreCameraSettingActivity.this.isFinishing()) {
                                MoreCameraSettingActivity.this.refreshUI();
                                MoreCameraSettingActivity.this.smartPictureFrame.setSwitchEnable(true);
                            }
                        }
                    });
                }
            });
        }
        if (this.mCameraDevice.O0000oOO()) {
            findViewById(R.id.settings_float_window).setVisibility(0);
            findViewById(R.id.settings_timelapse).setVisibility(0);
            findViewById(R.id.settings_float_window).setOnClickListener(this);
            findViewById(R.id.settings_timelapse).setOnClickListener(this);
            return;
        }
        findViewById(R.id.settings_float_window).setVisibility(8);
        findViewById(R.id.settings_timelapse).setVisibility(8);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void refreshUI() {
        this.mLightItem.setChecked(this.mCameraProperties.O000000o("light", true));
        this.mOnlyWifi.setChecked(this.mCameraDevice.O00000oO().O0000o0);
        if (this.mCameraDevice != null && !TextUtils.isEmpty(this.mCameraDevice.getModel()) && this.mCameraDevice.getModel().equals("isa.camera.hlc6")) {
            this.smartPictureFrame.setChecked(this.mCameraProperties.O000000o("rect", true));
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            finish();
        } else if (id == R.id.settings_infrared) {
            chr.O000000o(chr.O0000oo0);
            startActivity(new Intent(this, InfraredSettingActivity.class));
        } else if (id == R.id.settings_view) {
            startActivity(new Intent(this, ViewSettingActivity.class));
        } else if (id == R.id.settings_power) {
            chr.O000000o(chr.O0000o0);
            startActivity(new Intent(this, SleepSettingActivity.class));
        } else if (id == R.id.tvReset) {
            if (!this.mCameraDevice.isOwner()) {
                activity();
                gqg.O000000o((int) R.string.auth_fail_read_only);
                return;
            }
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O000000o((int) R.string.setting_restart);
            builder.O00000Oo((int) R.string.setting_restart_tip);
            builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity.AnonymousClass6 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    final XQProgressDialog xQProgressDialog = new XQProgressDialog(MoreCameraSettingActivity.this.activity());
                    xQProgressDialog.setMessage(MoreCameraSettingActivity.this.getString(R.string.alarm_select_set_ing));
                    xQProgressDialog.setCancelable(true);
                    xQProgressDialog.show();
                    chr.O000000o(chr.O000Oo00);
                    MoreCameraSettingActivity.this.mCameraDevice.O000000o(new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.MoreCameraSettingActivity.AnonymousClass6.AnonymousClass1 */

                        public void onSuccess(Void voidR) {
                            xQProgressDialog.dismiss();
                            MoreCameraSettingActivity.this.mCameraDevice.O00000Oo().O000000o("local_reset");
                            MoreCameraSettingActivity.this.activity();
                            gqg.O000000o((int) R.string.settings_set_success);
                        }

                        public void onFailure(int i, String str) {
                            xQProgressDialog.dismiss();
                            MoreCameraSettingActivity.this.activity();
                            gqg.O000000o((int) R.string.set_failed);
                        }
                    });
                }
            });
            builder.O00000oo();
        } else if (id == R.id.settings_float_window) {
            if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                gqg.O000000o((int) R.string.power_off);
            } else if (XmPluginHostApi.instance().getApiLevel() < 57) {
                civ.O00000o("CameraPlay", "pip not 36");
                gqg.O000000o(getResources().getString(R.string.api_tip_title));
            } else {
                chr.O000000o(chr.O0000o00);
                chr.O000000o(chr.O000ooO);
                if (mk.O000000o(this)) {
                    XmPluginHostApi.instance().openCameraFloatingWindow(this.mCameraDevice.getDid());
                    Intent intent = new Intent();
                    intent.putExtra("finish", true);
                    intent.putExtra("open_float_window", true);
                    setResult(-1, intent);
                    finish();
                    return;
                }
                gqg.O000000o(getResources().getString(R.string.float_tip));
            }
        } else if (id == R.id.settings_timelapse) {
            startActivity(new Intent(this, TimeLapsePhotographyActivity.class));
        }
    }

    public void onBackPressed() {
        if (this.mSubTitle.getVisibility() == 0) {
            this.mSubTitle.setVisibility(8);
        } else {
            super.onBackPressed();
        }
    }
}
