package com.xiaomi.passport.ui.settings;

import _m_j.egc;
import _m_j.ejr;
import _m_j.eks;
import _m_j.ekx;
import android.accounts.Account;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.data.IdentityAuthReason;
import com.xiaomi.accountsdk.account.data.NotificationAuthResult;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.ParcelableAttackGuardian;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.settings.UserInfoManager;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.smarthome.R;

public class UserInfoTransparentActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f6313O000000o;
    private MiAccountManager O00000Oo;
    public Account mAccount;
    public ejr mGetIdentityUrlTask;
    public ejr mGetPhoneIdentityAuthTask;
    public IdentityAuthReason mIdentityAuthReason;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
            return;
        }
        this.O00000Oo = MiAccountManager.O00000Oo(this);
        this.mAccount = this.O00000Oo.O00000oo();
        if (this.mAccount == null) {
            AccountLog.i("UserInfoTransparentActivity", "no xiaomi account");
            finish();
            return;
        }
        this.f6313O000000o = getIntent().getStringExtra("stat_key_source");
        int i = AnonymousClass4.f6317O000000o[UserInfoManager.UserInfoType.valueOf(this.f6313O000000o).ordinal()];
        boolean z = false;
        if (i != 1) {
            if (i == 2) {
                SharedPreferences sharedPreferences = getSharedPreferences(this.mAccount.name, 0);
                String string = sharedPreferences.getString("unactivated_email_address", null);
                long j = sharedPreferences.getLong("unactivated_email_time_stamp", 0);
                String O000000o2 = new UserDataProxy(this).O000000o(this.mAccount, "acc_user_email");
                if (System.currentTimeMillis() - j > 86400000) {
                    sharedPreferences.edit().clear().apply();
                } else {
                    if (!TextUtils.isEmpty(string) && (TextUtils.isEmpty(O000000o2) || !string.equals(O000000o2))) {
                        z = true;
                    }
                    if (z) {
                        O000000o(true, string);
                        return;
                    }
                }
                if (TextUtils.isEmpty(O000000o2)) {
                    doIdentityAuth(IdentityAuthReason.SEND_EMAIL_ACTIVATE_MESSAGE);
                    return;
                }
                new AlertDialog.Builder(this).setTitle((int) R.string.update_email_address_dialog_title).setMessage((int) R.string.update_email_address_dialog_message).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.passport.ui.settings.UserInfoTransparentActivity.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        UserInfoTransparentActivity.this.doIdentityAuth(IdentityAuthReason.SEND_EMAIL_ACTIVATE_MESSAGE);
                    }
                }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create().show();
            } else if (i == 3) {
                Intent newIntent = ChangePasswordActivity.newIntent(this);
                overridePendingTransition(0, 0);
                startActivityForResult(newIntent, 18);
            }
        } else if (this.mGetPhoneIdentityAuthTask == null) {
            this.mGetPhoneIdentityAuthTask = new ejr(this, new UserDataProxy(this).O000000o(this.mAccount, "identity_auth_token"), IdentityAuthReason.MODIFY_SAFE_PHONE, new ejr.O000000o() {
                /* class com.xiaomi.passport.ui.settings.UserInfoTransparentActivity.AnonymousClass3 */

                public final void O000000o(String str) {
                    UserInfoTransparentActivity userInfoTransparentActivity = UserInfoTransparentActivity.this;
                    userInfoTransparentActivity.mGetPhoneIdentityAuthTask = null;
                    Intent O000000o2 = eks.O000000o(userInfoTransparentActivity, null, str, "passportapi", null);
                    O000000o2.putExtra("userId", UserInfoTransparentActivity.this.mAccount.name);
                    UserInfoTransparentActivity.this.startActivityForResult(O000000o2, 10001);
                }

                public final void O000000o() {
                    UserInfoTransparentActivity userInfoTransparentActivity = UserInfoTransparentActivity.this;
                    userInfoTransparentActivity.mGetPhoneIdentityAuthTask = null;
                    userInfoTransparentActivity.startUpdateSafePhone();
                }

                public final void O000000o(int i) {
                    UserInfoTransparentActivity userInfoTransparentActivity = UserInfoTransparentActivity.this;
                    userInfoTransparentActivity.mGetPhoneIdentityAuthTask = null;
                    Toast.makeText(userInfoTransparentActivity, i, 1).show();
                    UserInfoManager.O000000o(UserInfoTransparentActivity.this.getApplicationContext(), false, i);
                    UserInfoTransparentActivity.this.finish();
                }

                public final void O000000o(ServerError serverError) {
                    UserInfoTransparentActivity userInfoTransparentActivity = UserInfoTransparentActivity.this;
                    userInfoTransparentActivity.mGetPhoneIdentityAuthTask = null;
                    if (!userInfoTransparentActivity.isFinishing()) {
                        egc.O000000o o000000o = egc.O00000Oo;
                        egc.O000000o.O000000o(UserInfoTransparentActivity.this, serverError);
                    }
                }
            });
            this.mGetPhoneIdentityAuthTask.executeOnExecutor(ekx.O000000o(), new Void[0]);
        }
    }

    public void onDestroy() {
        ejr ejr = this.mGetPhoneIdentityAuthTask;
        if (ejr != null) {
            ejr.cancel(true);
            this.mGetPhoneIdentityAuthTask = null;
        }
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10001) {
            if (i2 == -1) {
                NotificationAuthResult notificationAuthResult = (NotificationAuthResult) intent.getParcelableExtra("notification_auth_end");
                if (notificationAuthResult != null) {
                    new UserDataProxy(this).O000000o(this.mAccount, "identity_auth_token", notificationAuthResult.serviceToken);
                    startUpdateSafePhone();
                } else {
                    return;
                }
            }
            finish();
        } else if (i != 10002) {
            switch (i) {
                case 16:
                    if (i2 == -1) {
                        NotificationAuthResult notificationAuthResult2 = (NotificationAuthResult) intent.getParcelableExtra("notification_auth_end");
                        if (notificationAuthResult2 != null) {
                            new UserDataProxy(this).O000000o(this.mAccount, "identity_auth_token", notificationAuthResult2.serviceToken);
                            onPassIdentityAuth(this.mIdentityAuthReason);
                        } else {
                            return;
                        }
                    }
                    finish();
                    return;
                case 17:
                    if (i2 == 9999) {
                        doIdentityAuth(IdentityAuthReason.SEND_EMAIL_ACTIVATE_MESSAGE);
                        return;
                    } else {
                        finish();
                        return;
                    }
                case 18:
                    finish();
                    return;
                default:
                    return;
            }
        } else {
            finish();
        }
    }

    public void startUpdateSafePhone() {
        Intent intent = new Intent(this, BindPhoneActivity.class);
        intent.setPackage(getPackageName());
        startActivityForResult(intent, 10002);
    }

    public void doIdentityAuth(IdentityAuthReason identityAuthReason) {
        if (this.mGetIdentityUrlTask == null) {
            this.mIdentityAuthReason = identityAuthReason;
            this.mGetIdentityUrlTask = new ejr(this, new UserDataProxy(this).O000000o(this.mAccount, "identity_auth_token"), identityAuthReason, new ejr.O000000o() {
                /* class com.xiaomi.passport.ui.settings.UserInfoTransparentActivity.AnonymousClass2 */

                public final void O000000o(int i) {
                    UserInfoTransparentActivity userInfoTransparentActivity = UserInfoTransparentActivity.this;
                    userInfoTransparentActivity.mGetIdentityUrlTask = null;
                    Toast.makeText(userInfoTransparentActivity, i, 1).show();
                    UserInfoTransparentActivity.this.finish();
                }

                public final void O000000o(String str) {
                    UserInfoTransparentActivity userInfoTransparentActivity = UserInfoTransparentActivity.this;
                    userInfoTransparentActivity.mGetIdentityUrlTask = null;
                    Intent O000000o2 = eks.O000000o(userInfoTransparentActivity, null, str, "passportapi", null);
                    O000000o2.putExtra("userId", UserInfoTransparentActivity.this.mAccount.name);
                    UserInfoTransparentActivity.this.overridePendingTransition(0, 0);
                    UserInfoTransparentActivity.this.startActivityForResult(O000000o2, 16);
                }

                public final void O000000o() {
                    UserInfoTransparentActivity userInfoTransparentActivity = UserInfoTransparentActivity.this;
                    userInfoTransparentActivity.mGetIdentityUrlTask = null;
                    userInfoTransparentActivity.onPassIdentityAuth(userInfoTransparentActivity.mIdentityAuthReason);
                }

                public final void O000000o(ServerError serverError) {
                    UserInfoTransparentActivity userInfoTransparentActivity = UserInfoTransparentActivity.this;
                    userInfoTransparentActivity.mGetIdentityUrlTask = null;
                    if (!userInfoTransparentActivity.isFinishing()) {
                        egc.O000000o o000000o = egc.O00000Oo;
                        egc.O000000o.O000000o(UserInfoTransparentActivity.this, serverError);
                    }
                }
            });
            this.mGetIdentityUrlTask.executeOnExecutor(ekx.O000000o(), new Void[0]);
        }
    }

    private void O000000o(boolean z, String str) {
        Intent intent = new Intent(this, BindSafeEmailActivity.class);
        intent.putExtra("extra_has_unactivated_email", z);
        intent.putExtra("unactivated_email_address", str);
        startActivityForResult(intent, 17);
    }

    /* renamed from: com.xiaomi.passport.ui.settings.UserInfoTransparentActivity$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f6317O000000o = new int[UserInfoManager.UserInfoType.values().length];
        static final /* synthetic */ int[] O00000Oo = new int[IdentityAuthReason.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|5|6|7|8|9|10|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0027 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0032 */
        static {
            try {
                O00000Oo[IdentityAuthReason.SEND_EMAIL_ACTIVATE_MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f6317O000000o[UserInfoManager.UserInfoType.Modify_User_Phone.ordinal()] = 1;
            f6317O000000o[UserInfoManager.UserInfoType.Modify_User_Email.ordinal()] = 2;
            f6317O000000o[UserInfoManager.UserInfoType.Modify_User_Password.ordinal()] = 3;
        }
    }

    public void onPassIdentityAuth(IdentityAuthReason identityAuthReason) {
        if (identityAuthReason != null && AnonymousClass4.O00000Oo[identityAuthReason.ordinal()] == 1) {
            O000000o(false, null);
        }
    }
}
