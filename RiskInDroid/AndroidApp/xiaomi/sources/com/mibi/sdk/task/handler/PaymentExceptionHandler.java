package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;
import com.xiaomi.smarthome.R;

public abstract class PaymentExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    protected Context mContext;

    /* access modifiers changed from: protected */
    public abstract void handleError(int i, String str, Throwable th);

    public PaymentExceptionHandler(Context context) {
        this.mContext = context;
    }

    public Class<? extends Throwable> registeredException() {
        return PaymentException.class;
    }

    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!bundle.containsKey("errcode")) {
            bundle.putInt("errcode", 5);
        }
        if (!bundle.containsKey("errDesc")) {
            bundle.putString("errDesc", this.mContext.getString(R.string.mibi_error_auth_summary));
        }
        int i = bundle.getInt("errcode");
        handleError(i, bundle.getString("errDesc") + "[" + ((PaymentException) th).getFullIdentifier() + "]", th);
        return true;
    }
}
