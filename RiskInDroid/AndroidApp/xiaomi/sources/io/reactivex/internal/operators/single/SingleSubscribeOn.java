package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubscribeOn<T> extends Single<T> {
    final Scheduler scheduler;
    final SingleSource<? extends T> source;

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler2) {
        this.source = singleSource;
        this.scheduler = scheduler2;
    }

    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.source);
        singleObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.scheduler.scheduleDirect(subscribeOnObserver));
    }

    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final SingleObserver<? super T> downstream;
        final SingleSource<? extends T> source;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.downstream = singleObserver;
            this.source = singleSource;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void run() {
            this.source.subscribe(this);
        }
    }
}
