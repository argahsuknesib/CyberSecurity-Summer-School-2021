package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    final ObservableSource<? extends U> other;

    public ObservableTakeUntil(ObservableSource<T> observableSource, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.other = observableSource2;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.other.subscribe(takeUntilMainObserver.otherObserver);
        this.source.subscribe(takeUntilMainObserver);
    }

    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1418547743690811973L;
        final Observer<? super T> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new OtherObserver();
        final AtomicReference<Disposable> upstream = new AtomicReference<>();

        TakeUntilMainObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public final void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public final void onNext(T t) {
            HalfSerializer.onNext(this.downstream, t, this, this.error);
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        public final void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public final void otherError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public final void otherComplete() {
            DisposableHelper.dispose(this.upstream);
            HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            OtherObserver() {
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onNext(U u) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver.this.otherComplete();
            }

            public final void onError(Throwable th) {
                TakeUntilMainObserver.this.otherError(th);
            }

            public final void onComplete() {
                TakeUntilMainObserver.this.otherComplete();
            }
        }
    }
}
