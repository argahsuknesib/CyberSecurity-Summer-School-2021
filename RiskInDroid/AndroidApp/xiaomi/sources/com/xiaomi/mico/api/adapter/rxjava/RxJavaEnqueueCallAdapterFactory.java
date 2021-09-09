package com.xiaomi.mico.api.adapter.rxjava;

import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;

public class RxJavaEnqueueCallAdapterFactory extends CallAdapter.Factory {
    private Scheduler mScheduler;

    public static RxJavaEnqueueCallAdapterFactory create() {
        return new RxJavaEnqueueCallAdapterFactory(null);
    }

    public static RxJavaEnqueueCallAdapterFactory createWithScheduler(Scheduler scheduler) {
        return new RxJavaEnqueueCallAdapterFactory(scheduler);
    }

    private RxJavaEnqueueCallAdapterFactory(Scheduler scheduler) {
        this.mScheduler = scheduler;
    }

    public CallAdapter<?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != Observable.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
            if (getRawType(parameterUpperBound) == Response.class) {
                if (parameterUpperBound instanceof ParameterizedType) {
                    return new ResponseCallAdapter(getParameterUpperBound(0, (ParameterizedType) parameterUpperBound), this.mScheduler);
                }
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        }
        throw new IllegalStateException("Observable return type must be parameterized as Observable<Response>");
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
        private static final long serialVersionUID = 7982451379763135859L;
        private final Call<T> call;
        public final Subscriber<? super Response<T>> subscriber;

        RequestArbiter(Call<T> call2, Subscriber<? super Response<T>> subscriber2) {
            this.call = call2;
            this.subscriber = subscriber2;
        }

        public final void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n < 0: ".concat(String.valueOf(j)));
            } else if (j != 0 && compareAndSet(false, true)) {
                try {
                    if (TextUtils.isEmpty(this.call.request().header("sync"))) {
                        this.call.enqueue(new Callback<T>() {
                            /* class com.xiaomi.mico.api.adapter.rxjava.RxJavaEnqueueCallAdapterFactory.RequestArbiter.AnonymousClass1 */

                            public void onResponse(Call<T> call, Response<T> response) {
                                if (!RequestArbiter.this.subscriber.isUnsubscribed()) {
                                    try {
                                        RequestArbiter.this.subscriber.onNext(response);
                                        if (!RequestArbiter.this.subscriber.isUnsubscribed()) {
                                            RequestArbiter.this.subscriber.onCompleted();
                                        }
                                    } catch (Throwable th) {
                                        RequestArbiter.this.onError(th);
                                    }
                                }
                            }

                            public void onFailure(Call<T> call, Throwable th) {
                                RequestArbiter.this.onError(th);
                            }
                        });
                        return;
                    }
                    Response<T> execute = this.call.execute();
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onNext(execute);
                        if (!this.subscriber.isUnsubscribed()) {
                            this.subscriber.onCompleted();
                        }
                    }
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            Exceptions.throwIfFatal(th);
            if (!this.subscriber.isUnsubscribed()) {
                this.subscriber.onError(th);
            }
        }

        public final void unsubscribe() {
            this.call.cancel();
        }

        public final boolean isUnsubscribed() {
            return this.call.isCanceled();
        }
    }
}
