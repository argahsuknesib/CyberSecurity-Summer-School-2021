package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

public final class CachedObservable<T> extends Observable<T> {
    private final CacheState<T> state;

    public static <T> CachedObservable<T> from(Observable observable) {
        return from(observable, 16);
    }

    public static <T> CachedObservable<T> from(Observable observable, int i) {
        if (i > 0) {
            CacheState cacheState = new CacheState(observable, i);
            return new CachedObservable<>(new CachedSubscribe(cacheState), cacheState);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }

    private CachedObservable(Observable.OnSubscribe<T> onSubscribe, CacheState<T> cacheState) {
        super(onSubscribe);
        this.state = cacheState;
    }

    /* access modifiers changed from: package-private */
    public final boolean isConnected() {
        return this.state.isConnected;
    }

    /* access modifiers changed from: package-private */
    public final boolean hasObservers() {
        return this.state.producers.length != 0;
    }

    static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayProducer<?>[] EMPTY = new ReplayProducer[0];
        final SerialSubscription connection = new SerialSubscription();
        volatile boolean isConnected;
        volatile ReplayProducer<?>[] producers = EMPTY;
        final Observable<? extends T> source;
        boolean sourceDone;

        public CacheState(Observable<? extends T> observable, int i) {
            super(i);
            this.source = observable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: rx.internal.operators.CachedObservable$ReplayProducer<?>[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        public final void addProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length + 1)];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
                this.producers = replayProducerArr2;
            }
        }

        public final void removeProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (replayProducerArr[i2].equals(replayProducer)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        this.producers = EMPTY;
                        return;
                    }
                    ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length - 1)];
                    System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, i);
                    System.arraycopy(replayProducerArr, i + 1, replayProducerArr2, i, (length - i) - 1);
                    this.producers = replayProducerArr2;
                }
            }
        }

        public final void connect() {
            AnonymousClass1 r0 = new Subscriber<T>() {
                /* class rx.internal.operators.CachedObservable.CacheState.AnonymousClass1 */

                public void onNext(T t) {
                    CacheState.this.onNext(t);
                }

                public void onError(Throwable th) {
                    CacheState.this.onError(th);
                }

                public void onCompleted() {
                    CacheState.this.onCompleted();
                }
            };
            this.connection.set(r0);
            this.source.unsafeSubscribe(r0);
            this.isConnected = true;
        }

        public final void onNext(T t) {
            if (!this.sourceDone) {
                add(NotificationLite.next(t));
                dispatch();
            }
        }

        public final void onError(Throwable th) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th));
                this.connection.unsubscribe();
                dispatch();
            }
        }

        public final void onCompleted() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.completed());
                this.connection.unsubscribe();
                dispatch();
            }
        }

        /* access modifiers changed from: package-private */
        public final void dispatch() {
            for (ReplayProducer<?> replay : this.producers) {
                replay.replay();
            }
        }
    }

    static final class CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        final CacheState<T> state;

        public CachedSubscribe(CacheState<T> cacheState) {
            this.state = cacheState;
        }

        public final void call(Subscriber<? super T> subscriber) {
            ReplayProducer replayProducer = new ReplayProducer(subscriber, this.state);
            this.state.addProducer(replayProducer);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (!get() && compareAndSet(false, true)) {
                this.state.connect();
            }
        }
    }

    static final class ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        boolean emitting;
        int index;
        boolean missed;
        final CacheState<T> state;

        public ReplayProducer(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        public final void request(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 >= 0) {
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = Long.MAX_VALUE;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(j2, j3));
            replay();
        }

        public final long produced(long j) {
            return addAndGet(-j);
        }

        public final boolean isUnsubscribed() {
            return get() < 0;
        }

        public final void unsubscribe() {
            if (get() >= 0 && getAndSet(-1) >= 0) {
                this.state.removeProducer(this);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x00e9, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r2 = r15.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0010, code lost:
            r3 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
            if (r3 >= 0) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
            r7 = r15.state.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
            if (r7 == 0) goto L_0x00c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
            r8 = r15.currentBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
            if (r8 != null) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
            r8 = r15.state.head();
            r15.currentBuffer = r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
            r9 = r8.length - 1;
            r10 = r15.index;
            r11 = r15.currentIndexInBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
            if (r3 != 0) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
            r3 = r8[r11];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
            if (rx.internal.operators.NotificationLite.isCompleted(r3) == false) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
            r2.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0047, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0048, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0049, code lost:
            r1 = r2;
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
            if (rx.internal.operators.NotificationLite.isError(r3) == false) goto L_0x00c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
            r2.onError(rx.internal.operators.NotificationLite.getError(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0060, code lost:
            if (r3 <= 0) goto L_0x00c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0062, code lost:
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0063, code lost:
            if (r10 >= r7) goto L_0x00b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0067, code lost:
            if (r3 <= 0) goto L_0x00b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006d, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x006f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0070, code lost:
            if (r11 != r9) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0072, code lost:
            r8 = (java.lang.Object[]) r8[r9];
            r11 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0079, code lost:
            r13 = r8[r11];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x007f, code lost:
            if (rx.internal.operators.NotificationLite.accept(r2, r13) == false) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0084, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0085, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0086, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0088, code lost:
            r11 = r11 + 1;
            r10 = r10 + 1;
            r3 = r3 - 1;
            r12 = r12 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0092, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0093, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            rx.exceptions.Exceptions.throwIfFatal(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x009e, code lost:
            if (rx.internal.operators.NotificationLite.isError(r13) == false) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a6, code lost:
            r2.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, rx.internal.operators.NotificationLite.getValue(r13)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00b2, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00b8, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00ba, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00bb, code lost:
            r15.index = r10;
            r15.currentIndexInBuffer = r11;
            r15.currentBuffer = r8;
            produced((long) r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00c5, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00c8, code lost:
            if (r15.missed != false) goto L_0x00ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x00ca, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x00cd, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x00d0, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x00d3, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x00d4, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x00d7, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x00d8, code lost:
            r4 = r1;
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x00db, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x00dd, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x00de, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x00df, code lost:
            if (r4 == false) goto L_0x00e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x00e1, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x00e1  */
        public final void replay() {
            synchronized (this) {
                boolean z = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
            }
        }
    }
}
