package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = -3353584923995471404L;
    final Subscriber<? super T> child;
    final T value;

    public SingleProducer(Subscriber<? super T> subscriber, T t) {
        this.child = subscriber;
        this.value = t;
    }

    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (j != 0 && compareAndSet(false, true)) {
            Subscriber<? super T> subscriber = this.child;
            if (!subscriber.isUnsubscribed()) {
                T t = this.value;
                try {
                    subscriber.onNext(t);
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, subscriber, t);
                }
            }
        }
    }
}
