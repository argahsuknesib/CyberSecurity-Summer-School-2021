package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.schedulers.ImmediateScheduler;
import rx.internal.schedulers.TrampolineScheduler;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

public final class OperatorObserveOn<T> implements Observable.Operator<T, T> {
    private final int bufferSize;
    private final boolean delayError;
    private final Scheduler scheduler;

    public OperatorObserveOn(Scheduler scheduler2, boolean z) {
        this(scheduler2, z, RxRingBuffer.SIZE);
    }

    public OperatorObserveOn(Scheduler scheduler2, boolean z, int i) {
        this.scheduler = scheduler2;
        this.delayError = z;
        this.bufferSize = i <= 0 ? RxRingBuffer.SIZE : i;
    }

    public final Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler scheduler2 = this.scheduler;
        if ((scheduler2 instanceof ImmediateScheduler) || (scheduler2 instanceof TrampolineScheduler)) {
            return subscriber;
        }
        ObserveOnSubscriber observeOnSubscriber = new ObserveOnSubscriber(scheduler2, subscriber, this.delayError, this.bufferSize);
        observeOnSubscriber.init();
        return observeOnSubscriber;
    }

    public static <T> Observable.Operator<T, T> rebatch(final int i) {
        return new Observable.Operator<T, T>() {
            /* class rx.internal.operators.OperatorObserveOn.AnonymousClass1 */

            public final Subscriber<? super T> call(Subscriber<? super T> subscriber) {
                ObserveOnSubscriber observeOnSubscriber = new ObserveOnSubscriber(Schedulers.immediate(), subscriber, false, i);
                observeOnSubscriber.init();
                return observeOnSubscriber;
            }
        };
    }

    static final class ObserveOnSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> child;
        final AtomicLong counter = new AtomicLong();
        final boolean delayError;
        long emitted;
        Throwable error;
        volatile boolean finished;
        final int limit;
        final Queue<Object> queue;
        final Scheduler.Worker recursiveScheduler;
        final AtomicLong requested = new AtomicLong();

        public ObserveOnSubscriber(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z, int i) {
            this.child = subscriber;
            this.recursiveScheduler = scheduler.createWorker();
            this.delayError = z;
            i = i <= 0 ? RxRingBuffer.SIZE : i;
            this.limit = i - (i >> 2);
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(i);
            } else {
                this.queue = new SpscAtomicArrayQueue(i);
            }
            request((long) i);
        }

        /* access modifiers changed from: package-private */
        public final void init() {
            Subscriber<? super T> subscriber = this.child;
            subscriber.setProducer(new Producer() {
                /* class rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber.AnonymousClass1 */

                public void request(long j) {
                    if (j > 0) {
                        BackpressureUtils.getAndAddRequest(ObserveOnSubscriber.this.requested, j);
                        ObserveOnSubscriber.this.schedule();
                    }
                }
            });
            subscriber.add(this.recursiveScheduler);
            subscriber.add(this);
        }

        public final void onNext(T t) {
            if (!isUnsubscribed() && !this.finished) {
                if (!this.queue.offer(NotificationLite.next(t))) {
                    onError(new MissingBackpressureException());
                } else {
                    schedule();
                }
            }
        }

        public final void onCompleted() {
            if (!isUnsubscribed() && !this.finished) {
                this.finished = true;
                schedule();
            }
        }

        public final void onError(Throwable th) {
            if (isUnsubscribed() || this.finished) {
                RxJavaHooks.onError(th);
                return;
            }
            this.error = th;
            this.finished = true;
            schedule();
        }

        /* access modifiers changed from: protected */
        public final void schedule() {
            if (this.counter.getAndIncrement() == 0) {
                this.recursiveScheduler.schedule(this);
            }
        }

        public final void call() {
            long j = this.emitted;
            Queue<Object> queue2 = this.queue;
            Subscriber<? super T> subscriber = this.child;
            long j2 = j;
            long j3 = 1;
            do {
                long j4 = this.requested.get();
                while (j4 != j2) {
                    boolean z = this.finished;
                    Object poll = queue2.poll();
                    boolean z2 = poll == null;
                    if (!checkTerminated(z, z2, subscriber, queue2)) {
                        if (z2) {
                            break;
                        }
                        subscriber.onNext(NotificationLite.getValue(poll));
                        j2++;
                        if (j2 == ((long) this.limit)) {
                            j4 = BackpressureUtils.produced(this.requested, j2);
                            request(j2);
                            j2 = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (j4 != j2 || !checkTerminated(this.finished, queue2.isEmpty(), subscriber, queue2)) {
                    this.emitted = j2;
                    j3 = this.counter.addAndGet(-j3);
                } else {
                    return;
                }
            } while (j3 != 0);
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber, Queue<Object> queue2) {
            if (subscriber.isUnsubscribed()) {
                queue2.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.delayError) {
                    Throwable th = this.error;
                    if (th != null) {
                        queue2.clear();
                        try {
                            subscriber.onError(th);
                            return true;
                        } finally {
                            this.recursiveScheduler.unsubscribe();
                        }
                    } else if (!z2) {
                        return false;
                    } else {
                        try {
                            subscriber.onCompleted();
                            return true;
                        } finally {
                            this.recursiveScheduler.unsubscribe();
                        }
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        try {
                            subscriber.onError(th2);
                        } catch (Throwable th3) {
                            this.recursiveScheduler.unsubscribe();
                            throw th3;
                        }
                    } else {
                        subscriber.onCompleted();
                    }
                    this.recursiveScheduler.unsubscribe();
                    return false;
                }
            }
        }
    }
}
