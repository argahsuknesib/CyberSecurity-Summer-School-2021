package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fwb;
import android.content.Intent;
import com.xiaomi.smarthome.R;

public class DevicePinVerifyFPOpenActivity extends DevicePinVerifyActivity {
    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        this.O00000Oo = getString(R.string.device_more_security_fingerprint_main);
        this.O00000o0 = getString(R.string.device_more_verify_finger_print);
        this.O00000oO = getString(R.string.device_more_verify_pin_error);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(String str) {
        Intent intent = new Intent();
        fwb.O00000o0(intent, str);
        setResult(-1, intent);
        finish();
    }
}
