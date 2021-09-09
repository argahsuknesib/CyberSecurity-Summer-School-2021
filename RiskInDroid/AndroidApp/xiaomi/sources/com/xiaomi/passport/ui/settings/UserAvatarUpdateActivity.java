package com.xiaomi.passport.ui.settings;

import _m_j.eiq;
import _m_j.ekc;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.ParcelableAttackGuardian;
import com.xiaomi.passport.accountmanager.MiAccountManager;

public class UserAvatarUpdateActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
            return;
        }
        ekc ekc = new ekc();
        ekc.setArguments(getIntent().getExtras());
        eiq.O000000o(getFragmentManager(), ekc);
    }

    public void onResume() {
        super.onResume();
        if (MiAccountManager.O00000Oo(this).O00000oo() == null) {
            AccountLog.w("UserAvatarUpdateActivity", "no xiaomi account");
            finish();
        }
    }
}
