package com.xiaomi.passport.ui.internal;

import _m_j.eho;
import _m_j.eks;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.accountsdk.utils.ParcelableAttackGuardian;
import com.xiaomi.passport.ui.settings.ChangePasswordActivity;

public class QuickLoginActivity extends BaseActivity {
    /* access modifiers changed from: protected */
    public final boolean O000000o() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
        } else if (!getIntent().getBooleanExtra("has_password", true)) {
            Intent intent = new Intent(this, ChangePasswordActivity.class);
            intent.putExtras(getIntent());
            intent.setPackage(getPackageName());
            startActivityForResult(intent, 1);
        } else {
            FragmentManager fragmentManager = getFragmentManager();
            if (((eho) fragmentManager.findFragmentByTag("quick_login")) == null) {
                eho eho = new eho();
                eho.setArguments(getIntent().getExtras());
                fragmentManager.beginTransaction().setTransition(4099).replace(16908290, eho, "quick_login").commit();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            setResult(i2);
            finish();
        }
    }

    public void finish() {
        eks.O000000o(getIntent().getParcelableExtra("accountAuthenticatorResponse"), (Bundle) null);
        super.finish();
    }
}
