package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<U> firstTimeoutIndicator;
    final Function<? super T, ? extends Publisher<V>> itemTimeoutIndicator;
    final Publisher<? extends T> other;

    interface TimeoutSelectorSupport extends FlowableTimeoutTimed.TimeoutSupport {
        void onTimeoutError(long j, Throwable th);
    }

    public FlowableTimeout(Flowable<T> flowable, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        super(flowable);
        this.firstTimeoutIndicator = publisher;
        this.itemTimeoutIndicator = function;
        this.other = publisher2;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Publisher<? extends T> publisher = this.other;
        if (publisher == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.itemTimeoutIndicator);
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.startFirstTimeout(this.firstTimeoutIndicator);
            this.source.subscribe((FlowableSubscriber) timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.itemTimeoutIndicator, publisher);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.startFirstTimeout(this.firstTimeoutIndicator);
        this.source.subscribe((FlowableSubscriber) timeoutFallbackSubscriber);
    }

    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, TimeoutSelectorSupport, Subscription {
        private static final long serialVersionUID = 3764492702657003550L;
        final Subscriber<? super T> downstream;
        final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        TimeoutSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function) {
            this.downstream = subscriber;
            this.itemTimeoutIndicator = function;
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
        }

        public final void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    Disposable disposable = (Disposable) this.task.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.upstream.get().cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void startFirstTimeout(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.task.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }

        public final void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        public final void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(new TimeoutException());
            }
        }

        public final void onTimeoutError(long j, Throwable th) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void request(long j) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.task.dispose();
        }
    }

    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;
        long consumed;
        final Subscriber<? super T> downstream;
        Publisher<? extends T> fallback;
        final AtomicLong index;
        final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function, Publisher<? extends T> publisher) {
            super(true);
            this.downstream = subscriber;
            this.itemTimeoutIndicator = function;
            this.fallback = publisher;
            this.index = new AtomicLong();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
                setSubscription(subscription);
            }
        }

        public final void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = j + 1;
                if (this.index.compareAndSet(j, j2)) {
                    Disposable disposable = (Disposable) this.task.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.consumed++;
                    this.downstream.onNext(t);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j2, this);
                        if (this.task.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.upstream.get().cancel();
                        this.index.getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void startFirstTimeout(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.task.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                this.task.dispose();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        public final void onTimeout(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                Publisher<? extends T> publisher = this.fallback;
                this.fallback = null;
                long j2 = this.consumed;
                if (j2 != 0) {
                    produced(j2);
                }
                publisher.subscribe(new FlowableTimeoutTimed.FallbackSubscriber(this.downstream, this));
            }
        }

        public final void onTimeoutError(long j, Throwable th) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void cancel() {
            super.cancel();
            this.task.dispose();
        }
    }

    static final class TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final TimeoutSelectorSupport parent;

        TimeoutConsumer(long j, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.idx = j;
            this.parent = timeoutSelectorSupport;
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        public final void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            if (subscription != SubscriptionHelper.CANCELLED) {
                subscription.cancel();
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.onTimeout(this.idx);
            }
        }

        public final void onError(Throwable th) {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.onTimeoutError(this.idx, th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void onComplete() {
            if (get() != SubscriptionHelper.CANCELLED) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.parent.onTimeout(this.idx);
            }
        }

        public final void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public final boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }
    }
}
