package com.bumptech.glide.request;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<R> implements FutureTarget<R> {
    private R resource;

    public boolean cancel(boolean z) {
        return false;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public RequestFutureTarget(R r) {
        this.resource = r;
    }

    public R get() throws ExecutionException, InterruptedException {
        return this.resource;
    }

    public R get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.resource;
    }
}
