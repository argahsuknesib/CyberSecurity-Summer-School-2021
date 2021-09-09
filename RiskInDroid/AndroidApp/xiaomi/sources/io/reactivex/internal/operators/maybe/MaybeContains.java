package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

public final class MaybeContains<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T> {
    final MaybeSource<T> source;
    final Object value;

    public MaybeContains(MaybeSource<T> maybeSource, Object obj) {
        this.source = maybeSource;
        this.value = obj;
    }

    public final MaybeSource<T> source() {
        return this.source;
    }

    public final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.source.subscribe(new ContainsMaybeObserver(singleObserver, this.value));
    }

    static final class ContainsMaybeObserver implements MaybeObserver<Object>, Disposable {
        final SingleObserver<? super Boolean> downstream;
        Disposable upstream;
        final Object value;

        ContainsMaybeObserver(SingleObserver<? super Boolean> singleObserver, Object obj) {
            this.downstream = singleObserver;
            this.value = obj;
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

        public final void onSuccess(Object obj) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(Boolean.valueOf(ObjectHelper.equals(obj, this.value)));
        }

        public final void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(Boolean.FALSE);
        }
    }
}
