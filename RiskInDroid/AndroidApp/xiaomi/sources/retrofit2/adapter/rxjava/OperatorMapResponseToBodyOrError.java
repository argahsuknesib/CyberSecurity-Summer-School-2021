package retrofit2.adapter.rxjava;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

final class OperatorMapResponseToBodyOrError<T> implements Observable.Operator<T, Response<T>> {
    private static final OperatorMapResponseToBodyOrError<Object> INSTANCE = new OperatorMapResponseToBodyOrError<>();

    OperatorMapResponseToBodyOrError() {
    }

    static <R> OperatorMapResponseToBodyOrError<R> instance() {
        return INSTANCE;
    }

    public final Subscriber<? super Response<T>> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<Response<T>>(subscriber) {
            /* class retrofit2.adapter.rxjava.OperatorMapResponseToBodyOrError.AnonymousClass1 */

            public void onNext(Response<T> response) {
                if (response.isSuccessful()) {
                    subscriber.onNext(response.body());
                } else {
                    subscriber.onError(new HttpException(response));
                }
            }

            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th) {
                subscriber.onError(th);
            }
        };
    }
}
