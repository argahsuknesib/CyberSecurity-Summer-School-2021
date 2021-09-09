package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public final class SingleTakeUntilObservable<T, U> implements Single.OnSubscribe<T> {
    final Observable<? extends U> other;
    final Single.OnSubscribe<T> source;

    public SingleTakeUntilObservable(Single.OnSubscribe<T> onSubscribe, Observable<? extends U> observable) {
        this.source = onSubscribe;
        this.other = observable;
    }

    public final void call(SingleSubscriber<? super T> singleSubscriber) {
        TakeUntilSourceSubscriber takeUntilSourceSubscriber = new TakeUntilSourceSubscriber(singleSubscriber);
        singleSubscriber.add(takeUntilSourceSubscriber);
        this.other.subscribe((Subscriber) takeUntilSourceSubscriber.other);
        this.source.call(takeUntilSourceSubscriber);
    }

    static final class TakeUntilSourceSubscriber<T, U> extends SingleSubscriber<T> {
        final SingleSubscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final Subscriber<U> other = new OtherSubscriber();

        TakeUntilSourceSubscriber(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
            add(this.other);
        }

        public final void onSuccess(T t) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                unsubscribe();
                this.actual.onError(th);
                return;
            }
            RxJavaHooks.onError(th);
        }

        final class OtherSubscriber extends Subscriber<U> {
            OtherSubscriber() {
            }

            public final void onNext(U u) {
                onCompleted();
            }

            public final void onError(Throwable th) {
                TakeUntilSourceSubscriber.this.onError(th);
            }

            public final void onCompleted() {
                onError(new CancellationException("Single::takeUntil(Observable) - Stream was canceled before emitting a terminal event."));
            }
        }
    }
}
