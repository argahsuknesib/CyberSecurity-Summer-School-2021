package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTimer extends Completable {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public CompletableTimer(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.scheduler.scheduleDirect(timerDisposable, this.delay, this.unit));
    }

    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final CompletableObserver downstream;

        TimerDisposable(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public final void run() {
            this.downstream.onComplete();
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        /* access modifiers changed from: package-private */
        public final void setFuture(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }
}
