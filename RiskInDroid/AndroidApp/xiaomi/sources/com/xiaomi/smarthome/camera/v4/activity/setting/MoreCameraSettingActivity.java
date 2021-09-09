package com.xiaomi.smarthome.camera.v4.activity.setting;

import _m_j.chr;
import _m_j.chx;
import _m_j.cki;
import _m_j.cla;
import _m_j.cle;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftl;
import _m_j.ftn;
import _m_j.gkv;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.grv;
import _m_j.mj;
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
import com.xiaomi.smarthome.camera.activity.utils.SpecConstantUtils;
import com.xiaomi.smarthome.camera.v4.utils.CameraToastUtil;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class MoreCameraSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    public static final String TAG = "MoreCameraSettingActivity";
    cla alarmConfigV2 = new cla();
    public cle alarmManagerV2;
    private SettingsItemView mAiFrame;
    private SettingsItemView mAlarmMove;
    chx mCameraProperties;
    SettingsItemView mLightItem;
    SettingsItemView mOnlyWifi;
    private String md5Name;
    private SettingsItemView settings_gesture;
    private TextView tvReset;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.more_camera_activity);
        this.md5Name = grv.O000000o(this.mCameraDevice.getModel() + this.mCameraDevice.getDid());
        this.mCameraProperties = (chx) this.mCameraDevice.O000000o();
        this.alarmManagerV2 = this.mCameraDevice.O0000o0o();
        initView();
        refreshUI();
        chr.O000000o(chr.O0000OoO);
        getAlarmConfig();
    }

    public void onResume() {
        super.onResume();
        refreshGestureSettinView();
    }

    private void initView() {
        this.settings_gesture = (SettingsItemView) findViewById(R.id.settings_gesture);
        refreshGestureSettinView();
        this.settings_gesture.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.$$Lambda$MoreCameraSettingActivity$NNNNngNU1Aj0ddP2CA_sQ8tE7rk */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MoreCameraSettingActivity.this.lambda$initView$0$MoreCameraSettingActivity(compoundButton, z);
            }
        });
        if (CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.settings_gesture.setVisibility(0);
        }
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.more_camera_setting);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mLightItem = (SettingsItemView) findViewById(R.id.settings_light);
        this.mOnlyWifi = (SettingsItemView) findViewById(R.id.only_wifi);
        this.tvReset = (TextView) findViewById(R.id.tvReset);
        this.mLightItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass1 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MoreCameraSettingActivity.this.mLightItem.setSwitchEnable(false);
                chr.O000000o(chr.O0000oO0);
                if (MoreCameraSettingActivity.this.mCameraSpecDevice != null) {
                    SpecService O000000o2 = MoreCameraSettingActivity.this.mCameraSpecDevice.O000000o("indicator-light");
                    SpecProperty O000000o3 = MoreCameraSettingActivity.this.mCameraSpecDevice.O000000o(O000000o2, "on");
                    if (O000000o2 == null || O000000o3 == null) {
                        MoreCameraSettingActivity.this.refreshUI();
                        MoreCameraSettingActivity.this.mLightItem.setSwitchEnable(true);
                        return;
                    }
                    faw.O000000o().setDeviceProp(MoreCameraSettingActivity.this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass1.AnonymousClass1 */

                        public void onSuccess(JSONObject jSONObject) {
                            if (!MoreCameraSettingActivity.this.isFinishing()) {
                                MoreCameraSettingActivity.this.refreshUI();
                                MoreCameraSettingActivity.this.mLightItem.setSwitchEnable(true);
                            }
                        }

                        public void onFailure(fso fso) {
                            if (!MoreCameraSettingActivity.this.isFinishing()) {
                                MoreCameraSettingActivity.this.refreshUI();
                                MoreCameraSettingActivity.this.mLightItem.setSwitchEnable(true);
                            }
                        }
                    });
                    return;
                }
                MoreCameraSettingActivity.this.mCameraProperties.O000000o("light", z, new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass1.AnonymousClass2 */

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
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass2 */

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
        if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
            ((SettingsItemView) findViewById(R.id.settings_power)).setTitle(getString(R.string.camera_setting_wulizhebi_title));
        }
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.settings_device_calibration).setOnClickListener(this);
        findViewById(R.id.settings_float_window).setOnClickListener(this);
        this.mAlarmMove = (SettingsItemView) findViewById(R.id.alarm_move);
        ftl.O000000o();
        if (DeviceConstant.isNewChuangmi(this.mCameraDevice.getModel())) {
            if (DeviceConstant.isSupportAiNative(this.mCameraDevice.getModel())) {
                this.mAlarmMove.setTitle(getString(R.string.alarm_people_move));
                this.mAlarmMove.setSubTitle(getString(R.string.alarm_people_move_subtitle));
                this.mAlarmMove.setVisibility(0);
            } else if (CoreApi.O000000o().O0000O0o() && !ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                this.mAlarmMove.setVisibility(0);
            }
        }
        this.mAlarmMove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass3 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (MoreCameraSettingActivity.this.mCameraSpecDevice != null) {
                    SpecService O000000o2 = MoreCameraSettingActivity.this.mCameraSpecDevice.O000000o("camera-control");
                    SpecProperty O000000o3 = MoreCameraSettingActivity.this.mCameraSpecDevice.O000000o(O000000o2, "motion-tracking");
                    if (O000000o2 != null && O000000o3 != null) {
                        faw.O000000o().setDeviceProp(MoreCameraSettingActivity.this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass3.AnonymousClass1 */

                            public void onSuccess(JSONObject jSONObject) {
                                if (!MoreCameraSettingActivity.this.isFinishing()) {
                                    MoreCameraSettingActivity.this.refreshUI();
                                }
                            }

                            public void onFailure(fso fso) {
                                if (!MoreCameraSettingActivity.this.isFinishing()) {
                                    MoreCameraSettingActivity.this.refreshUI();
                                }
                            }
                        });
                    } else if (!MoreCameraSettingActivity.this.isFinishing()) {
                        MoreCameraSettingActivity.this.refreshUI();
                    } else {
                        return;
                    }
                } else {
                    MoreCameraSettingActivity moreCameraSettingActivity = MoreCameraSettingActivity.this;
                    moreCameraSettingActivity.setMotionDetection(moreCameraSettingActivity.alarmConfigV2.f13985O000000o, MoreCameraSettingActivity.this.alarmConfigV2.O00000oO, MoreCameraSettingActivity.this.alarmConfigV2.O00000Oo, MoreCameraSettingActivity.this.alarmConfigV2.O00000o0, z);
                }
                chr.O000000o(chr.O00O0oo, "type", Integer.valueOf(z ? 1 : 2));
            }
        });
        this.mAiFrame = (SettingsItemView) findViewById(R.id.ai_frame);
        if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            this.mAiFrame.setVisibility(0);
        }
        this.mAiFrame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass4 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (MoreCameraSettingActivity.this.mCameraSpecDevice != null) {
                    SpecService O000000o2 = MoreCameraSettingActivity.this.mCameraSpecDevice.O000000o("chuangmi-ai");
                    SpecProperty O000000o3 = MoreCameraSettingActivity.this.mCameraSpecDevice.O000000o(O000000o2, "algo-layer-switch");
                    if (O000000o2 != null && O000000o3 != null) {
                        faw.O000000o().setDeviceProp(MoreCameraSettingActivity.this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass4.AnonymousClass1 */

                            public void onSuccess(JSONObject jSONObject) {
                                if (!MoreCameraSettingActivity.this.isFinishing()) {
                                    MoreCameraSettingActivity.this.refreshUI();
                                }
                            }

                            public void onFailure(fso fso) {
                                if (!MoreCameraSettingActivity.this.isFinishing()) {
                                    MoreCameraSettingActivity.this.refreshUI();
                                }
                            }
                        });
                    } else if (!MoreCameraSettingActivity.this.isFinishing()) {
                        MoreCameraSettingActivity.this.refreshUI();
                    }
                }
            }
        });
    }

    public void setMotionDetection(boolean z, int i, String str, String str2, boolean z2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                mj.O000000o();
                String O000000o2 = mj.O000000o(str);
                if (!TextUtils.isEmpty(O000000o2)) {
                    str = O000000o2;
                }
            } else {
                str = "00:00:00";
            }
            if (!TextUtils.isEmpty(str2)) {
                mj.O000000o();
                String O000000o3 = mj.O000000o(str2);
                if (!TextUtils.isEmpty(O000000o3)) {
                    str2 = O000000o3;
                }
            } else {
                str2 = "23:59:59";
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
            jSONObject.put("interval", i);
            jSONObject.put("startTime", str);
            jSONObject.put("endTime", str2);
            jSONObject.put("trackSwitch", z2);
            this.alarmManagerV2.O00000Oo(this.mCameraDevice.getModel(), jSONObject, new cle.O000000o() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass5 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!MoreCameraSettingActivity.this.isFinishing()) {
                        MoreCameraSettingActivity.this.alarmConfigV2.O000000o(MoreCameraSettingActivity.this.alarmManagerV2.f14020O000000o);
                        MoreCameraSettingActivity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!MoreCameraSettingActivity.this.isFinishing()) {
                        MoreCameraSettingActivity.this.refreshUI();
                    }
                }
            });
        } catch (JSONException unused) {
            refreshUI();
        }
    }

    public void getAlarmConfig() {
        if (this.mCameraSpecDevice != null) {
            loadPropertiesFromServer(SpecConstantUtils.CameraControlSpecKV(this.mCameraDevice.getModel()), new Callback<List<PropertyParam>>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass6 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<PropertyParam>) ((List) obj));
                }

                public void onSuccess(List<PropertyParam> list) {
                    cki.O00000o0(MoreCameraSettingActivity.TAG, "CameraControlSpecKV onSuccess");
                    if (!MoreCameraSettingActivity.this.isFinishing()) {
                        MoreCameraSettingActivity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    String str2 = MoreCameraSettingActivity.TAG;
                    cki.O00000o0(str2, "CameraControlSpecKV onFailure " + i + "-" + str);
                }
            });
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.mCameraDevice.getDid());
            jSONObject.put("region", Locale.getDefault().getCountry());
            this.alarmManagerV2.O000000o(this.mCameraDevice.getModel(), jSONObject, new cle.O000000o() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass7 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!MoreCameraSettingActivity.this.isFinishing()) {
                        MoreCameraSettingActivity.this.alarmConfigV2.O000000o(MoreCameraSettingActivity.this.alarmManagerV2.f14020O000000o);
                        MoreCameraSettingActivity.this.refreshUI();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!MoreCameraSettingActivity.this.isFinishing()) {
                        MoreCameraSettingActivity.this.alarmConfigV2.O000000o(MoreCameraSettingActivity.this.alarmManagerV2.f14020O000000o);
                        MoreCameraSettingActivity.this.refreshUI();
                    }
                }
            });
        } catch (JSONException unused) {
            this.alarmConfigV2.O000000o(this.alarmManagerV2.f14020O000000o);
            refreshUI();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void refreshUI() {
        boolean z = false;
        boolean z2 = true;
        if (this.mCameraSpecDevice != null) {
            try {
                Object propertyValueFromCache = getPropertyValueFromCache("indicator-light", "on");
                this.mLightItem.setChecked(propertyValueFromCache == null ? true : ((Boolean) propertyValueFromCache).booleanValue());
                Object propertyValueFromCache2 = getPropertyValueFromCache("camera-control", "motion-tracking");
                SettingsItemView settingsItemView = this.mAlarmMove;
                if (propertyValueFromCache2 != null) {
                    z = ((Boolean) propertyValueFromCache2).booleanValue();
                }
                settingsItemView.setChecked(z);
                Object propertyValueFromCache3 = getPropertyValueFromCache("chuangmi-ai", "algo-layer-switch");
                SettingsItemView settingsItemView2 = this.mAiFrame;
                if (propertyValueFromCache3 != null) {
                    z2 = ((Boolean) propertyValueFromCache3).booleanValue();
                }
                settingsItemView2.setChecked(z2);
            } catch (Exception e) {
                cki.O00000o0("refreshUI", "Exception:" + e.getLocalizedMessage());
            }
        } else {
            this.mLightItem.setChecked(this.mCameraProperties.O000000o("light", true));
            SettingsItemView settingsItemView3 = this.mAlarmMove;
            cla cla = this.alarmConfigV2;
            if (cla != null && cla.O0000Oo0) {
                z = true;
            }
            settingsItemView3.setChecked(z);
        }
        this.mOnlyWifi.setChecked(this.mCameraDevice.O00000oO().O0000o0);
    }

    public void onDestroy() {
        super.onDestroy();
    }

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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            finish();
        } else if (view.getId() == R.id.settings_infrared) {
            chr.O000000o(chr.O0000oo0);
            startActivity(new Intent(this, InfraredSettingActivity.class));
        } else if (view.getId() == R.id.settings_view) {
            chr.O000000o(chr.O0000o);
            startActivity(new Intent(this, ViewSettingActivity.class));
        } else if (view.getId() == R.id.settings_power) {
            chr.O000000o(chr.O0000o0);
            startActivity(new Intent(this, SleepSettingActivity.class));
        } else if (view.getId() == R.id.tvReset) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O000000o((int) R.string.setting_restart);
            builder.O00000Oo((int) R.string.setting_restart_tip);
            builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
            builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass8 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    final XQProgressDialog xQProgressDialog = new XQProgressDialog(MoreCameraSettingActivity.this);
                    xQProgressDialog.setMessage(MoreCameraSettingActivity.this.getString(R.string.alarm_select_set_ing));
                    xQProgressDialog.setCancelable(true);
                    xQProgressDialog.show();
                    chr.O000000o(chr.O000Oo00);
                    MoreCameraSettingActivity.this.mCameraDevice.O000000o(new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.MoreCameraSettingActivity.AnonymousClass8.AnonymousClass1 */

                        public void onSuccess(Void voidR) {
                            xQProgressDialog.dismiss();
                            MoreCameraSettingActivity.this.mCameraDevice.O00000Oo().O000000o("local_reset");
                            gqg.O000000o((int) R.string.settings_set_success);
                        }

                        public void onFailure(int i, String str) {
                            xQProgressDialog.dismiss();
                            gqg.O000000o((int) R.string.set_failed);
                        }
                    });
                }
            });
            builder.O00000oo();
        } else if (view.getId() == R.id.settings_device_calibration) {
            chr.O000000o(chr.O00000oo);
            chr.O000000o(chr.O000ooO0);
            Intent intent = new Intent();
            intent.putExtra("finish", true);
            intent.putExtra("start_calibration", true);
            setResult(-1, intent);
            finish();
        } else if (view.getId() != R.id.settings_float_window) {
        } else {
            if (!this.mCameraDevice.O000000o().O000000o("power", true)) {
                CameraToastUtil.showPowerOffToast(this.mCameraDevice.getModel(), this, R.string.power_off);
            } else if (XmPluginHostApi.instance().getApiLevel() < 57) {
                gqg.O000000o(getResources().getString(R.string.api_tip_title));
            } else {
                chr.O000000o(chr.O0000o00);
                chr.O000000o(chr.O000ooO);
                if (mk.O000000o(this)) {
                    XmPluginHostApi.instance().openCameraFloatingWindow(this.mCameraDevice.getDid());
                    Intent intent2 = new Intent();
                    intent2.putExtra("finish", true);
                    intent2.putExtra("open_float_window", true);
                    setResult(-1, intent2);
                    finish();
                    return;
                }
                gqg.O000000o(getResources().getString(R.string.float_tip));
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    private void refreshGestureSettinView() {
        this.settings_gesture.setChecked(gpy.O00000o0(gkv.f17949O000000o, this.md5Name, "SP_KEY_GESTURE_CTRL_DIRECTION", true));
    }

    public /* synthetic */ void lambda$initView$0$MoreCameraSettingActivity(CompoundButton compoundButton, boolean z) {
        gpy.O000000o(gkv.f17949O000000o, this.md5Name, "SP_KEY_GESTURE_CTRL_DIRECTION", z);
    }
}
