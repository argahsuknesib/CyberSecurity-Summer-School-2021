package com.xiaomi.accounts;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OnAccountsUpdateListener;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.accounts.AccountManagerService;
import com.xiaomi.accounts.IAccountManagerResponse;
import com.xiaomi.accountsdk.utils.AccountLog;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import net.sqlcipher.database.SQLiteDatabase;

public class AccountManager {
    private static volatile AccountManager O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public final Handler f5956O000000o;
    public AccountManagerService O00000Oo;
    private final Context O00000o;
    public final HashMap<OnAccountsUpdateListener, Handler> O00000o0 = new HashMap<>();
    private final BroadcastReceiver O00000oo = new BroadcastReceiver() {
        /* class com.xiaomi.accounts.AccountManager.AnonymousClass13 */

        public final void onReceive(Context context, Intent intent) {
            Account[] O000000o2 = AccountManager.this.O000000o();
            synchronized (AccountManager.this.O00000o0) {
                for (Map.Entry next : AccountManager.this.O00000o0.entrySet()) {
                    AccountManager accountManager = AccountManager.this;
                    Handler handler = (Handler) next.getValue();
                    OnAccountsUpdateListener onAccountsUpdateListener = (OnAccountsUpdateListener) next.getKey();
                    Account[] accountArr = new Account[O000000o2.length];
                    System.arraycopy(O000000o2, 0, accountArr, 0, accountArr.length);
                    if (handler == null) {
                        handler = accountManager.f5956O000000o;
                    }
                    handler.post(new Runnable(onAccountsUpdateListener, accountArr) {
                        /* class com.xiaomi.accounts.AccountManager.AnonymousClass12 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ OnAccountsUpdateListener f5958O000000o;
                        final /* synthetic */ Account[] O00000Oo;

                        {
                            this.f5958O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final void run() {
                            try {
                                this.f5958O000000o.onAccountsUpdated(this.O00000Oo);
                            } catch (SQLException e) {
                                AccountLog.e("AccountManager", "Can't update accounts", e);
                            }
                        }
                    });
                }
            }
        }
    };

    private AccountManager(Context context) {
        this.O00000o = context;
        this.f5956O000000o = new Handler(this.O00000o.getMainLooper());
        this.O00000Oo = new AccountManagerService(context);
    }

    public static Bundle O000000o(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("authtoken") || TextUtils.isEmpty(bundle.getString("authtoken"))) {
            return bundle;
        }
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString("authtoken", "<omitted for logging purposes>");
        return bundle2;
    }

    public static AccountManager O000000o(Context context) {
        if (context != null) {
            if (O00000oO == null) {
                synchronized (AccountManager.class) {
                    if (O00000oO == null) {
                        O00000oO = new AccountManager(context.getApplicationContext());
                    }
                }
            }
            return O00000oO;
        }
        throw new IllegalArgumentException("context is null");
    }

    public final String O000000o(Account account) {
        if (account != null) {
            return this.O00000Oo.O000000o(account);
        }
        throw new IllegalArgumentException("account is null");
    }

    public final String O000000o(Account account, String str) {
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str != null) {
            return this.O00000Oo.O000000o(account, str);
        } else {
            throw new IllegalArgumentException("key is null");
        }
    }

    public final Account[] O000000o() {
        return this.O00000Oo.O000000o((String) null);
    }

    public final Account[] O000000o(String str) {
        return this.O00000Oo.O000000o(str);
    }

    public final void O000000o(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("accountType is null");
        } else if (str2 != null) {
            AccountManagerService accountManagerService = this.O00000Oo;
            if (Log.isLoggable("AccountManagerService", 2)) {
                AccountLog.v("AccountManagerService", "invalidateAuthToken: accountType " + str + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
            }
            if (str == null) {
                throw new IllegalArgumentException("accountType is null");
            } else if (str2 != null) {
                AccountManagerService.O00000o0 O000000o2 = accountManagerService.O000000o();
                synchronized (O000000o2.O00000o0) {
                    SQLiteDatabase O000000o3 = O000000o2.O00000Oo.O000000o();
                    O000000o3.beginTransaction();
                    try {
                        accountManagerService.O000000o(O000000o2, O000000o3, str, str2);
                        O000000o3.setTransactionSuccessful();
                    } finally {
                        O000000o3.endTransaction();
                    }
                }
            } else {
                throw new IllegalArgumentException("authToken is null");
            }
        }
    }

    public final AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str != null) {
            final Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putString("androidPackageName", this.O00000o.getPackageName());
            final Account account2 = account;
            final String str2 = str;
            return new AmsTask(activity, handler, accountManagerCallback) {
                /* class com.xiaomi.accounts.AccountManager.AnonymousClass5 */

                public void doWork() throws RemoteException {
                    AccountManager.this.O00000Oo.O000000o(this.mResponse, account2, str2, false, true, bundle2);
                }
            }.start();
        } else {
            throw new IllegalArgumentException("authTokenType is null");
        }
    }

    public final AccountManagerFuture<Bundle> O000000o(Account account, String str, Bundle bundle, boolean z, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        if (account == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str != null) {
            final Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putString("androidPackageName", this.O00000o.getPackageName());
            final Account account2 = account;
            final String str2 = str;
            final boolean z2 = z;
            return new AmsTask(null, handler, accountManagerCallback) {
                /* class com.xiaomi.accounts.AccountManager.AnonymousClass6 */

                public void doWork() throws RemoteException {
                    AccountManager.this.O00000Oo.O000000o(this.mResponse, account2, str2, z2, false, bundle2);
                }
            }.start();
        } else {
            throw new IllegalArgumentException("authTokenType is null");
        }
    }

    public final AccountManagerFuture<Bundle> O000000o(String str, String str2, String[] strArr, Bundle bundle, Activity activity, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
        Bundle bundle2 = bundle;
        if (str != null) {
            final Bundle bundle3 = new Bundle();
            if (bundle2 != null) {
                bundle3.putAll(bundle2);
            }
            bundle3.putString("androidPackageName", this.O00000o.getPackageName());
            final String str3 = str;
            final String str4 = str2;
            final String[] strArr2 = strArr;
            final Activity activity2 = activity;
            return new AmsTask(activity, handler, accountManagerCallback) {
                /* class com.xiaomi.accounts.AccountManager.AnonymousClass7 */

                public void doWork() throws RemoteException {
                    AccountManagerService accountManagerService = AccountManager.this.O00000Oo;
                    IAccountManagerResponse iAccountManagerResponse = this.mResponse;
                    String str = str3;
                    String str2 = str4;
                    String[] strArr = strArr2;
                    boolean z = activity2 != null;
                    Bundle bundle = bundle3;
                    if (Log.isLoggable("AccountManagerService", 2)) {
                        AccountLog.v("AccountManagerService", "addAccount: accountType " + str + ", response " + iAccountManagerResponse + ", authTokenType " + str2 + ", requiredFeatures " + AccountManagerService.O000000o(strArr) + ", expectActivityLaunch " + z + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
                    }
                    if (iAccountManagerResponse == null) {
                        throw new IllegalArgumentException("response is null");
                    } else if (str != null) {
                        AccountManagerService.O00000o0 O000000o2 = accountManagerService.O000000o();
                        int callingPid = Binder.getCallingPid();
                        int callingUid = Binder.getCallingUid();
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        Bundle bundle2 = bundle;
                        bundle2.putInt("callerUid", callingUid);
                        bundle2.putInt("callerPid", callingPid);
                        new AccountManagerService.Session(O000000o2, iAccountManagerResponse, str, z, true, str2, strArr, bundle2, str) {
                            /* class com.xiaomi.accounts.AccountManagerService.AnonymousClass3 */
                            final /* synthetic */ String val$accountType;
                            final /* synthetic */ String val$authTokenType;
                            final /* synthetic */ Bundle val$options;
                            final /* synthetic */ String[] val$requiredFeatures;

                            {
                                this.val$authTokenType = r7;
                                this.val$requiredFeatures = r8;
                                this.val$options = r9;
                                this.val$accountType = r10;
                            }

                            public void run() throws RemoteException {
                                this.mAuthenticator.addAccount(this, this.mAccountType, this.val$authTokenType, this.val$requiredFeatures, this.val$options);
                            }

                            /* access modifiers changed from: protected */
                            public String toDebugString(long j) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(super.toDebugString(j));
                                sb.append(", addAccount, accountType ");
                                sb.append(this.val$accountType);
                                sb.append(", requiredFeatures ");
                                String[] strArr = this.val$requiredFeatures;
                                sb.append(strArr != null ? TextUtils.join(",", strArr) : null);
                                return sb.toString();
                            }
                        }.bind();
                    } else {
                        throw new IllegalArgumentException("accountType is null");
                    }
                }
            }.start();
        }
        throw new IllegalArgumentException("accountType is null");
    }

    public final void O00000Oo() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == this.O00000o.getMainLooper()) {
            IllegalStateException illegalStateException = new IllegalStateException("calling this from your main thread can lead to deadlock");
            AccountLog.e("AccountManager", "calling this from your main thread can lead to deadlock and/or ANRs", illegalStateException);
            if (this.O00000o.getApplicationInfo().targetSdkVersion >= 8) {
                throw illegalStateException;
            }
        }
    }

    abstract class AmsTask extends FutureTask<Bundle> implements AccountManagerFuture<Bundle> {
        final WeakReference<Activity> mActivity;
        final AccountManagerCallback<Bundle> mCallback;
        final Handler mHandler;
        final IAccountManagerResponse mResponse = new Response();

        public abstract void doWork() throws RemoteException;

        public AmsTask(Activity activity, Handler handler, AccountManagerCallback<Bundle> accountManagerCallback) {
            super(new Callable<Bundle>() {
                /* class com.xiaomi.accounts.AccountManager.AmsTask.AnonymousClass1 */

                public Bundle call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            this.mHandler = handler;
            this.mCallback = accountManagerCallback;
            this.mActivity = new WeakReference<>(activity);
        }

        public final AccountManagerFuture<Bundle> start() {
            try {
                doWork();
            } catch (RemoteException e) {
                setException(e);
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public void set(Bundle bundle) {
            if (bundle == null) {
                AccountLog.e("AccountManager", "the bundle must not be null", new Exception());
            }
            super.set((Object) bundle);
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0062 */
        private Bundle internalGetResult(Long l, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
            if (!isDone()) {
                AccountManager.this.O00000Oo();
            }
            if (l == null) {
                try {
                    Bundle bundle = (Bundle) get();
                    cancel(true);
                    return bundle;
                } catch (CancellationException ) {
                    throw new OperationCanceledException();
                } catch (InterruptedException | TimeoutException unused) {
                    cancel(true);
                    throw new OperationCanceledException();
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof IOException) {
                        throw ((IOException) cause);
                    } else if (cause instanceof UnsupportedOperationException) {
                        throw new AuthenticatorException(cause);
                    } else if (cause instanceof AuthenticatorException) {
                        throw ((AuthenticatorException) cause);
                    } else if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    } else if (cause instanceof Error) {
                        throw ((Error) cause);
                    } else {
                        throw new IllegalStateException(cause);
                    }
                } catch (Throwable th) {
                    cancel(true);
                    throw th;
                }
            } else {
                Bundle bundle2 = (Bundle) get(l.longValue(), timeUnit);
                cancel(true);
                return bundle2;
            }
            throw new OperationCanceledException();
        }

        public Bundle getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(null, null);
        }

        public Bundle getResult(long j, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(Long.valueOf(j), timeUnit);
        }

        /* access modifiers changed from: protected */
        public void done() {
            AccountManagerCallback<Bundle> accountManagerCallback = this.mCallback;
            if (accountManagerCallback != null) {
                AccountManager accountManager = AccountManager.this;
                Handler handler = this.mHandler;
                if (handler == null) {
                    handler = accountManager.f5956O000000o;
                }
                handler.post(new Runnable(accountManagerCallback, this) {
                    /* class com.xiaomi.accounts.AccountManager.AnonymousClass11 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ AccountManagerCallback f5957O000000o;
                    final /* synthetic */ AccountManagerFuture O00000Oo;

                    {
                        this.f5957O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final void run() {
                        this.f5957O000000o.run(this.O00000Oo);
                    }
                });
            }
        }

        class Response extends IAccountManagerResponse.Stub {
            public void onRequestContinued() throws RemoteException {
            }

            private Response() {
            }

            public void onResult(Bundle bundle) {
                Intent intent = (Intent) bundle.getParcelable("intent");
                if (intent != null && AmsTask.this.mActivity.get() != null) {
                    AmsTask.this.mActivity.get().startActivity(intent);
                } else if (bundle.getBoolean("retry")) {
                    try {
                        AmsTask.this.doWork();
                    } catch (RemoteException unused) {
                    }
                } else {
                    AmsTask.this.set(bundle);
                }
            }

            public void onError(int i, String str) {
                if (i == 4) {
                    AmsTask.this.cancel(true);
                } else {
                    AmsTask.this.setException(AccountManager.O000000o(i, str));
                }
            }
        }
    }

    abstract class BaseFutureTask<T> extends FutureTask<T> {
        final Handler mHandler;
        public final IAccountManagerResponse mResponse = new Response();

        public abstract T bundleToResult(Bundle bundle) throws AuthenticatorException;

        public abstract void doWork() throws RemoteException;

        public BaseFutureTask(Handler handler) {
            super(new Callable<T>() {
                /* class com.xiaomi.accounts.AccountManager.BaseFutureTask.AnonymousClass1 */

                public T call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            this.mHandler = handler;
        }

        /* access modifiers changed from: protected */
        public void postRunnableToHandler(Runnable runnable) {
            Handler handler = this.mHandler;
            if (handler == null) {
                handler = AccountManager.this.f5956O000000o;
            }
            handler.post(runnable);
        }

        /* access modifiers changed from: protected */
        public void startTask() {
            try {
                doWork();
            } catch (RemoteException e) {
                setException(e);
            }
        }

        public class Response extends IAccountManagerResponse.Stub {
            public void onRequestContinued() throws RemoteException {
            }

            protected Response() {
            }

            public void onResult(Bundle bundle) {
                try {
                    Object bundleToResult = BaseFutureTask.this.bundleToResult(bundle);
                    if (bundleToResult != null) {
                        BaseFutureTask.this.set(bundleToResult);
                    }
                } catch (AuthenticatorException | ClassCastException unused) {
                    onError(5, "no result in response");
                }
            }

            public void onError(int i, String str) {
                if (i == 4) {
                    BaseFutureTask.this.cancel(true);
                } else {
                    BaseFutureTask.this.setException(AccountManager.O000000o(i, str));
                }
            }
        }
    }

    public abstract class Future2Task<T> extends BaseFutureTask<T> implements AccountManagerFuture<T> {
        final AccountManagerCallback<T> mCallback;

        public Future2Task(Handler handler, AccountManagerCallback<T> accountManagerCallback) {
            super(handler);
            this.mCallback = accountManagerCallback;
        }

        /* access modifiers changed from: protected */
        public void done() {
            if (this.mCallback != null) {
                postRunnableToHandler(new Runnable() {
                    /* class com.xiaomi.accounts.AccountManager.Future2Task.AnonymousClass1 */

                    public final void run() {
                        Future2Task.this.mCallback.run(Future2Task.this);
                    }
                });
            }
        }

        public Future2Task<T> start() {
            startTask();
            return this;
        }

        private T internalGetResult(Long l, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
            if (!isDone()) {
                AccountManager.this.O00000Oo();
            }
            if (l == null) {
                try {
                    T t = get();
                    cancel(true);
                    return t;
                } catch (InterruptedException | CancellationException | TimeoutException unused) {
                    cancel(true);
                    throw new OperationCanceledException();
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof IOException) {
                        throw ((IOException) cause);
                    } else if (cause instanceof UnsupportedOperationException) {
                        throw new AuthenticatorException(cause);
                    } else if (cause instanceof AuthenticatorException) {
                        throw ((AuthenticatorException) cause);
                    } else if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    } else if (cause instanceof Error) {
                        throw ((Error) cause);
                    } else {
                        throw new IllegalStateException(cause);
                    }
                } catch (Throwable th) {
                    cancel(true);
                    throw th;
                }
            } else {
                T t2 = get(l.longValue(), timeUnit);
                cancel(true);
                return t2;
            }
        }

        public T getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(null, null);
        }

        public T getResult(long j, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(Long.valueOf(j), timeUnit);
        }
    }

    public static Exception O000000o(int i, String str) {
        if (i == 3) {
            return new IOException(str);
        }
        if (i == 6) {
            return new UnsupportedOperationException(str);
        }
        if (i == 5) {
            return new AuthenticatorException(str);
        }
        if (i == 7) {
            return new IllegalArgumentException(str);
        }
        return new AuthenticatorException(str);
    }

    class GetAuthTokenByTypeAndFeaturesTask extends AmsTask implements AccountManagerCallback<Bundle> {
        final String mAccountType;
        final Bundle mAddAccountOptions;
        final String mAuthTokenType;
        final String[] mFeatures;
        volatile AccountManagerFuture<Bundle> mFuture = null;
        final Bundle mLoginOptions;
        final AccountManagerCallback<Bundle> mMyCallback;
        public volatile int mNumAccounts = 0;

        GetAuthTokenByTypeAndFeaturesTask(String str, String str2, String[] strArr, Activity activity, Bundle bundle, Bundle bundle2, AccountManagerCallback<Bundle> accountManagerCallback, Handler handler) {
            super(activity, handler, accountManagerCallback);
            if (str != null) {
                this.mAccountType = str;
                this.mAuthTokenType = str2;
                this.mFeatures = strArr;
                this.mAddAccountOptions = bundle;
                this.mLoginOptions = bundle2;
                this.mMyCallback = this;
                return;
            }
            throw new IllegalArgumentException("account type is null");
        }

        public void doWork() throws RemoteException {
            AccountManager accountManager = AccountManager.this;
            String str = this.mAccountType;
            String[] strArr = this.mFeatures;
            AnonymousClass1 r3 = new AccountManagerCallback<Account[]>() {
                /* class com.xiaomi.accounts.AccountManager.GetAuthTokenByTypeAndFeaturesTask.AnonymousClass1 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: com.xiaomi.accounts.AccountManager.O000000o(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>
                 arg types: [android.accounts.Account, java.lang.String, ?[OBJECT, ARRAY], int, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler]
                 candidates:
                  com.xiaomi.accounts.AccountManager.O000000o(android.accounts.Account, java.lang.String, android.os.Bundle, android.app.Activity, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle>
                  com.xiaomi.accounts.AccountManager.O000000o(android.accounts.Account, java.lang.String, android.os.Bundle, boolean, android.accounts.AccountManagerCallback<android.os.Bundle>, android.os.Handler):android.accounts.AccountManagerFuture<android.os.Bundle> */
                public final void run(AccountManagerFuture<Account[]> accountManagerFuture) {
                    try {
                        Account[] result = accountManagerFuture.getResult();
                        GetAuthTokenByTypeAndFeaturesTask getAuthTokenByTypeAndFeaturesTask = GetAuthTokenByTypeAndFeaturesTask.this;
                        getAuthTokenByTypeAndFeaturesTask.mNumAccounts = result.length;
                        if (result.length == 0) {
                            if (getAuthTokenByTypeAndFeaturesTask.mActivity.get() != null) {
                                GetAuthTokenByTypeAndFeaturesTask getAuthTokenByTypeAndFeaturesTask2 = GetAuthTokenByTypeAndFeaturesTask.this;
                                getAuthTokenByTypeAndFeaturesTask2.mFuture = AccountManager.this.O000000o(GetAuthTokenByTypeAndFeaturesTask.this.mAccountType, GetAuthTokenByTypeAndFeaturesTask.this.mAuthTokenType, GetAuthTokenByTypeAndFeaturesTask.this.mFeatures, GetAuthTokenByTypeAndFeaturesTask.this.mAddAccountOptions, (Activity) GetAuthTokenByTypeAndFeaturesTask.this.mActivity.get(), GetAuthTokenByTypeAndFeaturesTask.this.mMyCallback, GetAuthTokenByTypeAndFeaturesTask.this.mHandler);
                                return;
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("authAccount", null);
                            bundle.putString("accountType", null);
                            bundle.putString("authtoken", null);
                            try {
                                GetAuthTokenByTypeAndFeaturesTask.this.mResponse.onResult(bundle);
                            } catch (RemoteException unused) {
                            }
                        } else if (result.length == 1) {
                            if (getAuthTokenByTypeAndFeaturesTask.mActivity == null) {
                                GetAuthTokenByTypeAndFeaturesTask getAuthTokenByTypeAndFeaturesTask3 = GetAuthTokenByTypeAndFeaturesTask.this;
                                getAuthTokenByTypeAndFeaturesTask3.mFuture = AccountManager.this.O000000o(result[0], GetAuthTokenByTypeAndFeaturesTask.this.mAuthTokenType, (Bundle) null, false, GetAuthTokenByTypeAndFeaturesTask.this.mMyCallback, GetAuthTokenByTypeAndFeaturesTask.this.mHandler);
                                return;
                            }
                            GetAuthTokenByTypeAndFeaturesTask getAuthTokenByTypeAndFeaturesTask4 = GetAuthTokenByTypeAndFeaturesTask.this;
                            getAuthTokenByTypeAndFeaturesTask4.mFuture = AccountManager.this.O000000o(result[0], GetAuthTokenByTypeAndFeaturesTask.this.mAuthTokenType, GetAuthTokenByTypeAndFeaturesTask.this.mLoginOptions, (Activity) GetAuthTokenByTypeAndFeaturesTask.this.mActivity.get(), GetAuthTokenByTypeAndFeaturesTask.this.mMyCallback, GetAuthTokenByTypeAndFeaturesTask.this.mHandler);
                        } else if (getAuthTokenByTypeAndFeaturesTask.mActivity != null) {
                            AnonymousClass1 r0 = new IAccountManagerResponse.Stub() {
                                /* class com.xiaomi.accounts.AccountManager.GetAuthTokenByTypeAndFeaturesTask.AnonymousClass1.AnonymousClass1 */

                                public void onRequestContinued() throws RemoteException {
                                }

                                public void onResult(Bundle bundle) throws RemoteException {
                                    Account account = new Account(bundle.getString("authAccount"), bundle.getString("accountType"));
                                    GetAuthTokenByTypeAndFeaturesTask.this.mFuture = AccountManager.this.O000000o(account, GetAuthTokenByTypeAndFeaturesTask.this.mAuthTokenType, GetAuthTokenByTypeAndFeaturesTask.this.mLoginOptions, (Activity) GetAuthTokenByTypeAndFeaturesTask.this.mActivity.get(), GetAuthTokenByTypeAndFeaturesTask.this.mMyCallback, GetAuthTokenByTypeAndFeaturesTask.this.mHandler);
                                }

                                public void onError(int i, String str) throws RemoteException {
                                    GetAuthTokenByTypeAndFeaturesTask.this.mResponse.onError(i, str);
                                }
                            };
                            Intent intent = new Intent();
                            intent.setClassName("android", "android.accounts.ChooseAccountActivity");
                            intent.putExtra("accounts", result);
                            intent.putExtra("accountManagerResponse", new AccountManagerResponse(r0));
                            ((Activity) GetAuthTokenByTypeAndFeaturesTask.this.mActivity.get()).startActivity(intent);
                        } else {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("accounts", null);
                            try {
                                GetAuthTokenByTypeAndFeaturesTask.this.mResponse.onResult(bundle2);
                            } catch (RemoteException unused2) {
                            }
                        }
                    } catch (OperationCanceledException e) {
                        GetAuthTokenByTypeAndFeaturesTask.this.setException(e);
                    } catch (IOException e2) {
                        GetAuthTokenByTypeAndFeaturesTask.this.setException(e2);
                    } catch (AuthenticatorException e3) {
                        GetAuthTokenByTypeAndFeaturesTask.this.setException(e3);
                    }
                }
            };
            Handler handler = this.mHandler;
            if (str != null) {
                new Future2Task<Account[]>(handler, r3, str, strArr) {
                    /* class com.xiaomi.accounts.AccountManager.AnonymousClass3 */
                    final /* synthetic */ String[] val$features;
                    final /* synthetic */ String val$type;

                    {
                        this.val$type = r4;
                        this.val$features = r5;
                    }

                    public void doWork() throws RemoteException {
                        AccountManager.this.O00000Oo.O000000o(this.mResponse, this.val$type, this.val$features);
                    }

                    public Account[] bundleToResult(Bundle bundle) throws AuthenticatorException {
                        if (bundle.containsKey("accounts")) {
                            Parcelable[] parcelableArray = bundle.getParcelableArray("accounts");
                            Account[] accountArr = new Account[parcelableArray.length];
                            for (int i = 0; i < parcelableArray.length; i++) {
                                accountArr[i] = (Account) parcelableArray[i];
                            }
                            return accountArr;
                        }
                        throw new AuthenticatorException("no result in response");
                    }
                }.start();
                return;
            }
            throw new IllegalArgumentException("type is null");
        }

        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            try {
                Bundle result = accountManagerFuture.getResult();
                if (this.mNumAccounts == 0) {
                    String string = result.getString("authAccount");
                    String string2 = result.getString("accountType");
                    if (!TextUtils.isEmpty(string)) {
                        if (!TextUtils.isEmpty(string2)) {
                            Account account = new Account(string, string2);
                            this.mNumAccounts = 1;
                            AccountManager.this.O000000o(account, this.mAuthTokenType, (Bundle) null, (Activity) this.mActivity.get(), this.mMyCallback, this.mHandler);
                            return;
                        }
                    }
                    setException(new AuthenticatorException("account not in result"));
                    return;
                }
                set(result);
            } catch (OperationCanceledException unused) {
                cancel(true);
            } catch (IOException e) {
                setException(e);
            } catch (AuthenticatorException e2) {
                setException(e2);
            }
        }
    }
}
