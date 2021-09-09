package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeIsEmptySingle<T> extends Single<Boolean> implements FuseToMaybe<Boolean>, HasUpstreamMaybeSource<T> {
    final MaybeSource<T> source;

    public MaybeIsEmptySingle(MaybeSource<T> maybeSource) {
        this.source = maybeSource;
    }

    public final MaybeSource<T> source() {
        return this.source;
    }

    public final Maybe<Boolean> fuseToMaybe() {
        return RxJavaPlugins.onAssembly(new MaybeIsEmpty(this.source));
    }

    public final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new IsEmptyMaybeObserver(singleObserver));
    }

    static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final SingleObserver<? super Boolean> downstream;
        Disposable upstream;

        IsEmptyMaybeObserver(SingleObserver<? super Boolean> singleObserver) {
            this.downstream = singleObserver;
        }

        public final void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
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
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(Boolean.FALSE);
        }

        public final void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(Boolean.TRUE);
        }
    }
}
