package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorTimeoutBase<T> implements Observable.Operator<T, T> {
    final FirstTimeoutStub<T> firstTimeoutStub;
    final Observable<? extends T> other;
    final Scheduler scheduler;
    final TimeoutStub<T> timeoutStub;

    interface FirstTimeoutStub<T> extends Func3<TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription> {
    }

    interface TimeoutStub<T> extends Func4<TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription> {
    }

    OperatorTimeoutBase(FirstTimeoutStub<T> firstTimeoutStub2, TimeoutStub<T> timeoutStub2, Observable<? extends T> observable, Scheduler scheduler2) {
        this.firstTimeoutStub = firstTimeoutStub2;
        this.timeoutStub = timeoutStub2;
        this.other = observable;
        this.scheduler = scheduler2;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(serialSubscription);
        TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(serializedSubscriber, this.timeoutStub, serialSubscription, this.other, createWorker);
        serializedSubscriber.add(timeoutSubscriber);
        serializedSubscriber.setProducer(timeoutSubscriber.arbiter);
        serialSubscription.set((Subscription) this.firstTimeoutStub.call(timeoutSubscriber, 0L, createWorker));
        return timeoutSubscriber;
    }

    static final class TimeoutSubscriber<T> extends Subscriber<T> {
        long actual;
        final ProducerArbiter arbiter = new ProducerArbiter();
        final Scheduler.Worker inner;
        final Observable<? extends T> other;
        final SerialSubscription serial;
        final SerializedSubscriber<T> serializedSubscriber;
        boolean terminated;
        final TimeoutStub<T> timeoutStub;

        TimeoutSubscriber(SerializedSubscriber<T> serializedSubscriber2, TimeoutStub<T> timeoutStub2, SerialSubscription serialSubscription, Observable<? extends T> observable, Scheduler.Worker worker) {
            this.serializedSubscriber = serializedSubscriber2;
            this.timeoutStub = timeoutStub2;
            this.serial = serialSubscription;
            this.other = observable;
            this.inner = worker;
        }

        public final void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }

        public final void onNext(T t) {
            boolean z;
            long j;
            synchronized (this) {
                if (!this.terminated) {
                    j = this.actual + 1;
                    this.actual = j;
                    z = true;
                } else {
                    j = 0;
                    z = false;
                }
            }
            if (z) {
                this.serializedSubscriber.onNext(t);
                this.serial.set((Subscription) this.timeoutStub.call(this, Long.valueOf(j), t, this.inner));
            }
        }

        public final void onError(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.terminated) {
                    this.terminated = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onError(th);
            }
        }

        public final void onCompleted() {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.terminated) {
                    this.terminated = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onCompleted();
            }
        }

        public final void onTimeout(long j) {
            boolean z;
            synchronized (this) {
                z = true;
                if (j != this.actual || this.terminated) {
                    z = false;
                } else {
                    this.terminated = true;
                }
            }
            if (!z) {
                return;
            }
            if (this.other == null) {
                this.serializedSubscriber.onError(new TimeoutException());
                return;
            }
            AnonymousClass1 r5 = new Subscriber<T>() {
                /* class rx.internal.operators.OperatorTimeoutBase.TimeoutSubscriber.AnonymousClass1 */

                public void onNext(T t) {
                    TimeoutSubscriber.this.serializedSubscriber.onNext(t);
                }

                public void onError(Throwable th) {
                    TimeoutSubscriber.this.serializedSubscriber.onError(th);
                }

                public void onCompleted() {
                    TimeoutSubscriber.this.serializedSubscriber.onCompleted();
                }

                public void setProducer(Producer producer) {
                    TimeoutSubscriber.this.arbiter.setProducer(producer);
                }
            };
            this.other.unsafeSubscribe(r5);
            this.serial.set(r5);
        }
    }
}
