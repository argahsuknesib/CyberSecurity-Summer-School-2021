package rx.internal.producers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;

public final class ProducerObserverArbiter<T> implements Observer<T>, Producer {
    static final Producer NULL_PRODUCER = new Producer() {
        /* class rx.internal.producers.ProducerObserverArbiter.AnonymousClass1 */

        public final void request(long j) {
        }
    };
    final Subscriber<? super T> child;
    Producer currentProducer;
    boolean emitting;
    volatile boolean hasError;
    Producer missedProducer;
    long missedRequested;
    Object missedTerminal;
    List<T> queue;
    long requested;

    public ProducerObserverArbiter(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r4.child.onNext(r5);
        r0 = r4.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r0 == Long.MAX_VALUE) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r4.requested = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        throw r5;
     */
    public final void onNext(T t) {
        synchronized (this) {
            if (this.emitting) {
                List list = this.queue;
                if (list == null) {
                    list = new ArrayList(4);
                    this.queue = list;
                }
                list.add(t);
                return;
            }
            this.emitting = true;
        }
    }

    public final void onError(Throwable th) {
        boolean z;
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = th;
                z = false;
            } else {
                this.emitting = true;
                z = true;
            }
        }
        if (z) {
            this.child.onError(th);
        } else {
            this.hasError = true;
        }
    }

    public final void onCompleted() {
        synchronized (this) {
            if (this.emitting) {
                this.missedTerminal = Boolean.TRUE;
                return;
            }
            this.emitting = true;
            this.child.onCompleted();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        r2 = r6.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = r6.requested + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        if (r3 >= 0) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        r3 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        r6.requested = r3;
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        r2.request(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r6.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003a, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (j != 0) {
            synchronized (this) {
                if (this.emitting) {
                    this.missedRequested += j;
                    return;
                }
                this.emitting = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        r5.currentProducer = r6;
        r0 = r5.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        if (r0 == 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        r6.request(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r5.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x002b, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    public final void setProducer(Producer producer) {
        synchronized (this) {
            if (this.emitting) {
                if (producer == null) {
                    producer = NULL_PRODUCER;
                }
                this.missedProducer = producer;
                return;
            }
            this.emitting = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void emitLoop() {
        long j;
        Producer producer;
        Object obj;
        List<T> list;
        boolean z;
        boolean z2;
        long j2;
        Subscriber<? super T> subscriber = this.child;
        Producer producer2 = null;
        long j3 = 0;
        while (true) {
            synchronized (this) {
                j = this.missedRequested;
                producer = this.missedProducer;
                obj = this.missedTerminal;
                list = this.queue;
                z = true;
                if (j == 0 && producer == null && list == null && obj == null) {
                    this.emitting = false;
                    z2 = true;
                } else {
                    this.missedRequested = 0;
                    this.missedProducer = null;
                    this.queue = null;
                    this.missedTerminal = null;
                    z2 = false;
                }
            }
            if (!z2) {
                if (list != null && !list.isEmpty()) {
                    z = false;
                }
                if (obj != null) {
                    if (obj != Boolean.TRUE) {
                        subscriber.onError((Throwable) obj);
                        return;
                    } else if (z) {
                        subscriber.onCompleted();
                        return;
                    }
                }
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            j2 = ((long) list.size()) + 0;
                            break;
                        }
                        T next = it.next();
                        if (!subscriber.isUnsubscribed()) {
                            if (this.hasError) {
                                break;
                            }
                            try {
                                subscriber.onNext(next);
                            } catch (Throwable th) {
                                Exceptions.throwOrReport(th, subscriber, next);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    j2 = 0;
                }
                long j4 = this.requested;
                if (j4 != Long.MAX_VALUE) {
                    if (j != 0) {
                        j4 += j;
                        if (j4 < 0) {
                            j4 = Long.MAX_VALUE;
                        }
                    }
                    if (!(j2 == 0 || j4 == Long.MAX_VALUE)) {
                        j4 -= j2;
                        if (j4 < 0) {
                            throw new IllegalStateException("More produced than requested");
                        }
                    }
                    this.requested = j4;
                }
                if (producer == null) {
                    producer = this.currentProducer;
                    if (producer != null && j != 0) {
                        j3 = BackpressureUtils.addCap(j3, j);
                    }
                } else if (producer == NULL_PRODUCER) {
                    this.currentProducer = null;
                } else {
                    this.currentProducer = producer;
                    if (j4 != 0) {
                        j3 = BackpressureUtils.addCap(j3, j4);
                    }
                }
                producer2 = producer;
            } else if (j3 != 0 && producer2 != null) {
                producer2.request(j3);
                return;
            } else {
                return;
            }
        }
        while (true) {
        }
    }
}
