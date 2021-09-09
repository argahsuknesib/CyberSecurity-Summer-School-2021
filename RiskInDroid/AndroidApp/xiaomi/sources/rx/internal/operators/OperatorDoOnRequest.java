package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action1;

public class OperatorDoOnRequest<T> implements Observable.Operator<T, T> {
    final Action1<? super Long> request;

    public OperatorDoOnRequest(Action1<? super Long> action1) {
        this.request = action1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.setProducer(new Producer() {
            /* class rx.internal.operators.OperatorDoOnRequest.AnonymousClass1 */

            public void request(long j) {
                OperatorDoOnRequest.this.request.call(Long.valueOf(j));
                parentSubscriber.requestMore(j);
            }
        });
        subscriber.add(parentSubscriber);
        return parentSubscriber;
    }

    static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> child;

        ParentSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            request(0);
        }

        public final void requestMore(long j) {
            request(j);
        }

        public final void onCompleted() {
            this.child.onCompleted();
        }

        public final void onError(Throwable th) {
            this.child.onError(th);
        }

        public final void onNext(T t) {
            this.child.onNext(t);
        }
    }
}
