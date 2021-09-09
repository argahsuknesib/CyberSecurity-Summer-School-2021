package com.mibi.sdk.task;

import _m_j.chi;
import android.content.Context;
import com.mibi.sdk.task.handler.ExceptionDispatcher;

public abstract class RxBaseErrorHandleTaskListener<R> implements chi<R> {
    private Context mContext;
    private RxBaseErrorHandler mErrorHandler = new RxBaseErrorHandler(this.mContext) {
        /* class com.mibi.sdk.task.RxBaseErrorHandleTaskListener.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public void handleError(int i, String str, Throwable th) {
            RxBaseErrorHandleTaskListener.this.handleError(i, str, th);
        }
    };
    private RxBaseSuccessHandler<R> mSuccessHandler = new RxBaseSuccessHandler<R>() {
        /* class com.mibi.sdk.task.RxBaseErrorHandleTaskListener.AnonymousClass2 */

        /* access modifiers changed from: protected */
        public void handleSuccess(R r) {
            RxBaseErrorHandleTaskListener.this.handleSuccess(r);
        }
    };

    /* access modifiers changed from: protected */
    public void handleError(int i, String str, Throwable th) {
    }

    /* access modifiers changed from: protected */
    public void handleSuccess(R r) {
    }

    public RxBaseErrorHandleTaskListener(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void onError(Throwable th) {
        this.mErrorHandler.call(th);
    }

    public void onSuccess(R r) {
        this.mSuccessHandler.call(r);
    }

    public ExceptionDispatcher getDispatcher() {
        return this.mErrorHandler.getDispathcher();
    }
}
