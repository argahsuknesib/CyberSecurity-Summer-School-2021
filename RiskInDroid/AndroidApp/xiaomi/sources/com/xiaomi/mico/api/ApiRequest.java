package com.xiaomi.mico.api;

import com.xiaomi.mico.api.logger.ApiLogger;
import com.xiaomi.mico.api.model.MinaResponse;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

public class ApiRequest<T> {
    public final ApiLogger mApiLogger;
    public final ApiResponseHandler mApiResponseHandler;
    public volatile boolean mCanceled;
    public final Listener<T> mListener;
    private Observable<Response<MinaResponse<T>>> mObservable;
    public int mRetryTimes = 0;
    public boolean mRetrying = false;
    private Subscription mSubscription;

    public interface ICleanQueue {
        void bindToLifecycle(ApiRequest apiRequest);
    }

    public interface Listener<T> {
        void onFailure(ApiError apiError);

        void onSuccess(Object obj);
    }

    public final ApiRequest bindToLifecycle(ICleanQueue iCleanQueue) {
        if (iCleanQueue != null) {
            iCleanQueue.bindToLifecycle(this);
        }
        return this;
    }

    ApiRequest(ApiLogger apiLogger, ApiResponseHandler apiResponseHandler, Listener<T> listener) {
        this.mApiLogger = apiLogger;
        this.mApiResponseHandler = apiResponseHandler;
        this.mListener = listener;
    }

    /* access modifiers changed from: package-private */
    public void setObservable(Observable<Response<MinaResponse<T>>> observable) {
        if (this.mObservable == null) {
            this.mObservable = observable;
            return;
        }
        throw new IllegalStateException("ApiRequest already has an observable.");
    }

    public synchronized void cancel() {
        if (!this.mCanceled) {
            this.mCanceled = true;
            if (this.mSubscription != null && !this.mSubscription.isUnsubscribed()) {
                this.mSubscription.unsubscribe();
                this.mSubscription = null;
            }
            if (this.mRetrying) {
                this.mRetryTimes = 0;
                this.mRetrying = false;
                this.mApiResponseHandler.cancel(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isCanceled() {
        return this.mCanceled;
    }

    /* access modifiers changed from: package-private */
    public synchronized void subscribe() {
        if (this.mObservable == null) {
            throw new IllegalStateException("ApiRequest has not an observable.");
        } else if (!this.mCanceled) {
            this.mSubscription = this.mObservable.observeOn(this.mApiResponseHandler.getScheduler()).filter(new Func1<Response<MinaResponse<T>>, Boolean>() {
                /* class com.xiaomi.mico.api.ApiRequest.AnonymousClass3 */

                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
                    if (r4.code() != 401) goto L_0x0044;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
                    if (r3.this$0.mRetryTimes < 2) goto L_0x0025;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
                    r3.this$0.error(com.xiaomi.mico.api.ApiError.TOKEN_INVALID);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
                    r4 = r3.this$0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
                    monitor-enter(r4);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
                    r3.this$0.mRetryTimes++;
                    r3.this$0.mRetrying = true;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
                    monitor-exit(r4);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
                    r3.this$0.mApiResponseHandler.retry(r3.this$0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x0040, code lost:
                    return java.lang.Boolean.FALSE;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
                    r4 = r3.this$0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:27:0x0046, code lost:
                    monitor-enter(r4);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
                    r3.this$0.mRetryTimes = 0;
                    r3.this$0.mRetrying = false;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
                    monitor-exit(r4);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:32:0x0053, code lost:
                    return java.lang.Boolean.TRUE;
                 */
                public Boolean call(Response<MinaResponse<T>> response) {
                    synchronized (ApiRequest.this) {
                        if (ApiRequest.this.mCanceled) {
                            Boolean bool = Boolean.FALSE;
                            return bool;
                        }
                    }
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Response<MinaResponse<T>>>() {
                /* class com.xiaomi.mico.api.ApiRequest.AnonymousClass1 */

                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
                    if (r5.isSuccessful() == false) goto L_0x0042;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
                    r0 = r5.body();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
                    if (r0.code != 0) goto L_0x0032;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
                    r4.this$0.mListener.onSuccess(r5.body().data);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
                    r4.this$0.mListener.onFailure(com.xiaomi.mico.api.ApiError.generateError(r0.code, r0.message));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
                    r5 = r5.code();
                    r4.this$0.mApiLogger.w("Api request http code %s", java.lang.Integer.valueOf(r5));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
                    if (r5 < 400) goto L_0x006b;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
                    if (r5 >= 500) goto L_0x006b;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
                    r4.this$0.mListener.onFailure(com.xiaomi.mico.api.ApiError.HTTP_CODE_4XX);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
                    if (r5 < 500) goto L_0x0077;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
                    r4.this$0.mListener.onFailure(com.xiaomi.mico.api.ApiError.HTTP_CODE_5XX);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:25:0x0076, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
                    r4.this$0.mListener.onFailure(com.xiaomi.mico.api.ApiError.HTTP_CODE_OTHER);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
                    if (r4.this$0.mListener == null) goto L_?;
                 */
                public void call(Response<MinaResponse<T>> response) {
                    synchronized (ApiRequest.this) {
                        if (ApiRequest.this.mCanceled) {
                        }
                    }
                }
            }, new Action1<Throwable>() {
                /* class com.xiaomi.mico.api.ApiRequest.AnonymousClass2 */

                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
                    if (r3.this$0.mListener == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
                    if ((r4 instanceof java.net.SocketTimeoutException) == false) goto L_0x0034;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
                    r3.this$0.mListener.onFailure(com.xiaomi.mico.api.ApiError.HTTP_TIMEOUT);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
                    r3.this$0.mListener.onFailure(com.xiaomi.mico.api.ApiError.HTTP_ENGINE_EXCEPTION);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
                    r3.this$0.mApiLogger.e(r4.toString());
                 */
                public void call(Throwable th) {
                    synchronized (ApiRequest.this) {
                        if (!ApiRequest.this.mCanceled) {
                            ApiRequest.this.mRetryTimes = 0;
                            ApiRequest.this.mRetrying = false;
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        rx.Observable.just(r2).observeOn(rx.android.schedulers.AndroidSchedulers.mainThread()).subscribe(new com.xiaomi.mico.api.ApiRequest.AnonymousClass4(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        if (r1.mListener == null) goto L_?;
     */
    public void error(ApiError apiError) {
        synchronized (this) {
            if (!this.mCanceled) {
                this.mRetryTimes = 0;
                this.mRetrying = false;
            }
        }
    }
}
