package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapMaybe<T, R> extends Observable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    final int prefetch;
    final Observable<T> source;

    public ObservableConcatMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode2, int i) {
        this.source = observable;
        this.mapper = function;
        this.errorMode = errorMode2;
        this.prefetch = i;
    }

    public final void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.tryAsMaybe(this.source, this.mapper, observer)) {
            this.source.subscribe(new ConcatMapMaybeMainObserver(observer, this.mapper, this.prefetch, this.errorMode));
        }
    }

    static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final Observer<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapMaybeObserver<R> inner = new ConcatMapMaybeObserver<>(this);
        R item;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        final SimplePlainQueue<T> queue;
        volatile int state;
        Disposable upstream;

        ConcatMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, int i, ErrorMode errorMode2) {
            this.downstream = observer;
            this.mapper = function;
            this.errorMode = errorMode2;
            this.queue = new SpscLinkedArrayQueue(i);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.inner.dispose();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete() {
            this.state = 0;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.dispose();
                }
                this.state = 0;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.downstream;
                ErrorMode errorMode2 = this.errorMode;
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                int i = 1;
                while (true) {
                    if (this.cancelled) {
                        simplePlainQueue.clear();
                        this.item = null;
                    } else {
                        int i2 = this.state;
                        if (atomicThrowable.get() == null || !(errorMode2 == ErrorMode.IMMEDIATE || (errorMode2 == ErrorMode.BOUNDARY && i2 == 0))) {
                            boolean z = false;
                            if (i2 == 0) {
                                boolean z2 = this.done;
                                T poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z = true;
                                }
                                if (z2 && z) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        observer.onComplete();
                                        return;
                                    } else {
                                        observer.onError(terminate);
                                        return;
                                    }
                                } else if (!z) {
                                    try {
                                        MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null MaybeSource");
                                        this.state = 1;
                                        maybeSource.subscribe(this.inner);
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.upstream.dispose();
                                        simplePlainQueue.clear();
                                        atomicThrowable.addThrowable(th);
                                        observer.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i2 == 2) {
                                R r = this.item;
                                this.item = null;
                                observer.onNext(r);
                                this.state = 0;
                            }
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.item = null;
                observer.onError(atomicThrowable.terminate());
            }
        }

        static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapMaybeMainObserver<?, R> parent;

            ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
                this.parent = concatMapMaybeMainObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public final void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }

            public final void onError(Throwable th) {
                this.parent.innerError(th);
            }

            public final void onComplete() {
                this.parent.innerComplete();
            }

            /* access modifiers changed from: package-private */
            public final void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}