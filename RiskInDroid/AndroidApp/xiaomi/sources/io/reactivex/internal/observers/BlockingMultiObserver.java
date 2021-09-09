package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class BlockingMultiObserver<T> extends CountDownLatch implements CompletableObserver, MaybeObserver<T>, SingleObserver<T> {
    volatile boolean cancelled;
    Throwable error;
    Disposable upstream;
    T value;

    public BlockingMultiObserver() {
        super(1);
    }

    /* access modifiers changed from: package-private */
    public final void dispose() {
        this.cancelled = true;
        Disposable disposable = this.upstream;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        if (this.cancelled) {
            disposable.dispose();
        }
    }

    public final void onSuccess(T t) {
        this.value = t;
        countDown();
    }

    public final void onError(Throwable th) {
        this.error = th;
        countDown();
    }

    public final void onComplete() {
        countDown();
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public final T blockingGet(T t) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            T t2 = this.value;
            return t2 != null ? t2 : t;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public final Throwable blockingGetError() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                return e;
            }
        }
        return this.error;
    }

    public final Throwable blockingGetError(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    dispose();
                    throw ExceptionHelper.wrapOrThrow(new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit)));
                }
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this.error;
    }

    public final boolean blockingAwait(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    dispose();
                    return false;
                }
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
