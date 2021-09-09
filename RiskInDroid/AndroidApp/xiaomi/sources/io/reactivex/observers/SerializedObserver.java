package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

public final class SerializedObserver<T> implements Observer<T>, Disposable {
    final boolean delayError;
    volatile boolean done;
    final Observer<? super T> downstream;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;
    Disposable upstream;

    public SerializedObserver(@NonNull Observer<? super T> observer) {
        this(observer, false);
    }

    public SerializedObserver(@NonNull Observer<? super T> observer, boolean z) {
        this.downstream = observer;
        this.delayError = z;
    }

    public final void onSubscribe(@NonNull Disposable disposable) {
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

    public final void onNext(@NonNull T t) {
        if (!this.done) {
            if (t == null) {
                this.upstream.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.emitting = true;
                    this.downstream.onNext(t);
                    emitLoop();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        io.reactivex.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.downstream.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    public final void onError(@NonNull Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.done) {
                if (this.emitting) {
                    this.done = true;
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                        this.queue = appendOnlyLinkedArrayList;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.delayError) {
                        appendOnlyLinkedArrayList.add(error);
                    } else {
                        appendOnlyLinkedArrayList.setFirst(error);
                    }
                } else {
                    this.done = true;
                    this.emitting = true;
                    z = false;
                }
            }
        }
    }

    public final void onComplete() {
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.done = true;
                    this.emitting = true;
                    this.downstream.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void emitLoop() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
        } while (!appendOnlyLinkedArrayList.accept(this.downstream));
    }
}
