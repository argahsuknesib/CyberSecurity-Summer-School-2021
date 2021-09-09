package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public final class BlockingOperatorToFuture {
    private BlockingOperatorToFuture() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Future<T> toFuture(Observable<? extends T> observable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final Subscription subscribe = observable.single().subscribe((Subscriber) new Subscriber<T>() {
            /* class rx.internal.operators.BlockingOperatorToFuture.AnonymousClass1 */

            public final void onCompleted() {
                countDownLatch.countDown();
            }

            public final void onError(Throwable th) {
                atomicReference2.compareAndSet(null, th);
                countDownLatch.countDown();
            }

            public final void onNext(T t) {
                atomicReference.set(t);
            }
        });
        return new Future<T>() {
            /* class rx.internal.operators.BlockingOperatorToFuture.AnonymousClass2 */
            private volatile boolean cancelled;

            public final boolean cancel(boolean z) {
                if (countDownLatch.getCount() <= 0) {
                    return false;
                }
                this.cancelled = true;
                subscribe.unsubscribe();
                countDownLatch.countDown();
                return true;
            }

            public final boolean isCancelled() {
                return this.cancelled;
            }

            public final boolean isDone() {
                return countDownLatch.getCount() == 0;
            }

            public final T get() throws InterruptedException, ExecutionException {
                countDownLatch.await();
                return getValue();
            }

            public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                if (countDownLatch.await(j, timeUnit)) {
                    return getValue();
                }
                throw new TimeoutException("Timed out after " + timeUnit.toMillis(j) + "ms waiting for underlying Observable.");
            }

            private T getValue() throws ExecutionException {
                Throwable th = (Throwable) atomicReference2.get();
                if (th != null) {
                    throw new ExecutionException("Observable onError", th);
                } else if (!this.cancelled) {
                    return atomicReference.get();
                } else {
                    throw new CancellationException("Subscription unsubscribed");
                }
            }
        };
    }
}
