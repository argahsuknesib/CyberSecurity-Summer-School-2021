package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    @Nullable
    final Publisher<? extends T>[] array;
    final int bufferSize;
    final Function<? super Object[], ? extends R> combiner;
    final boolean delayErrors;
    @Nullable
    final Iterable<? extends Publisher<? extends T>> iterable;

    public FlowableCombineLatest(@NonNull Publisher[] publisherArr, @NonNull Function function, int i, boolean z) {
        this.array = publisherArr;
        this.iterable = null;
        this.combiner = function;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    public FlowableCombineLatest(@NonNull Iterable iterable2, @NonNull Function function, int i, boolean z) {
        this.array = null;
        this.iterable = iterable2;
        this.combiner = function;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        int i;
        Publisher<? extends T>[] publisherArr = this.array;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                Iterator it = (Iterator) ObjectHelper.requireNonNull(this.iterable.iterator(), "The iterator returned is null");
                i = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            Publisher<? extends T> publisher = (Publisher) ObjectHelper.requireNonNull(it.next(), "The publisher returned by the iterator is null");
                            if (i == publisherArr.length) {
                                Publisher<? extends T>[] publisherArr2 = new Publisher[((i >> 2) + i)];
                                System.arraycopy(publisherArr, 0, publisherArr2, 0, i);
                                publisherArr = publisherArr2;
                            }
                            publisherArr[i] = publisher;
                            i++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            EmptySubscription.error(th, subscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptySubscription.error(th2, subscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
                return;
            }
        } else {
            i = publisherArr.length;
        }
        if (i == 0) {
            EmptySubscription.complete(subscriber);
        } else if (i == 1) {
            publisherArr[0].subscribe(new FlowableMap.MapSubscriber(subscriber, new SingletonArrayFunc()));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.combiner, i, this.bufferSize, this.delayErrors);
            subscriber.onSubscribe(combineLatestCoordinator);
            combineLatestCoordinator.subscribe(publisherArr, i);
        }
    }

    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        volatile boolean cancelled;
        final Function<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.downstream = subscriber;
            this.combiner = function;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i];
            for (int i3 = 0; i3 < i; i3++) {
                combineLatestInnerSubscriberArr[i3] = new CombineLatestInnerSubscriber<>(this, i3, i2);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i];
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                drain();
            }
        }

        public final void cancel() {
            this.cancelled = true;
            cancelAll();
        }

        /* access modifiers changed from: package-private */
        public final void subscribe(Publisher<? extends T>[] publisherArr, int i) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.subscribers;
            for (int i2 = 0; i2 < i && !this.done && !this.cancelled; i2++) {
                publisherArr[i2].subscribe(combineLatestInnerSubscriberArr[i2]);
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerValue(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.latest;
                int i2 = this.nonEmptySources;
                if (objArr[i] == null) {
                    i2++;
                    this.nonEmptySources = i2;
                }
                objArr[i] = t;
                if (objArr.length == i2) {
                    this.queue.offer(this.subscribers[i], objArr.clone());
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                this.subscribers[i].requestOne();
            } else {
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            return;
         */
        public final void innerComplete(int i) {
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr[i] != null) {
                    int i2 = this.completedSources + 1;
                    if (i2 == objArr.length) {
                        this.done = true;
                    } else {
                        this.completedSources = i2;
                    }
                } else {
                    this.done = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerError(int i, Throwable th) {
            if (!ExceptionHelper.addThrowable(this.error, th)) {
                RxJavaPlugins.onError(th);
            } else if (!this.delayErrors) {
                cancelAll();
                this.done = true;
                drain();
            } else {
                innerComplete(i);
            }
        }

        /* access modifiers changed from: package-private */
        public final void drainOutput() {
            Subscriber<? super R> subscriber = this.downstream;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            int i = 1;
            while (!this.cancelled) {
                Throwable th = this.error.get();
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z = this.done;
                boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                if (!isEmpty) {
                    subscriber.onNext(null);
                }
                if (!z || !isEmpty) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        /* access modifiers changed from: package-private */
        public final void drainAsync() {
            Subscriber<? super R> subscriber = this.downstream;
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            int i = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Object poll = spscLinkedArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, subscriber, spscLinkedArrayQueue)) {
                        if (z2) {
                            break;
                        }
                        try {
                            subscriber.onNext(ObjectHelper.requireNonNull(this.combiner.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                            ((CombineLatestInnerSubscriber) poll).requestOne();
                            j2++;
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            cancelAll();
                            ExceptionHelper.addThrowable(this.error, th);
                            subscriber.onError(ExceptionHelper.terminate(this.error));
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (j2 != j || !checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                        this.requested.addAndGet(-j2);
                    }
                    i = addAndGet(-i);
                } else {
                    return;
                }
            } while (i != 0);
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainOutput();
                } else {
                    drainAsync();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.cancelled) {
                cancelAll();
                spscLinkedArrayQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.delayErrors) {
                    Throwable terminate = ExceptionHelper.terminate(this.error);
                    if (terminate != null && terminate != ExceptionHelper.TERMINATED) {
                        cancelAll();
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(terminate);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        cancelAll();
                        subscriber.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    cancelAll();
                    Throwable terminate2 = ExceptionHelper.terminate(this.error);
                    if (terminate2 == null || terminate2 == ExceptionHelper.TERMINATED) {
                        subscriber.onComplete();
                    } else {
                        subscriber.onError(terminate2);
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void cancelAll() {
            for (CombineLatestInnerSubscriber<T> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        public final int requestFusion(int i) {
            boolean z = false;
            if ((i & 4) != 0) {
                return 0;
            }
            int i2 = i & 2;
            if (i2 != 0) {
                z = true;
            }
            this.outputFused = z;
            return i2;
        }

        @Nullable
        public final R poll() throws Exception {
            Object poll = this.queue.poll();
            if (poll == null) {
                return null;
            }
            R requireNonNull = ObjectHelper.requireNonNull(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).requestOne();
            return requireNonNull;
        }

        public final void clear() {
            this.queue.clear();
        }

        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i2) {
            this.parent = combineLatestCoordinator;
            this.index = i;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, (long) this.prefetch);
        }

        public final void onNext(T t) {
            this.parent.innerValue(this.index, t);
        }

        public final void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        public final void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public final void cancel() {
            SubscriptionHelper.cancel(this);
        }

        public final void requestOne() {
            int i = this.produced + 1;
            if (i == this.limit) {
                this.produced = 0;
                ((Subscription) get()).request((long) i);
                return;
            }
            this.produced = i;
        }
    }

    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        public final R apply(T t) throws Exception {
            return FlowableCombineLatest.this.combiner.apply(new Object[]{t});
        }
    }
}
