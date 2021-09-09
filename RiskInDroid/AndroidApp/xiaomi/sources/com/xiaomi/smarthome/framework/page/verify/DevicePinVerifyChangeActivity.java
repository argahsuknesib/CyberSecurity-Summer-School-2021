package com.xiaomi.smarthome.framework.page.verify;

import _m_j.fqx;
import android.content.Intent;
import com.xiaomi.smarthome.R;

public class DevicePinVerifyChangeActivity extends DevicePinVerifyActivity {
    /* access modifiers changed from: protected */
    public final boolean O000000o() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        if (this.O0000oO0 || !fqx.O000000o(this.O0000o.model, this.O0000o.version)) {
            this.O00000Oo = getString(R.string.device_more_change_pin_title);
        } else {
            this.O00000Oo = getString(R.string.ble_secure_change_pin_code);
        }
        this.O00000o0 = getString(R.string.device_more_verify_pin_desc);
        this.O00000oO = getString(R.string.device_more_verify_pin_error);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(String str) {
        DevicePinMotifyChangeActivity.O000000o(this, this.f7933O000000o, str, this.O00000oo, this.O0000oO0, 300);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 300) {
            return;
        }
        if (i2 == -10) {
            Intent intent2 = new Intent();
            intent2.putExtra("xiaomi.sm.fail_msg", intent.getStringExtra("xiaomi.sm.fail_msg"));
            setResult(-10, intent2);
            finish();
        } else if (i2 == -1) {
            setResult(-1);
            finish();
        } else if (i2 == 0) {
            setResult(0);
            finish();
        }
    }
}
