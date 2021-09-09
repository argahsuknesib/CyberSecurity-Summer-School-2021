package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class SingleDelayedProducer<T> extends AtomicInteger implements Producer {
    private static final long serialVersionUID = -2873467947112093874L;
    final Subscriber<? super T> child;
    T value;

    public SingleDelayedProducer(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (j != 0) {
            do {
                int i = get();
                if (i != 0) {
                    if (i == 1 && compareAndSet(1, 3)) {
                        emit(this.child, this.value);
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final void setValue(T t) {
        do {
            int i = get();
            if (i == 0) {
                this.value = t;
            } else if (i == 2 && compareAndSet(2, 3)) {
                emit(this.child, t);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }

    private static <T> void emit(Subscriber<? super T> subscriber, T t) {
        if (!subscriber.isUnsubscribed()) {
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
