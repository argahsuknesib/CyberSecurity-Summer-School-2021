package com.xiaomi.accountsdk.futureservice;

import com.xiaomi.accountsdk.utils.PassportExecutors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public abstract class MiAccountManagerFuture<V> extends ClientFuture<V, V> {
    private static volatile Executor executor = PassportExecutors.newFixedThreadPool(3, "MiAccountManagerFuture");

    /* access modifiers changed from: protected */
    public V convertServerDataToClientData(V v) throws Throwable {
        return v;
    }

    public abstract V doWork();

    public static void setExecutor(Executor executor2) {
        executor = executor2;
    }

    protected MiAccountManagerFuture() {
        super(null);
    }

    public void interpretExecutionException(ExecutionException executionException) throws Exception {
        throw new IllegalStateException("not going here");
    }

    public MiAccountManagerFuture<V> start() {
        executor.execute(new Runnable() {
            /* class com.xiaomi.accountsdk.futureservice.MiAccountManagerFuture.AnonymousClass1 */

            public void run() {
                try {
                    MiAccountManagerFuture.this.setServerData(MiAccountManagerFuture.this.doWork());
                } catch (Throwable th) {
                    MiAccountManagerFuture.this.setServerSideThrowable(th);
                }
            }
        });
        return this;
    }
}
