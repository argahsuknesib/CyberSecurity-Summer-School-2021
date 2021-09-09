package com.facebook.react.common.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SimpleSettableFuture<T> implements Future<T> {
    private Exception mException;
    private final CountDownLatch mReadyLatch = new CountDownLatch(1);
    private T mResult;

    public boolean isCancelled() {
        return false;
    }

    public void set(T t) {
        checkNotSet();
        this.mResult = t;
        this.mReadyLatch.countDown();
    }

    public void setException(Exception exc) {
        checkNotSet();
        this.mException = exc;
        this.mReadyLatch.countDown();
    }

    public boolean cancel(boolean z) {
        throw new UnsupportedOperationException();
    }

    public boolean isDone() {
        return this.mReadyLatch.getCount() == 0;
    }

    public T get() throws InterruptedException, ExecutionException {
        this.mReadyLatch.await();
        Exception exc = this.mException;
        if (exc == null) {
            return this.mResult;
        }
        throw new ExecutionException(exc);
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.mReadyLatch.await(j, timeUnit)) {
            Exception exc = this.mException;
            if (exc == null) {
                return this.mResult;
            }
            throw new ExecutionException(exc);
        }
        throw new TimeoutException("Timed out waiting for result");
    }

    public T getOrThrow() {
        try {
            return get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public T getOrThrow(long j, TimeUnit timeUnit) {
        try {
            return get(j, timeUnit);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkNotSet() {
        if (this.mReadyLatch.getCount() == 0) {
            throw new RuntimeException("Result has already been set!");
        }
    }
}
