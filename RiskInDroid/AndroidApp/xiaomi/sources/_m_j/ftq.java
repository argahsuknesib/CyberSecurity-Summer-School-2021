package _m_j;

import _m_j.cmc;
import _m_j.ezo;
import _m_j.fnh;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.fus;
import _m_j.gft;
import _m_j.gfu;
import _m_j.gge;
import _m_j.goq;
import _m_j.gpu;
import _m_j.gpv;
import _m_j.gsy;
import _m_j.gtx;
import _m_j.gty;
import _m_j.gvf;
import _m_j.hje;
import _m_j.hna;
import _m_j.hor;
import _m_j.hsy;
import _m_j.htv;
import _m_j.htw;
import _m_j.ibh;
import _m_j.ibi;
import _m_j.ibl;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sankuai.waimai.router.annotation.RouterService;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.xiaomi.account.openid.OauthAccountManager;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.Gender;
import com.xiaomi.accountsdk.account.data.PassTokenLoginParams;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.account.data.XiaomiUserInfo;
import com.xiaomi.accountsdk.account.data.XiaomiUserProfile;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.passport.PassportUserEnvironment;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.ui.internal.AuthComponent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.auth.bindaccount.ThirdAccountGroupListActivity;
import com.xiaomi.smarthome.auth.bindaccount.model.ThirdAccount;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.core.entity.account.OAuthAccount;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.login.MijiaLoginManager;
import com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity;
import com.xiaomi.smarthome.frame.login.ui.LoginTransitActivity;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.LoginApiImpl$5$2;
import com.xiaomi.smarthome.framework.redpoint.ServerTimerManager;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.shop.MiotAccountProvider;
import com.xiaomi.youpin.login.api.manager.LoginManager;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiAccountInfo;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@RouterService
public class ftq implements gtx {
    private static final ftq INSTANCE = new ftq();

    @cug
    public static ftq provideInstance() {
        return INSTANCE;
    }

    public void startMiuiLogin(Context context, Activity activity, final ibq ibq) {
        new MijiaLoginManager(context).O000000o(activity, new ibq() {
            /* class _m_j.ftq.AnonymousClass1 */

            public final void O000000o(LoginMiAccount loginMiAccount) {
                fsp.O000000o().O00000oo.O000000o(4);
                ibq ibq = ibq;
                if (ibq != null) {
                    ibq.O000000o(loginMiAccount);
                }
            }

            public final void O000000o(int i, String str, Map<String, String> map) {
                fsp.O000000o().O00000oo.O00000Oo();
                ibq ibq = ibq;
                if (ibq != null) {
                    ibq.O000000o(i, str, map);
                }
            }
        });
    }

    public void startLogin(final Context context, final int i, final gtx.O000000o o000000o) {
        final ft O000000o2 = ft.O000000o(fsp.O000000o().O00000Oo);
        O000000o2.O000000o(new BroadcastReceiver() {
            /* class _m_j.ftq.AnonymousClass10 */

            public final void onReceive(Context context, Intent intent) {
                O000000o2.O000000o(this);
                gtx.O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        }, new IntentFilter("action.passwordlogin.login.complete"));
        if (!grr.O00000oO() || Build.VERSION.SDK_INT <= 19) {
            gsy.O00000o0(LogType.LOGIN, "LoginApi", "startLogin not miui");
            LoginTransitActivity.startLogin(context, LoginTransitActivity.LoginMethod.PWD, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            ici.O000000o(context, true, new ich() {
                /* class _m_j.ftq.AnonymousClass11 */

                public final void O000000o(Account account) {
                    LoginTransitActivity.startLogin(context, LoginTransitActivity.LoginMethod.AUTO, i);
                }

                public final void O000000o(int i, String str) {
                    LogType logType = LogType.LOGIN;
                    gsy.O00000o0(logType, "LoginApi", "startLogin canAccessAccount onFail:" + i + "," + str);
                    LoginTransitActivity.startLogin(context, LoginTransitActivity.LoginMethod.PWD, i);
                }
            });
        } else if (fwq.O000000o(context, "android.permission.GET_ACCOUNTS")) {
            gsy.O00000o0(LogType.LOGIN, "LoginApi", "startLogin isPermsGranted true");
            LoginTransitActivity.startLogin(context, LoginTransitActivity.LoginMethod.AUTO, i);
        } else if (context instanceof Activity) {
            Activity activity = (Activity) context;
            AnonymousClass12 r5 = new inc() {
                /* class _m_j.ftq.AnonymousClass12 */

                public final void onAction(List<String> list) {
                    LoginTransitActivity.startLogin(context, LoginTransitActivity.LoginMethod.AUTO, i);
                }
            };
            if (!fwq.O000000o("android.permission.GET_ACCOUNTS")) {
                activity.getApplication().getResources().getString(R.string.permission_successfully);
                fwq.O000000o(activity, activity.getApplication().getResources().getString(R.string.permission_failure), activity.getApplication().getResources().getString(R.string.tips), activity.getApplication().getResources().getString(R.string.permission_tips_denied_msg), r5, "android.permission.GET_ACCOUNTS");
                return;
            }
            r5.onAction(Arrays.asList("android.permission.GET_ACCOUNTS"));
        } else {
            LoginTransitActivity.startLogin(context, LoginTransitActivity.LoginMethod.PWD, i);
        }
    }

    public icc startLogout(final boolean z, final ibh<Void, Error> ibh) {
        CoreApi.O000000o().O0000oO0();
        return new icc(CoreApi.O000000o().O000000o(new fsm<Void, fso>() {
            /* class _m_j.ftq.AnonymousClass13 */

            public final void onFailure(fso fso) {
                if (ibh != null) {
                    if (fso == null) {
                        fso = new fso(0, "unknown error");
                    }
                    ibh.onFailure(new Error(fso.f17063O000000o, fso.O00000Oo));
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                Context context = fsp.O000000o().O00000Oo;
                final MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(context);
                gsy.O000000o(6, "LoginApi", "before Logout isLocal: " + O00000Oo2.O00000o0());
                if (O00000Oo2.O00000o0()) {
                    O00000Oo2.O000000o(new AccountManagerCallback<Boolean>() {
                        /* class _m_j.ftq.AnonymousClass13.AnonymousClass1 */

                        public final void run(AccountManagerFuture<Boolean> accountManagerFuture) {
                            try {
                                gsy.O000000o(3, "LoginApi", "delete account result: ".concat(String.valueOf(accountManagerFuture.getResult())));
                                O00000Oo2.O00000oO();
                                Account O00000oo = O00000Oo2.O00000oo();
                                O00000Oo2.O00000o();
                                Account O00000oo2 = O00000Oo2.O00000oo();
                                gsy.O00000Oo("LoginApi", "after logout local: " + gpp.O000000o(O00000oo.toString()) + " ;sys: " + gpp.O000000o(O00000oo2.toString()));
                            } catch (Exception e) {
                                gsy.O00000Oo("LoginApi", "delete account result: " + Log.getStackTraceString(e));
                            }
                        }
                    }, (Handler) null);
                    eks.O00000Oo(context);
                }
                if (z) {
                    CoreApi O000000o2 = CoreApi.O000000o();
                    try {
                        O000000o2.O00000Oo().clearPluginConfig(new LoginApiImpl$5$2(this));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                ibh ibh = ibh;
                if (ibh != null) {
                    ibh.onSuccess(null);
                }
            }
        }));
    }

    public void startLoginMiByOAuth(Activity activity, int[] iArr) {
        new LoginManager(activity).O000000o(activity, iArr, fsr.O0000o0, fsr.O0000o0o, new ibr() {
            /* class _m_j.ftq.AnonymousClass14 */

            public final void O000000o(ibx ibx) {
                OAuthAccount oAuthAccount = new OAuthAccount();
                oAuthAccount.O000000o(ibx.f1167O000000o, ibx.O00000Oo);
                CoreApi.O000000o().O000000o(oAuthAccount, new fsm<Void, fso>() {
                    /* class _m_j.ftq.AnonymousClass14.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        fsp.O000000o().O00000oo.O00000Oo();
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        fsp.O000000o().O00000oo.O000000o(8);
                    }
                });
            }

            public final void O000000o(int i, String str) {
                fsp.O000000o().O00000oo.O00000Oo();
            }
        });
    }

    public String getOauthUserId() {
        if (OauthAccountManager.getOauthAccount() != null) {
            return OauthAccountManager.getOauthAccount().getUserId();
        }
        return null;
    }

    public String getOauthServiceToken() {
        if (OauthAccountManager.getOauthAccount() != null) {
            return OauthAccountManager.getOauthAccount().getServiceToken();
        }
        return null;
    }

    public void invalideOauthServiceToken() {
        if (OauthAccountManager.getOauthAccount() != null) {
            OauthAccountManager.getOauthAccount().invalideServiceToken();
        }
    }

    public void getAuthorizationCode(Activity activity, String str, int[] iArr, String str2, ibr ibr) {
        new LoginManager(activity).O00000Oo(activity, iArr, str, str2, ibr);
    }

    public void canAccessAccount(ibh ibh) {
        if (ibh != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    final gpr gpr = new gpr(ibh);
                    ici.O000000o(ServiceApplication.getAppContext(), false, new ich() {
                        /* class _m_j.ftq.AnonymousClass15 */

                        public final void O000000o(Account account) {
                            ((ibh) gpr.f18128O000000o).onSuccess(account);
                            gpr.f18128O000000o = null;
                        }

                        public final void O000000o(int i, String str) {
                            LogType logType = LogType.LOGIN;
                            gsy.O00000Oo(logType, "login", "startLoginMiSystem on fail " + i + "," + str);
                            ((ibh) gpr.f18128O000000o).onFailure(new Error(i, str));
                            gpr.f18128O000000o = null;
                        }
                    });
                    return;
                }
                ibh.onSuccess(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ibm.O000000o(java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
     arg types: [java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, int, _m_j.ftq$16]
     candidates:
      _m_j.ibm.O000000o(java.lang.String, java.lang.String, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
      _m_j.ibm.O000000o(java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ibm.O000000o(java.lang.String, java.lang.String, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, int, _m_j.ftq$17]
     candidates:
      _m_j.ibm.O000000o(java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
      _m_j.ibm.O000000o(java.lang.String, java.lang.String, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void */
    public void refreshServiceToken(String str, final ibh<MiServiceTokenInfo, Error> ibh) {
        if (!CoreApi.O000000o().O0000Ooo()) {
            ibh.onFailure(new Error(-1, "not login"));
        } else if (CoreApi.O000000o().O0000oO0()) {
            ibm.O000000o(str, CoreApi.O000000o().O0000o0(), CoreApi.O000000o().O000000o(str), false, (ibh<MiServiceTokenInfo, ExceptionError>) new ibh<MiServiceTokenInfo, ExceptionError>() {
                /* class _m_j.ftq.AnonymousClass16 */

                public final /* synthetic */ void onFailure(Error error) {
                    ExceptionError exceptionError = (ExceptionError) error;
                    ibh.onFailure(new Error(exceptionError.f12083O000000o, exceptionError.O00000Oo));
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                    CoreApi.O000000o().O000000o(miServiceTokenInfo, (fsm<Void, fso>) null);
                    ibh.onSuccess(new MiServiceTokenInfo(miServiceTokenInfo.f12086O000000o, miServiceTokenInfo.O00000Oo, miServiceTokenInfo.O00000o0, miServiceTokenInfo.O00000o, miServiceTokenInfo.O00000oo, miServiceTokenInfo.O00000oO));
                }
            });
        } else {
            ibm.O000000o(str, CoreApi.O000000o().O0000o0(), CoreApi.O000000o().O0000oO(), false, (ibh<MiServiceTokenInfo, ExceptionError>) new ibh<MiServiceTokenInfo, ExceptionError>() {
                /* class _m_j.ftq.AnonymousClass17 */

                public final /* synthetic */ void onFailure(Error error) {
                    ExceptionError exceptionError = (ExceptionError) error;
                    ibh.onFailure(new Error(exceptionError.f12083O000000o, exceptionError.O00000Oo));
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                    CoreApi.O000000o().O000000o(miServiceTokenInfo, (fsm<Void, fso>) null);
                    ibh.onSuccess(new MiServiceTokenInfo(miServiceTokenInfo.f12086O000000o, miServiceTokenInfo.O00000Oo, miServiceTokenInfo.O00000o0, miServiceTokenInfo.O00000o, miServiceTokenInfo.O00000oo, miServiceTokenInfo.O00000oO));
                }
            });
        }
    }

    public void startPwdLogin(Context context, String str, final gtx.O000000o o000000o) {
        final ft O000000o2 = ft.O000000o(fsp.O000000o().O00000Oo);
        O000000o2.O000000o(new BroadcastReceiver() {
            /* class _m_j.ftq.AnonymousClass2 */

            public final void onReceive(Context context, Intent intent) {
                O000000o2.O000000o(this);
                gtx.O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        }, new IntentFilter("action.passwordlogin.login.complete"));
        LoginTransitActivity.startLogin(context, LoginTransitActivity.LoginMethod.PWD, 5);
    }

    public void getAccount(Context context, String str, ibh<AccountInfo, Error> ibh) {
        if (CoreApi.O000000o().O0000oO0()) {
            final Account O00000o0 = ici.O00000o0(context);
            final String str2 = str;
            final Context context2 = context;
            final ibh<AccountInfo, Error> ibh2 = ibh;
            goq.O000000o(new Runnable() {
                /* class _m_j.ftq.AnonymousClass3 */

                /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
                /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
                @SuppressLint({"MissingPermission"})
                public final void run() {
                    Bundle bundle;
                    AccountInfo.Builder builder = new AccountInfo.Builder();
                    builder.serviceId(str2);
                    try {
                        AccountManagerFuture<Bundle> authToken = AccountManager.get(context2).getAuthToken(O00000o0, str2, true, null, null);
                        if (authToken == null) {
                            ibh2.sendFailureMessage(new Error(-1, "AuthTokenResult is null"));
                            return;
                        }
                        bundle = authToken.getResult();
                        if (bundle == null) {
                            ibh2.sendFailureMessage(new Error(-2, "bundle is null"));
                            return;
                        }
                        String string = bundle.getString("authtoken");
                        String string2 = bundle.getString("encrypted_user_id");
                        if (!TextUtils.isEmpty(string)) {
                            String[] split = string.split(",");
                            if (split.length >= 2) {
                                builder.serviceToken(split[0]).security(split[1]);
                            }
                        }
                        if (TextUtils.isEmpty(string2)) {
                            try {
                                string2 = AccountManager.get(context2).getUserData(O00000o0, "encrypted_user_id");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            AccountManager accountManager = AccountManager.get(context2);
                            Account account = O00000o0;
                            String userData = accountManager.getUserData(account, str2 + "_slh");
                            AccountManager accountManager2 = AccountManager.get(context2);
                            Account account2 = O00000o0;
                            builder.encryptedUserId(string2).ph(accountManager2.getUserData(account2, str2 + "_ph")).slh(userData);
                            ibh2.sendSuccessMessage(builder.build());
                        } catch (Exception unused) {
                            ftq.this.getAccountInfo(str2, ibh2);
                        }
                    } catch (OperationCanceledException e2) {
                        e2.printStackTrace();
                        bundle = null;
                        if (bundle == null) {
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        bundle = null;
                        if (bundle == null) {
                        }
                    } catch (AuthenticatorException e4) {
                        e4.printStackTrace();
                        bundle = null;
                        if (bundle == null) {
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        bundle = null;
                        if (bundle == null) {
                        }
                    }
                }
            });
            return;
        }
        getAccountInfo(str, ibh);
    }

    public void queryWxBind(final ibh<Boolean, Error> ibh) {
        ibv.O000000o(23, CoreApi.O000000o().O0000oOo(), new ibn<Boolean>() {
            /* class _m_j.ftq.AnonymousClass4 */

            public final /* synthetic */ void O000000o(Object obj) {
                Boolean bool = (Boolean) obj;
                ibh ibh = ibh;
                if (ibh != null) {
                    ibh.onSuccess(bool);
                }
            }

            public final void O000000o(int i, String str) {
                if (ibh != null) {
                    ibh.sendFailureMessage(new Error(i, str));
                }
            }

            public final void O000000o(MiServiceTokenInfo miServiceTokenInfo) {
                LoginMiAccount O0000oOo = CoreApi.O000000o().O0000oOo();
                if (O0000oOo != null) {
                    O0000oOo.O000000o(miServiceTokenInfo);
                    CoreApi.O000000o().O000000o(O0000oOo, new fsm<Void, fso>() {
                        /* class _m_j.ftq.AnonymousClass4.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                        }

                        public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        }
                    });
                }
            }
        });
    }

    public void queryFacebookBind(final ibh<Boolean, Error> ibh) {
        ibv.O000000o(12, CoreApi.O000000o().O0000oOo(), new ibn<Boolean>() {
            /* class _m_j.ftq.AnonymousClass5 */

            public final /* synthetic */ void O000000o(Object obj) {
                Boolean bool = (Boolean) obj;
                ibh ibh = ibh;
                if (ibh != null) {
                    ibh.onSuccess(bool);
                }
            }

            public final void O000000o(int i, String str) {
                if (ibh != null) {
                    ibh.sendFailureMessage(new Error(i, str));
                }
            }

            public final void O000000o(MiServiceTokenInfo miServiceTokenInfo) {
                LoginMiAccount O0000oOo = CoreApi.O000000o().O0000oOo();
                if (O0000oOo != null) {
                    O0000oOo.O000000o(miServiceTokenInfo);
                    CoreApi.O000000o().O000000o(O0000oOo, new fsm<Void, fso>() {
                        /* class _m_j.ftq.AnonymousClass5.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                        }

                        public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        }
                    });
                }
            }
        });
    }

    public void getAccountInfo(String str, ibh<AccountInfo, Error> ibh) {
        final String O0000o0 = CoreApi.O000000o().O0000o0();
        final String O0000oO = CoreApi.O000000o().O0000oO();
        final String str2 = str;
        final ibh<AccountInfo, Error> ibh2 = ibh;
        goq.O000000o(new Runnable() {
            /* class _m_j.ftq.AnonymousClass6 */

            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.xiaomi.accountsdk.request.InvalidResponseException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.xiaomi.accountsdk.account.exception.InvalidCredentialException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.xiaomi.accountsdk.request.AccessDeniedException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.xiaomi.accountsdk.request.AuthenticationFailureException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.xiaomi.accountsdk.account.exception.InvalidUserNameException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.xiaomi.accountsdk.account.exception.IllegalDeviceException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.xiaomi.accountsdk.account.exception.NeedNotificationException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.io.IOException} */
            /* JADX WARNING: Multi-variable type inference failed */
            public final void run() {
                Exception exc;
                AccountInfo accountInfo = null;
                try {
                    exc = null;
                    accountInfo = ekq.O000000o(CommonApplication.getAppContext(), new PassTokenLoginParams.Builder().userId(O0000o0).passToken(O0000oO).serviceId(str2).build());
                } catch (IOException e) {
                    e.printStackTrace();
                    exc = e;
                } catch (InvalidResponseException e2) {
                    e2.printStackTrace();
                    exc = e2;
                } catch (InvalidCredentialException e3) {
                    e3.printStackTrace();
                    exc = e3;
                } catch (AccessDeniedException e4) {
                    e4.printStackTrace();
                    exc = e4;
                } catch (AuthenticationFailureException e5) {
                    e5.printStackTrace();
                    exc = e5;
                } catch (InvalidUserNameException e6) {
                    e6.printStackTrace();
                    exc = e6;
                } catch (IllegalDeviceException e7) {
                    e7.printStackTrace();
                    exc = e7;
                } catch (NeedNotificationException e8) {
                    e8.printStackTrace();
                    exc = e8;
                } catch (Exception e9) {
                    e9.printStackTrace();
                    exc = e9;
                }
                new ExceptionError(-1, "").O00000o0 = exc;
                if (accountInfo != null) {
                    ibh2.sendSuccessMessage(accountInfo);
                } else {
                    ibh2.sendFailureMessage(new Error(-1, ""));
                }
            }
        });
    }

    public boolean shouldInitFacebookSdk() {
        return CommonApplication.shouldInitFacebookSdk();
    }

    public Class<?> getLoginTransitActivity() {
        return LoginTransitActivity.class;
    }

    public Class<?> getLoginMiuiActivity() {
        return LoginMiuiActivity.class;
    }

    public Class<?> getThirdAccountGroupListActivity() {
        return ThirdAccountGroupListActivity.class;
    }

    public Dialog showLoginDialog(Activity activity, boolean z) {
        MijiaLoginManager O000000o2 = MijiaLoginManager.O000000o();
        return new MLAlertDialog.Builder(activity).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener(activity) {
            /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass3 */

            /* renamed from: O000000o */
            final /* synthetic */ Activity f7524O000000o;

            {
                this.f7524O000000o = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                gty.O000000o().startLogin(this.f7524O000000o, 1, null);
                dialogInterface.dismiss();
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener(z, activity) {
            /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass1 */

            /* renamed from: O000000o */
            final /* synthetic */ boolean f7522O000000o;
            final /* synthetic */ Activity O00000Oo;

            {
                this.f7522O000000o = r2;
                this.O00000Oo = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (this.f7522O000000o) {
                    this.O00000Oo.finish();
                }
            }
        }).O000000o(true).O00000Oo((int) R.string.loing_helper_title).O00000oo();
    }

    public boolean hasMiSystemAccount() {
        return ftk.O000000o();
    }

    public String getMiSystemAccountId() {
        return ftk.O00000Oo();
    }

    public void initThirdAccountBind(final ibh<Void, Error> ibh) {
        fal instance = fal.getInstance();
        AnonymousClass7 r1 = new fsm<Void, fso>() {
            /* class _m_j.ftq.AnonymousClass7 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                ibh.onSuccess((Void) obj);
            }

            public final void onFailure(fso fso) {
                ibh.onFailure(new Error(fso.f17063O000000o, fso.O00000Oo));
            }
        };
        exo stateNotifier = ServiceApplication.getStateNotifier();
        if (stateNotifier != null && stateNotifier.f15923O000000o == 4) {
            Context appContext = CommonApplication.getAppContext();
            String string = appContext.getSharedPreferences("third_cloud_account_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), 0).getString("sp_content", "");
            if (!TextUtils.isEmpty(string)) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            arrayList.add(ThirdAccount.O000000o(optJSONObject));
                        }
                    }
                    instance.O00000Oo = arrayList;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        instance.O000000o(r1);
    }

    public int getAllThirdAccountDeviceNum() {
        return fal.getInstance().O000000o().size();
    }

    public void setIcon(SimpleDraweeView simpleDraweeView, String str) {
        fal.O000000o(simpleDraweeView, str);
    }

    public icc logout(final ibh<Void, Error> ibh, String str) {
        return new icc(MijiaLoginManager.O000000o().O000000o(new fsm<Void, fso>() {
            /* class _m_j.ftq.AnonymousClass8 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                ibh.onSuccess((Void) obj);
            }

            public final void onFailure(fso fso) {
                ibh.onFailure(new Error(fso.f17063O000000o, fso.O00000Oo));
            }
        }, str));
    }

    public void logoutWitoutCleanPluginRecord(final ibh<Void, Error> ibh) {
        MijiaLoginManager O000000o2 = MijiaLoginManager.O000000o();
        AnonymousClass9 r1 = new fsm<Void, fso>() {
            /* class _m_j.ftq.AnonymousClass9 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                ibh.onSuccess((Void) obj);
            }

            public final void onFailure(fso fso) {
                ibh.onFailure(new Error(fso.f17063O000000o, fso.O00000Oo));
            }
        };
        LogType logType = LogType.LOGIN;
        gsy.O00000o0(logType, "LoginManager", "logoutWitoutCleanPluginRecord start stack:" + Log.getStackTraceString(new Exception()));
        ezo.O000000o().unregisterPushId(new fsm<Void, fso>(r1) {
            /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass7 */

            /* renamed from: O000000o */
            final /* synthetic */ fsm f7528O000000o;

            {
                this.f7528O000000o = r2;
            }

            public final void onFailure(fso fso) {
                fsm fsm = this.f7528O000000o;
                if (fsm != null) {
                    fsm.sendFailureMessage(new fso(-9999, ""));
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                gty.O000000o().startLogout(false, new ibh<Void, Error>() {
                    /* class com.xiaomi.smarthome.frame.login.MijiaLoginManager.AnonymousClass7.AnonymousClass1 */

                    public final void onFailure(Error error) {
                        if (AnonymousClass7.this.f7528O000000o != null) {
                            AnonymousClass7.this.f7528O000000o.sendFailureMessage(new fso(-9999, ""));
                        }
                        gsy.O00000Oo(4000, "4000.2.1", "");
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
                     arg types: [java.lang.String, int]
                     candidates:
                      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
                      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
                      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.gpu.O000000o(android.content.Context, boolean):void
                     arg types: [android.content.Context, int]
                     candidates:
                      _m_j.gpu.O000000o(android.content.Context, int):boolean
                      _m_j.gpu.O000000o(android.content.Context, boolean):void */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        hna.O00000o0().clearDevicePushBind();
                        gge.O000000o().O00000Oo();
                        fno.O000000o().O0000Oo();
                        hor.O000000o().clearSceneManager();
                        CoreApi.O000000o().O000O0o0();
                        ServiceApplication.getStateNotifier().O000000o(6);
                        fno.O000000o().O0000Oo0();
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("update_remote_wifi_log"));
                        CameraRouterFactory.getCameraManagerApi().cameraFrameManagerDestroyAllContext(ServiceApplication.getAppContext());
                        CameraRouterFactory.getCameraManagerApi().cameraInfoRefreshManagerClear();
                        ezo.O000000o().clearRegedPushIDAndDeviceID();
                        htw O000000o2 = htv.O000000o();
                        if (O000000o2 != null) {
                            O000000o2.stopScanNewDevice();
                        }
                        fus.O000000o();
                        ServiceApplication.getAppContext();
                        hje.O000000o();
                        hje.O00000o0();
                        gfu O000000o3 = gft.O000000o();
                        if (O000000o3 != null) {
                            O000000o3.onLogout();
                        }
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("action_on_logout"));
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("com.xiaomi.youpin.action.on_logout"));
                        gpv.O00000Oo("message_center_red_dot_clicked", true);
                        gpv.O00000Oo("my_home_red_dot_clicked", true);
                        CookieManager.getInstance().removeAllCookie();
                        cmc.O00000o0();
                        fnh.O000000o().O00000Oo();
                        hor.O000000o().clearLiteSceneManager();
                        gvf.O000000o().clear();
                        hor.O000000o().clearRecommendSceneManager();
                        if (AnonymousClass7.this.f7528O000000o != null) {
                            AnonymousClass7.this.f7528O000000o.sendSuccessMessage(null);
                        }
                        try {
                            gpu.O000000o(ServiceApplication.getAppContext(), false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032 A[RETURN] */
    public JSONObject getThirdAccountDeviceById(String str) {
        Device device;
        fal instance = fal.getInstance();
        if (!TextUtils.isEmpty(str)) {
            Iterator<Device> it = instance.O000000o().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                device = it.next();
                if (device.did != null && device.did.equals(str)) {
                    break;
                }
            }
            if (device == null) {
                return device.propInfo;
            }
            return null;
        }
        device = null;
        if (device == null) {
        }
    }

    public String atThirdAccountName(String str) {
        Pair<Integer, ThirdAccount> O00000Oo = fal.getInstance().O00000Oo(str);
        if (O00000Oo == null || O00000Oo.second == null) {
            return null;
        }
        return ((ThirdAccount) O00000Oo.second).f4322O000000o;
    }

    public int getThirdAccountIndex(String str) {
        Pair<Integer, ThirdAccount> O00000Oo = fal.getInstance().O00000Oo(str);
        if (O00000Oo == null || O00000Oo.first == null) {
            return 0;
        }
        return ((Integer) O00000Oo.first).intValue();
    }

    public List<Home> getAllHomes() {
        return ggb.O00000Oo().O0000OoO.O00000Oo;
    }

    public void startSyncHomes() {
        ggb.O00000Oo().O00000o0();
    }

    public String getServerMachineCode() {
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (O0000ooO == null) {
            return "";
        }
        return O0000ooO.f7546O000000o;
    }

    public boolean isCoreReady() {
        return CoreApi.O000000o().O0000O0o();
    }

    public boolean isMiLoggedIn() {
        return CoreApi.O000000o().O0000Ooo();
    }

    public void getMiUserInfoAndProfile(LoginMiAccount loginMiAccount, ibn<MiAccountInfo> ibn) {
        new ibk<MiAccountInfo>(loginMiAccount, ibn, ibn) {
            /* class _m_j.icj.AnonymousClass1 */
            final /* synthetic */ ibn O00000o0;

            {
                this.O00000o0 = r3;
            }

            public final void O000000o(final LoginMiAccount loginMiAccount, final MiServiceTokenInfo miServiceTokenInfo, final boolean z) {
                gor.O000000o(new AsyncTask<Void, Void, Pair<MiAccountInfo, ExceptionError>>() {
                    /* class _m_j.icj.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return O000000o();
                    }

                    public final /* synthetic */ void onPostExecute(Object obj) {
                        Pair pair = (Pair) obj;
                        MiAccountInfo miAccountInfo = (MiAccountInfo) pair.first;
                        ExceptionError exceptionError = (ExceptionError) pair.second;
                        if (exceptionError == null) {
                            gsy.O00000Oo("AccountUserApi", "XMPassport getMiUserInfoAndProfile onSuccess");
                            AnonymousClass1.this.O00000o0.O000000o(miAccountInfo);
                            return;
                        }
                        Exception exc = exceptionError.O00000o0;
                        if (exc != null && (exc instanceof AuthenticationFailureException)) {
                            gsy.O00000Oo("AccountUserApi", "XMPassport AuthenticationFailureException isNeedRefresh=" + z);
                            if (z) {
                                AnonymousClass1.this.O00000Oo();
                                return;
                            }
                        }
                        AnonymousClass1.this.O00000o0.O000000o(exceptionError.f12083O000000o, exceptionError.toString());
                    }

                    /* JADX INFO: additional move instructions added (1) to help type inference */
                    /* JADX WARNING: Removed duplicated region for block: B:54:0x00bb  */
                    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e1  */
                    private Pair<MiAccountInfo, ExceptionError> O000000o() {
                        XiaomiUserProfile xiaomiUserProfile;
                        XiaomiUserInfo xiaomiUserInfo;
                        AccessDeniedException accessDeniedException;
                        InvalidResponseException invalidResponseException;
                        CipherException cipherException;
                        IOException iOException;
                        AuthenticationFailureException authenticationFailureException;
                        AccessDeniedException accessDeniedException2;
                        Exception exc;
                        XiaomiUserInfo xiaomiUserInfo2;
                        XiaomiUserProfile xiaomiUserProfile2;
                        XiaomiUserInfo xiaomiUserInfo3;
                        XiaomiUserProfile xiaomiUserProfile3;
                        XiaomiUserInfo xiaomiUserInfo4;
                        XiaomiUserProfile xiaomiUserProfile4;
                        XiaomiUserInfo xiaomiUserInfo5;
                        XiaomiUserProfile xiaomiUserProfile5;
                        XiaomiUserInfo xiaomiUserInfo6;
                        XiaomiUserProfile xiaomiUserProfile6;
                        PassportInfo passportInfo = new PassportInfo(loginMiAccount.O000000o(), miServiceTokenInfo.O00000Oo, "passportapi", miServiceTokenInfo.O00000o0, miServiceTokenInfo.O00000o);
                        try {
                            gsy.O00000Oo("AccountUserApi", "start get userInfo and profile from XMPassport");
                            XiaomiUserInfo xiaomiUserInfo7 = XMPassport.getXiaomiUserInfo(passportInfo);
                            try {
                                gsy.O00000Oo("AccountUserApi", "userInfo got");
                                XiaomiUserProfile xiaomiUserProfile7 = XMPassport.getXiaomiUserProfile(passportInfo);
                                try {
                                    gsy.O00000Oo("AccountUserApi", "profile got");
                                    xiaomiUserProfile = xiaomiUserProfile7;
                                    xiaomiUserInfo = xiaomiUserInfo7;
                                    accessDeniedException = null;
                                } catch (InvalidResponseException e) {
                                    XiaomiUserProfile xiaomiUserProfile8 = xiaomiUserProfile7;
                                    xiaomiUserInfo2 = xiaomiUserInfo7;
                                    invalidResponseException = e;
                                    xiaomiUserProfile2 = xiaomiUserProfile8;
                                    invalidResponseException.printStackTrace();
                                    accessDeniedException = invalidResponseException;
                                    if (accessDeniedException != null) {
                                    }
                                } catch (CipherException e2) {
                                    XiaomiUserProfile xiaomiUserProfile9 = xiaomiUserProfile7;
                                    xiaomiUserInfo3 = xiaomiUserInfo7;
                                    cipherException = e2;
                                    xiaomiUserProfile3 = xiaomiUserProfile9;
                                    cipherException.printStackTrace();
                                    accessDeniedException = cipherException;
                                    if (accessDeniedException != null) {
                                    }
                                } catch (IOException e3) {
                                    XiaomiUserProfile xiaomiUserProfile10 = xiaomiUserProfile7;
                                    xiaomiUserInfo4 = xiaomiUserInfo7;
                                    iOException = e3;
                                    xiaomiUserProfile4 = xiaomiUserProfile10;
                                    iOException.printStackTrace();
                                    accessDeniedException = iOException;
                                    if (accessDeniedException != null) {
                                    }
                                } catch (AuthenticationFailureException e4) {
                                    XiaomiUserProfile xiaomiUserProfile11 = xiaomiUserProfile7;
                                    xiaomiUserInfo5 = xiaomiUserInfo7;
                                    authenticationFailureException = e4;
                                    xiaomiUserProfile5 = xiaomiUserProfile11;
                                    authenticationFailureException.printStackTrace();
                                    accessDeniedException = authenticationFailureException;
                                    if (accessDeniedException != null) {
                                    }
                                } catch (AccessDeniedException e5) {
                                    XiaomiUserProfile xiaomiUserProfile12 = xiaomiUserProfile7;
                                    xiaomiUserInfo6 = xiaomiUserInfo7;
                                    accessDeniedException2 = e5;
                                    xiaomiUserProfile6 = xiaomiUserProfile12;
                                    accessDeniedException2.printStackTrace();
                                    accessDeniedException = accessDeniedException2;
                                    if (accessDeniedException != null) {
                                    }
                                } catch (Exception e6) {
                                    XiaomiUserProfile xiaomiUserProfile13 = xiaomiUserProfile7;
                                    xiaomiUserInfo = xiaomiUserInfo7;
                                    exc = e6;
                                    xiaomiUserProfile = xiaomiUserProfile13;
                                    exc.printStackTrace();
                                    accessDeniedException = exc;
                                    if (accessDeniedException != null) {
                                    }
                                }
                            } catch (InvalidResponseException e7) {
                                xiaomiUserProfile2 = null;
                                InvalidResponseException invalidResponseException2 = e7;
                                xiaomiUserInfo2 = xiaomiUserInfo7;
                                invalidResponseException = invalidResponseException2;
                                invalidResponseException.printStackTrace();
                                accessDeniedException = invalidResponseException;
                                if (accessDeniedException != null) {
                                }
                            } catch (CipherException e8) {
                                xiaomiUserProfile3 = null;
                                CipherException cipherException2 = e8;
                                xiaomiUserInfo3 = xiaomiUserInfo7;
                                cipherException = cipherException2;
                                cipherException.printStackTrace();
                                accessDeniedException = cipherException;
                                if (accessDeniedException != null) {
                                }
                            } catch (IOException e9) {
                                xiaomiUserProfile4 = null;
                                IOException iOException2 = e9;
                                xiaomiUserInfo4 = xiaomiUserInfo7;
                                iOException = iOException2;
                                iOException.printStackTrace();
                                accessDeniedException = iOException;
                                if (accessDeniedException != null) {
                                }
                            } catch (AuthenticationFailureException e10) {
                                xiaomiUserProfile5 = null;
                                AuthenticationFailureException authenticationFailureException2 = e10;
                                xiaomiUserInfo5 = xiaomiUserInfo7;
                                authenticationFailureException = authenticationFailureException2;
                                authenticationFailureException.printStackTrace();
                                accessDeniedException = authenticationFailureException;
                                if (accessDeniedException != null) {
                                }
                            } catch (AccessDeniedException e11) {
                                xiaomiUserProfile6 = null;
                                AccessDeniedException accessDeniedException3 = e11;
                                xiaomiUserInfo6 = xiaomiUserInfo7;
                                accessDeniedException2 = accessDeniedException3;
                                accessDeniedException2.printStackTrace();
                                accessDeniedException = accessDeniedException2;
                                if (accessDeniedException != null) {
                                }
                            } catch (Exception e12) {
                                xiaomiUserProfile = null;
                                Exception exc2 = e12;
                                xiaomiUserInfo = xiaomiUserInfo7;
                                exc = exc2;
                                exc.printStackTrace();
                                accessDeniedException = exc;
                                if (accessDeniedException != null) {
                                }
                            }
                        } catch (InvalidResponseException e13) {
                            xiaomiUserInfo2 = null;
                            xiaomiUserProfile2 = null;
                            invalidResponseException = e13;
                            invalidResponseException.printStackTrace();
                            accessDeniedException = invalidResponseException;
                            if (accessDeniedException != null) {
                            }
                        } catch (CipherException e14) {
                            xiaomiUserInfo3 = null;
                            xiaomiUserProfile3 = null;
                            cipherException = e14;
                            cipherException.printStackTrace();
                            accessDeniedException = cipherException;
                            if (accessDeniedException != null) {
                            }
                        } catch (IOException e15) {
                            xiaomiUserInfo4 = null;
                            xiaomiUserProfile4 = null;
                            iOException = e15;
                            iOException.printStackTrace();
                            accessDeniedException = iOException;
                            if (accessDeniedException != null) {
                            }
                        } catch (AuthenticationFailureException e16) {
                            xiaomiUserInfo5 = null;
                            xiaomiUserProfile5 = null;
                            authenticationFailureException = e16;
                            authenticationFailureException.printStackTrace();
                            accessDeniedException = authenticationFailureException;
                            if (accessDeniedException != null) {
                            }
                        } catch (AccessDeniedException e17) {
                            xiaomiUserInfo6 = null;
                            xiaomiUserProfile6 = null;
                            accessDeniedException2 = e17;
                            accessDeniedException2.printStackTrace();
                            accessDeniedException = accessDeniedException2;
                            if (accessDeniedException != null) {
                            }
                        } catch (Exception e18) {
                            xiaomiUserInfo = null;
                            xiaomiUserProfile = null;
                            exc = e18;
                            exc.printStackTrace();
                            accessDeniedException = exc;
                            if (accessDeniedException != null) {
                            }
                        }
                        if (accessDeniedException != null) {
                            gsy.O00000Oo("AccountUserApi", "XMPassport exception:" + accessDeniedException.getMessage());
                            ExceptionError exceptionError = new ExceptionError(-1, accessDeniedException.getMessage());
                            exceptionError.O00000o0 = accessDeniedException;
                            return new Pair<>(null, exceptionError);
                        } else if (xiaomiUserInfo == null || xiaomiUserProfile == null) {
                            gsy.O00000Oo("AccountUserApi", "XMPassport exception:userInfo=" + xiaomiUserInfo + ",profile=" + xiaomiUserProfile);
                            return new Pair<>(null, new ExceptionError(-1, "data null"));
                        } else {
                            MiAccountInfo miAccountInfo = new MiAccountInfo();
                            miAccountInfo.f12085O000000o = xiaomiUserInfo.getUserId();
                            miAccountInfo.O00000Oo = xiaomiUserInfo.getUserName();
                            miAccountInfo.O00000o0 = xiaomiUserInfo.getAvatarAddress();
                            miAccountInfo.O00000o = xiaomiUserInfo.getPhone();
                            miAccountInfo.O00000oO = xiaomiUserInfo.getPhoneList();
                            miAccountInfo.O00000oo = xiaomiUserInfo.getEmail();
                            miAccountInfo.O0000O0o = xiaomiUserInfo.getNickName();
                            miAccountInfo.O0000OOo = xiaomiUserInfo.getAvatar();
                            Gender gender = xiaomiUserProfile.getGender();
                            if (gender != null) {
                                if (gender == Gender.MALE) {
                                    miAccountInfo.O0000Oo0 = MiAccountInfo.Gender.MALE;
                                } else if (gender == Gender.FEMALE) {
                                    miAccountInfo.O0000Oo0 = MiAccountInfo.Gender.FEMALE;
                                }
                            }
                            miAccountInfo.O0000Oo = xiaomiUserProfile.getBirthday();
                            return new Pair<>(miAccountInfo, null);
                        }
                    }
                }, new Void[0]);
            }
        }.O000000o();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064 A[SYNTHETIC, Splitter:B:14:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072 A[Catch:{ Exception -> 0x0124 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0088 A[Catch:{ Exception -> 0x0124 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A[Catch:{ Exception -> 0x0124 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00da A[Catch:{ Exception -> 0x0124 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7 A[Catch:{ Exception -> 0x0124 }] */
    public void initAccount() {
        String str;
        String str2;
        efa efa;
        String str3;
        if (ibm.f1156O000000o == null) {
            try {
                String O000000o2 = fln.O000000o(ServiceApplication.getAppContext());
                ibl.O000000o o000000o = new ibl.O000000o();
                o000000o.f1155O000000o = ServiceApplication.getAppContext().getApplicationContext();
                o000000o.O0000o0 = 0;
                o000000o.O0000o0O = true;
                CommonApplication.O000000o<IWXAPI> iWXAPIGetterCallback = ServiceApplication.getIWXAPIGetterCallback();
                o000000o.O00000Oo = "wxxmzh";
                o000000o.O00000o0 = iWXAPIGetterCallback;
                String str4 = "miot-third-test";
                if (gfr.f17662O000000o) {
                    if (XMPassportSettings.isLocalStaging(ServiceApplication.getAppContext())) {
                        str = str4;
                        o000000o.O0000OOo = str;
                        Collections.addAll(o000000o.O0000Oo0, "miotstore", "xiaoqiang", "passportapi", "xiaomihome", "mi_eshopm_go", "i.ai.mi.com", "mi_huodong", "ypsupport2", "tsm-auth", "kfs_chat");
                        if (!gfr.O0000OOo) {
                            if (!gfr.O0000Oo) {
                                str2 = "";
                                if (!TextUtils.isEmpty(str2)) {
                                    o000000o.O0000Oo0.add(str2);
                                }
                                Collections.addAll(o000000o.O0000Oo, "passportapi", "xiaomihome");
                                if (!gfr.O0000OOo) {
                                    if (!gfr.O0000Oo) {
                                        str4 = "";
                                    }
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    o000000o.O0000Oo.add(str4);
                                }
                                o000000o.O00000o = "690839864422812";
                                o000000o.O0000Ooo = true;
                                o000000o.O0000o00 = new AuthComponent(ServiceApplication.getAppContext());
                                o000000o.O0000OoO = new ibi() {
                                    /* class _m_j.ftk.AnonymousClass2 */

                                    public final String O00000o0() {
                                        return "";
                                    }

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: ClspMth{android.accounts.AccountManager.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>}
                                     arg types: [android.accounts.Account, java.lang.String, ?[OBJECT, ARRAY], int, _m_j.hsy$2, ?[OBJECT, ARRAY]]
                                     candidates:
                                      ClspMth{android.accounts.AccountManager.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>}
                                      ClspMth{android.accounts.AccountManager.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>} */
                                    public final void O000000o(WebView webView, String str, String str2, final ibi.O000000o o000000o) {
                                        new Object() {
                                            /* class _m_j.ftk.AnonymousClass2.AnonymousClass1 */
                                        };
                                        MiotAccountProvider O000000o2 = MiotAccountProvider.O000000o(CommonApplication.getAppContext());
                                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getAccountsByType(): ".concat(String.valueOf(str)));
                                        String O0000o0 = CoreApi.O000000o().O0000o0();
                                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getAccounts(): ".concat(String.valueOf(O0000o0)));
                                        Account[] accountArr = !TextUtils.isEmpty(O0000o0) ? new Account[]{new Account(O0000o0, "com.xiaomi")} : null;
                                        if (accountArr != null) {
                                            WeakReference weakReference = new WeakReference(webView);
                                            String concat = "weblogin:".concat(String.valueOf(str2));
                                            if (!CoreApi.O000000o().O0000oO0()) {
                                                Account account = accountArr[0];
                                                hsy.AnonymousClass1 r4 = new AccountManagerCallback<Bundle>(weakReference) {
                                                    /* class _m_j.hsy.AnonymousClass1 */

                                                    /* renamed from: O000000o */
                                                    final /* synthetic */ WeakReference f608O000000o;

                                                    {
                                                        this.f608O000000o = r1;
                                                    }

                                                    public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                                                        try {
                                                            String string = accountManagerFuture.getResult().getString("authtoken");
                                                            if (!TextUtils.isEmpty(string) && this.f608O000000o.get() != null) {
                                                                ((WebView) this.f608O000000o.get()).loadUrl(string);
                                                                ((WebView) this.f608O000000o.get()).postDelayed(new Runnable() {
                                                                    /* class _m_j.hsy.AnonymousClass1.AnonymousClass1 */

                                                                    public final void run() {
                                                                        if (AnonymousClass1.this.f608O000000o.get() != null) {
                                                                            ((WebView) AnonymousClass1.this.f608O000000o.get()).clearHistory();
                                                                        }
                                                                    }
                                                                }, 1000);
                                                            }
                                                        } catch (Exception unused) {
                                                        }
                                                    }
                                                };
                                                LogType logType = LogType.GENERAL;
                                                gsy.O000000o(logType, "MiotAccountProvider", "getAuthToken(): 2 " + account + ", " + concat + ", false");
                                                if (account == null) {
                                                    throw new IllegalArgumentException("account is null");
                                                } else if (concat != null) {
                                                    Bundle bundle = new Bundle();
                                                    bundle.putString("androidPackageName", O000000o2.f11381O000000o.getPackageName());
                                                    new MiotAccountProvider.AmsTask(null, null, r4, account, concat, Boolean.FALSE, bundle) {
                                                        /* class com.xiaomi.smarthome.shop.MiotAccountProvider.AnonymousClass2 */
                                                        final /* synthetic */ Account val$account1;
                                                        final /* synthetic */ String val$authTokenType1;
                                                        final /* synthetic */ Boolean val$notifyAuthFailure1;
                                                        final /* synthetic */ Bundle val$optionsIn;

                                                        {
                                                            this.val$account1 = r5;
                                                            this.val$authTokenType1 = r6;
                                                            this.val$notifyAuthFailure1 = r7;
                                                            this.val$optionsIn = r8;
                                                        }

                                                        public void doWork() {
                                                            goq.O000000o(new Runnable() {
                                                                /* class com.xiaomi.smarthome.shop.MiotAccountProvider.AnonymousClass2.AnonymousClass1 */

                                                                public final void run() {
                                                                    O000000o o000000o = AnonymousClass2.this.mResponse;
                                                                    Account account = AnonymousClass2.this.val$account1;
                                                                    String str = AnonymousClass2.this.val$authTokenType1;
                                                                    AnonymousClass2.this.val$notifyAuthFailure1.booleanValue();
                                                                    MiotAccountProvider.O000000o(o000000o, account, str);
                                                                }
                                                            });
                                                        }
                                                    }.start();
                                                } else {
                                                    throw new IllegalArgumentException("authTokenType is null");
                                                }
                                            } else {
                                                AccountManager.get(CommonApplication.getAppContext()).getAuthToken(accountArr[0], concat, (Bundle) null, false, (AccountManagerCallback<Bundle>) new AccountManagerCallback<Bundle>(weakReference) {
                                                    /* class _m_j.hsy.AnonymousClass2 */

                                                    /* renamed from: O000000o */
                                                    final /* synthetic */ WeakReference f610O000000o;

                                                    {
                                                        this.f610O000000o = r1;
                                                    }

                                                    public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                                                        try {
                                                            String string = accountManagerFuture.getResult().getString("authtoken");
                                                            if (!TextUtils.isEmpty(string) && this.f610O000000o.get() != null) {
                                                                ((WebView) this.f610O000000o.get()).loadUrl(string);
                                                                ((WebView) this.f610O000000o.get()).postDelayed(new Runnable() {
                                                                    /* class _m_j.hsy.AnonymousClass2.AnonymousClass1 */

                                                                    public final void run() {
                                                                        if (AnonymousClass2.this.f610O000000o.get() != null) {
                                                                            ((WebView) AnonymousClass2.this.f610O000000o.get()).clearHistory();
                                                                        }
                                                                    }
                                                                }, 1000);
                                                            }
                                                        } catch (Exception unused) {
                                                        }
                                                    }
                                                }, (Handler) null);
                                            }
                                        }
                                    }

                                    public final boolean O000000o() {
                                        return ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
                                    }

                                    public final Pair<Long, Boolean> O00000Oo() {
                                        Pair<Long, Boolean> O00000o0 = ServerTimerManager.O00000o0();
                                        LogType logType = LogType.LOGIN;
                                        gsy.O00000o0(logType, "SHApplication", "get timeDiff from network:" + O00000o0.second + ":" + O00000o0.first);
                                        return O00000o0;
                                    }
                                };
                                o000000o.O0000o00 = new AuthComponent(ServiceApplication.getAppContext());
                                o000000o.O0000o0o = O000000o2;
                                o000000o.O00000oO = new ibs() {
                                    /* class _m_j.ftk.AnonymousClass1 */

                                    public final void O000000o() {
                                        gsy.O00000Oo("login", "setUserLicenseConfig ");
                                        DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "", "accept", null);
                                    }

                                    public final void O000000o(String str, Map<String, String> map) {
                                        if (gfr.O0000Ooo) {
                                            try {
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(str);
                                                sb.append(":");
                                                sb.append(map == null ? null : map.toString());
                                                String sb2 = sb.toString();
                                                gsy.O00000Oo(LogType.LOGIN, "login", sb2);
                                                if (ServiceApplication.shouldEnableBugly()) {
                                                    CrashReport.O000000o(new MijiaLoginManager.LoginException(sb2));
                                                }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                };
                                ibl ibl = new ibl(o000000o, (byte) 0);
                                CommonApplication application = ServiceApplication.getApplication();
                                PassportUserEnvironment.O000000o.O000000o(new PassportUserEnvironment());
                                efa = ibl.O0000o00;
                                if (efa != null) {
                                    eeu.f15193O000000o = efa;
                                }
                                XMPassportSettings.setApplicationContext(application);
                                str3 = ibl.O0000o0;
                                if (!TextUtils.isEmpty(str3)) {
                                    XMPassportSettings.setUserAgent(str3);
                                }
                                ibm.f1156O000000o = ibl;
                                boolean O00000oO = ftn.O00000oO(ServiceApplication.getAppContext());
                                egt.f15254O000000o.O000000o(ServiceApplication.getAppContext());
                                gsy.O000000o(3, "AAAA", "setInternational: ".concat(String.valueOf(O00000oO)));
                                gsy.O00000Oo(LogType.STARTUP, "userAgent", "ua:".concat(String.valueOf(O000000o2)));
                                System.setProperty("http.agent", O000000o2);
                            }
                        }
                        str2 = str4;
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        Collections.addAll(o000000o.O0000Oo, "passportapi", "xiaomihome");
                        if (!gfr.O0000OOo) {
                        }
                        if (!TextUtils.isEmpty(str4)) {
                        }
                        o000000o.O00000o = "690839864422812";
                        o000000o.O0000Ooo = true;
                        o000000o.O0000o00 = new AuthComponent(ServiceApplication.getAppContext());
                        o000000o.O0000OoO = new ibi() {
                            /* class _m_j.ftk.AnonymousClass2 */

                            public final String O00000o0() {
                                return "";
                            }

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: ClspMth{android.accounts.AccountManager.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>}
                             arg types: [android.accounts.Account, java.lang.String, ?[OBJECT, ARRAY], int, _m_j.hsy$2, ?[OBJECT, ARRAY]]
                             candidates:
                              ClspMth{android.accounts.AccountManager.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>}
                              ClspMth{android.accounts.AccountManager.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>} */
                            public final void O000000o(WebView webView, String str, String str2, final ibi.O000000o o000000o) {
                                new Object() {
                                    /* class _m_j.ftk.AnonymousClass2.AnonymousClass1 */
                                };
                                MiotAccountProvider O000000o2 = MiotAccountProvider.O000000o(CommonApplication.getAppContext());
                                gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getAccountsByType(): ".concat(String.valueOf(str)));
                                String O0000o0 = CoreApi.O000000o().O0000o0();
                                gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getAccounts(): ".concat(String.valueOf(O0000o0)));
                                Account[] accountArr = !TextUtils.isEmpty(O0000o0) ? new Account[]{new Account(O0000o0, "com.xiaomi")} : null;
                                if (accountArr != null) {
                                    WeakReference weakReference = new WeakReference(webView);
                                    String concat = "weblogin:".concat(String.valueOf(str2));
                                    if (!CoreApi.O000000o().O0000oO0()) {
                                        Account account = accountArr[0];
                                        hsy.AnonymousClass1 r4 = new AccountManagerCallback<Bundle>(weakReference) {
                                            /* class _m_j.hsy.AnonymousClass1 */

                                            /* renamed from: O000000o */
                                            final /* synthetic */ WeakReference f608O000000o;

                                            {
                                                this.f608O000000o = r1;
                                            }

                                            public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                                                try {
                                                    String string = accountManagerFuture.getResult().getString("authtoken");
                                                    if (!TextUtils.isEmpty(string) && this.f608O000000o.get() != null) {
                                                        ((WebView) this.f608O000000o.get()).loadUrl(string);
                                                        ((WebView) this.f608O000000o.get()).postDelayed(new Runnable() {
                                                            /* class _m_j.hsy.AnonymousClass1.AnonymousClass1 */

                                                            public final void run() {
                                                                if (AnonymousClass1.this.f608O000000o.get() != null) {
                                                                    ((WebView) AnonymousClass1.this.f608O000000o.get()).clearHistory();
                                                                }
                                                            }
                                                        }, 1000);
                                                    }
                                                } catch (Exception unused) {
                                                }
                                            }
                                        };
                                        LogType logType = LogType.GENERAL;
                                        gsy.O000000o(logType, "MiotAccountProvider", "getAuthToken(): 2 " + account + ", " + concat + ", false");
                                        if (account == null) {
                                            throw new IllegalArgumentException("account is null");
                                        } else if (concat != null) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString("androidPackageName", O000000o2.f11381O000000o.getPackageName());
                                            new MiotAccountProvider.AmsTask(null, null, r4, account, concat, Boolean.FALSE, bundle) {
                                                /* class com.xiaomi.smarthome.shop.MiotAccountProvider.AnonymousClass2 */
                                                final /* synthetic */ Account val$account1;
                                                final /* synthetic */ String val$authTokenType1;
                                                final /* synthetic */ Boolean val$notifyAuthFailure1;
                                                final /* synthetic */ Bundle val$optionsIn;

                                                {
                                                    this.val$account1 = r5;
                                                    this.val$authTokenType1 = r6;
                                                    this.val$notifyAuthFailure1 = r7;
                                                    this.val$optionsIn = r8;
                                                }

                                                public void doWork() {
                                                    goq.O000000o(new Runnable() {
                                                        /* class com.xiaomi.smarthome.shop.MiotAccountProvider.AnonymousClass2.AnonymousClass1 */

                                                        public final void run() {
                                                            O000000o o000000o = AnonymousClass2.this.mResponse;
                                                            Account account = AnonymousClass2.this.val$account1;
                                                            String str = AnonymousClass2.this.val$authTokenType1;
                                                            AnonymousClass2.this.val$notifyAuthFailure1.booleanValue();
                                                            MiotAccountProvider.O000000o(o000000o, account, str);
                                                        }
                                                    });
                                                }
                                            }.start();
                                        } else {
                                            throw new IllegalArgumentException("authTokenType is null");
                                        }
                                    } else {
                                        AccountManager.get(CommonApplication.getAppContext()).getAuthToken(accountArr[0], concat, (Bundle) null, false, (AccountManagerCallback<Bundle>) new AccountManagerCallback<Bundle>(weakReference) {
                                            /* class _m_j.hsy.AnonymousClass2 */

                                            /* renamed from: O000000o */
                                            final /* synthetic */ WeakReference f610O000000o;

                                            {
                                                this.f610O000000o = r1;
                                            }

                                            public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                                                try {
                                                    String string = accountManagerFuture.getResult().getString("authtoken");
                                                    if (!TextUtils.isEmpty(string) && this.f610O000000o.get() != null) {
                                                        ((WebView) this.f610O000000o.get()).loadUrl(string);
                                                        ((WebView) this.f610O000000o.get()).postDelayed(new Runnable() {
                                                            /* class _m_j.hsy.AnonymousClass2.AnonymousClass1 */

                                                            public final void run() {
                                                                if (AnonymousClass2.this.f610O000000o.get() != null) {
                                                                    ((WebView) AnonymousClass2.this.f610O000000o.get()).clearHistory();
                                                                }
                                                            }
                                                        }, 1000);
                                                    }
                                                } catch (Exception unused) {
                                                }
                                            }
                                        }, (Handler) null);
                                    }
                                }
                            }

                            public final boolean O000000o() {
                                return ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
                            }

                            public final Pair<Long, Boolean> O00000Oo() {
                                Pair<Long, Boolean> O00000o0 = ServerTimerManager.O00000o0();
                                LogType logType = LogType.LOGIN;
                                gsy.O00000o0(logType, "SHApplication", "get timeDiff from network:" + O00000o0.second + ":" + O00000o0.first);
                                return O00000o0;
                            }
                        };
                        o000000o.O0000o00 = new AuthComponent(ServiceApplication.getAppContext());
                        o000000o.O0000o0o = O000000o2;
                        o000000o.O00000oO = new ibs() {
                            /* class _m_j.ftk.AnonymousClass1 */

                            public final void O000000o() {
                                gsy.O00000Oo("login", "setUserLicenseConfig ");
                                DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "", "accept", null);
                            }

                            public final void O000000o(String str, Map<String, String> map) {
                                if (gfr.O0000Ooo) {
                                    try {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(str);
                                        sb.append(":");
                                        sb.append(map == null ? null : map.toString());
                                        String sb2 = sb.toString();
                                        gsy.O00000Oo(LogType.LOGIN, "login", sb2);
                                        if (ServiceApplication.shouldEnableBugly()) {
                                            CrashReport.O000000o(new MijiaLoginManager.LoginException(sb2));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                        ibl ibl2 = new ibl(o000000o, (byte) 0);
                        CommonApplication application2 = ServiceApplication.getApplication();
                        PassportUserEnvironment.O000000o.O000000o(new PassportUserEnvironment());
                        efa = ibl2.O0000o00;
                        if (efa != null) {
                        }
                        XMPassportSettings.setApplicationContext(application2);
                        str3 = ibl2.O0000o0;
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        ibm.f1156O000000o = ibl2;
                        boolean O00000oO2 = ftn.O00000oO(ServiceApplication.getAppContext());
                        egt.f15254O000000o.O000000o(ServiceApplication.getAppContext());
                        gsy.O000000o(3, "AAAA", "setInternational: ".concat(String.valueOf(O00000oO2)));
                        gsy.O00000Oo(LogType.STARTUP, "userAgent", "ua:".concat(String.valueOf(O000000o2)));
                        System.setProperty("http.agent", O000000o2);
                    }
                }
                str = "xiaomiio";
                o000000o.O0000OOo = str;
                Collections.addAll(o000000o.O0000Oo0, "miotstore", "xiaoqiang", "passportapi", "xiaomihome", "mi_eshopm_go", "i.ai.mi.com", "mi_huodong", "ypsupport2", "tsm-auth", "kfs_chat");
                if (!gfr.O0000OOo) {
                }
                str2 = str4;
                if (!TextUtils.isEmpty(str2)) {
                }
                Collections.addAll(o000000o.O0000Oo, "passportapi", "xiaomihome");
                if (!gfr.O0000OOo) {
                }
                if (!TextUtils.isEmpty(str4)) {
                }
                o000000o.O00000o = "690839864422812";
                o000000o.O0000Ooo = true;
                o000000o.O0000o00 = new AuthComponent(ServiceApplication.getAppContext());
                o000000o.O0000OoO = new ibi() {
                    /* class _m_j.ftk.AnonymousClass2 */

                    public final String O00000o0() {
                        return "";
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: ClspMth{android.accounts.AccountManager.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>}
                     arg types: [android.accounts.Account, java.lang.String, ?[OBJECT, ARRAY], int, _m_j.hsy$2, ?[OBJECT, ARRAY]]
                     candidates:
                      ClspMth{android.accounts.AccountManager.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>}
                      ClspMth{android.accounts.AccountManager.getAuthToken(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>} */
                    public final void O000000o(WebView webView, String str, String str2, final ibi.O000000o o000000o) {
                        new Object() {
                            /* class _m_j.ftk.AnonymousClass2.AnonymousClass1 */
                        };
                        MiotAccountProvider O000000o2 = MiotAccountProvider.O000000o(CommonApplication.getAppContext());
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getAccountsByType(): ".concat(String.valueOf(str)));
                        String O0000o0 = CoreApi.O000000o().O0000o0();
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getAccounts(): ".concat(String.valueOf(O0000o0)));
                        Account[] accountArr = !TextUtils.isEmpty(O0000o0) ? new Account[]{new Account(O0000o0, "com.xiaomi")} : null;
                        if (accountArr != null) {
                            WeakReference weakReference = new WeakReference(webView);
                            String concat = "weblogin:".concat(String.valueOf(str2));
                            if (!CoreApi.O000000o().O0000oO0()) {
                                Account account = accountArr[0];
                                hsy.AnonymousClass1 r4 = new AccountManagerCallback<Bundle>(weakReference) {
                                    /* class _m_j.hsy.AnonymousClass1 */

                                    /* renamed from: O000000o */
                                    final /* synthetic */ WeakReference f608O000000o;

                                    {
                                        this.f608O000000o = r1;
                                    }

                                    public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                                        try {
                                            String string = accountManagerFuture.getResult().getString("authtoken");
                                            if (!TextUtils.isEmpty(string) && this.f608O000000o.get() != null) {
                                                ((WebView) this.f608O000000o.get()).loadUrl(string);
                                                ((WebView) this.f608O000000o.get()).postDelayed(new Runnable() {
                                                    /* class _m_j.hsy.AnonymousClass1.AnonymousClass1 */

                                                    public final void run() {
                                                        if (AnonymousClass1.this.f608O000000o.get() != null) {
                                                            ((WebView) AnonymousClass1.this.f608O000000o.get()).clearHistory();
                                                        }
                                                    }
                                                }, 1000);
                                            }
                                        } catch (Exception unused) {
                                        }
                                    }
                                };
                                LogType logType = LogType.GENERAL;
                                gsy.O000000o(logType, "MiotAccountProvider", "getAuthToken(): 2 " + account + ", " + concat + ", false");
                                if (account == null) {
                                    throw new IllegalArgumentException("account is null");
                                } else if (concat != null) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("androidPackageName", O000000o2.f11381O000000o.getPackageName());
                                    new MiotAccountProvider.AmsTask(null, null, r4, account, concat, Boolean.FALSE, bundle) {
                                        /* class com.xiaomi.smarthome.shop.MiotAccountProvider.AnonymousClass2 */
                                        final /* synthetic */ Account val$account1;
                                        final /* synthetic */ String val$authTokenType1;
                                        final /* synthetic */ Boolean val$notifyAuthFailure1;
                                        final /* synthetic */ Bundle val$optionsIn;

                                        {
                                            this.val$account1 = r5;
                                            this.val$authTokenType1 = r6;
                                            this.val$notifyAuthFailure1 = r7;
                                            this.val$optionsIn = r8;
                                        }

                                        public void doWork() {
                                            goq.O000000o(new Runnable() {
                                                /* class com.xiaomi.smarthome.shop.MiotAccountProvider.AnonymousClass2.AnonymousClass1 */

                                                public final void run() {
                                                    O000000o o000000o = AnonymousClass2.this.mResponse;
                                                    Account account = AnonymousClass2.this.val$account1;
                                                    String str = AnonymousClass2.this.val$authTokenType1;
                                                    AnonymousClass2.this.val$notifyAuthFailure1.booleanValue();
                                                    MiotAccountProvider.O000000o(o000000o, account, str);
                                                }
                                            });
                                        }
                                    }.start();
                                } else {
                                    throw new IllegalArgumentException("authTokenType is null");
                                }
                            } else {
                                AccountManager.get(CommonApplication.getAppContext()).getAuthToken(accountArr[0], concat, (Bundle) null, false, (AccountManagerCallback<Bundle>) new AccountManagerCallback<Bundle>(weakReference) {
                                    /* class _m_j.hsy.AnonymousClass2 */

                                    /* renamed from: O000000o */
                                    final /* synthetic */ WeakReference f610O000000o;

                                    {
                                        this.f610O000000o = r1;
                                    }

                                    public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                                        try {
                                            String string = accountManagerFuture.getResult().getString("authtoken");
                                            if (!TextUtils.isEmpty(string) && this.f610O000000o.get() != null) {
                                                ((WebView) this.f610O000000o.get()).loadUrl(string);
                                                ((WebView) this.f610O000000o.get()).postDelayed(new Runnable() {
                                                    /* class _m_j.hsy.AnonymousClass2.AnonymousClass1 */

                                                    public final void run() {
                                                        if (AnonymousClass2.this.f610O000000o.get() != null) {
                                                            ((WebView) AnonymousClass2.this.f610O000000o.get()).clearHistory();
                                                        }
                                                    }
                                                }, 1000);
                                            }
                                        } catch (Exception unused) {
                                        }
                                    }
                                }, (Handler) null);
                            }
                        }
                    }

                    public final boolean O000000o() {
                        return ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
                    }

                    public final Pair<Long, Boolean> O00000Oo() {
                        Pair<Long, Boolean> O00000o0 = ServerTimerManager.O00000o0();
                        LogType logType = LogType.LOGIN;
                        gsy.O00000o0(logType, "SHApplication", "get timeDiff from network:" + O00000o0.second + ":" + O00000o0.first);
                        return O00000o0;
                    }
                };
                o000000o.O0000o00 = new AuthComponent(ServiceApplication.getAppContext());
                o000000o.O0000o0o = O000000o2;
                o000000o.O00000oO = new ibs() {
                    /* class _m_j.ftk.AnonymousClass1 */

                    public final void O000000o() {
                        gsy.O00000Oo("login", "setUserLicenseConfig ");
                        DeviceApi.getInstance().setUserLicenseConfig(ServiceApplication.getAppContext(), "", "accept", null);
                    }

                    public final void O000000o(String str, Map<String, String> map) {
                        if (gfr.O0000Ooo) {
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append(str);
                                sb.append(":");
                                sb.append(map == null ? null : map.toString());
                                String sb2 = sb.toString();
                                gsy.O00000Oo(LogType.LOGIN, "login", sb2);
                                if (ServiceApplication.shouldEnableBugly()) {
                                    CrashReport.O000000o(new MijiaLoginManager.LoginException(sb2));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                ibl ibl22 = new ibl(o000000o, (byte) 0);
                CommonApplication application22 = ServiceApplication.getApplication();
                PassportUserEnvironment.O000000o.O000000o(new PassportUserEnvironment());
                efa = ibl22.O0000o00;
                if (efa != null) {
                }
                XMPassportSettings.setApplicationContext(application22);
                str3 = ibl22.O0000o0;
                if (!TextUtils.isEmpty(str3)) {
                }
                ibm.f1156O000000o = ibl22;
                boolean O00000oO22 = ftn.O00000oO(ServiceApplication.getAppContext());
                egt.f15254O000000o.O000000o(ServiceApplication.getAppContext());
                gsy.O000000o(3, "AAAA", "setInternational: ".concat(String.valueOf(O00000oO22)));
                gsy.O00000Oo(LogType.STARTUP, "userAgent", "ua:".concat(String.valueOf(O000000o2)));
                System.setProperty("http.agent", O000000o2);
            } catch (Exception e) {
                gsy.O00000o0(LogType.LOGIN, "SHApplication", Log.getStackTraceString(e));
            }
        }
    }

    public boolean doesLoginWithSystemAccount() {
        if (!CoreApi.O000000o().O0000Ooo()) {
            return false;
        }
        if (CoreApi.O000000o().O0000oO0()) {
            return true;
        }
        if (!ftk.O000000o() || !TextUtils.equals(CoreApi.O000000o().O0000o0(), ftk.O00000Oo())) {
            return false;
        }
        return true;
    }
}
