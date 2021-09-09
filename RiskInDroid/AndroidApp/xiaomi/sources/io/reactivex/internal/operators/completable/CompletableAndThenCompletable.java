package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenCompletable extends Completable {
    final CompletableSource next;
    final CompletableSource source;

    public CompletableAndThenCompletable(CompletableSource completableSource, CompletableSource completableSource2) {
        this.source = completableSource;
        this.next = completableSource2;
    }

    public final void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new SourceObserver(completableObserver, this.next));
    }

    static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -4101678820158072998L;
        final CompletableObserver actualObserver;
        final CompletableSource next;

        SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.actualObserver = completableObserver;
            this.next = completableSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.actualObserver.onSubscribe(this);
            }
        }

        public final void onError(Throwable th) {
            this.actualObserver.onError(th);
        }

        public final void onComplete() {
            this.next.subscribe(new NextObserver(this, this.actualObserver));
        }

        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }
    }

    static final class NextObserver implements CompletableObserver {
        final CompletableObserver downstream;
        final AtomicReference<Disposable> parent;

        public NextObserver(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
            this.parent = atomicReference;
            this.downstream = completableObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.parent, disposable);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }
    }
}
