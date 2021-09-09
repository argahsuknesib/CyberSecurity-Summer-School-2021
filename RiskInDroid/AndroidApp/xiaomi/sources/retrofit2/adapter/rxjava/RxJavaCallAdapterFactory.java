package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class RxJavaCallAdapterFactory extends CallAdapter.Factory {
    private final Scheduler scheduler;

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory(null);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(Scheduler scheduler2) {
        if (scheduler2 != null) {
            return new RxJavaCallAdapterFactory(scheduler2);
        }
        throw new NullPointerException("scheduler == null");
    }

    private RxJavaCallAdapterFactory(Scheduler scheduler2) {
        this.scheduler = scheduler2;
    }

    public final CallAdapter<?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Class<?> rawType = getRawType(type);
        String canonicalName = rawType.getCanonicalName();
        boolean equals = "rx.Single".equals(canonicalName);
        boolean equals2 = "rx.Completable".equals(canonicalName);
        if (rawType != Observable.class && !equals && !equals2) {
            return null;
        }
        if (!equals2 && !(type instanceof ParameterizedType)) {
            String str = equals ? "Single" : "Observable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        } else if (equals2) {
            return CompletableHelper.createCallAdapter(this.scheduler);
        } else {
            CallAdapter<Observable<?>> callAdapter = getCallAdapter(type, this.scheduler);
            return equals ? SingleHelper.makeSingle(callAdapter) : callAdapter;
        }
    }

    private CallAdapter<Observable<?>> getCallAdapter(Type type, Scheduler scheduler2) {
        Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType = getRawType(parameterUpperBound);
        if (rawType == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(getParameterUpperBound(0, (ParameterizedType) parameterUpperBound), scheduler2);
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        } else if (rawType != Result.class) {
            return new SimpleCallAdapter(parameterUpperBound, scheduler2);
        } else {
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResultCallAdapter(getParameterUpperBound(0, (ParameterizedType) parameterUpperBound), scheduler2);
            }
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
    }

    static final class CallOnSubscribe<T> implements Observable.OnSubscribe<Response<T>> {
        private final Call<T> originalCall;

        CallOnSubscribe(Call<T> call) {
            this.originalCall = call;
        }

        public final void call(Subscriber<? super Response<T>> subscriber) {
            RequestArbiter requestArbiter = new RequestArbiter(this.originalCall.clone(), subscriber);
            subscriber.add(requestArbiter);
            subscriber.setProducer(requestArbiter);
        }
    }

    static final class RequestArbiter<T> extends AtomicBoolean implements Producer, Subscription {
        private final Call<T> call;
        private final Subscriber<? super Response<T>> subscriber;

        RequestArbiter(Call<T> call2, Subscriber<? super Response<T>> subscriber2) {
            this.call = call2;
            this.subscriber = subscriber2;
        }

        public final void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n < 0: ".concat(String.valueOf(j)));
            } else if (j != 0 && compareAndSet(false, true)) {
                try {
                    Response<T> execute = this.call.execute();
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onNext(execute);
                    }
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onCompleted();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onError(th);
                    }
                }
            }
        }

        public final void unsubscribe() {
            this.call.cancel();
        }

        public final boolean isUnsubscribed() {
            return this.call.isCanceled();
        }
    }

    static final class ResponseCallAdapter implements CallAdapter<Observable<?>> {
        private final Type responseType;
        private final Scheduler scheduler;

        ResponseCallAdapter(Type type, Scheduler scheduler2) {
            this.responseType = type;
            this.scheduler = scheduler2;
        }

        public final Type responseType() {
            return this.responseType;
        }

        public final <R> Observable<Response<R>> adapt(Call<R> call) {
            Observable<Response<R>> create = Observable.create(new CallOnSubscribe(call));
            Scheduler scheduler2 = this.scheduler;
            return scheduler2 != null ? create.subscribeOn(scheduler2) : create;
        }
    }

    static final class SimpleCallAdapter implements CallAdapter<Observable<?>> {
        private final Type responseType;
        private final Scheduler scheduler;

        SimpleCallAdapter(Type type, Scheduler scheduler2) {
            this.responseType = type;
            this.scheduler = scheduler2;
        }

        public final Type responseType() {
            return this.responseType;
        }

        public final <R> Observable<R> adapt(Call<R> call) {
            Observable<R> lift = Observable.create(new CallOnSubscribe(call)).lift(OperatorMapResponseToBodyOrError.instance());
            Scheduler scheduler2 = this.scheduler;
            return scheduler2 != null ? lift.subscribeOn(scheduler2) : lift;
        }
    }

    static final class ResultCallAdapter implements CallAdapter<Observable<?>> {
        private final Type responseType;
        private final Scheduler scheduler;

        ResultCallAdapter(Type type, Scheduler scheduler2) {
            this.responseType = type;
            this.scheduler = scheduler2;
        }

        public final Type responseType() {
            return this.responseType;
        }

        public final <R> Observable<Result<R>> adapt(Call<R> call) {
            Observable<Result<R>> onErrorReturn = Observable.create(new CallOnSubscribe(call)).map(new Func1<Response<R>, Result<R>>() {
                /* class retrofit2.adapter.rxjava.RxJavaCallAdapterFactory.ResultCallAdapter.AnonymousClass2 */

                public Result<R> call(Response<R> response) {
                    return Result.response(response);
                }
            }).onErrorReturn(new Func1<Throwable, Result<R>>() {
                /* class retrofit2.adapter.rxjava.RxJavaCallAdapterFactory.ResultCallAdapter.AnonymousClass1 */

                public Result<R> call(Throwable th) {
                    return Result.error(th);
                }
            });
            Scheduler scheduler2 = this.scheduler;
            return scheduler2 != null ? onErrorReturn.subscribeOn(scheduler2) : onErrorReturn;
        }
    }
}
