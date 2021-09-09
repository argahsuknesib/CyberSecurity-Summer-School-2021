package rx.subjects;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.operators.BackpressureUtils;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class UnicastSubject<T> extends Subject<T, T> {
    final State<T> state;

    public static <T> UnicastSubject<T> create() {
        return create(16);
    }

    public static <T> UnicastSubject<T> create(int i) {
        return new UnicastSubject<>(new State(i, false, null));
    }

    public static <T> UnicastSubject<T> create(boolean z) {
        return new UnicastSubject<>(new State(16, z, null));
    }

    public static <T> UnicastSubject<T> create(int i, Action0 action0) {
        return new UnicastSubject<>(new State(i, false, action0));
    }

    public static <T> UnicastSubject<T> create(int i, Action0 action0, boolean z) {
        return new UnicastSubject<>(new State(i, z, action0));
    }

    private UnicastSubject(State<T> state2) {
        super(state2);
        this.state = state2;
    }

    public final void onNext(T t) {
        this.state.onNext(t);
    }

    public final void onError(Throwable th) {
        this.state.onError(th);
    }

    public final void onCompleted() {
        this.state.onCompleted();
    }

    public final boolean hasObservers() {
        return this.state.subscriber.get() != null;
    }

    static final class State<T> extends AtomicLong implements Observable.OnSubscribe<T>, Observer<T>, Producer, Subscription {
        private static final long serialVersionUID = -9044104859202255786L;
        volatile boolean caughtUp;
        final boolean delayError;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        final Queue<Object> queue;
        final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference<>();
        final AtomicReference<Action0> terminateOnce;

        public State(int i, boolean z, Action0 action0) {
            Queue<Object> queue2;
            this.terminateOnce = action0 != null ? new AtomicReference<>(action0) : null;
            this.delayError = z;
            if (i > 1) {
                queue2 = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(i) : new SpscUnboundedAtomicArrayQueue<>(i);
            } else {
                queue2 = UnsafeAccess.isUnsafeAvailable() ? new SpscLinkedQueue<>() : new SpscLinkedAtomicQueue<>();
            }
            this.queue = queue2;
        }

        public final void onNext(T t) {
            if (!this.done) {
                if (!this.caughtUp) {
                    boolean z = false;
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(NotificationLite.next(t));
                            z = true;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                Subscriber subscriber2 = this.subscriber.get();
                try {
                    subscriber2.onNext(t);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber2, t);
                }
            }
        }

        public final void onError(Throwable th) {
            if (!this.done) {
                doTerminate();
                this.error = th;
                boolean z = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z = false;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onError(th);
            }
        }

        public final void onCompleted() {
            if (!this.done) {
                doTerminate();
                boolean z = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z = false;
                        }
                    }
                    if (z) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onCompleted();
            }
        }

        public final void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            } else if (j > 0) {
                BackpressureUtils.getAndAddRequest(this, j);
                replay();
            } else if (this.done) {
                replay();
            }
        }

        public final void call(Subscriber<? super T> subscriber2) {
            if (this.subscriber.compareAndSet(null, subscriber2)) {
                subscriber2.add(this);
                subscriber2.setProducer(this);
                return;
            }
            subscriber2.onError(new IllegalStateException("Only a single subscriber is allowed"));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            r3 = r15.subscriber.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
            if (r3 == null) goto L_0x007a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            if (checkTerminated(r15.done, r0.isEmpty(), r2, r3) == false) goto L_0x0029;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
            r5 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
            if (r5 != Long.MAX_VALUE) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
            r7 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            r10 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
            if (r5 == 0) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
            r12 = r15.done;
            r13 = r0.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
            if (r13 != null) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
            r14 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
            r14 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
            if (checkTerminated(r12, r14, r2, r3) == false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
            if (r14 != false) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
            r12 = rx.internal.operators.NotificationLite.getValue(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r3.onNext(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005b, code lost:
            r5 = r5 - 1;
            r10 = r10 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0060, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0061, code lost:
            r0.clear();
            rx.exceptions.Exceptions.throwIfFatal(r1);
            r3.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r1, r12));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x006e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x006f, code lost:
            if (r7 != false) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0073, code lost:
            if (r10 == 0) goto L_0x007b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0075, code lost:
            addAndGet(-r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x007a, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x007b, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x007e, code lost:
            if (r15.missed != false) goto L_0x008e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0080, code lost:
            if (r7 == false) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0086, code lost:
            if (r0.isEmpty() == false) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0088, code lost:
            r15.caughtUp = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x008a, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008c, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x008d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x008e, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0090, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
            r0 = r15.queue;
            r2 = r15.delayError;
         */
        public final void replay() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
            }
        }

        public final void unsubscribe() {
            doTerminate();
            this.done = true;
            synchronized (this) {
                if (!this.emitting) {
                    this.emitting = true;
                    this.queue.clear();
                }
            }
        }

        public final boolean isUnsubscribed() {
            return this.done;
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber2) {
            if (subscriber2.isUnsubscribed()) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.error;
                if (th != null && !z3) {
                    this.queue.clear();
                    subscriber2.onError(th);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    if (th != null) {
                        subscriber2.onError(th);
                    } else {
                        subscriber2.onCompleted();
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void doTerminate() {
            Action0 action0;
            AtomicReference<Action0> atomicReference = this.terminateOnce;
            if (atomicReference != null && (action0 = atomicReference.get()) != null && atomicReference.compareAndSet(action0, null)) {
                action0.call();
            }
        }
    }
}
