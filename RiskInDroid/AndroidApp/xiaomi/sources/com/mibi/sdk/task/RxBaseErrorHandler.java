package com.mibi.sdk.task;

import android.content.Context;
import com.mibi.sdk.task.handler.AccountChangedExceptionHandler;
import com.mibi.sdk.task.handler.AccountExceptionHandler;
import com.mibi.sdk.task.handler.AccountThrottingExceptionHandler;
import com.mibi.sdk.task.handler.CertificateDateNotValidExceptionHandler;
import com.mibi.sdk.task.handler.ConnectionExceptionHandler;
import com.mibi.sdk.task.handler.ExceptionDispatcher;
import com.mibi.sdk.task.handler.IllegalDeviceExceptionHandler;
import com.mibi.sdk.task.handler.NetworkExceptionHandler;
import com.mibi.sdk.task.handler.NotConnectedExceptionHandler;
import com.mibi.sdk.task.handler.PasswordErrorExceptionHandler;
import com.mibi.sdk.task.handler.PaymentExceptionHandler;
import com.mibi.sdk.task.handler.ResultExceptionHandler;
import com.mibi.sdk.task.handler.ServerErrorCodeExceptionHandler;
import com.mibi.sdk.task.handler.ServiceExceptionHandler;
import com.mibi.sdk.task.handler.ServiceTokenExpiredExceptionHandler;

public abstract class RxBaseErrorHandler {
    private Context mContext;
    private ExceptionDispatcher mDispatcher = new ExceptionDispatcher();

    /* access modifiers changed from: protected */
    public abstract void handleError(int i, String str, Throwable th);

    public RxBaseErrorHandler(Context context) {
        this.mContext = context;
        this.mDispatcher.register(new AccountChangedExceptionHandler(this.mContext)).register(new AccountThrottingExceptionHandler(this.mContext)).register(new AccountExceptionHandler(this.mContext)).register(new CertificateDateNotValidExceptionHandler(this.mContext)).register(new ConnectionExceptionHandler()).register(new NotConnectedExceptionHandler(this.mContext)).register(new NetworkExceptionHandler(this.mContext)).register(new IllegalDeviceExceptionHandler(this.mContext)).register(new PasswordErrorExceptionHandler(this.mContext)).register(new ResultExceptionHandler(this.mContext)).register(new ServiceExceptionHandler(this.mContext)).register(new ServiceTokenExpiredExceptionHandler(this.mContext)).register(new ServerErrorCodeExceptionHandler(this.mContext)).register(new PaymentExceptionHandler(this.mContext) {
            /* class com.mibi.sdk.task.RxBaseErrorHandler.AnonymousClass1 */

            public void handleError(int i, String str, Throwable th) {
                RxBaseErrorHandler.this.handleError(i, str, th);
            }
        });
    }

    public void call(Throwable th) {
        try {
            if (!this.mDispatcher.dispatch(th)) {
                throw new IllegalStateException("error not handled", th);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("exception occurs in onError", e);
        }
    }

    public ExceptionDispatcher getDispathcher() {
        return this.mDispatcher;
    }
}
