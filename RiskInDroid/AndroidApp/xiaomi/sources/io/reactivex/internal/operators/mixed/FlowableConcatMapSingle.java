package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapSingle<T, R> extends Flowable<R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    final int prefetch;
    final Flowable<T> source;

    public FlowableConcatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode2, int i) {
        this.source = flowable;
        this.mapper = function;
        this.errorMode = errorMode2;
        this.prefetch = i;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber) new ConcatMapSingleSubscriber(subscriber, this.mapper, this.prefetch, this.errorMode));
    }

    static final class ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        long emitted;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);
        R item;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        final int prefetch;
        final SimplePlainQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        volatile int state;
        Subscription upstream;

        ConcatMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, int i, ErrorMode errorMode2) {
            this.downstream = subscriber;
            this.mapper = function;
            this.prefetch = i;
            this.errorMode = errorMode2;
            this.queue = new SpscArrayQueue(i);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public final void onNext(T t) {
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
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

        public final void request(long j) {
            BackpressureHelper.add(this.requested, j);
            drain();
        }

        public final void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
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
                Subscriber<? super R> subscriber = this.downstream;
                ErrorMode errorMode2 = this.errorMode;
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicLong atomicLong = this.requested;
                int i = this.prefetch;
                int i2 = i - (i >> 1);
                int i3 = 1;
                while (true) {
                    if (this.cancelled) {
                        simplePlainQueue.clear();
                        this.item = null;
                    } else {
                        int i4 = this.state;
                        if (atomicThrowable.get() == null || !(errorMode2 == ErrorMode.IMMEDIATE || (errorMode2 == ErrorMode.BOUNDARY && i4 == 0))) {
                            if (i4 == 0) {
                                boolean z = this.done;
                                T poll = simplePlainQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        subscriber.onComplete();
                                        return;
                                    } else {
                                        subscriber.onError(terminate);
                                        return;
                                    }
                                } else if (!z2) {
                                    int i5 = this.consumed + 1;
                                    if (i5 == i2) {
                                        this.consumed = 0;
                                        this.upstream.request((long) i2);
                                    } else {
                                        this.consumed = i5;
                                    }
                                    try {
                                        SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null SingleSource");
                                        this.state = 1;
                                        singleSource.subscribe(this.inner);
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.upstream.cancel();
                                        simplePlainQueue.clear();
                                        atomicThrowable.addThrowable(th);
                                        subscriber.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i4 == 2) {
                                long j = this.emitted;
                                if (j != atomicLong.get()) {
                                    R r = this.item;
                                    this.item = null;
                                    subscriber.onNext(r);
                                    this.emitted = j + 1;
                                    this.state = 0;
                                }
                            }
                        }
                    }
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.item = null;
                subscriber.onError(atomicThrowable.terminate());
            }
        }

        static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapSingleSubscriber<?, R> parent;

            ConcatMapSingleObserver(ConcatMapSingleSubscriber<?, R> concatMapSingleSubscriber) {
                this.parent = concatMapSingleSubscriber;
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

            /* access modifiers changed from: package-private */
            public final void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
