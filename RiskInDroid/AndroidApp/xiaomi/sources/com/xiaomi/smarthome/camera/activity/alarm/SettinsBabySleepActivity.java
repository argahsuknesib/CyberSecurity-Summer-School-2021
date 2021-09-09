package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.chr;
import _m_j.cki;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqg;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.utils.SpecConstantUtils;
import com.xiaomi.smarthome.camera.view.BabySleepAreaView;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SettinsBabySleepActivity extends CameraBaseActivity {
    public static final String TAG = "SettinsBabySleepActivity";
    public BabySleepAreaView baby_area_view;
    private TextView baby_sleep_set_tips;
    private String filePath = "";
    public XQProgressDialog mPD;
    private boolean needSetValue = false;
    private SettingsItemView switch_baby_sleep;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_activity_setting_baby_sleep);
        findViewById(R.id.title_bar_more).setVisibility(8);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.settings_alarm_baby_sleep);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$SettinsBabySleepActivity$qtN4VIqoFQ9w3bw6Q3O6Y6dLZes */

            public final void onClick(View view) {
                SettinsBabySleepActivity.this.lambda$onCreate$0$SettinsBabySleepActivity(view);
            }
        });
        this.baby_sleep_set_tips = (TextView) findViewById(R.id.baby_sleep_set_tips);
        this.filePath = getIntent().getExtras().getString("babySleepImgPath", "");
        this.baby_area_view = (BabySleepAreaView) findViewById(R.id.baby_area_view);
        this.baby_area_view.setEnabled(false);
        this.baby_area_view.setImageResource(R.drawable.baby_sleep_tips_icon);
        this.switch_baby_sleep = (SettingsItemView) findViewById(R.id.switch_baby_sleep);
        this.baby_area_view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.SettinsBabySleepActivity.AnonymousClass1 */

            public void onGlobalLayout() {
                SettinsBabySleepActivity.this.baby_area_view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) SettinsBabySleepActivity.this.baby_area_view.getLayoutParams();
                layoutParams.width = SettinsBabySleepActivity.this.baby_area_view.getMeasuredWidth();
                layoutParams.height = (layoutParams.width * 9) / 16;
                SettinsBabySleepActivity.this.baby_area_view.setLayoutParams(layoutParams);
            }
        });
        this.switch_baby_sleep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.$$Lambda$SettinsBabySleepActivity$wEGViqEwhfspx482sJ7atk0Pxw */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SettinsBabySleepActivity.this.lambda$onCreate$1$SettinsBabySleepActivity(compoundButton, z);
            }
        });
        loadPropertiesFromServer(SpecConstantUtils.ChuangmiBabySleepKV(this.mCameraDevice.getModel()), new Callback<List<PropertyParam>>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.SettinsBabySleepActivity.AnonymousClass3 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<PropertyParam>) ((List) obj));
            }

            /* JADX INFO: additional move instructions added (1) to help type inference */
            public void onSuccess(List<PropertyParam> list) {
                if (!SettinsBabySleepActivity.this.isFinishing()) {
                    SettinsBabySleepActivity.this.mPD.dismiss();
                    try {
                        String str = SettinsBabySleepActivity.TAG;
                        StringBuilder sb = new StringBuilder("loadPropertiesFromServer ChuangmiBabySleepKV onSuccess result=");
                        sb.append(list == null ? list : list.toString());
                        cki.O000000o(str, sb.toString());
                        Object propertyValueFromCache = SettinsBabySleepActivity.this.getPropertyValueFromCache("chuangmi-ai", "baby-wake-switch");
                        SettinsBabySleepActivity.this.refreshUI(propertyValueFromCache != null && ((Boolean) propertyValueFromCache).booleanValue());
                        JSONObject jSONObject = new JSONArray(SettinsBabySleepActivity.this.getPropertyValueFromCache("chuangmi-ai", "baby-sleep-area").toString()).getJSONObject(0);
                        JSONArray jSONArray = new JSONArray(jSONObject.optString("start_coor"));
                        JSONArray jSONArray2 = new JSONArray(jSONObject.optString("end_coor"));
                        SettinsBabySleepActivity.this.baby_area_view.setPositions(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray2.getInt(0), jSONArray2.getInt(1));
                    } catch (Exception e) {
                        cki.O00000oO(SettinsBabySleepActivity.TAG, e.toString());
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!SettinsBabySleepActivity.this.isFinishing()) {
                    SettinsBabySleepActivity.this.mPD.dismiss();
                    String str2 = SettinsBabySleepActivity.TAG;
                    cki.O00000oO(str2, "loadPropertiesFromServer ChuangmiBabySleepKV onFailure " + i + "-" + str);
                    Object propertyValueFromCache = SettinsBabySleepActivity.this.getPropertyValueFromCache("chuangmi-ai", "baby-wake-switch");
                    SettinsBabySleepActivity.this.refreshUI(propertyValueFromCache != null && ((Boolean) propertyValueFromCache).booleanValue());
                    gqg.O00000Oo((int) R.string.action_fail);
                }
            }
        });
        this.mPD = XQProgressDialog.O000000o(getContext(), null, getString(R.string.plugin_loading));
    }

    public /* synthetic */ void lambda$onCreate$0$SettinsBabySleepActivity(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$onCreate$1$SettinsBabySleepActivity(CompoundButton compoundButton, final boolean z) {
        this.mPD = XQProgressDialog.O000000o(getContext(), null, getString(R.string.camera_waiting));
        this.needSetValue = true;
        cki.O000000o(TAG, "onCheckedChange isChecked=".concat(String.valueOf(z)));
        SpecService O000000o2 = this.mCameraSpecDevice.O000000o("chuangmi-ai");
        SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "baby-wake-switch");
        if (O000000o2 == null || O000000o3 == null) {
            refreshUI(true ^ z);
        } else {
            faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Boolean.valueOf(z), new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.SettinsBabySleepActivity.AnonymousClass2 */

                /* JADX INFO: additional move instructions added (1) to help type inference */
                public void onSuccess(JSONObject jSONObject) {
                    chr.O000000o(chr.O00Oo00o, "type", Integer.valueOf(z ? 1 : 2));
                    if (!SettinsBabySleepActivity.this.isFinishing()) {
                        SettinsBabySleepActivity.this.mPD.dismiss();
                        String str = SettinsBabySleepActivity.TAG;
                        StringBuilder sb = new StringBuilder("switch_baby_sleep onSuccess result=");
                        Object obj = jSONObject;
                        if (jSONObject != null) {
                            obj = jSONObject.toString();
                        }
                        sb.append(obj);
                        cki.O000000o(str, sb.toString());
                        SettinsBabySleepActivity.this.refreshUI(z);
                    }
                }

                /* JADX INFO: additional move instructions added (1) to help type inference */
                public void onFailure(fso fso) {
                    if (!SettinsBabySleepActivity.this.isFinishing()) {
                        SettinsBabySleepActivity.this.mPD.dismiss();
                        String str = SettinsBabySleepActivity.TAG;
                        StringBuilder sb = new StringBuilder("switch_baby_sleep onFailure ");
                        Object obj = fso;
                        if (fso != null) {
                            obj = fso.toString();
                        }
                        sb.append(obj);
                        cki.O00000oO(str, sb.toString());
                        SettinsBabySleepActivity.this.refreshUI(!z);
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }
    }

    public void refreshUI(boolean z) {
        this.switch_baby_sleep.setChecked(z);
        if (!this.switch_baby_sleep.isChecked()) {
            this.baby_area_view.setEnabled(false);
            this.baby_area_view.setImageResource(R.drawable.baby_sleep_tips_icon);
            this.baby_sleep_set_tips.setVisibility(8);
            return;
        }
        this.baby_area_view.setEnabled(true);
        this.baby_area_view.setImageURI(Uri.fromFile(new File(this.filePath)));
        this.baby_sleep_set_tips.setVisibility(0);
    }

    public void onBackPressed() {
        if (this.needSetValue || this.baby_area_view.needSetValue) {
            this.mPD = XQProgressDialog.O000000o(getContext(), null, getString(R.string.camera_waiting));
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o("chuangmi-ai");
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "baby-sleep-area");
            int[] positions = this.baby_area_view.getPositions();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start_coor", "[" + positions[0] + "," + positions[1] + "]");
                jSONObject.put("end_coor", "[" + positions[2] + "," + positions[3] + "]");
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                cki.O00000oO(TAG, e.toString());
            }
            if (O000000o2 == null || O000000o3 == null) {
                gqg.O00000Oo((int) R.string.action_fail);
                this.mPD.dismiss();
                super.onBackPressed();
                return;
            }
            String str = TAG;
            cki.O000000o(str, "onBackPressed array=" + jSONArray.toString());
            faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, jSONArray.toString(), new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.SettinsBabySleepActivity.AnonymousClass4 */

                /* JADX INFO: additional move instructions added (1) to help type inference */
                public void onSuccess(JSONObject jSONObject) {
                    if (!SettinsBabySleepActivity.this.isFinishing()) {
                        String str = SettinsBabySleepActivity.TAG;
                        StringBuilder sb = new StringBuilder("onBackPressed onSuccess result=");
                        Object obj = jSONObject;
                        if (jSONObject != null) {
                            obj = jSONObject.toString();
                        }
                        sb.append(obj);
                        cki.O000000o(str, sb.toString());
                        gqg.O00000Oo((int) R.string.action_success);
                        SettinsBabySleepActivity.this.mPD.dismiss();
                        SettinsBabySleepActivity.super.onBackPressed();
                    }
                }

                /* JADX INFO: additional move instructions added (1) to help type inference */
                public void onFailure(fso fso) {
                    if (!SettinsBabySleepActivity.this.isFinishing()) {
                        String str = SettinsBabySleepActivity.TAG;
                        StringBuilder sb = new StringBuilder("onBackPressed onFailure ");
                        Object obj = fso;
                        if (fso != null) {
                            obj = fso.toString();
                        }
                        sb.append(obj);
                        cki.O00000oO(str, sb.toString());
                        gqg.O00000Oo((int) R.string.action_fail);
                        SettinsBabySleepActivity.this.mPD.dismiss();
                        SettinsBabySleepActivity.super.onBackPressed();
                    }
                }
            });
            return;
        }
        super.onBackPressed();
    }
}
