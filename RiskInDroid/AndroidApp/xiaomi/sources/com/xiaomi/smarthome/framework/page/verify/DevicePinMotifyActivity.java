package com.xiaomi.smarthome.framework.page.verify;

import android.content.Intent;
import android.text.TextUtils;

public abstract class DevicePinMotifyActivity extends DevicePinActivity {
    protected String O0000oo0;

    /* access modifiers changed from: protected */
    public abstract void O00000Oo(String str);

    /* access modifiers changed from: protected */
    public final void O000000o(String str) {
        if (TextUtils.isEmpty(this.O0000oo0)) {
            this.O0000oo0 = str;
            this.vDesc.setText(this.O00000o);
            this.vPinInputView.O00000Oo();
        } else if (str.equals(this.O0000oo0)) {
            O00000oO();
            O00000Oo(str);
        } else {
            this.vPinInputView.O00000o0();
            if (this.O0000Oo0 != null) {
                this.O0000Oo0.setVisibility(0);
                this.O0000Oo0.setText(this.O00000oO);
                return;
            }
            this.vDesc.setText(this.O00000oO);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        O00000Oo(this.O0000oo0);
    }

    public void onBackClick() {
        if (TextUtils.isEmpty(this.O0000oo0)) {
            super.onBackClick();
            return;
        }
        this.vPinInputView.O00000Oo();
        this.vDesc.setText(this.O00000o0);
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.setVisibility(4);
        }
        this.O0000oo0 = "";
    }

    /* access modifiers changed from: protected */
    public final void O0000OOo() {
        O00000oo();
        Intent intent = new Intent();
        intent.putExtra("pincode", this.O0000oo0);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(String str) {
        O00000oo();
        Intent intent = new Intent();
        intent.putExtra("xiaomi.sm.fail_msg", str);
        setResult(-10, intent);
        finish();
    }
}
