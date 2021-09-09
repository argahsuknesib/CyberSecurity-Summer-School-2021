package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.CallAdapter;

final class ExecutorCallAdapterFactory extends CallAdapter.Factory {
    final Executor callbackExecutor;

    ExecutorCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    public final CallAdapter<Call<?>> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != Call.class) {
            return null;
        }
        final Type callResponseType = Utils.getCallResponseType(type);
        return new CallAdapter<Call<?>>() {
            /* class retrofit2.ExecutorCallAdapterFactory.AnonymousClass1 */

            public Type responseType() {
                return callResponseType;
            }

            public <R> Call<R> adapt(Call<R> call) {
                return new ExecutorCallbackCall(ExecutorCallAdapterFactory.this.callbackExecutor, call);
            }
        };
    }

    static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        public final void enqueue(final Callback<T> callback) {
            if (callback != null) {
                this.delegate.enqueue(new Callback<T>() {
                    /* class retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 */

                    public void onResponse(Call<T> call, final Response<T> response) {
                        ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() {
                            /* class retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                                    callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                                } else {
                                    callback.onResponse(ExecutorCallbackCall.this, response);
                                }
                            }
                        });
                    }

                    public void onFailure(Call<T> call, final Throwable th) {
                        ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable() {
                            /* class retrofit2.ExecutorCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.AnonymousClass2 */

                            public void run() {
                                callback.onFailure(ExecutorCallbackCall.this, th);
                            }
                        });
                    }
                });
                return;
            }
            throw new NullPointerException("callback == null");
        }

        public final boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        public final Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        public final void cancel() {
            this.delegate.cancel();
        }

        public final boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        public final Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        public final Request request() {
            return this.delegate.request();
        }
    }
}
