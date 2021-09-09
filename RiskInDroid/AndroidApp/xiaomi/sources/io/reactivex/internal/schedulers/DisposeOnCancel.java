package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class DisposeOnCancel implements Future<Object> {
    final Disposable upstream;

    public final Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return false;
    }

    DisposeOnCancel(Disposable disposable) {
        this.upstream = disposable;
    }

    public final boolean cancel(boolean z) {
        this.upstream.dispose();
        return false;
    }
}
