package com.xiaomi.passport.ui.page;

import _m_j.ee;
import _m_j.efp;
import _m_j.eft;
import _m_j.efv;
import _m_j.efw;
import _m_j.ega;
import _m_j.ege;
import _m_j.egs;
import _m_j.egt;
import _m_j.eha;
import _m_j.ehc;
import _m_j.ehq;
import _m_j.ehr;
import _m_j.ei;
import _m_j.eie;
import _m_j.eif;
import _m_j.eih;
import _m_j.eij;
import _m_j.eik;
import _m_j.eiu;
import _m_j.eiw;
import _m_j.eiy;
import _m_j.eiz;
import _m_j.ejd;
import _m_j.eje;
import _m_j.ejf;
import _m_j.eji;
import _m_j.ekk;
import _m_j.ekl;
import _m_j.ekm;
import _m_j.ekn;
import _m_j.eko;
import _m_j.ekq;
import _m_j.eks;
import _m_j.ft;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import _m_j.oOOO00o0;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.accountsdk.account.data.PhoneTicketLoginParams;
import com.xiaomi.accountsdk.account.data.PhoneTokenRegisterParams;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.data.PhoneAccount;
import com.xiaomi.passport.ui.internal.PhoneWrapper;
import com.xiaomi.passport.ui.internal.util.LinkSpanHelper;
import com.xiaomi.passport.ui.logiccontroller.CountryNameChooser;
import com.xiaomi.passport.ui.utils.AccountLoginer$4;
import com.xiaomi.passport.ui.utils.AccountLoginer$6;
import com.xiaomi.passport.ui.view.AccountLoginPageFooter;
import com.xiaomi.passport.ui.view.AccountLoginPageHeader;
import com.xiaomi.passport.ui.view.LoadingDialog;
import com.xiaomi.passport.uicontroller.SimpleFutureTask;
import com.xiaomi.phonenum.data.AccountCertification;
import com.xiaomi.phonenum.procedure.AccountPhoneNumberManagerFactory;
import com.xiaomi.phonenum.procedure.AccountPhoneNumberSourceFlag;
import com.xiaomi.phonenum.procedure.MiuiAccountPhoneNumberManager;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class AccountLoginActivity extends AppCompatActivity implements efp, ekk, ekl, AccountLoginPageFooter.O000000o, AccountLoginPageHeader.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private AccountLoginPageHeader f6269O000000o;
    private AccountLoginPageFooter O00000Oo;
    private ee.O000000o O00000o;
    private int O00000o0;
    private ekn O00000oO;
    private eko O00000oo;
    private CountryNameChooser O0000O0o;
    private LoadingDialog O0000OOo;
    public String sid;

    public void onRequestSmsOrPwdLogin(efw efw, efv efv) {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0155, code lost:
        if (r9.equals("FACEBOOK_AUTH_PROVIDER") != false) goto L_0x0163;
     */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XMPassportSettings.ensureApplicationContext(getApplication());
        setContentView((int) R.layout.passport_activity_account_login);
        getWindow().getDecorView().setBackgroundResource(R.drawable.passport_phone_number_login_bg);
        Intent intent = getIntent();
        this.sid = intent.getStringExtra("service_id");
        if (!TextUtils.isEmpty(this.sid)) {
            char c = 0;
            this.O00000o0 = intent.getIntExtra("account_phone_number_source_flag", 0);
            this.f6269O000000o = (AccountLoginPageHeader) findViewById(R$id.header);
            this.f6269O000000o.setOnActionListener(this);
            this.f6269O000000o.O000000o(intent.getStringExtra("choose_country_init_text"));
            this.O00000Oo = (AccountLoginPageFooter) findViewById(R$id.footer);
            this.O00000Oo.setOnActionClickListener(this);
            this.O00000o = new ee.O000000o() {
                /* class com.xiaomi.passport.ui.page.AccountLoginActivity.AnonymousClass1 */

                public final void O000000o(Fragment fragment) {
                    AccountLoginActivity.this.updateHeaderAndFooterWhenFragmentChanged(fragment);
                }
            };
            getSupportFragmentManager().O000000o(this.O00000o, true);
            this.O00000oo = new eko(this);
            this.O00000oO = new ekn(this, this, this.sid);
            ekn ekn = this.O00000oO;
            ft.O000000o(ekn.f15574O000000o).O000000o(ekn.O00000o0, new IntentFilter("passport_sns_events"));
            Parcelable parcelableExtra = intent.getParcelableExtra("choose_country_intent");
            if (parcelableExtra != null) {
                this.O0000O0o = new CountryNameChooser((Intent) parcelableExtra);
            }
            this.O0000OOo = new LoadingDialog(this);
            this.O0000OOo.setCancelable(false);
            egt egt = egt.f15254O000000o;
            if (egt.O00000oO()) {
                AccountLog.i("AccountLoginActivity", "gotoDefaultManualInputLoginFragment when international");
                O00000Oo();
            } else {
                Class<AccountPhoneNumberManagerFactory> cls = AccountPhoneNumberManagerFactory.class;
                try {
                    AccountLog.i("AccountLoginActivity", "import phone-num-keep lib, goto query");
                    AccountPhoneNumberSourceFlag accountPhoneNumberSourceFlag = new AccountPhoneNumberSourceFlag(this.O00000o0);
                    if (!accountPhoneNumberSourceFlag.isValid()) {
                        O00000Oo();
                    } else if (MiuiAccountPhoneNumberManager.isAccountPhoneNumberManagerServiceExists(this)) {
                        O000000o();
                    } else if (!accountPhoneNumberSourceFlag.containsFlag(2)) {
                        O000000o();
                    } else if (ContextCompat.O000000o(this, "android.permission.READ_PHONE_STATE") == 0) {
                        O000000o();
                    } else {
                        oOOO00o0.O000000o(this, new String[]{"android.permission.READ_PHONE_STATE"}, 5647);
                    }
                } catch (NoClassDefFoundError unused) {
                    AccountLog.e("AccountLoginActivity", "not import phone-num-keep lib, goto other ways");
                    O00000Oo();
                }
            }
            String stringExtra = getIntent().getStringExtra("sns_sign_in");
            if (!TextUtils.isEmpty(stringExtra)) {
                ekn ekn2 = this.O00000oO;
                switch (stringExtra.hashCode()) {
                    case -2108095153:
                        if (stringExtra.equals("WECHAT_AUTH_PROVIDER")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 41040111:
                        break;
                    case 980055921:
                        if (stringExtra.equals("WEIBO_AUTH_PROVIDER")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1157878473:
                        if (stringExtra.equals("QQ_AUTH_PROVIDER")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1685682978:
                        if (stringExtra.equals("GOOGLE_AUTH_PROVIDER")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    ekn2.O000000o();
                } else if (c == 1) {
                    ekn2.O00000Oo();
                } else if (c == 2) {
                    ekn2.O00000o0();
                } else if (c == 3) {
                    ekn2.O00000o();
                } else if (c == 4) {
                    ekn2.O00000oO();
                } else {
                    throw new IllegalStateException("can not find sns provider: ".concat(String.valueOf(stringExtra)));
                }
            }
        } else {
            throw new IllegalStateException("sid / serviceId / authType can not be empty");
        }
    }

    public void onResume() {
        super.onResume();
        ekn ekn = this.O00000oO;
        ehr.O000000o o000000o = ehr.O0000O0o;
        ehq ehq = ehr.O00000oo;
        if (ehq != null) {
            ehr.O000000o o000000o2 = ehr.O0000O0o;
            ehr.O00000oo = null;
            egt egt = egt.f15254O000000o;
            ekn.O000000o((ehr) egt.O000000o(ehq), ehq);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        getSupportFragmentManager().O000000o(this.O00000o);
        ekn ekn = this.O00000oO;
        ft.O000000o(ekn.f15574O000000o).O000000o(ekn.O00000o0);
        eko eko = this.O00000oo;
        if (eko.O00000o0 != null) {
            eko.O00000o0.cancel(true);
            eko.O00000o0 = null;
        }
        dismissLoadingView();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 5647) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            O00000Oo();
        } else {
            O000000o();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ekn ekn = this.O00000oO;
        ArrayList arrayList = new ArrayList();
        arrayList.add("FACEBOOK_AUTH_PROVIDER");
        arrayList.add("GOOGLE_AUTH_PROVIDER");
        arrayList.add("WEIBO_AUTH_PROVIDER");
        arrayList.add("QQ_AUTH_PROVIDER");
        arrayList.add("WECHAT_AUTH_PROVIDER");
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            egt egt = egt.f15254O000000o;
            eft O000000o2 = egt.O000000o((String) it.next());
            if (O000000o2 instanceof ehr) {
                ehr ehr = (ehr) O000000o2;
                if (i == ehr.O000000o()) {
                    ehr.O000000o(ekn.f15574O000000o, i, i2, intent);
                    ehr.O000000o o000000o = ehr.O0000O0o;
                    ehq ehq = ehr.O00000oo;
                    if (ehq != null) {
                        ehr.O000000o o000000o2 = ehr.O0000O0o;
                        ehr.O00000oo = null;
                        ekn.O000000o(ehr, ehq);
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        if (this.O0000O0o == null) {
            return;
        }
        if (i == 8880) {
            if (i2 == -1) {
                try {
                    String stringExtra = intent.getStringExtra("countryName");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        this.f6269O000000o.O000000o(stringExtra);
                        return;
                    }
                } catch (CountryNameChooser.ChooseNoneException unused) {
                    AccountLog.e("AccountLoginActivity", "failed get country name");
                    return;
                } catch (CountryNameChooser.NotChooseActionException e) {
                    AccountLog.e("AccountLoginActivity", "onActivityResult", e);
                    return;
                }
            }
            throw new CountryNameChooser.ChooseNoneException();
        }
        throw new CountryNameChooser.NotChooseActionException();
    }

    public void onBackPressed() {
        goBack(false);
    }

    private void O000000o() {
        gotoFragment(eji.O000000o(this.sid, this.O00000o0), false);
    }

    private void O00000Oo() {
        eft eft;
        String str;
        egt egt = egt.f15254O000000o;
        efw O0000O0o2 = egt.O0000O0o();
        String stringExtra = getIntent().getStringExtra("default_auth_provider");
        if (TextUtils.isEmpty(stringExtra)) {
            eft = null;
        } else {
            egt egt2 = egt.f15254O000000o;
            eft = egt.O000000o(stringExtra);
        }
        if (eft instanceof efw) {
            O0000O0o2 = (efw) eft;
        }
        ehc.O000000o O000000o2 = ege.O000000o(this, getIntent().getStringExtra("default_phone_country_code"));
        if (O000000o2 == null) {
            str = null;
        } else {
            str = ege.O000000o(O000000o2);
        }
        gotoFragment(O0000O0o2.O000000o(this.sid, str), false);
        updateUserAgreement(null);
    }

    public void updateHeaderAndFooterWhenFragmentChanged(Fragment fragment) {
        if (!(fragment instanceof ekm)) {
            this.f6269O000000o.O000000o(true);
            ehr.O000000o o000000o = ehr.O0000O0o;
            if (ehr.O000000o.O000000o()) {
                this.O00000Oo.O000000o(false);
            } else if (fragment instanceof eij) {
                this.O00000Oo.setVisibility(8);
            } else if (fragment instanceof eha) {
                this.O00000Oo.setVisibility(8);
            } else {
                this.O00000Oo.O000000o(true);
            }
        }
    }

    public void onSkipQueryPhoneAccount() {
        O00000Oo();
    }

    public void onQueryPhoneAccountFailed() {
        O00000Oo();
    }

    public void onUseManualInputLogin() {
        O00000Oo();
    }

    public void onRequestPhoneLogin(final PhoneAccount phoneAccount) {
        if (!this.O00000Oo.f6327O000000o.isChecked()) {
            Toast.makeText(this, (int) R.string.passport_error_user_agreement_error, 0).show();
            return;
        }
        this.O0000OOo.O000000o((int) R.string.doing_login);
        eko eko = this.O00000oo;
        String str = this.sid;
        AnonymousClass2 r2 = new eko.O00000Oo() {
            /* class com.xiaomi.passport.ui.page.AccountLoginActivity.AnonymousClass2 */

            public final void O000000o(AccountInfo accountInfo) {
                AccountLoginActivity.this.dismissLoadingView();
                AccountLoginActivity.this.loginSuccess(accountInfo);
            }
        };
        AnonymousClass3 r3 = new eko.O000000o() {
            /* class com.xiaomi.passport.ui.page.AccountLoginActivity.AnonymousClass3 */

            public final void O000000o(Throwable th) {
                AccountLoginActivity.this.dismissLoadingView();
                AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                eiw.O000000o(accountLoginActivity, accountLoginActivity, accountLoginActivity.sid, phoneAccount).O00000Oo(AccountLoginActivity.this.getApplicationContext(), th);
            }
        };
        if (eko.O00000o0 == null) {
            PhoneTicketLoginParams build = new PhoneTicketLoginParams.Builder().serviceId(str).verifiedActivatorPhone(new ActivatorPhoneInfo.Builder().phoneHash(phoneAccount.f6215O000000o.hashedPhoneNumber).activatorToken(phoneAccount.f6215O000000o.activatorToken).build()).build();
            eko.O00000o0 = new SimpleFutureTask<>(new AccountLoginer$4(eko, build, str, phoneAccount), new SimpleFutureTask.O000000o<AccountInfo>(r2, r3) {
                /* class _m_j.eko.AnonymousClass3 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000Oo f15579O000000o;
                final /* synthetic */ O000000o O00000Oo;

                {
                    this.f15579O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final void O000000o(SimpleFutureTask<AccountInfo> simpleFutureTask) {
                    try {
                        AccountInfo accountInfo = (AccountInfo) simpleFutureTask.get();
                        if (eks.O00000Oo(eko.this.O00000Oo, accountInfo)) {
                            this.f15579O000000o.O000000o(accountInfo);
                        } else {
                            this.O00000Oo.O000000o(new IllegalStateException("addOrUpdateAccountManager failed"));
                        }
                    } catch (InterruptedException e) {
                        this.O00000Oo.O000000o(e);
                    } catch (CancellationException e2) {
                        this.O00000Oo.O000000o(e2);
                    } catch (ExecutionException e3) {
                        this.O00000Oo.O000000o(e3.getCause());
                    } finally {
                        eko.this.O00000o0 = null;
                    }
                }
            });
            eko.f15576O000000o.submit(eko.O00000o0);
            return;
        }
        throw new IllegalStateException("exists running task");
    }

    public void onRequestSnsLogin(final ehr ehr, final ehq ehq) {
        eko eko = this.O00000oo;
        AnonymousClass4 r1 = new eko.O00000Oo() {
            /* class com.xiaomi.passport.ui.page.AccountLoginActivity.AnonymousClass4 */

            public final void O000000o(AccountInfo accountInfo) {
                AccountLoginActivity.this.loginSuccess(accountInfo);
            }
        };
        AnonymousClass5 r2 = new eko.O000000o() {
            /* class com.xiaomi.passport.ui.page.AccountLoginActivity.AnonymousClass5 */

            public final void O000000o(Throwable th) {
                AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                new eiz(accountLoginActivity, new ejf(ehr, accountLoginActivity, new eje(accountLoginActivity, new ejd(new eiy(new eiu()))))).O00000Oo(AccountLoginActivity.this.getApplicationContext(), th);
            }
        };
        ehr.O00000Oo(eko.O00000Oo, ehq).O000000o(new iwc<AccountInfo, iuh>(r1, r2) {
            /* class _m_j.eko.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000Oo f15577O000000o;
            final /* synthetic */ O000000o O00000Oo;

            {
                this.f15577O000000o = r2;
                this.O00000Oo = r3;
            }

            public final /* synthetic */ Object invoke(Object obj) {
                AccountInfo accountInfo = (AccountInfo) obj;
                if (eks.O00000Oo(eko.this.O00000Oo, accountInfo)) {
                    this.f15577O000000o.O000000o(accountInfo);
                    return null;
                }
                this.O00000Oo.O000000o(new IllegalStateException("addOrUpdateAccountManager failed"));
                return null;
            }
        }, new iwc<Throwable, iuh>(r2) {
            /* class _m_j.eko.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O000000o f15578O000000o;

            {
                this.f15578O000000o = r2;
            }

            public final /* synthetic */ Object invoke(Object obj) {
                this.f15578O000000o.O000000o((Throwable) obj);
                return null;
            }
        });
    }

    public void onRequestPhoneRegisterAndLogin(final PhoneAccount phoneAccount) {
        if (!this.O00000Oo.f6327O000000o.isChecked()) {
            Toast.makeText(this, (int) R.string.passport_error_user_agreement_error, 0).show();
            return;
        }
        this.O0000OOo.O000000o((int) R.string.doing_register);
        eko eko = this.O00000oo;
        String str = this.sid;
        AnonymousClass6 r2 = new eko.O00000Oo() {
            /* class com.xiaomi.passport.ui.page.AccountLoginActivity.AnonymousClass6 */

            public final void O000000o(AccountInfo accountInfo) {
                AccountLoginActivity.this.dismissLoadingView();
                AccountLoginActivity.this.loginSuccess(accountInfo);
            }
        };
        AnonymousClass7 r3 = new eko.O000000o() {
            /* class com.xiaomi.passport.ui.page.AccountLoginActivity.AnonymousClass7 */

            public final void O000000o(Throwable th) {
                AccountLoginActivity.this.dismissLoadingView();
                AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                eiw.O000000o(accountLoginActivity, accountLoginActivity, accountLoginActivity.sid, phoneAccount).O00000Oo(AccountLoginActivity.this.getApplicationContext(), th);
            }
        };
        if (eko.O00000o0 == null) {
            PhoneTokenRegisterParams build = new PhoneTokenRegisterParams.Builder().serviceId(str).phoneHashActivatorToken(new ActivatorPhoneInfo.Builder().phoneHash(phoneAccount.f6215O000000o.hashedPhoneNumber).activatorToken(phoneAccount.f6215O000000o.activatorToken).build()).build();
            eko.O00000o0 = new SimpleFutureTask<>(new AccountLoginer$6(eko, build, str, phoneAccount), new SimpleFutureTask.O000000o<AccountInfo>(r2, r3) {
                /* class _m_j.eko.AnonymousClass4 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000Oo f15580O000000o;
                final /* synthetic */ O000000o O00000Oo;

                {
                    this.f15580O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final void O000000o(SimpleFutureTask<AccountInfo> simpleFutureTask) {
                    try {
                        AccountInfo accountInfo = (AccountInfo) simpleFutureTask.get();
                        if (eks.O00000Oo(eko.this.O00000Oo, accountInfo)) {
                            this.f15580O000000o.O000000o(accountInfo);
                        } else {
                            this.O00000Oo.O000000o(new IllegalStateException("addOrUpdateAccountManager failed"));
                        }
                    } catch (InterruptedException e) {
                        this.O00000Oo.O000000o(e);
                    } catch (CancellationException e2) {
                        this.O00000Oo.O000000o(e2);
                    } catch (ExecutionException e3) {
                        this.O00000Oo.O000000o(e3.getCause());
                    } finally {
                        eko.this.O00000o0 = null;
                    }
                }
            });
            eko.f15576O000000o.submit(eko.O00000o0);
            return;
        }
        throw new IllegalStateException("exists running task");
    }

    public void onRequestSendTicketAndLogin(final PhoneAccount phoneAccount) {
        PhoneWrapper phoneWrapper = new PhoneWrapper(new ActivatorPhoneInfo.Builder().phoneHash(phoneAccount.f6215O000000o.hashedPhoneNumber).activatorToken(phoneAccount.f6215O000000o.activatorToken).build(), this.sid);
        this.O0000OOo.O000000o((int) R.string.loading);
        new egs().O000000o(phoneWrapper, (ega) null, (eif) null).O000000o(new iwc<String, iuh>() {
            /* class com.xiaomi.passport.ui.page.AccountLoginActivity.AnonymousClass8 */

            public final /* synthetic */ Object invoke(Object obj) {
                if (!AccountLoginActivity.this.isFinishing() && !AccountLoginActivity.this.isDestroyed()) {
                    AccountLoginActivity.this.dismissLoadingView();
                    PhoneWrapper phoneWrapper = new PhoneWrapper(new ActivatorPhoneInfo.Builder().phoneHash(phoneAccount.f6215O000000o.hashedPhoneNumber).activatorToken(phoneAccount.f6215O000000o.activatorToken).phone(phoneAccount.O00000Oo.phone).build(), AccountLoginActivity.this.sid);
                    AccountLoginActivity accountLoginActivity = AccountLoginActivity.this;
                    eha.O000000o o000000o = eha.O00000oO;
                    accountLoginActivity.gotoFragment(eha.O000000o.O000000o(AccountLoginActivity.this.sid, phoneWrapper), false);
                }
                return null;
            }
        }, new iwc<Throwable, iuh>() {
            /* class com.xiaomi.passport.ui.page.AccountLoginActivity.AnonymousClass9 */

            public final /* synthetic */ Object invoke(Object obj) {
                if (!AccountLoginActivity.this.isFinishing() && !AccountLoginActivity.this.isDestroyed()) {
                    AccountLoginActivity.this.dismissLoadingView();
                    AccountLoginActivity.this.onUseManualInputLogin();
                }
                return null;
            }
        });
    }

    public void onSnsLoginFailed() {
        if (!TextUtils.isEmpty(getIntent().getStringExtra("sns_sign_in"))) {
            O000000o(null);
        }
    }

    public boolean isUserAgreedProtocol() {
        return this.O00000Oo.f6327O000000o.isChecked();
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x010e A[LOOP:1: B:50:0x010c->B:51:0x010e, LOOP_END] */
    public void updateUserAgreement(PhoneAccount[] phoneAccountArr) {
        AccountCertification.Source source;
        String str;
        AccountLoginPageFooter accountLoginPageFooter = this.O00000Oo;
        eie eie = new eie();
        ixe.O00000o0(this, "context");
        if (TextUtils.isEmpty(eie.f15315O000000o)) {
            eie.f15315O000000o = eie.O000000o("https://account.xiaomi.com/about/protocol/agreement?_locale=%s", this);
        }
        String str2 = eie.f15315O000000o;
        if (str2 == null) {
            ixe.O000000o();
        }
        ixe.O00000o0(this, "context");
        if (TextUtils.isEmpty(eie.O00000Oo)) {
            eie.O00000Oo = eie.O000000o("https://account.xiaomi.com/about/protocol/privacy?_locale=%s", this);
        }
        String str3 = eie.O00000Oo;
        if (str3 == null) {
            ixe.O000000o();
        }
        if (phoneAccountArr != null && phoneAccountArr.length > 0) {
            source = null;
            for (PhoneAccount phoneAccount : phoneAccountArr) {
                if (phoneAccount != null && (source = phoneAccount.f6215O000000o.source) != null) {
                    break;
                }
            }
        } else {
            source = null;
        }
        if (source != null) {
            String str4 = source.type;
            char c = 65535;
            int hashCode = str4.hashCode();
            if (hashCode != -2015525726) {
                if (hashCode != -1787213167) {
                    if (hashCode == -711380617 && str4.equals("TELECOM")) {
                        c = 2;
                    }
                } else if (str4.equals("UNICOM")) {
                    c = 1;
                }
            } else if (str4.equals("MOBILE")) {
                c = 0;
            }
            if (c == 0) {
                str = getString(R.string.user_agreement_hint_with_mobile, new Object[]{str2, str3, source.link});
            } else if (c == 1) {
                str = getString(R.string.user_agreement_hint_with_unicom, new Object[]{str2, str3, source.link});
            } else if (c == 2) {
                str = getString(R.string.user_agreement_hint_with_telecom, new Object[]{str2, str3, source.link});
            }
            accountLoginPageFooter.O00000Oo.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView = accountLoginPageFooter.O00000Oo;
            AccountLoginPageFooter.AnonymousClass1 r2 = new LinkSpanHelper.O000000o() {
                /* class com.xiaomi.passport.ui.view.AccountLoginPageFooter.AnonymousClass1 */

                public final void O000000o(View view, String str) {
                    if (AccountLoginPageFooter.this.O00000o0 != null) {
                        AccountLoginPageFooter.this.O00000o0.onUserAgreementLinkClicked(view, str);
                    }
                }
            };
            Spannable spannable = (Spannable) Html.fromHtml(str);
            int color = getResources().getColor(R.color.passport_link_text);
            for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
                int spanStart = spannable.getSpanStart(uRLSpan);
                int spanEnd = spannable.getSpanEnd(uRLSpan);
                spannable.removeSpan(uRLSpan);
                spannable.setSpan(new LinkSpanHelper.UrlSpanNoUnderline(uRLSpan.getURL(), r2, color), spanStart, spanEnd, spannable.getSpanFlags(uRLSpan));
            }
            textView.setText(spannable);
        }
        str = getString(R.string.user_agreement_hint_default, new Object[]{str2, str3});
        accountLoginPageFooter.O00000Oo.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView2 = accountLoginPageFooter.O00000Oo;
        AccountLoginPageFooter.AnonymousClass1 r22 = new LinkSpanHelper.O000000o() {
            /* class com.xiaomi.passport.ui.view.AccountLoginPageFooter.AnonymousClass1 */

            public final void O000000o(View view, String str) {
                if (AccountLoginPageFooter.this.O00000o0 != null) {
                    AccountLoginPageFooter.this.O00000o0.onUserAgreementLinkClicked(view, str);
                }
            }
        };
        Spannable spannable2 = (Spannable) Html.fromHtml(str);
        int color2 = getResources().getColor(R.color.passport_link_text);
        while (r4 < r5) {
        }
        textView2.setText(spannable2);
    }

    public void updateHeaderVisibility(boolean z, boolean z2) {
        if (z) {
            this.f6269O000000o.O000000o(z2);
        } else {
            this.f6269O000000o.setVisibility(8);
        }
    }

    public void updateFooterVisibility(boolean z, boolean z2) {
        if (z) {
            this.O00000Oo.O000000o(z2);
        } else {
            this.O00000Oo.setVisibility(8);
        }
    }

    public void gotoFragment(Fragment fragment, boolean z) {
        ei O00000Oo2 = getSupportFragmentManager().O000000o().O00000Oo(R$id.content, fragment, null);
        if (z) {
            O00000Oo2 = O00000Oo2.O000000o((String) null);
        }
        O00000Oo2.O00000o0();
    }

    public void goBack(boolean z) {
        ee supportFragmentManager = getSupportFragmentManager();
        Fragment O000000o2 = supportFragmentManager.O000000o(R$id.content);
        if (O000000o2 != null && (O000000o2 instanceof eij)) {
            eij eij = (eij) O000000o2;
            if (eij.O00000o0() && !z) {
                eij.O00000o();
                return;
            }
        }
        if (supportFragmentManager.O00000oO() > 0) {
            supportFragmentManager.O00000o0();
        } else {
            O000000o(null);
        }
    }

    public void loginSuccess(AccountInfo accountInfo) {
        O000000o(accountInfo);
    }

    public void loginCancelled() {
        onSnsLoginFailed();
    }

    private void O000000o(AccountInfo accountInfo) {
        int i = accountInfo == null ? 0 : -1;
        Intent intent = getIntent();
        eks.O000000o(intent.getParcelableExtra("accountAuthenticatorResponse"), ekq.O000000o(i, accountInfo, intent.getBooleanExtra("need_retry_on_authenticator_response_result", false)));
        ehr.O000000o o000000o = ehr.O0000O0o;
        ehr.O00000oO = null;
        setResult(i);
        if (!isFinishing()) {
            finish();
        }
    }

    public void onSnsFacebookClicked(View view) {
        this.O00000oO.O000000o();
    }

    public void onSnsGoogleClicked(View view) {
        this.O00000oO.O00000Oo();
    }

    public void onSnsWeiboClicked(View view) {
        this.O00000oO.O00000o0();
    }

    public void onSnsQqClicked(View view) {
        this.O00000oO.O00000o();
    }

    public void onSnsWechatClicked(View view) {
        this.O00000oO.O00000oO();
    }

    public void onUserAgreementLinkClicked(View view, String str) {
        new eih();
        gotoFragment(eih.O000000o(str), true);
    }

    public void onBackClicked(View view) {
        onBackPressed();
    }

    public void onHelpClicked(View view) {
        eik.O000000o(this, "https://account.xiaomi.com/helpcenter");
    }

    public void onCountryNameClicked(View view) {
        CountryNameChooser countryNameChooser = this.O0000O0o;
        if (countryNameChooser != null) {
            startActivityForResult(countryNameChooser.f6267O000000o, 8880);
        }
    }

    public void dismissLoadingView() {
        this.O0000OOo.dismiss();
    }

    public Resources getResources() {
        if (Build.VERSION.SDK_INT >= 24) {
            return getApplicationContext().getResources();
        }
        return super.getResources();
    }
}
