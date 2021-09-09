package com.xiaomi.smarthome.device.bluetooth.connect.single;

import _m_j.fob;
import _m_j.foc;
import _m_j.fte;
import _m_j.hxc;
import _m_j.izb;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.verify.view.PinInputView;
import com.xiaomi.smarthome.framework.page.verify.view.PinSoftKeyboard;
import com.xiaomi.smarthome.framework.statistic.BindStep;

public class BleSecurePinActivity extends BaseActivity implements PinSoftKeyboard.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f7148O000000o;
    View O00000Oo;
    View O00000o;
    CheckBox O00000o0;
    PinInputView O00000oO;
    PinSoftKeyboard O00000oo;
    private String O0000O0o = "";
    private String O0000OOo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.ble_secure_pin_code_layout);
        this.f7148O000000o = (TextView) findViewById(R.id.message);
        this.O00000Oo = findViewById(R.id.ratio_container);
        this.O00000o0 = (CheckBox) findViewById(R.id.ratio_btn);
        this.O00000o = findViewById(R.id.cancel);
        this.O00000oO = (PinInputView) findViewById(R.id.xiaomi_sm_pin_inputs);
        this.O00000oo = (PinSoftKeyboard) findViewById(R.id.xiaomi_sm_pin_softkeyboard);
        this.O00000oo.setClickListener(this);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleSecurePinActivity.AnonymousClass1 */

            public final void onClick(View view) {
                BleSecurePinActivity.this.finish();
            }
        });
        this.O0000OOo = getIntent().getStringExtra("key_mac");
        if (TextUtils.isEmpty(this.O0000OOo)) {
            fte.O00000Oo("BleSecurePinActivity device mac is null");
            finish();
        }
    }

    public void onNumberClick(int i) {
        final String O000000o2 = this.O00000oO.O000000o(i);
        if (O000000o2.length() >= this.O00000oO.getPincodeNumber()) {
            new Handler(getMainLooper()).postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleSecurePinActivity.AnonymousClass2 */

                public final void run() {
                    BleSecurePinActivity.this.onPinCodeInputFinish(O000000o2);
                }
            }, 100);
        }
    }

    public void onBackClick() {
        finish();
    }

    public void onDeleteClick() {
        this.O00000oO.O000000o();
    }

    public void onResume() {
        super.onResume();
        BleDevice O00000o02 = fob.O00000o0(this.O0000OOo);
        if (O00000o02 != null) {
            hxc.O000000o().O000000o(O00000o02.model, BindStep.STEP_INPUT_CONFIG);
        }
    }

    public void onPause() {
        super.onPause();
        BleDevice O00000o02 = fob.O00000o0(this.O0000OOo);
        if (O00000o02 != null) {
            hxc.O000000o().O000000o(O00000o02.model, BindStep.STEP_INPUT_CONFIG, "secure pin onPause");
        }
    }

    public void onPinCodeInputFinish(String str) {
        if (TextUtils.isEmpty(this.O0000O0o)) {
            this.O0000O0o = str;
            this.O00000Oo.setVisibility(4);
            this.f7148O000000o.setText((int) R.string.ble_secure_pin_setting_second_tips);
            this.O00000oO.O00000Oo();
        } else if (!TextUtils.equals(this.O0000O0o, str)) {
            izb.O000000o(this, (int) R.string.device_more_add_pin_error, 0).show();
            this.O0000O0o = "";
            this.O00000Oo.setVisibility(0);
            this.f7148O000000o.setText((int) R.string.ble_secure_pin_setting_first_tips);
            this.O00000oO.O00000Oo();
        } else if (!isFinishing()) {
            foc.O00000Oo(this.O0000OOo, 1);
            foc.O000000o(this.O0000OOo, this.O00000o0.isChecked());
            foc.O0000OOo(this.O0000OOo, this.O0000O0o);
            setResult(-1);
            finish();
        }
    }
}
