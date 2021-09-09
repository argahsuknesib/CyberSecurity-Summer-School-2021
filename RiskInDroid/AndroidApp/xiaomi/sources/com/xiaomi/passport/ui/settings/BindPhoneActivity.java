package com.xiaomi.passport.ui.settings;

import _m_j.eez;
import _m_j.eiq;
import _m_j.ejo;
import _m_j.ejq;
import _m_j.eju;
import _m_j.ekx;
import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.data.MiuiActivatorInfo;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.account.exception.InvalidVerifyCodeException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.account.exception.ReachLimitException;
import com.xiaomi.accountsdk.account.exception.UserRestrictedException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.ParcelableAttackGuardian;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.onetrack.Analytics;
import com.xiaomi.passport.ui.settings.SimpleAsyncTask;
import com.xiaomi.passport.ui.settings.utils.UserDataProxy;
import com.xiaomi.smarthome.R;
import java.io.IOException;

public class BindPhoneActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    String f6289O000000o;
    private SimpleAsyncTask<O00000o0> O00000Oo;
    private eju O00000o;
    private SimpleAsyncTask<O00000o0> O00000o0;
    public Account mAccount;

    public interface O000000o {
        void O000000o(int i);

        void O000000o(ServerError serverError);

        void O000000o(String str);
    }

    public interface O00000Oo {
        void O000000o();

        void O000000o(int i);

        void O000000o(ServerError serverError);

        void O000000o(String str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!new ParcelableAttackGuardian().safeCheck(this)) {
            finish();
            return;
        }
        this.mAccount = MiAccountManager.O00000Oo(this).O00000oo();
        if (this.mAccount == null) {
            AccountLog.i("BindPhoneActivity", "no xiaomi account");
            finish();
            return;
        }
        this.O00000o = new eju();
        this.O00000o.setArguments(getIntent().getExtras());
        eiq.O000000o(getFragmentManager(), this.O00000o);
    }

    public void onDestroy() {
        SimpleAsyncTask<O00000o0> simpleAsyncTask = this.O00000Oo;
        if (simpleAsyncTask != null) {
            simpleAsyncTask.cancel(true);
            this.O00000Oo = null;
        }
        SimpleAsyncTask<O00000o0> simpleAsyncTask2 = this.O00000o0;
        if (simpleAsyncTask2 != null) {
            simpleAsyncTask2.cancel(true);
            this.O00000o0 = null;
        }
        super.onDestroy();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        eju eju = this.O00000o;
        if (eju != null) {
            eju.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void modifySafePhone(final String str, MiuiActivatorInfo miuiActivatorInfo, String str2, final O000000o o000000o) {
        SimpleAsyncTask<O00000o0> simpleAsyncTask = this.O00000Oo;
        if (simpleAsyncTask == null || !simpleAsyncTask.O000000o()) {
            final Context applicationContext = getApplicationContext();
            SimpleAsyncTask.O000000o O000000o2 = new SimpleAsyncTask.O000000o().O000000o(getFragmentManager(), getString(R.string.just_a_second));
            final Context context = applicationContext;
            final String str3 = str;
            final String str4 = str2;
            final MiuiActivatorInfo miuiActivatorInfo2 = miuiActivatorInfo;
            O000000o2.O00000o = new SimpleAsyncTask.O00000Oo<O00000o0>() {
                /* class com.xiaomi.passport.ui.settings.BindPhoneActivity.AnonymousClass2 */

                /* access modifiers changed from: private */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
                    r0 = e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
                    r19 = r10;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:29:0x008e, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
                    com.xiaomi.accountsdk.utils.AccountLog.e("BindPhoneActivity", "modifySafePhone", r0);
                    r4 = 11;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:31:0x0095, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:32:0x0096, code lost:
                    com.xiaomi.accountsdk.utils.AccountLog.e("BindPhoneActivity", "modifySafePhone", r0);
                    r4 = 17;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
                    r0 = e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x009d, code lost:
                    r19 = r10;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:36:0x00aa, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
                    com.xiaomi.accountsdk.utils.AccountLog.e("BindPhoneActivity", "modifySafePhone", r0);
                    r4 = 3;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b0, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b1, code lost:
                    com.xiaomi.accountsdk.utils.AccountLog.e("BindPhoneActivity", "modifySafePhone", r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c0, code lost:
                    return new com.xiaomi.passport.ui.settings.BindPhoneActivity.O00000o0(r1.O00000oO, r0.getServerError(), 3);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c1, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c2, code lost:
                    com.xiaomi.accountsdk.utils.AccountLog.e("BindPhoneActivity", "modifySafePhone", r0);
                    r4 = 4;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c7, code lost:
                    r0 = e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c8, code lost:
                    r19 = r10;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d7, code lost:
                    r0 = e;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Removed duplicated region for block: B:29:0x008e A[ExcHandler: UserRestrictedException (r0v22 'e' com.xiaomi.accountsdk.account.exception.UserRestrictedException A[CUSTOM_DECLARE]), Splitter:B:12:0x0051] */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x0095 A[ExcHandler: InvalidPhoneNumException (r0v21 'e' com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException A[CUSTOM_DECLARE]), Splitter:B:12:0x0051] */
                /* JADX WARNING: Removed duplicated region for block: B:36:0x00aa A[ExcHandler: CipherException (r0v17 'e' com.xiaomi.accountsdk.request.CipherException A[CUSTOM_DECLARE]), Splitter:B:12:0x0051] */
                /* JADX WARNING: Removed duplicated region for block: B:38:0x00b0 A[ExcHandler: InvalidResponseException (r0v15 'e' com.xiaomi.accountsdk.request.InvalidResponseException A[CUSTOM_DECLARE]), Splitter:B:12:0x0051] */
                /* JADX WARNING: Removed duplicated region for block: B:41:0x00c1 A[ExcHandler: AccessDeniedException (r0v14 'e' com.xiaomi.accountsdk.request.AccessDeniedException A[CUSTOM_DECLARE]), Splitter:B:12:0x0051] */
                /* renamed from: O00000Oo */
                public O00000o0 O000000o() {
                    int i;
                    int i2;
                    eez O000000o2 = eez.O000000o(context, "passportapi");
                    if (O000000o2 == null) {
                        AccountLog.w("BindPhoneActivity", "null passportInfo");
                        return null;
                    }
                    Account O00000oo = MiAccountManager.O00000Oo(context).O00000oo();
                    i = 5;
                    if (O00000oo == null || TextUtils.isEmpty(O00000oo.name)) {
                        return new O00000o0(null, 5);
                    }
                    UserDataProxy userDataProxy = new UserDataProxy(context);
                    String O000000o3 = userDataProxy.O000000o(BindPhoneActivity.this.mAccount, "acc_user_phone");
                    String O000000o4 = userDataProxy.O000000o(BindPhoneActivity.this.mAccount, "identity_auth_token");
                    int i3 = 0;
                    while (i3 < 2) {
                        try {
                            i2 = i3;
                            ejq.O000000o(O000000o2, str3, str4, miuiActivatorInfo2, !TextUtils.isEmpty(O000000o3), O000000o4, "passportapi");
                            Analytics.O00000o0("click_change_phone_success");
                            return new O00000o0(null, 0);
                        } catch (IOException e) {
                            e = e;
                        } catch (AuthenticationFailureException e2) {
                            e = e2;
                            AccountLog.e("BindPhoneActivity", "modifySafePhone", e);
                            O000000o2.O000000o(context);
                            i = 1;
                            i3 = i2 + 1;
                        } catch (AccessDeniedException e3) {
                        } catch (InvalidResponseException e4) {
                        } catch (CipherException e5) {
                        } catch (InvalidVerifyCodeException e6) {
                            e = e6;
                            AccountLog.e("BindPhoneActivity", "modifySafePhone", e);
                            Analytics.O00000o0("click_change_phone_submit_code_fail");
                            i = 7;
                            i3 = i2 + 1;
                        } catch (InvalidPhoneNumException e7) {
                        } catch (UserRestrictedException e8) {
                        } catch (NeedVerificationException e9) {
                            e = e9;
                            AccountLog.e("BindPhoneActivity", "modifySafePhone", e);
                            i = 15;
                            i3 = i2 + 1;
                        }
                    }
                    return new O00000o0(null, i);
                    AccountLog.e("BindPhoneActivity", "modifySafePhone", e);
                    i = 2;
                    return new O00000o0(null, i);
                }
            };
            O000000o2.O00000oO = new SimpleAsyncTask.O00000o0<O00000o0>() {
                /* class com.xiaomi.passport.ui.settings.BindPhoneActivity.AnonymousClass1 */

                public final /* synthetic */ void O000000o(Object obj) {
                    O00000o0 o00000o0 = (O00000o0) obj;
                    if (o00000o0 == null) {
                        AccountLog.i("BindPhoneActivity", "modifySafePhone result is null");
                        return;
                    }
                    ejo ejo = new ejo(o00000o0.O00000Oo);
                    if (ejo.f15526O000000o == 15) {
                        o000000o.O000000o(str);
                    } else if (!ejo.O000000o()) {
                        Intent intent = new Intent();
                        intent.putExtra("acc_user_phone", str);
                        BindPhoneActivity.this.setResult(-1, intent);
                        new UserDataProxy(applicationContext).O000000o(BindPhoneActivity.this.mAccount, "acc_user_phone", str);
                        Toast.makeText(applicationContext, (int) R.string.set_success, 1).show();
                        UserInfoManager.O000000o(BindPhoneActivity.this.getApplicationContext(), true, -1);
                        BindPhoneActivity.this.finish();
                    } else if (o00000o0.f6294O000000o == null) {
                        o000000o.O000000o(ejo.O00000Oo());
                    } else {
                        o000000o.O000000o(o00000o0.f6294O000000o);
                    }
                }
            };
            this.O00000Oo = O000000o2.O000000o();
            this.O00000Oo.executeOnExecutor(ekx.O000000o(), new Void[0]);
            return;
        }
        AccountLog.d("BindPhoneActivity", "modify safe phone task id running");
    }

    public void sendModifySafePhoneTicket(String str, String str2, String str3, final O00000Oo o00000Oo) {
        SimpleAsyncTask<O00000o0> simpleAsyncTask = this.O00000o0;
        if (simpleAsyncTask == null || !simpleAsyncTask.O000000o()) {
            final Context applicationContext = getApplicationContext();
            SimpleAsyncTask.O000000o O000000o2 = new SimpleAsyncTask.O000000o().O000000o(getFragmentManager(), getString(R.string.passport_sending_vcode));
            final Context context = applicationContext;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            O000000o2.O00000o = new SimpleAsyncTask.O00000Oo<O00000o0>() {
                /* class com.xiaomi.passport.ui.settings.BindPhoneActivity.AnonymousClass4 */

                /* access modifiers changed from: private */
                /* renamed from: O00000Oo */
                public O00000o0 O000000o() {
                    eez O000000o2 = eez.O000000o(context, "passportapi");
                    if (O000000o2 == null) {
                        AccountLog.w("BindPhoneActivity", "null passportInfo");
                        return null;
                    }
                    int i = 0;
                    int i2 = 5;
                    while (i < 2) {
                        try {
                            ejq.O00000Oo(O000000o2, str4, str5, str6, "passportapi");
                            return new O00000o0(null, 0);
                        } catch (IOException e) {
                            AccountLog.e("BindPhoneActivity", "sendModifySafePhoneTicket", e);
                            i2 = 2;
                        } catch (AuthenticationFailureException e2) {
                            AccountLog.e("BindPhoneActivity", "sendModifySafePhoneTicket", e2);
                            O000000o2.O000000o(context);
                            i++;
                            i2 = 1;
                        } catch (AccessDeniedException e3) {
                            AccountLog.e("BindPhoneActivity", "sendModifySafePhoneTicket", e3);
                            i2 = 4;
                        } catch (InvalidResponseException e4) {
                            AccountLog.e("BindPhoneActivity", "sendModifySafePhoneTicket", e4);
                            return new O00000o0(e4.getServerError(), 3);
                        } catch (CipherException e5) {
                            AccountLog.e("BindPhoneActivity", "sendModifySafePhoneTicket", e5);
                            i2 = 3;
                        } catch (InvalidPhoneNumException e6) {
                            AccountLog.e("BindPhoneActivity", "sendModifySafePhoneTicket", e6);
                            i2 = 17;
                        } catch (ReachLimitException e7) {
                            AccountLog.e("BindPhoneActivity", "sendModifySafePhoneTicket", e7);
                            i2 = 10;
                        } catch (NeedCaptchaException e8) {
                            AccountLog.e("BindPhoneActivity", "sendModifySafePhoneTicket", e8);
                            i2 = 12;
                            BindPhoneActivity.this.f6289O000000o = e8.getCaptchaUrl();
                        }
                    }
                    return new O00000o0(null, i2);
                }
            };
            O000000o2.O00000oO = new SimpleAsyncTask.O00000o0<O00000o0>() {
                /* class com.xiaomi.passport.ui.settings.BindPhoneActivity.AnonymousClass3 */

                public final /* synthetic */ void O000000o(Object obj) {
                    O00000o0 o00000o0 = (O00000o0) obj;
                    if (o00000o0 == null) {
                        AccountLog.i("BindPhoneActivity", "send ticket result is null");
                        return;
                    }
                    ejo ejo = new ejo(o00000o0.O00000Oo);
                    if (ejo.f15526O000000o == 12) {
                        o00000Oo.O000000o(BindPhoneActivity.this.f6289O000000o);
                    } else if (!ejo.O000000o()) {
                        Toast.makeText(applicationContext, (int) R.string.sms_send_success, 1).show();
                        o00000Oo.O000000o();
                    } else if (o00000o0.f6294O000000o != null) {
                        o00000Oo.O000000o(o00000o0.f6294O000000o);
                    } else {
                        o00000Oo.O000000o(ejo.O00000Oo());
                    }
                }
            };
            this.O00000o0 = O000000o2.O000000o();
            this.O00000o0.executeOnExecutor(ekx.O000000o(), new Void[0]);
            return;
        }
        AccountLog.d("BindPhoneActivity", "send modify phone ticket task is running");
    }

    public class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public ServerError f6294O000000o;
        int O00000Oo;

        O00000o0(ServerError serverError, int i) {
            this.f6294O000000o = serverError;
            this.O00000Oo = i;
        }
    }
}
