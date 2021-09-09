package com.xiaomi.passport.LocalFeatures;

import _m_j.eer;
import _m_j.ees;
import _m_j.eet;
import _m_j.eeu;
import _m_j.ekq;
import _m_j.eks;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.xiaomi.accounts.ILocalFeatureManagerResponse;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.MetaLoginData;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;

public final class LocalFeaturesImpl implements eet {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ExecutorService f6183O000000o = Executors.newFixedThreadPool(5);
    private static LocalFeaturesImpl O00000o = null;
    public Context O00000Oo;
    Handler O00000o0 = new Handler(this.O00000Oo.getMainLooper());

    private LocalFeaturesImpl(Context context) {
        this.O00000Oo = context;
    }

    public static synchronized LocalFeaturesImpl O000000o(Context context) {
        LocalFeaturesImpl localFeaturesImpl;
        synchronized (LocalFeaturesImpl.class) {
            if (O00000o == null) {
                O00000o = new LocalFeaturesImpl(context);
            }
            localFeaturesImpl = O00000o;
        }
        return localFeaturesImpl;
    }

    public final ees<Bundle> O000000o(String str, String str2, String str3, Activity activity) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("userId or password options is null");
        }
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        return new AmsTask(activity, null, null) {
            /* class com.xiaomi.passport.LocalFeatures.LocalFeaturesImpl.AnonymousClass1 */

            public void doWork() throws RemoteException {
                LocalFeaturesImpl.f6183O000000o.execute(new Runnable() {
                    /* class com.xiaomi.passport.LocalFeatures.LocalFeaturesImpl.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        LocalFeaturesImpl localFeaturesImpl = LocalFeaturesImpl.this;
                        LocalFeaturesManagerResponse localFeaturesManagerResponse = AnonymousClass1.this.mResponse;
                        String str = str4;
                        String str2 = str5;
                        String str3 = str6;
                        if (localFeaturesManagerResponse != null) {
                            try {
                                AccountInfo O000000o2 = ekq.O000000o(str, str2, str3);
                                Bundle bundle = new Bundle();
                                bundle.putString("sts_url", O000000o2 != null ? O000000o2.getAutoLoginUrl() : null);
                                localFeaturesManagerResponse.O000000o(bundle);
                            } catch (NeedCaptchaException e) {
                                NeedCaptchaException needCaptchaException = e;
                                AccountLog.w("LocalFeaturesImpl", needCaptchaException);
                                localFeaturesImpl.O000000o(localFeaturesManagerResponse, str, str2, str3, needCaptchaException);
                            } catch (NeedVerificationException e2) {
                                NeedVerificationException needVerificationException = e2;
                                AccountLog.w("LocalFeaturesImpl", needVerificationException);
                                localFeaturesImpl.O000000o(localFeaturesManagerResponse, str, str2, str3, needVerificationException);
                            } catch (NeedNotificationException e3) {
                                NeedNotificationException needNotificationException = e3;
                                AccountLog.w("LocalFeaturesImpl", needNotificationException);
                                localFeaturesImpl.O000000o(localFeaturesManagerResponse, str, str2, str3, needNotificationException);
                            } catch (InvalidCredentialException e4) {
                                InvalidCredentialException invalidCredentialException = e4;
                                AccountLog.w("LocalFeaturesImpl", invalidCredentialException);
                                if (invalidCredentialException.getHasPwd()) {
                                    localFeaturesManagerResponse.O000000o(4, invalidCredentialException.getMessage());
                                } else {
                                    localFeaturesImpl.O000000o(localFeaturesManagerResponse, str, str2, str3, invalidCredentialException);
                                }
                            } catch (IOException e5) {
                                AccountLog.w("LocalFeaturesImpl", e5);
                                localFeaturesManagerResponse.O000000o(5, e5.getMessage());
                            } catch (InvalidResponseException e6) {
                                AccountLog.w("LocalFeaturesImpl", e6);
                                localFeaturesManagerResponse.O000000o(6, e6.getMessage());
                            } catch (AccessDeniedException e7) {
                                AccountLog.w("LocalFeaturesImpl", e7);
                                localFeaturesManagerResponse.O000000o(7, e7.getMessage());
                            } catch (InvalidUserNameException e8) {
                                AccountLog.w("LocalFeaturesImpl", e8);
                                localFeaturesManagerResponse.O000000o(8, e8.getMessage());
                            } catch (AuthenticationFailureException e9) {
                                AccountLog.w("LocalFeaturesImpl", e9);
                                localFeaturesManagerResponse.O000000o(6, e9.getMessage());
                            } catch (IllegalDeviceException e10) {
                                AccountLog.w("LocalFeaturesImpl", e10);
                                localFeaturesManagerResponse.O000000o(9, e10.getMessage());
                            }
                        } else {
                            throw new IllegalArgumentException("response is null");
                        }
                    }
                });
            }
        }.start();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(LocalFeaturesManagerResponse localFeaturesManagerResponse, String str, String str2, String str3, Exception exc) {
        Intent intent;
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("service_id", str3);
        bundle.putString("password", str2);
        bundle.putBoolean("need_retry_on_authenticator_response_result", true);
        if (exc instanceof NeedCaptchaException) {
            bundle.putString("captcha_url", ((NeedCaptchaException) exc).getCaptchaUrl());
        } else if (exc instanceof NeedNotificationException) {
            intent = eks.O000000o(this.O00000Oo, localFeaturesManagerResponse, ((NeedNotificationException) exc).getNotificationUrl(), null, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("intent", intent);
            localFeaturesManagerResponse.O000000o(bundle2);
        } else if (exc instanceof NeedVerificationException) {
            NeedVerificationException needVerificationException = (NeedVerificationException) exc;
            MetaLoginData metaLoginData = needVerificationException.getMetaLoginData();
            bundle.putString("extra_step1_token", needVerificationException.getStep1Token());
            bundle.putString("extra_sign", metaLoginData.sign);
            bundle.putString("extra_qs", metaLoginData.qs);
            bundle.putString("extra_callback", metaLoginData.callback);
        }
        intent = eks.O00000Oo(localFeaturesManagerResponse, bundle);
        Bundle bundle22 = new Bundle();
        bundle22.putParcelable("intent", intent);
        localFeaturesManagerResponse.O000000o(bundle22);
    }

    public final ees<Bundle> O000000o(String str, Activity activity, eer<Bundle> eer) {
        final String str2 = str;
        final Activity activity2 = activity;
        return new AmsTask(activity, null, eer, null) {
            /* class com.xiaomi.passport.LocalFeatures.LocalFeaturesImpl.AnonymousClass2 */

            public void doWork() throws RemoteException {
                LocalFeaturesImpl.f6183O000000o.execute(new Runnable() {
                    /* class com.xiaomi.passport.LocalFeatures.LocalFeaturesImpl.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        if (!ekq.O00000Oo(str2)) {
                            AnonymousClass2.this.mResponse.O000000o(7, "invalid scan code login url");
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW");
                        if (MiAccountManager.O00000Oo(LocalFeaturesImpl.this.O00000Oo).O00000Oo()) {
                            intent.setClassName("com.xiaomi.account", "com.xiaomi.account.ui.AccountWebActivity");
                        } else {
                            intent.setComponent(eeu.f15193O000000o.O00000o());
                        }
                        intent.putExtra("accountAuthenticatorResponse", AnonymousClass2.this.mResponse);
                        intent.setData(Uri.parse(str2));
                        if (null != null) {
                            intent.putExtras(null);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("intent", intent);
                        AnonymousClass2.this.mResponse.O000000o(bundle);
                    }
                });
            }
        }.start();
    }

    abstract class AmsTask extends FutureTask<Bundle> implements ees<Bundle> {
        final Activity mActivity;
        final eer<Bundle> mCallback;
        final Handler mHandler;
        final LocalFeaturesManagerResponse mResponse = new LocalFeaturesManagerResponse(new Response());

        public abstract void doWork() throws RemoteException;

        public AmsTask(Activity activity, Handler handler, eer<Bundle> eer) {
            super(new Callable<Bundle>() {
                /* class com.xiaomi.passport.LocalFeatures.LocalFeaturesImpl.AmsTask.AnonymousClass1 */

                public Bundle call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            this.mHandler = handler;
            this.mCallback = eer;
            this.mActivity = activity;
        }

        public final ees<Bundle> start() {
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
                AccountLog.e("LocalFeaturesImpl", "the bundle must not be null", new Exception());
            }
            super.set((Object) bundle);
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x00ea */
        private Bundle internalGetResult(Long l, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException, InvalidCredentialException, InvalidUserNameException, InvalidResponseException, IllegalDeviceException, AccessDeniedException, AuthenticationFailureException {
            if (!isDone()) {
                LocalFeaturesImpl localFeaturesImpl = LocalFeaturesImpl.this;
                Looper myLooper = Looper.myLooper();
                if (myLooper != null && myLooper == localFeaturesImpl.O00000Oo.getMainLooper()) {
                    IllegalStateException illegalStateException = new IllegalStateException("calling this from your main thread can lead to deadlock");
                    AccountLog.e("LocalFeaturesImpl", "calling this from your main thread can lead to deadlock and/or ANRs", illegalStateException);
                    if (localFeaturesImpl.O00000Oo.getApplicationInfo().targetSdkVersion >= 8) {
                        throw illegalStateException;
                    }
                }
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
                    } else if (cause instanceof InvalidCredentialException) {
                        throw new InvalidCredentialException(((InvalidCredentialException) cause).hasPwd);
                    } else if (cause instanceof InvalidUserNameException) {
                        throw new InvalidUserNameException();
                    } else if (cause instanceof InvalidResponseException) {
                        throw new InvalidResponseException(e.getMessage());
                    } else if (cause instanceof IllegalDeviceException) {
                        throw new IllegalDeviceException(e.getMessage());
                    } else if (cause instanceof SSLException) {
                        throw new SSLException(e.getMessage());
                    } else if (cause instanceof AccessDeniedException) {
                        throw new AccessDeniedException(403, e.getMessage());
                    } else if (cause instanceof AuthenticationFailureException) {
                        throw new AuthenticationFailureException(e.getMessage());
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

        public Bundle getResult() throws OperationCanceledException, IOException, AuthenticatorException, InvalidCredentialException, InvalidUserNameException, AccessDeniedException, InvalidResponseException, IllegalDeviceException, AuthenticationFailureException {
            return internalGetResult(null, null);
        }

        public Bundle getResult(long j, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException, InvalidCredentialException, InvalidUserNameException, AccessDeniedException, InvalidResponseException, IllegalDeviceException, AuthenticationFailureException {
            return internalGetResult(Long.valueOf(j), timeUnit);
        }

        /* access modifiers changed from: protected */
        public void done() {
            eer<Bundle> eer = this.mCallback;
            if (eer != null) {
                LocalFeaturesImpl localFeaturesImpl = LocalFeaturesImpl.this;
                Handler handler = this.mHandler;
                if (handler == null) {
                    handler = localFeaturesImpl.O00000o0;
                }
                handler.post(new Runnable(eer, this) {
                    /* class com.xiaomi.passport.LocalFeatures.LocalFeaturesImpl.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ eer f6186O000000o;
                    final /* synthetic */ ees O00000Oo;

                    {
                        this.f6186O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final void run() {
                        this.f6186O000000o.run(this.O00000Oo);
                    }
                });
            }
        }

        class Response extends ILocalFeatureManagerResponse.Stub {
            public void onRequestContinued() throws RemoteException {
            }

            private Response() {
            }

            public void onResult(Bundle bundle) {
                Intent intent = (Intent) bundle.getParcelable("intent");
                if (intent != null && AmsTask.this.mActivity != null) {
                    AmsTask.this.mActivity.startActivity(intent);
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
                    AmsTask.this.setException(LocalFeaturesImpl.O000000o(i, str));
                }
            }
        }
    }

    public static Exception O000000o(int i, String str) {
        if (i == 5) {
            return new IOException(str);
        }
        if (i == 7) {
            return new AccessDeniedException(403, str);
        }
        if (i == 4) {
            return new InvalidCredentialException(70016, str, true);
        }
        if (i == 10) {
            return new SSLException(str);
        }
        if (i == 6) {
            return new InvalidResponseException(str);
        }
        if (i == 8) {
            return new InvalidUserNameException();
        }
        if (i == 9) {
            return new IllegalDeviceException(str);
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
}
