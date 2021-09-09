package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    final T initialValue;
    final Flowable<T> source;

    public BlockingFlowableMostRecent(Flowable<T> flowable, T t) {
        this.source = flowable;
        this.initialValue = t;
    }

    public final Iterator<T> iterator() {
        MostRecentSubscriber mostRecentSubscriber = new MostRecentSubscriber(this.initialValue);
        this.source.subscribe((FlowableSubscriber) mostRecentSubscriber);
        return mostRecentSubscriber.getIterable();
    }

    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        volatile Object value;

        MostRecentSubscriber(T t) {
            this.value = NotificationLite.next(t);
        }

        public final void onComplete() {
            this.value = NotificationLite.complete();
        }

        public final void onError(Throwable th) {
            this.value = NotificationLite.error(th);
        }

        public final void onNext(T t) {
            this.value = NotificationLite.next(t);
        }

        public final MostRecentSubscriber<T>.Iterator getIterable() {
            return new Iterator();
        }

        final class Iterator implements java.util.Iterator<T> {
            private Object buf;

            Iterator() {
            }

            public final boolean hasNext() {
                this.buf = MostRecentSubscriber.this.value;
                return !NotificationLite.isComplete(this.buf);
            }

            public final T next() {
                Object obj = null;
                try {
                    if (this.buf == null) {
                        obj = MostRecentSubscriber.this.value;
                    }
                    if (NotificationLite.isComplete(this.buf)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.isError(this.buf)) {
                        T value = NotificationLite.getValue(this.buf);
                        this.buf = obj;
                        return value;
                    } else {
                        throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));
                    }
                } finally {
                    this.buf = obj;
                }
            }

            public final void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }
    }
}
