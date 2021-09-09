package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.operators.OperatorTimeoutBase;

public final class OperatorTimeout<T> extends OperatorTimeoutBase<T> {
    public final /* bridge */ /* synthetic */ Subscriber call(Subscriber subscriber) {
        return super.call(subscriber);
    }

    public OperatorTimeout(final long j, final TimeUnit timeUnit, Observable<? extends T> observable, Scheduler scheduler) {
        super(new OperatorTimeoutBase.FirstTimeoutStub<T>() {
            /* class rx.internal.operators.OperatorTimeout.AnonymousClass1 */

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l, Scheduler.Worker worker) {
                return worker.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorTimeout.AnonymousClass1.AnonymousClass1 */

                    public void call() {
                        timeoutSubscriber.onTimeout(l.longValue());
                    }
                }, j, timeUnit);
            }
        }, new OperatorTimeoutBase.TimeoutStub<T>() {
            /* class rx.internal.operators.OperatorTimeout.AnonymousClass2 */

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l, T t, Scheduler.Worker worker) {
                return worker.schedule(new Action0() {
                    /* class rx.internal.operators.OperatorTimeout.AnonymousClass2.AnonymousClass1 */

                    public void call() {
                        timeoutSubscriber.onTimeout(l.longValue());
                    }
                }, j, timeUnit);
            }
        }, observable, scheduler);
    }
}
