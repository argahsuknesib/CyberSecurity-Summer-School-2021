package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.BackpressureOverflow;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.BackpressureDrainManager;

public class OperatorOnBackpressureBuffer<T> implements Observable.Operator<T, T> {
    private final Long capacity;
    private final Action0 onOverflow;
    private final BackpressureOverflow.Strategy overflowStrategy;

    static final class Holder {
        static final OperatorOnBackpressureBuffer<?> INSTANCE = new OperatorOnBackpressureBuffer<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureBuffer<T> instance() {
        return Holder.INSTANCE;
    }

    OperatorOnBackpressureBuffer() {
        this.capacity = null;
        this.onOverflow = null;
        this.overflowStrategy = BackpressureOverflow.ON_OVERFLOW_DEFAULT;
    }

    public OperatorOnBackpressureBuffer(long j) {
        this(j, null, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
    }

    public OperatorOnBackpressureBuffer(long j, Action0 action0) {
        this(j, action0, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
    }

    public OperatorOnBackpressureBuffer(long j, Action0 action0, BackpressureOverflow.Strategy strategy) {
        if (j <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        } else if (strategy != null) {
            this.capacity = Long.valueOf(j);
            this.onOverflow = action0;
            this.overflowStrategy = strategy;
        } else {
            throw new NullPointerException("The BackpressureOverflow strategy must not be null");
        }
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        BufferSubscriber bufferSubscriber = new BufferSubscriber(subscriber, this.capacity, this.onOverflow, this.overflowStrategy);
        subscriber.add(bufferSubscriber);
        subscriber.setProducer(bufferSubscriber.manager());
        return bufferSubscriber;
    }

    static final class BufferSubscriber<T> extends Subscriber<T> implements BackpressureDrainManager.BackpressureQueueCallback {
        private final AtomicLong capacity;
        private final Subscriber<? super T> child;
        private final BackpressureDrainManager manager;
        private final Action0 onOverflow;
        private final BackpressureOverflow.Strategy overflowStrategy;
        private final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean saturated = new AtomicBoolean(false);

        public BufferSubscriber(Subscriber<? super T> subscriber, Long l, Action0 action0, BackpressureOverflow.Strategy strategy) {
            this.child = subscriber;
            this.capacity = l != null ? new AtomicLong(l.longValue()) : null;
            this.onOverflow = action0;
            this.manager = new BackpressureDrainManager(this);
            this.overflowStrategy = strategy;
        }

        public final void onStart() {
            request(Long.MAX_VALUE);
        }

        public final void onCompleted() {
            if (!this.saturated.get()) {
                this.manager.terminateAndDrain();
            }
        }

        public final void onError(Throwable th) {
            if (!this.saturated.get()) {
                this.manager.terminateAndDrain(th);
            }
        }

        public final void onNext(T t) {
            if (assertCapacity()) {
                this.queue.offer(NotificationLite.next(t));
                this.manager.drain();
            }
        }

        public final boolean accept(Object obj) {
            return NotificationLite.accept(this.child, obj);
        }

        public final void complete(Throwable th) {
            if (th != null) {
                this.child.onError(th);
            } else {
                this.child.onCompleted();
            }
        }

        public final Object peek() {
            return this.queue.peek();
        }

        public final Object poll() {
            Object poll = this.queue.poll();
            AtomicLong atomicLong = this.capacity;
            if (!(atomicLong == null || poll == null)) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[SYNTHETIC, Splitter:B:19:0x0039] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0049 A[SYNTHETIC] */
        private boolean assertCapacity() {
            long j;
            boolean z;
            Action0 action0;
            if (this.capacity == null) {
                return true;
            }
            do {
                j = this.capacity.get();
                if (j <= 0) {
                    try {
                        if (this.overflowStrategy.mayAttemptDrop() && poll() != null) {
                            z = true;
                            action0 = this.onOverflow;
                            if (action0 != null) {
                                try {
                                    action0.call();
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.manager.terminateAndDrain(th);
                                    return false;
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    } catch (MissingBackpressureException e) {
                        if (this.saturated.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e);
                        }
                    }
                    z = false;
                    action0 = this.onOverflow;
                    if (action0 != null) {
                    }
                    if (!z) {
                    }
                }
            } while (!this.capacity.compareAndSet(j, j - 1));
            return true;
        }

        /* access modifiers changed from: protected */
        public final Producer manager() {
            return this.manager;
        }
    }
}
