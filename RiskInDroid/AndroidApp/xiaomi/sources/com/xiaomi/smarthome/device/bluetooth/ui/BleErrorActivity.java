package com.xiaomi.smarthome.device.bluetooth.ui;

import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.bluetooth.connect.ConnectBaseActivity;

public class BleErrorActivity extends ConnectBaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f7151O000000o;
    private TextView O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    private int O00000oO;
    public String mModel;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.ble_error);
        Intent intent = getIntent();
        this.O00000oO = intent.getIntExtra("error.from", 0);
        this.mModel = intent.getStringExtra("model");
        this.f7151O000000o = (TextView) findViewById(R.id.retry);
        this.O00000Oo = (TextView) findViewById(R.id.cancel);
        this.O00000o0 = (TextView) findViewById(R.id.line1);
        this.O00000o = (TextView) findViewById(R.id.line2);
        this.f7151O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.BleErrorActivity.AnonymousClass1 */

            public final void onClick(View view) {
                hxk hxk = hxi.O00000o;
                String str = BleErrorActivity.this.mModel;
                hxk.f952O000000o.O000000o("adddevice_BLE_timeout_retry", "model", str);
                BleErrorActivity.this.retry();
            }
        });
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.ui.BleErrorActivity.AnonymousClass2 */

            public final void onClick(View view) {
                hxk hxk = hxi.O00000o;
                String str = BleErrorActivity.this.mModel;
                hxk.f952O000000o.O000000o("adddevice_BLE_timeout_cancel", "model", str);
                BleErrorActivity.this.finish();
            }
        });
        if (this.O00000oO == 1) {
            this.O00000o0.setText((int) R.string.ble_rssi_match_failed_line1);
            this.O00000o.setText((int) R.string.ble_rssi_match_failed_line2);
        }
        hxp hxp = hxi.O00000o0;
        String str = this.mModel;
        hxp.f957O000000o.O000000o("adddevice_BLE_timeout_show", "model", str);
    }

    public void retry() {
        if (this.O00000oO == 1) {
            setResult(-1);
            finish();
        }
    }
}
