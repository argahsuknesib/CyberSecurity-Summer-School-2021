package com.xiaomi.mico.api;

import _m_j.ahh;
import _m_j.eez;
import _m_j.exo;
import _m_j.ft;
import _m_j.ftn;
import _m_j.gsy;
import _m_j.jgc;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.mico.api.AccountInfo;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiEvent;
import com.xiaomi.mico.api.exception.NeedUserInteractionException;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.mico.setting.mijia.MijiaCacheManager;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class LoginManager implements ApiResponseHandler, CookieJar {
    @SuppressLint({"StaticFieldLeak"})
    private static LoginManager sInstance;
    public AccountInfo mAccountInfo;
    public final MiAccountManager mAccountManager;
    public final AccountStore mAccountStore;
    private Set<CacheCookie> mCacheCookies = new HashSet();
    private List<LoginManagerCallback> mCallbackList = new ArrayList();
    public final Context mContext;
    private final Object mCookieLock = new Object();
    private final Handler mHandler;
    private List<ApiRequest> mPendingRequests = new ArrayList();
    private final Object mRequestLock = new Object();
    private final Scheduler mScheduler;
    private final ServiceTokenStatus mServiceTokenStatus = new ServiceTokenStatus();
    public ServiceTokenResult serviceTokenResult;
    private String serviceid;

    public interface LoginManagerCallback {
        void onLoginSuccess();

        void onLogout();
    }

    enum State {
        INITIALIZED,
        VALID,
        REFRESHING,
        LOGIN_REQUIRED
    }

    static LoginManager init(Context context, Scheduler scheduler, Handler handler, AccountLog accountLog) {
        if (sInstance == null) {
            LoginManager loginManager = new LoginManager(context, scheduler, handler, accountLog);
            sInstance = loginManager;
            return loginManager;
        }
        throw new IllegalStateException("LoginManager has already been initialized.");
    }

    public static LoginManager getInstance() {
        LoginManager loginManager = sInstance;
        if (loginManager != null) {
            return loginManager;
        }
        throw new IllegalStateException("LoginManager has not been initialized.");
    }

    static class ServiceTokenStatus {
        public long lastRefreshTimeStamp;
        public State state;

        private ServiceTokenStatus() {
            this.state = State.INITIALIZED;
            this.lastRefreshTimeStamp = 0;
        }
    }

    private LoginManager(Context context, Scheduler scheduler, Handler handler, AccountLog accountLog) {
        this.mContext = context;
        this.mScheduler = scheduler;
        this.mHandler = handler;
        registerAccountReceiver();
        AccountLog.setInstance(accountLog);
        this.mAccountManager = MiAccountManager.O00000Oo(context);
        this.mAccountStore = new SharedPrefsStore(context);
        loadAccountInfo();
    }

    private synchronized void loadAccountInfo() {
        if (this.mAccountInfo == null) {
            this.mAccountInfo = AccountInfo.load(this.mAccountManager, this.mAccountStore);
            if (this.mAccountInfo.isPassportValid()) {
                if (this.mAccountInfo.isCoreServiceValid()) {
                    addOrUpdateCookies(ApiConstants.MICO_SID);
                }
                updateServiceTokenStatus(ApiConstants.MICO_SID, State.VALID, 0);
                return;
            }
            updateAccountInfo();
            return;
        }
        throw new IllegalStateException("Account info has been loaded.");
    }

    public void updateAccountInfo() {
        CoreApi.O000000o().O000000o(this.mContext, new CoreApi.O0000o00() {
            /* class com.xiaomi.mico.api.LoginManager.AnonymousClass1 */

            public void onAccountReady(boolean z, String str) {
                ServiceApplication.getStateNotifier().O000000o(new exo.O000000o() {
                    /* class com.xiaomi.mico.api.LoginManager.AnonymousClass1.AnonymousClass1 */

                    public void onLoginSuccess() {
                        LoginManager.this.loginByInit(LoginManager.this.mContext).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<LoginState>() {
                            /* class com.xiaomi.mico.api.LoginManager.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            public void call(LoginState loginState) {
                                LoginManager.this.notifyLoginSuccess();
                            }
                        }, new Action1<Throwable>() {
                            /* class com.xiaomi.mico.api.LoginManager.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                            public void call(Throwable th) {
                                gsy.O00000Oo(12000, "12000.7.1", "");
                                ahh.O000000o(th);
                            }
                        });
                    }

                    public void onLoginFailed() {
                        gsy.O00000Oo(12000, "12000.7.1", "");
                    }
                });
            }
        });
    }

    public void addOrUpdateCookies(String str) {
        String str2 = str;
        int i = 1;
        Object[] objArr = {"add or update cookies sid=%s", str2};
        if (ApiConstants.MICO_SID.equals(str2)) {
            ApiConstants.ServiceConfig[] officeServices = ApiConstants.getOfficeServices();
            String currentMicoID = MicoManager.getInstance().getCurrentMicoID();
            String currentMicoSN = MicoManager.getInstance().getCurrentMicoSN();
            Object[] objArr2 = new Object[2];
            objArr2[0] = "device id %s";
            objArr2[1] = TextUtils.isEmpty(currentMicoID) ? "blank" : currentMicoID;
            int i2 = 0;
            while (i2 < officeServices.length) {
                String[] strArr = new String[2];
                strArr[0] = officeServices[i2].getBaseUrl();
                strArr[i] = officeServices[i2].getPreviewUrl();
                int i3 = 0;
                while (i3 < 2) {
                    HttpUrl parse = HttpUrl.parse(strArr[i3]);
                    if (parse == null) {
                        new Object[i][0] = "no HttpUrl for " + strArr[i3];
                    } else {
                        ArrayList arrayList = new ArrayList(5);
                        Cookie.Builder path = new Cookie.Builder().domain(parse.host()).path("/");
                        new Object[i][0] = "host " + parse.host();
                        if (parse.isHttps()) {
                            path.secure();
                        }
                        arrayList.add(path.name("userId").value(this.mAccountInfo.getPassportInfo().getUserId()).build());
                        arrayList.add(path.name("serviceToken").value(this.mAccountInfo.getServiceInfo(str2).getServiceToken()).build());
                        if (!TextUtils.isEmpty(currentMicoID)) {
                            arrayList.add(path.name("deviceId").value(currentMicoID).build());
                            Object[] objArr3 = {"device id=%s", currentMicoID};
                        } else {
                            new Object[1][0] = "empty device id";
                        }
                        arrayList.add(path.name("partnerSource").value("mihome").build());
                        arrayList.add(path.name("sn").value(currentMicoSN).build());
                        saveFromResponse(parse, arrayList);
                    }
                    i3++;
                    i = 1;
                }
                i2++;
                i = 1;
            }
        }
    }

    public void changeDeviceIdCookie() {
        new Object[1][0] = "changeDeviceIdCookie";
        if (this.mAccountInfo.isPassportValid() && this.mAccountInfo.isCoreServiceValid()) {
            addOrUpdateCookies(ApiConstants.MICO_SID);
        }
    }

    public void updateServiceTokenStatus(String str, State state, long j) {
        if (ApiConstants.MICO_SID.equals(str)) {
            ServiceTokenStatus serviceTokenStatus = this.mServiceTokenStatus;
            serviceTokenStatus.state = state;
            serviceTokenStatus.lastRefreshTimeStamp = j;
        }
    }

    /* access modifiers changed from: package-private */
    public void onServerEnvSwitched() {
        if (this.mAccountInfo.isPassportValid() && this.mAccountInfo.isCoreServiceValid()) {
            addOrUpdateCookies(ApiConstants.MICO_SID);
        }
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        synchronized (this.mCookieLock) {
            Object[] objArr = {"cooooooooooookie=%s", this.mCacheCookies.toString()};
            if (this.mCacheCookies != null) {
                if (!this.mCacheCookies.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<CacheCookie> it = this.mCacheCookies.iterator();
                    while (it.hasNext()) {
                        Cookie cookie = it.next().getCookie();
                        if (cookie.expiresAt() < System.currentTimeMillis()) {
                            it.remove();
                        } else if (cookie.matches(httpUrl)) {
                            arrayList.add(cookie);
                        }
                    }
                    return arrayList;
                }
            }
            List<Cookie> emptyList = Collections.emptyList();
            return emptyList;
        }
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        synchronized (this.mCookieLock) {
            for (CacheCookie next : CacheCookie.decorateCookies(list)) {
                this.mCacheCookies.remove(next);
                this.mCacheCookies.add(next);
            }
        }
    }

    public Scheduler getScheduler() {
        return this.mScheduler;
    }

    public void retry(ApiRequest apiRequest) {
        if (this.mServiceTokenStatus.state == State.VALID) {
            if (TimeUnit.MILLISECONDS.toSeconds(Math.abs(System.currentTimeMillis() - this.mServiceTokenStatus.lastRefreshTimeStamp)) > 20) {
                synchronized (this.mRequestLock) {
                    this.mPendingRequests.add(apiRequest);
                }
                updateServiceTokenStatus(ApiConstants.MICO_SID, State.REFRESHING, System.currentTimeMillis());
                refreshServiceToken(ApiConstants.MICO_SID).subscribe(new Action1<String>() {
                    /* class com.xiaomi.mico.api.LoginManager.AnonymousClass2 */

                    public void call(String str) {
                        if (!TextUtils.isEmpty(str)) {
                            LoginManager.this.executePendingRequests();
                        } else {
                            LoginManager.this.failedToRefreshServiceToken();
                        }
                    }
                }, new Action1<Throwable>() {
                    /* class com.xiaomi.mico.api.LoginManager.AnonymousClass3 */

                    public void call(Throwable th) {
                        LoginManager.this.failedToRefreshServiceToken();
                    }
                });
                return;
            }
            executeRequest(apiRequest);
        } else if (this.mServiceTokenStatus.state == State.REFRESHING) {
            synchronized (this.mRequestLock) {
                this.mPendingRequests.add(apiRequest);
            }
        } else {
            insufficientRequest(apiRequest);
        }
    }

    public void cancel(ApiRequest apiRequest) {
        synchronized (this.mRequestLock) {
            this.mPendingRequests.remove(apiRequest);
        }
    }

    public void executePendingRequests() {
        synchronized (this.mRequestLock) {
            Iterator<ApiRequest> it = this.mPendingRequests.iterator();
            while (it.hasNext()) {
                executeRequest(it.next());
                it.remove();
            }
        }
    }

    public void failedToRefreshServiceToken() {
        this.mServiceTokenStatus.state = State.LOGIN_REQUIRED;
        updateServiceTokenStatus(ApiConstants.MICO_SID, State.LOGIN_REQUIRED, System.currentTimeMillis());
        insufficientPendingRequests();
        jgc.O000000o().O00000o(new ApiEvent.AccountException());
    }

    private void insufficientPendingRequests() {
        synchronized (this.mRequestLock) {
            Iterator<ApiRequest> it = this.mPendingRequests.iterator();
            while (it.hasNext()) {
                insufficientRequest(it.next());
                it.remove();
            }
        }
    }

    private void executeRequest(ApiRequest apiRequest) {
        if (!apiRequest.isCanceled()) {
            apiRequest.subscribe();
        }
    }

    private void insufficientRequest(ApiRequest apiRequest) {
        if (!apiRequest.isCanceled()) {
            apiRequest.error(ApiError.TOKEN_INSUFFICIENT);
        }
    }

    public boolean hasValidAccount() {
        return this.mAccountInfo.isPassportValid();
    }

    public boolean isSystemAccount() {
        return this.mAccountStore.getAccountType() == AccountType.SYSTEM;
    }

    public boolean hasSystemAccount() {
        return this.mAccountManager.O00000Oo;
    }

    public String getSystemAccountUserId() {
        if (!hasSystemAccount()) {
            return null;
        }
        Account[] accountsByType = AccountManager.get(this.mContext).getAccountsByType("com.xiaomi");
        if (accountsByType.length > 0) {
            return accountsByType[0].name;
        }
        return null;
    }

    public Account[] getAccounts() {
        return this.mAccountManager.O000000o();
    }

    public AccountInfo.PassportInfo getPassportInfo() {
        return this.mAccountInfo.getPassportInfo();
    }

    public AccountInfo.ServiceInfo getServiceInfo(String str) {
        return this.mAccountInfo.getServiceInfo(str);
    }

    public ServiceTokenResult getServiceTokenResult() {
        return this.serviceTokenResult;
    }

    public void remoceServiceInfo(String str) {
        this.mAccountInfo.getServiceInfoMap().remove(str);
    }

    public Observable<String> webLogin(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return Observable.error(new Throwable("args must not be empty."));
        }
        Account O00000oo = this.mAccountManager.O00000oo();
        if (O00000oo == null) {
            return Observable.error(new Throwable("Account is null."));
        }
        if (!isSystemAccount() || getPassportInfo().getUserId().equals(O00000oo.name)) {
            return Observable.create(new Observable.OnSubscribe<ServiceTokenResult>() {
                /* class com.xiaomi.mico.api.LoginManager.AnonymousClass5 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super ServiceTokenResult>) ((Subscriber) obj));
                }

                public void call(Subscriber<? super ServiceTokenResult> subscriber) {
                    ServiceTokenResult serviceTokenResult = LoginManager.this.mAccountManager.O000000o(context, "weblogin:" + str).get();
                    if (serviceTokenResult.O00000o != ServiceTokenResult.ErrorCode.ERROR_USER_INTERACTION_NEEDED || serviceTokenResult.O0000O0o == null) {
                        LoginManager.this.serviceTokenResult = serviceTokenResult;
                        subscriber.onNext(serviceTokenResult);
                        subscriber.onCompleted();
                        return;
                    }
                    subscriber.onError(new NeedUserInteractionException(serviceTokenResult.O0000O0o));
                }
            }).subscribeOn(Schedulers.newThread()).map(new Func1<ServiceTokenResult, String>() {
                /* class com.xiaomi.mico.api.LoginManager.AnonymousClass4 */

                public String call(ServiceTokenResult serviceTokenResult) {
                    if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_NONE) {
                        return serviceTokenResult.O00000Oo;
                    }
                    AccountLog.e("LoginManager", "Web login failed: " + serviceTokenResult.O00000oO);
                    return null;
                }
            });
        }
        AccountLog.e("LoginManager", "System account is changed");
        return Observable.error(new Throwable("System account is changed."));
    }

    public void login() {
        if (MicoApplication.getInstance().getMicoHelperListener() != null) {
            MicoApplication.getInstance().getMicoHelperListener().login();
        }
    }

    public Observable<LoginState> loginByInit(final Context context) {
        if (context != null) {
            final String str = ApiConstants.MICO_SID;
            return Observable.create(new Observable.OnSubscribe<eez>() {
                /* class com.xiaomi.mico.api.LoginManager.AnonymousClass7 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super eez>) ((Subscriber) obj));
                }

                public void call(Subscriber<? super eez> subscriber) {
                    if (!subscriber.isUnsubscribed()) {
                        ServiceTokenResult serviceTokenResult = LoginManager.this.mAccountManager.O000000o(context, str).get();
                        if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_NONE) {
                            LoginManager.this.mAccountManager.O000000o(LoginManager.this.mContext, serviceTokenResult).get();
                            serviceTokenResult = LoginManager.this.mAccountManager.O000000o(context, str).get();
                        }
                        if (serviceTokenResult.O00000o != ServiceTokenResult.ErrorCode.ERROR_USER_INTERACTION_NEEDED || serviceTokenResult.O0000O0o == null) {
                            LoginManager.getInstance().serviceTokenResult = serviceTokenResult;
                            subscriber.onNext(eez.O000000o(LoginManager.this.mContext, str));
                            subscriber.onCompleted();
                            return;
                        }
                        subscriber.onError(new NeedUserInteractionException(serviceTokenResult.O0000O0o));
                    }
                }
            }).subscribeOn(Schedulers.newThread()).observeOn(this.mScheduler).map(new Func1<eez, LoginState>() {
                /* class com.xiaomi.mico.api.LoginManager.AnonymousClass6 */

                public LoginState call(eez eez) {
                    Account O00000oo = LoginManager.this.mAccountManager.O00000oo();
                    if (O00000oo == null) {
                        return LoginState.NO_ACCOUNT;
                    }
                    if (eez == null) {
                        return LoginState.FAILED;
                    }
                    LoginState loginState = LoginState.SUCCESS;
                    LoginManager.this.mAccountInfo.updateAccountCoreInfo(LoginManager.this.mAccountManager, LoginManager.this.mAccountStore, O00000oo, eez.getEncryptedUserId(), ExtendedAuthToken.build(eez.getServiceToken(), eez.getSecurity()).toPlain());
                    LoginManager.this.addOrUpdateCookies(str);
                    LoginManager.this.updateServiceTokenStatus(str, State.VALID, System.currentTimeMillis());
                    return loginState;
                }
            });
        }
        throw new IllegalStateException("context must be provided when login.");
    }

    public static class XiaomiAccountException extends Exception {
        private String message;

        public XiaomiAccountException(String str) {
            this.message = str;
        }

        public String toString() {
            return "XiaomiAccountException{message='" + this.message + '\'' + '}';
        }
    }

    public static class XiaomiAccountChangedException extends Exception {
        private String message;

        public XiaomiAccountChangedException(String str) {
            this.message = str;
        }

        public String toString() {
            return "XiaomiAccountChangedException{message='" + this.message + '\'' + '}';
        }
    }

    public Observable<String> refreshServiceToken(final String str) {
        Account O00000oo = this.mAccountManager.O00000oo();
        if (O00000oo == null) {
            AccountLog.e("LoginManager", "refresh service token : XiaomiAccount is null.");
            return Observable.error(new XiaomiAccountException("Account is null."));
        } else if (!isSystemAccount() || getPassportInfo().getUserId().equals(O00000oo.name)) {
            return Observable.unsafeCreate(new Observable.OnSubscribe<ServiceTokenResult>() {
                /* class com.xiaomi.mico.api.LoginManager.AnonymousClass9 */

                public /* bridge */ /* synthetic */ void call(Object obj) {
                    call((Subscriber<? super ServiceTokenResult>) ((Subscriber) obj));
                }

                public void call(Subscriber<? super ServiceTokenResult> subscriber) {
                    if (!subscriber.isUnsubscribed()) {
                        ServiceTokenResult serviceTokenResult = LoginManager.this.mAccountManager.O000000o(LoginManager.this.mContext, str).get();
                        if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_NONE) {
                            LoginManager.this.mAccountManager.O000000o(LoginManager.this.mContext, serviceTokenResult).get();
                        }
                        LoginManager loginManager = LoginManager.this;
                        loginManager.serviceTokenResult = serviceTokenResult;
                        subscriber.onNext(loginManager.mAccountManager.O000000o(LoginManager.this.mContext, str).get());
                        subscriber.onCompleted();
                    }
                }
            }).subscribeOn(Schedulers.newThread()).observeOn(this.mScheduler).map(new Func1<ServiceTokenResult, String>() {
                /* class com.xiaomi.mico.api.LoginManager.AnonymousClass8 */

                public String call(ServiceTokenResult serviceTokenResult) {
                    if (serviceTokenResult.O00000o == ServiceTokenResult.ErrorCode.ERROR_NONE) {
                        LoginManager.this.mAccountInfo.updateServiceInfo(LoginManager.this.mAccountStore, str, serviceTokenResult.O00000Oo, serviceTokenResult.O00000o0);
                        LoginManager.this.addOrUpdateCookies(str);
                        LoginManager.this.updateServiceTokenStatus(str, State.VALID, System.currentTimeMillis());
                        return serviceTokenResult.O00000Oo;
                    }
                    AccountLog.e("LoginManager", "Refresh service token failed: " + serviceTokenResult.O00000oO);
                    return null;
                }
            });
        } else {
            AccountLog.e("LoginManager", "System account is changed");
            return Observable.error(new XiaomiAccountChangedException("System account is changed."));
        }
    }

    public Observable<LoginState> logout() {
        return Observable.create(new Observable.OnSubscribe<LoginState>() {
            /* class com.xiaomi.mico.api.LoginManager.AnonymousClass10 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super LoginState>) ((Subscriber) obj));
            }

            public void call(Subscriber<? super LoginState> subscriber) {
                LoginManager.this.mAccountManager.O00000oo();
                LoginManager loginManager = LoginManager.this;
                loginManager.serviceTokenResult = null;
                loginManager.onAccountRemoved();
                subscriber.onNext(LoginState.NO_ACCOUNT);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(this.mScheduler);
    }

    public void onAccountRemoved() {
        this.mAccountInfo.remove(this.mAccountStore);
        synchronized (this.mCookieLock) {
            this.mCacheCookies.clear();
        }
        updateServiceTokenStatus(ApiConstants.MICO_SID, State.INITIALIZED, System.currentTimeMillis());
    }

    private void registerAccountReceiver() {
        ft O000000o2 = ft.O000000o(CommonApplication.getAppContext());
        IntentFilter intentFilter = new IntentFilter("action_on_login_success");
        intentFilter.addAction("action_on_logout");
        O000000o2.O000000o(new AccountReceiver(), intentFilter);
    }

    class AccountReceiver extends BroadcastReceiver {
        private AccountReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action_on_login_success".equals(action)) {
                if (!ftn.O00000oO(context) || ftn.O0000Oo0(context)) {
                    LoginManager loginManager = LoginManager.this;
                    loginManager.loginByInit(loginManager.mContext).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<LoginState>() {
                        /* class com.xiaomi.mico.api.LoginManager.AccountReceiver.AnonymousClass1 */

                        public void call(LoginState loginState) {
                            LoginManager.this.notifyLoginSuccess();
                        }
                    }, new Action1<Throwable>() {
                        /* class com.xiaomi.mico.api.LoginManager.AccountReceiver.AnonymousClass2 */

                        public void call(Throwable th) {
                        }
                    });
                }
            } else if ("action_on_logout".equals(action)) {
                LoginManager.this.logout().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<LoginState>() {
                    /* class com.xiaomi.mico.api.LoginManager.AccountReceiver.AnonymousClass3 */

                    public void call(LoginState loginState) {
                        MicoManager.getInstance().reset();
                        PlayerManager.getInstance().resetAndStopQuery();
                        MijiaCacheManager.clear();
                        LoginManager.this.notifyLogout();
                    }
                });
            }
        }
    }

    public void addLoginManagerCallback(LoginManagerCallback loginManagerCallback) {
        if (!this.mCallbackList.contains(loginManagerCallback)) {
            this.mCallbackList.add(loginManagerCallback);
        }
    }

    public void removeLoginManagerCallbackCallback(LoginManagerCallback loginManagerCallback) {
        this.mCallbackList.remove(loginManagerCallback);
    }

    public void notifyLoginSuccess() {
        int i = 0;
        while (i < this.mCallbackList.size()) {
            try {
                LoginManagerCallback loginManagerCallback = this.mCallbackList.get(i);
                if (loginManagerCallback != null) {
                    loginManagerCallback.onLoginSuccess();
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void notifyLogout() {
        int i = 0;
        while (i < this.mCallbackList.size()) {
            try {
                LoginManagerCallback loginManagerCallback = this.mCallbackList.get(i);
                if (loginManagerCallback != null) {
                    loginManagerCallback.onLogout();
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
