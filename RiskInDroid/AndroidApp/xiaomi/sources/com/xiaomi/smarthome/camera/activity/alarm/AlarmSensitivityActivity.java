package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.chx;
import _m_j.gqg;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import org.json.JSONArray;

public class AlarmSensitivityActivity extends CameraBaseActivity implements View.OnClickListener {
    private static final String TAG = "AlarmSensitivityActivity";
    private ImageView iv_alarm_sensivity_hight;
    private ImageView iv_alarm_sensivity_low;
    private ImageView iv_alarm_sensivity_middle;
    chx mCameraProperties;
    XQProgressDialog mProgressDialog;
    private TextView tv_alarm_sensivity_hight;
    private TextView tv_alarm_sensivity_low;
    private TextView tv_alarm_sensivity_middle;
    private int type;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_sensivity);
        this.mCameraProperties = (chx) this.mCameraDevice.O000000o();
        initView();
        loadData();
    }

    private void initView() {
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.alarm_sensivity_setting);
        findViewById(R.id.title_bar_more).setVisibility(8);
        findViewById(R.id.ll_alarm_sensivity_hight).setOnClickListener(this);
        findViewById(R.id.ll_alarm_sensivity_middle).setOnClickListener(this);
        findViewById(R.id.ll_alarm_sensivity_low).setOnClickListener(this);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.iv_alarm_sensivity_hight = (ImageView) findViewById(R.id.iv_alarm_sensivity_hight);
        this.tv_alarm_sensivity_hight = (TextView) findViewById(R.id.tv_alarm_sensivity_hight);
        this.iv_alarm_sensivity_middle = (ImageView) findViewById(R.id.iv_alarm_sensivity_middle);
        this.tv_alarm_sensivity_middle = (TextView) findViewById(R.id.tv_alarm_sensivity_middle);
        this.iv_alarm_sensivity_low = (ImageView) findViewById(R.id.iv_alarm_sensivity_low);
        this.tv_alarm_sensivity_low = (TextView) findViewById(R.id.tv_alarm_sensivity_low);
        this.mProgressDialog = new XQProgressDialog(activity());
        this.mProgressDialog.setMessage(getString(R.string.loading_data));
        this.mProgressDialog.show();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.ll_alarm_sensivity_hight) {
            this.iv_alarm_sensivity_hight.setVisibility(0);
            this.iv_alarm_sensivity_middle.setVisibility(4);
            this.iv_alarm_sensivity_low.setVisibility(4);
            if (Build.VERSION.SDK_INT >= 23) {
                this.tv_alarm_sensivity_hight.setTextColor(getColor(R.color.mj_color_green_normal));
                this.tv_alarm_sensivity_middle.setTextColor(getColor(R.color.mj_color_black));
                this.tv_alarm_sensivity_low.setTextColor(getColor(R.color.mj_color_black));
            }
            this.type = 3;
        } else if (id == R.id.ll_alarm_sensivity_middle) {
            this.iv_alarm_sensivity_hight.setVisibility(4);
            this.iv_alarm_sensivity_middle.setVisibility(0);
            this.iv_alarm_sensivity_low.setVisibility(4);
            if (Build.VERSION.SDK_INT >= 23) {
                this.tv_alarm_sensivity_hight.setTextColor(getColor(R.color.mj_color_black));
                this.tv_alarm_sensivity_middle.setTextColor(getColor(R.color.mj_color_green_normal));
                this.tv_alarm_sensivity_low.setTextColor(getColor(R.color.mj_color_black));
            }
            this.type = 2;
        } else if (id == R.id.ll_alarm_sensivity_low) {
            this.iv_alarm_sensivity_hight.setVisibility(4);
            this.iv_alarm_sensivity_middle.setVisibility(4);
            this.iv_alarm_sensivity_low.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 23) {
                this.tv_alarm_sensivity_hight.setTextColor(getColor(R.color.mj_color_black));
                this.tv_alarm_sensivity_middle.setTextColor(getColor(R.color.mj_color_black));
                this.tv_alarm_sensivity_low.setTextColor(getColor(R.color.mj_color_green_normal));
            }
            this.type = 1;
        } else if (id == R.id.title_bar_return) {
            onBackPressed();
        }
        setData(this.type);
    }

    private void loadData() {
        this.mCameraDevice.O0000o0O().O00000o(new Callback<JSONArray>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSensitivityActivity.AnonymousClass1 */

            public void onSuccess(JSONArray jSONArray) {
                if (!AlarmSensitivityActivity.this.isFinishing()) {
                    if (AlarmSensitivityActivity.this.mProgressDialog.isShowing()) {
                        AlarmSensitivityActivity.this.mProgressDialog.dismiss();
                    }
                    if (jSONArray != null && jSONArray.length() > 0) {
                        AlarmSensitivityActivity.this.refreshUI(jSONArray.optInt(0));
                    }
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmSensitivityActivity.this.isFinishing()) {
                    if (AlarmSensitivityActivity.this.mProgressDialog.isShowing()) {
                        AlarmSensitivityActivity.this.mProgressDialog.dismiss();
                    }
                    AlarmSensitivityActivity.this.activity();
                    gqg.O000000o(AlarmSensitivityActivity.this.getString(R.string.tip_no_info));
                }
            }
        });
    }

    public void refreshUI(int i) {
        this.type = i;
        if (i == 1) {
            this.iv_alarm_sensivity_hight.setVisibility(4);
            this.iv_alarm_sensivity_middle.setVisibility(4);
            this.iv_alarm_sensivity_low.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 23) {
                this.tv_alarm_sensivity_hight.setTextColor(getColor(R.color.mj_color_black));
                this.tv_alarm_sensivity_middle.setTextColor(getColor(R.color.mj_color_black));
                this.tv_alarm_sensivity_low.setTextColor(getColor(R.color.mj_color_green_normal));
            }
        } else if (i == 2) {
            this.iv_alarm_sensivity_hight.setVisibility(4);
            this.iv_alarm_sensivity_middle.setVisibility(0);
            this.iv_alarm_sensivity_low.setVisibility(4);
            if (Build.VERSION.SDK_INT >= 23) {
                this.tv_alarm_sensivity_hight.setTextColor(getColor(R.color.mj_color_black));
                this.tv_alarm_sensivity_middle.setTextColor(getColor(R.color.mj_color_green_normal));
                this.tv_alarm_sensivity_low.setTextColor(getColor(R.color.mj_color_black));
            }
        } else if (i == 3) {
            this.iv_alarm_sensivity_hight.setVisibility(0);
            this.iv_alarm_sensivity_middle.setVisibility(4);
            this.iv_alarm_sensivity_low.setVisibility(4);
            if (Build.VERSION.SDK_INT >= 23) {
                this.tv_alarm_sensivity_hight.setTextColor(getColor(R.color.mj_color_green_normal));
                this.tv_alarm_sensivity_middle.setTextColor(getColor(R.color.mj_color_black));
                this.tv_alarm_sensivity_low.setTextColor(getColor(R.color.mj_color_black));
            }
        }
    }

    private void setData(int i) {
        this.mCameraDevice.O0000o0O().O000000o(new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSensitivityActivity.AnonymousClass2 */

            public void onSuccess(Void voidR) {
                if (!AlarmSensitivityActivity.this.isFinishing()) {
                    if (AlarmSensitivityActivity.this.mProgressDialog.isShowing()) {
                        AlarmSensitivityActivity.this.mProgressDialog.dismiss();
                    }
                    AlarmSensitivityActivity.this.activity();
                    gqg.O000000o((int) R.string.settings_set_success);
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmSensitivityActivity.this.isFinishing()) {
                    if (AlarmSensitivityActivity.this.mProgressDialog.isShowing()) {
                        AlarmSensitivityActivity.this.mProgressDialog.dismiss();
                    }
                    AlarmSensitivityActivity.this.activity();
                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                }
            }
        }, i);
        this.mCameraDevice.O0000o0O().O00000Oo(new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSensitivityActivity.AnonymousClass3 */

            public void onSuccess(Void voidR) {
                if (!AlarmSensitivityActivity.this.isFinishing()) {
                    if (AlarmSensitivityActivity.this.mProgressDialog.isShowing()) {
                        AlarmSensitivityActivity.this.mProgressDialog.dismiss();
                    }
                    AlarmSensitivityActivity.this.activity();
                    gqg.O000000o((int) R.string.settings_set_success);
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmSensitivityActivity.this.isFinishing()) {
                    if (AlarmSensitivityActivity.this.mProgressDialog.isShowing()) {
                        AlarmSensitivityActivity.this.mProgressDialog.dismiss();
                    }
                    AlarmSensitivityActivity.this.activity();
                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                }
            }
        }, i);
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("alarmLevel", this.type);
        setResult(-1, intent);
        super.onBackPressed();
    }
}
