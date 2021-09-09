package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimer extends Single<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public SingleTimer(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public final void subscribeActual(SingleObserver<? super Long> singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.scheduler.scheduleDirect(timerDisposable, this.delay, this.unit));
    }

    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final SingleObserver<? super Long> downstream;

        TimerDisposable(SingleObserver<? super Long> singleObserver) {
            this.downstream = singleObserver;
        }

        public final void run() {
            this.downstream.onSuccess(0L);
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
