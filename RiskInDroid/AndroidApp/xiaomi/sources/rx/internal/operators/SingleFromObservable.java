package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public final class SingleFromObservable<T> implements Single.OnSubscribe<T> {
    final Observable.OnSubscribe<T> source;

    public SingleFromObservable(Observable.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    public final void call(SingleSubscriber<? super T> singleSubscriber) {
        WrapSingleIntoSubscriber wrapSingleIntoSubscriber = new WrapSingleIntoSubscriber(singleSubscriber);
        singleSubscriber.add(wrapSingleIntoSubscriber);
        this.source.call(wrapSingleIntoSubscriber);
    }

    static final class WrapSingleIntoSubscriber<T> extends Subscriber<T> {
        final SingleSubscriber<? super T> actual;
        int state;
        T value;

        WrapSingleIntoSubscriber(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
        }

        public final void onNext(T t) {
            int i = this.state;
            if (i == 0) {
                this.state = 1;
                this.value = t;
            } else if (i == 1) {
                this.state = 2;
                this.actual.onError(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }

        public final void onError(Throwable th) {
            if (this.state == 2) {
                RxJavaHooks.onError(th);
                return;
            }
            this.value = null;
            this.actual.onError(th);
        }

        public final void onCompleted() {
            int i = this.state;
            if (i == 0) {
                this.actual.onError(new NoSuchElementException());
            } else if (i == 1) {
                this.state = 2;
                T t = this.value;
                this.value = null;
                this.actual.onSuccess(t);
            }
        }
    }
}
