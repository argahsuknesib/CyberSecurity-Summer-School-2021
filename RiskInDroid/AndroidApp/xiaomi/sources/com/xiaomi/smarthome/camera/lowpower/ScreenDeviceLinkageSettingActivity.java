package com.xiaomi.smarthome.camera.lowpower;

import _m_j.civ;
import _m_j.ftn;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hzc;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.lowpower.entity.EffectiveTimeSpan;
import com.xiaomi.smarthome.camera.lowpower.entity.LinkageDeviceInfo;
import com.xiaomi.smarthome.camera.lowpower.linkage.DeviceLinkSelectActivity;
import com.xiaomi.smarthome.camera.lowpower.timerange.CreateTimeEdit2Activity;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScreenDeviceLinkageSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    public static final String TAG = "ScreenDeviceLinkageSettingActivity";
    public static int sActivityCounts;
    private String dataList;
    private boolean isMultiChoice;
    private boolean isToSelectPage;
    public LinkageManager linkManager;
    public EffectiveTimeSpan mEffectiveTimeSpan;
    private int maxLength;
    private View selectActiveTimeRange;
    private View selectScreenDevice;
    private TextView timeRangeText;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        int i = sActivityCounts + 1;
        sActivityCounts = i;
        if (i > 1) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_screen_device_linkage_setting);
        this.isMultiChoice = getIntent().getBooleanExtra("extra_multi_choice", true);
        this.maxLength = getIntent().getIntExtra("extra_max_length", 3);
        this.isToSelectPage = getIntent().getBooleanExtra("extra_to_select_page", false);
        this.dataList = getIntent().getStringExtra("extra_screen_device_list");
        initViews();
        initData();
        if (this.isToSelectPage) {
            Intent intent = new Intent(this, DeviceLinkSelectActivity.class);
            intent.putExtra("extra_multi_choice", this.isMultiChoice);
            intent.putExtra("max_length", this.maxLength);
            startActivity(intent);
        }
    }

    private void initData() {
        this.linkManager = LinkageManager.getInstance();
        if (!TextUtils.isEmpty(this.dataList)) {
            try {
                restoreDeviceListFromJSON(this.mDeviceStat.did, new JSONArray(this.dataList));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            this.linkManager.getLinkageDeviceList(this.mDeviceStat.did, this.mDeviceStat.model, new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.lowpower.ScreenDeviceLinkageSettingActivity.AnonymousClass1 */

                public void onSuccess(JSONObject jSONObject) {
                    civ.O000000o("xm111", "success result:");
                    for (LinkageDeviceInfo deviceStat : ScreenDeviceLinkageSettingActivity.this.linkManager.getLinkageList()) {
                        civ.O000000o("xm111", " deviceStat:" + deviceStat.getDeviceStat() + " ");
                    }
                }

                public void onFailure(int i, String str) {
                    civ.O000000o("xm111", "error:".concat(String.valueOf(str)));
                }
            });
        }
        this.linkManager.getTimeRange(this.mDeviceStat.model, this.mDeviceStat.did, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.camera.lowpower.ScreenDeviceLinkageSettingActivity.AnonymousClass2 */

            public void onSuccess(JSONObject jSONObject) {
                gsy.O000000o(3, "xm111", jSONObject.toString());
                ScreenDeviceLinkageSettingActivity.this.mEffectiveTimeSpan = EffectiveTimeSpan.parseFromJsonObject(jSONObject);
                ScreenDeviceLinkageSettingActivity.this.updateTimeRange();
            }

            public void onFailure(int i, String str) {
                gsy.O000000o(3, "xm111", str.toString());
                ScreenDeviceLinkageSettingActivity.this.updateTimeRange();
            }
        });
    }

    private void restoreDeviceListFromJSON(String str, JSONArray jSONArray) {
        LinkageManager.getInstance().restoreDeviceListFromJSON(str, jSONArray);
    }

    private void initViews() {
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.lowpower.$$Lambda$ScreenDeviceLinkageSettingActivity$ux3BfcMRsALSqS2Igx7tnw513Ow */

            public final void onClick(View view) {
                ScreenDeviceLinkageSettingActivity.this.lambda$initViews$0$ScreenDeviceLinkageSettingActivity(view);
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.link_device);
        Picasso.get().load(ftn.O00000Oo(CoreApi.O000000o().O0000ooO(), hzc.f1008O000000o.get("img_link_ai_speaker"))).into((ImageView) findViewById(R.id.iv_cover));
        this.selectScreenDevice = findViewById(R.id.listitem_condition_select);
        this.selectActiveTimeRange = findViewById(R.id.listitem_timespan);
        this.selectActiveTimeRange.setOnClickListener(this);
        this.selectScreenDevice.setOnClickListener(this);
        this.timeRangeText = (TextView) findViewById(R.id.tv_timespan);
    }

    public /* synthetic */ void lambda$initViews$0$ScreenDeviceLinkageSettingActivity(View view) {
        finish();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.listitem_condition_select) {
            Intent intent = new Intent(this, DeviceLinkSelectActivity.class);
            intent.putExtra("extra_multi_choice", this.isMultiChoice);
            intent.putExtra("max_length", this.maxLength);
            startActivity(intent);
        } else if (id == R.id.listitem_timespan) {
            Intent intent2 = new Intent(this, CreateTimeEdit2Activity.class);
            intent2.putExtra("time_span", this.mEffectiveTimeSpan);
            startActivityForResult(intent2, 1);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        sActivityCounts--;
        LinkageManager linkageManager = this.linkManager;
        if (linkageManager != null) {
            linkageManager.destroyInstance();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            final EffectiveTimeSpan effectiveTimeSpan = (EffectiveTimeSpan) intent.getParcelableExtra("time_span");
            this.linkManager.submitTimeRange(this.mDeviceStat.model, this.mDeviceStat.did, effectiveTimeSpan.toJSON().toString(), new Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.camera.lowpower.ScreenDeviceLinkageSettingActivity.AnonymousClass3 */

                public void onSuccess(JSONObject jSONObject) {
                    ScreenDeviceLinkageSettingActivity screenDeviceLinkageSettingActivity = ScreenDeviceLinkageSettingActivity.this;
                    screenDeviceLinkageSettingActivity.mEffectiveTimeSpan = effectiveTimeSpan;
                    screenDeviceLinkageSettingActivity.updateTimeRange();
                }

                public void onFailure(int i, String str) {
                    gqg.O00000Oo((int) R.string.action_fail);
                    ScreenDeviceLinkageSettingActivity.this.updateTimeRange();
                }
            });
        }
    }

    public void updateTimeRange() {
        EffectiveTimeSpan effectiveTimeSpan = this.mEffectiveTimeSpan;
        if (effectiveTimeSpan == null) {
            this.timeRangeText.setText(getString(R.string.scene_exetime_all_day));
        } else if (effectiveTimeSpan.fromHour == this.mEffectiveTimeSpan.toHour && this.mEffectiveTimeSpan.fromMin == this.mEffectiveTimeSpan.toMin) {
            this.timeRangeText.setText(getString(R.string.scene_exetime_all_day));
        } else {
            int rawOffset = new GregorianCalendar().getTimeZone().getRawOffset();
            int convert = (int) TimeUnit.HOURS.convert((long) rawOffset, TimeUnit.MILLISECONDS);
            LogType logType = LogType.SCENE;
            gsy.O000000o(logType, "DeviceLinkageSetting", "offsetHOser----" + convert + "--mGTMoffeset---" + rawOffset);
            int i = (((this.mEffectiveTimeSpan.fromHour + convert) + -8) + 24) % 24;
            int i2 = this.mEffectiveTimeSpan.fromMin;
            int i3 = (((this.mEffectiveTimeSpan.toHour + convert) + -8) + 24) % 24;
            int i4 = this.mEffectiveTimeSpan.toMin;
            if (i3 < i || (i3 == i && i4 < i2)) {
                TextView textView = this.timeRangeText;
                textView.setText(formatTime(i, i2) + "-" + formatTime(i3, i4) + "(" + getResources().getString(R.string.scene_exetime_second_day) + ")");
                return;
            }
            TextView textView2 = this.timeRangeText;
            textView2.setText(formatTime(i, i2) + "-" + formatTime(i3, i4));
        }
    }

    private String formatTime(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i >= 0 && i <= 9) {
            sb.append("0");
        }
        sb.append(i);
        sb.append(":");
        if (i2 >= 0 && i2 <= 9) {
            sb.append("0");
        }
        sb.append(i2);
        return sb.toString();
    }
}
