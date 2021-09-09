package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class LockOnGetVariable<T> {
    public CountDownLatch initLatch;
    public T value;

    public LockOnGetVariable(Object obj) {
        this.value = obj;
    }

    public LockOnGetVariable(final Callable callable) {
        this.initLatch = new CountDownLatch(1);
        FacebookSdk.getExecutor().execute(new FutureTask(new Callable<Void>() {
            /* class com.facebook.internal.LockOnGetVariable.AnonymousClass1 */

            /* JADX INFO: finally extract failed */
            public Void call() throws Exception {
                try {
                    LockOnGetVariable.this.value = callable.call();
                    LockOnGetVariable.this.initLatch.countDown();
                    return null;
                } catch (Throwable th) {
                    LockOnGetVariable.this.initLatch.countDown();
                    throw th;
                }
            }
        }));
    }

    public T getValue() {
        waitOnInit();
        return this.value;
    }

    private void waitOnInit() {
        CountDownLatch countDownLatch = this.initLatch;
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
        }
    }
}
