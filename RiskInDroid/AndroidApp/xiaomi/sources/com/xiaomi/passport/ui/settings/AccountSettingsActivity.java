package com.xiaomi.passport.ui.settings;

import _m_j.ejl;
import _m_j.ekx;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.account.data.IdentityAuthReason;
import com.xiaomi.accountsdk.account.data.NotificationAuthResult;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.ParcelableAttackGuardian;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;

public class AccountSettingsActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ejl f6280O000000o;
    public ServiceTokenFuture mRefreshTokenFuture;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            Toast.makeText(this, (int) R.string.passport_unknow_error, 0).show();
            finish();
        } else if (MiAccountManager.O00000Oo(this).O00000oo() != null) {
            O000000o();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        NotificationAuthResult notificationAuthResult;
        if (i != 65536) {
            ejl ejl = this.f6280O000000o;
            if (ejl != null) {
                AccountLog.d("AccountSettingsFragment", "onActivityResult() requestCode:" + i + " resultCode:" + i2);
                if (i != 16) {
                    if (i == 17 && i2 == 9999) {
                        ejl.O00000Oo(IdentityAuthReason.SEND_EMAIL_ACTIVATE_MESSAGE);
                    }
                } else if (i2 == -1 && (notificationAuthResult = (NotificationAuthResult) intent.getParcelableExtra("notification_auth_end")) != null) {
                    new UserDataProxy(ejl.getActivity()).O000000o(ejl.f15508O000000o, "identity_auth_token", notificationAuthResult.serviceToken);
                    ejl.O000000o(ejl.O00000o);
                }
            }
        } else if (i2 == -1) {
            AccountLog.d("AccountSettingsActivity", "add account success");
            O000000o();
        } else {
            AccountLog.d("AccountSettingsActivity", "add account cancelled");
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        boolean z = false;
        if (MiAccountManager.O00000Oo(this).O00000oo() == null) {
            finish();
            Toast.makeText(this, (int) R.string.no_account, 0).show();
            return;
        }
        Activity activity = (Activity) new WeakReference(this).get();
        if (activity != null && !activity.isFinishing() && this.mRefreshTokenFuture == null) {
            z = true;
        }
        if (z) {
            this.mRefreshTokenFuture = MiAccountManager.O00000Oo(this).O000000o(this, "passportapi");
            ekx.O000000o().execute(new Runnable() {
                /* class com.xiaomi.passport.ui.settings.AccountSettingsActivity.AnonymousClass1 */

                public final void run() {
                    try {
                        ServiceTokenResult serviceTokenResult = AccountSettingsActivity.this.mRefreshTokenFuture.get();
                        if (serviceTokenResult == null || TextUtils.isEmpty(serviceTokenResult.O00000Oo)) {
                            AccountLog.e("AccountSettingsActivity", "cannot get service token");
                            AccountSettingsActivity.this.finish();
                        }
                    } finally {
                        AccountSettingsActivity.this.mRefreshTokenFuture = null;
                    }
                }
            });
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private void O000000o() {
        FragmentManager fragmentManager = getFragmentManager();
        String simpleName = ejl.class.getSimpleName();
        this.f6280O000000o = (ejl) fragmentManager.findFragmentByTag(simpleName);
        if (this.f6280O000000o == null) {
            ejl ejl = new ejl();
            Intent intent = getIntent();
            if (!(intent == null || intent.getExtras() == null)) {
                ejl.setArguments(intent.getExtras());
            }
            fragmentManager.beginTransaction().add(16908290, ejl, simpleName).commit();
            this.f6280O000000o = ejl;
        }
    }
}
