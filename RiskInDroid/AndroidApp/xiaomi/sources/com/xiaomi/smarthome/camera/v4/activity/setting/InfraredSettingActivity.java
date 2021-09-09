package com.xiaomi.smarthome.camera.v4.activity.setting;

import _m_j.chr;
import _m_j.civ;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqg;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class InfraredSettingActivity extends CameraBaseActivity implements SettingsItemView.OnSelectedListener {
    private SettingsItemView mInfraredAuto;
    private SettingsItemView mInfraredClose;
    private SettingsItemView mInfraredOpen;
    public int mLastType = 0;
    public XQProgressDialog mPD;
    private SettingsItemView sivGlimmerSetting;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_setting_infrared);
        findViewById(R.id.title_bar_more).setVisibility(8);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.infrared_func_setting);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.InfraredSettingActivity.AnonymousClass1 */

            public void onClick(View view) {
                InfraredSettingActivity.this.finish();
            }
        });
        initView();
    }

    public void onResume() {
        super.onResume();
        updateProperties();
    }

    private void initView() {
        this.mInfraredAuto = (SettingsItemView) findViewById(R.id.infrared_auto);
        this.mInfraredClose = (SettingsItemView) findViewById(R.id.infrared_close);
        this.mInfraredOpen = (SettingsItemView) findViewById(R.id.infrared_open);
        this.mInfraredOpen.setTitleMaxLines(2);
        this.sivGlimmerSetting = (SettingsItemView) findViewById(R.id.sivGlimmerSetting);
        if ("chuangmi.camera.ip026c".equals(this.mCameraDevice.getModel())) {
            findViewById(R.id.full_color_ll).setVisibility(8);
            this.mInfraredOpen.setTitle(getString(R.string.infrared_open_2_026));
        }
        if ("chuangmi.camera.026c02".equals(this.mCameraDevice.getModel())) {
            findViewById(R.id.full_color_ll).setVisibility(8);
            this.mInfraredOpen.setTitle(getString(R.string.infrared_open_2_026));
        }
        this.mInfraredAuto.setOnSelectedListener(this);
        this.mInfraredClose.setOnSelectedListener(this);
        this.mInfraredOpen.setOnSelectedListener(this);
        this.sivGlimmerSetting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.InfraredSettingActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O0000oo);
                InfraredSettingActivity.this.changeGlimmerColor(z);
            }
        });
        updateFullColor();
        updateGlimmerColor();
    }

    public void initType(int i) {
        this.mInfraredAuto.setSelect(false);
        this.mInfraredClose.setSelect(false);
        this.mInfraredOpen.setSelect(false);
        if (this.mCameraSpecDevice != null) {
            if (i == 0) {
                this.mInfraredOpen.setSelect(true);
            } else if (i == 1) {
                this.mInfraredClose.setSelect(true);
            } else if (i == 2) {
                this.mInfraredAuto.setSelect(true);
            }
        } else if (i == 0) {
            this.mInfraredAuto.setSelect(true);
        } else if (i == 1) {
            this.mInfraredClose.setSelect(true);
        } else if (i == 2) {
            this.mInfraredOpen.setSelect(true);
        }
    }

    private void updateProperties() {
        this.mPD = XQProgressDialog.O000000o(getContext(), null, getString(R.string.plugin_loading));
        if (this.mCameraSpecDevice != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("camera-control", "night-shot"));
            arrayList.add(new Pair("camera-control", "glimmer-full-color"));
            loadPropertiesFromServer(arrayList, new Callback<List<PropertyParam>>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.InfraredSettingActivity.AnonymousClass3 */

                public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    onSuccess((List<PropertyParam>) ((List) obj));
                }

                public void onSuccess(List<PropertyParam> list) {
                    if (!InfraredSettingActivity.this.isFinishing()) {
                        Object propertyValueFromCache = InfraredSettingActivity.this.getPropertyValueFromCache("camera-control", "night-shot");
                        InfraredSettingActivity.this.mLastType = propertyValueFromCache != null ? ((Integer) propertyValueFromCache).intValue() : 2;
                        InfraredSettingActivity infraredSettingActivity = InfraredSettingActivity.this;
                        infraredSettingActivity.initType(infraredSettingActivity.mLastType);
                        InfraredSettingActivity.this.updateGlimmerColor();
                        InfraredSettingActivity.this.mPD.dismiss();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!InfraredSettingActivity.this.isFinishing()) {
                        InfraredSettingActivity infraredSettingActivity = InfraredSettingActivity.this;
                        infraredSettingActivity.initType(infraredSettingActivity.mLastType);
                        InfraredSettingActivity.this.mPD.dismiss();
                        gqg.O000000o((int) R.string.set_failed);
                    }
                }
            });
            return;
        }
        this.mCameraDevice.O000000o().O000000o(new String[]{"night_mode", "full_color"}, new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.InfraredSettingActivity.AnonymousClass4 */

            public void onSuccess(Void voidR) {
                if (!InfraredSettingActivity.this.isFinishing()) {
                    civ.O000000o("InfraredSettingActivity", "updateProperty onSuccess");
                    InfraredSettingActivity.this.updateGlimmerColor();
                    InfraredSettingActivity.this.mPD.dismiss();
                }
            }

            public void onFailure(int i, String str) {
                if (!InfraredSettingActivity.this.isFinishing()) {
                    civ.O000000o("InfraredSettingActivity", "updateProperty onFailure");
                    InfraredSettingActivity.this.mPD.dismiss();
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
      _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
      _m_j.cll.O000000o(java.lang.String, boolean):boolean */
    public void updateGlimmerColor() {
        boolean z = false;
        if (this.mCameraSpecDevice != null) {
            Object propertyValueFromCache = getPropertyValueFromCache("camera-control", "glimmer-full-color");
            if (propertyValueFromCache != null) {
                z = ((Boolean) propertyValueFromCache).booleanValue();
            }
            this.mCameraDevice.O000000o().O00000Oo("full_color", Boolean.valueOf(z));
            this.sivGlimmerSetting.setChecked(z);
            return;
        }
        this.sivGlimmerSetting.setChecked(this.mCameraDevice.O000000o().O000000o("full_color", false));
    }

    private void updateFullColor() {
        if (this.mCameraSpecDevice != null) {
            Object propertyValueFromCache = getPropertyValueFromCache("camera-control", "night-shot");
            int intValue = propertyValueFromCache != null ? ((Integer) propertyValueFromCache).intValue() : 2;
            this.mCameraDevice.O000000o().O00000Oo("night_mode", Integer.valueOf(intValue));
            this.mLastType = intValue;
        } else {
            this.mLastType = this.mCameraDevice.O000000o().O000000o("night_mode");
        }
        initType(this.mLastType);
    }

    private void changeType(final int i) {
        initType(i);
        this.mPD = XQProgressDialog.O000000o(getContext(), null, getString(R.string.camera_waiting));
        if (this.mCameraSpecDevice != null) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("camera-control");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "night-shot");
            if (O000000o2 != null && O000000o3 != null) {
                faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Integer.valueOf(i), new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.InfraredSettingActivity.AnonymousClass5 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!InfraredSettingActivity.this.isFinishing()) {
                            Object propertyValueFromCache = InfraredSettingActivity.this.getPropertyValueFromCache("camera-control", "night-shot");
                            InfraredSettingActivity.this.mLastType = propertyValueFromCache != null ? ((Integer) propertyValueFromCache).intValue() : 2;
                            InfraredSettingActivity infraredSettingActivity = InfraredSettingActivity.this;
                            infraredSettingActivity.initType(infraredSettingActivity.mLastType);
                            InfraredSettingActivity.this.mPD.dismiss();
                        }
                    }

                    public void onFailure(fso fso) {
                        if (!InfraredSettingActivity.this.isFinishing()) {
                            InfraredSettingActivity infraredSettingActivity = InfraredSettingActivity.this;
                            infraredSettingActivity.initType(infraredSettingActivity.mLastType);
                            InfraredSettingActivity.this.mPD.dismiss();
                            gqg.O000000o((int) R.string.set_failed);
                        }
                    }
                });
            } else if (!isFinishing()) {
                initType(this.mLastType);
                this.mPD.dismiss();
                gqg.O000000o((int) R.string.set_failed);
            }
        } else {
            this.mCameraDevice.O000000o().O000000o("night_mode", Integer.valueOf(i), new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.InfraredSettingActivity.AnonymousClass6 */

                public void onSuccess(Void voidR) {
                    if (!InfraredSettingActivity.this.isFinishing()) {
                        InfraredSettingActivity infraredSettingActivity = InfraredSettingActivity.this;
                        int i = i;
                        infraredSettingActivity.mLastType = i;
                        infraredSettingActivity.initType(i);
                        InfraredSettingActivity.this.mPD.dismiss();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!InfraredSettingActivity.this.isFinishing()) {
                        InfraredSettingActivity infraredSettingActivity = InfraredSettingActivity.this;
                        infraredSettingActivity.initType(infraredSettingActivity.mLastType);
                        InfraredSettingActivity.this.mPD.dismiss();
                        gqg.O000000o((int) R.string.set_failed);
                    }
                }
            });
        }
    }

    public void changeGlimmerColor(boolean z) {
        this.mPD = XQProgressDialog.O000000o(getContext(), null, getString(R.string.camera_waiting));
        if (this.mCameraSpecDevice != null) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("camera-control");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "glimmer-full-color");
            if (O000000o2 != null && O000000o3 != null) {
                faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.InfraredSettingActivity.AnonymousClass7 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!InfraredSettingActivity.this.isFinishing()) {
                            InfraredSettingActivity.this.updateGlimmerColor();
                            InfraredSettingActivity.this.mPD.dismiss();
                        }
                    }

                    public void onFailure(fso fso) {
                        if (!InfraredSettingActivity.this.isFinishing()) {
                            InfraredSettingActivity.this.updateGlimmerColor();
                            InfraredSettingActivity.this.mPD.dismiss();
                        }
                    }
                });
            } else if (!isFinishing()) {
                updateGlimmerColor();
                this.mPD.dismiss();
            }
        } else if (this.mCameraDevice != null && this.mCameraDevice.O000000o() != null) {
            this.mCameraDevice.O000000o().O000000o("full_color", z, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.InfraredSettingActivity.AnonymousClass8 */

                public void onSuccess(Void voidR) {
                    if (!InfraredSettingActivity.this.isFinishing()) {
                        civ.O000000o("InfraredSettingActivity", "onSuccess");
                        InfraredSettingActivity.this.updateGlimmerColor();
                        InfraredSettingActivity.this.mPD.dismiss();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!InfraredSettingActivity.this.isFinishing()) {
                        civ.O000000o("InfraredSettingActivity", "onFailure");
                        InfraredSettingActivity.this.updateGlimmerColor();
                        InfraredSettingActivity.this.mPD.dismiss();
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.chr.O000000o(int, int, long):void
      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
    public void onSelected(View view) {
        int id = view.getId();
        if (id == R.id.infrared_auto) {
            if (this.mCameraSpecDevice != null) {
                changeType(2);
                return;
            }
            chr.O000000o(chr.O0000ooO, "type", (Object) 1);
            changeType(0);
        } else if (id == R.id.infrared_close) {
            if (this.mCameraSpecDevice != null) {
                changeType(1);
                return;
            }
            chr.O000000o(chr.O0000ooO, "type", (Object) 2);
            changeType(1);
        } else if (id != R.id.infrared_open) {
        } else {
            if (this.mCameraSpecDevice != null) {
                changeType(0);
                return;
            }
            chr.O000000o(chr.O0000ooO, "type", (Object) 3);
            changeType(2);
        }
    }
}
