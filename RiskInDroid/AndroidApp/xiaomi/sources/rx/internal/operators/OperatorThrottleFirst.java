package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

public final class OperatorThrottleFirst<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeInMilliseconds;

    public OperatorThrottleFirst(long j, TimeUnit timeUnit, Scheduler scheduler2) {
        this.timeInMilliseconds = timeUnit.toMillis(j);
        this.scheduler = scheduler2;
    }

    public final Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            /* class rx.internal.operators.OperatorThrottleFirst.AnonymousClass1 */
            private long lastOnNext = -1;

            public void onStart() {
                request(Long.MAX_VALUE);
            }

            public void onNext(T t) {
                long now = OperatorThrottleFirst.this.scheduler.now();
                long j = this.lastOnNext;
                if (j == -1 || now < j || now - j >= OperatorThrottleFirst.this.timeInMilliseconds) {
                    this.lastOnNext = now;
                    subscriber.onNext(t);
                }
            }

            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th) {
                subscriber.onError(th);
            }
        };
    }
}
