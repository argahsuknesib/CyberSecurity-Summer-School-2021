package com.github.scribejava.core.httpclient.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JDKHttpFuture<V> implements Future<V> {
    private final Exception exception;
    private final V response;

    public boolean cancel(boolean z) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public JDKHttpFuture(Exception exc) {
        this(null, exc);
    }

    public JDKHttpFuture(V v) {
        this(v, null);
    }

    private JDKHttpFuture(V v, Exception exc) {
        this.response = v;
        this.exception = exc;
    }

    public V get() throws InterruptedException, ExecutionException {
        Exception exc = this.exception;
        if (exc == null) {
            return this.response;
        }
        throw new ExecutionException(exc);
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return get();
    }
}
