package _m_j;

import _m_j.egg;
import _m_j.ejz;
import _m_j.ekq;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.MetaLoginData;
import com.xiaomi.accountsdk.account.data.PasswordLoginParams;
import com.xiaomi.accountsdk.account.data.Step2LoginParams;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidStep2codeException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.MiuiOsBuildReflection;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.internal.AlertDialog;
import com.xiaomi.passport.ui.internal.CaptchaView;
import com.xiaomi.passport.ui.internal.PassportGroupEditText;
import com.xiaomi.passport.ui.internal.util.LoginUIController;
import com.xiaomi.passport.uicontroller.SimpleFutureTask;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public final class eho extends Fragment implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected PassportGroupEditText f15295O000000o;
    public CaptchaView O00000Oo;
    public String O00000o;
    protected EditText O00000o0;
    protected String O00000oO;
    protected String O00000oo;
    protected volatile String O0000O0o;
    protected volatile MetaLoginData O0000OOo;
    protected TextView O0000Oo;
    public boolean O0000Oo0;
    protected ImageView O0000OoO;
    protected String O0000Ooo;
    private View O0000o;
    private Button O0000o0;
    private Button O0000o00;
    private CheckBox O0000o0O;
    private View O0000o0o;
    private TextView O0000oO;
    private boolean O0000oO0;
    private final AtomicBoolean O0000oOO = new AtomicBoolean(false);
    private boolean O0000oOo;
    private LoginUIController O0000oo0;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        Bundle arguments = getArguments();
        if (arguments == null) {
            AccountLog.d("QuickLoginFragment", "extra options is null");
            O00000Oo();
            return;
        }
        this.O00000o = arguments.getString("userId");
        if (TextUtils.isEmpty(this.O00000o)) {
            AccountLog.d("QuickLoginFragment", "extra user is null");
            O00000Oo();
            return;
        }
        this.O0000Oo0 = arguments.getBoolean("verify_only", false);
        this.O00000oO = arguments.getString("service_id", "passportapi");
        this.O0000O0o = arguments.getString("extra_step1_token");
        this.O0000oOo = arguments.getBoolean("return_sts_url", false);
        this.O0000oo0 = new LoginUIController(getActivity());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = 0;
        View inflate = layoutInflater.inflate((int) R.layout.passport_quick_login, viewGroup, false);
        this.O0000o00 = (Button) inflate.findViewById(R$id.cancel);
        this.O0000o0 = (Button) inflate.findViewById(R$id.passport_confirm);
        this.f15295O000000o = (PassportGroupEditText) inflate.findViewById(R$id.et_account_password);
        this.f15295O000000o.setStyle(PassportGroupEditText.Style.SingleItem);
        this.O0000Oo = (TextView) inflate.findViewById(R$id.tv_forget_pwd);
        this.O0000OoO = (ImageView) inflate.findViewById(R$id.show_password_img);
        this.O00000Oo = (CaptchaView) inflate.findViewById(R$id.captcha_layout);
        this.O0000o0o = inflate.findViewById(R$id.inner_content);
        this.O0000o = inflate.findViewById(R$id.inner_content_step2);
        this.O00000o0 = (EditText) inflate.findViewById(R$id.passport_vcode);
        this.O0000o0O = (CheckBox) inflate.findViewById(R$id.passport_trust_device);
        this.O0000oO = (TextView) inflate.findViewById(16908310);
        this.O0000o00.setOnClickListener(this);
        this.O0000o0.setOnClickListener(this);
        this.O0000Oo.setOnClickListener(this);
        this.O0000OoO.setOnClickListener(this);
        this.O0000oO0 = false;
        O00000o0();
        Bundle arguments = getArguments();
        if (arguments == null) {
            O00000Oo();
            return inflate;
        }
        String string = arguments.getString("extra_sign");
        String string2 = arguments.getString("extra_qs");
        String string3 = arguments.getString("extra_callback");
        if (!(string == null || string2 == null || string3 == null)) {
            this.O0000OOo = new MetaLoginData(string, string2, string3);
        }
        this.O0000Ooo = arguments.getString("title") == null ? getString(R.string.passport_quick_login_title) : arguments.getString("title");
        String string4 = arguments.getString("captcha_url");
        if (!TextUtils.isEmpty(string4)) {
            O000000o(string4);
        }
        ((TextView) inflate.findViewById(R$id.passport_account_name)).setText(getString(R.string.passport_account_name, this.O00000o));
        String string5 = arguments.getString("password");
        this.f15295O000000o.setText(string5);
        PassportGroupEditText passportGroupEditText = this.f15295O000000o;
        if (!TextUtils.isEmpty(string5)) {
            i = string5.length();
        }
        passportGroupEditText.setSelection(i);
        O000000o();
        Window window = getActivity().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (MiuiOsBuildReflection.isTablet()) {
            attributes.width = getResources().getDimensionPixelSize(R.dimen.passport_quick_login_dialog_width);
        } else {
            attributes.gravity = 80;
            attributes.width = -1;
        }
        window.setAttributes(attributes);
        return inflate;
    }

    @TargetApi(16)
    public final void onStop() {
        if ("com.xiaomi.account".equals(getActivity().getPackageName()) && this.O0000O0o != null) {
            Intent intent = new Intent(getActivity(), getActivity().getClass());
            intent.putExtra("service_id", this.O00000oO);
            intent.putExtra("extra_step1_token", this.O0000O0o);
            intent.putExtra("extra_sign", this.O0000OOo.sign);
            intent.putExtra("extra_qs", this.O0000OOo.qs);
            intent.putExtra("extra_callback", this.O0000OOo.callback);
            ((NotificationManager) getActivity().getSystemService("notification")).notify(1000, new Notification.Builder(getActivity()).setAutoCancel(false).setSmallIcon(17301642).setContentIntent(PendingIntent.getActivity(getActivity(), 0, intent, 134217728)).setContentTitle(getString(R.string.passport_vcode_notification_title)).setContentText(getString(R.string.passport_vcode_prompt_long)).build());
        }
        super.onStop();
    }

    public final void onStart() {
        super.onStart();
        ((NotificationManager) getActivity().getSystemService("notification")).cancel(1000);
    }

    private void O00000Oo() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private void O000000o(Bundle bundle) {
        Bundle arguments;
        if (this.O0000oOO.compareAndSet(false, true) && (arguments = getArguments()) != null) {
            eks.O000000o(arguments.getParcelable("accountAuthenticatorResponse"), bundle);
        }
    }

    public final void onClick(View view) {
        String str;
        if (this.O0000o00 == view) {
            O00000Oo();
        } else if (this.O0000o0 == view) {
            if (this.O0000O0o == null) {
                String obj = this.f15295O000000o.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    this.f15295O000000o.setError(getString(R.string.passport_error_empty_pwd));
                    return;
                }
                if (this.O00000Oo.getVisibility() == 0) {
                    str = this.O00000Oo.getCaptchaCode();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                } else {
                    str = null;
                }
                String str2 = this.O00000o;
                String captchaIck = this.O00000Oo.getCaptchaIck();
                PasswordLoginParams build = new PasswordLoginParams.Builder().setUserId(str2).setCaptCode(str).setCaptIck(captchaIck).setPassword(obj).setServiceId(this.O00000oO).setIsReturnStsUrl(this.O0000oOo).build();
                LoginUIController loginUIController = this.O0000oo0;
                AnonymousClass1 r5 = new LoginUIController.O000000o() {
                    /* class _m_j.eho.AnonymousClass1 */

                    public final void O000000o(AccountInfo accountInfo) {
                        eho.this.O000000o(accountInfo);
                    }

                    public final void O000000o(Step2LoginParams step2LoginParams) {
                        if (eho.this.O0000Oo0) {
                            eho.this.O00000Oo(new AccountInfo.Builder().userId(eho.this.O00000o).build());
                            return;
                        }
                        eho.this.O0000O0o = step2LoginParams.step1Token;
                        eho.this.O0000OOo = step2LoginParams.metaLoginData;
                        eho.this.O000000o();
                    }

                    public final void O000000o(String str) {
                        if (eho.this.O00000Oo.getVisibility() != 0) {
                            eho.this.O000000o(str);
                        } else {
                            eho.this.O000000o(str);
                        }
                    }

                    public final void O000000o(String str, String str2) {
                        eho eho = eho.this;
                        eho.startActivityForResult(eks.O000000o(eho.getActivity(), eho.getActivity().getIntent().getParcelableExtra("accountAuthenticatorResponse"), str2, str, eho.getArguments()), 2);
                    }

                    public final void O000000o(int i) {
                        if (i == R.string.passport_error_no_password_user) {
                            eho eho = eho.this;
                            ejz.O000000o o000000o = new ejz.O000000o(1);
                            o000000o.f15551O000000o = eho.getString(R.string.passport_login_failed);
                            o000000o.O00000Oo = eho.getString(R.string.passport_error_no_password_user);
                            ejz O000000o2 = o000000o.O000000o();
                            O000000o2.f15550O000000o = 17039370;
                            O000000o2.O00000Oo = null;
                            O000000o2.O000000o(eho.getActivity().getFragmentManager(), "no password user");
                            return;
                        }
                        eho eho2 = eho.this;
                        eho2.O00000Oo(eho2.getString(i));
                    }
                };
                if (loginUIController.O000000o(LoginUIController.UIControllerType.PASSWORD_LOGIN)) {
                    AccountLog.d("LoginUIController", "password login has not finished");
                } else if (loginUIController.O00000Oo == null || loginUIController.O00000Oo.isFinishing()) {
                    AccountLog.i("LoginUIController", "activity non exist");
                } else {
                    loginUIController.O000000o(loginUIController.O00000Oo.getFragmentManager(), loginUIController.O00000Oo.getString(R.string.passport_checking_account));
                    ekr.O000000o();
                    SimpleFutureTask simpleFutureTask = new SimpleFutureTask(new Callable<AccountInfo>(build) {
                        /* class com.xiaomi.passport.ui.internal.util.LoginUIController.AnonymousClass3 */
                        final /* synthetic */ PasswordLoginParams val$params;

                        {
                            this.val$params = r2;
                        }

                        public AccountInfo call() {
                            return ekq.O000000o(this.val$params);
                        }
                    }, new SimpleFutureTask.O000000o<AccountInfo>(r5, build) {
                        /* class com.xiaomi.passport.ui.internal.util.LoginUIController.AnonymousClass2 */

                        /* renamed from: O000000o */
                        final /* synthetic */ O000000o f6265O000000o;
                        final /* synthetic */ PasswordLoginParams O00000Oo;

                        {
                            this.f6265O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        /* JADX INFO: finally extract failed */
                        /* JADX WARNING: Removed duplicated region for block: B:47:0x0109  */
                        /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
                        public final void O000000o(SimpleFutureTask<AccountInfo> simpleFutureTask) {
                            if (LoginUIController.this.O00000Oo == null || LoginUIController.this.O00000Oo.isFinishing()) {
                                AccountLog.d("LoginUIController", "activity not alive");
                                return;
                            }
                            int i = R.string.passport_error_unknown;
                            try {
                                this.f6265O000000o.O000000o((AccountInfo) simpleFutureTask.get());
                                LoginUIController.this.O000000o();
                            } catch (InterruptedException e) {
                                AccountLog.e("LoginUIController", "interrupted", e);
                                LoginUIController.this.O000000o();
                                this.f6265O000000o.O000000o((int) R.string.passport_error_unknown);
                            } catch (ExecutionException e2) {
                                AccountLog.e("LoginUIController", "execution error", e2);
                                Throwable cause = e2.getCause();
                                if (cause instanceof NeedNotificationException) {
                                    AccountLog.e("LoginUIController", "need notification", e2);
                                    this.f6265O000000o.O000000o(this.O00000Oo.serviceId, ((NeedNotificationException) cause).getNotificationUrl());
                                } else if (cause instanceof NeedVerificationException) {
                                    AccountLog.e("LoginUIController", "need step2 login", e2);
                                    NeedVerificationException needVerificationException = (NeedVerificationException) cause;
                                    this.f6265O000000o.O000000o(new Step2LoginParams.Builder().setUserId(needVerificationException.getUserId()).setMetaLoginData(needVerificationException.getMetaLoginData()).setServiceId(this.O00000Oo.serviceId).setStep1Token(needVerificationException.getStep1Token()).build());
                                } else if (cause instanceof NeedCaptchaException) {
                                    AccountLog.e("LoginUIController", "need captcha");
                                    this.f6265O000000o.O000000o(((NeedCaptchaException) cause).getCaptchaUrl());
                                } else {
                                    if (cause instanceof InvalidCredentialException) {
                                        AccountLog.e("LoginUIController", "wrong password", e2);
                                        InvalidCredentialException invalidCredentialException = (InvalidCredentialException) cause;
                                        if (!TextUtils.isEmpty(invalidCredentialException.getCaptchaUrl())) {
                                            this.f6265O000000o.O000000o(invalidCredentialException.getCaptchaUrl());
                                        } else {
                                            i = ((InvalidCredentialException) cause).getHasPwd() ? R.string.passport_bad_authentication : R.string.passport_error_no_password_user;
                                        }
                                    } else if (cause instanceof IOException) {
                                        AccountLog.e("LoginUIController", "network error", e2);
                                        i = R.string.passport_error_network;
                                    } else if (cause instanceof InvalidUserNameException) {
                                        AccountLog.e("LoginUIController", "nonExist user name", e2);
                                        i = R.string.passport_error_user_name;
                                    } else if (cause instanceof AccessDeniedException) {
                                        AccountLog.e("LoginUIController", "access denied", e2);
                                        i = R.string.passport_access_denied;
                                    } else if (cause instanceof InvalidResponseException) {
                                        AccountLog.e("LoginUIController", "invalid response", e2);
                                        i = R.string.passport_error_server;
                                    }
                                    LoginUIController.this.O000000o();
                                    if (i == -1) {
                                        this.f6265O000000o.O000000o(i);
                                        return;
                                    }
                                    return;
                                }
                                i = -1;
                                LoginUIController.this.O000000o();
                                if (i == -1) {
                                }
                            } catch (Throwable th) {
                                LoginUIController.this.O000000o();
                                throw th;
                            }
                        }
                    });
                    ekx.O000000o().submit(simpleFutureTask);
                    loginUIController.f6263O000000o.put(LoginUIController.UIControllerType.PASSWORD_LOGIN, simpleFutureTask);
                }
            } else {
                String obj2 = this.O00000o0.getText().toString();
                boolean isChecked = this.O0000o0O.isChecked();
                if (TextUtils.isEmpty(obj2)) {
                    this.O00000o0.setError(getString(R.string.passport_error_empty_vcode));
                    return;
                }
                String str3 = this.O00000o;
                Step2LoginParams build2 = new Step2LoginParams.Builder().setUserId(str3).setServiceId(this.O00000oO).setStep1Token(this.O0000O0o).setMetaLoginData(this.O0000OOo).setTrust(isChecked).setStep2code(obj2).build();
                LoginUIController loginUIController2 = this.O0000oo0;
                AnonymousClass2 r52 = new LoginUIController.O00000Oo() {
                    /* class _m_j.eho.AnonymousClass2 */

                    public final void O000000o(AccountInfo accountInfo) {
                        eho.this.O000000o(accountInfo);
                    }

                    public final void O000000o() {
                        eho eho = eho.this;
                        eho.O00000Oo(eho.getString(R.string.passport_bad_authentication));
                    }

                    public final void O00000Oo() {
                        eho eho = eho.this;
                        eho.O00000Oo(eho.getString(R.string.passport_wrong_vcode));
                    }

                    public final void O000000o(int i) {
                        eho eho = eho.this;
                        eho.O00000Oo(eho.getString(i));
                    }
                };
                if (loginUIController2.O000000o(LoginUIController.UIControllerType.PASSWORD_LOGIN)) {
                    AccountLog.d("LoginUIController", "password login has not finished");
                } else if (loginUIController2.O00000Oo == null || loginUIController2.O00000Oo.isFinishing()) {
                    AccountLog.i("LoginUIController", "activity non exist");
                } else {
                    loginUIController2.O000000o(loginUIController2.O00000Oo.getFragmentManager(), loginUIController2.O00000Oo.getString(R.string.passport_checking_account));
                    ekr.O000000o();
                    SimpleFutureTask simpleFutureTask2 = new SimpleFutureTask(new Callable<AccountInfo>(build2) {
                        /* class com.xiaomi.passport.ui.internal.util.LoginUIController.AnonymousClass5 */
                        final /* synthetic */ Step2LoginParams val$step2LoginParams;

                        {
                            this.val$step2LoginParams = r2;
                        }

                        public AccountInfo call() {
                            return ekq.O000000o(this.val$step2LoginParams.userId, this.val$step2LoginParams.step2code, this.val$step2LoginParams.metaLoginData, this.val$step2LoginParams.trust, this.val$step2LoginParams.step1Token, this.val$step2LoginParams.serviceId);
                        }
                    }, new SimpleFutureTask.O000000o<AccountInfo>(r52) {
                        /* class com.xiaomi.passport.ui.internal.util.LoginUIController.AnonymousClass4 */

                        /* renamed from: O000000o */
                        final /* synthetic */ O00000Oo f6266O000000o;

                        {
                            this.f6266O000000o = r2;
                        }

                        /* JADX INFO: finally extract failed */
                        /* JADX WARNING: Removed duplicated region for block: B:35:0x008f  */
                        /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
                        public final void O000000o(SimpleFutureTask<AccountInfo> simpleFutureTask) {
                            if (LoginUIController.this.O00000Oo == null || LoginUIController.this.O00000Oo.isFinishing()) {
                                AccountLog.d("LoginUIController", "activity not alive");
                                return;
                            }
                            int i = R.string.passport_error_unknown;
                            try {
                                this.f6266O000000o.O000000o((AccountInfo) simpleFutureTask.get());
                                LoginUIController.this.O000000o();
                            } catch (InterruptedException e) {
                                AccountLog.e("LoginUIController", "interrupted", e);
                                LoginUIController.this.O000000o();
                                this.f6266O000000o.O000000o((int) R.string.passport_error_unknown);
                            } catch (ExecutionException e2) {
                                AccountLog.e("LoginUIController", "execution error", e2);
                                Throwable cause = e2.getCause();
                                if (cause instanceof InvalidStep2codeException) {
                                    AccountLog.e("LoginUIController", "wrong step2 code", e2);
                                    this.f6266O000000o.O00000Oo();
                                } else if (cause instanceof InvalidCredentialException) {
                                    AccountLog.e("LoginUIController", "wrong password", e2);
                                    this.f6266O000000o.O000000o();
                                } else {
                                    if (cause instanceof IOException) {
                                        AccountLog.e("LoginUIController", "network error", e2);
                                        i = R.string.passport_error_network;
                                    } else if (cause instanceof InvalidUserNameException) {
                                        AccountLog.e("LoginUIController", "nonExist user name", e2);
                                        i = R.string.passport_error_user_name;
                                    } else if (cause instanceof AccessDeniedException) {
                                        AccountLog.e("LoginUIController", "access denied", e2);
                                        i = R.string.passport_access_denied;
                                    } else if (cause instanceof InvalidResponseException) {
                                        AccountLog.e("LoginUIController", "invalid response", e2);
                                        i = R.string.passport_error_server;
                                    }
                                    LoginUIController.this.O000000o();
                                    if (i == -1) {
                                        this.f6266O000000o.O000000o(i);
                                        return;
                                    }
                                    return;
                                }
                                i = -1;
                                LoginUIController.this.O000000o();
                                if (i == -1) {
                                }
                            } catch (Throwable th) {
                                LoginUIController.this.O000000o();
                                throw th;
                            }
                        }
                    });
                    ekx.O000000o().submit(simpleFutureTask2);
                    loginUIController2.f6263O000000o.put(LoginUIController.UIControllerType.PASSWORD_LOGIN, simpleFutureTask2);
                }
            }
        } else if (this.O0000Oo == view) {
            Activity activity = getActivity();
            if (activity == null) {
                return;
            }
            if (egg.f15249O000000o == null || AsyncTask.Status.FINISHED == egg.f15249O000000o.getStatus()) {
                egg.O000000o o000000o = new egg.O000000o(activity);
                egg.f15249O000000o = o000000o;
                o000000o.executeOnExecutor(ekx.O000000o(), new Void[0]);
            }
        } else if (this.O0000OoO == view) {
            this.O0000oO0 = !this.O0000oO0;
            O00000o0();
        }
    }

    private void O00000o0() {
        eis.O000000o(this.f15295O000000o, this.O0000OoO, this.O0000oO0, getResources());
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            if (i2 == -1) {
                AccountLog.i("QuickLoginFragment", "notification completed");
                getActivity().setResult(-1);
                O00000Oo();
                return;
            }
            O00000Oo(getString(R.string.passport_relogin_notice));
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            AccountLog.w("QuickLoginFragment", "captcha url is null");
            this.O00000Oo.setVisibility(8);
            return;
        }
        this.O00000Oo.setVisibility(0);
        CaptchaView captchaView = this.O00000Oo;
        captchaView.O000000o(URLs.ACCOUNT_DOMAIN + str);
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        if (this.O0000O0o == null) {
            this.O0000o.setVisibility(8);
            this.O0000o0o.setVisibility(0);
            this.O0000oO.setText(this.O0000Ooo);
            return;
        }
        this.O0000o0o.setVisibility(8);
        this.O0000o.setVisibility(0);
        this.O0000oO.setText((int) R.string.passport_quick_login_step2_title);
    }

    public final void O000000o(AccountInfo accountInfo) {
        this.O0000O0o = null;
        this.O0000OOo = null;
        this.O00000oo = null;
        if (!this.O0000Oo0) {
            eks.O00000Oo(getActivity(), accountInfo);
        }
        O00000Oo(accountInfo);
    }

    public final void O00000Oo(AccountInfo accountInfo) {
        AccountLog.i("QuickLoginFragment", "login success");
        eks.O000000o(getActivity().getApplicationContext(), accountInfo);
        O000000o(ekq.O000000o(accountInfo, getArguments().getBoolean("need_retry_on_authenticator_response_result", false)));
        getActivity().setResult(-1);
        getActivity().finish();
    }

    public final void O00000Oo(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (getActivity().getIntent() != null) {
            builder.O000000o((int) R.string.passport_verification_failed);
        } else {
            builder.O000000o((int) R.string.passport_login_failed);
        }
        builder.O000000o(str);
        builder.O000000o();
        builder.O00000o0();
    }

    public final void onDestroy() {
        if (egg.f15249O000000o != null) {
            egg.f15249O000000o.cancel(true);
            egg.f15249O000000o = null;
        }
        LoginUIController loginUIController = this.O0000oo0;
        if (loginUIController != null) {
            for (LoginUIController.UIControllerType uIControllerType : loginUIController.f6263O000000o.keySet()) {
                FutureTask futureTask = loginUIController.f6263O000000o.get(uIControllerType);
                if (futureTask != null && !futureTask.isDone()) {
                    futureTask.cancel(true);
                }
            }
            loginUIController.f6263O000000o.clear();
            this.O0000oo0 = null;
        }
        super.onDestroy();
    }
}
