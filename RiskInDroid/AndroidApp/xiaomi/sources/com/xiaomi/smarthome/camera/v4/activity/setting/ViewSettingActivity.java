package com.xiaomi.smarthome.camera.v4.activity.setting;

import _m_j.chr;
import _m_j.chx;
import _m_j.cki;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqg;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.BaseDevice;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ViewSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    public static final String TAG = "ViewSettingActivity";
    chx mCameraProperties;
    SettingsItemView mCorrectLensDistortItem;
    BaseDevice.StateChangedListener mListener = new BaseDevice.StateChangedListener() {
        /* class com.xiaomi.smarthome.camera.v4.activity.setting.ViewSettingActivity.AnonymousClass4 */

        public void onStateChanged(BaseDevice baseDevice) {
            ViewSettingActivity.this.refreshUI();
        }
    };
    public XQProgressDialog mPD;
    SettingsItemView mRoteItem;
    SettingsItemView mWatermarkItem;
    SettingsItemView mWdrItem;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.view_setting_acitivity);
        this.mCameraProperties = (chx) this.mCameraDevice.O000000o();
        initView();
        this.mCameraDevice.addStateChangedListener(this.mListener);
        try {
            if (this.mCameraSpecDevice != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("camera-control", "time-watermark"));
                arrayList.add(new Pair("camera-control", "wdr-mode"));
                this.mPD = XQProgressDialog.O000000o(getContext(), null, getString(R.string.camera_waiting));
                loadPropertiesFromServer(arrayList, new Callback<List<PropertyParam>>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.ViewSettingActivity.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<PropertyParam>) ((List) obj));
                    }

                    public void onSuccess(List<PropertyParam> list) {
                        if (!ViewSettingActivity.this.isFinishing()) {
                            ViewSettingActivity.this.refreshUI();
                            ViewSettingActivity.this.mPD.dismiss();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!ViewSettingActivity.this.isFinishing()) {
                            ViewSettingActivity.this.mPD.dismiss();
                            gqg.O00000Oo((int) R.string.action_fail);
                        }
                    }
                });
            }
        } catch (Exception e) {
            cki.O00000oO(TAG, e.toString());
        }
    }

    private void initView() {
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.setting_view);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mWatermarkItem = (SettingsItemView) findViewById(R.id.watermark);
        this.mCorrectLensDistortItem = (SettingsItemView) findViewById(R.id.correct_lens_distort);
        this.mRoteItem = (SettingsItemView) findViewById(R.id.settings_rote);
        this.mWdrItem = (SettingsItemView) findViewById(R.id.settings_wdr);
        this.mWatermarkItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.ViewSettingActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ViewSettingActivity.this.mWatermarkItem.setSwitchEnable(false);
                chr.O000000o(chr.O0000oO);
                if (ViewSettingActivity.this.mCameraSpecDevice != null) {
                    SpecService O000000o2 = ViewSettingActivity.this.mCameraSpecDevice.O000000o("camera-control");
                    SpecProperty O000000o3 = ViewSettingActivity.this.mCameraSpecDevice.O000000o(O000000o2, "time-watermark");
                    if (O000000o2 != null && O000000o3 != null) {
                        faw.O000000o().setDeviceProp(ViewSettingActivity.this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.setting.ViewSettingActivity.AnonymousClass2.AnonymousClass1 */

                            public void onSuccess(JSONObject jSONObject) {
                                if (!ViewSettingActivity.this.isFinishing()) {
                                    ViewSettingActivity.this.refreshUI();
                                    ViewSettingActivity.this.mWatermarkItem.setSwitchEnable(true);
                                }
                            }

                            public void onFailure(fso fso) {
                                if (!ViewSettingActivity.this.isFinishing()) {
                                    ViewSettingActivity.this.refreshUI();
                                    ViewSettingActivity.this.mWatermarkItem.setSwitchEnable(true);
                                }
                            }
                        });
                    } else if (!ViewSettingActivity.this.isFinishing()) {
                        ViewSettingActivity.this.refreshUI();
                        ViewSettingActivity.this.mWatermarkItem.setSwitchEnable(true);
                    }
                } else {
                    ViewSettingActivity.this.mCameraProperties.O000000o("watermark", z, new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.ViewSettingActivity.AnonymousClass2.AnonymousClass2 */

                        public void onSuccess(Void voidR) {
                            if (!ViewSettingActivity.this.isFinishing()) {
                                ViewSettingActivity.this.refreshUI();
                                ViewSettingActivity.this.mWatermarkItem.setSwitchEnable(true);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!ViewSettingActivity.this.isFinishing()) {
                                ViewSettingActivity.this.refreshUI();
                                ViewSettingActivity.this.mWatermarkItem.setSwitchEnable(true);
                            }
                        }
                    });
                }
            }
        });
        this.mCorrectLensDistortItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.ViewSettingActivity.AnonymousClass3 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                chr.O000000o(chr.O0000oOO);
                ViewSettingActivity.this.mCameraDevice.O00000oO().O000000o(z);
            }
        });
        this.mRoteItem.setOnClickListener(this);
        this.mWdrItem.setOnClickListener(this);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
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
        if (this.mCameraSpecDevice != null) {
            Object propertyValueFromCache = getPropertyValueFromCache("camera-control", "time-watermark");
            this.mWatermarkItem.setChecked(propertyValueFromCache != null ? ((Boolean) propertyValueFromCache).booleanValue() : false);
            Object propertyValueFromCache2 = getPropertyValueFromCache("camera-control", "wdr-mode");
            if (propertyValueFromCache2 != null) {
                z = ((Boolean) propertyValueFromCache2).booleanValue();
            }
            this.mCameraProperties.O00000Oo("wdr", Boolean.valueOf(z));
            this.mWdrItem.setInfo(z ? getString(R.string.setting_open_status) : getString(R.string.setting_close_status));
        } else {
            this.mWatermarkItem.setChecked(this.mCameraProperties.O000000o("watermark", false));
            this.mWdrItem.setInfo(this.mCameraProperties.O000000o("wdr", false) ? getString(R.string.setting_open_status) : getString(R.string.setting_close_status));
        }
        this.mCorrectLensDistortItem.setChecked(this.mCameraDevice.O00000oO().O0000OOo);
    }

    public void onResume() {
        super.onResume();
        refreshUI();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            finish();
        } else if (id == R.id.settings_wdr) {
            chr.O000000o(chr.O0000ooo);
            startActivity(new Intent(this, WdrSettingActivity.class));
        } else if (id == R.id.settings_rote) {
            chr.O000000o(chr.O00oOooo);
            startActivity(new Intent(this, RoteSettingActivity.class));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.mCameraDevice != null) {
            this.mCameraDevice.removeStateChangedListener(this.mListener);
        }
    }
}
