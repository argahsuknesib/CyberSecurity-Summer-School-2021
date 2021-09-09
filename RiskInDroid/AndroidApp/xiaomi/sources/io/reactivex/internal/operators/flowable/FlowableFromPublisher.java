package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFromPublisher<T> extends Flowable<T> {
    final Publisher<? extends T> publisher;

    public FlowableFromPublisher(Publisher<? extends T> publisher2) {
        this.publisher = publisher2;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        this.publisher.subscribe(subscriber);
    }
}
