package com.xiaomi.smarthome.wificonfig;

import _m_j.cub;
import _m_j.cuh;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class WifiRepeaterWPSChooseSceneActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private ImageView f12027O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private SimpleDraweeView O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private ImageView O0000O0o;
    private ImageView O0000OOo;
    private String O0000Oo;
    private Button O0000Oo0;
    private int O0000OoO = 1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wifi_repeater_choose_scene);
        this.f12027O000000o = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000o0 = (SimpleDraweeView) findViewById(R.id.img_device_icon);
        this.O00000o = (TextView) findViewById(R.id.txt_device_name);
        this.O00000oO = (TextView) findViewById(R.id.txt_set_new_device);
        this.O00000oo = (TextView) findViewById(R.id.txt_set_init_device);
        this.O0000O0o = (ImageView) findViewById(R.id.img_set_device);
        this.O0000OOo = (ImageView) findViewById(R.id.img_set_init_device);
        this.O0000Oo0 = (Button) findViewById(R.id.next_btn);
        this.f12027O000000o.setOnClickListener(this);
        this.O00000oO.setOnClickListener(this);
        this.O00000oo.setOnClickListener(this);
        this.O0000Oo0.setOnClickListener(this);
        this.O0000Oo = getIntent().getStringExtra("model");
        if (TextUtils.isEmpty(this.O0000Oo)) {
            finish();
        }
        this.O00000Oo.setText((int) R.string.wps_choose_connect_type_title);
        DeviceFactory.O00000Oo(this.O0000Oo, this.O00000o0);
        this.O00000o.setText(DeviceFactory.O0000OoO(this.O0000Oo));
    }

    public void onClick(View view) {
        if (view.getId() == R.id.txt_set_init_device) {
            this.O00000oo.setTextColor(ContextCompat.O00000o0(this, R.color.mj_color_text_hightlight));
            this.O0000OOo.setVisibility(0);
            this.O00000oO.setTextColor(ContextCompat.O00000o0(this, R.color.mj_color_black));
            this.O0000O0o.setVisibility(4);
            this.O0000OoO = 2;
        } else if (view.getId() == R.id.txt_set_new_device) {
            this.O00000oO.setTextColor(ContextCompat.O00000o0(this, R.color.mj_color_text_hightlight));
            this.O0000O0o.setVisibility(0);
            this.O00000oo.setTextColor(ContextCompat.O00000o0(this, R.color.mj_color_black));
            this.O0000OOo.setVisibility(4);
            this.O0000OoO = 1;
        } else if (view.getId() == R.id.module_a_3_return_btn) {
            onBackPressed();
        } else if (view.getId() == R.id.next_btn) {
            int i = this.O0000OoO;
            if (i == 1) {
                cub.O000000o(new cuh(this, "ResetDevicePage").O000000o("model", this.O0000Oo));
                finish();
            } else if (i == 2) {
                WifiRepeaterWPSReadyActivity.invokeActivity(this, this.O0000Oo);
                finish();
            }
        }
    }
}
