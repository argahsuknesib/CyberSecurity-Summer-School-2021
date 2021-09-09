package io.reactivex.processors;

import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ReplayProcessor<T> extends FlowableProcessor<T> {
    static final ReplaySubscription[] EMPTY = new ReplaySubscription[0];
    private static final Object[] EMPTY_ARRAY = new Object[0];
    static final ReplaySubscription[] TERMINATED = new ReplaySubscription[0];
    final ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ReplaySubscription<T>[]> subscribers = new AtomicReference<>(EMPTY);

    interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        Throwable getError();

        @Nullable
        T getValue();

        T[] getValues(T[] tArr);

        boolean isDone();

        void next(T t);

        void replay(ReplaySubscription<T> replaySubscription);

        int size();

        void trimHead();
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create() {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(16));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> create(int i) {
        return new ReplayProcessor<>(new UnboundedReplayBuffer(i));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithSize(int i) {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(i));
    }

    static <T> ReplayProcessor<T> createUnbounded() {
        return new ReplayProcessor<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j, timeUnit, scheduler));
    }

    @CheckReturnValue
    @NonNull
    public static <T> ReplayProcessor<T> createWithTimeAndSize(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return new ReplayProcessor<>(new SizeAndTimeBoundReplayBuffer(i, j, timeUnit, scheduler));
    }

    ReplayProcessor(ReplayBuffer<T> replayBuffer) {
        this.buffer = replayBuffer;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        ReplaySubscription replaySubscription = new ReplaySubscription(subscriber, this);
        subscriber.onSubscribe(replaySubscription);
        if (!add(replaySubscription) || !replaySubscription.cancelled) {
            this.buffer.replay(replaySubscription);
        } else {
            remove(replaySubscription);
        }
    }

    public final void onSubscribe(Subscription subscription) {
        if (this.done) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public final void onNext(T t) {
        ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.done) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.next(t);
            for (ReplaySubscription replay : (ReplaySubscription[]) this.subscribers.get()) {
                replayBuffer.replay(replay);
            }
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.done = true;
        ReplayBuffer<T> replayBuffer = this.buffer;
        replayBuffer.error(th);
        for (ReplaySubscription replay : (ReplaySubscription[]) this.subscribers.getAndSet(TERMINATED)) {
            replayBuffer.replay(replay);
        }
    }

    public final void onComplete() {
        if (!this.done) {
            this.done = true;
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.complete();
            for (ReplaySubscription replay : (ReplaySubscription[]) this.subscribers.getAndSet(TERMINATED)) {
                replayBuffer.replay(replay);
            }
        }
    }

    public final boolean hasSubscribers() {
        return ((ReplaySubscription[]) this.subscribers.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    public final int subscriberCount() {
        return ((ReplaySubscription[]) this.subscribers.get()).length;
    }

    @Nullable
    public final Throwable getThrowable() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        if (replayBuffer.isDone()) {
            return replayBuffer.getError();
        }
        return null;
    }

    public final void cleanupBuffer() {
        this.buffer.trimHead();
    }

    public final T getValue() {
        return this.buffer.getValue();
    }

    public final Object[] getValues() {
        Object[] values = getValues(EMPTY_ARRAY);
        return values == EMPTY_ARRAY ? new Object[0] : values;
    }

    public final T[] getValues(T[] tArr) {
        return this.buffer.getValues(tArr);
    }

    public final boolean hasComplete() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        return replayBuffer.isDone() && replayBuffer.getError() == null;
    }

    public final boolean hasThrowable() {
        ReplayBuffer<T> replayBuffer = this.buffer;
        return replayBuffer.isDone() && replayBuffer.getError() != null;
    }

    public final boolean hasValue() {
        return this.buffer.size() != 0;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.buffer.size();
    }

    /* access modifiers changed from: package-private */
    public final boolean add(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.subscribers.get();
            if (replaySubscriptionArr == TERMINATED) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[(length + 1)];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void remove(ReplaySubscription<T> replaySubscription) {
        ReplaySubscription<T>[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.subscribers.get();
            if (replaySubscriptionArr != TERMINATED && replaySubscriptionArr != EMPTY) {
                int length = replaySubscriptionArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (replaySubscriptionArr[i2] == replaySubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        replaySubscriptionArr2 = EMPTY;
                    } else {
                        ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[(length - 1)];
                        System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i);
                        System.arraycopy(replaySubscriptionArr, i + 1, replaySubscriptionArr3, i, (length - i) - 1);
                        replaySubscriptionArr2 = replaySubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(replaySubscriptionArr, replaySubscriptionArr2));
    }

    static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final ReplayProcessor<T> state;

        ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            this.downstream = subscriber;
            this.state = replayProcessor;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                BackpressureHelper.add(this.requested, j);
                this.state.buffer.replay(this);
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }
    }

    static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {
        final List<T> buffer;
        volatile boolean done;
        Throwable error;
        volatile int size;

        public final void trimHead() {
        }

        UnboundedReplayBuffer(int i) {
            this.buffer = new ArrayList(ObjectHelper.verifyPositive(i, "capacityHint"));
        }

        public final void next(T t) {
            this.buffer.add(t);
            this.size++;
        }

        public final void error(Throwable th) {
            this.error = th;
            this.done = true;
        }

        public final void complete() {
            this.done = true;
        }

        @Nullable
        public final T getValue() {
            int i = this.size;
            if (i == 0) {
                return null;
            }
            return this.buffer.get(i - 1);
        }

        public final T[] getValues(T[] tArr) {
            int i = this.size;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.buffer;
            if (tArr.length < i) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        public final void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() == 0) {
                List<T> list = this.buffer;
                Subscriber<? super T> subscriber = replaySubscription.downstream;
                Integer num = (Integer) replaySubscription.index;
                int i = 0;
                if (num != null) {
                    i = num.intValue();
                } else {
                    replaySubscription.index = 0;
                }
                long j = replaySubscription.emitted;
                int i2 = 1;
                do {
                    long j2 = replaySubscription.requested.get();
                    while (j != j2) {
                        if (replaySubscription.cancelled) {
                            replaySubscription.index = null;
                            return;
                        }
                        boolean z = this.done;
                        int i3 = this.size;
                        if (!z || i != i3) {
                            if (i == i3) {
                                break;
                            }
                            subscriber.onNext(list.get(i));
                            i++;
                            j++;
                        } else {
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            Throwable th = this.error;
                            if (th == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th);
                                return;
                            }
                        }
                    }
                    if (j == j2) {
                        if (replaySubscription.cancelled) {
                            replaySubscription.index = null;
                            return;
                        }
                        boolean z2 = this.done;
                        int i4 = this.size;
                        if (z2 && i == i4) {
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            Throwable th2 = this.error;
                            if (th2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    replaySubscription.index = Integer.valueOf(i);
                    replaySubscription.emitted = j;
                    i2 = replaySubscription.addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public final int size() {
            return this.size;
        }

        public final boolean isDone() {
            return this.done;
        }

        public final Throwable getError() {
            return this.error;
        }
    }

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        Node(T t) {
            this.value = t;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int maxSize;
        int size;
        Node<T> tail;

        SizeBoundReplayBuffer(int i) {
            this.maxSize = ObjectHelper.verifyPositive(i, "maxSize");
            Node<T> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        /* access modifiers changed from: package-private */
        public final void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = (Node) this.head.get();
            }
        }

        public final void next(T t) {
            Node<T> node = new Node<>(t);
            Node<T> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        public final void error(Throwable th) {
            this.error = th;
            trimHead();
            this.done = true;
        }

        public final void complete() {
            trimHead();
            this.done = true;
        }

        public final void trimHead() {
            if (this.head.value != null) {
                Node<T> node = new Node<>(null);
                node.lazySet(this.head.get());
                this.head = node;
            }
        }

        public final boolean isDone() {
            return this.done;
        }

        public final Throwable getError() {
            return this.error;
        }

        public final T getValue() {
            Node<T> node = this.head;
            while (true) {
                Node<T> node2 = (Node) node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        public final T[] getValues(T[] tArr) {
            Node<T> node = this.head;
            Node<T> node2 = node;
            int i = 0;
            while (true) {
                node2 = (Node) node2.get();
                if (node2 == null) {
                    break;
                }
                i++;
            }
            if (tArr.length < i) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            for (int i2 = 0; i2 < i; i2++) {
                node = (Node) node.get();
                tArr[i2] = node.value;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        public final void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replaySubscription.downstream;
                Node<T> node = (Node) replaySubscription.index;
                if (node == null) {
                    node = this.head;
                }
                long j = replaySubscription.emitted;
                int i = 1;
                do {
                    long j2 = replaySubscription.requested.get();
                    while (j != j2) {
                        if (replaySubscription.cancelled) {
                            replaySubscription.index = null;
                            return;
                        }
                        boolean z = this.done;
                        Node<T> node2 = (Node) node.get();
                        boolean z2 = node2 == null;
                        if (!z || !z2) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(node2.value);
                            j++;
                            node = node2;
                        } else {
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            Throwable th = this.error;
                            if (th == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th);
                                return;
                            }
                        }
                    }
                    if (j == j2) {
                        if (replaySubscription.cancelled) {
                            replaySubscription.index = null;
                            return;
                        } else if (this.done && node.get() == null) {
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            Throwable th2 = this.error;
                            if (th2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    replaySubscription.index = node;
                    replaySubscription.emitted = j;
                    i = replaySubscription.addAndGet(-i);
                } while (i != 0);
            }
        }

        public final int size() {
            Node<T> node = this.head;
            int i = 0;
            while (i != Integer.MAX_VALUE && (node = (Node) node.get()) != null) {
                i++;
            }
            return i;
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final long maxAge;
        final int maxSize;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;
        final TimeUnit unit;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler2) {
            this.maxSize = ObjectHelper.verifyPositive(i, "maxSize");
            this.maxAge = ObjectHelper.verifyPositive(j, "maxAge");
            this.unit = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
            this.scheduler = (Scheduler) ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
            TimedNode<T> timedNode = new TimedNode<>(null, 0);
            this.tail = timedNode;
            this.head = timedNode;
        }

        /* access modifiers changed from: package-private */
        public final void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = (TimedNode) this.head.get();
            }
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time > now) {
                    this.head = timedNode;
                    return;
                } else {
                    timedNode = timedNode2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void trimFinal() {
            long now = this.scheduler.now(this.unit) - this.maxAge;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    if (timedNode.value != null) {
                        this.head = new TimedNode<>(null, 0);
                        return;
                    } else {
                        this.head = timedNode;
                        return;
                    }
                } else if (timedNode2.time <= now) {
                    timedNode = timedNode2;
                } else if (timedNode.value != null) {
                    TimedNode<T> timedNode3 = new TimedNode<>(null, 0);
                    timedNode3.lazySet(timedNode.get());
                    this.head = timedNode3;
                    return;
                } else {
                    this.head = timedNode;
                    return;
                }
            }
        }

        public final void trimHead() {
            if (this.head.value != null) {
                TimedNode<T> timedNode = new TimedNode<>(null, 0);
                timedNode.lazySet(this.head.get());
                this.head = timedNode;
            }
        }

        public final void next(T t) {
            TimedNode<T> timedNode = new TimedNode<>(t, this.scheduler.now(this.unit));
            TimedNode<T> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        public final void error(Throwable th) {
            trimFinal();
            this.error = th;
            this.done = true;
        }

        public final void complete() {
            trimFinal();
            this.done = true;
        }

        @Nullable
        public final T getValue() {
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    break;
                }
                timedNode = timedNode2;
            }
            if (timedNode.time < this.scheduler.now(this.unit) - this.maxAge) {
                return null;
            }
            return timedNode.value;
        }

        public final T[] getValues(T[] tArr) {
            TimedNode head2 = getHead();
            int size2 = size(head2);
            if (size2 != 0) {
                if (tArr.length < size2) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size2);
                }
                for (int i = 0; i != size2; i++) {
                    head2 = (TimedNode) head2.get();
                    tArr[i] = head2.value;
                }
                if (tArr.length > size2) {
                    tArr[size2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        /* access modifiers changed from: package-private */
        public final TimedNode<T> getHead() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.head;
            long now = this.scheduler.now(this.unit) - this.maxAge;
            Object obj = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode3 = (TimedNode) obj;
                timedNode = timedNode2;
                timedNode2 = timedNode3;
                if (timedNode2 == null || timedNode2.time > now) {
                    return timedNode;
                }
                obj = timedNode2.get();
            }
            return timedNode;
        }

        public final void replay(ReplaySubscription<T> replaySubscription) {
            if (replaySubscription.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = replaySubscription.downstream;
                TimedNode timedNode = (TimedNode) replaySubscription.index;
                if (timedNode == null) {
                    timedNode = getHead();
                }
                long j = replaySubscription.emitted;
                int i = 1;
                do {
                    long j2 = replaySubscription.requested.get();
                    while (j != j2) {
                        if (replaySubscription.cancelled) {
                            replaySubscription.index = null;
                            return;
                        }
                        boolean z = this.done;
                        TimedNode timedNode2 = (TimedNode) timedNode.get();
                        boolean z2 = timedNode2 == null;
                        if (!z || !z2) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(timedNode2.value);
                            j++;
                            timedNode = timedNode2;
                        } else {
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            Throwable th = this.error;
                            if (th == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th);
                                return;
                            }
                        }
                    }
                    if (j == j2) {
                        if (replaySubscription.cancelled) {
                            replaySubscription.index = null;
                            return;
                        } else if (this.done && timedNode.get() == null) {
                            replaySubscription.index = null;
                            replaySubscription.cancelled = true;
                            Throwable th2 = this.error;
                            if (th2 == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onError(th2);
                                return;
                            }
                        }
                    }
                    replaySubscription.index = timedNode;
                    replaySubscription.emitted = j;
                    i = replaySubscription.addAndGet(-i);
                } while (i != 0);
            }
        }

        public final int size() {
            return size(getHead());
        }

        /* access modifiers changed from: package-private */
        public final int size(TimedNode<T> timedNode) {
            int i = 0;
            while (i != Integer.MAX_VALUE && (timedNode = (TimedNode) timedNode.get()) != null) {
                i++;
            }
            return i;
        }

        public final Throwable getError() {
            return this.error;
        }

        public final boolean isDone() {
            return this.done;
        }
    }
}
