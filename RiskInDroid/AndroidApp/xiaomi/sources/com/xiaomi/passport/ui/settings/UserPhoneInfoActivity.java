package com.xiaomi.passport.ui.settings;

import _m_j.egc;
import _m_j.ejr;
import _m_j.ejx;
import _m_j.eks;
import _m_j.ekx;
import android.accounts.Account;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.data.IdentityAuthReason;
import com.xiaomi.accountsdk.account.data.NotificationAuthResult;
import com.xiaomi.accountsdk.account.stat.AccountStatInterface;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.ParcelableAttackGuardian;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.smarthome.R;

public class UserPhoneInfoActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private MiAccountManager f6318O000000o;
    private ejx O00000Oo;
    private ejx.O000000o O00000o0 = new ejx.O000000o() {
        /* class com.xiaomi.passport.ui.settings.UserPhoneInfoActivity.AnonymousClass1 */

        public final void O000000o() {
            UserPhoneInfoActivity.this.refreshUpdatePhoneInfo();
        }
    };
    public Account mAccount;
    public ejr mGetPhoneIdentityAuthTask;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
            return;
        }
        setContentView((int) R.layout.user_phone_info);
        this.f6318O000000o = MiAccountManager.O00000Oo(this);
        this.mAccount = this.f6318O000000o.O00000oo();
        if (this.mAccount == null) {
            AccountLog.i("UserPhoneInfoActivity", "no xiaomi account");
            finish();
            return;
        }
        O000000o(findViewById(R$id.use_sign_in), R.drawable.icon_sign_in, R.string.sign_in);
        O000000o(findViewById(R$id.use_get_back_pwd), R.drawable.icon_get_back_pwd, R.string.get_back_pwd);
        O000000o(findViewById(R$id.use_identity), R.drawable.icon_identity, R.string.identity);
        refreshUpdatePhoneInfo();
        if (this.O00000Oo == null || AsyncTask.Status.RUNNING != this.O00000Oo.getStatus()) {
            this.O00000Oo = new ejx(this, this.O00000o0);
            this.O00000Oo.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void onResume() {
        super.onResume();
        AccountStatInterface.getInstance().statPageStart("UserPhoneInfoActivity");
    }

    public void onPause() {
        AccountStatInterface.getInstance().statPageEnd("UserPhoneInfoActivity");
        super.onPause();
    }

    public void onDestroy() {
        ejr ejr = this.mGetPhoneIdentityAuthTask;
        if (ejr != null) {
            ejr.cancel(true);
            this.mGetPhoneIdentityAuthTask = null;
        }
        super.onDestroy();
    }

    public void onClick(View view) {
        if (view.getId() == R$id.action_btn && this.mGetPhoneIdentityAuthTask == null) {
            this.mGetPhoneIdentityAuthTask = new ejr(this, new UserDataProxy(this).O000000o(this.mAccount, "identity_auth_token"), IdentityAuthReason.MODIFY_SAFE_PHONE, new ejr.O000000o() {
                /* class com.xiaomi.passport.ui.settings.UserPhoneInfoActivity.AnonymousClass2 */

                public final void O000000o(String str) {
                    UserPhoneInfoActivity userPhoneInfoActivity = UserPhoneInfoActivity.this;
                    userPhoneInfoActivity.mGetPhoneIdentityAuthTask = null;
                    Intent O000000o2 = eks.O000000o(userPhoneInfoActivity, null, str, "passportapi", null);
                    O000000o2.putExtra("userId", UserPhoneInfoActivity.this.mAccount.name);
                    UserPhoneInfoActivity.this.startActivityForResult(O000000o2, 10001);
                }

                public final void O000000o() {
                    UserPhoneInfoActivity userPhoneInfoActivity = UserPhoneInfoActivity.this;
                    userPhoneInfoActivity.mGetPhoneIdentityAuthTask = null;
                    userPhoneInfoActivity.startUpdateSafePhone();
                }

                public final void O000000o(int i) {
                    UserPhoneInfoActivity userPhoneInfoActivity = UserPhoneInfoActivity.this;
                    userPhoneInfoActivity.mGetPhoneIdentityAuthTask = null;
                    Toast.makeText(userPhoneInfoActivity, i, 1).show();
                    UserInfoManager.O000000o(UserPhoneInfoActivity.this.getApplicationContext(), false, i);
                }

                public final void O000000o(ServerError serverError) {
                    UserPhoneInfoActivity userPhoneInfoActivity = UserPhoneInfoActivity.this;
                    userPhoneInfoActivity.mGetPhoneIdentityAuthTask = null;
                    if (!userPhoneInfoActivity.isFinishing()) {
                        egc.O000000o o000000o = egc.O00000Oo;
                        egc.O000000o.O000000o(UserPhoneInfoActivity.this, serverError);
                    }
                }
            });
            this.mGetPhoneIdentityAuthTask.executeOnExecutor(ekx.O000000o(), new Void[0]);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        NotificationAuthResult notificationAuthResult;
        super.onActivityResult(i, i2, intent);
        if (i != 10001) {
            if (i == 10002 && i2 == -1) {
                refreshUpdatePhoneInfo();
            }
        } else if (i2 == -1 && (notificationAuthResult = (NotificationAuthResult) intent.getParcelableExtra("notification_auth_end")) != null) {
            new UserDataProxy(this).O000000o(this.mAccount, "identity_auth_token", notificationAuthResult.serviceToken);
            startUpdateSafePhone();
        }
    }

    public void refreshUpdatePhoneInfo() {
        String O000000o2 = new UserDataProxy(this).O000000o(this.mAccount, "acc_user_phone");
        boolean isEmpty = TextUtils.isEmpty(O000000o2);
        ImageView imageView = (ImageView) findViewById(R$id.icon_phone);
        int i = 8;
        if (imageView != null) {
            imageView.setVisibility(isEmpty ? 8 : 0);
        }
        TextView textView = (TextView) findViewById(R$id.phone_num);
        if (textView != null) {
            if (isEmpty) {
                O000000o2 = getString(R.string.no_phone);
            }
            textView.setText(O000000o2);
        }
        TextView textView2 = (TextView) findViewById(R$id.update_phone_notice);
        if (textView2 != null) {
            if (!isEmpty) {
                i = 0;
            }
            textView2.setVisibility(i);
        }
        Button button = (Button) findViewById(R$id.action_btn);
        if (button != null) {
            button.setText(isEmpty ? R.string.action_add_phone : R.string.action_update_phone);
            button.setOnClickListener(this);
        }
    }

    private void O000000o(View view, int i, int i2) {
        if (view != null) {
            ImageView imageView = (ImageView) view.findViewById(R$id.icon);
            if (imageView != null) {
                imageView.setImageDrawable(getResources().getDrawable(i));
            }
            TextView textView = (TextView) view.findViewById(R$id.icon_desc);
            if (textView != null) {
                textView.setText(i2);
            }
        }
    }

    public void startUpdateSafePhone() {
        Intent intent = new Intent(this, BindPhoneActivity.class);
        intent.setPackage(getPackageName());
        startActivityForResult(intent, 10002);
    }
}
