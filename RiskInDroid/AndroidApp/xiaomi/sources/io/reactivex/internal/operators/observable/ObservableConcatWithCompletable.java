package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource other;

    public ObservableConcatWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.other = completableSource;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ConcatWithObserver(observer, this.other));
    }

    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Observer<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;
        final Observer<? super T> downstream;
        boolean inCompletable;
        CompletableSource other;

        ConcatWithObserver(Observer<? super T> observer, CompletableSource completableSource) {
            this.downstream = observer;
            this.other = completableSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && !this.inCompletable) {
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (this.inCompletable) {
                this.downstream.onComplete();
                return;
            }
            this.inCompletable = true;
            DisposableHelper.replace(this, null);
            CompletableSource completableSource = this.other;
            this.other = null;
            completableSource.subscribe(this);
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }
    }
}
