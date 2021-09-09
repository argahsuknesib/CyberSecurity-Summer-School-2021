package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingle<T, R> extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final MaybeSource<T> source;

    public MaybeFlatMapSingle(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.source = maybeSource;
        this.mapper = function;
    }

    public final void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new FlatMapMaybeObserver(singleObserver, this.mapper));
    }

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4827726964688405508L;
        final SingleObserver<? super R> downstream;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;

        FlatMapMaybeObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.downstream = singleObserver;
            this.mapper = function;
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null SingleSource");
                if (!isDisposed()) {
                    singleSource.subscribe(new FlatMapSingleObserver(this, this.downstream));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onError(new NoSuchElementException());
        }
    }

    static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
        final SingleObserver<? super R> downstream;
        final AtomicReference<Disposable> parent;

        FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
            this.parent = atomicReference;
            this.downstream = singleObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.parent, disposable);
        }

        public final void onSuccess(R r) {
            this.downstream.onSuccess(r);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }
    }
}
