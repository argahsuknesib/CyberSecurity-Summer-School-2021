package com.xiaomi.passport.accountmanager;

import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.os.AsyncTask;
import android.os.Bundle;
import com.xiaomi.passport.servicetoken.AMAuthTokenConverter;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class AMFutureConverter {
    public static AccountManagerFuture<Bundle> O000000o(final ServiceTokenFuture serviceTokenFuture) {
        final MyAccountManagerFuture myAccountManagerFuture = new MyAccountManagerFuture();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            /* class com.xiaomi.passport.accountmanager.AMFutureConverter.AnonymousClass1 */

            public final void run() {
                ServiceTokenResult serviceTokenResult = serviceTokenFuture.get();
                Exception O000000o2 = AMAuthTokenConverter.O000000o(serviceTokenResult);
                if (O000000o2 != null) {
                    myAccountManagerFuture.setException(O000000o2);
                    return;
                }
                try {
                    myAccountManagerFuture.setResult(AMAuthTokenConverter.O00000Oo(serviceTokenResult));
                } catch (AMAuthTokenConverter.ConvertException e) {
                    myAccountManagerFuture.setException(new AuthenticatorException(String.format("errorCode=%s;errorMsg:%s", e.errorCode, e.errorMsg)));
                }
            }
        });
        return myAccountManagerFuture;
    }

    static class MyAccountManagerFuture extends FutureTask<Bundle> implements AccountManagerFuture<Bundle> {
        public MyAccountManagerFuture() {
            super(new Callable<Bundle>() {
                /* class com.xiaomi.passport.accountmanager.AMFutureConverter.MyAccountManagerFuture.AnonymousClass1 */

                public Bundle call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
        }

        public Bundle getResult() throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(null, null);
        }

        public Bundle getResult(long j, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
            return internalGetResult(Long.valueOf(j), timeUnit);
        }

        private Bundle internalGetResult(Long l, TimeUnit timeUnit) throws OperationCanceledException, IOException, AuthenticatorException {
            if (l == null) {
                try {
                    Bundle bundle = (Bundle) get();
                    cancel(true);
                    return bundle;
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
                Bundle bundle2 = (Bundle) get(l.longValue(), timeUnit);
                cancel(true);
                return bundle2;
            }
        }

        public void setResult(Bundle bundle) {
            super.set(bundle);
        }

        public void setException(Exception exc) {
            super.setException((Throwable) exc);
        }
    }
}
