package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCreate extends Completable {
    final CompletableOnSubscribe source;

    public CompletableCreate(CompletableOnSubscribe completableOnSubscribe) {
        this.source = completableOnSubscribe;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        Emitter emitter = new Emitter(completableObserver);
        completableObserver.onSubscribe(emitter);
        try {
            this.source.subscribe(emitter);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            emitter.onError(th);
        }
    }

    static final class Emitter extends AtomicReference<Disposable> implements CompletableEmitter, Disposable {
        private static final long serialVersionUID = -2467358622224974244L;
        final CompletableObserver downstream;

        Emitter(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public final void onComplete() {
            Disposable disposable;
            if (get() != DisposableHelper.DISPOSED && (disposable = (Disposable) getAndSet(DisposableHelper.DISPOSED)) != DisposableHelper.DISPOSED) {
                try {
                    this.downstream.onComplete();
                } finally {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (!tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }

        public final boolean tryOnError(Throwable th) {
            Disposable disposable;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (get() == DisposableHelper.DISPOSED || (disposable = (Disposable) getAndSet(DisposableHelper.DISPOSED)) == DisposableHelper.DISPOSED) {
                return false;
            }
            try {
                this.downstream.onError(th);
            } finally {
                if (disposable != null) {
                    disposable.dispose();
                }
            }
        }

        public final void setDisposable(Disposable disposable) {
            DisposableHelper.set(this, disposable);
        }

        public final void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public final String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }
}
