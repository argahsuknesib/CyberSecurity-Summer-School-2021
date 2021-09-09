package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;

public final class MaybeMergeArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] sources;

    interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        int consumerIndex();

        void drop();

        T peek();

        @Nullable
        T poll();

        int producerIndex();
    }

    public MaybeMergeArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.sources = maybeSourceArr;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Object obj;
        MaybeSource<? extends T>[] maybeSourceArr = this.sources;
        int length = maybeSourceArr.length;
        if (length <= bufferSize()) {
            obj = new MpscFillOnceSimpleQueue(length);
        } else {
            obj = new ClqSimpleQueue();
        }
        MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(subscriber, length, obj);
        subscriber.onSubscribe(mergeMaybeObserver);
        AtomicThrowable atomicThrowable = mergeMaybeObserver.error;
        int length2 = maybeSourceArr.length;
        int i = 0;
        while (i < length2) {
            MaybeSource<? extends T> maybeSource = maybeSourceArr[i];
            if (!mergeMaybeObserver.isCancelled() && atomicThrowable.get() == null) {
                maybeSource.subscribe(mergeMaybeObserver);
                i++;
            } else {
                return;
            }
        }
    }

    static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -660395290758764731L;
        volatile boolean cancelled;
        long consumed;
        final Subscriber<? super T> downstream;
        final AtomicThrowable error = new AtomicThrowable();
        boolean outputFused;
        final SimpleQueueWithConsumerIndex<Object> queue;
        final AtomicLong requested = new AtomicLong();
        final CompositeDisposable set = new CompositeDisposable();
        final int sourceCount;

        MergeMaybeObserver(Subscriber<? super T> subscriber, int i, SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex) {
            this.downstream = subscriber;
            this.sourceCount = i;
            this.queue = simpleQueueWithConsumerIndex;
        }

        public final int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Nullable
        public final T poll() throws Exception {
            T poll;
            do {
                poll = this.queue.poll();
            } while (poll == NotificationLite.COMPLETE);
            return poll;
        }

        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public final void clear() {
            this.queue.clear();
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
                this.set.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            this.set.add(disposable);
        }

        public final void onSuccess(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                this.set.dispose();
                this.queue.offer(NotificationLite.COMPLETE);
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public final void onComplete() {
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }

        /* access modifiers changed from: package-private */
        public final boolean isCancelled() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void drainNormal() {
            Subscriber<? super T> subscriber = this.downstream;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
            long j = this.consumed;
            int i = 1;
            do {
                long j2 = this.requested.get();
                while (j != j2) {
                    if (!this.cancelled) {
                        if (((Throwable) this.error.get()) == null) {
                            if (simpleQueueWithConsumerIndex.consumerIndex() != this.sourceCount) {
                                Object poll = simpleQueueWithConsumerIndex.poll();
                                if (poll == null) {
                                    break;
                                } else if (poll != NotificationLite.COMPLETE) {
                                    subscriber.onNext(poll);
                                    j++;
                                }
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        } else {
                            simpleQueueWithConsumerIndex.clear();
                            subscriber.onError(this.error.terminate());
                            return;
                        }
                    } else {
                        simpleQueueWithConsumerIndex.clear();
                        return;
                    }
                }
                if (j == j2) {
                    if (((Throwable) this.error.get()) != null) {
                        simpleQueueWithConsumerIndex.clear();
                        subscriber.onError(this.error.terminate());
                        return;
                    }
                    while (simpleQueueWithConsumerIndex.peek() == NotificationLite.COMPLETE) {
                        simpleQueueWithConsumerIndex.drop();
                    }
                    if (simpleQueueWithConsumerIndex.consumerIndex() == this.sourceCount) {
                        subscriber.onComplete();
                        return;
                    }
                }
                this.consumed = j;
                i = addAndGet(-i);
            } while (i != 0);
        }

        /* access modifiers changed from: package-private */
        public final void drainFused() {
            Subscriber<? super T> subscriber = this.downstream;
            SimpleQueueWithConsumerIndex<Object> simpleQueueWithConsumerIndex = this.queue;
            int i = 1;
            while (!this.cancelled) {
                Throwable th = (Throwable) this.error.get();
                if (th != null) {
                    simpleQueueWithConsumerIndex.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z = simpleQueueWithConsumerIndex.producerIndex() == this.sourceCount;
                if (!simpleQueueWithConsumerIndex.isEmpty()) {
                    subscriber.onNext(null);
                }
                if (z) {
                    subscriber.onComplete();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
            simpleQueueWithConsumerIndex.clear();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                if (this.outputFused) {
                    drainFused();
                } else {
                    drainNormal();
                }
            }
        }
    }

    static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        int consumerIndex;
        final AtomicInteger producerIndex = new AtomicInteger();

        MpscFillOnceSimpleQueue(int i) {
            super(i);
        }

        public final boolean offer(T t) {
            ObjectHelper.requireNonNull(t, "value is null");
            int andIncrement = this.producerIndex.getAndIncrement();
            if (andIncrement >= length()) {
                return false;
            }
            lazySet(andIncrement, t);
            return true;
        }

        public final boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public final T poll() {
            int i = this.consumerIndex;
            if (i == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.producerIndex;
            do {
                T t = get(i);
                if (t != null) {
                    this.consumerIndex = i + 1;
                    lazySet(i, null);
                    return t;
                }
            } while (atomicInteger.get() != i);
            return null;
        }

        public final T peek() {
            int i = this.consumerIndex;
            if (i == length()) {
                return null;
            }
            return get(i);
        }

        public final void drop() {
            int i = this.consumerIndex;
            lazySet(i, null);
            this.consumerIndex = i + 1;
        }

        public final boolean isEmpty() {
            return this.consumerIndex == producerIndex();
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
        public final void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        public final int consumerIndex() {
            return this.consumerIndex;
        }

        public final int producerIndex() {
            return this.producerIndex.get();
        }
    }

    static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        int consumerIndex;
        final AtomicInteger producerIndex = new AtomicInteger();

        ClqSimpleQueue() {
        }

        public final boolean offer(T t, T t2) {
            throw new UnsupportedOperationException();
        }

        public final boolean offer(T t) {
            this.producerIndex.getAndIncrement();
            return super.offer(t);
        }

        @Nullable
        public final T poll() {
            T poll = super.poll();
            if (poll != null) {
                this.consumerIndex++;
            }
            return poll;
        }

        public final int consumerIndex() {
            return this.consumerIndex;
        }

        public final int producerIndex() {
            return this.producerIndex.get();
        }

        public final void drop() {
            poll();
        }
    }
}
