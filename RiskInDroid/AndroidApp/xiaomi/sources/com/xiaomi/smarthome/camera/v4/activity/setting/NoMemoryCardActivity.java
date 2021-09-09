package com.xiaomi.smarthome.camera.v4.activity.setting;

import _m_j.cih;
import _m_j.clf;
import _m_j.ftn;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoIntroActivity;

public class NoMemoryCardActivity extends CameraBaseActivity {
    private TextView tvBuy;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mCameraDevice == null) {
            finish();
            return;
        }
        if ("isa.camera.hlc6".equals(this.mCameraDevice.getModel()) || "mijia.camera.v3".equals(this.mCameraDevice.getModel())) {
            setContentView((int) R.layout.activity_no_memory_card);
        } else if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            setContentView((int) R.layout.activity_no_memory_card_022);
            ((TextView) findViewById(R.id.storage_time_content1)).setText(getString(R.string.storage_hour_quality_content, new Object[]{40}));
            ((TextView) findViewById(R.id.storage_time_content2)).setText(getString(R.string.storage_day_quality_content, new Object[]{"3.5"}));
            ((TextView) findViewById(R.id.storage_time_content3)).setText(getString(R.string.storage_day_quality_content, new Object[]{"7"}));
            ((TextView) findViewById(R.id.storage_time_content4)).setText(getString(R.string.storage_day_quality_content, new Object[]{"14"}));
            ((TextView) findViewById(R.id.storage_time_content5)).setText(getString(R.string.storage_day_quality_content, new Object[]{"28"}));
        } else {
            setContentView((int) R.layout.activity_no_memory_card_newchuangmi);
        }
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.storage_sdcard_file_manager);
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.NoMemoryCardActivity.AnonymousClass1 */

            public void onClick(View view) {
                NoMemoryCardActivity.this.finish();
            }
        });
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.tvBuy = (TextView) findViewById(R.id.tv_buy);
        if (this.isV4) {
            if (cih.O000000o()) {
                clf.O00000Oo();
                if (clf.O00000oO() && !clf.O00000o() && !this.mCameraDevice.isShared()) {
                    this.tvBuy.setVisibility(0);
                    this.tvBuy.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.NoMemoryCardActivity.AnonymousClass2 */

                        public void onClick(View view) {
                            NoMemoryCardActivity noMemoryCardActivity = NoMemoryCardActivity.this;
                            noMemoryCardActivity.startActivity(new Intent(noMemoryCardActivity, CloudVideoIntroActivity.class));
                        }
                    });
                }
            }
            this.tvBuy.setVisibility(8);
        } else if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || !clf.O00000oO() || this.mCameraDevice.O00000oO().O00000Oo() || this.mCameraDevice.isShared()) {
            this.tvBuy.setVisibility(8);
        } else {
            this.tvBuy.setVisibility(0);
            this.tvBuy.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.NoMemoryCardActivity.AnonymousClass3 */

                public void onClick(View view) {
                    NoMemoryCardActivity noMemoryCardActivity = NoMemoryCardActivity.this;
                    noMemoryCardActivity.startActivity(new Intent(noMemoryCardActivity, CloudVideoIntroActivity.class));
                }
            });
        }
        if (this.mCameraDevice != null && this.mCameraDevice.O0000oOO()) {
            findViewById(R.id.tab_row_4gb).setVisibility(0);
            findViewById(R.id.tab_row_8gb).setVisibility(0);
            ((TextView) findViewById(R.id.storage_16_low)).setText((int) R.string.storage_time_4_days);
            ((TextView) findViewById(R.id.storage_16_high)).setText((int) R.string.storage_time_2_days);
            ((TextView) findViewById(R.id.storage_32_low)).setText((int) R.string.storage_time_8_days);
            ((TextView) findViewById(R.id.storage_32_high)).setText((int) R.string.storage_time_4_days);
            ((TextView) findViewById(R.id.camera_tips_1)).setText(((TextView) findViewById(R.id.camera_tips_1)).getText().toString().replace("16", "4"));
            ((TextView) findViewById(R.id.camera_tips_1)).setText(((TextView) findViewById(R.id.camera_tips_1)).getText().toString().replace("64", "32"));
            ((TextView) findViewById(R.id.high_quality)).setText((int) R.string.quality_fhd);
            ((TextView) findViewById(R.id.low_quality)).setText((int) R.string.quality_low);
            findViewById(R.id.gb_64_tab_tow).setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
    }
}
