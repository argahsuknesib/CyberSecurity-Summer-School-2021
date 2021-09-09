package rx.internal.operators;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OperatorSwitch<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayError;

    static final class Holder {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(false);

        Holder() {
        }
    }

    static final class HolderDelayError {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(true);

        HolderDelayError() {
        }
    }

    public static <T> OperatorSwitch<T> instance(boolean z) {
        if (z) {
            return HolderDelayError.INSTANCE;
        }
        return Holder.INSTANCE;
    }

    OperatorSwitch(boolean z) {
        this.delayError = z;
    }

    public final Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        SwitchSubscriber switchSubscriber = new SwitchSubscriber(subscriber, this.delayError);
        subscriber.add(switchSubscriber);
        switchSubscriber.init();
        return switchSubscriber;
    }

    static final class SwitchSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final Throwable TERMINAL_ERROR = new Throwable("Terminal error");
        final Subscriber<? super T> child;
        final boolean delayError;
        boolean emitting;
        Throwable error;
        final AtomicLong index;
        boolean innerActive;
        volatile boolean mainDone;
        boolean missed;
        Producer producer;
        final SpscLinkedArrayQueue<Object> queue;
        long requested;
        final SerialSubscription serial = new SerialSubscription();

        SwitchSubscriber(Subscriber<? super T> subscriber, boolean z) {
            this.child = subscriber;
            this.delayError = z;
            this.index = new AtomicLong();
            this.queue = new SpscLinkedArrayQueue<>(RxRingBuffer.SIZE);
        }

        /* access modifiers changed from: package-private */
        public final void init() {
            this.child.add(this.serial);
            this.child.add(Subscriptions.create(new Action0() {
                /* class rx.internal.operators.OperatorSwitch.SwitchSubscriber.AnonymousClass1 */

                public void call() {
                    SwitchSubscriber.this.clearProducer();
                }
            }));
            this.child.setProducer(new Producer() {
                /* class rx.internal.operators.OperatorSwitch.SwitchSubscriber.AnonymousClass2 */

                public void request(long j) {
                    if (j > 0) {
                        SwitchSubscriber.this.childRequested(j);
                    } else if (j < 0) {
                        throw new IllegalArgumentException("n >= 0 expected but it was ".concat(String.valueOf(j)));
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public final void clearProducer() {
            synchronized (this) {
                this.producer = null;
            }
        }

        public final void onNext(Observable<? extends T> observable) {
            InnerSubscriber innerSubscriber;
            long incrementAndGet = this.index.incrementAndGet();
            Subscription subscription = this.serial.get();
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                innerSubscriber = new InnerSubscriber(incrementAndGet, this);
                this.innerActive = true;
                this.producer = null;
            }
            this.serial.set(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
        }

        public final void onError(Throwable th) {
            boolean updateError;
            synchronized (this) {
                updateError = updateError(th);
            }
            if (updateError) {
                this.mainDone = true;
                drain();
                return;
            }
            pluginError(th);
        }

        /* access modifiers changed from: package-private */
        public final boolean updateError(Throwable th) {
            Throwable th2 = this.error;
            if (th2 == TERMINAL_ERROR) {
                return false;
            }
            if (th2 == null) {
                this.error = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).getExceptions());
                arrayList.add(th);
                this.error = new CompositeException(arrayList);
            } else {
                this.error = new CompositeException(th2, th);
            }
            return true;
        }

        public final void onCompleted() {
            this.mainDone = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void emit(T t, InnerSubscriber<T> innerSubscriber) {
            synchronized (this) {
                if (this.index.get() == innerSubscriber.id) {
                    this.queue.offer(innerSubscriber, NotificationLite.next(t));
                    drain();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void error(Throwable th, long j) {
            boolean z;
            synchronized (this) {
                if (this.index.get() == j) {
                    z = updateError(th);
                    this.innerActive = false;
                    this.producer = null;
                } else {
                    z = true;
                }
            }
            if (z) {
                drain();
            } else {
                pluginError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public final void complete(long j) {
            synchronized (this) {
                if (this.index.get() == j) {
                    this.innerActive = false;
                    this.producer = null;
                    drain();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void pluginError(Throwable th) {
            RxJavaHooks.onError(th);
        }

        /* access modifiers changed from: package-private */
        public final void innerProducer(Producer producer2, long j) {
            synchronized (this) {
                if (this.index.get() == j) {
                    long j2 = this.requested;
                    this.producer = producer2;
                    producer2.request(j2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void childRequested(long j) {
            Producer producer2;
            synchronized (this) {
                producer2 = this.producer;
                this.requested = BackpressureUtils.addCap(this.requested, j);
            }
            if (producer2 != null) {
                producer2.request(j);
            }
            drain();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            r9 = r8.queue;
            r10 = r8.index;
            r11 = r8.child;
            r12 = r1;
            r14 = r3;
            r15 = r8.mainDone;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
            r16 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
            if (r16 == r12) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
            r18 = r9.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
            if (checkTerminated(r15, r0, r14, r9, r11, r18) == false) goto L_0x0051;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0050, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
            if (r18 != false) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0053, code lost:
            r2 = rx.internal.operators.NotificationLite.getValue(r9.poll());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
            if (r10.get() != ((rx.internal.operators.OperatorSwitch.InnerSubscriber) r9.poll()).id) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006b, code lost:
            r11.onNext(r2);
            r16 = r16 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0075, code lost:
            if (r16 != r12) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x007b, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x007e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
            if (checkTerminated(r8.mainDone, r0, r14, r9, r11, r9.isEmpty()) == false) goto L_0x0091;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
            monitor-enter(r19);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r0 = r8.requested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x009b, code lost:
            if (r0 == Long.MAX_VALUE) goto L_0x00a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x009d, code lost:
            r0 = r0 - r16;
            r8.requested = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a1, code lost:
            r12 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a5, code lost:
            if (r8.missed != false) goto L_0x00ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a7, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
            monitor-exit(r19);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00aa, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ab, code lost:
            r8.missed = false;
            r15 = r8.mainDone;
            r0 = r8.innerActive;
            r14 = r8.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b3, code lost:
            if (r14 == null) goto L_0x00c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b7, code lost:
            if (r14 == rx.internal.operators.OperatorSwitch.SwitchSubscriber.TERMINAL_ERROR) goto L_0x00c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bb, code lost:
            if (r8.delayError != false) goto L_0x00c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bd, code lost:
            r8.error = rx.internal.operators.OperatorSwitch.SwitchSubscriber.TERMINAL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c1, code lost:
            monitor-exit(r19);
         */
        public final void drain() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                boolean z = this.innerActive;
                long j = this.requested;
                Throwable th = this.error;
                if (!(th == null || th == TERMINAL_ERROR || this.delayError)) {
                    this.error = TERMINAL_ERROR;
                }
            }
        }

        /* access modifiers changed from: protected */
        public final boolean checkTerminated(boolean z, boolean z2, Throwable th, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z3) {
            if (this.delayError) {
                if (!z || z2 || !z3) {
                    return false;
                }
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            } else if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            } else if (!z || z2 || !z3) {
                return false;
            } else {
                subscriber.onCompleted();
                return true;
            }
        }
    }

    static final class InnerSubscriber<T> extends Subscriber<T> {
        public final long id;
        private final SwitchSubscriber<T> parent;

        InnerSubscriber(long j, SwitchSubscriber<T> switchSubscriber) {
            this.id = j;
            this.parent = switchSubscriber;
        }

        public final void setProducer(Producer producer) {
            this.parent.innerProducer(producer, this.id);
        }

        public final void onNext(T t) {
            this.parent.emit(t, this);
        }

        public final void onError(Throwable th) {
            this.parent.error(th, this.id);
        }

        public final void onCompleted() {
            this.parent.complete(this.id);
        }
    }
}
