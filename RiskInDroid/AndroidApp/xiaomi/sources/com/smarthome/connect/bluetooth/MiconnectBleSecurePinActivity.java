package com.smarthome.connect.bluetooth;

import _m_j.dck;
import _m_j.dct;
import _m_j.foc;
import _m_j.izb;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.smarthome.connect.view.PinInputView;
import com.smarthome.connect.view.PinSoftKeyboard;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class MiconnectBleSecurePinActivity extends BaseActivity implements dck, PinSoftKeyboard.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f5629O000000o;
    View O00000Oo;
    PinInputView O00000o;
    CheckBox O00000o0;
    PinSoftKeyboard O00000oO;
    private String O00000oo = "";
    private String O0000O0o;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.miconnect_secure_pin_code_layout);
        ((TextView) findViewById(R.id.common_tile_tv)).setText((int) R.string.miconnect_ble_secure_pin_setting_title);
        this.f5629O000000o = (TextView) findViewById(R.id.message);
        this.O00000Oo = findViewById(R.id.ratio_container);
        this.O00000o0 = (CheckBox) findViewById(R.id.ratio_btn);
        this.O00000o = (PinInputView) findViewById(R.id.xiaomi_sm_pin_inputs);
        this.O00000oO = (PinSoftKeyboard) findViewById(R.id.xiaomi_sm_pin_softkeyboard);
        this.O00000oO.setClickListener(this);
        this.O0000O0o = getIntent().getStringExtra("key_mac");
        if (TextUtils.isEmpty(this.O0000O0o)) {
            dct.O00000o0("BleSecurePinActivity device mac is null");
            finish();
        }
    }

    public void onNumberClick(int i) {
        PinInputView pinInputView = this.O00000o;
        if (pinInputView.O00000oO.length() < pinInputView.f5649O000000o) {
            pinInputView.O00000oO += i;
        }
        pinInputView.O00000oo[pinInputView.O00000oO.length() - 1].showPin();
        pinInputView.O00000oo[pinInputView.O00000oO.length() - 1].clearHighlight();
        if (pinInputView.O00000oO.length() < pinInputView.f5649O000000o) {
            pinInputView.O00000oo[pinInputView.O00000oO.length()].showHighlight();
            pinInputView.O0000O0o = pinInputView.O00000oo[pinInputView.O00000oO.length()];
        } else {
            pinInputView.O0000O0o = null;
        }
        final String str = pinInputView.O00000oO;
        if (str.length() >= this.O00000o.getPincodeNumber()) {
            new Handler(getMainLooper()).postDelayed(new Runnable() {
                /* class com.smarthome.connect.bluetooth.MiconnectBleSecurePinActivity.AnonymousClass1 */

                public final void run() {
                    MiconnectBleSecurePinActivity.this.onPinCodeInputFinish(str);
                }
            }, 100);
        }
    }

    public void onBackClick() {
        finish();
    }

    public void onDeleteClick() {
        PinInputView pinInputView = this.O00000o;
        if (!TextUtils.isEmpty(pinInputView.O00000oO)) {
            pinInputView.O0000O0o = pinInputView.O00000oo[pinInputView.O00000oO.length() - 1];
            pinInputView.O00000oo[pinInputView.O00000oO.length() - 1].clearPin();
            pinInputView.O00000oo[pinInputView.O00000oO.length() - 1].showHighlight();
            if (pinInputView.O00000oO.length() < pinInputView.f5649O000000o) {
                pinInputView.O00000oo[pinInputView.O00000oO.length()].clearPin();
                pinInputView.O00000oo[pinInputView.O00000oO.length()].clearHighlight();
            }
            if (pinInputView.O00000oO.length() == 1) {
                pinInputView.O00000oO = "";
            } else {
                pinInputView.O00000oO = pinInputView.O00000oO.substring(0, pinInputView.O00000oO.length() - 1);
            }
        }
    }

    public void onPinCodeInputFinish(String str) {
        if (TextUtils.isEmpty(this.O00000oo)) {
            this.O00000oo = str;
            this.O00000Oo.setVisibility(4);
            this.f5629O000000o.setText((int) R.string.miconnect_ble_secure_pin_setting_second_tips);
            this.O00000o.O000000o();
        } else if (!TextUtils.equals(this.O00000oo, str)) {
            izb.O000000o(this, (int) R.string.miconnect_device_more_add_pin_error, 0).show();
            this.O00000oo = "";
            this.O00000Oo.setVisibility(0);
            this.f5629O000000o.setText((int) R.string.miconnect_ble_secure_pin_setting_first_tips);
            this.O00000o.O000000o();
        } else if (!isFinishing()) {
            foc.O00000Oo(this.O0000O0o, 1);
            foc.O000000o(this.O0000O0o, this.O00000o0.isChecked());
            foc.O0000OOo(this.O0000O0o, this.O00000oo);
            setResult(-1);
            finish();
        }
    }
}
