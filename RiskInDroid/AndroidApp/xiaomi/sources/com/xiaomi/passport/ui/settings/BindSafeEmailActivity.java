package com.xiaomi.passport.ui.settings;

import _m_j.eiq;
import _m_j.ejt;
import _m_j.eka;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.ParcelableAttackGuardian;
import com.xiaomi.passport.accountmanager.MiAccountManager;

public class BindSafeEmailActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
        } else if (getIntent().getBooleanExtra("extra_has_unactivated_email", false)) {
            eiq.O000000o(getFragmentManager(), eka.O000000o(getIntent().getStringExtra("unactivated_email_address")));
        } else {
            ejt ejt = new ejt();
            ejt.setArguments(getIntent().getExtras());
            eiq.O000000o(getFragmentManager(), ejt);
        }
    }

    public void onResume() {
        super.onResume();
        if (MiAccountManager.O00000Oo(this).O00000oo() == null) {
            AccountLog.i("BindSafeEmailActivity", "no xiaomi account");
            finish();
        }
    }
}
