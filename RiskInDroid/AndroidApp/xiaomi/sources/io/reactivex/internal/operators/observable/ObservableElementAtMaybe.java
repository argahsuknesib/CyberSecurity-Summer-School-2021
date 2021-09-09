package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {
    final long index;
    final ObservableSource<T> source;

    public ObservableElementAtMaybe(ObservableSource<T> observableSource, long j) {
        this.source = observableSource;
        this.index = j;
    }

    public final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new ElementAtObserver(maybeObserver, this.index));
    }

    public final Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableElementAt(this.source, this.index, null, false));
    }

    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        long count;
        boolean done;
        final MaybeObserver<? super T> downstream;
        final long index;
        Disposable upstream;

        ElementAtObserver(MaybeObserver<? super T> maybeObserver, long j) {
            this.downstream = maybeObserver;
            this.index = j;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.upstream.dispose();
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.done) {
                long j = this.count;
                if (j == this.index) {
                    this.done = true;
                    this.upstream.dispose();
                    this.downstream.onSuccess(t);
                    return;
                }
                this.count = j + 1;
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }
    }
}
