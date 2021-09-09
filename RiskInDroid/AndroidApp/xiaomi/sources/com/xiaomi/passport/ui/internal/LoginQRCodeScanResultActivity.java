package com.xiaomi.passport.ui.internal;

import _m_j.ehs;
import _m_j.eiq;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.utils.ParcelableAttackGuardian;

public class LoginQRCodeScanResultActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ehs f6246O000000o;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
            return;
        }
        this.f6246O000000o = new ehs();
        this.f6246O000000o.setArguments(getIntent().getExtras());
        eiq.O000000o(getFragmentManager(), this.f6246O000000o);
    }

    public void onBackPressed() {
        ehs ehs = this.f6246O000000o;
        if (ehs != null) {
            boolean z = false;
            if (ehs.f15299O000000o.canGoBack()) {
                ehs.f15299O000000o.goBack();
            } else {
                ehs.O000000o(false);
                z = true;
            }
            if (z) {
                return;
            }
        }
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void finish() {
        if (!isFinishing()) {
            ehs ehs = this.f6246O000000o;
            ehs.O00000Oo(ehs.O000000o(ehs.O00000Oo));
        }
        super.finish();
    }
}
