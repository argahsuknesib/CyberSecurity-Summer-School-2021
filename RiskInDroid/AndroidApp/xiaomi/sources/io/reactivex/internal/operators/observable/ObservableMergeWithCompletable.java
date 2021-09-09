package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    final CompletableSource other;

    public ObservableMergeWithCompletable(Observable<T> observable, CompletableSource completableSource) {
        super(observable);
        this.other = completableSource;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.other.subscribe(mergeWithObserver.otherObserver);
    }

    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        final Observer<? super T> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        final AtomicReference<Disposable> mainDisposable = new AtomicReference<>();
        volatile boolean mainDone;
        volatile boolean otherDone;
        final OtherObserver otherObserver = new OtherObserver(this);

        MergeWithObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.mainDisposable, disposable);
        }

        public final void onNext(T t) {
            HalfSerializer.onNext(this.downstream, t, this, this.error);
        }

        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.mainDisposable);
            HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        public final void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        public final void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        /* access modifiers changed from: package-private */
        public final void otherError(Throwable th) {
            DisposableHelper.dispose(this.mainDisposable);
            HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public final void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<?> parent;

            OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public final void onError(Throwable th) {
                this.parent.otherError(th);
            }

            public final void onComplete() {
                this.parent.otherComplete();
            }
        }
    }
}
