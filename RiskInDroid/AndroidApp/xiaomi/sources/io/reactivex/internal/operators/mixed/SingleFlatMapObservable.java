package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
    final SingleSource<T> source;

    public SingleFlatMapObservable(SingleSource<T> singleSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.source = singleSource;
        this.mapper = function;
    }

    public final void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.mapper);
        observer.onSubscribe(flatMapObserver);
        this.source.subscribe(flatMapObserver);
    }

    static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;
        final Observer<? super R> downstream;
        final Function<? super T, ? extends ObservableSource<? extends R>> mapper;

        FlatMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.downstream = observer;
            this.mapper = function;
        }

        public final void onNext(R r) {
            this.downstream.onNext(r);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public final void onSuccess(T t) {
            try {
                ((ObservableSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }
    }
}
