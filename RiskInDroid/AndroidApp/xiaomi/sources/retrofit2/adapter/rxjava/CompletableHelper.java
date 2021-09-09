package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import rx.Completable;
import rx.Scheduler;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

final class CompletableHelper {
    CompletableHelper() {
    }

    static CallAdapter<Completable> createCallAdapter(Scheduler scheduler) {
        return new CompletableCallAdapter(scheduler);
    }

    static final class CompletableCallOnSubscribe implements Completable.CompletableOnSubscribe {
        private final Call originalCall;

        CompletableCallOnSubscribe(Call call) {
            this.originalCall = call;
        }

        public final void call(Completable.CompletableSubscriber completableSubscriber) {
            final Call clone = this.originalCall.clone();
            Subscription create = Subscriptions.create(new Action0() {
                /* class retrofit2.adapter.rxjava.CompletableHelper.CompletableCallOnSubscribe.AnonymousClass1 */

                public void call() {
                    clone.cancel();
                }
            });
            completableSubscriber.onSubscribe(create);
            try {
                Response execute = clone.execute();
                if (create.isUnsubscribed()) {
                    return;
                }
                if (execute.isSuccessful()) {
                    completableSubscriber.onCompleted();
                } else {
                    completableSubscriber.onError(new HttpException(execute));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!create.isUnsubscribed()) {
                    completableSubscriber.onError(th);
                }
            }
        }
    }

    static class CompletableCallAdapter implements CallAdapter<Completable> {
        private final Scheduler scheduler;

        CompletableCallAdapter(Scheduler scheduler2) {
            this.scheduler = scheduler2;
        }

        public Type responseType() {
            return Void.class;
        }

        public Completable adapt(Call call) {
            Completable create = Completable.create((Completable.CompletableOnSubscribe) new CompletableCallOnSubscribe(call));
            Scheduler scheduler2 = this.scheduler;
            return scheduler2 != null ? create.subscribeOn(scheduler2) : create;
        }
    }
}
