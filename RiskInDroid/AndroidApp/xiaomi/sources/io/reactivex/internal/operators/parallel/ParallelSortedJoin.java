package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelSortedJoin<T> extends Flowable<T> {
    final Comparator<? super T> comparator;
    final ParallelFlowable<List<T>> source;

    public ParallelSortedJoin(ParallelFlowable<List<T>> parallelFlowable, Comparator<? super T> comparator2) {
        this.source = parallelFlowable;
        this.comparator = comparator2;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.source.parallelism(), this.comparator);
        subscriber.onSubscribe(sortedJoinSubscription);
        this.source.subscribe(sortedJoinSubscription.subscribers);
    }

    static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;
        volatile boolean cancelled;
        final Comparator<? super T> comparator;
        final Subscriber<? super T> downstream;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final int[] indexes;
        final List<T>[] lists;
        final AtomicInteger remaining = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();
        final SortedJoinInnerSubscriber<T>[] subscribers;

        SortedJoinSubscription(Subscriber<? super T> subscriber, int i, Comparator<? super T> comparator2) {
            this.downstream = subscriber;
            this.comparator = comparator2;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                sortedJoinInnerSubscriberArr[i2] = new SortedJoinInnerSubscriber<>(this, i2);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new List[i];
            this.indexes = new int[i];
            this.remaining.lazySet(i);
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                if (this.remaining.get() == 0) {
                    drain();
                }
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    Arrays.fill(this.lists, (Object) null);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void cancelAll() {
            for (SortedJoinInnerSubscriber<T> cancel : this.subscribers) {
                cancel.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerNext(List<T> list, int i) {
            this.lists[i] = list;
            if (this.remaining.decrementAndGet() == 0) {
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                drain();
            } else if (th != this.error.get()) {
                RxJavaPlugins.onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            boolean z;
            T t;
            if (getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.downstream;
                List<T>[] listArr = this.lists;
                int[] iArr = this.indexes;
                int length = iArr.length;
                int i = 1;
                while (true) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.cancelled) {
                            Arrays.fill(listArr, (Object) null);
                            return;
                        }
                        Throwable th = this.error.get();
                        if (th != null) {
                            cancelAll();
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onError(th);
                            return;
                        }
                        T t2 = null;
                        int i2 = -1;
                        for (int i3 = 0; i3 < length; i3++) {
                            List<T> list = listArr[i3];
                            int i4 = iArr[i3];
                            if (list.size() != i4) {
                                if (t2 == null) {
                                    t = list.get(i4);
                                } else {
                                    t = list.get(i4);
                                    try {
                                        if (!(this.comparator.compare(t2, t) > 0)) {
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        cancelAll();
                                        Arrays.fill(listArr, (Object) null);
                                        if (!this.error.compareAndSet(null, th2)) {
                                            RxJavaPlugins.onError(th2);
                                        }
                                        subscriber.onError(this.error.get());
                                        return;
                                    }
                                }
                                t2 = t;
                                i2 = i3;
                            }
                        }
                        if (t2 == null) {
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onComplete();
                            return;
                        }
                        subscriber.onNext(t2);
                        iArr[i2] = iArr[i2] + 1;
                        j2++;
                    }
                    if (j2 == j) {
                        if (this.cancelled) {
                            Arrays.fill(listArr, (Object) null);
                            return;
                        }
                        Throwable th3 = this.error.get();
                        if (th3 != null) {
                            cancelAll();
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onError(th3);
                            return;
                        }
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                z = true;
                                break;
                            } else if (iArr[i5] != listArr[i5].size()) {
                                z = false;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        if (z) {
                            Arrays.fill(listArr, (Object) null);
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                        this.requested.addAndGet(-j2);
                    }
                    int i6 = get();
                    if (i6 != i || (i6 = addAndGet(-i)) != 0) {
                        i = i6;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        final int index;
        final SortedJoinSubscription<T> parent;

        public final void onComplete() {
        }

        SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i) {
            this.parent = sortedJoinSubscription;
            this.index = i;
        }

        public final void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }

        public final void onNext(List<T> list) {
            this.parent.innerNext(list, this.index);
        }

        public final void onError(Throwable th) {
            this.parent.innerError(th);
        }

        /* access modifiers changed from: package-private */
        public final void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }
}
