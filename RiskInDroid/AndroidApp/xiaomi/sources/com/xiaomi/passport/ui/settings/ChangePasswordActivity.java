package com.xiaomi.passport.ui.settings;

import _m_j.eez;
import _m_j.egc;
import _m_j.ehh;
import _m_j.ejq;
import _m_j.ejr;
import _m_j.ekq;
import _m_j.eks;
import _m_j.ekx;
import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.IdentityAuthReason;
import com.xiaomi.accountsdk.account.data.NotificationAuthResult;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidParameterException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.passport.ui.settings.SimpleAsyncTask;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.passport.ui.settings.widget.PasswordView;
import com.xiaomi.smarthome.R;
import java.io.IOException;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    final TextWatcher f6301O000000o = new TextWatcher() {
        /* class com.xiaomi.passport.ui.settings.ChangePasswordActivity.AnonymousClass5 */

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            ChangePasswordActivity.this.updateErrorMsgView(false, -1);
        }
    };
    private SimpleAsyncTask<O000000o> O00000Oo;
    private PasswordView O00000o;
    private TextView O00000o0;
    private PasswordView O00000oO;
    private View O00000oo;
    private View O0000O0o;
    public Account mAccount;
    public ejr mGetIdentityUrlTask;
    public IdentityAuthReason mIdentityAuthReason;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.change_pwd_layout);
        this.O0000O0o = findViewById(16908290);
        this.O00000oo = findViewById(R$id.change_pwd_btn);
        this.O00000oo.setOnClickListener(this);
        this.O00000o0 = (TextView) findViewById(R$id.error_status);
        this.O00000o = (PasswordView) findViewById(R$id.input_new_pwd_view);
        this.O00000o.O000000o(this.f6301O000000o);
        this.O00000oO = (PasswordView) findViewById(R$id.confirm_pwd_view);
        this.O00000oO.O000000o(this.f6301O000000o);
        this.mAccount = MiAccountManager.O00000Oo(getApplicationContext()).O00000oo();
        findViewById(R$id.back).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.passport.ui.settings.ChangePasswordActivity.AnonymousClass1 */

            public final void onClick(View view) {
                ChangePasswordActivity.this.onBackPressed();
            }
        });
        O000000o(false);
        if (this.mAccount == null) {
            finish();
            return;
        }
        IdentityAuthReason identityAuthReason = IdentityAuthReason.CHANGE_PASSWORD;
        if (this.mGetIdentityUrlTask == null) {
            this.mIdentityAuthReason = identityAuthReason;
            String O000000o2 = new UserDataProxy(this).O000000o(this.mAccount, "identity_auth_token");
            final ehh ehh = new ehh();
            ehh.O000000o(this);
            this.mGetIdentityUrlTask = new ejr(this, O000000o2, identityAuthReason, new ejr.O000000o() {
                /* class com.xiaomi.passport.ui.settings.ChangePasswordActivity.AnonymousClass2 */

                public final void O000000o(int i) {
                    ChangePasswordActivity changePasswordActivity = ChangePasswordActivity.this;
                    changePasswordActivity.mGetIdentityUrlTask = null;
                    Toast.makeText(changePasswordActivity, i, 1).show();
                    ehh.O000000o();
                }

                public final void O000000o(String str) {
                    ChangePasswordActivity changePasswordActivity = ChangePasswordActivity.this;
                    changePasswordActivity.mGetIdentityUrlTask = null;
                    Intent O000000o2 = eks.O000000o(changePasswordActivity, null, str, "passportapi", null);
                    O000000o2.putExtra("userId", ChangePasswordActivity.this.mAccount.name);
                    O000000o2.putExtra("passToken", eks.O00000o0(ChangePasswordActivity.this.getApplicationContext(), ChangePasswordActivity.this.mAccount));
                    ChangePasswordActivity.this.startActivityForResult(O000000o2, 16);
                    ChangePasswordActivity.this.overridePendingTransition(0, 0);
                    ehh.O000000o();
                }

                public final void O000000o() {
                    ChangePasswordActivity changePasswordActivity = ChangePasswordActivity.this;
                    changePasswordActivity.mGetIdentityUrlTask = null;
                    changePasswordActivity.onPassIdentityAuth(changePasswordActivity.mIdentityAuthReason);
                    ehh.O000000o();
                }

                public final void O000000o(ServerError serverError) {
                    ChangePasswordActivity changePasswordActivity = ChangePasswordActivity.this;
                    changePasswordActivity.mGetIdentityUrlTask = null;
                    if (!changePasswordActivity.isFinishing()) {
                        egc.O000000o o000000o = egc.O00000Oo;
                        egc.O000000o.O000000o(ChangePasswordActivity.this, serverError);
                    }
                }
            });
            this.mGetIdentityUrlTask.executeOnExecutor(ekx.O000000o(), new Void[0]);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onResume() {
        super.onResume();
        this.mAccount = MiAccountManager.O00000Oo(getApplicationContext()).O00000oo();
        if (this.mAccount == null) {
            finish();
        }
    }

    public void onDestroy() {
        SimpleAsyncTask<O000000o> simpleAsyncTask = this.O00000Oo;
        if (simpleAsyncTask != null) {
            simpleAsyncTask.cancel(true);
            this.O00000Oo = null;
        }
        ejr ejr = this.mGetIdentityUrlTask;
        if (ejr != null) {
            ejr.cancel(true);
            this.mGetIdentityUrlTask = null;
        }
        super.onDestroy();
    }

    public void onClick(View view) {
        if (view == this.O00000oo) {
            String password = this.O00000o.getPassword();
            final String str = null;
            if (!TextUtils.isEmpty(password)) {
                String password2 = this.O00000oO.getPassword();
                if (!TextUtils.isEmpty(password2)) {
                    if (!TextUtils.equals(password, password2)) {
                        this.O00000oO.setError(getString(R.string.inconsistent_pwd));
                    } else {
                        str = password;
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                AccountLog.w("ChangePasswordActivity", "no valid newPwd");
                return;
            }
            final Context applicationContext = getApplicationContext();
            SimpleAsyncTask.O000000o O000000o2 = new SimpleAsyncTask.O000000o().O000000o(getFragmentManager(), getString(R.string.just_a_second));
            O000000o2.O00000o = new SimpleAsyncTask.O00000Oo<O000000o>() {
                /* class com.xiaomi.passport.ui.settings.ChangePasswordActivity.AnonymousClass4 */

                /* access modifiers changed from: private */
                /* renamed from: O00000Oo */
                public O000000o O000000o() {
                    SimpleAsyncTask.ResultType resultType;
                    ServerError serverError;
                    eez O000000o2 = eez.O000000o(applicationContext, "passportapi");
                    SimpleAsyncTask.ResultType resultType2 = SimpleAsyncTask.ResultType.ERROR_UNKNOWN;
                    try {
                        AccountInfo build = new AccountInfo.Builder().userId(O000000o2.getUserId()).passToken(ejq.O000000o(O000000o2, eks.O00000o0(applicationContext, ChangePasswordActivity.this.mAccount), str, new UserDataProxy(applicationContext).O000000o(ChangePasswordActivity.this.mAccount, "identity_auth_token"), "passportapi")).hasPwd(true).build();
                        eks.O00000Oo(applicationContext, build);
                        ChangePasswordActivity.this.handleResponse(ekq.O000000o(build, ChangePasswordActivity.this.getIntent().getBooleanExtra("need_retry_on_authenticator_response_result", false)));
                        return new O000000o(null, SimpleAsyncTask.ResultType.SUCCESS);
                    } catch (AccessDeniedException e) {
                        AccountLog.e("ChangePasswordActivity", "changePassword", e);
                        resultType = SimpleAsyncTask.ResultType.ERROR_ACCESS_DENIED;
                        return new O000000o(null, resultType);
                    } catch (AuthenticationFailureException e2) {
                        AccountLog.e("ChangePasswordActivity", "changePassword", e2);
                        resultType = SimpleAsyncTask.ResultType.ERROR_AUTH_FAIL;
                        return new O000000o(null, resultType);
                    } catch (IOException e3) {
                        AccountLog.e("ChangePasswordActivity", "changePassword", e3);
                        resultType = SimpleAsyncTask.ResultType.ERROR_NETWORK;
                        return new O000000o(null, resultType);
                    } catch (InvalidCredentialException e4) {
                        AccountLog.e("ChangePasswordActivity", "changePassword", e4);
                        resultType = SimpleAsyncTask.ResultType.ERROR_AUTH_FAIL;
                        return new O000000o(null, resultType);
                    } catch (InvalidParameterException e5) {
                        AccountLog.e("ChangePasswordActivity", "changePassword", e5);
                        resultType = SimpleAsyncTask.ResultType.ERROR_SAME_NEW_AND_OLD_PASS;
                        return new O000000o(null, resultType);
                    } catch (CipherException | InvalidResponseException e6) {
                        AccountLog.e("ChangePasswordActivity", "changePassword", e6);
                        resultType = SimpleAsyncTask.ResultType.ERROR_SERVER;
                        if ((e6 instanceof InvalidResponseException) && (serverError = ((InvalidResponseException) e6).getServerError()) != null) {
                            return new O000000o(serverError, resultType);
                        }
                        return new O000000o(null, resultType);
                    }
                }
            };
            O000000o2.O00000oO = new SimpleAsyncTask.O00000o0<O000000o>() {
                /* class com.xiaomi.passport.ui.settings.ChangePasswordActivity.AnonymousClass3 */

                public final /* synthetic */ void O000000o(Object obj) {
                    O000000o o000000o = (O000000o) obj;
                    if (o000000o.O00000Oo.success()) {
                        Toast.makeText(applicationContext, (int) R.string.set_success, 1).show();
                        ChangePasswordActivity.this.setResult(-1);
                        UserInfoManager.O00000Oo(ChangePasswordActivity.this.getApplicationContext(), true, -1);
                        ChangePasswordActivity.this.finish();
                        Analytics.O00000o0("click_change_pwd_success");
                        return;
                    }
                    ChangePasswordActivity.this.updateErrorMsgView(true, o000000o.O00000Oo.getErrorMessageResId());
                    if (o000000o.f6308O000000o != null && !ChangePasswordActivity.this.isFinishing()) {
                        egc.O000000o o000000o2 = egc.O00000Oo;
                        egc.O000000o.O000000o(ChangePasswordActivity.this, o000000o.f6308O000000o);
                    }
                    Analytics.O00000o0("click_change_pwd_fail");
                }
            };
            this.O00000Oo = O000000o2.O000000o();
            this.O00000Oo.executeOnExecutor(ekx.O000000o(), new Void[0]);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AccountLog.d("ChangePasswordActivity", "onActivityResult() requestCode:" + i + " resultCode:" + i2);
        if (i2 != -1) {
            UserInfoManager.O00000Oo(getApplicationContext(), false, i2);
            setResult(i2);
            finish();
        }
        if (i == 16 && i2 == -1) {
            NotificationAuthResult notificationAuthResult = (NotificationAuthResult) intent.getParcelableExtra("notification_auth_end");
            if (notificationAuthResult != null) {
                new UserDataProxy(this).O000000o(this.mAccount, "identity_auth_token", notificationAuthResult.serviceToken);
                onPassIdentityAuth(this.mIdentityAuthReason);
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    /* renamed from: com.xiaomi.passport.ui.settings.ChangePasswordActivity$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f6307O000000o = new int[IdentityAuthReason.values().length];

        static {
            try {
                f6307O000000o[IdentityAuthReason.CHANGE_PASSWORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onPassIdentityAuth(IdentityAuthReason identityAuthReason) {
        if (identityAuthReason != null && AnonymousClass6.f6307O000000o[identityAuthReason.ordinal()] == 1) {
            O000000o(true);
        }
    }

    private void O000000o(boolean z) {
        View view = this.O0000O0o;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void handleResponse(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            eks.O000000o(intent.getParcelableExtra("accountAuthenticatorResponse"), bundle);
        }
    }

    public void updateErrorMsgView(boolean z, int i) {
        this.O00000o0.setVisibility(z ? 0 : 8);
        if (i != -1) {
            this.O00000o0.setText(i);
        }
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ChangePasswordActivity.class);
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public ServerError f6308O000000o;
        SimpleAsyncTask.ResultType O00000Oo;

        O000000o(ServerError serverError, SimpleAsyncTask.ResultType resultType) {
            this.f6308O000000o = serverError;
            this.O00000Oo = resultType;
        }
    }
}
