package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

public final class OperatorOnBackpressureLatest<T> implements Observable.Operator<T, T> {

    static final class Holder {
        static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest<>();

        Holder() {
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> instance() {
        return Holder.INSTANCE;
    }

    public final Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        LatestEmitter latestEmitter = new LatestEmitter(subscriber);
        LatestSubscriber<? super T> latestSubscriber = new LatestSubscriber<>(latestEmitter);
        latestEmitter.parent = latestSubscriber;
        subscriber.add(latestSubscriber);
        subscriber.add(latestEmitter);
        subscriber.setProducer(latestEmitter);
        return latestSubscriber;
    }

    static final class LatestEmitter<T> extends AtomicLong implements Observer<T>, Producer, Subscription {
        static final Object EMPTY = new Object();
        private static final long serialVersionUID = -1364393685005146274L;
        final Subscriber<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        LatestSubscriber<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            lazySet(-4611686018427387904L);
        }

        public final void request(long j) {
            long j2;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 != Long.MIN_VALUE) {
                        if (j2 == -4611686018427387904L) {
                            j3 = j;
                        } else {
                            j3 = j2 + j;
                            if (j3 < 0) {
                                j3 = Long.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j2, j3));
                if (j2 == -4611686018427387904L) {
                    this.parent.requestMore(Long.MAX_VALUE);
                }
                emit();
            }
        }

        /* access modifiers changed from: package-private */
        public final long produced(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 < 0) {
                    return j2;
                }
                j3 = j2 - j;
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        public final boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public final void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }

        public final void onNext(T t) {
            this.value.lazySet(t);
            emit();
        }

        public final void onError(Throwable th) {
            this.terminal = th;
            this.done = true;
            emit();
        }

        public final void onCompleted() {
            this.done = true;
            emit();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r2 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
            if (r2 != Long.MIN_VALUE) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            r4 = r9.value.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            if (r2 <= 0) goto L_0x003e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            if (r4 == rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.EMPTY) goto L_0x003e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
            r9.child.onNext(r4);
            r9.value.compareAndSet(r4, rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.EMPTY);
            produced(1);
            r4 = rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.EMPTY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
            if (r4 != rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.EMPTY) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
            if (r9.done == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
            r2 = r9.terminal;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
            if (r2 == null) goto L_0x0050;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
            r9.child.onError(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
            r9.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
            if (r9.missed != false) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
            r9.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r9.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0060, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0062, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0063, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0066, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0067, code lost:
            r8 = r2;
            r2 = r1;
            r1 = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006b, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x006d, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006e, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x006f, code lost:
            if (r2 == false) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0071, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            r9.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0079, code lost:
            throw r1;
         */
        public final void emit() {
            synchronized (this) {
                boolean z = true;
                if (this.emitting) {
                    this.missed = true;
                } else {
                    this.emitting = true;
                    this.missed = false;
                }
            }
        }
    }

    static final class LatestSubscriber<T> extends Subscriber<T> {
        private final LatestEmitter<T> producer;

        LatestSubscriber(LatestEmitter<T> latestEmitter) {
            this.producer = latestEmitter;
        }

        public final void onStart() {
            request(0);
        }

        public final void onNext(T t) {
            this.producer.onNext(t);
        }

        public final void onError(Throwable th) {
            this.producer.onError(th);
        }

        public final void onCompleted() {
            this.producer.onCompleted();
        }

        /* access modifiers changed from: package-private */
        public final void requestMore(long j) {
            request(j);
        }
    }
}
