package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

public final class CompletableOnErrorComplete extends Completable {
    final Predicate<? super Throwable> predicate;
    final CompletableSource source;

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate2) {
        this.source = completableSource;
        this.predicate = predicate2;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new OnError(completableObserver));
    }

    final class OnError implements CompletableObserver {
        private final CompletableObserver downstream;

        OnError(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }

        public final void onError(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.predicate.test(th)) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        public final void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }
    }
}
