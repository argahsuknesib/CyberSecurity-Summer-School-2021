package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySupplier<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int capacityHint;
    final Callable<? extends Publisher<B>> other;

    public FlowableWindowBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, int i) {
        super(flowable);
        this.other = callable;
        this.capacityHint = i;
    }

    public final void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        this.source.subscribe((FlowableSubscriber) new WindowBoundaryMainSubscriber(subscriber, this.capacityHint, this.other));
    }

    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Runnable, Subscription {
        static final WindowBoundaryInnerSubscriber<Object, Object> BOUNDARY_DISPOSED = new WindowBoundaryInnerSubscriber<>(null);
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final AtomicReference<WindowBoundaryInnerSubscriber<T, B>> boundarySubscriber = new AtomicReference<>();
        final int capacityHint;
        volatile boolean done;
        final Subscriber<? super Flowable<T>> downstream;
        long emitted;
        final AtomicThrowable errors = new AtomicThrowable();
        final Callable<? extends Publisher<B>> other;
        final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        final AtomicLong requested;
        final AtomicBoolean stopWindows = new AtomicBoolean();
        Subscription upstream;
        UnicastProcessor<T> window;
        final AtomicInteger windows = new AtomicInteger(1);

        WindowBoundaryMainSubscriber(Subscriber<? super Flowable<T>> subscriber, int i, Callable<? extends Publisher<B>> callable) {
            this.downstream = subscriber;
            this.capacityHint = i;
            this.other = callable;
            this.requested = new AtomicLong();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                drain();
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable th) {
            disposeBoundary();
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        public final void cancel() {
            if (this.stopWindows.compareAndSet(false, true)) {
                disposeBoundary();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.cancel();
                }
            }
        }

        public final void request(long j) {
            BackpressureHelper.add(this.requested, j);
        }

        /* access modifiers changed from: package-private */
        public final void disposeBoundary() {
            Disposable andSet = this.boundarySubscriber.getAndSet(BOUNDARY_DISPOSED);
            if (andSet != null && andSet != BOUNDARY_DISPOSED) {
                andSet.dispose();
            }
        }

        public final void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerNext(WindowBoundaryInnerSubscriber<T, B> windowBoundaryInnerSubscriber) {
            this.boundarySubscriber.compareAndSet(windowBoundaryInnerSubscriber, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th) {
            this.upstream.cancel();
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete() {
            this.upstream.cancel();
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super Flowable<T>> subscriber = this.downstream;
                MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                long j = this.emitted;
                int i = 1;
                while (this.windows.get() != 0) {
                    UnicastProcessor<T> unicastProcessor = this.window;
                    boolean z = this.done;
                    if (!z || atomicThrowable.get() == null) {
                        Object poll = mpscLinkedQueue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate == null) {
                                if (unicastProcessor != null) {
                                    this.window = null;
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                                return;
                            }
                            if (unicastProcessor != null) {
                                this.window = null;
                                unicastProcessor.onError(terminate);
                            }
                            subscriber.onError(terminate);
                            return;
                        } else if (z2) {
                            this.emitted = j;
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        } else if (poll != NEXT_WINDOW) {
                            unicastProcessor.onNext(poll);
                        } else {
                            if (unicastProcessor != null) {
                                this.window = null;
                                unicastProcessor.onComplete();
                            }
                            if (!this.stopWindows.get()) {
                                if (j != this.requested.get()) {
                                    UnicastProcessor<T> create = UnicastProcessor.create(this.capacityHint, this);
                                    this.window = create;
                                    this.windows.getAndIncrement();
                                    try {
                                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.other.call(), "The other Callable returned a null Publisher");
                                        WindowBoundaryInnerSubscriber windowBoundaryInnerSubscriber = new WindowBoundaryInnerSubscriber(this);
                                        if (this.boundarySubscriber.compareAndSet(null, windowBoundaryInnerSubscriber)) {
                                            publisher.subscribe(windowBoundaryInnerSubscriber);
                                            j++;
                                            subscriber.onNext(create);
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        atomicThrowable.addThrowable(th);
                                        this.done = true;
                                    }
                                } else {
                                    this.upstream.cancel();
                                    disposeBoundary();
                                    atomicThrowable.addThrowable(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                                    this.done = true;
                                }
                            }
                        }
                    } else {
                        mpscLinkedQueue.clear();
                        Throwable terminate2 = atomicThrowable.terminate();
                        if (unicastProcessor != null) {
                            this.window = null;
                            unicastProcessor.onError(terminate2);
                        }
                        subscriber.onError(terminate2);
                        return;
                    }
                }
                mpscLinkedQueue.clear();
                this.window = null;
            }
        }
    }

    static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {
        boolean done;
        final WindowBoundaryMainSubscriber<T, B> parent;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
            this.parent = windowBoundaryMainSubscriber;
        }

        public final void onNext(B b) {
            if (!this.done) {
                this.done = true;
                dispose();
                this.parent.innerNext(this);
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.parent.innerError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                this.parent.innerComplete();
            }
        }
    }
}
