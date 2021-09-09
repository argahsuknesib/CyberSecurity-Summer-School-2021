package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

public final class OperatorDebounceWithTime<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public OperatorDebounceWithTime(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public final Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(createWorker);
        serializedSubscriber.add(serialSubscription);
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorDebounceWithTime.AnonymousClass1 */
            final Subscriber<?> self = this;
            final DebounceState<T> state = new DebounceState<>();

            public void onStart() {
                request(Long.MAX_VALUE);
            }

            public void onNext(T t) {
                final int next = this.state.next(t);
                serialSubscription.set(createWorker.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorDebounceWithTime.AnonymousClass1.AnonymousClass1 */

                    public void call() {
                        AnonymousClass1.this.state.emit(next, serializedSubscriber, AnonymousClass1.this.self);
                    }
                }, OperatorDebounceWithTime.this.timeout, OperatorDebounceWithTime.this.unit));
            }

            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                unsubscribe();
                this.state.clear();
            }

            public void onCompleted() {
                this.state.emitAndComplete(serializedSubscriber, this);
            }
        };
    }

    static final class DebounceState<T> {
        boolean emitting;
        boolean hasValue;
        int index;
        boolean terminate;
        T value;

        DebounceState() {
        }

        public final synchronized int next(T t) {
            int i;
            this.value = t;
            this.hasValue = true;
            i = this.index + 1;
            this.index = i;
            return i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r4.onNext(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
            if (r2.terminate != false) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
            r2.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0027, code lost:
            r4.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x002e, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x002f, code lost:
            rx.exceptions.Exceptions.throwOrReport(r4, r5, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0032, code lost:
            return;
         */
        public final void emit(int i, Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (!this.emitting && this.hasValue) {
                    if (i == this.index) {
                        T t = this.value;
                        this.value = null;
                        this.hasValue = false;
                        this.emitting = true;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r5.onNext(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
            rx.exceptions.Exceptions.throwOrReport(r5, r6, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
            r5.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r2 == false) goto L_0x0022;
         */
        public final void emitAndComplete(Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (this.emitting) {
                    this.terminate = true;
                    return;
                }
                T t = this.value;
                boolean z = this.hasValue;
                this.value = null;
                this.hasValue = false;
                this.emitting = true;
            }
        }

        public final synchronized void clear() {
            this.index++;
            this.value = null;
            this.hasValue = false;
        }
    }
}
