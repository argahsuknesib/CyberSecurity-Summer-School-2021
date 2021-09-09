package com.github.scribejava.httpclient.okhttp;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.Call;

public class OkHttpFuture<T> implements Future<T> {
    private final Call call;
    private final CountDownLatch latch = new CountDownLatch(1);
    private T result;

    public OkHttpFuture(Call call2) {
        this.call = call2;
    }

    public boolean cancel(boolean z) {
        this.call.cancel();
        return this.call.isCanceled();
    }

    public boolean isCancelled() {
        return this.call.isCanceled();
    }

    public boolean isDone() {
        return this.call.isExecuted();
    }

    public T get() throws InterruptedException, ExecutionException {
        this.latch.await();
        return this.result;
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.latch.await(j, timeUnit)) {
            return this.result;
        }
        throw new TimeoutException();
    }

    /* access modifiers changed from: package-private */
    public void finish() {
        this.latch.countDown();
    }

    /* access modifiers changed from: package-private */
    public void setResult(T t) {
        this.result = t;
    }
}
