package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;

    public FlowableFlattenIterable(Flowable<T> flowable, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
        super(flowable);
        this.mapper = function;
        this.prefetch = i;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        if (this.source instanceof Callable) {
            try {
                Object call = ((Callable) this.source).call();
                if (call == null) {
                    EmptySubscription.complete(subscriber);
                    return;
                }
                try {
                    FlowableFromIterable.subscribe(subscriber, ((Iterable) this.mapper.apply(call)).iterator());
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
            }
        } else {
            this.source.subscribe((FlowableSubscriber) new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch));
        }
    }

    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        volatile boolean cancelled;
        int consumed;
        Iterator<? extends R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        int fusionMode;
        final int limit;
        final Function<? super T, ? extends Iterable<? extends R>> mapper;
        final int prefetch;
        SimpleQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        Subscription upstream;

        FlattenIterableSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function, int i) {
            this.downstream = subscriber;
            this.mapper = function;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int requestFusion = queueSubscription.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueSubscription;
                        this.downstream.onSubscribe(this);
                        subscription.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public final void onNext(T t) {
            if (!this.done) {
                if (this.fusionMode != 0 || this.queue.offer(t)) {
                    drain();
                } else {
                    onError(new MissingBackpressureException("Queue is full?!"));
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.done || !ExceptionHelper.addThrowable(this.error, th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            drain();
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0121, code lost:
            if (r6 != null) goto L_0x0123;
         */
        public final void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.downstream;
                SimpleQueue<T> simpleQueue = this.queue;
                boolean z = this.fusionMode != 1;
                Iterator<? extends R> it = this.current;
                int i = 1;
                while (true) {
                    if (it == null) {
                        boolean z2 = this.done;
                        try {
                            T poll = simpleQueue.poll();
                            if (!checkTerminated(z2, poll == null, subscriber, simpleQueue)) {
                                if (poll != null) {
                                    try {
                                        it = ((Iterable) this.mapper.apply(poll)).iterator();
                                        if (!it.hasNext()) {
                                            consumedOne(z);
                                            it = null;
                                        } else {
                                            this.current = it;
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.upstream.cancel();
                                        ExceptionHelper.addThrowable(this.error, th);
                                        subscriber.onError(ExceptionHelper.terminate(this.error));
                                        return;
                                    }
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            Exceptions.throwIfFatal(th3);
                            this.upstream.cancel();
                            ExceptionHelper.addThrowable(this.error, th3);
                            Throwable terminate = ExceptionHelper.terminate(this.error);
                            this.current = null;
                            simpleQueue.clear();
                            subscriber.onError(terminate);
                            return;
                        }
                    }
                    if (it != null) {
                        long j = this.requested.get();
                        long j2 = 0;
                        while (true) {
                            if (j2 == j) {
                                break;
                            } else if (!checkTerminated(this.done, false, subscriber, simpleQueue)) {
                                try {
                                    subscriber.onNext(ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value"));
                                    if (!checkTerminated(this.done, false, subscriber, simpleQueue)) {
                                        j2++;
                                        try {
                                            if (!it.hasNext()) {
                                                consumedOne(z);
                                                this.current = null;
                                                it = null;
                                                break;
                                            }
                                        } catch (Throwable th4) {
                                            Throwable th5 = th4;
                                            Exceptions.throwIfFatal(th5);
                                            this.current = null;
                                            this.upstream.cancel();
                                            ExceptionHelper.addThrowable(this.error, th5);
                                            subscriber.onError(ExceptionHelper.terminate(this.error));
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th6) {
                                    Exceptions.throwIfFatal(th6);
                                    this.current = null;
                                    this.upstream.cancel();
                                    ExceptionHelper.addThrowable(this.error, th6);
                                    subscriber.onError(ExceptionHelper.terminate(this.error));
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (j2 == j) {
                            if (checkTerminated(this.done, simpleQueue.isEmpty() && it == null, subscriber, simpleQueue)) {
                                return;
                            }
                        }
                        if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                            this.requested.addAndGet(-j2);
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void consumedOne(boolean z) {
            if (z) {
                int i = this.consumed + 1;
                if (i == this.limit) {
                    this.consumed = 0;
                    this.upstream.request((long) i);
                    return;
                }
                this.consumed = i;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SimpleQueue<?> simpleQueue) {
            if (this.cancelled) {
                this.current = null;
                simpleQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (this.error.get() != null) {
                    Throwable terminate = ExceptionHelper.terminate(this.error);
                    this.current = null;
                    simpleQueue.clear();
                    subscriber.onError(terminate);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            }
        }

        public final void clear() {
            this.current = null;
            this.queue.clear();
        }

        public final boolean isEmpty() {
            return this.current == null && this.queue.isEmpty();
        }

        @Nullable
        public final R poll() throws Exception {
            Iterator<? extends R> it = this.current;
            while (true) {
                if (it == null) {
                    T poll = this.queue.poll();
                    if (poll != null) {
                        it = ((Iterable) this.mapper.apply(poll)).iterator();
                        if (it.hasNext()) {
                            this.current = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R requireNonNull = ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.current = null;
            }
            return requireNonNull;
        }

        public final int requestFusion(int i) {
            return ((i & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }
}
