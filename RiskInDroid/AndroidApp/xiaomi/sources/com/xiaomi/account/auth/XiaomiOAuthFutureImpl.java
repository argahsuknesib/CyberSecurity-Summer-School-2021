package com.xiaomi.account.auth;

import android.accounts.OperationCanceledException;
import android.os.Looper;
import com.xiaomi.account.openauth.XMAuthericationException;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class XiaomiOAuthFutureImpl<V> extends FutureTask<V> implements XiaomiOAuthFuture<V> {
    private void ensureNotOnMainThread() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == Looper.getMainLooper()) {
            throw new IllegalStateException("calling this from your main thread can lead to deadlock");
        }
    }

    public XiaomiOAuthFutureImpl(Callable<V> callable) {
        super(callable);
    }

    public V getResult() throws IOException, OperationCanceledException, XMAuthericationException {
        return internalGetResult(10L, TimeUnit.MINUTES);
    }

    public V getResult(long j, TimeUnit timeUnit) throws IOException, OperationCanceledException, XMAuthericationException {
        return internalGetResult(Long.valueOf(j), timeUnit);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0059 */
    private V internalGetResult(Long l, TimeUnit timeUnit) throws OperationCanceledException, IOException, XMAuthericationException {
        if (!isDone()) {
            ensureNotOnMainThread();
        }
        if (l == null) {
            try {
                V v = get();
                cancel(true);
                return v;
            } catch (CancellationException ) {
                throw new OperationCanceledException();
            } catch (InterruptedException | TimeoutException unused) {
                cancel(true);
                throw new OperationCanceledException();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause instanceof IOException) {
                    throw ((IOException) cause);
                } else if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else if (cause instanceof Error) {
                    throw ((Error) cause);
                } else if (cause instanceof XMAuthericationException) {
                    throw ((XMAuthericationException) cause);
                } else if (cause instanceof OperationCanceledException) {
                    throw ((OperationCanceledException) cause);
                } else {
                    throw new XMAuthericationException(cause);
                }
            } catch (Throwable th) {
                cancel(true);
                throw th;
            }
        } else {
            V v2 = get(l.longValue(), timeUnit);
            cancel(true);
            return v2;
        }
        throw new OperationCanceledException();
    }
}
