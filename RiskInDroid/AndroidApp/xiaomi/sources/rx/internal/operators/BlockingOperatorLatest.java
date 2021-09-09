package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorLatest {
    private BlockingOperatorLatest() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> latest(final Observable<? extends T> observable) {
        return new Iterable<T>() {
            /* class rx.internal.operators.BlockingOperatorLatest.AnonymousClass1 */

            public final Iterator<T> iterator() {
                LatestObserverIterator latestObserverIterator = new LatestObserverIterator();
                observable.materialize().subscribe((Subscriber) latestObserverIterator);
                return latestObserverIterator;
            }
        };
    }

    static final class LatestObserverIterator<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {
        Notification<? extends T> iteratorNotification;
        final Semaphore notify = new Semaphore(0);
        final AtomicReference<Notification<? extends T>> value = new AtomicReference<>();

        public final void onCompleted() {
        }

        public final void onError(Throwable th) {
        }

        LatestObserverIterator() {
        }

        public final void onNext(Notification<? extends T> notification) {
            if (this.value.getAndSet(notification) == null) {
                this.notify.release();
            }
        }

        public final boolean hasNext() {
            Notification<? extends T> notification = this.iteratorNotification;
            if (notification == null || !notification.isOnError()) {
                Notification<? extends T> notification2 = this.iteratorNotification;
                if ((notification2 == null || !notification2.isOnCompleted()) && this.iteratorNotification == null) {
                    try {
                        this.notify.acquire();
                        this.iteratorNotification = this.value.getAndSet(null);
                        if (this.iteratorNotification.isOnError()) {
                            throw Exceptions.propagate(this.iteratorNotification.getThrowable());
                        }
                    } catch (InterruptedException e) {
                        unsubscribe();
                        Thread.currentThread().interrupt();
                        this.iteratorNotification = Notification.createOnError(e);
                        throw Exceptions.propagate(e);
                    }
                }
                return !this.iteratorNotification.isOnCompleted();
            }
            throw Exceptions.propagate(this.iteratorNotification.getThrowable());
        }

        public final T next() {
            if (!hasNext() || !this.iteratorNotification.isOnNext()) {
                throw new NoSuchElementException();
            }
            T value2 = this.iteratorNotification.getValue();
            this.iteratorNotification = null;
            return value2;
        }

        public final void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }
}
