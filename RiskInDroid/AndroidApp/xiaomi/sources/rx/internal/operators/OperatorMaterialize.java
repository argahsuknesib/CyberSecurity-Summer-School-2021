package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public final class OperatorMaterialize<T> implements Observable.Operator<Notification<T>, T> {

    static final class Holder {
        static final OperatorMaterialize<Object> INSTANCE = new OperatorMaterialize<>();

        Holder() {
        }
    }

    public static <T> OperatorMaterialize<T> instance() {
        return Holder.INSTANCE;
    }

    OperatorMaterialize() {
    }

    public final Subscriber<? super T> call(Subscriber<? super Notification<T>> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.add(parentSubscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorMaterialize.AnonymousClass1 */

            public void request(long j) {
                if (j > 0) {
                    parentSubscriber.requestMore(j);
                }
            }
        });
        return parentSubscriber;
    }

    static class ParentSubscriber<T> extends Subscriber<T> {
        private boolean busy;
        private final Subscriber<? super Notification<T>> child;
        private boolean missed;
        private final AtomicLong requested = new AtomicLong();
        private volatile Notification<T> terminalNotification;

        ParentSubscriber(Subscriber<? super Notification<T>> subscriber) {
            this.child = subscriber;
        }

        public void onStart() {
            request(0);
        }

        /* access modifiers changed from: package-private */
        public void requestMore(long j) {
            BackpressureUtils.getAndAddRequest(this.requested, j);
            request(j);
            drain();
        }

        public void onCompleted() {
            this.terminalNotification = Notification.createOnCompleted();
            drain();
        }

        public void onError(Throwable th) {
            this.terminalNotification = Notification.createOnError(th);
            RxJavaHooks.onError(th);
            drain();
        }

        public void onNext(T t) {
            this.child.onNext(Notification.createOnNext(t));
            decrementRequested();
        }

        private void decrementRequested() {
            long j;
            AtomicLong atomicLong = this.requested;
            do {
                j = atomicLong.get();
                if (j == Long.MAX_VALUE) {
                    return;
                }
            } while (!atomicLong.compareAndSet(j, j - 1));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            if (r7.child.isUnsubscribed() != false) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
            r1 = r7.terminalNotification;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r1 == null) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            if (r0.get() <= 0) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            r7.terminalNotification = null;
            r7.child.onNext(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            if (r7.child.isUnsubscribed() != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
            r7.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
            if (r7.missed != false) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
            r7.busy = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r0 = r7.requested;
         */
        private void drain() {
            synchronized (this) {
                if (this.busy) {
                    this.missed = true;
                }
            }
        }
    }
}
