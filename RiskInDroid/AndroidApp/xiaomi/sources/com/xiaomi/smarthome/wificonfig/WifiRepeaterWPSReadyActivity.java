package com.xiaomi.smarthome.wificonfig;

import _m_j.cub;
import _m_j.cuh;
import _m_j.gsy;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;

public class WifiRepeaterWPSReadyActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f12028O000000o;
    ImageView O00000Oo;
    private SimpleDraweeView O00000o;
    private TextView O00000o0;
    private CheckBox O00000oO;
    private String O00000oo;
    public Button mBtnNext;

    public static void invokeActivity(Context context, String str) {
        Intent intent = new Intent(context, WifiRepeaterWPSReadyActivity.class);
        intent.putExtra("model", str);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wifi_repeater_wps_ready);
        this.O00000Oo = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$WifiRepeaterWPSReadyActivity$TDoGvffRPm1RUgmXzoC0I_MhxPM */

            public final void onClick(View view) {
                WifiRepeaterWPSReadyActivity.this.O00000Oo(view);
            }
        });
        this.f12028O000000o = (TextView) findViewById(R.id.module_a_3_return_title);
        this.f12028O000000o.setText((int) R.string.wps_into_ready_bind_mode);
        this.O00000o0 = (TextView) findViewById(R.id.txt_device_name);
        this.O00000o = (SimpleDraweeView) findViewById(R.id.img_wps_ready);
        this.O00000oO = (CheckBox) findViewById(R.id.check_box_confirm);
        this.mBtnNext = (Button) findViewById(R.id.next_btn);
        this.O00000oo = getIntent().getStringExtra("model");
        if (TextUtils.isEmpty(this.O00000oo)) {
            gsy.O00000o0(LogType.KUAILIAN, "Repeater-Binder", "onCrete, models is empty");
            finish();
            return;
        }
        this.O00000oO.setChecked(false);
        this.mBtnNext.setEnabled(false);
        this.O00000oO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.wificonfig.WifiRepeaterWPSReadyActivity.AnonymousClass1 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                WifiRepeaterWPSReadyActivity.this.mBtnNext.setEnabled(z);
            }
        });
        this.O00000o0.setText(DeviceFactory.O0000OoO(this.O00000oo));
        this.mBtnNext.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$WifiRepeaterWPSReadyActivity$4PwxdhW_lKg7uOzvtT5_4KCU8yM */

            public final void onClick(View view) {
                WifiRepeaterWPSReadyActivity.this.O000000o(view);
            }
        });
        this.O00000o.setImageResource(R.drawable.icon_wifi_repeater_wps_guide);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        cuh cuh = new cuh(this, "WifiRepeaterWpsScanActivity");
        cuh.O000000o("model", this.O00000oo);
        cub.O000000o(cuh);
        finish();
    }
}
