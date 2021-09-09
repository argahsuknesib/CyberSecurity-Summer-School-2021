package com.xiaomi.accountsdk.futureservice;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ClientFuture<ServerDataType, ClientDataType> extends FutureTask<ClientDataType> {
    public final ClientCallback<ClientDataType> mClientCallback;

    public interface ClientCallback<ClientSideDataType> {
        void call(ClientFuture<?, ClientSideDataType> clientFuture);
    }

    /* access modifiers changed from: protected */
    public abstract ClientDataType convertServerDataToClientData(Object obj) throws Throwable;

    public abstract void interpretExecutionException(ExecutionException executionException) throws Exception;

    protected ClientFuture(ClientCallback<ClientDataType> clientCallback) {
        super(new Callable<ClientDataType>() {
            /* class com.xiaomi.accountsdk.futureservice.ClientFuture.AnonymousClass1 */

            public ClientDataType call() throws Exception {
                throw new IllegalStateException("this should never be called");
            }
        });
        this.mClientCallback = clientCallback;
    }

    /* access modifiers changed from: protected */
    public void done() {
        super.done();
        onDone();
    }

    public final void setServerData(ServerDataType serverdatatype) {
        try {
            set(convertServerDataToClientData(serverdatatype));
        } catch (Throwable th) {
            setException(th);
        }
    }

    public final void setServerSideThrowable(Throwable th) {
        setException(th);
    }

    private void onDone() {
        if (!isCancelled() && this.mClientCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.xiaomi.accountsdk.futureservice.ClientFuture.AnonymousClass2 */

                public void run() {
                    ClientFuture.this.mClientCallback.call(ClientFuture.this);
                }
            });
        }
    }

    public ClientDataType get() throws InterruptedException, ExecutionException {
        if (!isDone()) {
            ensureNotOnMainThread();
        }
        return super.get();
    }

    public ClientDataType get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (!isDone()) {
            ensureNotOnMainThread();
        }
        return super.get(j, timeUnit);
    }

    private void ensureNotOnMainThread() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == Looper.getMainLooper()) {
            Log.e("ClientFuture", "calling this from your main thread can lead to deadlock and/or ANRs", new IllegalStateException("ClientFuture#calling this from your main thread can lead to deadlock"));
        }
    }
}
