package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayErrors;
    final int maxConcurrent;

    static final class HolderNoDelay {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);

        HolderNoDelay() {
        }
    }

    static final class HolderDelayErrors {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);

        HolderDelayErrors() {
        }
    }

    public static <T> OperatorMerge<T> instance(boolean z) {
        if (z) {
            return HolderDelayErrors.INSTANCE;
        }
        return HolderNoDelay.INSTANCE;
    }

    public static <T> OperatorMerge<T> instance(boolean z, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxConcurrent > 0 required but it was ".concat(String.valueOf(i)));
        } else if (i == Integer.MAX_VALUE) {
            return instance(z);
        } else {
            return new OperatorMerge<>(z, i);
        }
    }

    OperatorMerge(boolean z, int i) {
        this.delayErrors = z;
        this.maxConcurrent = i;
    }

    public final Subscriber<Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        MergeSubscriber mergeSubscriber = new MergeSubscriber(subscriber, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> mergeProducer = new MergeProducer<>(mergeSubscriber);
        mergeSubscriber.producer = mergeProducer;
        subscriber.add(mergeSubscriber);
        subscriber.setProducer(mergeProducer);
        return mergeSubscriber;
    }

    static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.subscriber = mergeSubscriber;
        }

        public final void request(long j) {
            if (j > 0) {
                if (get() != Long.MAX_VALUE) {
                    BackpressureUtils.getAndAddRequest(this, j);
                    this.subscriber.emit();
                }
            } else if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        public final long produced(int i) {
            return addAndGet((long) (-i));
        }
    }

    static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        final Subscriber<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        volatile ConcurrentLinkedQueue<Throwable> errors;
        final Object innerGuard = new Object();
        volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;
        long lastId;
        int lastIndex;
        final int maxConcurrent;
        boolean missed;
        MergeProducer<T> producer;
        volatile Queue<Object> queue;
        int scalarEmissionCount;
        final int scalarEmissionLimit;
        volatile CompositeSubscription subscriptions;
        long uniqueId;

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z, int i) {
            this.child = subscriber;
            this.delayErrors = z;
            this.maxConcurrent = i;
            if (i == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
                return;
            }
            this.scalarEmissionLimit = Math.max(1, i >> 1);
            request((long) i);
        }

        /* access modifiers changed from: package-private */
        public final Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.errors;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.errors = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* access modifiers changed from: package-private */
        public final CompositeSubscription getOrCreateComposite() {
            CompositeSubscription compositeSubscription;
            CompositeSubscription compositeSubscription2 = this.subscriptions;
            if (compositeSubscription2 != null) {
                return compositeSubscription2;
            }
            boolean z = false;
            synchronized (this) {
                compositeSubscription = this.subscriptions;
                if (compositeSubscription == null) {
                    CompositeSubscription compositeSubscription3 = new CompositeSubscription();
                    this.subscriptions = compositeSubscription3;
                    compositeSubscription = compositeSubscription3;
                    z = true;
                }
            }
            if (z) {
                add(compositeSubscription);
            }
            return compositeSubscription;
        }

        public final void onNext(Observable<? extends T> observable) {
            if (observable != null) {
                if (observable == Observable.empty()) {
                    emitEmpty();
                } else if (observable instanceof ScalarSynchronousObservable) {
                    tryEmit(((ScalarSynchronousObservable) observable).get());
                } else {
                    long j = this.uniqueId;
                    this.uniqueId = 1 + j;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
                    addInner(innerSubscriber);
                    observable.unsafeSubscribe(innerSubscriber);
                    emit();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void emitEmpty() {
            int i = this.scalarEmissionCount + 1;
            if (i == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore((long) i);
                return;
            }
            this.scalarEmissionCount = i;
        }

        private void reportError() {
            ArrayList arrayList = new ArrayList(this.errors);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException(arrayList));
            }
        }

        public final void onError(Throwable th) {
            getOrCreateErrorQueue().offer(th);
            this.done = true;
            emit();
        }

        public final void onCompleted() {
            this.done = true;
            emit();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: rx.internal.operators.OperatorMerge$InnerSubscriber<?>[]} */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Multi-variable type inference failed */
        public final void addInner(InnerSubscriber<T> innerSubscriber) {
            getOrCreateComposite().add(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[(length + 1)];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        /* access modifiers changed from: package-private */
        public final void removeInner(InnerSubscriber<T> innerSubscriber) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer != null) {
                rxRingBuffer.release();
            }
            this.subscriptions.remove(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerSubscriber.equals(innerSubscriberArr[i2])) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        this.innerSubscribers = EMPTY;
                        return;
                    }
                    InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[(length - 1)];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i);
                    System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr2, i, (length - i) - 1);
                    this.innerSubscribers = innerSubscriberArr2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void tryEmit(InnerSubscriber<T> innerSubscriber, T t) {
            long j;
            boolean z = false;
            if (this.producer.get() != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            } else {
                j = 0;
            }
            if (z) {
                RxRingBuffer rxRingBuffer = innerSubscriber.queue;
                if (rxRingBuffer == null || rxRingBuffer.isEmpty()) {
                    emitScalar(innerSubscriber, t, j);
                    return;
                }
                queueScalar(innerSubscriber, t);
                emitLoop();
                return;
            }
            queueScalar(innerSubscriber, t);
            emit();
        }

        /* access modifiers changed from: protected */
        public final void queueScalar(InnerSubscriber<T> innerSubscriber, T t) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer == null) {
                rxRingBuffer = RxRingBuffer.getSpscInstance();
                innerSubscriber.add(rxRingBuffer);
                innerSubscriber.queue = rxRingBuffer;
            }
            try {
                rxRingBuffer.onNext(NotificationLite.next(t));
            } catch (MissingBackpressureException e) {
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e);
            } catch (IllegalStateException e2) {
                if (!innerSubscriber.isUnsubscribed()) {
                    innerSubscriber.unsubscribe();
                    innerSubscriber.onError(e2);
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void emitScalar(InnerSubscriber<T> innerSubscriber, T t, long j) {
            boolean z = true;
            try {
                this.child.onNext(t);
            } catch (Throwable th) {
                th = th;
            }
            if (j != Long.MAX_VALUE) {
                this.producer.produced(1);
            }
            innerSubscriber.requestMore(1);
            synchronized (this) {
                if (!this.missed) {
                    this.emitting = false;
                    return;
                }
                this.missed = false;
                emitLoop();
                return;
            }
            if (!z) {
                synchronized (this) {
                    this.emitting = false;
                }
            }
            throw th;
        }

        public final void requestMore(long j) {
            request(j);
        }

        /* access modifiers changed from: package-private */
        public final void tryEmit(T t) {
            long j;
            boolean z = false;
            if (this.producer.get() != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            } else {
                j = 0;
            }
            if (z) {
                Queue<Object> queue2 = this.queue;
                if (queue2 == null || queue2.isEmpty()) {
                    emitScalar(t, j);
                    return;
                }
                queueScalar(t);
                emitLoop();
                return;
            }
            queueScalar(t);
            emit();
        }

        /* access modifiers changed from: protected */
        public final void queueScalar(T t) {
            Queue<Object> queue2;
            Queue<Object> queue3 = this.queue;
            if (queue3 == null) {
                int i = this.maxConcurrent;
                if (i == Integer.MAX_VALUE) {
                    queue3 = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.SIZE);
                } else {
                    if (!Pow2.isPowerOfTwo(i)) {
                        queue2 = new SpscExactAtomicArrayQueue<>(i);
                    } else if (UnsafeAccess.isUnsafeAvailable()) {
                        queue2 = new SpscArrayQueue<>(i);
                    } else {
                        queue2 = new SpscAtomicArrayQueue<>(i);
                    }
                    queue3 = queue2;
                }
                this.queue = queue3;
            }
            if (!queue3.offer(NotificationLite.next(t))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
            }
        }

        /* access modifiers changed from: protected */
        public final void emitScalar(T t, long j) {
            boolean z = true;
            try {
                this.child.onNext(t);
            } catch (Throwable th) {
                th = th;
            }
            if (j != Long.MAX_VALUE) {
                this.producer.produced(1);
            }
            int i = this.scalarEmissionCount + 1;
            if (i == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore((long) i);
            } else {
                this.scalarEmissionCount = i;
            }
            synchronized (this) {
                if (!this.missed) {
                    this.emitting = false;
                    return;
                }
                this.missed = false;
                emitLoop();
                return;
            }
            if (!z) {
                synchronized (this) {
                    this.emitting = false;
                }
            }
            throw th;
        }

        /* access modifiers changed from: package-private */
        public final void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                emitLoop();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x01be, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x01bf, code lost:
            r21 = r2;
         */
        /* JADX WARNING: Removed duplicated region for block: B:177:0x01cc  */
        /* JADX WARNING: Removed duplicated region for block: B:208:0x018f A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x00f6 A[Catch:{ Throwable -> 0x0043, all -> 0x01c7, all -> 0x0056 }] */
        public final void emitLoop() {
            boolean z;
            Subscriber<? super T> subscriber;
            int i;
            Subscriber<? super T> subscriber2;
            boolean z2;
            int i2;
            boolean z3;
            Subscriber<? super T> subscriber3;
            int i3;
            long j;
            try {
                subscriber = this.child;
                while (!checkTerminate()) {
                    Queue<Object> queue2 = this.queue;
                    long j2 = this.producer.get();
                    boolean z4 = j2 == Long.MAX_VALUE;
                    long j3 = 0;
                    if (queue2 != null) {
                        int i4 = 0;
                        while (true) {
                            i = i4;
                            Object obj = null;
                            int i5 = 0;
                            while (true) {
                                if (j2 <= 0) {
                                    break;
                                }
                                Object poll = queue2.poll();
                                if (!checkTerminate()) {
                                    if (poll == null) {
                                        obj = poll;
                                        break;
                                    }
                                    subscriber.onNext(NotificationLite.getValue(poll));
                                    i++;
                                    i5++;
                                    j2--;
                                    obj = poll;
                                } else {
                                    return;
                                }
                            }
                            if (i5 > 0) {
                                if (z4) {
                                    j2 = Long.MAX_VALUE;
                                } else {
                                    j2 = this.producer.produced(i5);
                                }
                            }
                            if (j2 == 0) {
                                break;
                            } else if (obj == null) {
                                break;
                            } else {
                                i4 = i;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    boolean z5 = this.done;
                    Queue<Object> queue3 = this.queue;
                    InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                    int length = innerSubscriberArr.length;
                    if (!z5 || ((queue3 != null && !queue3.isEmpty()) || length != 0)) {
                        if (length > 0) {
                            long j4 = this.lastId;
                            int i6 = this.lastIndex;
                            if (length > i6) {
                                subscriber3 = subscriber;
                                if (innerSubscriberArr[i6].id != j4) {
                                }
                                int i7 = i6;
                                i3 = 0;
                                z2 = false;
                                while (true) {
                                    if (i3 >= length) {
                                        if (!checkTerminate()) {
                                            InnerSubscriber<?> innerSubscriber = innerSubscriberArr[i7];
                                            j = j2;
                                            Object obj2 = null;
                                            while (true) {
                                                int i8 = 0;
                                                while (j > j3) {
                                                    if (!checkTerminate()) {
                                                        RxRingBuffer rxRingBuffer = innerSubscriber.queue;
                                                        if (rxRingBuffer == null || (obj2 = rxRingBuffer.poll()) == null) {
                                                            break;
                                                        }
                                                        Subscriber<? super T> subscriber4 = subscriber3;
                                                        try {
                                                            subscriber4.onNext(NotificationLite.getValue(obj2));
                                                            j--;
                                                            i8++;
                                                            subscriber3 = subscriber4;
                                                        } catch (Throwable th) {
                                                            Throwable th2 = th;
                                                            unsubscribe();
                                                            throw th2;
                                                        }
                                                    } else {
                                                        return;
                                                    }
                                                }
                                                subscriber2 = subscriber3;
                                                if (i8 > 0) {
                                                    j = !z4 ? this.producer.produced(i8) : Long.MAX_VALUE;
                                                    innerSubscriber.requestMore((long) i8);
                                                    j3 = 0;
                                                }
                                                if (j == j3) {
                                                    break;
                                                } else if (obj2 == null) {
                                                    break;
                                                } else {
                                                    subscriber3 = subscriber2;
                                                    j3 = 0;
                                                }
                                            }
                                            boolean z6 = innerSubscriber.done;
                                            RxRingBuffer rxRingBuffer2 = innerSubscriber.queue;
                                            if (z6 && (rxRingBuffer2 == null || rxRingBuffer2.isEmpty())) {
                                                removeInner(innerSubscriber);
                                                if (!checkTerminate()) {
                                                    i++;
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                            if (j == 0) {
                                                break;
                                            }
                                            i7++;
                                            if (i7 == length) {
                                                i7 = 0;
                                            }
                                            i3++;
                                            j3 = 0;
                                            j2 = j;
                                            subscriber3 = subscriber2;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        subscriber2 = subscriber3;
                                        break;
                                    }
                                }
                                this.lastIndex = i7;
                                this.lastId = innerSubscriberArr[i7].id;
                                i2 = i;
                            } else {
                                subscriber3 = subscriber;
                            }
                            if (length <= i6) {
                                i6 = 0;
                            }
                            int i9 = i6;
                            for (int i10 = 0; i10 < length && innerSubscriberArr[i9].id != j4; i10++) {
                                int i11 = i9 + 1;
                                i9 = i11 == length ? 0 : i11;
                            }
                            this.lastIndex = i9;
                            this.lastId = innerSubscriberArr[i9].id;
                            i6 = i9;
                            int i72 = i6;
                            i3 = 0;
                            z2 = false;
                            while (true) {
                                if (i3 >= length) {
                                }
                                i3++;
                                j3 = 0;
                                j2 = j;
                                subscriber3 = subscriber2;
                            }
                            this.lastIndex = i72;
                            this.lastId = innerSubscriberArr[i72].id;
                            i2 = i;
                        } else {
                            subscriber2 = subscriber;
                            i2 = i;
                            z2 = false;
                        }
                        if (i2 > 0) {
                            request((long) i2);
                        }
                        if (!z2) {
                            synchronized (this) {
                                try {
                                    if (!this.missed) {
                                        try {
                                            this.emitting = false;
                                            return;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            z3 = true;
                                            while (true) {
                                                try {
                                                    break;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                }
                                            }
                                            throw th;
                                        }
                                    } else {
                                        this.missed = false;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    z3 = false;
                                    while (true) {
                                        break;
                                    }
                                    throw th;
                                }
                            }
                        }
                        subscriber = subscriber2;
                    } else {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
                        if (concurrentLinkedQueue != null) {
                            if (!concurrentLinkedQueue.isEmpty()) {
                                reportError();
                                return;
                            }
                        }
                        subscriber.onCompleted();
                        return;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                z = true;
                if (!z) {
                }
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (this.delayErrors || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                reportError();
                return true;
            } finally {
                unsubscribe();
            }
        }
    }

    static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int LIMIT = (RxRingBuffer.SIZE / 4);
        volatile boolean done;
        final long id;
        int outstanding;
        final MergeSubscriber<T> parent;
        volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, long j) {
            this.parent = mergeSubscriber;
            this.id = j;
        }

        public final void onStart() {
            this.outstanding = RxRingBuffer.SIZE;
            request((long) RxRingBuffer.SIZE);
        }

        public final void onNext(T t) {
            this.parent.tryEmit(this, t);
        }

        public final void onError(Throwable th) {
            this.done = true;
            this.parent.getOrCreateErrorQueue().offer(th);
            this.parent.emit();
        }

        public final void onCompleted() {
            this.done = true;
            this.parent.emit();
        }

        public final void requestMore(long j) {
            int i = this.outstanding - ((int) j);
            if (i > LIMIT) {
                this.outstanding = i;
                return;
            }
            this.outstanding = RxRingBuffer.SIZE;
            int i2 = RxRingBuffer.SIZE - i;
            if (i2 > 0) {
                request((long) i2);
            }
        }
    }
}
