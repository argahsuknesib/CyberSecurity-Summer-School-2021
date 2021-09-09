package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends R> mapper;

    public MaybeMap(MaybeSource<T> maybeSource, Function<? super T, ? extends R> function) {
        super(maybeSource);
        this.mapper = function;
    }

    public final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.source.subscribe(new MapMaybeObserver(maybeObserver, this.mapper));
    }

    static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super R> downstream;
        final Function<? super T, ? extends R> mapper;
        Disposable upstream;

        MapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends R> function) {
            this.downstream = maybeObserver;
            this.mapper = function;
        }

        public final void dispose() {
            Disposable disposable = this.upstream;
            this.upstream = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                this.downstream.onSuccess(ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null item"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }
    }
}
