package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OperatorScan<R, T> implements Observable.Operator<R, T> {
    private static final Object NO_INITIAL_VALUE = new Object();
    final Func2<R, ? super T, R> accumulator;
    private final Func0<R> initialValueFactory;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: rx.internal.operators.OperatorScan.<init>(rx.functions.Func0, rx.functions.Func2):void
     arg types: [rx.internal.operators.OperatorScan$1, rx.functions.Func2]
     candidates:
      rx.internal.operators.OperatorScan.<init>(java.lang.Object, rx.functions.Func2):void
      rx.internal.operators.OperatorScan.<init>(rx.functions.Func0, rx.functions.Func2):void */
    public OperatorScan(final Object obj, Func2 func2) {
        this((Func0) new Func0<R>() {
            /* class rx.internal.operators.OperatorScan.AnonymousClass1 */

            public R call() {
                return obj;
            }
        }, func2);
    }

    public OperatorScan(Func0 func0, Func2 func2) {
        this.initialValueFactory = func0;
        this.accumulator = func2;
    }

    public OperatorScan(Func2<R, ? super T, R> func2) {
        this(NO_INITIAL_VALUE, func2);
    }

    public final Subscriber<? super T> call(final Subscriber<? super R> subscriber) {
        final R call = this.initialValueFactory.call();
        if (call == NO_INITIAL_VALUE) {
            return new Subscriber<T>(subscriber) {
                /* class rx.internal.operators.OperatorScan.AnonymousClass2 */
                boolean once;
                R value;

                /* JADX INFO: additional move instructions added (1) to help type inference */
                public void onNext(T t) {
                    Object obj;
                    if (!this.once) {
                        this.once = true;
                        obj = t;
                    } else {
                        try {
                            obj = OperatorScan.this.accumulator.call(this.value, t);
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, subscriber, t);
                            return;
                        }
                    }
                    this.value = obj;
                    subscriber.onNext(obj);
                }

                public void onError(Throwable th) {
                    subscriber.onError(th);
                }

                public void onCompleted() {
                    subscriber.onCompleted();
                }
            };
        }
        final InitialProducer initialProducer = new InitialProducer(call, subscriber);
        AnonymousClass3 r2 = new Subscriber<T>() {
            /* class rx.internal.operators.OperatorScan.AnonymousClass3 */
            private R value = call;

            public void onNext(T t) {
                try {
                    R call = OperatorScan.this.accumulator.call(this.value, t);
                    this.value = call;
                    initialProducer.onNext(call);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this, t);
                }
            }

            public void onError(Throwable th) {
                initialProducer.onError(th);
            }

            public void onCompleted() {
                initialProducer.onCompleted();
            }

            public void setProducer(Producer producer) {
                initialProducer.setProducer(producer);
            }
        };
        subscriber.add(r2);
        subscriber.setProducer(initialProducer);
        return r2;
    }

    static final class InitialProducer<R> implements Observer<R>, Producer {
        final Subscriber<? super R> child;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        long missedRequested;
        volatile Producer producer;
        final Queue<Object> queue;
        final AtomicLong requested;

        public InitialProducer(R r, Subscriber<? super R> subscriber) {
            Queue<Object> queue2;
            this.child = subscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue2 = new SpscLinkedQueue<>();
            } else {
                queue2 = new SpscLinkedAtomicQueue<>();
            }
            this.queue = queue2;
            queue2.offer(NotificationLite.next(r));
            this.requested = new AtomicLong();
        }

        public final void onNext(R r) {
            this.queue.offer(NotificationLite.next(r));
            emit();
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, Subscriber<? super R> subscriber) {
            if (subscriber.isUnsubscribed()) {
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
                return true;
            } else if (!z2) {
                return false;
            } else {
                subscriber.onCompleted();
                return true;
            }
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            emit();
        }

        public final void onCompleted() {
            this.done = true;
            emit();
        }

        public final void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was ".concat(String.valueOf(j)));
            } else if (j != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                Producer producer2 = this.producer;
                if (producer2 == null) {
                    synchronized (this.requested) {
                        producer2 = this.producer;
                        if (producer2 == null) {
                            this.missedRequested = BackpressureUtils.addCap(this.missedRequested, j);
                        }
                    }
                }
                if (producer2 != null) {
                    producer2.request(j);
                }
                emit();
            }
        }

        public final void setProducer(Producer producer2) {
            long j;
            if (producer2 != null) {
                synchronized (this.requested) {
                    if (this.producer == null) {
                        j = this.missedRequested;
                        if (j != Long.MAX_VALUE) {
                            j--;
                        }
                        this.missedRequested = 0;
                        this.producer = producer2;
                    } else {
                        throw new IllegalStateException("Can't set more than one Producer!");
                    }
                }
                if (j > 0) {
                    producer2.request(j);
                }
                emit();
                return;
            }
            throw new NullPointerException();
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
        public final void emitLoop() {
            Subscriber<? super R> subscriber = this.child;
            Queue<Object> queue2 = this.queue;
            AtomicLong atomicLong = this.requested;
            long j = atomicLong.get();
            while (!checkTerminated(this.done, queue2.isEmpty(), subscriber)) {
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.done;
                    Object poll = queue2.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, subscriber)) {
                        if (z2) {
                            break;
                        }
                        Object value = NotificationLite.getValue(poll);
                        try {
                            subscriber.onNext(value);
                            j2++;
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, subscriber, value);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                    j = BackpressureUtils.produced(atomicLong, j2);
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                }
            }
        }
    }
}
