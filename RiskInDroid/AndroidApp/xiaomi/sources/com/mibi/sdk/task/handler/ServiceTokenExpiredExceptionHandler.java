package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ServiceTokenExpiredException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;
import com.xiaomi.smarthome.R;

public class ServiceTokenExpiredExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    public ServiceTokenExpiredExceptionHandler(Context context) {
        this.mContext = context;
    }

    public Class<? extends PaymentException> registeredException() {
        return ServiceTokenExpiredException.class;
    }

    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (!bundle.containsKey("errcode")) {
            bundle.putInt("errcode", 6);
        }
        if (!bundle.containsKey("errDesc")) {
            bundle.putString("errDesc", this.mContext.getString(R.string.mibi_error_server_summary));
        }
        return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
    }
}
