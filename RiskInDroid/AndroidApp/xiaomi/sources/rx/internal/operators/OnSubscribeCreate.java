package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeCreate<T> implements Observable.OnSubscribe<T> {
    final Action1<Emitter<T>> Emitter;
    final Emitter.BackpressureMode backpressure;

    public OnSubscribeCreate(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        this.Emitter = action1;
        this.backpressure = backpressureMode;
    }

    /* renamed from: rx.internal.operators.OnSubscribeCreate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$rx$Emitter$BackpressureMode = new int[Emitter.BackpressureMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.NONE.ordinal()] = 1;
            $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.ERROR.ordinal()] = 2;
            $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.DROP.ordinal()] = 3;
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void call(Subscriber<? super T> subscriber) {
        BaseEmitter baseEmitter;
        int i = AnonymousClass1.$SwitchMap$rx$Emitter$BackpressureMode[this.backpressure.ordinal()];
        if (i == 1) {
            baseEmitter = new NoneEmitter(subscriber);
        } else if (i == 2) {
            baseEmitter = new ErrorEmitter(subscriber);
        } else if (i == 3) {
            baseEmitter = new DropEmitter(subscriber);
        } else if (i != 4) {
            baseEmitter = new BufferEmitter(subscriber, RxRingBuffer.SIZE);
        } else {
            baseEmitter = new LatestEmitter(subscriber);
        }
        subscriber.add(baseEmitter);
        subscriber.setProducer(baseEmitter);
        this.Emitter.call(baseEmitter);
    }

    static abstract class BaseEmitter<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> actual;
        final SerialSubscription serial = new SerialSubscription();

        /* access modifiers changed from: package-private */
        public void onRequested() {
        }

        /* access modifiers changed from: package-private */
        public void onUnsubscribed() {
        }

        public BaseEmitter(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public void onCompleted() {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onCompleted();
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        public void onError(Throwable th) {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onError(th);
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        public final void unsubscribe() {
            this.serial.unsubscribe();
            onUnsubscribed();
        }

        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        public final void request(long j) {
            if (BackpressureUtils.validate(j)) {
                BackpressureUtils.getAndAddRequest(this, j);
                onRequested();
            }
        }

        public final void setSubscription(Subscription subscription) {
            this.serial.set(subscription);
        }

        public final void setCancellation(Cancellable cancellable) {
            setSubscription(new CancellableSubscription(cancellable));
        }

        public final long requested() {
            return get();
        }
    }

    static final class NoneEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public NoneEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void onNext(T t) {
            long j;
            if (!this.actual.isUnsubscribed()) {
                this.actual.onNext(t);
                do {
                    j = get();
                    if (j == 0) {
                        return;
                    }
                } while (!compareAndSet(j, j - 1));
            }
        }
    }

    static abstract class NoOverflowBaseEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        /* access modifiers changed from: package-private */
        public abstract void onOverflow();

        public NoOverflowBaseEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t) {
            if (!this.actual.isUnsubscribed()) {
                if (get() != 0) {
                    this.actual.onNext(t);
                    BackpressureUtils.produced(this, 1);
                    return;
                }
                onOverflow();
            }
        }
    }

    static final class DropEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        /* access modifiers changed from: package-private */
        public final void onOverflow() {
        }

        public DropEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }
    }

    static final class ErrorEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;
        private boolean done;

        public ErrorEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void onNext(T t) {
            if (!this.done) {
                super.onNext(t);
            }
        }

        public final void onCompleted() {
            if (!this.done) {
                this.done = true;
                super.onCompleted();
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.done = true;
            super.onError(th);
        }

        /* access modifiers changed from: package-private */
        public final void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    static final class BufferEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final Queue<Object> queue;
        final AtomicInteger wip;

        public BufferEmitter(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(i) : new SpscUnboundedAtomicArrayQueue<>(i);
            this.wip = new AtomicInteger();
        }

        public final void onNext(T t) {
            this.queue.offer(NotificationLite.next(t));
            drain();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void onRequested() {
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (this.wip.getAndIncrement() == 0) {
                Subscriber subscriber = this.actual;
                Queue<Object> queue2 = this.queue;
                int i = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (subscriber.isUnsubscribed()) {
                            queue2.clear();
                            return;
                        }
                        boolean z = this.done;
                        Object poll = queue2.poll();
                        boolean z2 = poll == null;
                        if (!z || !z2) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(NotificationLite.getValue(poll));
                            j2++;
                        } else {
                            Throwable th = this.error;
                            if (th != null) {
                                super.onError(th);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 == j) {
                        if (subscriber.isUnsubscribed()) {
                            queue2.clear();
                            return;
                        }
                        boolean z3 = this.done;
                        boolean isEmpty = queue2.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        BackpressureUtils.produced(this, j2);
                    }
                    i = this.wip.addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    static final class LatestEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<Object> queue = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        public LatestEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public final void onNext(T t) {
            this.queue.set(NotificationLite.next(t));
            drain();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onCompleted() {
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void onRequested() {
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            boolean z;
            if (this.wip.getAndIncrement() == 0) {
                Subscriber subscriber = this.actual;
                AtomicReference<Object> atomicReference = this.queue;
                int i = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (true) {
                        z = false;
                        if (j2 == j) {
                            break;
                        } else if (subscriber.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        } else {
                            boolean z2 = this.done;
                            Object andSet = atomicReference.getAndSet(null);
                            boolean z3 = andSet == null;
                            if (!z2 || !z3) {
                                if (z3) {
                                    break;
                                }
                                subscriber.onNext(NotificationLite.getValue(andSet));
                                j2++;
                            } else {
                                Throwable th = this.error;
                                if (th != null) {
                                    super.onError(th);
                                    return;
                                } else {
                                    super.onCompleted();
                                    return;
                                }
                            }
                        }
                    }
                    if (j2 == j) {
                        if (subscriber.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z4 = this.done;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (z4 && z) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                super.onError(th2);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        BackpressureUtils.produced(this, j2);
                    }
                    i = this.wip.addAndGet(-i);
                } while (i != 0);
            }
        }
    }
}
