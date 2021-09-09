package com.xiaomi.smarthome.shop;

import _m_j.gsy;
import _m_j.hsz;
import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.OperationCanceledException;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.PackageNameDeniedException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class MiotAccountProvider {
    private static volatile MiotAccountProvider O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f11381O000000o;
    final Handler O00000Oo = new Handler(this.f11381O000000o.getMainLooper());

    interface O000000o {
        void O000000o(Bundle bundle);
    }

    private MiotAccountProvider(Context context) {
        this.f11381O000000o = context;
    }

    public static MiotAccountProvider O000000o(Context context) {
        if (O00000o0 == null) {
            synchronized ("MiotAccountProvider") {
                if (O00000o0 == null) {
                    O00000o0 = new MiotAccountProvider(context);
                }
            }
        }
        return O00000o0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068 A[SYNTHETIC, Splitter:B:20:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0098 A[Catch:{ IOException -> 0x012c, InvalidResponseException -> 0x011c, InvalidCredentialException -> 0x010c, AccessDeniedException -> 0x00fe, AuthenticationFailureException -> 0x00f0, InvalidUserNameException -> 0x00e0, PackageNameDeniedException -> 0x00d2 }] */
    public static void O000000o(O000000o o000000o, Account account, String str) {
        String str2;
        if (o000000o == null) {
            throw new IllegalArgumentException("response is null");
        } else if (account == null) {
            throw new IllegalArgumentException("account is null");
        } else if (str != null) {
            Bundle bundle = new Bundle();
            String O0000oO = CoreApi.O000000o().O0000oO();
            if (TextUtils.isEmpty(O0000oO) || !"com.xiaomi".equals(account.type)) {
                gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getAuthToken(): passToken null or account type error");
                bundle.putBoolean("booleanResult", false);
                o000000o.O000000o(bundle);
                return;
            }
            String str3 = "passportapi";
            if (TextUtils.isEmpty(str)) {
                gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getting auth token, but no service url contained, use micloud");
            } else if (str.startsWith("weblogin:")) {
                str2 = str.substring(9);
                if (!hsz.O000000o(str2)) {
                    bundle.putInt("errorCode", 7);
                    bundle.putString("errorMessage", "untrusted web sso url");
                    o000000o.O000000o(bundle);
                    return;
                }
                if (str2 == null) {
                    try {
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getAuthToken(): webAutoLoginUrl = ".concat(String.valueOf(str2)));
                        AccountInfo loginByPassToken = XMPassport.loginByPassToken(account.name, null, hsz.O000000o(), O0000oO, str2);
                        if (loginByPassToken != null) {
                            bundle.putString("authAccount", loginByPassToken.getUserId());
                            bundle.putString("accountType", str2);
                            bundle.putString("authtoken", loginByPassToken.getAutoLoginUrl());
                            o000000o.O000000o(bundle);
                            return;
                        }
                        return;
                    } catch (IOException unused) {
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "io exception when getting service token");
                        bundle.putInt("errorCode", 5);
                        bundle.putString("errorMessage", "io exception when getting service token");
                        o000000o.O000000o(bundle);
                        return;
                    } catch (InvalidResponseException unused2) {
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "invalid response received when getting service token");
                        bundle.putInt("errorCode", 5);
                        bundle.putString("errorMessage", "invalid response from server");
                        o000000o.O000000o(bundle);
                        return;
                    } catch (InvalidCredentialException unused3) {
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "invalid credential, passToken is invalid");
                        bundle.putInt("errorCode", 5);
                        bundle.putString("errorMessage", "invalid passToken");
                        o000000o.O000000o(bundle);
                        return;
                    } catch (AccessDeniedException unused4) {
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "access denied");
                        bundle.putInt("errorCode", 5);
                        bundle.putString("errorMessage", "access denied");
                        o000000o.O000000o(bundle);
                        return;
                    } catch (AuthenticationFailureException unused5) {
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "auth failure");
                        bundle.putInt("errorCode", 5);
                        bundle.putString("errorMessage", "auth failure");
                        o000000o.O000000o(bundle);
                        return;
                    } catch (InvalidUserNameException unused6) {
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "no such a user");
                        bundle.putInt("errorCode", 5);
                        bundle.putString("errorMessage", "no such user");
                        o000000o.O000000o(bundle);
                        return;
                    } catch (PackageNameDeniedException unused7) {
                        gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "package name denied");
                        bundle.putInt("errorCode", 5);
                        bundle.putString("errorMessage", "package name denied");
                        o000000o.O000000o(bundle);
                        return;
                    }
                } else {
                    gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "getAuthToken(): serviceId = ".concat(String.valueOf(str3)));
                    AccountInfo loginByPassToken2 = XMPassport.loginByPassToken(account.name, str3, hsz.O000000o(), O0000oO);
                    String plain = ExtendedAuthToken.build(loginByPassToken2.getServiceToken(), loginByPassToken2.getSecurity()).toPlain();
                    bundle.putString("authAccount", loginByPassToken2.getUserId());
                    bundle.putString("accountType", "com.xiaomi");
                    bundle.putString("authtoken", plain);
                    o000000o.O000000o(bundle);
                    return;
                }
            } else {
                str3 = str;
            }
            str2 = null;
            if (str2 == null) {
            }
        } else {
            throw new IllegalArgumentException("authTokenType is null");
        }
    }

    public abstract class AmsTask extends FutureTask<Bundle> implements AccountManagerFuture<Bundle> {
        final Activity mActivity;
        final AccountManagerCallback<Bundle> mCallback;
        final Handler mHandler;
        final O000000o mResponse = new O000000o(this, (byte) 0);

        public abstract void doWork();

        public AmsTask(Activity activity, Handler handler, AccountManagerCallback<Bundle> accountManagerCallback) {
            super(new Callable<Bundle>() {
                /* class com.xiaomi.smarthome.shop.MiotAccountProvider.AmsTask.AnonymousClass1 */

                public Bundle call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            this.mHandler = handler;
            this.mCallback = accountManagerCallback;
            this.mActivity = activity;
        }

        public final AccountManagerFuture<Bundle> start() {
            doWork();
            return this;
        }

        /* access modifiers changed from: protected */
        public void set(Bundle bundle) {
            if (bundle == null) {
                gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "the bundle must not be null");
            }
            super.set((Object) bundle);
        }

        private void ensureNotOnMainThread() {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null && myLooper == MiotAccountProvider.this.f11381O000000o.getMainLooper()) {
                IllegalStateException illegalStateException = new IllegalStateException("calling this from your main thread can lead to deadlock");
                gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "calling this from your main thread can lead to deadlock and/or ANRs");
                if (MiotAccountProvider.this.f11381O000000o.getApplicationInfo().targetSdkVersion >= 8) {
                    throw illegalStateException;
                }
            }
        }

        private Bundle internalGetResult(Long l, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
            if (!isDone()) {
                ensureNotOnMainThread();
            }
            LogType logType = LogType.GENERAL;
            gsy.O000000o(logType, "MiotAccountProvider", "internalGetResult(): " + l + ", " + timeUnit);
            if (l == null) {
                try {
                    Bundle bundle = (Bundle) get();
                    cancel(true);
                    return bundle;
                } catch (InterruptedException | CancellationException | TimeoutException unused) {
                    cancel(true);
                    throw new RuntimeException();
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
        }

        public Bundle getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(null, null);
        }

        public Bundle getResult(long j, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(Long.valueOf(j), timeUnit);
        }

        /* access modifiers changed from: protected */
        public void done() {
            gsy.O000000o(LogType.GENERAL, "MiotAccountProvider", "done()");
            AccountManagerCallback<Bundle> accountManagerCallback = this.mCallback;
            if (accountManagerCallback != null) {
                MiotAccountProvider miotAccountProvider = MiotAccountProvider.this;
                Handler handler = this.mHandler;
                if (handler == null) {
                    handler = miotAccountProvider.O00000Oo;
                }
                handler.post(new Runnable(accountManagerCallback, this) {
                    /* class com.xiaomi.smarthome.shop.MiotAccountProvider.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ AccountManagerCallback f11384O000000o;
                    final /* synthetic */ AccountManagerFuture O00000Oo;

                    {
                        this.f11384O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final void run() {
                        this.f11384O000000o.run(this.O00000Oo);
                    }
                });
            }
        }

        class O000000o implements O000000o {
            private O000000o() {
            }

            /* synthetic */ O000000o(AmsTask amsTask, byte b) {
                this();
            }

            public final void O000000o(Bundle bundle) {
                Intent intent = (Intent) bundle.getParcelable("intent");
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "MiotAccountProvider", "AmsTask::Response::onResult(): " + bundle.toString());
                if (intent != null && AmsTask.this.mActivity != null) {
                    AmsTask.this.mActivity.startActivity(intent);
                } else if (bundle.getBoolean("retry")) {
                    AmsTask.this.doWork();
                } else {
                    AmsTask.this.set(bundle);
                }
            }
        }
    }
}
