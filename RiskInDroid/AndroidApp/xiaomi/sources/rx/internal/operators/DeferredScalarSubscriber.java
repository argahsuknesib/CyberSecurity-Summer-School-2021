package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public abstract class DeferredScalarSubscriber<T, R> extends Subscriber<T> {
    protected final Subscriber<? super R> actual;
    protected boolean hasValue;
    final AtomicInteger state = new AtomicInteger();
    protected R value;

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        this.actual = subscriber;
    }

    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    public void onCompleted() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            complete();
        }
    }

    /* access modifiers changed from: protected */
    public final void complete() {
        this.actual.onCompleted();
    }

    /* access modifiers changed from: protected */
    public final void complete(R r) {
        Subscriber<? super R> subscriber = this.actual;
        do {
            int i = this.state.get();
            if (i != 2 && i != 3 && !subscriber.isUnsubscribed()) {
                if (i == 1) {
                    subscriber.onNext(r);
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                    this.state.lazySet(3);
                    return;
                }
                this.value = r;
            } else {
                return;
            }
        } while (!this.state.compareAndSet(0, 2));
    }

    /* access modifiers changed from: package-private */
    public final void downstreamRequest(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was ".concat(String.valueOf(j)));
        } else if (j != 0) {
            Subscriber<? super R> subscriber = this.actual;
            do {
                int i = this.state.get();
                if (i != 1 && i != 3 && !subscriber.isUnsubscribed()) {
                    if (i == 2) {
                        if (this.state.compareAndSet(2, 3)) {
                            subscriber.onNext(this.value);
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.state.compareAndSet(0, 1));
        }
    }

    public final void setProducer(Producer producer) {
        producer.request(Long.MAX_VALUE);
    }

    public final void subscribeTo(Observable<? extends T> observable) {
        setupDownstream();
        observable.unsafeSubscribe(this);
    }

    /* access modifiers changed from: package-private */
    public final void setupDownstream() {
        Subscriber<? super R> subscriber = this.actual;
        subscriber.add(this);
        subscriber.setProducer(new InnerProducer(this));
    }

    static final class InnerProducer implements Producer {
        final DeferredScalarSubscriber<?, ?> parent;

        public InnerProducer(DeferredScalarSubscriber<?, ?> deferredScalarSubscriber) {
            this.parent = deferredScalarSubscriber;
        }

        public final void request(long j) {
            this.parent.downstreamRequest(j);
        }
    }
}
