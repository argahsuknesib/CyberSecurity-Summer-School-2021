package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

public final class OperatorTakeTimed<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    public OperatorTakeTimed(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler2;
    }

    public final Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        TakeSubscriber takeSubscriber = new TakeSubscriber(new SerializedSubscriber(subscriber));
        createWorker.schedule(takeSubscriber, this.time, this.unit);
        return takeSubscriber;
    }

    static final class TakeSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> child;

        public TakeSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.child = subscriber;
        }

        public final void onNext(T t) {
            this.child.onNext(t);
        }

        public final void onError(Throwable th) {
            this.child.onError(th);
            unsubscribe();
        }

        public final void onCompleted() {
            this.child.onCompleted();
            unsubscribe();
        }

        public final void call() {
            onCompleted();
        }
    }
}
