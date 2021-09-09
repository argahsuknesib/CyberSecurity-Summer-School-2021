package com.mibi.sdk.task.handler;

import android.content.Context;
import android.os.Bundle;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.exception.ServerException;
import com.mibi.sdk.task.handler.ExceptionDispatcher;
import com.xiaomi.smarthome.R;

public class ServiceExceptionHandler implements ExceptionDispatcher.ExceptionHandler {
    private Context mContext;

    public ServiceExceptionHandler(Context context) {
        this.mContext = context;
    }

    public Class<? extends PaymentException> registeredException() {
        return ServerException.class;
    }

    public boolean handle(Throwable th, Bundle bundle, ExceptionDispatcher exceptionDispatcher) {
        if (th instanceof ServerException) {
            if (!bundle.containsKey("errcode")) {
                bundle.putInt("errcode", 6);
            }
            String str = this.mContext.getString(R.string.mibi_error_server_summary) + ((ServerException) th).getResponseCode();
            if (!bundle.containsKey("errDesc")) {
                bundle.putString("errDesc", str);
            }
            return exceptionDispatcher.dispatchAs(th, bundle, PaymentException.class);
        }
        throw new IllegalStateException();
    }
}
