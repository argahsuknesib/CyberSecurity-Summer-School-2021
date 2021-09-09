package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fqx;
import _m_j.fwb;
import android.content.Intent;
import com.xiaomi.smarthome.R;

public class DevicePinVerifyFPReOpenActivity extends DevicePinVerifyActivity {
    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        if (this.O0000oO0 || !fqx.O000000o(this.O0000o.model, this.O0000o.version)) {
            this.O00000Oo = getString(R.string.device_more_verify_enter_title);
        } else {
            this.O00000Oo = getString(R.string.ble_secure_pin_verify_title);
        }
        this.O00000o0 = getString(R.string.device_more_verify_finger_print);
        this.O00000oO = getString(R.string.device_more_verify_pin_error);
        this.vSubHint.setVisibility(0);
        this.vSubHint.setText((int) R.string.device_more_verify_fingerprint_sub_hint);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(String str) {
        Intent intent = new Intent();
        fwb.O00000o0(intent, str);
        setResult(-1, intent);
        finish();
    }
}
